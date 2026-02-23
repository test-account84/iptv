package B3;

import B3.C;
import O2.H0;
import O2.Q1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w extends k0 {
    public final boolean n;
    public final Q1.d o;
    public final Q1.b p;
    public a q;
    public v r;
    public boolean s;
    public boolean t;
    public boolean u;

    public static final class a extends s {
        public static final Object j = new Object();
        public final Object h;
        public final Object i;

        public a(Q1 q1, Object obj, Object obj2) {
            super(q1);
            this.h = obj;
            this.i = obj2;
        }

        public static a A(Q1 q1, Object obj, Object obj2) {
            return new a(q1, obj, obj2);
        }

        public static /* synthetic */ Object x(a aVar) {
            return aVar.i;
        }

        public static a z(H0 h0) {
            return new a(new b(h0), Q1.d.s, j);
        }

        public int f(Object obj) {
            Object obj2;
            Q1 q1 = this.g;
            if (j.equals(obj) && (obj2 = this.i) != null) {
                obj = obj2;
            }
            return q1.f(obj);
        }

        public Q1.b l(int i, Q1.b bVar, boolean z) {
            this.g.l(i, bVar, z);
            if (d4.k0.c(bVar.c, this.i) && z) {
                bVar.c = j;
            }
            return bVar;
        }

        public Object r(int i) {
            Object r = this.g.r(i);
            return d4.k0.c(r, this.i) ? j : r;
        }

        public Q1.d t(int i, Q1.d dVar, long j2) {
            this.g.t(i, dVar, j2);
            if (d4.k0.c(dVar.a, this.h)) {
                dVar.a = Q1.d.s;
            }
            return dVar;
        }

        public a y(Q1 q1) {
            return new a(q1, this.h, this.i);
        }
    }

    public static final class b extends Q1 {
        public final H0 g;

        public b(H0 h0) {
            this.g = h0;
        }

        public int f(Object obj) {
            return obj == a.j ? 0 : -1;
        }

        public Q1.b l(int i, Q1.b bVar, boolean z) {
            bVar.z(z ? 0 : null, z ? a.j : null, 0, -9223372036854775807L, 0L, C3.b.h, true);
            return bVar;
        }

        public int n() {
            return 1;
        }

        public Object r(int i) {
            return a.j;
        }

        public Q1.d t(int i, Q1.d dVar, long j) {
            dVar.j(Q1.d.s, this.g, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            dVar.m = true;
            return dVar;
        }

        public int u() {
            return 1;
        }
    }

    public w(C c, boolean z) {
        super(c);
        this.n = z && c.S();
        this.o = new Q1.d();
        this.p = new Q1.b();
        Q1 U = c.U();
        if (U == null) {
            this.q = a.z(c.e());
        } else {
            this.q = a.A(U, null, null);
            this.u = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C0(O2.Q1 r15) {
        /*
            r14 = this;
            boolean r0 = r14.t
            if (r0 == 0) goto L19
            B3.w$a r0 = r14.q
            B3.w$a r15 = r0.y(r15)
            r14.q = r15
            B3.v r15 = r14.r
            if (r15 == 0) goto Lae
            long r0 = r15.o()
            r14.K0(r0)
            goto Lae
        L19:
            boolean r0 = r15.v()
            if (r0 == 0) goto L36
            boolean r0 = r14.u
            if (r0 == 0) goto L2a
            B3.w$a r0 = r14.q
            B3.w$a r15 = r0.y(r15)
            goto L32
        L2a:
            java.lang.Object r0 = O2.Q1.d.s
            java.lang.Object r1 = B3.w.a.j
            B3.w$a r15 = B3.w.a.A(r15, r0, r1)
        L32:
            r14.q = r15
            goto Lae
        L36:
            O2.Q1$d r0 = r14.o
            r1 = 0
            r15.s(r1, r0)
            O2.Q1$d r0 = r14.o
            long r2 = r0.e()
            O2.Q1$d r0 = r14.o
            java.lang.Object r0 = r0.a
            B3.v r4 = r14.r
            if (r4 == 0) goto L74
            long r4 = r4.q()
            B3.w$a r6 = r14.q
            B3.v r7 = r14.r
            B3.C$b r7 = r7.a
            java.lang.Object r7 = r7.a
            O2.Q1$b r8 = r14.p
            r6.m(r7, r8)
            O2.Q1$b r6 = r14.p
            long r6 = r6.t()
            long r6 = r6 + r4
            B3.w$a r4 = r14.q
            O2.Q1$d r5 = r14.o
            O2.Q1$d r1 = r4.s(r1, r5)
            long r4 = r1.e()
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 == 0) goto L74
            r12 = r6
            goto L75
        L74:
            r12 = r2
        L75:
            O2.Q1$d r9 = r14.o
            O2.Q1$b r10 = r14.p
            r11 = 0
            r8 = r15
            android.util.Pair r1 = r8.o(r9, r10, r11, r12)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            boolean r1 = r14.u
            if (r1 == 0) goto L94
            B3.w$a r0 = r14.q
            B3.w$a r15 = r0.y(r15)
            goto L98
        L94:
            B3.w$a r15 = B3.w.a.A(r15, r0, r2)
        L98:
            r14.q = r15
            B3.v r15 = r14.r
            if (r15 == 0) goto Lae
            r14.K0(r3)
            B3.C$b r15 = r15.a
            java.lang.Object r0 = r15.a
            java.lang.Object r0 = r14.I0(r0)
            B3.C$b r15 = r15.c(r0)
            goto Laf
        Lae:
            r15 = 0
        Laf:
            r0 = 1
            r14.u = r0
            r14.t = r0
            B3.w$a r0 = r14.q
            r14.m0(r0)
            if (r15 == 0) goto Lc6
            B3.v r0 = r14.r
            java.lang.Object r0 = d4.a.e(r0)
            B3.v r0 = (B3.v) r0
            r0.a(r15)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.w.C0(O2.Q1):void");
    }

    public void F0() {
        if (this.n) {
            return;
        }
        this.s = true;
        E0();
    }

    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public v E(C.b bVar, b4.b bVar2, long j) {
        v vVar = new v(bVar, bVar2, j);
        vVar.y(this.l);
        if (this.t) {
            vVar.a(bVar.c(I0(bVar.a)));
        } else {
            this.r = vVar;
            if (!this.s) {
                this.s = true;
                E0();
            }
        }
        return vVar;
    }

    public final Object H0(Object obj) {
        return (a.x(this.q) == null || !a.x(this.q).equals(obj)) ? obj : a.j;
    }

    public final Object I0(Object obj) {
        return (a.x(this.q) == null || !obj.equals(a.j)) ? obj : a.x(this.q);
    }

    public Q1 J0() {
        return this.q;
    }

    public final void K0(long j) {
        v vVar = this.r;
        int f = this.q.f(vVar.a.a);
        if (f == -1) {
            return;
        }
        long j2 = this.q.k(f, this.p).e;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        vVar.w(j);
    }

    public void Y(z zVar) {
        ((v) zVar).x();
        if (zVar == this.r) {
            this.r = null;
        }
    }

    public void n0() {
        this.t = false;
        this.s = false;
        super.n0();
    }

    public C.b w0(C.b bVar) {
        return bVar.c(H0(bVar.a));
    }

    public void P() {
    }
}
