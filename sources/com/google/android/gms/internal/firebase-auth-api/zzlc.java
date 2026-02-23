package com.google.android.gms.internal.firebase-auth-api;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzlc {
    private static final byte[] zza = new byte[0];
    private final zzld zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private BigInteger zzg = BigInteger.ZERO;

    private zzlc(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zzld zzldVar) {
        this.zzf = bArr;
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zzldVar;
    }

    public static zzlc zza(byte[] bArr, zzll zzllVar, zzlj zzljVar, zzlg zzlgVar, zzld zzldVar, byte[] bArr2) throws GeneralSecurityException {
        byte[] zza2 = zzljVar.zza(bArr, zzllVar);
        byte[] zza3 = zzlt.zza(zzljVar.zza(), zzlgVar.zzb(), zzldVar.zzc());
        byte[] bArr3 = zzlt.zzl;
        byte[] bArr4 = zza;
        byte[] zza4 = zzwg.zza(zzlt.zza, zzlgVar.zza(bArr3, bArr4, "psk_id_hash", zza3), zzlgVar.zza(bArr3, bArr2, "info_hash", zza3));
        byte[] zza5 = zzlgVar.zza(zza2, bArr4, "secret", zza3);
        byte[] zza6 = zzlgVar.zza(zza5, zza4, "key", zza3, zzldVar.zza());
        byte[] zza7 = zzlgVar.zza(zza5, zza4, "base_nonce", zza3, zzldVar.zzb());
        zzldVar.zzb();
        BigInteger bigInteger = BigInteger.ONE;
        return new zzlc(bArr, zza6, zza7, bigInteger.shiftLeft(96).subtract(bigInteger), zzldVar);
    }

    private final synchronized byte[] zza() throws GeneralSecurityException {
        byte[] zza2;
        zza2 = zzwg.zza(this.zze, zzme.zza(this.zzg, this.zzb.zzb()));
        if (this.zzg.compareTo(this.zzc) >= 0) {
            throw new GeneralSecurityException("message limit reached");
        }
        this.zzg = this.zzg.add(BigInteger.ONE);
        return zza2;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zza(this.zzd, zza(), bArr, bArr2);
    }
}
