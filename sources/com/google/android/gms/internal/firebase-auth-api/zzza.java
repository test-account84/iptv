package com.google.android.gms.internal.firebase-auth-api;

import H5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzza implements zzadk {
    private final /* synthetic */ zzacd zza;
    private final /* synthetic */ zzyj zzb;

    public zzza(zzyj zzyjVar, zzacd zzacdVar) {
        this.zzb = zzyjVar;
        this.zza = zzacdVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzahb zzahbVar = (zzahb) obj;
        zzyj.zza(this.zzb, new zzafn(zzahbVar.zzd(), zzahbVar.zzb(), Long.valueOf(zzahbVar.zza()), "Bearer"), null, null, Boolean.valueOf(zzahbVar.zzf()), null, this.zza, this);
    }

    public final void zza(String str) {
        this.zza.zza(m.a(str));
    }
}
