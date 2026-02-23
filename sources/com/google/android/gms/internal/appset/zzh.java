package com.google.android.gms.internal.appset;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzh implements Runnable {
    public final /* synthetic */ zzl zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public /* synthetic */ zzh(zzl zzlVar, TaskCompletionSource taskCompletionSource) {
        this.zza = zzlVar;
        this.zzb = taskCompletionSource;
    }

    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
