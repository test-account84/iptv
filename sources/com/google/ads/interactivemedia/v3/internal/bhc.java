package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhc extends bqn implements brt {
    private static final bhc a;
    private int d;
    private bha e;
    private bpb f;
    private bpb g;

    static {
        bhc bhcVar = new bhc();
        a = bhcVar;
        bqn.aL(bhc.class, bhcVar);
    }

    private bhc() {
        bpb bpbVar = bpb.b;
        this.f = bpbVar;
        this.g = bpbVar;
    }

    public static /* synthetic */ bhc c() {
        return a;
    }

    public static bhc d() {
        return a;
    }

    public static bhc e(bpb bpbVar, bqb bqbVar) throws bqw {
        return (bhc) bqn.aC(a, bpbVar, bqbVar);
    }

    public static /* synthetic */ void h(bhc bhcVar, bha bhaVar) {
        bhaVar.getClass();
        bhcVar.e = bhaVar;
    }

    public static /* synthetic */ void j(bhc bhcVar, bpb bpbVar) {
        bhcVar.f = bpbVar;
    }

    public static /* synthetic */ void k(bhc bhcVar, bpb bpbVar) {
        bhcVar.g = bpbVar;
    }

    public static /* synthetic */ void l(bhc bhcVar) {
        bhcVar.d = 0;
    }

    public static bif m() {
        return (bif) a.ay();
    }

    public final int a() {
        return this.d;
    }

    public final bha b() {
        bha bhaVar = this.e;
        return bhaVar == null ? bha.c() : bhaVar;
    }

    public final bpb f() {
        return this.f;
    }

    public final bpb g() {
        return this.g;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new bhc();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (short[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
