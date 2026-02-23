package com.google.android.gms.internal.firebase-auth-api;

import G5.H;
import com.google.android.gms.common.api.Status;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzadd implements zzadf {
    private final /* synthetic */ Status zza;

    public zzadd(zzacz zzaczVar, Status status) {
        this.zza = status;
    }

    public final void zza(H h, Object... objArr) {
        h.onVerificationFailed(zzacf.zza(this.zza));
    }
}
