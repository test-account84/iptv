package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhj {
    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 1;
    private static final /* synthetic */ int[] f = {a, b, c, d, e};

    public static /* synthetic */ String a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "CHACHA20_POLY1305" : "AES_256_GCM" : "AES_128_GCM" : "AEAD_UNKNOWN" : "UNRECOGNIZED";
    }

    public static int b(int i) {
        if (i != e) {
            return i - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int c(int i) {
        if (i == 0) {
            return a;
        }
        if (i == 1) {
            return b;
        }
        if (i == 2) {
            return c;
        }
        if (i != 3) {
            return 0;
        }
        return d;
    }

    public static int[] values$ar$edu$5566fcf9_0() {
        return new int[]{a, b, c, d, e};
    }
}
