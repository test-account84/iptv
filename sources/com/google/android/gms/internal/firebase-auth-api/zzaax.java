package com.google.android.gms.internal.firebase-auth-api;

import G5.g;
import H5.T;
import H5.U;
import H5.d0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaax extends zzacx {
    private final zzagt zzy;

    public zzaax(g gVar, String str) {
        super(2);
        r.n(gVar, "credential cannot be null");
        this.zzy = U.a(gVar, str).zza(false);
    }

    public final String zza() {
        return "reauthenticateWithCredentialWithData";
    }

    public final void zzb() {
        H5.b zza = zzaai.zza(this.zzc, this.zzk);
        if (!this.zzd.L().equalsIgnoreCase(zza.L())) {
            zza(new Status(17024));
        } else {
            ((T) this.zze).a(this.zzj, zza);
            zzb(new d0(zza));
        }
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzb);
    }
}
