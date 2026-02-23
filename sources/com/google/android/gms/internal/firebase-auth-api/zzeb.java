package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzeb extends zzne {
    private final /* synthetic */ zzdz zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeb(zzdz zzdzVar, Class cls) {
        super(cls);
        this.zza = zzdzVar;
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzsq.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ void zzb(zzakn zzaknVar) throws GeneralSecurityException {
        zzsq zzsqVar = (zzsq) zzaknVar;
        zzxo.zza(zzsqVar.zza());
        if (zzsqVar.zzd().zza() != 12 && zzsqVar.zzd().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final /* synthetic */ zzakn zza(zzakn zzaknVar) throws GeneralSecurityException {
        zzsq zzsqVar = (zzsq) zzaknVar;
        return (zzsn) ((zzajc) zzsn.zzb().zza(zzahp.zza(zzou.zza(zzsqVar.zza()))).zza(zzsqVar.zzd()).zza(0).zzf());
    }
}
