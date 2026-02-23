package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhg extends bqn implements brt {
    private static final bhg a;
    private int d;
    private bhi e;
    private bpb f = bpb.b;

    static {
        bhg bhgVar = new bhg();
        a = bhgVar;
        bqn.aL(bhg.class, bhgVar);
    }

    private bhg() {
    }

    public static /* synthetic */ bhg b() {
        return a;
    }

    public static bhg c() {
        return a;
    }

    public static bhg d(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bhg) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void g(bhg bhgVar, bhi bhiVar) {
        bhiVar.getClass();
        bhgVar.e = bhiVar;
    }

    public static /* synthetic */ void h(bhg bhgVar, bpb bpbVar) {
        bhgVar.f = bpbVar;
    }

    public static /* synthetic */ void j(bhg bhgVar) {
        bhgVar.d = 0;
    }

    public static bif k() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bhi e() {
        bhi bhiVar = this.e;
        return bhiVar == null ? bhi.c() : bhiVar;
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
            return new bhg();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
