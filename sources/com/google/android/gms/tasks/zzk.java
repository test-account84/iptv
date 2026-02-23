package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzk implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzl zzb;

    public zzk(zzl zzlVar, Task task) {
        this.zzb = zzlVar;
        this.zza = task;
    }

    public final void run() {
        synchronized (zzl.zzb(this.zzb)) {
            try {
                zzl zzlVar = this.zzb;
                if (zzl.zza(zzlVar) != null) {
                    zzl.zza(zzlVar).onFailure((Exception) r.m(this.zza.getException()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
