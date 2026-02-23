package com.google.android.gms.internal.firebase-auth-api;

import H5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaab implements zzadk {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzacd zzb;
    private final /* synthetic */ zzyj zzc;

    public zzaab(zzyj zzyjVar, String str, zzacd zzacdVar) {
        this.zzc = zzyjVar;
        this.zza = str;
        this.zzb = zzacdVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzafn zzafnVar = (zzafn) obj;
        zzagc zzagcVar = new zzagc();
        zzagcVar.zzd(zzafnVar.zzc()).zzc(this.zza);
        zzyj.zza(this.zzc, this.zzb, zzafnVar, zzagcVar, this);
    }

    public final void zza(String str) {
        this.zzb.zza(m.a(str));
    }
}
