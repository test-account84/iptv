package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzwd implements zzbg {
    private static final zzif.zza zza = zzif.zza.zza;
    private static final ThreadLocal zzb = new zzwc();
    private static final ThreadLocal zzc = new zzwf();
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private final SecretKeySpec zzg;
    private final int zzh;

    public zzwd(byte[] bArr, int i) throws GeneralSecurityException {
        this(bArr, i, new byte[0]);
    }

    private final byte[] zza(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(zzd(bArr3, this.zzd));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                doFinal[i5] = (byte) (doFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            doFinal = cipher.doFinal(doFinal);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = zzd(copyOfRange, this.zzd);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zze, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zzd(doFinal, bArr2));
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = (bArr.length - this.zzh) - 16;
        if (length < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        Cipher cipher = (Cipher) zzb.get();
        cipher.init(1, this.zzg);
        byte[] zza2 = zza(cipher, 0, bArr, 0, this.zzh);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr3 = bArr2;
        byte[] zza3 = zza(cipher, 1, bArr3, 0, bArr3.length);
        byte[] zza4 = zza(cipher, 2, bArr, this.zzh, length);
        int length2 = bArr.length - 16;
        byte b = 0;
        for (int i = 0; i < 16; i++) {
            b = (byte) (b | (((bArr[length2 + i] ^ zza3[i]) ^ zza2[i]) ^ zza4[i]));
        }
        if (b != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = (Cipher) zzc.get();
        cipher2.init(1, this.zzg, new IvParameterSpec(zza2));
        return cipher2.doFinal(bArr, this.zzh, length);
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzh;
        if (length > 2147483631 - i) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + i + 16];
        byte[] zza2 = zzou.zza(i);
        System.arraycopy(zza2, 0, bArr3, 0, this.zzh);
        Cipher cipher = (Cipher) zzb.get();
        cipher.init(1, this.zzg);
        byte[] zza3 = zza(cipher, 0, zza2, 0, zza2.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] zza4 = zza(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = (Cipher) zzc.get();
        cipher2.init(1, this.zzg, new IvParameterSpec(zza3));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.zzh);
        byte[] zza5 = zza(cipher, 2, bArr3, this.zzh, bArr.length);
        int length2 = bArr.length + this.zzh;
        for (int i2 = 0; i2 < 16; i2++) {
            bArr3[length2 + i2] = (byte) ((zza4[i2] ^ zza3[i2]) ^ zza5[i2]);
        }
        byte[] bArr5 = this.zzf;
        return bArr5.length == 0 ? bArr3 : zzwg.zza(bArr5, bArr3);
    }

    private zzwd(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzh = i;
        zzxo.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzg = secretKeySpec;
        Cipher cipher = (Cipher) zzb.get();
        cipher.init(1, secretKeySpec);
        byte[] zza2 = zza(cipher.doFinal(new byte[16]));
        this.zzd = zza2;
        this.zze = zza(zza2);
        this.zzf = bArr2;
    }

    private static byte[] zza(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i2 = i + 1;
            bArr2[i] = (byte) ((bArr[i] << 1) ^ ((bArr[i2] & 255) >>> 7));
            i = i2;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzf;
        if (bArr3.length == 0) {
            return zzc(bArr, bArr2);
        }
        if (zzpf.zza(bArr3, bArr)) {
            return zzc(Arrays.copyOfRange(bArr, this.zzf.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }
}
