package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bpu extends bql implements brt {
    private static final bpu d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private byte l = 2;
    private String j = "";
    private bqt k = bsb.e();

    static {
        bpu bpuVar = new bpu();
        d = bpuVar;
        bqn.aL(bpu.class, bpuVar);
    }

    private bpu() {
    }

    public static /* synthetic */ bpu c() {
        return d;
    }

    public static bpu e() {
        return d;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return bqn.aI(d, "\u0001\u0006\u0000\u0001\u0001ϧ\u0006\u0000\u0001\u0001\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0007ဇ\u0003\nဈ\u0004ϧЛ", new Object[]{"e", "f", "g", "h", "i", "j", "k", bpx.class});
        }
        if (i2 == 3) {
            return new bpu();
        }
        if (i2 == 4) {
            return new bpr((byte[]) null, (char[]) null);
        }
        if (i2 == 5) {
            return d;
        }
        this.l = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
