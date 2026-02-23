package com.google.android.gms.tasks;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzc implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzd zzb;

    public zzc(zzd zzdVar, Task task) {
        this.zzb = zzdVar;
        this.zza = task;
    }

    public final void run() {
        if (this.zza.isCanceled()) {
            zzd.zzb(this.zzb).zzc();
            return;
        }
        try {
            zzd.zzb(this.zzb).zzb(zzd.zza(this.zzb).then(this.zza));
        } catch (Exception e) {
            zzd.zzb(this.zzb).zza(e);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                zzd.zzb(this.zzb).zza((Exception) e2.getCause());
            } else {
                zzd.zzb(this.zzb).zza(e2);
            }
        }
    }
}
