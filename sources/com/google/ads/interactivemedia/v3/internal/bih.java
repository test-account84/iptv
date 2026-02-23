package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bih extends bqn implements brt {
    private static final bih a;
    private int d;

    static {
        bih bihVar = new bih();
        a = bihVar;
        bqn.aL(bih.class, bihVar);
    }

    private bih() {
    }

    public static /* synthetic */ bih a() {
        return a;
    }

    public static bih b() {
        return a;
    }

    public static bih c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bih) bqn.aC(a, bpbVar, bqbVar);
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"d"});
        }
        if (i2 == 3) {
            return new bih();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[][]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
