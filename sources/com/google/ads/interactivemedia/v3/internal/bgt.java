package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgt extends bqn implements brt {
    private static final bgt a;
    private int d;
    private bpb e = bpb.b;

    static {
        bgt bgtVar = new bgt();
        a = bgtVar;
        bqn.aL(bgt.class, bgtVar);
    }

    private bgt() {
    }

    public static /* synthetic */ bgt b() {
        return a;
    }

    public static bgt c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgt) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void e(bgt bgtVar, bpb bpbVar) {
        bgtVar.e = bpbVar;
    }

    public static /* synthetic */ void f(bgt bgtVar) {
        bgtVar.d = 0;
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
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"d", "e"});
        }
        if (i2 == 3) {
            return new bgt();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (boolean[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
