package com.google.android.gms.internal.firebase-auth-api;

import G5.F;
import H5.T;
import H5.d0;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaaw extends zzacx {
    private final F zzy;

    public zzaaw(F f) {
        super(2);
        this.zzy = (F) r.n(f, "credential cannot be null");
    }

    public final String zza() {
        return "linkPhoneAuthCredential";
    }

    public final void zzb() {
        H5.b zza = zzaai.zza(this.zzc, this.zzk);
        ((T) this.zze).a(this.zzj, zza);
        zzb(new d0(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(new zzya(this.zzd.zze(), this.zzy), this.zzb);
    }
}
