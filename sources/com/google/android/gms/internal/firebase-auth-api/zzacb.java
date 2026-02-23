package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzacb extends zzacx {
    private final zzyb zzy;

    public zzacb(zzaga zzagaVar) {
        super(8);
        r.m(zzagaVar);
        this.zzy = new zzyb(zzagaVar);
    }

    public final String zza() {
        return "verifyPhoneNumber";
    }

    public final void zzb() {
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzb);
    }
}
