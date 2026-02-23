package J5;

import J5.p;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class o implements ScheduledExecutorService {
    public final ExecutorService a;
    public final ScheduledExecutorService c;

    public o(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.a = executorService;
        this.c = scheduledExecutorService;
    }

    public static /* synthetic */ ScheduledFuture a(o oVar, Callable callable, long j, TimeUnit timeUnit, p.b bVar) {
        return oVar.r(callable, j, timeUnit, bVar);
    }

    public static /* synthetic */ ScheduledFuture b(o oVar, Runnable runnable, long j, long j2, TimeUnit timeUnit, p.b bVar) {
        return oVar.w(runnable, j, j2, timeUnit, bVar);
    }

    public static /* synthetic */ ScheduledFuture c(o oVar, Runnable runnable, long j, long j2, TimeUnit timeUnit, p.b bVar) {
        return oVar.u(runnable, j, j2, timeUnit, bVar);
    }

    public static /* synthetic */ void d(Callable callable, p.b bVar) {
        p(callable, bVar);
    }

    public static /* synthetic */ void e(Runnable runnable, p.b bVar) {
        s(runnable, bVar);
    }

    public static /* synthetic */ void f(o oVar, Runnable runnable, p.b bVar) {
        oVar.t(runnable, bVar);
    }

    public static /* synthetic */ Future g(o oVar, Callable callable, p.b bVar) {
        return oVar.q(callable, bVar);
    }

    public static /* synthetic */ void h(Runnable runnable, p.b bVar) {
        x(runnable, bVar);
    }

    public static /* synthetic */ void i(o oVar, Runnable runnable, p.b bVar) {
        oVar.n(runnable, bVar);
    }

    public static /* synthetic */ void j(Runnable runnable, p.b bVar) {
        m(runnable, bVar);
    }

    public static /* synthetic */ void k(o oVar, Runnable runnable, p.b bVar) {
        oVar.v(runnable, bVar);
    }

    public static /* synthetic */ ScheduledFuture l(o oVar, Runnable runnable, long j, TimeUnit timeUnit, p.b bVar) {
        return oVar.o(runnable, j, timeUnit, bVar);
    }

    public static /* synthetic */ void m(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
            bVar.set(null);
        } catch (Exception e) {
            bVar.a(e);
        }
    }

    public static /* synthetic */ void p(Callable callable, p.b bVar) {
        try {
            bVar.set(callable.call());
        } catch (Exception e) {
            bVar.a(e);
        }
    }

    public static /* synthetic */ void s(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
        } catch (Exception e) {
            bVar.a(e);
            throw e;
        }
    }

    public static /* synthetic */ void x(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
        } catch (Exception e) {
            bVar.a(e);
        }
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.a.awaitTermination(j, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }

    public List invokeAll(Collection collection) {
        return this.a.invokeAll(collection);
    }

    public Object invokeAny(Collection collection) {
        return this.a.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    public final /* synthetic */ void n(Runnable runnable, p.b bVar) {
        this.a.execute(new m(runnable, bVar));
    }

    public final /* synthetic */ ScheduledFuture o(Runnable runnable, long j, TimeUnit timeUnit, p.b bVar) {
        return this.c.schedule(new j(this, runnable, bVar), j, timeUnit);
    }

    public final /* synthetic */ Future q(Callable callable, p.b bVar) {
        return this.a.submit(new n(callable, bVar));
    }

    public final /* synthetic */ ScheduledFuture r(Callable callable, long j, TimeUnit timeUnit, p.b bVar) {
        return this.c.schedule(new k(this, callable, bVar), j, timeUnit);
    }

    public ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return new p(new c(this, runnable, j, timeUnit));
    }

    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return new p(new f(this, runnable, j, j2, timeUnit));
    }

    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return new p(new g(this, runnable, j, j2, timeUnit));
    }

    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public List shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public Future submit(Runnable runnable) {
        return this.a.submit(runnable);
    }

    public final /* synthetic */ void t(Runnable runnable, p.b bVar) {
        this.a.execute(new d(runnable, bVar));
    }

    public final /* synthetic */ ScheduledFuture u(Runnable runnable, long j, long j2, TimeUnit timeUnit, p.b bVar) {
        return this.c.scheduleAtFixedRate(new i(this, runnable, bVar), j, j2, timeUnit);
    }

    public final /* synthetic */ void v(Runnable runnable, p.b bVar) {
        this.a.execute(new e(runnable, bVar));
    }

    public final /* synthetic */ ScheduledFuture w(Runnable runnable, long j, long j2, TimeUnit timeUnit, p.b bVar) {
        return this.c.scheduleWithFixedDelay(new l(this, runnable, bVar), j, j2, timeUnit);
    }

    public List invokeAll(Collection collection, long j, TimeUnit timeUnit) {
        return this.a.invokeAll(collection, j, timeUnit);
    }

    public Object invokeAny(Collection collection, long j, TimeUnit timeUnit) {
        return this.a.invokeAny(collection, j, timeUnit);
    }

    public ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        return new p(new h(this, callable, j, timeUnit));
    }

    public Future submit(Runnable runnable, Object obj) {
        return this.a.submit(runnable, obj);
    }

    public Future submit(Callable callable) {
        return this.a.submit(callable);
    }
}
