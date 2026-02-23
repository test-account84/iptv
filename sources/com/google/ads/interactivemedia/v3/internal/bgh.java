package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgh extends bqn implements brt {
    private static final bgh a;
    private int d;
    private bgj e;
    private bhg f;

    static {
        bgh bghVar = new bgh();
        a = bghVar;
        bqn.aL(bgh.class, bghVar);
    }

    private bgh() {
    }

    public static /* synthetic */ bgh b() {
        return a;
    }

    public static bgh c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgh) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void f(bgh bghVar, int i) {
        bghVar.d = i;
    }

    public static /* synthetic */ void g(bgh bghVar, bgj bgjVar) {
        bgjVar.getClass();
        bghVar.e = bgjVar;
    }

    public static /* synthetic */ void h(bgh bghVar, bhg bhgVar) {
        bhgVar.getClass();
        bghVar.f = bhgVar;
    }

    public static bif j() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bgj d() {
        bgj bgjVar = this.e;
        return bgjVar == null ? bgj.c() : bgjVar;
    }

    public final bhg e() {
        bhg bhgVar = this.f;
        return bhgVar == null ? bhg.c() : bhgVar;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new bgh();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (short[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
