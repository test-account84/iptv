package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bij implements biz {
    public static final int a = bch.b;
    private static final ThreadLocal b = new bii();
    private final SecretKeySpec c;
    private final int d;
    private final int e;

    public bij(byte[] bArr, int i) throws GeneralSecurityException {
        if (!bch.a(a)) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        bjg.a(bArr.length);
        this.c = new SecretKeySpec(bArr, "AES");
        int blockSize = ((Cipher) b.get()).getBlockSize();
        this.e = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.d = i;
    }

    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.d;
        if (length > Integer.MAX_VALUE - i) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (Integer.MAX_VALUE - this.d));
        }
        byte[] bArr2 = new byte[i + length];
        byte[] b2 = bjf.b(i);
        System.arraycopy(b2, 0, bArr2, 0, this.d);
        int i2 = this.d;
        Cipher cipher = (Cipher) b.get();
        byte[] bArr3 = new byte[this.e];
        System.arraycopy(b2, 0, bArr3, 0, this.d);
        cipher.init(1, this.c, new IvParameterSpec(bArr3));
        if (cipher.doFinal(bArr, 0, length, bArr2, i2) == length) {
            return bArr2;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
