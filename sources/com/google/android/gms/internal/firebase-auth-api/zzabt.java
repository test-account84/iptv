package com.google.android.gms.internal.firebase-auth-api;

import H5.T;
import H5.d0;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzabt extends zzacx {
    public zzabt() {
        super(2);
    }

    public final String zza() {
        return "unlinkEmailCredential";
    }

    public final void zzb() {
        H5.b zza = zzaai.zza(this.zzc, this.zzk);
        ((T) this.zze).a(this.zzj, zza);
        zzb(new d0(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zze(this.zzd.zze(), this.zzb);
    }
}
