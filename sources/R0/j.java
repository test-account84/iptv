package R0;

import Q0.k;
import Q0.n;
import Q0.q;
import Q0.u;
import U0.m;
import a1.l;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j extends u {
    public static final String j = Q0.k.f("WorkManagerImpl");
    public static j k = null;
    public static j l = null;
    public static final Object m = new Object();
    public Context a;
    public androidx.work.a b;
    public WorkDatabase c;
    public c1.a d;
    public List e;
    public d f;
    public a1.h g;
    public boolean h;
    public BroadcastReceiver.PendingResult i;

    public j(Context context, androidx.work.a aVar, c1.a aVar2) {
        this(context, aVar, aVar2, context.getResources().getBoolean(q.a));
    }

    public static void g(Context context, androidx.work.a aVar) {
        synchronized (m) {
            try {
                j jVar = k;
                if (jVar != null && l != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (jVar == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (l == null) {
                        l = new j(applicationContext, aVar, new c1.b(aVar.l()));
                    }
                    k = l;
                }
            } finally {
            }
        }
    }

    public static j l() {
        synchronized (m) {
            try {
                j jVar = k;
                if (jVar != null) {
                    return jVar;
                }
                return l;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static j m(Context context) {
        j l2;
        synchronized (m) {
            try {
                l2 = l();
                if (l2 == null) {
                    context.getApplicationContext();
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return l2;
    }

    public n a(String str) {
        a1.a d = a1.a.d(str, this);
        this.d.b(d);
        return d.e();
    }

    public n c(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new g(this, list).a();
    }

    public n e(String str, Q0.d dVar, List list) {
        return new g(this, str, dVar, list).a();
    }

    public n h(UUID uuid) {
        a1.a b = a1.a.b(uuid, this);
        this.d.b(b);
        return b.e();
    }

    public List i(Context context, androidx.work.a aVar, c1.a aVar2) {
        return Arrays.asList(new e[]{f.a(context, this), new S0.b(context, aVar, aVar2, this)});
    }

    public Context j() {
        return this.a;
    }

    public androidx.work.a k() {
        return this.b;
    }

    public a1.h n() {
        return this.g;
    }

    public d o() {
        return this.f;
    }

    public List p() {
        return this.e;
    }

    public WorkDatabase q() {
        return this.c;
    }

    public c1.a r() {
        return this.d;
    }

    public final void s(Context context, androidx.work.a aVar, c1.a aVar2, WorkDatabase workDatabase, List list, d dVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = aVar;
        this.d = aVar2;
        this.c = workDatabase;
        this.e = list;
        this.f = dVar;
        this.g = new a1.h(workDatabase);
        this.h = false;
        if (Build.VERSION.SDK_INT >= 24 && i.a(applicationContext)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        this.d.b(new ForceStopRunnable(applicationContext, this));
    }

    public void t() {
        synchronized (m) {
            try {
                this.h = true;
                BroadcastReceiver.PendingResult pendingResult = this.i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void u() {
        if (Build.VERSION.SDK_INT >= 23) {
            m.b(j());
        }
        q().B().l();
        f.b(k(), q(), p());
    }

    public void v(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (m) {
            try {
                this.i = pendingResult;
                if (this.h) {
                    pendingResult.finish();
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void w(String str) {
        x(str, null);
    }

    public void x(String str, WorkerParameters.a aVar) {
        this.d.b(new l(this, str, aVar));
    }

    public void y(String str) {
        this.d.b(new a1.m(this, str, true));
    }

    public void z(String str) {
        this.d.b(new a1.m(this, str, false));
    }

    public j(Context context, androidx.work.a aVar, c1.a aVar2, WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        Q0.k.e(new k.a(aVar.j()));
        List i = i(applicationContext, aVar, aVar2);
        s(context, aVar, aVar2, workDatabase, i, new d(context, aVar, aVar2, workDatabase, i));
    }

    public j(Context context, androidx.work.a aVar, c1.a aVar2, boolean z) {
        this(context, aVar, aVar2, WorkDatabase.s(context.getApplicationContext(), aVar2.c(), z));
    }
}
