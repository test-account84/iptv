package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzzc implements zzadk {
    private final /* synthetic */ zzacd zza;
    private final /* synthetic */ zzadl zzb;
    private final /* synthetic */ zzyj zzc;

    public zzzc(zzyj zzyjVar, zzacd zzacdVar, zzadl zzadlVar) {
        this.zzc = zzyjVar;
        this.zza = zzacdVar;
        this.zzb = zzadlVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagh zzaghVar = (zzagh) obj;
        zzyj.zza(this.zzc, new zzafn(zzaghVar.zzc(), zzaghVar.zzb(), Long.valueOf(zzaghVar.zza()), "Bearer"), null, "password", Boolean.FALSE, null, this.zza, this);
    }

    public final void zza(String str) {
        this.zzb.zza(str);
    }
}
