package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bim implements azo {
    public static final int a = bch.a;
    private static final ThreadLocal b = new bik();
    private static final ThreadLocal c = new bil();
    private final byte[] d;
    private final byte[] e;
    private final SecretKeySpec f;
    private final int g;

    public bim(byte[] bArr, int i) throws GeneralSecurityException {
        if (!bch.a(a)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.g = i;
        bjg.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f = secretKeySpec;
        Cipher cipher = (Cipher) b.get();
        cipher.init(1, secretKeySpec);
        byte[] b2 = b(cipher.doFinal(new byte[16]));
        this.d = b2;
        this.e = b(b2);
    }

    private static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            byte b2 = bArr[i];
            int i2 = i + 1;
            bArr2[i] = (byte) (((b2 + b2) ^ ((bArr[i2] & 255) >>> 7)) & 255);
            i = i2;
        }
        byte b3 = bArr[15];
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (b3 + b3));
        return bArr2;
    }

    private final byte[] c(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        int length;
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(d(bArr3, this.d));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        int i5 = 0;
        while (i3 - i5 > 16) {
            for (int i6 = 0; i6 < 16; i6++) {
                doFinal[i6] = (byte) (doFinal[i6] ^ bArr[(i2 + i5) + i6]);
            }
            doFinal = cipher.doFinal(doFinal);
            i5 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i5 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = d(copyOfRange, this.d);
        } else {
            byte[] copyOf = Arrays.copyOf(this.e, 16);
            while (true) {
                length = copyOfRange.length;
                if (i4 >= length) {
                    break;
                }
                copyOf[i4] = (byte) (copyOf[i4] ^ copyOfRange[i4]);
                i4++;
            }
            copyOf[length] = (byte) (copyOf[length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(d(doFinal, bArr2));
    }

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.g;
        if (length > 2147483631 - i) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[i + length + 16];
        byte[] b2 = bjf.b(i);
        System.arraycopy(b2, 0, bArr3, 0, this.g);
        Cipher cipher = (Cipher) b.get();
        cipher.init(1, this.f);
        byte[] c2 = c(cipher, 0, b2, 0, b2.length);
        byte[] c3 = c(cipher, 1, bArr2, 0, 0);
        Cipher cipher2 = (Cipher) c.get();
        cipher2.init(1, this.f, new IvParameterSpec(c2));
        cipher2.doFinal(bArr, 0, length, bArr3, this.g);
        byte[] c4 = c(cipher, 2, bArr3, this.g, length);
        int i2 = length + this.g;
        for (int i3 = 0; i3 < 16; i3++) {
            bArr3[i2 + i3] = (byte) ((c3[i3] ^ c2[i3]) ^ c4[i3]);
        }
        return bArr3;
    }
}
