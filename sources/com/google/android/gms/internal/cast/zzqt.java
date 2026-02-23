package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzqt extends zzqq implements ScheduledExecutorService, zzqp {
    final ScheduledExecutorService zza;

    public zzqt(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzqw zzn = zzqw.zzn(runnable, null);
        return new zzqr(zzn, this.zza.schedule(zzn, j, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzqs zzqsVar = new zzqs(runnable);
        return new zzqr(zzqsVar, this.zza.scheduleAtFixedRate(zzqsVar, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzqs zzqsVar = new zzqs(runnable);
        return new zzqr(zzqsVar, this.zza.scheduleWithFixedDelay(zzqsVar, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzqw zzqwVar = new zzqw(callable);
        return new zzqr(zzqwVar, this.zza.schedule(zzqwVar, j, timeUnit));
    }
}
