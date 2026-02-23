package com.google.android.gms.internal.firebase-auth-api;

import G5.d;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzabi extends zzacx {
    private final zzxz zzy;

    public zzabi(String str, d dVar) {
        super(6);
        r.h(str, "token cannot be null or empty");
        this.zzy = new zzxz(str, dVar);
    }

    public final String zza() {
        return "sendEmailVerification";
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzb);
    }
}
