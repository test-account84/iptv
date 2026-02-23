package com.google.ads.interactivemedia.v3.internal;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhu extends bqn implements brt {
    private static final bhu a;
    private int f;
    private boolean g;
    private String d = "";
    private String e = "";
    private String h = "";

    static {
        bhu bhuVar = new bhu();
        a = bhuVar;
        bqn.aL(bhu.class, bhuVar);
    }

    private bhu() {
    }

    public static /* synthetic */ bhu b() {
        return a;
    }

    public final int a() {
        return this.f;
    }

    public final String c() {
        return this.h;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final boolean f() {
        return this.g;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"d", "e", "f", "g", "h"});
        }
        if (i2 == 3) {
            return new bhu();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (char[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
