package com.google.android.gms.internal.firebase-auth-api;

import G5.A;
import H5.T;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;
import d.D;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaan extends zzacx {
    private final String zzaa;
    private final String zzab;
    private final A zzy;
    private final String zzz;

    public zzaan(A a, String str, String str2, String str3) {
        super(2);
        D.a(r.m(a));
        this.zzz = r.g(str);
        this.zzaa = str2;
        this.zzab = str3;
    }

    public final String zza() {
        return "finalizeMfaEnrollment";
    }

    public final void zzb() {
        ((T) this.zze).a(this.zzj, zzaai.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza((A) null, this.zzz, this.zzaa, this.zzab, this.zzb);
    }
}
