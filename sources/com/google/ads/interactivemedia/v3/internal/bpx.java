package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bpx extends bqn implements brt {
    private static final bpx a;
    private int d;
    private long g;
    private long h;
    private double i;
    private byte l = 2;
    private bqt e = bsb.e();
    private String f = "";
    private bpb j = bpb.b;
    private String k = "";

    static {
        bpx bpxVar = new bpx();
        a = bpxVar;
        bqn.aL(bpx.class, bpxVar);
    }

    private bpx() {
    }

    public static /* synthetic */ bpx c() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"d", "e", bpw.class, "f", "g", "h", "i", "j", "k"});
        }
        if (i2 == 3) {
            return new bpx();
        }
        if (i2 == 4) {
            return new bpv(null);
        }
        if (i2 == 5) {
            return a;
        }
        this.l = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
