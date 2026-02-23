package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhr extends bqn implements brt {
    private static final bhr a;
    private String d = "";
    private bpb e = bpb.b;
    private int f;

    static {
        bhr bhrVar = new bhr();
        a = bhrVar;
        bqn.aL(bhr.class, bhrVar);
    }

    private bhr() {
    }

    public static /* synthetic */ bhr b() {
        return a;
    }

    public static bhr c() {
        return a;
    }

    public static /* synthetic */ void f(bhr bhrVar, String str) {
        bhrVar.d = str;
    }

    public static /* synthetic */ void g(bhr bhrVar, bpb bpbVar) {
        bhrVar.e = bpbVar;
    }

    public static /* synthetic */ void h(bhr bhrVar, bhq bhqVar) {
        bhrVar.f = bhqVar.getNumber();
    }

    public static bif j() {
        return (bif) a.ay();
    }

    public final bhq a() {
        bhq a2 = bhq.a(this.f);
        return a2 == null ? bhq.UNRECOGNIZED : a2;
    }

    public final bpb d() {
        return this.e;
    }

    public final String e() {
        return this.d;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new bhr();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (short[][]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
