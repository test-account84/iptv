package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhb extends bqn implements brt {
    private static final bhb a;
    private int d;
    private bhc e;
    private bpb f = bpb.b;

    static {
        bhb bhbVar = new bhb();
        a = bhbVar;
        bqn.aL(bhb.class, bhbVar);
    }

    private bhb() {
    }

    public static /* synthetic */ bhb b() {
        return a;
    }

    public static bhb c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bhb) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void f(bhb bhbVar, bhc bhcVar) {
        bhcVar.getClass();
        bhbVar.e = bhcVar;
    }

    public static /* synthetic */ void g(bhb bhbVar, bpb bpbVar) {
        bhbVar.f = bpbVar;
    }

    public static /* synthetic */ void h(bhb bhbVar) {
        bhbVar.d = 0;
    }

    public static bif j() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bhc d() {
        bhc bhcVar = this.e;
        return bhcVar == null ? bhc.d() : bhcVar;
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
            return new bhb();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (char[]) null, (char[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
