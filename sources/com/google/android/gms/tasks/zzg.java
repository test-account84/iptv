package com.google.android.gms.tasks;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzg implements Runnable {
    final /* synthetic */ zzh zza;

    public zzg(zzh zzhVar) {
        this.zza = zzhVar;
    }

    public final void run() {
        synchronized (zzh.zzb(this.zza)) {
            try {
                zzh zzhVar = this.zza;
                if (zzh.zza(zzhVar) != null) {
                    zzh.zza(zzhVar).onCanceled();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
