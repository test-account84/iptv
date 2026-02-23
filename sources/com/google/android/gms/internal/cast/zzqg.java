package com.google.android.gms.internal.cast;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzqg extends zzez implements Future {
    public boolean cancel(boolean z) {
        return zzb().cancel(z);
    }

    public final Object get() throws InterruptedException, ExecutionException {
        return zzb().get();
    }

    public final boolean isCancelled() {
        return zzb().isCancelled();
    }

    public final boolean isDone() {
        return zzb().isDone();
    }

    public /* bridge */ /* synthetic */ Object zza() {
        throw null;
    }

    public abstract Future zzb();

    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return zzb().get(j, timeUnit);
    }
}
