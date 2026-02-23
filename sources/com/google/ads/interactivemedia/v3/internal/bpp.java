package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bpp extends bqn implements brt {
    private static final bpp a;
    private int d;
    private String e = "";
    private String f = "";

    static {
        bpp bppVar = new bpp();
        a = bppVar;
        bqn.aL(bpp.class, bppVar);
    }

    private bpp() {
    }

    public static /* synthetic */ bpp c() {
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
            return new bpp();
        }
        if (i2 == 4) {
            return new bpv((byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
