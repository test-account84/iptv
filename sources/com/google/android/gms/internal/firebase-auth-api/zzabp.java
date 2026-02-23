package com.google.android.gms.internal.firebase-auth-api;

import H5.k;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzabp extends zzacx {
    private final String zzaa;
    private final long zzab;
    private final boolean zzac;
    private final boolean zzad;
    private final String zzae;
    private final String zzaf;
    private final boolean zzag;
    private final String zzy;
    private final String zzz;

    public zzabp(k kVar, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3) {
        super(8);
        r.m(kVar);
        r.g(str);
        this.zzy = r.g(kVar.H());
        this.zzz = str;
        this.zzaa = str2;
        this.zzab = j;
        this.zzac = z;
        this.zzad = z2;
        this.zzae = str3;
        this.zzaf = str4;
        this.zzag = z3;
    }

    public final String zza() {
        return "startMfaEnrollment";
    }

    public final void zzb() {
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzz, this.zzaa, this.zzab, this.zzac, this.zzad, this.zzae, this.zzaf, this.zzag, this.zzb);
    }
}
