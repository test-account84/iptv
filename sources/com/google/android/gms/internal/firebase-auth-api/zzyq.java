package com.google.android.gms.internal.firebase-auth-api;

import H5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzyq implements zzadk {
    private final /* synthetic */ zzacd zza;
    private final /* synthetic */ zzyj zzb;

    public zzyq(zzyj zzyjVar, zzacd zzacdVar) {
        this.zzb = zzyjVar;
        this.zza = zzacdVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaeo zzaeoVar = (zzaeo) obj;
        if (zzaeoVar.zzf()) {
            this.zza.zza(new zzyk(zzaeoVar.zzc(), zzaeoVar.zze(), null));
        } else {
            zzyj.zza(this.zzb, new zzafn(zzaeoVar.zzd(), zzaeoVar.zzb(), Long.valueOf(zzaeoVar.zza()), "Bearer"), null, null, Boolean.valueOf(zzaeoVar.zzg()), null, this.zza, this);
        }
    }

    public final void zza(String str) {
        this.zza.zza(m.a(str));
    }
}
