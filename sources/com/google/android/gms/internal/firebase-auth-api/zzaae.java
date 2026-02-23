package com.google.android.gms.internal.firebase-auth-api;

import H5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaae implements zzadk {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzacd zzb;
    private final /* synthetic */ zzyj zzc;

    public zzaae(zzyj zzyjVar, String str, zzacd zzacdVar) {
        this.zzc = zzyjVar;
        this.zza = str;
        this.zzb = zzacdVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzafn zzafnVar = (zzafn) obj;
        String zzc = zzafnVar.zzc();
        zzagc zzagcVar = new zzagc();
        zzagcVar.zzd(zzc).zzf(this.zza);
        zzyj.zza(this.zzc, this.zzb, zzafnVar, zzagcVar, this);
    }

    public final void zza(String str) {
        this.zzb.zza(m.a(str));
    }
}
