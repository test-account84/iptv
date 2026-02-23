package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class afn extends bqn implements brt {
    private static final afn a;
    private int d;
    private int e = 2;

    static {
        afn afnVar = new afn();
        a = afnVar;
        bqn.aL(afn.class, afnVar);
    }

    private afn() {
    }

    public static /* synthetic */ afn a() {
        return a;
    }

    public static afn b() {
        return a;
    }

    public final int c() {
        int b = afo.b(this.e);
        return b == 0 ? afo.c : b;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001bဌ\u0000", new Object[]{"d", "e", afo.a()});
        }
        if (i2 == 3) {
            return new afn();
        }
        if (i2 == 4) {
            return new afl((byte[]) null, (char[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
