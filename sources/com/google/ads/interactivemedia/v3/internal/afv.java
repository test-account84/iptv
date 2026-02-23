package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class afv extends bqn implements brt {
    private static final afv a;
    private int d;
    private long e = -1;
    private int f = 1000;
    private int g = 1000;

    static {
        afv afvVar = new afv();
        a = afvVar;
        bqn.aL(afv.class, afvVar);
    }

    private afv() {
    }

    public static /* synthetic */ afv a() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဌ\u0001\u0003ဌ\u0002", new Object[]{"d", "e", "f", agh.a(), "g", agh.a()});
        }
        if (i2 == 3) {
            return new afv();
        }
        if (i2 == 4) {
            return new agl((byte[]) null, (char[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
