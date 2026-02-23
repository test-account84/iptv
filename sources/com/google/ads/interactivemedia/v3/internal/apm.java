package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class apm extends bqn implements brt {
    private static final apm a;
    private int d;
    private apo e;
    private bpb f;
    private bpb g;

    static {
        apm apmVar = new apm();
        a = apmVar;
        bqn.aL(apm.class, apmVar);
    }

    private apm() {
        bpb bpbVar = bpb.b;
        this.f = bpbVar;
        this.g = bpbVar;
    }

    public static /* synthetic */ apm a() {
        return a;
    }

    public static apm b(bpb bpbVar, bqb bqbVar) throws bqw {
        return (apm) bqn.aC(a, bpbVar, bqbVar);
    }

    public final apo c() {
        apo apoVar = this.e;
        return apoVar == null ? apo.f() : apoVar;
    }

    public final bpb d() {
        return this.g;
    }

    public final bpb e() {
        return this.f;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new apm();
        }
        if (i2 == 4) {
            return new apn(null, null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
