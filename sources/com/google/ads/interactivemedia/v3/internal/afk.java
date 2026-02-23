package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class afk extends bqn implements brt {
    private static final afk a;
    private int d;
    private long f;
    private long j;
    private long k;
    private long m;
    private int q;
    private String e = "";
    private String g = "";
    private String h = "";
    private String i = "";
    private String l = "";
    private String n = "";
    private String o = "";
    private bqt p = bqn.aF();

    static {
        afk afkVar = new afk();
        a = afkVar;
        bqn.aL(afk.class, afkVar);
    }

    private afk() {
    }

    public static /* synthetic */ afk a() {
        return a;
    }

    public static /* synthetic */ void b(afk afkVar, long j) {
        afkVar.d |= 2;
        afkVar.f = j;
    }

    public static /* synthetic */ void c(afk afkVar, String str) {
        str.getClass();
        afkVar.d |= 4;
        afkVar.g = str;
    }

    public static /* synthetic */ void d(afk afkVar, String str) {
        str.getClass();
        afkVar.d |= 8;
        afkVar.h = str;
    }

    public static /* synthetic */ void e(afk afkVar, String str) {
        afkVar.d |= 16;
        afkVar.i = str;
    }

    public static /* synthetic */ void f(afk afkVar, String str) {
        afkVar.d |= 1024;
        afkVar.o = str;
    }

    public static /* synthetic */ void g(afk afkVar, String str) {
        str.getClass();
        afkVar.d |= 1;
        afkVar.e = str;
    }

    public static /* synthetic */ void h(afk afkVar, int i) {
        afkVar.q = afj.b(i);
        afkVar.d |= 2048;
    }

    public static afl j() {
        return (afl) a.ay();
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", afh.class, "q", afj.a()});
        }
        if (i2 == 3) {
            return new afk();
        }
        if (i2 == 4) {
            return new afl((byte[]) null, (int[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
