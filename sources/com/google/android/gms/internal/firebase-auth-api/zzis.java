package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzis extends zzne {
    private final /* synthetic */ zzin zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzis(zzin zzinVar, Class cls) {
        super(cls);
        this.zza = zzinVar;
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zztd.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ void zzb(zzakn zzaknVar) throws GeneralSecurityException {
        zztd zztdVar = (zztd) zzaknVar;
        if (zztdVar.zza() == 64) {
            return;
        }
        throw new InvalidAlgorithmParameterException("invalid key size: " + zztdVar.zza() + ". Valid keys must have 64 bytes.");
    }

    public final /* synthetic */ zzakn zza(zzakn zzaknVar) throws GeneralSecurityException {
        return (zztc) ((zzajc) zztc.zzb().zza(zzahp.zza(zzou.zza(((zztd) zzaknVar).zza()))).zza(zzin.zza()).zzf());
    }
}
