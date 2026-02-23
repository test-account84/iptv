package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzn implements zzq {
    private final Executor zza;
    private final Object zzb = new Object();
    private OnSuccessListener zzc;

    public zzn(Executor executor, OnSuccessListener onSuccessListener) {
        this.zza = executor;
        this.zzc = onSuccessListener;
    }

    public static /* bridge */ /* synthetic */ OnSuccessListener zza(zzn zznVar) {
        return zznVar.zzc;
    }

    public static /* bridge */ /* synthetic */ Object zzb(zzn zznVar) {
        return zznVar.zzb;
    }

    public final void zzc() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }

    public final void zzd(Task task) {
        if (task.isSuccessful()) {
            synchronized (this.zzb) {
                try {
                    if (this.zzc == null) {
                        return;
                    }
                    this.zza.execute(new zzm(this, task));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
