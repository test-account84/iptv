package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class bi {
    public static final bi a = new bi(new bh());
    public final avx A;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int j;
    public final int k;
    public final boolean l;
    public final avo m;
    public final avo o;
    public final int q;
    public final int r;
    public final avo s;
    public final avo t;
    public final int u;
    public final avs z;
    public final int f = 0;
    public final int g = 0;
    public final int h = 0;
    public final int i = 0;
    public final int n = 0;
    public final int p = 0;
    public final int v = 0;
    public final boolean w = false;
    public final boolean x = false;
    public final boolean y = false;

    public bi(bh bhVar) {
        this.b = bh.f(bhVar);
        this.c = bh.e(bhVar);
        this.d = bh.d(bhVar);
        this.e = bh.c(bhVar);
        this.j = bh.i(bhVar);
        this.k = bh.h(bhVar);
        this.l = bh.p(bhVar);
        this.m = bh.m(bhVar);
        this.o = bh.j(bhVar);
        this.q = bh.b(bhVar);
        this.r = bh.a(bhVar);
        this.s = bh.k(bhVar);
        this.t = bh.l(bhVar);
        this.u = bh.g(bhVar);
        this.z = avs.c(bh.n(bhVar));
        this.A = avx.l(bh.o(bhVar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            bi biVar = (bi) obj;
            if (this.b == biVar.b && this.c == biVar.c && this.d == biVar.d && this.e == biVar.e && this.l == biVar.l && this.j == biVar.j && this.k == biVar.k && this.m.equals(biVar.m) && this.o.equals(biVar.o) && this.q == biVar.q && this.r == biVar.r && this.s.equals(biVar.s) && this.t.equals(biVar.t) && this.u == biVar.u && this.z.equals(biVar.z) && this.A.equals(biVar.A)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((this.b + 31) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 28629151) + (this.l ? 1 : 0)) * 31) + this.j) * 31) + this.k) * 31) + this.m.hashCode()) * 961) + this.o.hashCode()) * 961) + this.q) * 31) + this.r) * 31) + this.s.hashCode()) * 31) + this.t.hashCode()) * 31) + this.u) * 28629151) + this.z.hashCode()) * 31) + this.A.hashCode();
    }
}
