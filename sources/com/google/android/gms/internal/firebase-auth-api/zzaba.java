package com.google.android.gms.internal.firebase-auth-api;

import G5.h;
import H5.T;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaba extends zzacx {
    private final zzyd zzy;

    public zzaba(h hVar, String str) {
        super(2);
        r.n(hVar, "Credential cannot be null");
        this.zzy = new zzyd(hVar, str);
    }

    public final String zza() {
        return "reauthenticateWithEmailLink";
    }

    public final void zzb() {
        H5.b zza = zzaai.zza(this.zzc, this.zzk);
        if (!this.zzd.L().equalsIgnoreCase(zza.L())) {
            zza(new Status(17024));
        } else {
            ((T) this.zze).a(this.zzj, zza);
            zzb(null);
        }
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzb);
    }
}
