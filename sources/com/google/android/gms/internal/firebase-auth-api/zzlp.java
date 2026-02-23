package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzlp extends zzne {
    private final /* synthetic */ zzln zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzlp(zzln zzlnVar, Class cls) {
        super(cls);
        this.zza = zzlnVar;
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzuq.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ void zzb(zzakn zzaknVar) throws GeneralSecurityException {
        zzlt.zza(((zzuq) zzaknVar).zzc());
    }

    public final /* synthetic */ zzakn zza(zzakn zzaknVar) throws GeneralSecurityException {
        byte[] zza;
        byte[] zza2;
        zzuq zzuqVar = (zzuq) zzaknVar;
        zzuo zzc = zzuqVar.zzc().zzc();
        int i = zzlo.zza[zzc.ordinal()];
        if (i != 1) {
            if (i != 2 && i != 3 && i != 4) {
                throw new GeneralSecurityException("Invalid KEM");
            }
            zzwo zzc2 = zzlt.zzc(zzuqVar.zzc().zzc());
            ECParameterSpec zza3 = zzwp.zza(zzc2);
            KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzwt.zzd.zza("EC");
            keyPairGenerator.initialize(zza3);
            KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
            zzwr zzwrVar = zzwr.UNCOMPRESSED;
            ECPoint w = generateKeyPair.getPublic().getW();
            EllipticCurve curve = zzwp.zza(zzc2).getCurve();
            zzmg.zza(w, curve);
            int zza4 = zzwp.zza(curve);
            int ordinal = zzwrVar.ordinal();
            if (ordinal == 0) {
                int i2 = (zza4 * 2) + 1;
                byte[] bArr = new byte[i2];
                byte[] zza5 = zzme.zza(w.getAffineX());
                byte[] zza6 = zzme.zza(w.getAffineY());
                System.arraycopy(zza6, 0, bArr, i2 - zza6.length, zza6.length);
                System.arraycopy(zza5, 0, bArr, (zza4 + 1) - zza5.length, zza5.length);
                bArr[0] = 4;
                zza2 = bArr;
            } else if (ordinal == 1) {
                int i3 = zza4 + 1;
                zza2 = new byte[i3];
                byte[] zza7 = zzme.zza(w.getAffineX());
                System.arraycopy(zza7, 0, zza2, i3 - zza7.length, zza7.length);
                zza2[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
            } else {
                if (ordinal != 2) {
                    throw new GeneralSecurityException("invalid format:" + String.valueOf(zzwrVar));
                }
                int i4 = zza4 * 2;
                zza2 = new byte[i4];
                byte[] zza8 = zzme.zza(w.getAffineX());
                if (zza8.length > zza4) {
                    zza8 = Arrays.copyOfRange(zza8, zza8.length - zza4, zza8.length);
                }
                byte[] zza9 = zzme.zza(w.getAffineY());
                if (zza9.length > zza4) {
                    zza9 = Arrays.copyOfRange(zza9, zza9.length - zza4, zza9.length);
                }
                System.arraycopy(zza9, 0, zza2, i4 - zza9.length, zza9.length);
                System.arraycopy(zza8, 0, zza2, zza4 - zza8.length, zza8.length);
            }
            zza = zzme.zza(generateKeyPair.getPrivate().getS(), zzlt.zza(zzc));
        } else {
            zza = zzou.zza(32);
            zza[0] = (byte) (zza[0] | 7);
            byte b = (byte) (zza[31] & 63);
            zza[31] = b;
            zza[31] = (byte) (b | 128);
            zza2 = zzxr.zza(zza);
        }
        return (zzuu) ((zzajc) zzuu.zzb().zza(0).zza((zzuv) ((zzajc) zzuv.zzc().zza(0).zza(zzuqVar.zzc()).zza(zzahp.zza(zza2)).zzf())).zza(zzahp.zza(zza)).zzf());
    }
}
