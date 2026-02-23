package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgl extends bqn implements brt {
    private static final bgl a;
    private int d;

    static {
        bgl bglVar = new bgl();
        a = bglVar;
        bqn.aL(bgl.class, bglVar);
    }

    private bgl() {
    }

    public static /* synthetic */ bgl b() {
        return a;
    }

    public static bgl c() {
        return a;
    }

    public static /* synthetic */ void d(bgl bglVar) {
        bglVar.d = 16;
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
            return new bgl();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (int[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
