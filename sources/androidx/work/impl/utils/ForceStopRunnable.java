package androidx.work.impl.utils;

import L.a;
import Q0.k;
import Q0.t;
import R0.f;
import R0.h;
import R0.j;
import U0.m;
import Z0.n;
import Z0.p;
import Z0.q;
import a1.c;
import a1.d;
import a1.e;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ForceStopRunnable implements Runnable {
    public static final String e = k.f("ForceStopRunnable");
    public static final long f = TimeUnit.DAYS.toMillis(3650);
    public final Context a;
    public final j c;
    public int d = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        public static final String a = k.f("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            k.c().g(a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
            ForceStopRunnable.g(context);
        }
    }

    public ForceStopRunnable(Context context, j jVar) {
        this.a = context.getApplicationContext();
        this.c = jVar;
    }

    public static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    public static PendingIntent d(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, c(context), i);
    }

    public static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent d = d(context, a.c() ? 167772160 : 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, d);
        }
    }

    public boolean a() {
        boolean i = Build.VERSION.SDK_INT >= 23 ? m.i(this.a, this.c) : false;
        WorkDatabase q = this.c.q();
        q B = q.B();
        n A = q.A();
        q.c();
        try {
            List<p> q2 = B.q();
            boolean z = (q2 == null || q2.isEmpty()) ? false : true;
            if (z) {
                for (p pVar : q2) {
                    B.d(t.ENQUEUED, pVar.a);
                    B.m(pVar.a, -1L);
                }
            }
            A.b();
            q.r();
            q.g();
            return z || i;
        } catch (Throwable th) {
            q.g();
            throw th;
        }
    }

    public void b() {
        boolean a = a();
        if (h()) {
            k.c().a(e, "Rescheduling Workers.", new Throwable[0]);
            this.c.u();
            this.c.n().c(false);
        } else if (e()) {
            k.c().a(e, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.c.u();
        } else if (a) {
            k.c().a(e, "Found unfinished work, scheduling it.", new Throwable[0]);
            f.b(this.c.k(), this.c.q(), this.c.p());
        }
    }

    public boolean e() {
        try {
            PendingIntent d = d(this.a, a.c() ? 570425344 : 536870912);
            if (Build.VERSION.SDK_INT >= 30) {
                if (d != null) {
                    d.cancel();
                }
                List a = c.a((ActivityManager) this.a.getSystemService("activity"), null, 0, 0);
                if (a != null && !a.isEmpty()) {
                    for (int i = 0; i < a.size(); i++) {
                        if (e.a(d.a(a.get(i))) == 10) {
                            return true;
                        }
                    }
                }
            } else if (d == null) {
                g(this.a);
                return true;
            }
            return false;
        } catch (SecurityException e2) {
            e = e2;
            k.c().h(e, "Ignoring exception", e);
            return true;
        } catch (IllegalArgumentException e3) {
            e = e3;
            k.c().h(e, "Ignoring exception", e);
            return true;
        }
    }

    public boolean f() {
        androidx.work.a k = this.c.k();
        if (TextUtils.isEmpty(k.c())) {
            k.c().a(e, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean b = a1.j.b(this.a, k);
        k.c().a(e, String.format("Is default app process = %s", new Object[]{Boolean.valueOf(b)}), new Throwable[0]);
        return b;
    }

    public boolean h() {
        return this.c.n().a();
    }

    public void i(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    public void run() {
        int i;
        try {
            if (!f()) {
                return;
            }
            while (true) {
                h.e(this.a);
                k.c().a(e, "Performing cleanup operations.", new Throwable[0]);
                try {
                    b();
                    return;
                } catch (SQLiteDatabaseCorruptException | SQLiteTableLockedException | SQLiteCantOpenDatabaseException | SQLiteAccessPermException | SQLiteDatabaseLockedException | SQLiteConstraintException e2) {
                    i = this.d + 1;
                    this.d = i;
                    if (i >= 3) {
                        k.c().b(e, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        this.c.k().d();
                        throw illegalStateException;
                    }
                    k.c().a(e, String.format("Retrying after %s", new Object[]{Long.valueOf(i * 300)}), e2);
                    i(this.d * 300);
                }
                k.c().a(e, String.format("Retrying after %s", new Object[]{Long.valueOf(i * 300)}), e2);
                i(this.d * 300);
            }
        } finally {
            this.c.t();
        }
    }
}
