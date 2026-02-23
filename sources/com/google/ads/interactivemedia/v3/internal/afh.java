package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class afh extends bqn implements brt {
    private static final afh a;
    private int d;
    private String e = "";
    private String f = "";

    static {
        afh afhVar = new afh();
        a = afhVar;
        bqn.aL(afh.class, afhVar);
    }

    private afh() {
    }

    public static /* synthetic */ afh a() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new afh();
        }
        if (i2 == 4) {
            return new afl((byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
