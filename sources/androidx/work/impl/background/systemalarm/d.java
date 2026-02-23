package androidx.work.impl.background.systemalarm;

import Q0.k;
import R0.j;
import a1.n;
import a1.r;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d implements R0.b {
    public static final String l = k.f("SystemAlarmDispatcher");
    public final Context a;
    public final c1.a c;
    public final r d;
    public final R0.d e;
    public final j f;
    public final androidx.work.impl.background.systemalarm.a g;
    public final Handler h;
    public final List i;
    public Intent j;
    public c k;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            d dVar;
            d dVar2;
            synchronized (d.this.i) {
                d dVar3 = d.this;
                dVar3.j = (Intent) dVar3.i.get(0);
            }
            Intent intent = d.this.j;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = d.this.j.getIntExtra("KEY_START_ID", 0);
                k c = k.c();
                String str = d.l;
                c.a(str, String.format("Processing command %s, %s", new Object[]{d.this.j, Integer.valueOf(intExtra)}), new Throwable[0]);
                PowerManager.WakeLock b = n.b(d.this.a, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                try {
                    k.c().a(str, String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, b}), new Throwable[0]);
                    b.acquire();
                    d dVar4 = d.this;
                    dVar4.g.p(dVar4.j, intExtra, dVar4);
                    k.c().a(str, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, b}), new Throwable[0]);
                    b.release();
                    dVar = d.this;
                    dVar2 = new d(dVar);
                } catch (Throwable th) {
                    try {
                        k c2 = k.c();
                        String str2 = d.l;
                        c2.b(str2, "Unexpected error in onHandleIntent", th);
                        k.c().a(str2, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, b}), new Throwable[0]);
                        b.release();
                        dVar = d.this;
                        dVar2 = new d(dVar);
                    } catch (Throwable th2) {
                        k.c().a(d.l, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, b}), new Throwable[0]);
                        b.release();
                        d dVar5 = d.this;
                        dVar5.k(new d(dVar5));
                        throw th2;
                    }
                }
                dVar.k(dVar2);
            }
        }
    }

    public static class b implements Runnable {
        public final d a;
        public final Intent c;
        public final int d;

        public b(d dVar, Intent intent, int i) {
            this.a = dVar;
            this.c = intent;
            this.d = i;
        }

        public void run() {
            this.a.a(this.c, this.d);
        }
    }

    public interface c {
        void b();
    }

    public static class d implements Runnable {
        public final d a;

        public d(d dVar) {
            this.a = dVar;
        }

        public void run() {
            this.a.c();
        }
    }

    public d(Context context) {
        this(context, null, null);
    }

    public boolean a(Intent intent, int i) {
        k c2 = k.c();
        String str = l;
        c2.a(str, String.format("Adding command %s (%s)", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            k.c().h(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra("KEY_START_ID", i);
        synchronized (this.i) {
            try {
                boolean z = !this.i.isEmpty();
                this.i.add(intent);
                if (!z) {
                    l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public final void b() {
        if (this.h.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public void c() {
        k c2 = k.c();
        String str = l;
        c2.a(str, "Checking if commands are complete.", new Throwable[0]);
        b();
        synchronized (this.i) {
            try {
                if (this.j != null) {
                    k.c().a(str, String.format("Removing command %s", new Object[]{this.j}), new Throwable[0]);
                    if (!((Intent) this.i.remove(0)).equals(this.j)) {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                    this.j = null;
                }
                a1.k c3 = this.c.c();
                if (!this.g.o() && this.i.isEmpty() && !c3.a()) {
                    k.c().a(str, "No more commands & intents.", new Throwable[0]);
                    c cVar = this.k;
                    if (cVar != null) {
                        cVar.b();
                    }
                } else if (!this.i.isEmpty()) {
                    l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(String str, boolean z) {
        k(new b(this, androidx.work.impl.background.systemalarm.a.c(this.a, str, z), 0));
    }

    public R0.d e() {
        return this.e;
    }

    public c1.a f() {
        return this.c;
    }

    public j g() {
        return this.f;
    }

    public r h() {
        return this.d;
    }

    public final boolean i(String str) {
        b();
        synchronized (this.i) {
            try {
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    if (str.equals(((Intent) it.next()).getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j() {
        k.c().a(l, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.e.i(this);
        this.d.a();
        this.k = null;
    }

    public void k(Runnable runnable) {
        this.h.post(runnable);
    }

    public final void l() {
        b();
        PowerManager.WakeLock b2 = n.b(this.a, "ProcessCommand");
        try {
            b2.acquire();
            this.f.r().b(new a());
        } finally {
            b2.release();
        }
    }

    public void m(c cVar) {
        if (this.k != null) {
            k.c().b(l, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.k = cVar;
        }
    }

    public d(Context context, R0.d dVar, j jVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.g = new androidx.work.impl.background.systemalarm.a(applicationContext);
        this.d = new r();
        jVar = jVar == null ? j.m(context) : jVar;
        this.f = jVar;
        dVar = dVar == null ? jVar.o() : dVar;
        this.e = dVar;
        this.c = jVar.r();
        dVar.c(this);
        this.i = new ArrayList();
        this.j = null;
        this.h = new Handler(Looper.getMainLooper());
    }
}
