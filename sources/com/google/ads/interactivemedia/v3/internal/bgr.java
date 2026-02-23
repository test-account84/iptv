package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgr extends bqn implements brt {
    private static final bgr a;
    private int d;
    private bpb e = bpb.b;

    static {
        bgr bgrVar = new bgr();
        a = bgrVar;
        bqn.aL(bgr.class, bgrVar);
    }

    private bgr() {
    }

    public static /* synthetic */ bgr b() {
        return a;
    }

    public static bgr c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgr) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void e(bgr bgrVar, bpb bpbVar) {
        bgrVar.e = bpbVar;
    }

    public static /* synthetic */ void f(bgr bgrVar) {
        bgrVar.d = 0;
    }

    public static bif g() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bpb d() {
        return this.e;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"d", "e"});
        }
        if (i2 == 3) {
            return new bgr();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (char[]) null, (short[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
