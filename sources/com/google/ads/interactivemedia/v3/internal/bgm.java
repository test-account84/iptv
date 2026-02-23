package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgm extends bqn implements brt {
    private static final bgm a;
    private int d;
    private bgo e;
    private bpb f = bpb.b;

    static {
        bgm bgmVar = new bgm();
        a = bgmVar;
        bqn.aL(bgm.class, bgmVar);
    }

    private bgm() {
    }

    public static /* synthetic */ bgm b() {
        return a;
    }

    public static bgm c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgm) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void f(bgm bgmVar, bgo bgoVar) {
        bgoVar.getClass();
        bgmVar.e = bgoVar;
    }

    public static /* synthetic */ void g(bgm bgmVar, bpb bpbVar) {
        bgmVar.f = bpbVar;
    }

    public static /* synthetic */ void h(bgm bgmVar) {
        bgmVar.d = 0;
    }

    public static bif j() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bgo d() {
        bgo bgoVar = this.e;
        return bgoVar == null ? bgo.c() : bgoVar;
    }

    public final bpb e() {
        return this.f;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new bgm();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null, (char[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
