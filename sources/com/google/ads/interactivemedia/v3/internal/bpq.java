package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bpq extends bql implements brt {
    private static final bpq d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean n;
    private boolean p;
    private byte r = 2;
    private bqt m = bsb.e();
    private boolean o = true;
    private bqt q = bsb.e();

    static {
        bpq bpqVar = new bpq();
        d = bpqVar;
        bqn.aL(bpq.class, bpqVar);
    }

    private bpq() {
    }

    public static /* synthetic */ bpq c() {
        return d;
    }

    public static bpq e() {
        return d;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.r);
        }
        if (i2 == 2) {
            return bqn.aI(d, "\u0001\f\u0000\u0001\u0001ϧ\f\u0000\u0002\u0001\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0005\u0005ဇ\u0003\u0006ဌ\u0002\nဇ\u0006\u000b\u001b\fဇ\u0007\rဇ\b\u000eဇ\t\u000fဇ\u0004ϧЛ", new Object[]{"e", "f", bpm.a(), "g", "k", "i", "h", bpo.a(), "l", "m", bpp.class, "n", "o", "p", "j", "q", bpx.class});
        }
        if (i2 == 3) {
            return new bpq();
        }
        if (i2 == 4) {
            return new bpr((byte[]) null, (byte[]) null);
        }
        if (i2 == 5) {
            return d;
        }
        this.r = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
