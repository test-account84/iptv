package com.google.ads.interactivemedia.v3.internal;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bdr {
    public static final byte[] a = c(1, 0);
    public static final byte[] b = c(2, 32);
    public static final byte[] c = c(2, 16);
    public static final byte[] d = c(2, 17);
    public static final byte[] e = c(2, 18);
    public static final byte[] f = c(2, 1);
    public static final byte[] g = c(2, 2);
    public static final byte[] h = c(2, 3);
    public static final byte[] i = c(2, 1);
    public static final byte[] j = c(2, 2);
    public static final byte[] k = c(2, 3);
    public static final byte[] l = new byte[0];
    private static final byte[] m;
    private static final byte[] n;
    private static final byte[] o;

    static {
        Charset charset = StandardCharsets.UTF_8;
        m = "KEM".getBytes(charset);
        n = "HPKE".getBytes(charset);
        o = "HPKE-v1".getBytes(charset);
    }

    public static void a(bhn bhnVar) throws GeneralSecurityException {
        if (bhnVar.e() == bhl.a || bhnVar.e() == bhl.f) {
            int e2 = bhnVar.e();
            String a2 = bhl.a(e2);
            if (e2 == 0) {
                throw null;
            }
            throw new GeneralSecurityException("Invalid KEM param: ".concat(String.valueOf(a2)));
        }
        if (bhnVar.d() == bhk.a || bhnVar.d() == bhk.e) {
            int d2 = bhnVar.d();
            String a3 = bhk.a(d2);
            if (d2 == 0) {
                throw null;
            }
            throw new GeneralSecurityException("Invalid KDF param: ".concat(String.valueOf(a3)));
        }
        if (bhnVar.c() == bhj.a || bhnVar.c() == bhj.e) {
            int c2 = bhnVar.c();
            String a4 = bhj.a(c2);
            if (c2 == 0) {
                throw null;
            }
            throw new GeneralSecurityException("Invalid AEAD param: ".concat(String.valueOf(a4)));
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return bjh.y(n, bArr, bArr2, bArr3);
    }

    public static byte[] c(int i2, int i3) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) ((i3 >> (((i2 - i4) - 1) * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] d(byte[] bArr) throws GeneralSecurityException {
        return bjh.y(m, bArr);
    }

    public static byte[] e(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return bjh.y(o, bArr2, str.getBytes(StandardCharsets.UTF_8), bArr);
    }

    public static byte[] f(String str, byte[] bArr, byte[] bArr2, int i2) throws GeneralSecurityException {
        return bjh.y(c(2, i2), o, bArr2, str.getBytes(StandardCharsets.UTF_8), bArr);
    }

    public static int g(int i2) throws GeneralSecurityException {
        int i3 = i2 - 2;
        int i4 = bhl.a;
        if (i2 == 0) {
            throw null;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 2;
        }
        if (i3 == 4) {
            return 3;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }
}
