package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgy extends bqn implements brt {
    private static final bgy a;
    private bht d;

    static {
        bgy bgyVar = new bgy();
        a = bgyVar;
        bqn.aL(bgy.class, bgyVar);
    }

    private bgy() {
    }

    public static /* synthetic */ bgy a() {
        return a;
    }

    public static bgy b() {
        return a;
    }

    public static /* synthetic */ void d(bgy bgyVar, bht bhtVar) {
        bhtVar.getClass();
        bgyVar.d = bhtVar;
    }

    public static bif e() {
        return (bif) a.ay();
    }

    public final bht c() {
        bht bhtVar = this.d;
        return bhtVar == null ? bht.b() : bhtVar;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"d"});
        }
        if (i2 == 3) {
            return new bgy();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (char[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
