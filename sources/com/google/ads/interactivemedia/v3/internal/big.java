package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class big extends bqn implements brt {
    private static final big a;
    private int d;
    private bpb e = bpb.b;

    static {
        big bigVar = new big();
        a = bigVar;
        bqn.aL(big.class, bigVar);
    }

    private big() {
    }

    public static bif b() {
        return (bif) a.ay();
    }

    public static /* synthetic */ big c() {
        return a;
    }

    public static big d(bpb bpbVar, bqb bqbVar) throws bqw {
        return (big) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void f(big bigVar, bpb bpbVar) {
        bigVar.e = bpbVar;
    }

    public static /* synthetic */ void g(big bigVar) {
        bigVar.d = 0;
    }

    public final int a() {
        return this.d;
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
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"d", "e"});
        }
        if (i2 == 3) {
            return new big();
        }
        if (i2 == 4) {
            return new bif(null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
