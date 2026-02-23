package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhz extends bqn implements brt {
    private static final bhz a;
    private int d;
    private bia e;

    static {
        bhz bhzVar = new bhz();
        a = bhzVar;
        bqn.aL(bhz.class, bhzVar);
    }

    private bhz() {
    }

    public static /* synthetic */ bhz b() {
        return a;
    }

    public static bhz c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bhz) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void e(bhz bhzVar, bia biaVar) {
        biaVar.getClass();
        bhzVar.e = biaVar;
    }

    public static /* synthetic */ void f(bhz bhzVar) {
        bhzVar.d = 0;
    }

    public static bif g() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bia d() {
        bia biaVar = this.e;
        return biaVar == null ? bia.b() : biaVar;
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
            return new bhz();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
