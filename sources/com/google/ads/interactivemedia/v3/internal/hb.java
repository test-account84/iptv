package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class hb {
    private static final te s = new te(new Object());
    public final be a;
    public final te b;
    public final long c;
    public final long d;
    public final int e;
    public final ev f;
    public final boolean g;
    public final um h;
    public final wk i;
    public final List j;
    public final te k;
    public final boolean l;
    public final int m;
    public final au n;
    public final boolean o;
    public volatile long p;
    public volatile long q;
    public volatile long r;

    public hb(be beVar, te teVar, long j, long j2, int i, ev evVar, boolean z, um umVar, wk wkVar, List list, te teVar2, boolean z2, int i2, au auVar, long j3, long j4, long j5, boolean z3) {
        this.a = beVar;
        this.b = teVar;
        this.c = j;
        this.d = j2;
        this.e = i;
        this.f = evVar;
        this.g = z;
        this.h = umVar;
        this.i = wkVar;
        this.j = list;
        this.k = teVar2;
        this.l = z2;
        this.m = i2;
        this.n = auVar;
        this.p = j3;
        this.q = j4;
        this.r = j5;
        this.o = z3;
    }

    public static hb g(wk wkVar) {
        be beVar = be.a;
        te teVar = s;
        return new hb(beVar, teVar, -9223372036854775807L, 0L, 1, null, false, um.a, wkVar, avo.o(), teVar, false, 0, au.a, 0L, 0L, 0L, false);
    }

    public static te h() {
        return s;
    }

    public final hb a(te teVar) {
        return new hb(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, teVar, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }

    public final hb b(te teVar, long j, long j2, long j3, long j4, um umVar, wk wkVar, List list) {
        return new hb(this.a, teVar, j2, j3, this.e, this.f, this.g, umVar, wkVar, list, this.k, this.l, this.m, this.n, this.p, j4, j, this.o);
    }

    public final hb c(boolean z, int i) {
        return new hb(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, z, i, this.n, this.p, this.q, this.r, this.o);
    }

    public final hb d(ev evVar) {
        return new hb(this.a, this.b, this.c, this.d, this.e, evVar, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }

    public final hb e(int i) {
        return new hb(this.a, this.b, this.c, this.d, i, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }

    public final hb f(be beVar) {
        return new hb(beVar, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }
}
