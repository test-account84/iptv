package com.google.android.gms.internal.firebase-auth-api;

import G5.F;
import H5.T;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzabx extends zzacx {
    private final F zzy;

    public zzabx(F f) {
        super(2);
        this.zzy = (F) r.m(f);
    }

    public final String zza() {
        return "updatePhoneNumber";
    }

    public final void zzb() {
        ((T) this.zze).a(this.zzj, zzaai.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(new zzya(this.zzd.zze(), this.zzy), this.zzb);
    }
}
