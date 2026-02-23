package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class afy extends bqn implements brt {
    private static final afy a;
    private int d;
    private int e;
    private long f = -1;

    static {
        afy afyVar = new afy();
        a = afyVar;
        bqn.aL(afy.class, afyVar);
    }

    private afy() {
    }

    public static /* synthetic */ afy a() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001", new Object[]{"d", "e", aft.a(), "f"});
        }
        if (i2 == 3) {
            return new afy();
        }
        if (i2 == 4) {
            return new agl((byte[]) null, (short[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
