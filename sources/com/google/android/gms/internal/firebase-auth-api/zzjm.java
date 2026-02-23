package com.google.android.gms.internal.firebase-auth-api;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzjm extends zzoh {
    public zzjm(Class cls) {
        super(cls);
    }

    public final /* synthetic */ Object zza(zzakn zzaknVar) throws GeneralSecurityException {
        zztu zztuVar = (zztu) zzaknVar;
        zztq zzb = zztuVar.zzb();
        zztv zzf = zzb.zzf();
        zzwo zza = zzkx.zza(zzf.zzd());
        byte[] zzg = zztuVar.zzf().zzg();
        byte[] zzg2 = zztuVar.zzg().zzg();
        ECParameterSpec zza2 = zzwp.zza(zza);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, zzg), new BigInteger(1, zzg2));
        zzmg.zza(eCPoint, zza2.getCurve());
        return new zzwk(((KeyFactory) zzwt.zze.zza("EC")).generatePublic(new ECPublicKeySpec(eCPoint, zza2)), zzf.zzf().zzg(), zzkx.zza(zzf.zze()), zzkx.zza(zzb.zza()), new zzkz(zzb.zzb().zzd()));
    }
}
