package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgq extends bqn implements brt {
    private static final bgq a;
    private int d;
    private int e;

    static {
        bgq bgqVar = new bgq();
        a = bgqVar;
        bqn.aL(bgq.class, bgqVar);
    }

    private bgq() {
    }

    public static /* synthetic */ bgq b() {
        return a;
    }

    public static bgq c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgq) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void d(bgq bgqVar, int i) {
        bgqVar.d = i;
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
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"d", "e"});
        }
        if (i2 == 3) {
            return new bgq();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (byte[]) null, (short[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
