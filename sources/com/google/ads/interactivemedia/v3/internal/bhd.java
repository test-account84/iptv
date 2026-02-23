package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhd extends bqn implements brt {
    private static final bhd a;
    private int d;
    private int e;
    private bpb f = bpb.b;

    static {
        bhd bhdVar = new bhd();
        a = bhdVar;
        bqn.aL(bhd.class, bhdVar);
    }

    private bhd() {
    }

    public static /* synthetic */ bhd a() {
        return a;
    }

    public static bhd b() {
        return a;
    }

    public static /* synthetic */ void d(bhd bhdVar, bpb bpbVar) {
        bhdVar.f = bpbVar;
    }

    public static /* synthetic */ void g(bhd bhdVar, int i) {
        bhdVar.d = bhe.a(i);
    }

    public static /* synthetic */ void h(bhd bhdVar, int i) {
        bhdVar.e = bhf.a(i);
    }

    public static bif j() {
        return (bif) a.ay();
    }

    public final bpb c() {
        return this.f;
    }

    public final int e() {
        int b = bhe.b(this.d);
        return b == 0 ? bhe.f : b;
    }

    public final int f() {
        int b = bhf.b(this.e);
        return b == 0 ? bhf.g : b;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new bhd();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (int[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
