package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class btr extends bqn implements brt {
    private static final btr a;
    private bqt d = bqn.aF();
    private bqs e = bqn.aE();
    private bqs f = bqn.aE();

    static {
        btr btrVar = new btr();
        a = btrVar;
        bqn.aL(btr.class, btrVar);
    }

    private btr() {
    }

    public static /* synthetic */ btr c() {
        return a;
    }

    public static btr e() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0003\u0000\u0000\u0001\u0005\u0003\u0000\u0003\u0000\u0001\u001a\u0002\u001e\u0005,", new Object[]{"d", "e", btv.a(), "f", btx.a()});
        }
        if (i2 == 3) {
            return new btr();
        }
        if (i2 == 4) {
            return new bts(null, null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
