package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class azg extends ayc implements ScheduledExecutorService, aze {
    final ScheduledExecutorService a;

    public azg(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        atp.k(scheduledExecutorService);
        this.a = scheduledExecutorService;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        azk q = azk.q(runnable, null);
        return new ayq(q, this.a.schedule(q, j, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        azf azfVar = new azf(runnable);
        return new ayq(azfVar, this.a.scheduleAtFixedRate(azfVar, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        azf azfVar = new azf(runnable);
        return new ayq(azfVar, this.a.scheduleWithFixedDelay(azfVar, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        azk p = azk.p(callable);
        return new ayq(p, this.a.schedule(p, j, timeUnit));
    }
}
