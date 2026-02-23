package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaas extends zzacx {
    private final zzxy zzy;

    public zzaas() {
        super(11);
        this.zzy = new zzxy();
    }

    public final String zza() {
        return "getRecaptchaParam";
    }

    public final void zzb() {
        zzb(this.zzu);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzb);
    }
}
