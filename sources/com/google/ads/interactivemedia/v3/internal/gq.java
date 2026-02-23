package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class gq {
    public final td a;
    public final Object b;
    public final uf[] c;
    public boolean d;
    public boolean e;
    public gr f;
    public boolean g;
    private final boolean[] h;
    private final hi[] i;
    private final wj j;
    private final ha k;
    private gq l;
    private um m;
    private wk n;
    private long o;

    public gq(hi[] hiVarArr, long j, wj wjVar, wr wrVar, ha haVar, gr grVar, wk wkVar) {
        this.i = hiVarArr;
        this.o = j;
        this.j = wjVar;
        this.k = haVar;
        te teVar = grVar.a;
        this.b = teVar.a;
        this.f = grVar;
        this.m = um.a;
        this.n = wkVar;
        this.c = new uf[2];
        this.h = new boolean[2];
        long j2 = grVar.b;
        long j3 = grVar.d;
        td m = haVar.m(teVar, wrVar, j2);
        this.a = j3 != -9223372036854775807L ? new se(m, j3) : m;
    }

    private final void u() {
        if (!w()) {
            return;
        }
        int i = 0;
        while (true) {
            wk wkVar = this.n;
            if (i >= wkVar.a) {
                return;
            }
            boolean b = wkVar.b(i);
            we weVar = this.n.c[i];
            if (b && weVar != null) {
                weVar.f();
            }
            i++;
        }
    }

    private final void v() {
        if (!w()) {
            return;
        }
        int i = 0;
        while (true) {
            wk wkVar = this.n;
            if (i >= wkVar.a) {
                return;
            }
            boolean b = wkVar.b(i);
            we weVar = this.n.c[i];
            if (b && weVar != null) {
                weVar.g();
            }
            i++;
        }
    }

    private final boolean w() {
        return this.l == null;
    }

    public final long a(wk wkVar, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= wkVar.a) {
                break;
            }
            boolean[] zArr2 = this.h;
            if (z || !wkVar.a(this.n, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            hi[] hiVarArr = this.i;
            if (i2 >= 2) {
                break;
            }
            hiVarArr[i2].b();
            i2++;
        }
        u();
        this.n = wkVar;
        v();
        long f = this.a.f(wkVar.c, this.h, this.c, zArr, j);
        int i3 = 0;
        while (true) {
            hi[] hiVarArr2 = this.i;
            if (i3 >= 2) {
                break;
            }
            hiVarArr2[i3].b();
            i3++;
        }
        this.e = false;
        int i4 = 0;
        while (true) {
            uf[] ufVarArr = this.c;
            if (i4 >= ufVarArr.length) {
                return f;
            }
            if (ufVarArr[i4] != null) {
                af.w(wkVar.b(i4));
                this.i[i4].b();
                this.e = true;
            } else {
                af.w(wkVar.c[i4] == null);
            }
            i4++;
        }
    }

    public final long b() {
        if (!this.d) {
            return this.f.b;
        }
        long bo = this.e ? this.a.bo() : Long.MIN_VALUE;
        return bo == Long.MIN_VALUE ? this.f.e : bo;
    }

    public final long c() {
        if (this.d) {
            return this.a.c();
        }
        return 0L;
    }

    public final long d() {
        return this.o;
    }

    public final long e() {
        return this.f.b + this.o;
    }

    public final long f(long j) {
        return j - this.o;
    }

    public final long g(long j) {
        return j + this.o;
    }

    public final gq h() {
        return this.l;
    }

    public final um i() {
        return this.m;
    }

    public final wk j() {
        return this.n;
    }

    public final wk k(float f, be beVar) throws ev {
        wk p = this.j.p(this.i, this.m, this.f.a, beVar);
        for (we weVar : p.c) {
            if (weVar != null) {
                weVar.h(f);
            }
        }
        return p;
    }

    public final void l(long j) {
        af.w(w());
        this.a.o(f(j));
    }

    public final void m(float f, be beVar) throws ev {
        this.d = true;
        this.m = this.a.h();
        wk k = k(f, beVar);
        gr grVar = this.f;
        long j = grVar.b;
        long j2 = grVar.e;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        long s = s(k, j);
        long j3 = this.o;
        gr grVar2 = this.f;
        this.o = j3 + (grVar2.b - s);
        this.f = grVar2.b(s);
    }

    public final void n(long j) {
        af.w(w());
        if (this.d) {
            this.a.l(f(j));
        }
    }

    public final void o() {
        u();
        ha haVar = this.k;
        td tdVar = this.a;
        try {
            if (tdVar instanceof se) {
                haVar.g(((se) tdVar).a);
            } else {
                haVar.g(tdVar);
            }
        } catch (RuntimeException e) {
            cd.c("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void p(gq gqVar) {
        if (gqVar == this.l) {
            return;
        }
        u();
        this.l = gqVar;
        v();
    }

    public final void q() {
        td tdVar = this.a;
        if (tdVar instanceof se) {
            long j = this.f.d;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((se) tdVar).m(j);
        }
    }

    public final boolean r() {
        if (this.d) {
            return !this.e || this.a.bo() == Long.MIN_VALUE;
        }
        return false;
    }

    public final long s(wk wkVar, long j) {
        return a(wkVar, j, false, new boolean[2]);
    }

    public final void t() {
        this.o = 1000000000000L;
    }
}
