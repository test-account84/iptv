package com.google.android.gms.internal.firebase-auth-api;

import H5.c0;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaak extends zzacx {
    private final String zzy;
    private final String zzz;

    public zzaak(String str, String str2) {
        super(4);
        r.h(str, "code cannot be null or empty");
        this.zzy = str;
        this.zzz = str2;
    }

    public final String zza() {
        return "checkActionCode";
    }

    public final void zzb() {
        zzb(new c0(this.zzm));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zzd(this.zzy, this.zzz, this.zzb);
    }
}
