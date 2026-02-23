package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzabf extends zzacx {
    private final zzafz zzy;

    public zzabf(String str, String str2, String str3, String str4) {
        super(15);
        this.zzy = zzafz.zzg().zzd(str).zza(str2).zzc(str4).zzb(str3).zza(zzaey.zza).zza();
    }

    public final String zza() {
        return "revokeAccessToken";
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzb);
    }
}
