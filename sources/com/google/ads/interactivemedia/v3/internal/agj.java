package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class agj extends bqn implements brt {
    private static final agj a;
    private int d;
    private long e;
    private String f = "";
    private bpb g = bpb.b;

    static {
        agj agjVar = new agj();
        a = agjVar;
        bqn.aL(agj.class, agjVar);
    }

    private agj() {
    }

    public static /* synthetic */ agj b() {
        return a;
    }

    public static agj c() {
        return a;
    }

    public final long a() {
        return this.e;
    }

    public final boolean d() {
        return (this.d & 1) != 0;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new agj();
        }
        if (i2 == 4) {
            return new agl((byte[]) null, (float[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
