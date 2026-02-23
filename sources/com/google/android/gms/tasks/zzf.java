package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzf implements OnSuccessListener, OnFailureListener, OnCanceledListener, zzq {
    private final Executor zza;
    private final Continuation zzb;
    private final zzw zzc;

    public zzf(Executor executor, Continuation continuation, zzw zzwVar) {
        this.zza = executor;
        this.zzb = continuation;
        this.zzc = zzwVar;
    }

    public static /* bridge */ /* synthetic */ Continuation zza(zzf zzfVar) {
        return zzfVar.zzb;
    }

    public static /* bridge */ /* synthetic */ zzw zzb(zzf zzfVar) {
        return zzfVar.zzc;
    }

    public final void onCanceled() {
        this.zzc.zzc();
    }

    public final void onFailure(Exception exc) {
        this.zzc.zza(exc);
    }

    public final void onSuccess(Object obj) {
        this.zzc.zzb(obj);
    }

    public final void zzc() {
        throw new UnsupportedOperationException();
    }

    public final void zzd(Task task) {
        this.zza.execute(new zze(this, task));
    }
}
