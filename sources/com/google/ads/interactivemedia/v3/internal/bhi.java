package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhi extends bqn implements brt {
    private static final bhi a;
    private int d;
    private int e;

    static {
        bhi bhiVar = new bhi();
        a = bhiVar;
        bqn.aL(bhi.class, bhiVar);
    }

    private bhi() {
    }

    public static /* synthetic */ bhi b() {
        return a;
    }

    public static bhi c() {
        return a;
    }

    public static /* synthetic */ void d(bhi bhiVar, int i) {
        bhiVar.e = i;
    }

    public static /* synthetic */ void f(bhi bhiVar, int i) {
        bhiVar.d = bhf.a(i);
    }

    public static bif g() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.e;
    }

    public final int e() {
        int b = bhf.b(this.d);
        return b == 0 ? bhf.g : b;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"d", "e"});
        }
        if (i2 == 3) {
            return new bhi();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (char[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
