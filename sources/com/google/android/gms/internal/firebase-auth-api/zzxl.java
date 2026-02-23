package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzxl implements zzrx {
    private static final zzif.zza zza = zzif.zza.zza;
    private final SecretKey zzb;
    private byte[] zzc;
    private byte[] zzd;

    public zzxl(byte[] bArr) throws GeneralSecurityException {
        zzxo.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzb = secretKeySpec;
        Cipher zza2 = zza();
        zza2.init(1, secretKeySpec);
        byte[] zzb = zzrd.zzb(zza2.doFinal(new byte[16]));
        this.zzc = zzb;
        this.zzd = zzrd.zzb(zzb);
    }

    private static Cipher zza() throws GeneralSecurityException {
        if (zza.zza()) {
            return (Cipher) zzwt.zza.zza("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        Cipher zza2 = zza();
        zza2.init(1, this.zzb);
        int max = Math.max(1, (int) Math.ceil(bArr.length / 16.0d));
        byte[] zza3 = (max << 4) == bArr.length ? zzwg.zza(bArr, (max - 1) << 4, this.zzc, 0, 16) : zzwg.zza(zzrd.zza(Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length)), this.zzd);
        byte[] bArr2 = new byte[16];
        for (int i2 = 0; i2 < max - 1; i2++) {
            bArr2 = zza2.doFinal(zzwg.zza(bArr2, 0, bArr, i2 << 4, 16));
        }
        return Arrays.copyOf(zza2.doFinal(zzwg.zza(zza3, bArr2)), i);
    }
}
