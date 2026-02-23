package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzht {
    private static final zzif.zza zza = zzif.zza.zzb;
    private static final ThreadLocal zzb = new zzhw();
    private final SecretKey zzc;
    private final boolean zzd;

    public zzht(byte[] bArr, boolean z) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzxo.zza(bArr.length);
        this.zzc = new SecretKeySpec(bArr, "AES");
        this.zzd = z;
    }

    private static AlgorithmParameterSpec zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        Integer zzb2 = zzpf.zzb();
        return (zzb2 == null || zzb2.intValue() > 19) ? new GCMParameterSpec(128, bArr, 0, length) : new IvParameterSpec(bArr, 0, length);
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        if (bArr2.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        boolean z = this.zzd;
        int length = bArr2.length;
        byte[] bArr4 = new byte[z ? length + 28 : length + 16];
        if (z) {
            System.arraycopy(bArr, 0, bArr4, 0, 12);
        }
        AlgorithmParameterSpec zza2 = zza(bArr);
        ThreadLocal threadLocal = zzb;
        ((Cipher) threadLocal.get()).init(1, this.zzc, zza2);
        if (bArr3 != null && bArr3.length != 0) {
            ((Cipher) threadLocal.get()).updateAAD(bArr3);
        }
        int doFinal = ((Cipher) threadLocal.get()).doFinal(bArr2, 0, bArr2.length, bArr4, this.zzd ? 12 : 0);
        if (doFinal == bArr2.length + 16) {
            return bArr4;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - bArr2.length)}));
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        boolean z = this.zzd;
        if (bArr2.length < (z ? 28 : 16)) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (z && !ByteBuffer.wrap(bArr).equals(ByteBuffer.wrap(bArr2, 0, 12))) {
            throw new GeneralSecurityException("iv does not match prepended iv");
        }
        AlgorithmParameterSpec zza2 = zza(bArr);
        ThreadLocal threadLocal = zzb;
        ((Cipher) threadLocal.get()).init(2, this.zzc, zza2);
        if (bArr3 != null && bArr3.length != 0) {
            ((Cipher) threadLocal.get()).updateAAD(bArr3);
        }
        boolean z2 = this.zzd;
        return ((Cipher) threadLocal.get()).doFinal(bArr2, z2 ? 12 : 0, z2 ? bArr2.length - 12 : bArr2.length);
    }
}
