package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class afw extends bqn implements brt {
    private static final afw a;
    private int d;
    private long e = -1;

    static {
        afw afwVar = new afw();
        a = afwVar;
        bqn.aL(afw.class, afwVar);
    }

    private afw() {
    }

    public static /* synthetic */ afw a() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဂ\u0000", new Object[]{"d", "e"});
        }
        if (i2 == 3) {
            return new afw();
        }
        if (i2 == 4) {
            return new agl((byte[]) null, (char[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
