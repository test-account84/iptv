package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bud extends bqn implements brt {
    private static final bud a;
    private int d;
    private boolean e;
    private boolean f;

    static {
        bud budVar = new bud();
        a = budVar;
        bqn.aL(bud.class, budVar);
    }

    private bud() {
    }

    public static /* synthetic */ bud c() {
        return a;
    }

    public static bud e() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new bud();
        }
        if (i2 == 4) {
            return new bub((byte[]) null, (char[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
