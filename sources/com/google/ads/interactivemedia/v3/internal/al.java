package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class al {
    public static final al a = new ak().a();
    public final CharSequence b;
    public final CharSequence c;
    public final CharSequence d;
    public final CharSequence e;
    public final CharSequence f;
    public final byte[] g;
    public final Integer h;
    public final Integer i;
    public final Integer j;

    @Deprecated
    public final Integer k;
    public final Integer l;
    public final Integer m;
    public final Integer n;
    public final Integer o;
    public final Integer p;
    public final Integer q;
    public final CharSequence r;
    public final CharSequence s;
    public final CharSequence t;
    public final CharSequence u;
    public final CharSequence v;

    public /* synthetic */ al(ak akVar) {
        this.b = ak.j(akVar);
        this.c = ak.d(akVar);
        this.d = ak.c(akVar);
        this.e = ak.b(akVar);
        this.f = ak.g(akVar);
        this.g = ak.u(akVar);
        this.h = ak.l(akVar);
        this.i = ak.t(akVar);
        this.j = ak.s(akVar);
        this.k = ak.o(akVar);
        this.l = ak.o(akVar);
        this.m = ak.n(akVar);
        this.n = ak.m(akVar);
        this.o = ak.r(akVar);
        this.p = ak.q(akVar);
        this.q = ak.p(akVar);
        this.r = ak.k(akVar);
        this.s = ak.e(akVar);
        this.t = ak.f(akVar);
        this.u = ak.h(akVar);
        this.v = ak.i(akVar);
    }

    public final ak a() {
        return new ak(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && al.class == obj.getClass()) {
            al alVar = (al) obj;
            if (cq.V(this.b, alVar.b) && cq.V(this.c, alVar.c) && cq.V(this.d, alVar.d) && cq.V(this.e, alVar.e) && cq.V(null, null) && cq.V(null, null) && cq.V(this.f, alVar.f) && cq.V(null, null) && cq.V(null, null) && Arrays.equals(this.g, alVar.g) && cq.V(this.h, alVar.h) && cq.V(null, null) && cq.V(this.i, alVar.i) && cq.V(this.j, alVar.j) && cq.V(null, null) && cq.V(null, null) && cq.V(this.l, alVar.l) && cq.V(this.m, alVar.m) && cq.V(this.n, alVar.n) && cq.V(this.o, alVar.o) && cq.V(this.p, alVar.p) && cq.V(this.q, alVar.q) && cq.V(this.r, alVar.r) && cq.V(this.s, alVar.s) && cq.V(this.t, alVar.t) && cq.V(null, null) && cq.V(null, null) && cq.V(this.u, alVar.u) && cq.V(null, null) && cq.V(this.v, alVar.v)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.d, this.e, null, null, this.f, null, null, Integer.valueOf(Arrays.hashCode(this.g)), this.h, null, this.i, this.j, null, null, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, null, null, this.u, null, this.v});
    }
}
