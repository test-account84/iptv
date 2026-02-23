package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgp extends bqn implements brt {
    private static final bgp a;
    private int d;
    private bpb e = bpb.b;

    static {
        bgp bgpVar = new bgp();
        a = bgpVar;
        bqn.aL(bgp.class, bgpVar);
    }

    private bgp() {
    }

    public static /* synthetic */ bgp b() {
        return a;
    }

    public static bgp c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgp) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void e(bgp bgpVar, bpb bpbVar) {
        bgpVar.e = bpbVar;
    }

    public static /* synthetic */ void f(bgp bgpVar) {
        bgpVar.d = 0;
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
            return new bgp();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (short[]) null, (char[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
