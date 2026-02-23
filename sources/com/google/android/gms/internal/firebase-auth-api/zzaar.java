package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaar extends zzacx {
    private final zzxx zzy;

    public zzaar(String str, String str2) {
        super(10);
        r.g(str2);
        this.zzy = new zzxx(str, str2);
    }

    public final String zza() {
        return "getRecaptchaConfig";
    }

    public final void zzb() {
        zzb(this.zzt);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzb);
    }
}
