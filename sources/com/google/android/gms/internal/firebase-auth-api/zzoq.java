package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzoq extends zzmo implements zzco {
    private final zzop zza;
    private final zznb zzb;

    public zzoq(zzop zzopVar, zznb zznbVar, Class cls) {
        super(zzopVar, cls);
        this.zza = zzopVar;
        this.zzb = zznbVar;
    }

    public final zzuy zzc(zzahp zzahpVar) throws GeneralSecurityException {
        try {
            zzakn zza = this.zza.zza(zzahpVar);
            this.zza.zza(zza);
            zzakn zzb = this.zza.zzb(zza);
            this.zzb.zza(zzb);
            return (zzuy) ((zzajc) zzuy.zza().zza(this.zzb.zze()).zza(zzb.zzi()).zza(this.zzb.zzd()).zzf());
        } catch (zzaji e) {
            throw new GeneralSecurityException("expected serialized proto of type ", e);
        }
    }
}
