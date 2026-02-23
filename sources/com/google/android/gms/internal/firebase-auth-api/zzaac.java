package com.google.android.gms.internal.firebase-auth-api;

import G5.P;
import H5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaac implements zzadk {
    private final /* synthetic */ P zza;
    private final /* synthetic */ zzacd zzb;
    private final /* synthetic */ zzyj zzc;

    public zzaac(zzyj zzyjVar, P p, zzacd zzacdVar) {
        this.zzc = zzyjVar;
        this.zza = p;
        this.zzb = zzacdVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzafn zzafnVar = (zzafn) obj;
        zzagc zzagcVar = new zzagc();
        zzagcVar.zzd(zzafnVar.zzc());
        if (this.zza.J() || this.zza.H() != null) {
            zzagcVar.zzb(this.zza.H());
        }
        if (this.zza.zzc() || this.zza.I() != null) {
            zzagcVar.zzg(this.zza.zza());
        }
        zzyj.zza(this.zzc, this.zzb, zzafnVar, zzagcVar, this);
    }

    public final void zza(String str) {
        this.zzb.zza(m.a(str));
    }
}
