package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bpw extends bqn implements brt {
    private static final bpw a;
    private int d;
    private boolean f;
    private byte g = 2;
    private String e = "";

    static {
        bpw bpwVar = new bpw();
        a = bpwVar;
        bqn.aL(bpw.class, bpwVar);
    }

    private bpw() {
    }

    public static /* synthetic */ bpw c() {
        return a;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new bpw();
        }
        if (i2 == 4) {
            return new bpv((byte[]) null, (char[]) null);
        }
        if (i2 == 5) {
            return a;
        }
        this.g = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
