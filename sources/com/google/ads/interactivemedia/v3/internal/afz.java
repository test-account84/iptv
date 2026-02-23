package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class afz extends bqn implements brt {
    private static final afz a;
    private int d;
    private long e = -1;
    private int f = 1000;

    static {
        afz afzVar = new afz();
        a = afzVar;
        bqn.aL(afz.class, afzVar);
    }

    private afz() {
    }

    public static /* synthetic */ afz a() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဌ\u0001", new Object[]{"d", "e", "f", agh.a()});
        }
        if (i2 == 3) {
            return new afz();
        }
        if (i2 == 4) {
            return new agl((byte[]) null, (int[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
