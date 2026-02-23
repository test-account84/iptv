package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bib extends bqn implements brt {
    private static final bib a;
    private int d;
    private bic e;

    static {
        bib bibVar = new bib();
        a = bibVar;
        bqn.aL(bib.class, bibVar);
    }

    private bib() {
    }

    public static /* synthetic */ bib b() {
        return a;
    }

    public static bib c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bib) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void e(bib bibVar, bic bicVar) {
        bicVar.getClass();
        bibVar.e = bicVar;
    }

    public static /* synthetic */ void f(bib bibVar) {
        bibVar.d = 0;
    }

    public static bif g() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bic d() {
        bic bicVar = this.e;
        return bicVar == null ? bic.c() : bicVar;
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
            return new bib();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
