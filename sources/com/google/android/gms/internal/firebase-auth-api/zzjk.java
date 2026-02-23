package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzjk extends zzne {
    private final /* synthetic */ zzji zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjk(zzji zzjiVar, Class cls) {
        super(cls);
        this.zza = zzjiVar;
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zztn.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ void zzb(zzakn zzaknVar) throws GeneralSecurityException {
        zzkx.zza(((zztn) zzaknVar).zzc());
    }

    public final /* synthetic */ zzakn zza(zzakn zzaknVar) throws GeneralSecurityException {
        zztn zztnVar = (zztn) zzaknVar;
        ECParameterSpec zza = zzwp.zza(zzkx.zza(zztnVar.zzc().zzf().zzd()));
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzwt.zzd.zza("EC");
        keyPairGenerator.initialize(zza);
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        ECPublicKey eCPublicKey = generateKeyPair.getPublic();
        ECPrivateKey eCPrivateKey = generateKeyPair.getPrivate();
        ECPoint w = eCPublicKey.getW();
        return (zztr) ((zzajc) zztr.zzb().zza(0).zza((zztu) ((zzajc) zztu.zzc().zza(0).zza(zztnVar.zzc()).zza(zzahp.zza(w.getAffineX().toByteArray())).zzb(zzahp.zza(w.getAffineY().toByteArray())).zzf())).zza(zzahp.zza(eCPrivateKey.getS().toByteArray())).zzf());
    }
}
