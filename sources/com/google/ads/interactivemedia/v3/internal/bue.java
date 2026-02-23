package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bue extends bqn implements brt {
    private static final bue a;
    private bqs d = bqn.aE();

    static {
        bue bueVar = new bue();
        a = bueVar;
        bqn.aL(bue.class, bueVar);
    }

    private bue() {
    }

    public static /* synthetic */ bue c() {
        return a;
    }

    public static bue e() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"d", bui.b()});
        }
        if (i2 == 3) {
            return new bue();
        }
        if (i2 == 4) {
            return new bub((byte[]) null, (short[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
