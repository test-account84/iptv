package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bio implements azr {
    public static final int a = bch.a;
    private static final Collection b = Arrays.asList(new Integer[]{64});
    private static final byte[] c = new byte[16];
    private final bja d;
    private final byte[] e;

    public bio(byte[] bArr) throws GeneralSecurityException {
        if (!bch.a(a)) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        Collection collection = b;
        int length = bArr.length;
        if (collection.contains(Integer.valueOf(length))) {
            int i = length >> 1;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, i);
            this.e = Arrays.copyOfRange(bArr, i, length);
            this.d = new bja(copyOfRange);
            return;
        }
        throw new InvalidKeyException("invalid key size: " + length + " bytes; key must have 64 bytes");
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] z;
        if (bArr.length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher cipher = (Cipher) biv.a.a("AES/CTR/NoPadding");
        byte[][] bArr3 = {bArr2, bArr};
        byte[] a2 = this.d.a(c, 16);
        for (int i = 0; i <= 0; i++) {
            byte[] bArr4 = bArr3[i];
            if (bArr4 == null) {
                bArr4 = new byte[0];
            }
            a2 = bjh.z(com.google.ads.interactivemedia.v3.impl.data.ag.b(a2), this.d.a(bArr4, 16));
        }
        byte[] bArr5 = bArr3[1];
        int length = bArr5.length;
        if (length >= 16) {
            int length2 = a2.length;
            if (length < length2) {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
            int i2 = length - length2;
            z = Arrays.copyOf(bArr5, length);
            for (int i3 = 0; i3 < a2.length; i3++) {
                int i4 = i2 + i3;
                z[i4] = (byte) (z[i4] ^ a2[i3]);
            }
        } else {
            z = bjh.z(com.google.ads.interactivemedia.v3.impl.data.ag.a(bArr5), com.google.ads.interactivemedia.v3.impl.data.ag.b(a2));
        }
        byte[] a3 = this.d.a(z, 16);
        byte[] bArr6 = (byte[]) a3.clone();
        bArr6[8] = (byte) (bArr6[8] & Byte.MAX_VALUE);
        bArr6[12] = (byte) (bArr6[12] & Byte.MAX_VALUE);
        cipher.init(1, new SecretKeySpec(this.e, "AES"), new IvParameterSpec(bArr6));
        return bjh.y(a3, cipher.doFinal(bArr));
    }
}
