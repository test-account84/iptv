package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzyp implements zzadk {
    private final /* synthetic */ zzadl zza;
    private final /* synthetic */ zzacd zzb;
    private final /* synthetic */ zzafn zzc;
    private final /* synthetic */ zzagc zzd;
    private final /* synthetic */ zzyj zze;

    public zzyp(zzyj zzyjVar, zzadl zzadlVar, zzacd zzacdVar, zzafn zzafnVar, zzagc zzagcVar) {
        this.zze = zzyjVar;
        this.zza = zzadlVar;
        this.zzb = zzacdVar;
        this.zzc = zzafnVar;
        this.zzd = zzagcVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        List zza = ((zzafd) obj).zza();
        if (zza == null || zza.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzyj.zza(this.zze, this.zzb, this.zzc, (zzafc) zza.get(0), this.zzd, this.zza);
        }
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }
}
