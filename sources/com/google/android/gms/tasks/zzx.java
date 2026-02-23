package com.google.android.gms.tasks;

import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzx implements Runnable {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzx(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void run() {
        this.zza.trySetException(new TimeoutException());
    }
}
