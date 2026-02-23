package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgf extends bqn implements brt {
    private static final bgf a;
    private int d;
    private bgg e;

    static {
        bgf bgfVar = new bgf();
        a = bgfVar;
        bqn.aL(bgf.class, bgfVar);
    }

    private bgf() {
    }

    public static /* synthetic */ bgf b() {
        return a;
    }

    public static bgf c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgf) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void e(bgf bgfVar, bgg bggVar) {
        bggVar.getClass();
        bgfVar.e = bggVar;
    }

    public static /* synthetic */ void f(bgf bgfVar) {
        bgfVar.d = 32;
    }

    public static bif g() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bgg d() {
        bgg bggVar = this.e;
        return bggVar == null ? bgg.c() : bggVar;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"d", "e"});
        }
        if (i2 == 3) {
            return new bgf();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (char[]) null, (byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
