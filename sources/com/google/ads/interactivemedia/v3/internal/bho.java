package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bho extends bqn implements brt {
    private static final bho a;
    private int d;
    private bhp e;
    private bpb f = bpb.b;

    static {
        bho bhoVar = new bho();
        a = bhoVar;
        bqn.aL(bho.class, bhoVar);
    }

    private bho() {
    }

    public static /* synthetic */ bho b() {
        return a;
    }

    public static bho c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bho) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void f(bho bhoVar, bhp bhpVar) {
        bhpVar.getClass();
        bhoVar.e = bhpVar;
    }

    public static /* synthetic */ void g(bho bhoVar, bpb bpbVar) {
        bhoVar.f = bpbVar;
    }

    public static /* synthetic */ void j(bho bhoVar) {
        bhoVar.d = 0;
    }

    public static bif k() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bhp d() {
        bhp bhpVar = this.e;
        return bhpVar == null ? bhp.d() : bhpVar;
    }

    public final bpb e() {
        return this.f;
    }

    public final boolean h() {
        return this.e != null;
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
            return new bho();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (char[]) null, (char[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
