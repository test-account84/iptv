package com.google.android.gms.tasks;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzm implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzn zzb;

    public zzm(zzn zznVar, Task task) {
        this.zzb = zznVar;
        this.zza = task;
    }

    public final void run() {
        synchronized (zzn.zzb(this.zzb)) {
            try {
                zzn zznVar = this.zzb;
                if (zzn.zza(zznVar) != null) {
                    zzn.zza(zznVar).onSuccess(this.zza.getResult());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
