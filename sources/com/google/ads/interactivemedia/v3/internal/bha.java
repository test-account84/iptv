package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bha extends bqn implements brt {
    private static final bha a;
    private bhd d;
    private bgy e;
    private int f;

    static {
        bha bhaVar = new bha();
        a = bhaVar;
        bqn.aL(bha.class, bhaVar);
    }

    private bha() {
    }

    public static /* synthetic */ bha b() {
        return a;
    }

    public static bha c() {
        return a;
    }

    public static /* synthetic */ void e(bha bhaVar, bhd bhdVar) {
        bhdVar.getClass();
        bhaVar.d = bhdVar;
    }

    public static /* synthetic */ void f(bha bhaVar, bgy bgyVar) {
        bgyVar.getClass();
        bhaVar.e = bgyVar;
    }

    public static /* synthetic */ void h(bha bhaVar, int i) {
        bhaVar.f = bgx.a(i);
    }

    public static bif j() {
        return (bif) a.ay();
    }

    public final bgy a() {
        bgy bgyVar = this.e;
        return bgyVar == null ? bgy.b() : bgyVar;
    }

    public final bhd d() {
        bhd bhdVar = this.d;
        return bhdVar == null ? bhd.b() : bhdVar;
    }

    public final int g() {
        int b = bgx.b(this.f);
        return b == 0 ? bgx.e : b;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new bha();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (byte[]) null, (char[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
