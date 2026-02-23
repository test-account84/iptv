package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bqu {
    static final Charset a;
    public static final byte[] b;
    public static final ByteBuffer c;

    static {
        Charset.forName("US-ASCII");
        a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        c = ByteBuffer.wrap(bArr);
        bpg.H(bArr, 0, 0, false);
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        int d = d(length, bArr, 0, length);
        if (d == 0) {
            return 1;
        }
        return d;
    }

    public static int c(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int d(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static Object e(Object obj, Object obj2) {
        return ((brs) obj).bq().aS((brs) obj2).aZ();
    }

    public static String f(byte[] bArr) {
        return new String(bArr, a);
    }

    public static boolean g(brs brsVar) {
        if (brsVar instanceof boo) {
            throw null;
        }
        return false;
    }

    public static boolean h(byte[] bArr) {
        return btj.i(bArr);
    }

    public static void i(Object obj) {
        obj.getClass();
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }
}
