package com.google.android.gms.internal.firebase-auth-api;

import G5.J;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzabr extends zzacx {
    private final zzyf zzy;

    public zzabr(J j, String str, String str2, long j2, boolean z, boolean z2, String str3, String str4, boolean z3) {
        super(8);
        r.m(j);
        r.g(str);
        this.zzy = new zzyf(j, str, str2, j2, z, z2, str3, str4, z3);
    }

    public final String zza() {
        return "startMfaSignInWithPhoneNumber";
    }

    public final void zzb() {
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzb);
    }
}
