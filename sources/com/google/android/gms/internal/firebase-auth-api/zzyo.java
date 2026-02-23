package com.google.android.gms.internal.firebase-auth-api;

import H5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzyo implements zzadk {
    private final /* synthetic */ zzacd zza;
    private final /* synthetic */ zzyj zzb;

    public zzyo(zzyj zzyjVar, zzacd zzacdVar) {
        this.zzb = zzyjVar;
        this.zza = zzacdVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagz zzagzVar = (zzagz) obj;
        if (zzagzVar.zzf()) {
            this.zza.zza(new zzyk(zzagzVar.zzc(), zzagzVar.zze(), null));
        } else {
            zzyj.zza(this.zzb, new zzafn(zzagzVar.zzd(), zzagzVar.zzb(), Long.valueOf(zzagzVar.zza()), "Bearer"), null, null, Boolean.FALSE, null, this.zza, this);
        }
    }

    public final void zza(String str) {
        this.zza.zza(m.a(str));
    }
}
