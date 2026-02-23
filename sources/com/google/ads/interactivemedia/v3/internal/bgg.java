package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgg extends bqn implements brt {
    private static final bgg a;
    private int d;

    static {
        bgg bggVar = new bgg();
        a = bggVar;
        bqn.aL(bgg.class, bggVar);
    }

    private bgg() {
    }

    public static /* synthetic */ bgg b() {
        return a;
    }

    public static bgg c() {
        return a;
    }

    public static /* synthetic */ void d(bgg bggVar) {
        bggVar.d = 16;
    }

    public static bif e() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"d"});
        }
        if (i2 == 3) {
            return new bgg();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (char[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
