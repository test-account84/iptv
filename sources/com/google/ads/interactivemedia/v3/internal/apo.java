package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class apo extends bqn implements brt {
    private static final apo a;
    private int d;
    private String e = "";
    private String f = "";
    private long g;
    private long h;
    private long i;

    static {
        apo apoVar = new apo();
        a = apoVar;
        bqn.aL(apo.class, apoVar);
    }

    private apo() {
    }

    public static apn d() {
        return (apn) a.ay();
    }

    public static /* synthetic */ apo e() {
        return a;
    }

    public static apo f() {
        return a;
    }

    public static apo g(bpb bpbVar) throws bqw {
        return (apo) bqn.aB(a, bpbVar);
    }

    public static apo h(bpb bpbVar, bqb bqbVar) throws bqw {
        return (apo) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void l(apo apoVar, String str) {
        str.getClass();
        apoVar.d |= 1;
        apoVar.e = str;
    }

    public static /* synthetic */ void m(apo apoVar, long j) {
        apoVar.d |= 16;
        apoVar.i = j;
    }

    public static /* synthetic */ void n(apo apoVar, String str) {
        str.getClass();
        apoVar.d |= 2;
        apoVar.f = str;
    }

    public static /* synthetic */ void o(apo apoVar, long j) {
        apoVar.d |= 4;
        apoVar.g = j;
    }

    public static /* synthetic */ void p(apo apoVar, long j) {
        apoVar.d |= 8;
        apoVar.h = j;
    }

    public final long a() {
        return this.h;
    }

    public final long b() {
        return this.g;
    }

    public final long c() {
        return this.i;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"d", "e", "f", "g", "h", "i"});
        }
        if (i2 == 3) {
            return new apo();
        }
        if (i2 == 4) {
            return new apn(null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }

    public final String j() {
        return this.f;
    }

    public final String k() {
        return this.e;
    }
}
