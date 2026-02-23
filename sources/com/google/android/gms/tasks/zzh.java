package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzh implements zzq {
    private final Executor zza;
    private final Object zzb = new Object();
    private OnCanceledListener zzc;

    public zzh(Executor executor, OnCanceledListener onCanceledListener) {
        this.zza = executor;
        this.zzc = onCanceledListener;
    }

    public static /* bridge */ /* synthetic */ OnCanceledListener zza(zzh zzhVar) {
        return zzhVar.zzc;
    }

    public static /* bridge */ /* synthetic */ Object zzb(zzh zzhVar) {
        return zzhVar.zzb;
    }

    public final void zzc() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }

    public final void zzd(Task task) {
        if (task.isCanceled()) {
            synchronized (this.zzb) {
                try {
                    if (this.zzc == null) {
                        return;
                    }
                    this.zza.execute(new zzg(this));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
