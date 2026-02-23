package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bic extends bqn implements brt {
    private static final bic a;
    private String d = "";
    private bht e;

    static {
        bic bicVar = new bic();
        a = bicVar;
        bqn.aL(bic.class, bicVar);
    }

    private bic() {
    }

    public static /* synthetic */ bic b() {
        return a;
    }

    public static bic c() {
        return a;
    }

    public static bic d(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bic) bqn.aC(a, bpbVar, bqbVar);
    }

    public final bht a() {
        bht bhtVar = this.e;
        return bhtVar == null ? bht.b() : bhtVar;
    }

    public final String e() {
        return this.d;
    }

    public final boolean f() {
        return this.e != null;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"d", "e"});
        }
        if (i2 == 3) {
            return new bic();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (boolean[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
