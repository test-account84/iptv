package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class agb extends bqn implements brt {
    private static final agb a;
    private int d;
    private long e = -1;
    private long f = -1;
    private long g = -1;
    private long h = -1;
    private long i = -1;
    private long j = -1;
    private long k = -1;
    private long l = -1;

    static {
        agb agbVar = new agb();
        a = agbVar;
        bqn.aL(agb.class, agbVar);
    }

    private agb() {
    }

    public static /* synthetic */ agb a() {
        return a;
    }

    public static /* synthetic */ void b(agb agbVar, long j) {
        agbVar.d |= 1;
        agbVar.e = j;
    }

    public static /* synthetic */ void c(agb agbVar, long j) {
        agbVar.d |= 4;
        agbVar.g = j;
    }

    public static /* synthetic */ void d(agb agbVar, long j) {
        agbVar.d |= 8;
        agbVar.h = j;
    }

    public static /* synthetic */ void e(agb agbVar, long j) {
        agbVar.d |= 16;
        agbVar.i = j;
    }

    public static /* synthetic */ void f(agb agbVar, long j) {
        agbVar.d |= 32;
        agbVar.j = j;
    }

    public static agl g() {
        return (agl) a.ay();
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"d", "e", "f", "g", "h", "i", "j", "k", "l"});
        }
        if (i2 == 3) {
            return new agb();
        }
        if (i2 == 4) {
            return new agl((byte[]) null, (short[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
