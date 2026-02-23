package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class buo extends bqn implements brt {
    private static final buo a;
    private byte e = 2;
    private bqt d = bqn.aF();

    static {
        buo buoVar = new buo();
        a = buoVar;
        bqn.aL(buo.class, buoVar);
    }

    private buo() {
    }

    public static /* synthetic */ buo c() {
        return a;
    }

    public static buo e() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.e);
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"d", bun.class});
        }
        if (i2 == 3) {
            return new buo();
        }
        if (i2 == 4) {
            return new bum(null, null);
        }
        if (i2 == 5) {
            return a;
        }
        this.e = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
