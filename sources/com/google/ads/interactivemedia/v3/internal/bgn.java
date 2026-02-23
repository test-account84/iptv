package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgn extends bqn implements brt {
    private static final bgn a;
    private bgo d;
    private int e;

    static {
        bgn bgnVar = new bgn();
        a = bgnVar;
        bqn.aL(bgn.class, bgnVar);
    }

    private bgn() {
    }

    public static /* synthetic */ bgn b() {
        return a;
    }

    public static bgn c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgn) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void e(bgn bgnVar, bgo bgoVar) {
        bgoVar.getClass();
        bgnVar.d = bgoVar;
    }

    public static /* synthetic */ void f(bgn bgnVar, int i) {
        bgnVar.e = i;
    }

    public static bif g() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.e;
    }

    public final bgo d() {
        bgo bgoVar = this.d;
        return bgoVar == null ? bgo.c() : bgoVar;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"d", "e"});
        }
        if (i2 == 3) {
            return new bgn();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (char[]) null, (byte[]) null, (char[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
