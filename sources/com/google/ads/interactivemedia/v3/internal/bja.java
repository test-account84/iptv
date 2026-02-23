package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bja implements bgd {
    public static final int a = bch.a;
    private final SecretKey b;
    private byte[] c;
    private byte[] d;

    public bja(byte[] bArr) throws GeneralSecurityException {
        bjg.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.b = secretKeySpec;
        Cipher b = b();
        b.init(1, secretKeySpec);
        byte[] b2 = com.google.ads.interactivemedia.v3.impl.data.ag.b(b.doFinal(new byte[16]));
        this.c = b2;
        this.d = com.google.ads.interactivemedia.v3.impl.data.ag.b(b2);
    }

    private static Cipher b() throws GeneralSecurityException {
        if (bch.a(a)) {
            return (Cipher) biv.a.a("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    public final byte[] a(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        Cipher b = b();
        b.init(1, this.b);
        int length = bArr.length;
        int max = Math.max(1, (int) Math.ceil(length / 16.0d));
        byte[] A = max * 16 == length ? bjh.A(bArr, (max - 1) * 16, this.c, 0, 16) : bjh.z(com.google.ads.interactivemedia.v3.impl.data.ag.a(Arrays.copyOfRange(bArr, (max - 1) * 16, length)), this.d);
        byte[] bArr2 = new byte[16];
        for (int i2 = 0; i2 < max - 1; i2++) {
            bArr2 = b.doFinal(bjh.A(bArr2, 0, bArr, i2 * 16, 16));
        }
        return Arrays.copyOf(b.doFinal(bjh.z(A, bArr2)), i);
    }
}
