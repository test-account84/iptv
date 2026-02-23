package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzie implements zzbg {
    private static final ThreadLocal zza = new zzid();
    private static final boolean zzb = zza();
    private final SecretKey zzc;
    private final byte[] zzd;

    public zzie(byte[] bArr) throws GeneralSecurityException {
        this(bArr, new byte[0]);
    }

    private static AlgorithmParameterSpec zza(byte[] bArr, int i, int i2) throws GeneralSecurityException {
        if (zzb) {
            return new GCMParameterSpec(128, bArr, 0, i2);
        }
        if (zzxp.zza()) {
            return new IvParameterSpec(bArr, 0, i2);
        }
        throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec zza2 = zza(bArr, 0, 12);
        ThreadLocal threadLocal = zza;
        ((Cipher) threadLocal.get()).init(2, this.zzc, zza2);
        if (bArr2 != null && bArr2.length != 0) {
            ((Cipher) threadLocal.get()).updateAAD(bArr2);
        }
        return ((Cipher) threadLocal.get()).doFinal(bArr, 12, bArr.length - 12);
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 28];
        byte[] zza2 = zzou.zza(12);
        System.arraycopy(zza2, 0, bArr3, 0, 12);
        AlgorithmParameterSpec zza3 = zza(zza2, 0, zza2.length);
        ThreadLocal threadLocal = zza;
        ((Cipher) threadLocal.get()).init(1, this.zzc, zza3);
        if (bArr2 != null && bArr2.length != 0) {
            ((Cipher) threadLocal.get()).updateAAD(bArr2);
        }
        int doFinal = ((Cipher) threadLocal.get()).doFinal(bArr, 0, bArr.length, bArr3, 12);
        if (doFinal != bArr.length + 16) {
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - bArr.length)}));
        }
        byte[] bArr4 = this.zzd;
        return bArr4.length == 0 ? bArr3 : zzwg.zza(bArr4, bArr3);
    }

    private zzie(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.zzd = bArr2;
        zzxo.zza(bArr.length);
        this.zzc = new SecretKeySpec(bArr, "AES");
    }

    private static boolean zza() {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzd;
        if (bArr3.length == 0) {
            return zzc(bArr, bArr2);
        }
        if (zzpf.zza(bArr3, bArr)) {
            return zzc(Arrays.copyOfRange(bArr, this.zzd.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }
}
