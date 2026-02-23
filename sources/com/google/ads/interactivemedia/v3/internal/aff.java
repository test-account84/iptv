package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aff extends bqn implements brt {
    private static final aff a;
    private int d;
    private int e;
    private boolean h;
    private boolean f = true;
    private String g = "unknown_host";
    private boolean i = true;

    static {
        aff affVar = new aff();
        a = affVar;
        bqn.aL(aff.class, affVar);
    }

    private aff() {
    }

    public static /* synthetic */ aff a() {
        return a;
    }

    public static /* synthetic */ void f(aff affVar) {
        affVar.d |= 16;
        affVar.i = false;
    }

    public static /* synthetic */ void g(aff affVar) {
        affVar.d |= 4;
        affVar.g = "a.3.29.0";
    }

    public static /* synthetic */ void h(aff affVar) {
        affVar.d |= 8;
        affVar.h = false;
    }

    public static /* synthetic */ void k(aff affVar, int i) {
        affVar.e = afg.b(i);
        affVar.d |= 1;
    }

    public static afl l() {
        return (afl) a.ay();
    }

    public final String b() {
        return this.g;
    }

    public final boolean c() {
        return this.h;
    }

    public final boolean d() {
        return this.i;
    }

    public final boolean e() {
        return this.f;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဇ\u0004", new Object[]{"d", "e", afg.a(), "f", "g", "h", "i"});
        }
        if (i2 == 3) {
            return new aff();
        }
        if (i2 == 4) {
            return new afl(null, null, null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }

    public final int j() {
        int c = afg.c(this.e);
        return c == 0 ? afg.a : c;
    }
}
