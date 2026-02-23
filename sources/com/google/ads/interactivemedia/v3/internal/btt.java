package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class btt extends bqn implements brt {
    private static final btt a;
    private bqt d = bqn.aF();
    private bqs e = bqn.aE();
    private bqs f = bqn.aE();
    private bqs g = bqn.aE();
    private bqt h = bqn.aF();

    static {
        btt bttVar = new btt();
        a = bttVar;
        bqn.aL(btt.class, bttVar);
    }

    private btt() {
    }

    public static /* synthetic */ btt c() {
        return a;
    }

    public static btt e() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0005\u0000\u0001\u001a\u0002\u001e\u0003\u0016\u0004\u001a\u0005,", new Object[]{"d", "e", btv.a(), "g", "h", "f", btx.a()});
        }
        if (i2 == 3) {
            return new btt();
        }
        if (i2 == 4) {
            return new bts(null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
