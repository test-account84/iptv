package com.google.android.gms.internal.firebase-auth-api;

import G5.d;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzabz extends zzacx {
    private final zzyi zzy;

    public zzabz(String str, String str2, d dVar) {
        super(6);
        r.g(str);
        r.g(str2);
        r.m(dVar);
        this.zzy = new zzyi(str, str2, dVar);
    }

    public final String zza() {
        return "verifyBeforeUpdateEmail";
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzb);
    }
}
