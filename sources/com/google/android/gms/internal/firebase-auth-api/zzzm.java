package com.google.android.gms.internal.firebase-auth-api;

import H5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzzm implements zzadk {
    private final /* synthetic */ zzacd zza;
    private final /* synthetic */ zzyj zzb;

    public zzzm(zzyj zzyjVar, zzacd zzacdVar) {
        this.zzb = zzyjVar;
        this.zza = zzacdVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagv zzagvVar = (zzagv) obj;
        if (zzagvVar.zzl()) {
            this.zza.zza(new zzyk(zzagvVar.zzf(), zzagvVar.zzk(), zzagvVar.zzb()));
        } else {
            zzyj.zza(this.zzb, zzagvVar, this.zza, this);
        }
    }

    public final void zza(String str) {
        this.zza.zza(m.a(str));
    }
}
