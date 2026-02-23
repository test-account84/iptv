package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgk extends bqn implements brt {
    private static final bgk a;
    private bgl d;
    private int e;

    static {
        bgk bgkVar = new bgk();
        a = bgkVar;
        bqn.aL(bgk.class, bgkVar);
    }

    private bgk() {
    }

    public static /* synthetic */ bgk b() {
        return a;
    }

    public static bgk c() {
        return a;
    }

    public static bgk d(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgk) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void f(bgk bgkVar, bgl bglVar) {
        bglVar.getClass();
        bgkVar.d = bglVar;
    }

    public static /* synthetic */ void g(bgk bgkVar, int i) {
        bgkVar.e = i;
    }

    public static bif h() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.e;
    }

    public final bgl e() {
        bgl bglVar = this.d;
        return bglVar == null ? bgl.c() : bglVar;
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
            return new bgk();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (short[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
