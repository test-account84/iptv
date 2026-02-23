package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzwb implements zzxi {
    private static final zzif.zza zza = zzif.zza.zzb;
    private static final ThreadLocal zzb = new zzwa();
    private final SecretKeySpec zzc;
    private final int zzd;
    private final int zze;

    public zzwb(byte[] bArr, int i) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzxo.zza(bArr.length);
        this.zzc = new SecretKeySpec(bArr, "AES");
        int blockSize = ((Cipher) zzb.get()).getBlockSize();
        this.zze = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzd = i;
    }

    private final void zza(byte[] bArr, int i, int i2, byte[] bArr2, int i3, byte[] bArr3, boolean z) throws GeneralSecurityException {
        Cipher cipher = (Cipher) zzb.get();
        byte[] bArr4 = new byte[this.zze];
        System.arraycopy(bArr3, 0, bArr4, 0, this.zzd);
        cipher.init(z ? 1 : 2, this.zzc, new IvParameterSpec(bArr4));
        if (cipher.doFinal(bArr, i, i2, bArr2, i3) != i2) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }

    public final byte[] zzb(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzd;
        if (length > Integer.MAX_VALUE - i) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (Integer.MAX_VALUE - this.zzd));
        }
        byte[] bArr2 = new byte[bArr.length + i];
        byte[] zza2 = zzou.zza(i);
        System.arraycopy(zza2, 0, bArr2, 0, this.zzd);
        zza(bArr, 0, bArr.length, bArr2, this.zzd, zza2, true);
        return bArr2;
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzd;
        if (length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        int length2 = bArr.length;
        int i2 = this.zzd;
        byte[] bArr3 = new byte[length2 - i2];
        zza(bArr, i2, bArr.length - i2, bArr3, 0, bArr2, false);
        return bArr3;
    }
}
