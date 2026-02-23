package com.google.android.gms.internal.firebase-auth-api;

import H5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzzn implements zzadk {
    private final /* synthetic */ zzzo zza;

    public zzzn(zzzo zzzoVar) {
        this.zza = zzzoVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaeq zzaeqVar = (zzaeq) obj;
        zzafn zzafnVar = new zzafn(zzaeqVar.zzb(), zzaeqVar.zza(), Long.valueOf(zzafp.zza(zzaeqVar.zza())), "Bearer");
        zzzo zzzoVar = this.zza;
        zzyj.zza(zzzoVar.zzb, zzafnVar, null, null, Boolean.FALSE, null, zzzoVar.zza, this);
    }

    public final void zza(String str) {
        this.zza.zza.zza(m.a(str));
    }
}
