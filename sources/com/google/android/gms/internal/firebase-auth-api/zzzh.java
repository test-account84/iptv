package com.google.android.gms.internal.firebase-auth-api;

import H5.m;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzzh implements zzadk {
    private final /* synthetic */ zzadk zza;
    private final /* synthetic */ zzafn zzb;
    private final /* synthetic */ zzzi zzc;

    public zzzh(zzzi zzziVar, zzadk zzadkVar, zzafn zzafnVar) {
        this.zzc = zzziVar;
        this.zza = zzadkVar;
        this.zzb = zzafnVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        List zza = ((zzafd) obj).zza();
        if (zza == null || zza.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzafc zzafcVar = (zzafc) zza.get(0);
        zzagc zzagcVar = new zzagc();
        zzagcVar.zzd(this.zzb.zzc()).zza(this.zzc.zza);
        zzzi zzziVar = this.zzc;
        zzyj.zza(zzziVar.zzc, zzziVar.zzb, this.zzb, zzafcVar, zzagcVar, this.zza);
    }

    public final void zza(String str) {
        this.zzc.zzb.zza(m.a(str));
    }
}
