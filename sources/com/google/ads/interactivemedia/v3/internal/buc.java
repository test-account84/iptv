package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class buc extends bqn implements brt {
    private static final buc a;
    private bqs d = bqn.aE();

    static {
        buc bucVar = new buc();
        a = bucVar;
        bqn.aL(buc.class, bucVar);
    }

    private buc() {
    }

    public static /* synthetic */ buc c() {
        return a;
    }

    public static buc e() {
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
            return new buc();
        }
        if (i2 == 4) {
            return new bub(null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
