package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class agm extends bqn implements brt {
    private static final agm a;
    private int d;
    private bqt e = bqn.aF();
    private bpb f = bpb.b;
    private int g = 1;
    private int h = 1;

    static {
        agm agmVar = new agm();
        a = agmVar;
        bqn.aL(agm.class, agmVar);
    }

    private agm() {
    }

    public static agl a() {
        return (agl) a.ay();
    }

    public static /* synthetic */ agm b() {
        return a;
    }

    public static /* synthetic */ void c(agm agmVar, bpb bpbVar) {
        agmVar.f();
        agmVar.e.add(bpbVar);
    }

    public static /* synthetic */ void d(agm agmVar, bpb bpbVar) {
        agmVar.d |= 1;
        agmVar.f = bpbVar;
    }

    public static /* synthetic */ void e(agm agmVar, int i) {
        agmVar.h = agg.b(i);
        agmVar.d |= 4;
    }

    private final void f() {
        bqt bqtVar = this.e;
        if (bqtVar.c()) {
            return;
        }
        this.e = bqn.aG(bqtVar);
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"d", "e", "f", "g", agi.a(), "h", agg.a()});
        }
        if (i2 == 3) {
            return new agm();
        }
        if (i2 == 4) {
            return new agl(null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
