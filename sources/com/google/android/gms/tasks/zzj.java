package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzj implements zzq {
    private final Executor zza;
    private final Object zzb = new Object();
    private OnCompleteListener zzc;

    public zzj(Executor executor, OnCompleteListener onCompleteListener) {
        this.zza = executor;
        this.zzc = onCompleteListener;
    }

    public static /* bridge */ /* synthetic */ OnCompleteListener zza(zzj zzjVar) {
        return zzjVar.zzc;
    }

    public static /* bridge */ /* synthetic */ Object zzb(zzj zzjVar) {
        return zzjVar.zzb;
    }

    public final void zzc() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }

    public final void zzd(Task task) {
        synchronized (this.zzb) {
            try {
                if (this.zzc == null) {
                    return;
                }
                this.zza.execute(new zzi(this, task));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
