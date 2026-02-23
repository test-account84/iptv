package com.google.android.gms.tasks;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzi implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzj zzb;

    public zzi(zzj zzjVar, Task task) {
        this.zzb = zzjVar;
        this.zza = task;
    }

    public final void run() {
        synchronized (zzj.zzb(this.zzb)) {
            try {
                zzj zzjVar = this.zzb;
                if (zzj.zza(zzjVar) != null) {
                    zzj.zza(zzjVar).onComplete(this.zza);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
