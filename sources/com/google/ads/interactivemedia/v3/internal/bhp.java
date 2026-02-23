package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhp extends bqn implements brt {
    private static final bhp a;
    private int d;
    private bhn e;
    private bpb f = bpb.b;

    static {
        bhp bhpVar = new bhp();
        a = bhpVar;
        bqn.aL(bhp.class, bhpVar);
    }

    private bhp() {
    }

    public static /* synthetic */ bhp c() {
        return a;
    }

    public static bhp d() {
        return a;
    }

    public static bhp e(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bhp) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void g(bhp bhpVar, bhn bhnVar) {
        bhnVar.getClass();
        bhpVar.e = bhnVar;
    }

    public static /* synthetic */ void h(bhp bhpVar, bpb bpbVar) {
        bhpVar.f = bpbVar;
    }

    public static /* synthetic */ void k(bhp bhpVar) {
        bhpVar.d = 0;
    }

    public static bif l() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bhn b() {
        bhn bhnVar = this.e;
        return bhnVar == null ? bhn.b() : bhnVar;
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
            return new bhp();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (short[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }

    public final boolean j() {
        return this.e != null;
    }
}
