package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class age extends bqn implements brt {
    private static final age a;
    private int d;
    private bpb e;
    private bpb f;

    static {
        age ageVar = new age();
        a = ageVar;
        bqn.aL(age.class, ageVar);
    }

    private age() {
        bpb bpbVar = bpb.b;
        this.e = bpbVar;
        this.f = bpbVar;
    }

    public static /* synthetic */ age a() {
        return a;
    }

    public static /* synthetic */ void b(age ageVar, bpb bpbVar) {
        ageVar.d |= 1;
        ageVar.e = bpbVar;
    }

    public static /* synthetic */ void c(age ageVar, bpb bpbVar) {
        ageVar.d |= 2;
        ageVar.f = bpbVar;
    }

    public static agl d() {
        return (agl) a.ay();
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new age();
        }
        if (i2 == 4) {
            return new agl((byte[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
