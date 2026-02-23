package com.google.android.gms.internal.firebase-auth-api;

import H5.k;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzabs extends zzacx {
    private final zzagm zzy;

    public zzabs(k kVar, String str) {
        super(12);
        r.m(kVar);
        this.zzy = zzagm.zza(r.g(kVar.H()), str);
    }

    public final String zza() {
        return "startMfaEnrollment";
    }

    public final void zzb() {
        zzb(this.zzv);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzb);
    }
}
