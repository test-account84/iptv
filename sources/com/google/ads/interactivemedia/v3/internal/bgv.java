package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgv extends bqn implements brt {
    private static final bgv a;
    private int d;
    private bpb e = bpb.b;

    static {
        bgv bgvVar = new bgv();
        a = bgvVar;
        bqn.aL(bgv.class, bgvVar);
    }

    private bgv() {
    }

    public static /* synthetic */ bgv b() {
        return a;
    }

    public static bgv c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgv) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void e(bgv bgvVar, bpb bpbVar) {
        bgvVar.e = bpbVar;
    }

    public static /* synthetic */ void f(bgv bgvVar) {
        bgvVar.d = 0;
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
            return new bgv();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (char[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
