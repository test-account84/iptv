package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzadg implements Runnable {
    private /* synthetic */ zzadh zza;
    private /* synthetic */ zzadj zzb;
    private /* synthetic */ TaskCompletionSource zzc;

    public /* synthetic */ zzadg(zzadh zzadhVar, zzadj zzadjVar, TaskCompletionSource taskCompletionSource) {
        this.zza = zzadhVar;
        this.zzb = zzadjVar;
        this.zzc = taskCompletionSource;
    }

    public final void run() {
        this.zzb.zza(this.zzc, this.zza.zza);
    }
}
