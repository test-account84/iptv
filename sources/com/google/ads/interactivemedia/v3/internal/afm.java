package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class afm extends bqn implements brt {
    private static final afm a;
    private int d;
    private afn e;
    private afp f;

    static {
        afm afmVar = new afm();
        a = afmVar;
        bqn.aL(afm.class, afmVar);
    }

    private afm() {
    }

    public static /* synthetic */ afm a() {
        return a;
    }

    public static afm b(byte[] bArr, bqb bqbVar) throws bqw {
        return (afm) bqn.aD(a, bArr, bqbVar);
    }

    public final afn c() {
        afn afnVar = this.e;
        return afnVar == null ? afn.b() : afnVar;
    }

    public final afp d() {
        afp afpVar = this.f;
        return afpVar == null ? afp.b() : afpVar;
    }

    public final boolean e() {
        return (this.d & 1) != 0;
    }

    public final boolean f() {
        return (this.d & 2) != 0;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"d", "e", "f"});
        }
        if (i2 == 3) {
            return new afm();
        }
        if (i2 == 4) {
            return new afl(null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
