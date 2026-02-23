package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhx extends bqn implements brt {
    private static final bhx a;
    private String d = "";
    private int e;
    private int f;
    private int g;

    static {
        bhx bhxVar = new bhx();
        a = bhxVar;
        bqn.aL(bhx.class, bhxVar);
    }

    private bhx() {
    }

    public static /* synthetic */ bhx a() {
        return a;
    }

    public static /* synthetic */ void b(bhx bhxVar, String str) {
        str.getClass();
        bhxVar.d = str;
    }

    public static /* synthetic */ void c(bhx bhxVar, bid bidVar) {
        bhxVar.g = bidVar.getNumber();
    }

    public static /* synthetic */ void d(bhx bhxVar, int i) {
        bhxVar.f = i;
    }

    public static /* synthetic */ void e(bhx bhxVar, int i) {
        bhxVar.e = bhs.a(i);
    }

    public static bif f() {
        return (bif) a.ay();
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new bhx();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (char[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
