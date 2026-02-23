package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgs extends bqn implements brt {
    private static final bgs a;
    private int d;
    private int e;

    static {
        bgs bgsVar = new bgs();
        a = bgsVar;
        bqn.aL(bgs.class, bgsVar);
    }

    private bgs() {
    }

    public static /* synthetic */ bgs b() {
        return a;
    }

    public static bgs c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgs) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void d(bgs bgsVar, int i) {
        bgsVar.d = i;
    }

    public static bif e() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"e", "d"});
        }
        if (i2 == 3) {
            return new bgs();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (int[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
