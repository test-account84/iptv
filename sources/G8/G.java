package G8;

import java.util.concurrent.locks.LockSupport;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class g extends a {
    public final Thread d;
    public final h0 e;

    public g(o8.g gVar, Thread thread, h0 h0Var) {
        super(gVar, true, true);
        this.d = thread;
        this.e = h0Var;
    }

    public void D(Object obj) {
        if (kotlin.jvm.internal.l.a(Thread.currentThread(), this.d)) {
            return;
        }
        Thread thread = this.d;
        c.a();
        LockSupport.unpark(thread);
    }

    public final Object O0() {
        c.a();
        try {
            h0 h0Var = this.e;
            if (h0Var != null) {
                h0.l0(h0Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    h0 h0Var2 = this.e;
                    long o0 = h0Var2 != null ? h0Var2.o0() : Long.MAX_VALUE;
                    if (h0()) {
                        h0 h0Var3 = this.e;
                        if (h0Var3 != null) {
                            h0.g0(h0Var3, false, 1, null);
                        }
                        c.a();
                        Object h = F0.h(d0());
                        B b = h instanceof B ? (B) h : null;
                        if (b == null) {
                            return h;
                        }
                        throw b.a;
                    }
                    c.a();
                    LockSupport.parkNanos(this, o0);
                } catch (Throwable th) {
                    h0 h0Var4 = this.e;
                    if (h0Var4 != null) {
                        h0.g0(h0Var4, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            G(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            c.a();
            throw th2;
        }
    }

    public boolean i0() {
        return true;
    }
}
