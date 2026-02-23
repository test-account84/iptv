package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bht extends bqn implements brt {
    private static final bht a;
    private String d = "";
    private bpb e = bpb.b;
    private int f;

    static {
        bht bhtVar = new bht();
        a = bhtVar;
        bqn.aL(bht.class, bhtVar);
    }

    private bht() {
    }

    public static /* synthetic */ bht a() {
        return a;
    }

    public static bht b() {
        return a;
    }

    public static /* synthetic */ void f(bht bhtVar, String str) {
        str.getClass();
        bhtVar.d = str;
    }

    public static /* synthetic */ void g(bht bhtVar, bpb bpbVar) {
        bhtVar.e = bpbVar;
    }

    public static /* synthetic */ void h(bht bhtVar, bid bidVar) {
        bhtVar.f = bidVar.getNumber();
    }

    public static bif j() {
        return (bif) a.ay();
    }

    public final bid c() {
        bid a2 = bid.a(this.f);
        return a2 == null ? bid.f : a2;
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
            return new bht();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (char[][]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
