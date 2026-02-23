package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhh extends bqn implements brt {
    private static final bhh a;
    private bhi d;
    private int e;
    private int f;

    static {
        bhh bhhVar = new bhh();
        a = bhhVar;
        bqn.aL(bhh.class, bhhVar);
    }

    private bhh() {
    }

    public static /* synthetic */ bhh b() {
        return a;
    }

    public static bhh c() {
        return a;
    }

    public static bhh d(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bhh) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void f(bhh bhhVar, bhi bhiVar) {
        bhiVar.getClass();
        bhhVar.d = bhiVar;
    }

    public static /* synthetic */ void g(bhh bhhVar, int i) {
        bhhVar.e = i;
    }

    public static bif h() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.e;
    }

    public final bhi e() {
        bhi bhiVar = this.d;
        return bhiVar == null ? bhi.c() : bhiVar;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new bhh();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (char[]) null, (byte[]) null, (char[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
