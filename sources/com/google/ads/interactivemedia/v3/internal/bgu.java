package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgu extends bqn implements brt {
    private static final bgu a;
    private int d;
    private int e;

    static {
        bgu bguVar = new bgu();
        a = bguVar;
        bqn.aL(bgu.class, bguVar);
    }

    private bgu() {
    }

    public static /* synthetic */ bgu b() {
        return a;
    }

    public static bgu c(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgu) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void d(bgu bguVar) {
        bguVar.d = 64;
    }

    public static bif e() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"d", "e"});
        }
        if (i2 == 3) {
            return new bgu();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
