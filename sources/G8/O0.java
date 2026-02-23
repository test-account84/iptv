package G8;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class o0 extends n0 implements V {
    public final Executor e;

    public o0(Executor executor) {
        this.e = executor;
        kotlinx.coroutines.internal.d.a(g0());
    }

    public void c0(o8.g gVar, Runnable runnable) {
        try {
            Executor g0 = g0();
            c.a();
            g0.execute(runnable);
        } catch (RejectedExecutionException e) {
            c.a();
            f0(gVar, e);
            b0.b().c0(gVar, runnable);
        }
    }

    public void close() {
        ExecutorService g0 = g0();
        ExecutorService executorService = g0 instanceof ExecutorService ? g0 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof o0) && ((o0) obj).g0() == g0();
    }

    public final void f0(o8.g gVar, RejectedExecutionException rejectedExecutionException) {
        B0.c(gVar, m0.a("The task was rejected", rejectedExecutionException));
    }

    public Executor g0() {
        return this.e;
    }

    public final ScheduledFuture h0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, o8.g gVar, long j) {
        try {
            return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            f0(gVar, e);
            return null;
        }
    }

    public int hashCode() {
        return System.identityHashCode(g0());
    }

    public d0 t(long j, Runnable runnable, o8.g gVar) {
        Executor g0 = g0();
        ScheduledExecutorService scheduledExecutorService = g0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) g0 : null;
        ScheduledFuture h0 = scheduledExecutorService != null ? h0(scheduledExecutorService, runnable, gVar, j) : null;
        return h0 != null ? new c0(h0) : Q.i.t(j, runnable, gVar);
    }

    public String toString() {
        return g0().toString();
    }
}
