package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhv extends bqn implements brt {
    private static final bhv a;
    private bhr d;
    private int e;
    private int f;
    private int g;

    static {
        bhv bhvVar = new bhv();
        a = bhvVar;
        bqn.aL(bhv.class, bhvVar);
    }

    private bhv() {
    }

    public static /* synthetic */ bhv c() {
        return a;
    }

    public final int a() {
        return this.f;
    }

    public final bhr b() {
        bhr bhrVar = this.d;
        return bhrVar == null ? bhr.c() : bhrVar;
    }

    public final bid d() {
        bid a2 = bid.a(this.g);
        return a2 == null ? bid.f : a2;
    }

    public final boolean e() {
        return this.d != null;
    }

    public final int f() {
        int b = bhs.b(this.e);
        return b == 0 ? bhs.e : b;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new bhv();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (short[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
