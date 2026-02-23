package com.google.android.gms.internal.firebase-auth-api;

import G5.d;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzabh extends zzacx {
    private final zzyc zzy;
    private final String zzz;

    public zzabh(String str, d dVar, String str2, String str3, String str4) {
        super(4);
        r.h(str, "email cannot be null or empty");
        this.zzy = new zzyc(str, dVar, str2, str3);
        this.zzz = str4;
    }

    public final String zza() {
        return this.zzz;
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzb);
    }
}
