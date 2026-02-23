package com.google.android.gms.internal.firebase-auth-api;

import H5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzzq implements zzadk {
    private final /* synthetic */ zzacd zza;
    private final /* synthetic */ zzyj zzb;

    public zzzq(zzyj zzyjVar, zzacd zzacdVar) {
        this.zzb = zzyjVar;
        this.zza = zzacdVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaes zzaesVar = (zzaes) obj;
        zzyj.zza(this.zzb, new zzafn(zzaesVar.zzb(), zzaesVar.zza(), Long.valueOf(zzafp.zza(zzaesVar.zza())), "Bearer"), null, null, Boolean.FALSE, null, this.zza, this);
    }

    public final void zza(String str) {
        this.zza.zza(m.a(str));
    }
}
