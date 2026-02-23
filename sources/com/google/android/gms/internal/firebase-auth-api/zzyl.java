package com.google.android.gms.internal.firebase-auth-api;

import H5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzyl implements zzadk {
    private final /* synthetic */ zzacd zza;
    private final /* synthetic */ zzyj zzb;

    public zzyl(zzyj zzyjVar, zzacd zzacdVar) {
        this.zzb = zzyjVar;
        this.zza = zzacdVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagh zzaghVar = (zzagh) obj;
        zzyj.zza(this.zzb, new zzafn(zzaghVar.zzc(), zzaghVar.zzb(), Long.valueOf(zzaghVar.zza()), "Bearer"), null, null, Boolean.TRUE, null, this.zza, this);
    }

    public final void zza(String str) {
        this.zza.zza(m.a(str));
    }
}
