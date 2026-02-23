package com.google.ads.interactivemedia.v3.internal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bdg {
    private static final byte[] a = new byte[0];
    private final bdf b;
    private final BigInteger c;
    private final byte[] d;
    private final byte[] e;
    private final byte[] f;
    private BigInteger g = BigInteger.ZERO;

    private bdg(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, bdf bdfVar) {
        this.f = bArr;
        this.d = bArr2;
        this.e = bArr3;
        this.c = bigInteger;
        this.b = bdfVar;
    }

    public static bdg c(byte[] bArr, byte[] bArr2, bdj bdjVar, bde bdeVar, bdf bdfVar, byte[] bArr3) throws GeneralSecurityException {
        byte[] b = bdr.b(bdjVar.b(), bdeVar.b(), bdfVar.b());
        byte[] bArr4 = bdr.l;
        byte[] bArr5 = a;
        byte[] y = bjh.y(bdr.a, bdeVar.d(bArr4, bArr5, "psk_id_hash", b), bdeVar.d(bArr4, bArr3, "info_hash", b));
        byte[] d = bdeVar.d(bArr2, bArr5, "secret", b);
        byte[] c = bdeVar.c(d, y, "key", b, bdfVar.a());
        byte[] c2 = bdeVar.c(d, y, "base_nonce", b, 12);
        BigInteger bigInteger = BigInteger.ONE;
        return new bdg(bArr, c, c2, bigInteger.shiftLeft(96).subtract(bigInteger), bdfVar);
    }

    private final synchronized byte[] d() throws GeneralSecurityException {
        byte[] z;
        try {
            byte[] bArr = this.e;
            byte[] byteArray = this.g.toByteArray();
            int length = byteArray.length;
            if (length != 12) {
                if (length > 13) {
                    throw new GeneralSecurityException("integer too large");
                }
                if (length != 13) {
                    byte[] bArr2 = new byte[12];
                    System.arraycopy(byteArray, 0, bArr2, 12 - length, length);
                    byteArray = bArr2;
                } else {
                    if (byteArray[0] != 0) {
                        throw new GeneralSecurityException("integer too large");
                    }
                    byteArray = Arrays.copyOfRange(byteArray, 1, 13);
                }
            }
            z = bjh.z(bArr, byteArray);
            if (this.g.compareTo(this.c) >= 0) {
                throw new GeneralSecurityException("message limit reached");
            }
            this.g = this.g.add(BigInteger.ONE);
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    public final byte[] a() {
        return this.f;
    }

    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.b.c(this.d, d(), bArr, bArr2);
    }
}
