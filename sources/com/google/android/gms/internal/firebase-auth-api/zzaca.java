package com.google.android.gms.internal.firebase-auth-api;

import G5.P;
import H5.T;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaca extends zzacx {
    private final P zzy;

    public zzaca(P p) {
        super(2);
        this.zzy = (P) r.n(p, "request cannot be null");
    }

    public final String zza() {
        return "updateProfile";
    }

    public final void zzb() {
        ((T) this.zze).a(this.zzj, zzaai.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzd.zze(), this.zzy, this.zzb);
    }
}
