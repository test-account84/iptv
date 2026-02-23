package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhn extends bqn implements brt {
    private static final bhn a;
    private int d;
    private int e;
    private int f;

    static {
        bhn bhnVar = new bhn();
        a = bhnVar;
        bqn.aL(bhn.class, bhnVar);
    }

    private bhn() {
    }

    public static /* synthetic */ bhn a() {
        return a;
    }

    public static bhn b() {
        return a;
    }

    public static /* synthetic */ void f(bhn bhnVar, int i) {
        bhnVar.d = bhl.b(i);
    }

    public static /* synthetic */ void g(bhn bhnVar, int i) {
        bhnVar.e = bhk.b(i);
    }

    public static /* synthetic */ void h(bhn bhnVar, int i) {
        bhnVar.f = bhj.b(i);
    }

    public static bif j() {
        return (bif) a.ay();
    }

    public final int c() {
        int c = bhj.c(this.f);
        return c == 0 ? bhj.e : c;
    }

    public final int d() {
        int c = bhk.c(this.e);
        return c == 0 ? bhk.e : c;
    }

    public final int e() {
        int c = bhl.c(this.d);
        return c == 0 ? bhl.f : c;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new bhn();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (byte[]) null, (char[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
