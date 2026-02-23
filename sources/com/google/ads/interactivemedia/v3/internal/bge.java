package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bge extends bqn implements brt {
    private static final bge a;
    private int d;
    private bpb e = bpb.b;
    private bgg f;

    static {
        bge bgeVar = new bge();
        a = bgeVar;
        bqn.aL(bge.class, bgeVar);
    }

    private bge() {
    }

    public static /* synthetic */ bge b() {
        return a;
    }

    public static bge c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bge) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void f(bge bgeVar, bpb bpbVar) {
        bgeVar.e = bpbVar;
    }

    public static /* synthetic */ void g(bge bgeVar, bgg bggVar) {
        bggVar.getClass();
        bgeVar.f = bggVar;
    }

    public static /* synthetic */ void h(bge bgeVar) {
        bgeVar.d = 0;
    }

    public static bif j() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bgg d() {
        bgg bggVar = this.f;
        return bggVar == null ? bgg.c() : bggVar;
    }

    public final bpb e() {
        return this.e;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new bge();
        }
        if (i2 == 4) {
            return new bif(null, null, null, null, null, null, null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
