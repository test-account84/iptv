package com.google.ads.interactivemedia.v3.internal;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class ayc extends AbstractExecutorService implements aze {
    private final ExecutorService a;

    public ayc() {
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final azd submit(Callable callable) {
        return (azd) super.submit(callable);
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.a.awaitTermination(j, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.a.execute(runnable);
    }

    public final boolean isShutdown() {
        return this.a.isShutdown();
    }

    public final boolean isTerminated() {
        return this.a.isTerminated();
    }

    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return azk.q(runnable, obj);
    }

    public final void shutdown() {
        this.a.shutdown();
    }

    public final List shutdownNow() {
        return this.a.shutdownNow();
    }

    public final /* bridge */ /* synthetic */ Future submit(Runnable runnable) {
        return (azd) super.submit(runnable);
    }

    public final String toString() {
        return super.toString() + "[" + this.a + "]";
    }

    public ayc(ExecutorService executorService) {
        this();
        atp.k(executorService);
        this.a = executorService;
    }

    public final RunnableFuture newTaskFor(Callable callable) {
        return azk.p(callable);
    }

    public final /* bridge */ /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (azd) super.submit(runnable, obj);
    }
}
