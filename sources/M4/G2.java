package M4;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g2 extends Thread {
    public final Object a;
    public final BlockingQueue c;
    public boolean d = false;
    public final /* synthetic */ i2 e;

    public g2(i2 i2Var, String str, BlockingQueue blockingQueue) {
        this.e = i2Var;
        com.google.android.gms.common.internal.r.m(str);
        com.google.android.gms.common.internal.r.m(blockingQueue);
        this.a = new Object();
        this.c = blockingQueue;
        setName(str);
    }

    public final void a() {
        synchronized (this.a) {
            this.a.notifyAll();
        }
    }

    public final void b() {
        synchronized (i2.q(this.e)) {
            try {
                if (!this.d) {
                    i2.u(this.e).release();
                    i2.q(this.e).notifyAll();
                    i2 i2Var = this.e;
                    if (this == i2.p(i2Var)) {
                        i2.x(i2Var, null);
                    } else if (this == i2.o(i2Var)) {
                        i2.w(i2Var, null);
                    } else {
                        i2Var.a.d().r().a("Current scheduler thread is neither worker nor network");
                    }
                    this.d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(InterruptedException interruptedException) {
        this.e.a.d().w().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                i2.u(this.e).acquire();
                z = true;
            } catch (InterruptedException e) {
                c(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                f2 f2Var = (f2) this.c.poll();
                if (f2Var != null) {
                    Process.setThreadPriority(true != f2Var.c ? 10 : threadPriority);
                    f2Var.run();
                } else {
                    synchronized (this.a) {
                        if (this.c.peek() == null) {
                            i2.B(this.e);
                            try {
                                this.a.wait(30000L);
                            } catch (InterruptedException e2) {
                                c(e2);
                            }
                        }
                    }
                    synchronized (i2.q(this.e)) {
                        if (this.c.peek() == null) {
                            b();
                            b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
