package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bia extends bqn implements brt {
    private static final bia a;
    private String d = "";

    static {
        bia biaVar = new bia();
        a = biaVar;
        bqn.aL(bia.class, biaVar);
    }

    private bia() {
    }

    public static /* synthetic */ bia a() {
        return a;
    }

    public static bia b() {
        return a;
    }

    public static bia c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bia) bqn.aC(a, bpbVar, bqbVar);
    }

    public final String d() {
        return this.d;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"d"});
        }
        if (i2 == 3) {
            return new bia();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (int[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
