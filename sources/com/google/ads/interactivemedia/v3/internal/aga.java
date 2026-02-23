package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aga extends bqn implements brt {
    private static final aga a;
    private int d;
    private long t;
    private long u;
    private long e = -1;
    private long f = -1;
    private long g = -1;
    private long h = -1;
    private long i = -1;
    private long j = -1;
    private int k = 1000;
    private long l = -1;
    private long m = -1;
    private long n = -1;
    private int o = 1000;
    private long p = -1;
    private long q = -1;
    private long r = -1;
    private long s = -1;
    private long v = -1;
    private long w = -1;
    private long x = -1;
    private long y = -1;

    static {
        aga agaVar = new aga();
        a = agaVar;
        bqn.aL(aga.class, agaVar);
    }

    private aga() {
    }

    public static /* synthetic */ aga a() {
        return a;
    }

    public static /* synthetic */ void b(aga agaVar, long j) {
        agaVar.d |= 1;
        agaVar.e = j;
    }

    public static /* synthetic */ void c(aga agaVar, long j) {
        agaVar.d |= 2;
        agaVar.f = j;
    }

    public static /* synthetic */ void d(aga agaVar, long j) {
        agaVar.d |= 4;
        agaVar.g = j;
    }

    public static /* synthetic */ void e(aga agaVar, long j) {
        agaVar.d |= 8;
        agaVar.h = j;
    }

    public static /* synthetic */ void f(aga agaVar) {
        agaVar.d &= -9;
        agaVar.h = -1L;
    }

    public static /* synthetic */ void g(aga agaVar, long j) {
        agaVar.d |= 16;
        agaVar.i = j;
    }

    public static /* synthetic */ void h(aga agaVar, long j) {
        agaVar.d |= 32;
        agaVar.j = j;
    }

    public static /* synthetic */ void j(aga agaVar, long j) {
        agaVar.d |= 128;
        agaVar.l = j;
    }

    public static /* synthetic */ void k(aga agaVar, long j) {
        agaVar.d |= 256;
        agaVar.m = j;
    }

    public static /* synthetic */ void l(aga agaVar, long j) {
        agaVar.d |= 512;
        agaVar.n = j;
    }

    public static /* synthetic */ void m(aga agaVar, long j) {
        agaVar.d |= 2048;
        agaVar.p = j;
    }

    public static /* synthetic */ void n(aga agaVar, long j) {
        agaVar.d |= 4096;
        agaVar.q = j;
    }

    public static /* synthetic */ void o(aga agaVar, long j) {
        agaVar.d |= 8192;
        agaVar.r = j;
    }

    public static /* synthetic */ void p(aga agaVar, long j) {
        agaVar.d |= 16384;
        agaVar.s = j;
    }

    public static /* synthetic */ void q(aga agaVar, long j) {
        agaVar.d |= 32768;
        agaVar.t = j;
    }

    public static /* synthetic */ void r(aga agaVar, long j) {
        agaVar.d |= 65536;
        agaVar.u = j;
    }

    public static /* synthetic */ void s(aga agaVar, long j) {
        agaVar.d |= 131072;
        agaVar.v = j;
    }

    public static /* synthetic */ void t(aga agaVar, long j) {
        agaVar.d |= 262144;
        agaVar.w = j;
    }

    public static /* synthetic */ void u(aga agaVar, int i) {
        agaVar.k = agh.b(i);
        agaVar.d |= 64;
    }

    public static /* synthetic */ void v(aga agaVar, int i) {
        agaVar.o = agh.b(i);
        agaVar.d |= 1024;
    }

    public static agl w() {
        return (agl) a.ay();
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"d", "e", "f", "g", "h", "i", "j", "k", agh.a(), "l", "m", "n", "o", agh.a(), "p", "q", "r", "s", "t", "u", "v", "w", "x", "y"});
        }
        if (i2 == 3) {
            return new aga();
        }
        if (i2 == 4) {
            return new agl((byte[]) null, (byte[]) null, (char[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
