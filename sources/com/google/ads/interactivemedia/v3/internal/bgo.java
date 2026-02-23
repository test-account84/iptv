package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgo extends bqn implements brt {
    private static final bgo a;
    private int d;

    static {
        bgo bgoVar = new bgo();
        a = bgoVar;
        bqn.aL(bgo.class, bgoVar);
    }

    private bgo() {
    }

    public static /* synthetic */ bgo b() {
        return a;
    }

    public static bgo c() {
        return a;
    }

    public static /* synthetic */ void d(bgo bgoVar) {
        bgoVar.d = 16;
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
            return new bgo();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (char[]) null, (char[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
