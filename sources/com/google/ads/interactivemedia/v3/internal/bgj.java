package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgj extends bqn implements brt {
    private static final bgj a;
    private int d;
    private bgl e;
    private bpb f = bpb.b;

    static {
        bgj bgjVar = new bgj();
        a = bgjVar;
        bqn.aL(bgj.class, bgjVar);
    }

    private bgj() {
    }

    public static /* synthetic */ bgj b() {
        return a;
    }

    public static bgj c() {
        return a;
    }

    public static bgj d(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgj) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void g(bgj bgjVar, bgl bglVar) {
        bglVar.getClass();
        bgjVar.e = bglVar;
    }

    public static /* synthetic */ void h(bgj bgjVar, bpb bpbVar) {
        bgjVar.f = bpbVar;
    }

    public static /* synthetic */ void j(bgj bgjVar) {
        bgjVar.d = 0;
    }

    public static bif k() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bgl e() {
        bgl bglVar = this.e;
        return bglVar == null ? bgl.c() : bglVar;
    }

    public final bpb f() {
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
            return new bgj();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (char[]) null, (char[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
