package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzp implements OnSuccessListener, OnFailureListener, OnCanceledListener, zzq {
    private final Executor zza;
    private final SuccessContinuation zzb;
    private final zzw zzc;

    public zzp(Executor executor, SuccessContinuation successContinuation, zzw zzwVar) {
        this.zza = executor;
        this.zzb = successContinuation;
        this.zzc = zzwVar;
    }

    public static /* bridge */ /* synthetic */ SuccessContinuation zza(zzp zzpVar) {
        return zzpVar.zzb;
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
        this.zza.execute(new zzo(this, task));
    }
}
