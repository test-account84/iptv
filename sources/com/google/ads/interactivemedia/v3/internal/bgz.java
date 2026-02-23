package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgz extends bqn implements brt {
    private static final bgz a;
    private bha d;

    static {
        bgz bgzVar = new bgz();
        a = bgzVar;
        bqn.aL(bgz.class, bgzVar);
    }

    private bgz() {
    }

    public static /* synthetic */ bgz a() {
        return a;
    }

    public static bgz b(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bgz) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void d(bgz bgzVar, bha bhaVar) {
        bhaVar.getClass();
        bgzVar.d = bhaVar;
    }

    public static bif e() {
        return (bif) a.ay();
    }

    public final bha c() {
        bha bhaVar = this.d;
        return bhaVar == null ? bha.c() : bhaVar;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"d"});
        }
        if (i2 == 3) {
            return new bgz();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (short[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
