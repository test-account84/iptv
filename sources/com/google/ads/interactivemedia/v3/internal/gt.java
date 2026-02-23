package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.util.Pair;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class gt {
    private final bc a = new bc();
    private final bd b = new bd();
    private final hu c;
    private final Handler d;
    private long e;
    private int f;
    private boolean g;
    private gq h;
    private gq i;
    private gq j;
    private int k;
    private Object l;
    private long m;

    public gt(hu huVar, Handler handler) {
        this.c = huVar;
        this.d = handler;
    }

    private final boolean A(be beVar, te teVar) {
        if (C(teVar)) {
            return beVar.o(beVar.n(teVar.a, this.a).c, this.b).p == beVar.a(teVar.a);
        }
        return false;
    }

    private final boolean B(be beVar) {
        gq gqVar = this.h;
        if (gqVar == null) {
            return true;
        }
        int a = beVar.a(gqVar.b);
        while (true) {
            a = beVar.i(a, this.a, this.b, this.f, this.g);
            while (gqVar.h() != null && !gqVar.f.g) {
                gqVar = gqVar.h();
            }
            gq h = gqVar.h();
            if (a == -1 || h == null || beVar.a(h.b) != a) {
                break;
            }
            gqVar = h;
        }
        boolean m = m(gqVar);
        gqVar.f = g(beVar, gqVar.f);
        return !m;
    }

    private static final boolean C(te teVar) {
        return !teVar.b() && teVar.e == -1;
    }

    private final long s(be beVar, Object obj, int i) {
        beVar.n(obj, this.a);
        this.a.i(i);
        this.a.k(i);
        return 0L;
    }

    private final gr t(be beVar, gq gqVar, long j) {
        long j2;
        gr grVar = gqVar.f;
        long d = (gqVar.d() + grVar.e) - j;
        if (!grVar.g) {
            te teVar = grVar.a;
            beVar.n(teVar.a, this.a);
            if (!teVar.b()) {
                int d2 = this.a.d(teVar.e);
                this.a.l(teVar.e);
                if (d2 != this.a.a(teVar.e)) {
                    return v(beVar, teVar.a, teVar.e, d2, grVar.e, teVar.d);
                }
                s(beVar, teVar.a, teVar.e);
                return w(beVar, teVar.a, 0L, grVar.e, teVar.d);
            }
            int i = teVar.b;
            if (this.a.a(i) == -1) {
                return null;
            }
            int e = this.a.e(i, teVar.c);
            if (e < 0) {
                return v(beVar, teVar.a, i, e, grVar.c, teVar.d);
            }
            long j3 = grVar.c;
            if (j3 == -9223372036854775807L) {
                bd bdVar = this.b;
                bc bcVar = this.a;
                Pair l = beVar.l(bdVar, bcVar, bcVar.c, -9223372036854775807L, Math.max(0L, d));
                if (l == null) {
                    return null;
                }
                j3 = ((Long) l.second).longValue();
            }
            s(beVar, teVar.a, teVar.b);
            return w(beVar, teVar.a, Math.max(0L, j3), grVar.c, teVar.d);
        }
        long j4 = 0;
        int i2 = beVar.i(beVar.a(grVar.a.a), this.a, this.b, this.f, this.g);
        if (i2 == -1) {
            return null;
        }
        int i3 = beVar.d(i2, this.a, true).c;
        Object obj = this.a.b;
        af.s(obj);
        long j5 = grVar.a.d;
        if (beVar.o(i3, this.b).o == i2) {
            Pair l2 = beVar.l(this.b, this.a, i3, -9223372036854775807L, Math.max(0L, d));
            if (l2 == null) {
                return null;
            }
            obj = l2.first;
            long longValue = ((Long) l2.second).longValue();
            gq h = gqVar.h();
            if (h == null || !h.b.equals(obj)) {
                j5 = this.e;
                this.e = 1 + j5;
            } else {
                j5 = h.f.a.d;
            }
            j2 = longValue;
            j4 = -9223372036854775807L;
        } else {
            j2 = 0;
        }
        te x = x(beVar, obj, j2, j5, this.b, this.a);
        if (j4 != -9223372036854775807L && grVar.c != -9223372036854775807L) {
            beVar.n(grVar.a.a, this.a).h();
        }
        return u(beVar, x, j4, j2);
    }

    private final gr u(be beVar, te teVar, long j, long j2) {
        beVar.n(teVar.a, this.a);
        boolean b = teVar.b();
        Object obj = teVar.a;
        return b ? v(beVar, obj, teVar.b, teVar.c, j, teVar.d) : w(beVar, obj, j2, j, teVar.d);
    }

    private final gr v(be beVar, Object obj, int i, int i2, long j, long j2) {
        te teVar = new te(obj, i, i2, j2);
        long f = beVar.n(teVar.a, this.a).f(teVar.b, teVar.c);
        if (i2 == this.a.d(i)) {
            this.a.j();
        }
        this.a.l(teVar.b);
        long j3 = 0;
        if (f != -9223372036854775807L && f <= 0) {
            j3 = Math.max(0L, (-1) + f);
        }
        return new gr(teVar, j3, j, -9223372036854775807L, f, false, false, false, false);
    }

    private final gr w(be beVar, Object obj, long j, long j2, long j3) {
        long j4;
        long j5;
        long j6;
        long j7 = j;
        beVar.n(obj, this.a);
        int b = this.a.b(j7);
        bc bcVar = this.a;
        if (b == -1) {
            bcVar.h();
        } else {
            bcVar.l(b);
        }
        te teVar = new te(obj, j3, b);
        boolean C = C(teVar);
        boolean A = A(beVar, teVar);
        boolean z = z(beVar, teVar, C);
        if (b != -1) {
            this.a.l(b);
        }
        if (b != -1) {
            this.a.i(b);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != -9223372036854775807L) {
            j6 = j4;
            j5 = j6;
        } else {
            j5 = this.a.d;
            j6 = -9223372036854775807L;
        }
        if (j5 != -9223372036854775807L && j7 >= j5) {
            j7 = Math.max(0L, j5 - 1);
        }
        return new gr(teVar, j7, j2, j6, j5, false, C, A, z);
    }

    private static te x(be beVar, Object obj, long j, long j2, bd bdVar, bc bcVar) {
        beVar.n(obj, bcVar);
        beVar.o(bcVar.c, bdVar);
        beVar.a(obj);
        if (bcVar.d == 0) {
            bcVar.h();
        }
        beVar.n(obj, bcVar);
        int c = bcVar.c(j);
        return c == -1 ? new te(obj, j2, bcVar.b(j)) : new te(obj, c, bcVar.d(c), j2);
    }

    private final void y() {
        avk j = avo.j();
        for (gq gqVar = this.h; gqVar != null; gqVar = gqVar.h()) {
            j.g(gqVar.f.a);
        }
        gq gqVar2 = this.i;
        this.d.post(new gs(this, j, gqVar2 == null ? null : gqVar2.f.a));
    }

    private final boolean z(be beVar, te teVar, boolean z) {
        int a = beVar.a(teVar.a);
        return !beVar.o(beVar.m(a, this.a).c, this.b).i && beVar.i(a, this.a, this.b, this.f, this.g) == -1 && z;
    }

    public final gq a() {
        gq gqVar = this.h;
        if (gqVar == null) {
            return null;
        }
        if (gqVar == this.i) {
            this.i = gqVar.h();
        }
        this.h.o();
        int i = this.k - 1;
        this.k = i;
        if (i == 0) {
            this.j = null;
            gq gqVar2 = this.h;
            this.l = gqVar2.b;
            this.m = gqVar2.f.a.d;
        }
        this.h = this.h.h();
        y();
        return this.h;
    }

    public final gq b() {
        gq gqVar = this.i;
        boolean z = false;
        if (gqVar != null && gqVar.h() != null) {
            z = true;
        }
        af.w(z);
        this.i = this.i.h();
        y();
        return this.i;
    }

    public final gq c() {
        return this.j;
    }

    public final gq d() {
        return this.h;
    }

    public final gq e() {
        return this.i;
    }

    public final gr f(long j, hb hbVar) {
        gq gqVar = this.j;
        return gqVar == null ? u(hbVar.a, hbVar.b, hbVar.c, hbVar.r) : t(hbVar.a, gqVar, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.v3.internal.gr g(com.google.ads.interactivemedia.v3.internal.be r19, com.google.ads.interactivemedia.v3.internal.gr r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.ads.interactivemedia.v3.internal.te r3 = r2.a
            boolean r12 = C(r3)
            boolean r13 = r0.A(r1, r3)
            boolean r14 = r0.z(r1, r3, r12)
            com.google.ads.interactivemedia.v3.internal.te r4 = r2.a
            java.lang.Object r4 = r4.a
            com.google.ads.interactivemedia.v3.internal.bc r5 = r0.a
            r1.n(r4, r5)
            boolean r1 = r3.b()
            r4 = -1
            r5 = 0
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L2f
            int r1 = r3.e
            if (r1 != r4) goto L31
        L2f:
            r9 = r7
            goto L37
        L31:
            com.google.ads.interactivemedia.v3.internal.bc r9 = r0.a
            r9.i(r1)
            r9 = r5
        L37:
            boolean r1 = r3.b()
            if (r1 == 0) goto L4a
            com.google.ads.interactivemedia.v3.internal.bc r1 = r0.a
            int r5 = r3.b
            int r6 = r3.c
            long r5 = r1.f(r5, r6)
        L47:
            r7 = r9
            r9 = r5
            goto L56
        L4a:
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L51
            r7 = r5
            r9 = r7
            goto L56
        L51:
            com.google.ads.interactivemedia.v3.internal.bc r1 = r0.a
            long r5 = r1.d
            goto L47
        L56:
            boolean r1 = r3.b()
            if (r1 == 0) goto L64
            com.google.ads.interactivemedia.v3.internal.bc r1 = r0.a
            int r4 = r3.b
            r1.l(r4)
            goto L6d
        L64:
            int r1 = r3.e
            if (r1 == r4) goto L6d
            com.google.ads.interactivemedia.v3.internal.bc r4 = r0.a
            r4.l(r1)
        L6d:
            com.google.ads.interactivemedia.v3.internal.gr r15 = new com.google.ads.interactivemedia.v3.internal.gr
            long r4 = r2.b
            long r1 = r2.c
            r11 = 0
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.gt.g(com.google.ads.interactivemedia.v3.internal.be, com.google.ads.interactivemedia.v3.internal.gr):com.google.ads.interactivemedia.v3.internal.gr");
    }

    public final te h(be beVar, Object obj, long j) {
        long j2;
        int a;
        int i = beVar.n(obj, this.a).c;
        Object obj2 = this.l;
        if (obj2 == null || (a = beVar.a(obj2)) == -1 || beVar.m(a, this.a).c != i) {
            gq gqVar = this.h;
            while (true) {
                if (gqVar == null) {
                    gqVar = this.h;
                    while (gqVar != null) {
                        int a2 = beVar.a(gqVar.b);
                        if (a2 == -1 || beVar.m(a2, this.a).c != i) {
                            gqVar = gqVar.h();
                        }
                    }
                    j2 = this.e;
                    this.e = 1 + j2;
                    if (this.h == null) {
                        this.l = obj;
                        this.m = j2;
                    }
                } else {
                    if (gqVar.b.equals(obj)) {
                        break;
                    }
                    gqVar = gqVar.h();
                }
            }
            j2 = gqVar.f.a.d;
        } else {
            j2 = this.m;
        }
        long j3 = j2;
        beVar.n(obj, this.a);
        beVar.o(this.a.c, this.b);
        int a3 = beVar.a(obj);
        Object obj3 = obj;
        while (true) {
            bd bdVar = this.b;
            if (a3 < bdVar.o) {
                return x(beVar, obj3, j, j3, bdVar, this.a);
            }
            beVar.d(a3, this.a, true);
            this.a.h();
            bc bcVar = this.a;
            if (bcVar.c(bcVar.d) != -1) {
                obj3 = this.a.b;
                af.s(obj3);
            }
            a3--;
        }
    }

    public final void i() {
        if (this.k == 0) {
            return;
        }
        gq gqVar = this.h;
        af.t(gqVar);
        this.l = gqVar.b;
        this.m = gqVar.f.a.d;
        while (gqVar != null) {
            gqVar.o();
            gqVar = gqVar.h();
        }
        this.h = null;
        this.j = null;
        this.i = null;
        this.k = 0;
        y();
    }

    public final /* synthetic */ void j(avk avkVar, te teVar) {
        this.c.S(avkVar.f(), teVar);
    }

    public final void k(long j) {
        gq gqVar = this.j;
        if (gqVar != null) {
            gqVar.n(j);
        }
    }

    public final boolean l(td tdVar) {
        gq gqVar = this.j;
        return gqVar != null && gqVar.a == tdVar;
    }

    public final boolean m(gq gqVar) {
        boolean z = false;
        af.w(gqVar != null);
        if (gqVar.equals(this.j)) {
            return false;
        }
        this.j = gqVar;
        while (gqVar.h() != null) {
            gqVar = gqVar.h();
            if (gqVar == this.i) {
                this.i = this.h;
                z = true;
            }
            gqVar.o();
            this.k--;
        }
        this.j.p(null);
        y();
        return z;
    }

    public final boolean n() {
        gq gqVar = this.j;
        if (gqVar != null) {
            return !gqVar.f.i && gqVar.r() && this.j.f.e != -9223372036854775807L && this.k < 100;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean o(com.google.ads.interactivemedia.v3.internal.be r17, long r18, long r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.ads.interactivemedia.v3.internal.gq r2 = r0.h
            r3 = 0
        L7:
            r4 = 1
            if (r2 == 0) goto L96
            com.google.ads.interactivemedia.v3.internal.gr r5 = r2.f
            r6 = 0
            if (r3 != 0) goto L16
            com.google.ads.interactivemedia.v3.internal.gr r3 = r0.g(r1, r5)
            r7 = r18
            goto L39
        L16:
            r7 = r18
            com.google.ads.interactivemedia.v3.internal.gr r9 = r0.t(r1, r3, r7)
            if (r9 != 0) goto L26
            boolean r1 = r0.m(r3)
            if (r1 != 0) goto L25
            return r4
        L25:
            return r6
        L26:
            long r10 = r5.b
            long r12 = r9.b
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 != 0) goto L8e
            com.google.ads.interactivemedia.v3.internal.te r10 = r5.a
            com.google.ads.interactivemedia.v3.internal.te r11 = r9.a
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L8e
            r3 = r9
        L39:
            long r9 = r5.c
            com.google.ads.interactivemedia.v3.internal.gr r9 = r3.a(r9)
            r2.f = r9
            long r9 = r5.e
            long r11 = r3.e
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r5 == 0) goto L85
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 != 0) goto L53
            goto L85
        L53:
            r2.q()
            long r7 = r3.e
            int r1 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r1 != 0) goto L62
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L66
        L62:
            long r7 = r2.g(r7)
        L66:
            com.google.ads.interactivemedia.v3.internal.gq r1 = r0.i
            if (r2 != r1) goto L7a
            com.google.ads.interactivemedia.v3.internal.gr r1 = r2.f
            boolean r1 = r1.f
            r9 = -9223372036854775808
            int r1 = (r20 > r9 ? 1 : (r20 == r9 ? 0 : -1))
            if (r1 == 0) goto L78
            int r1 = (r20 > r7 ? 1 : (r20 == r7 ? 0 : -1))
            if (r1 < 0) goto L7a
        L78:
            r1 = 1
            goto L7b
        L7a:
            r1 = 0
        L7b:
            boolean r2 = r0.m(r2)
            if (r2 != 0) goto L84
            if (r1 != 0) goto L84
            return r4
        L84:
            return r6
        L85:
            com.google.ads.interactivemedia.v3.internal.gq r3 = r2.h()
            r15 = r3
            r3 = r2
            r2 = r15
            goto L7
        L8e:
            boolean r1 = r0.m(r3)
            if (r1 != 0) goto L95
            return r4
        L95:
            return r6
        L96:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.gt.o(com.google.ads.interactivemedia.v3.internal.be, long, long):boolean");
    }

    public final boolean p(be beVar, int i) {
        this.f = i;
        return B(beVar);
    }

    public final boolean q(be beVar, boolean z) {
        this.g = z;
        return B(beVar);
    }

    public final gq r(hi[] hiVarArr, wj wjVar, wr wrVar, ha haVar, gr grVar, wk wkVar) {
        gq gqVar = this.j;
        gq gqVar2 = new gq(hiVarArr, gqVar == null ? 1000000000000L : (gqVar.d() + this.j.f.e) - grVar.b, wjVar, wrVar, haVar, grVar, wkVar);
        gq gqVar3 = this.j;
        if (gqVar3 != null) {
            gqVar3.p(gqVar2);
        } else {
            this.h = gqVar2;
            this.i = gqVar2;
        }
        this.l = null;
        this.j = gqVar2;
        this.k++;
        y();
        return gqVar2;
    }
}
