package com.google.android.gms.internal.firebase-auth-api;

import H5.T;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzabv extends zzacx {
    private final String zzy;

    public zzabv(String str) {
        super(2);
        this.zzy = r.h(str, "email cannot be null or empty");
    }

    public final String zza() {
        return "updateEmail";
    }

    public final void zzb() {
        ((T) this.zze).a(this.zzj, zzaai.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zzb(this.zzd.zze(), this.zzy, this.zzb);
    }
}
