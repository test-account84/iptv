package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class agk extends bqn implements brt {
    private static final agk a;
    private int d;
    private String e = "";

    static {
        agk agkVar = new agk();
        a = agkVar;
        bqn.aL(agk.class, agkVar);
    }

    private agk() {
    }

    public static /* synthetic */ agk a() {
        return a;
    }

    public static /* synthetic */ void b(agk agkVar, String str) {
        str.getClass();
        agkVar.d |= 1;
        agkVar.e = str;
    }

    public static agl c() {
        return (agl) a.ay();
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"d", "e"});
        }
        if (i2 == 3) {
            return new agk();
        }
        if (i2 == 4) {
            return new agl((byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
