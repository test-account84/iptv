package M4;

import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i2 extends F2 {
    public static final AtomicLong l = new AtomicLong(Long.MIN_VALUE);
    public g2 c;
    public g2 d;
    public final PriorityBlockingQueue e;
    public final BlockingQueue f;
    public final Thread.UncaughtExceptionHandler g;
    public final Thread.UncaughtExceptionHandler h;
    public final Object i;
    public final Semaphore j;
    public volatile boolean k;

    public i2(l2 l2Var) {
        super(l2Var);
        this.i = new Object();
        this.j = new Semaphore(2);
        this.e = new PriorityBlockingQueue();
        this.f = new LinkedBlockingQueue();
        this.g = new e2(this, "Thread death: Uncaught exception on worker thread");
        this.h = new e2(this, "Thread death: Uncaught exception on network thread");
    }

    public static /* bridge */ /* synthetic */ boolean B(i2 i2Var) {
        boolean z = i2Var.k;
        return false;
    }

    public static /* bridge */ /* synthetic */ g2 o(i2 i2Var) {
        return i2Var.d;
    }

    public static /* bridge */ /* synthetic */ g2 p(i2 i2Var) {
        return i2Var.c;
    }

    public static /* bridge */ /* synthetic */ Object q(i2 i2Var) {
        return i2Var.i;
    }

    public static /* bridge */ /* synthetic */ Semaphore u(i2 i2Var) {
        return i2Var.j;
    }

    public static /* bridge */ /* synthetic */ AtomicLong v() {
        return l;
    }

    public static /* bridge */ /* synthetic */ void w(i2 i2Var, g2 g2Var) {
        i2Var.d = null;
    }

    public static /* bridge */ /* synthetic */ void x(i2 i2Var, g2 g2Var) {
        i2Var.c = null;
    }

    public final void A(Runnable runnable) {
        k();
        com.google.android.gms.common.internal.r.m(runnable);
        D(new f2(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean C() {
        return Thread.currentThread() == this.c;
    }

    public final void D(f2 f2Var) {
        synchronized (this.i) {
            try {
                this.e.add(f2Var);
                g2 g2Var = this.c;
                if (g2Var == null) {
                    g2 g2Var2 = new g2(this, "Measurement Worker", this.e);
                    this.c = g2Var2;
                    g2Var2.setUncaughtExceptionHandler(this.g);
                    this.c.start();
                } else {
                    g2Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        if (Thread.currentThread() != this.d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void h() {
        if (Thread.currentThread() != this.c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final boolean j() {
        return false;
    }

    public final Object r(AtomicReference atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.a.f().z(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                this.a.d().w().a("Interrupted waiting for " + str);
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            this.a.d().w().a("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final Future s(Callable callable) {
        k();
        com.google.android.gms.common.internal.r.m(callable);
        f2 f2Var = new f2(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.c) {
            if (!this.e.isEmpty()) {
                this.a.d().w().a("Callable skipped the worker queue.");
            }
            f2Var.run();
        } else {
            D(f2Var);
        }
        return f2Var;
    }

    public final Future t(Callable callable) {
        k();
        com.google.android.gms.common.internal.r.m(callable);
        f2 f2Var = new f2(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.c) {
            f2Var.run();
        } else {
            D(f2Var);
        }
        return f2Var;
    }

    public final void y(Runnable runnable) {
        k();
        com.google.android.gms.common.internal.r.m(runnable);
        f2 f2Var = new f2(this, runnable, false, "Task exception on network thread");
        synchronized (this.i) {
            try {
                this.f.add(f2Var);
                g2 g2Var = this.d;
                if (g2Var == null) {
                    g2 g2Var2 = new g2(this, "Measurement Network", this.f);
                    this.d = g2Var2;
                    g2Var2.setUncaughtExceptionHandler(this.h);
                    this.d.start();
                } else {
                    g2Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z(Runnable runnable) {
        k();
        com.google.android.gms.common.internal.r.m(runnable);
        D(new f2(this, runnable, false, "Task exception on worker thread"));
    }
}
