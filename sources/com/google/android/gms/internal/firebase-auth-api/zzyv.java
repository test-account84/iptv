package com.google.android.gms.internal.firebase-auth-api;

import H5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzyv implements zzadk {
    private final /* synthetic */ zzacd zza;
    private final /* synthetic */ zzyj zzb;

    public zzyv(zzyj zzyjVar, zzacd zzacdVar) {
        this.zzb = zzyjVar;
        this.zza = zzacdVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagx zzagxVar = (zzagx) obj;
        zzyj.zza(this.zzb, new zzafn(zzagxVar.zzc(), zzagxVar.zzb(), Long.valueOf(zzagxVar.zza()), "Bearer"), null, null, Boolean.valueOf(zzagxVar.zzd()), null, this.zza, this);
    }

    public final void zza(String str) {
        this.zza.zza(m.a(str));
    }
}
