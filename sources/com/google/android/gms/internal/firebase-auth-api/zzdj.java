package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdj extends zzne {
    private final /* synthetic */ zzdi zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdj(zzdi zzdiVar, Class cls) {
        super(cls);
        this.zza = zzdiVar;
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzsf.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ void zzb(zzakn zzaknVar) throws GeneralSecurityException {
        zzsf zzsfVar = (zzsf) zzaknVar;
        new zzdv().zzc().zzb(zzsfVar.zzc());
        new zzqg().zzc().zzb(zzsfVar.zzd());
        zzxo.zza(zzsfVar.zzc().zza());
    }

    public final /* synthetic */ zzakn zza(zzakn zzaknVar) throws GeneralSecurityException {
        zzsf zzsfVar = (zzsf) zzaknVar;
        zzsi zzsiVar = (zzsi) new zzdv().zzc().zza(zzsfVar.zzc());
        return (zzse) ((zzajc) zzse.zzb().zza(zzsiVar).zza((zzuc) new zzqg().zzc().zza(zzsfVar.zzd())).zza(zzdi.zza()).zzf());
    }
}
