package h1;

import android.os.Process;
import h1.b;
import java.util.concurrent.BlockingQueue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c extends Thread {
    public static final boolean h = v.b;
    public final BlockingQueue a;
    public final BlockingQueue c;
    public final b d;
    public final q e;
    public volatile boolean f = false;
    public final w g;

    public class a implements Runnable {
        public final /* synthetic */ n a;

        public a(n nVar) {
            this.a = nVar;
        }

        public void run() {
            try {
                c.a(c.this).put(this.a);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public c(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, b bVar, q qVar) {
        this.a = blockingQueue;
        this.c = blockingQueue2;
        this.d = bVar;
        this.e = qVar;
        this.g = new w(this, blockingQueue2, qVar);
    }

    public static /* synthetic */ BlockingQueue a(c cVar) {
        return cVar.c;
    }

    private void b() throws InterruptedException {
        c((n) this.a.take());
    }

    public void c(n nVar) {
        q qVar;
        nVar.b("cache-queue-take");
        nVar.N(1);
        try {
            if (nVar.H()) {
                nVar.p("cache-discard-canceled");
                return;
            }
            b.a aVar = this.d.get(nVar.t());
            if (aVar == null) {
                nVar.b("cache-miss");
                if (!this.g.c(nVar)) {
                    this.c.put(nVar);
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar.b(currentTimeMillis)) {
                nVar.b("cache-hit-expired");
                nVar.O(aVar);
                if (!this.g.c(nVar)) {
                    this.c.put(nVar);
                }
                return;
            }
            nVar.b("cache-hit");
            p M = nVar.M(new k(aVar.a, aVar.g));
            nVar.b("cache-hit-parsed");
            if (!M.b()) {
                nVar.b("cache-parsing-failed");
                this.d.a(nVar.t(), true);
                nVar.O(null);
                if (!this.g.c(nVar)) {
                    this.c.put(nVar);
                }
                return;
            }
            if (aVar.c(currentTimeMillis)) {
                nVar.b("cache-hit-refresh-needed");
                nVar.O(aVar);
                M.d = true;
                if (!this.g.c(nVar)) {
                    this.e.c(nVar, M, new a(nVar));
                }
                qVar = this.e;
            } else {
                qVar = this.e;
            }
            qVar.b(nVar, M);
        } finally {
            nVar.N(2);
        }
    }

    public void d() {
        this.f = true;
        interrupt();
    }

    public void run() {
        if (h) {
            v.e("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.initialize();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
