package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhm extends bqn implements brt {
    private static final bhm a;
    private bhn d;

    static {
        bhm bhmVar = new bhm();
        a = bhmVar;
        bqn.aL(bhm.class, bhmVar);
    }

    private bhm() {
    }

    public static /* synthetic */ bhm a() {
        return a;
    }

    public static bhm b(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bhm) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void d(bhm bhmVar, bhn bhnVar) {
        bhnVar.getClass();
        bhmVar.d = bhnVar;
    }

    public static bif e() {
        return (bif) a.ay();
    }

    public final bhn c() {
        bhn bhnVar = this.d;
        return bhnVar == null ? bhn.b() : bhnVar;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"d"});
        }
        if (i2 == 3) {
            return new bhm();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (short[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
