package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhe {
    public static final int a = 2;
    public static final int b = 4;
    public static final int c = 5;
    public static final int d = 6;
    public static final int e = 7;
    public static final int f = 1;
    private static final /* synthetic */ int[] g = {a, b, c, d, e, f};

    public static int a(int i) {
        if (i != f) {
            return i - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int b(int i) {
        if (i == 0) {
            return a;
        }
        if (i == 2) {
            return b;
        }
        if (i == 3) {
            return c;
        }
        if (i == 4) {
            return d;
        }
        if (i != 5) {
            return 0;
        }
        return e;
    }

    public static String toString$ar$edu$a53f9db7_0(int i) {
        return Integer.toString(a(i));
    }

    public static int[] values$ar$edu$1f5331ac_0() {
        return new int[]{a, b, c, d, e, f};
    }
}
