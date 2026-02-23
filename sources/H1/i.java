package h1;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i extends Thread {
    public final BlockingQueue a;
    public final h c;
    public final b d;
    public final q e;
    public volatile boolean f = false;

    public i(BlockingQueue blockingQueue, h hVar, b bVar, q qVar) {
        this.a = blockingQueue;
        this.c = hVar;
        this.d = bVar;
        this.e = qVar;
    }

    private void c() throws InterruptedException {
        d((n) this.a.take());
    }

    public final void a(n nVar) {
        TrafficStats.setThreadStatsTag(nVar.E());
    }

    public final void b(n nVar, u uVar) {
        this.e.a(nVar, nVar.L(uVar));
    }

    public void d(n nVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        nVar.N(3);
        try {
            try {
                try {
                    nVar.b("network-queue-take");
                } catch (u e) {
                    e.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    b(nVar, e);
                    nVar.J();
                }
            } catch (Exception e2) {
                v.d(e2, "Unhandled exception %s", e2.toString());
                u uVar = new u((Throwable) e2);
                uVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                this.e.a(nVar, uVar);
                nVar.J();
            }
            if (nVar.H()) {
                nVar.p("network-discard-cancelled");
                nVar.J();
                return;
            }
            a(nVar);
            k a = this.c.a(nVar);
            nVar.b("network-http-complete");
            if (a.e && nVar.G()) {
                nVar.p("not-modified");
                nVar.J();
                return;
            }
            p M = nVar.M(a);
            nVar.b("network-parse-complete");
            if (nVar.T() && M.b != null) {
                this.d.b(nVar.t(), M.b);
                nVar.b("network-cache-written");
            }
            nVar.I();
            this.e.b(nVar, M);
            nVar.K(M);
        } finally {
            nVar.N(4);
        }
    }

    public void e() {
        this.f = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                c();
            } catch (InterruptedException unused) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
