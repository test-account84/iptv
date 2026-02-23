package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgi extends bqn implements brt {
    private static final bgi a;
    private bgk d;
    private bhh e;

    static {
        bgi bgiVar = new bgi();
        a = bgiVar;
        bqn.aL(bgi.class, bgiVar);
    }

    private bgi() {
    }

    public static /* synthetic */ bgi a() {
        return a;
    }

    public static bgi b(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgi) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void e(bgi bgiVar, bgk bgkVar) {
        bgkVar.getClass();
        bgiVar.d = bgkVar;
    }

    public static /* synthetic */ void f(bgi bgiVar, bhh bhhVar) {
        bhhVar.getClass();
        bgiVar.e = bhhVar;
    }

    public static bif g() {
        return (bif) a.ay();
    }

    public final bgk c() {
        bgk bgkVar = this.d;
        return bgkVar == null ? bgk.c() : bgkVar;
    }

    public final bhh d() {
        bhh bhhVar = this.e;
        return bhhVar == null ? bhh.c() : bhhVar;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"d", "e"});
        }
        if (i2 == 3) {
            return new bgi();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (byte[]) null, (char[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
