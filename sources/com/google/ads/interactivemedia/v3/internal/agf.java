package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class agf extends bqn implements brt {
    private static final agf a;
    private int d;
    private bpb e;
    private bpb f;
    private bpb g;
    private bpb h;

    static {
        agf agfVar = new agf();
        a = agfVar;
        bqn.aL(agf.class, agfVar);
    }

    private agf() {
        bpb bpbVar = bpb.b;
        this.e = bpbVar;
        this.f = bpbVar;
        this.g = bpbVar;
        this.h = bpbVar;
    }

    public static /* synthetic */ agf a() {
        return a;
    }

    public static agf b(byte[] bArr, bqb bqbVar) throws bqw {
        return (agf) bqn.aD(a, bArr, bqbVar);
    }

    public static /* synthetic */ void g(agf agfVar, bpb bpbVar) {
        agfVar.d |= 1;
        agfVar.e = bpbVar;
    }

    public static /* synthetic */ void h(agf agfVar, bpb bpbVar) {
        agfVar.d |= 2;
        agfVar.f = bpbVar;
    }

    public static /* synthetic */ void j(agf agfVar, bpb bpbVar) {
        agfVar.d |= 4;
        agfVar.g = bpbVar;
    }

    public static /* synthetic */ void k(agf agfVar, bpb bpbVar) {
        agfVar.d |= 8;
        agfVar.h = bpbVar;
    }

    public static agl l() {
        return (agl) a.ay();
    }

    public final bpb c() {
        return this.e;
    }

    public final bpb d() {
        return this.f;
    }

    public final bpb e() {
        return this.h;
    }

    public final bpb f() {
        return this.g;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"d", "e", "f", "g", "h"});
        }
        if (i2 == 3) {
            return new agf();
        }
        if (i2 == 4) {
            return new agl((byte[]) null, (char[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
