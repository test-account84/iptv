package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bty extends bqn implements brt {
    private static final bty a;
    private int d;
    private int e;
    private String f = "*";

    static {
        bty btyVar = new bty();
        a = btyVar;
        bqn.aL(bty.class, btyVar);
    }

    private bty() {
    }

    public static /* synthetic */ bty c() {
        return a;
    }

    public static bty e() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001", new Object[]{"d", "e", btz.a(), "f"});
        }
        if (i2 == 3) {
            return new bty();
        }
        if (i2 == 4) {
            return new bub((byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
