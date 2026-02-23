package com.google.android.gms.internal.firebase-auth-api;

import H5.l;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaao extends zzacx {
    private final String zzy;
    private final String zzz;

    public zzaao(String str, String str2) {
        super(3);
        r.h(str, "email cannot be null or empty");
        this.zzy = str;
        this.zzz = str2;
    }

    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    public final void zzb() {
        zzb(new l(this.zzl.zza() == null ? zzap.zzh() : (List) r.m(this.zzl.zza())));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zze(this.zzy, this.zzz, this.zzb);
    }
}
