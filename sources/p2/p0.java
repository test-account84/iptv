package P2;

import B3.C;
import O2.H0;
import O2.Q1;
import O2.R0;
import O2.V1;
import O2.p1;
import O2.s1;
import O2.t1;
import O2.z0;
import P2.c;
import android.os.Looper;
import android.util.SparseArray;
import d4.A;
import java.io.IOException;
import java.util.List;
import s5.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class p0 implements P2.a {
    public final d4.e a;
    public final Q1.b c;
    public final Q1.d d;
    public final a e;
    public final SparseArray f;
    public d4.A g;
    public t1 h;
    public d4.w i;
    public boolean j;

    public static final class a {
        public final Q1.b a;
        public s5.y b = s5.y.z();
        public s5.A c = s5.A.k();
        public C.b d;
        public C.b e;
        public C.b f;

        public a(Q1.b bVar) {
            this.a = bVar;
        }

        public static /* synthetic */ s5.y a(a aVar) {
            return aVar.b;
        }

        public static C.b c(t1 t1Var, s5.y yVar, C.b bVar, Q1.b bVar2) {
            Q1 w = t1Var.w();
            int J = t1Var.J();
            Object r = w.v() ? null : w.r(J);
            int g = (t1Var.d() || w.v()) ? -1 : w.k(J, bVar2).g(d4.k0.P0(t1Var.getCurrentPosition()) - bVar2.t());
            for (int i = 0; i < yVar.size(); i++) {
                C.b bVar3 = (C.b) yVar.get(i);
                if (i(bVar3, r, t1Var.d(), t1Var.s(), t1Var.N(), g)) {
                    return bVar3;
                }
            }
            if (yVar.isEmpty() && bVar != null) {
                if (i(bVar, r, t1Var.d(), t1Var.s(), t1Var.N(), g)) {
                    return bVar;
                }
            }
            return null;
        }

        public static boolean i(C.b bVar, Object obj, boolean z, int i, int i2, int i3) {
            if (bVar.a.equals(obj)) {
                return (z && bVar.b == i && bVar.c == i2) || (!z && bVar.b == -1 && bVar.e == i3);
            }
            return false;
        }

        public final void b(A.a aVar, C.b bVar, Q1 q1) {
            if (bVar == null) {
                return;
            }
            if (q1.f(bVar.a) == -1 && (q1 = (Q1) this.c.get(bVar)) == null) {
                return;
            }
            aVar.f(bVar, q1);
        }

        public C.b d() {
            return this.d;
        }

        public C.b e() {
            if (this.b.isEmpty()) {
                return null;
            }
            return (C.b) s5.D.d(this.b);
        }

        public Q1 f(C.b bVar) {
            return (Q1) this.c.get(bVar);
        }

        public C.b g() {
            return this.e;
        }

        public C.b h() {
            return this.f;
        }

        public void j(t1 t1Var) {
            this.d = c(t1Var, this.b, this.e, this.a);
        }

        public void k(List list, C.b bVar, t1 t1Var) {
            this.b = s5.y.r(list);
            if (!list.isEmpty()) {
                this.e = (C.b) list.get(0);
                this.f = (C.b) d4.a.e(bVar);
            }
            if (this.d == null) {
                this.d = c(t1Var, this.b, this.e, this.a);
            }
            m(t1Var.w());
        }

        public void l(t1 t1Var) {
            this.d = c(t1Var, this.b, this.e, this.a);
            m(t1Var.w());
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m(O2.Q1 r4) {
            /*
                r3 = this;
                s5.A$a r0 = s5.A.a()
                s5.y r1 = r3.b
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L3a
                B3.C$b r1 = r3.e
                r3.b(r0, r1, r4)
                B3.C$b r1 = r3.f
                B3.C$b r2 = r3.e
                boolean r1 = r5.j.a(r1, r2)
                if (r1 != 0) goto L20
                B3.C$b r1 = r3.f
                r3.b(r0, r1, r4)
            L20:
                B3.C$b r1 = r3.d
                B3.C$b r2 = r3.e
                boolean r1 = r5.j.a(r1, r2)
                if (r1 != 0) goto L5c
                B3.C$b r1 = r3.d
                B3.C$b r2 = r3.f
                boolean r1 = r5.j.a(r1, r2)
                if (r1 != 0) goto L5c
            L34:
                B3.C$b r1 = r3.d
                r3.b(r0, r1, r4)
                goto L5c
            L3a:
                r1 = 0
            L3b:
                s5.y r2 = r3.b
                int r2 = r2.size()
                if (r1 >= r2) goto L51
                s5.y r2 = r3.b
                java.lang.Object r2 = r2.get(r1)
                B3.C$b r2 = (B3.C.b) r2
                r3.b(r0, r2, r4)
                int r1 = r1 + 1
                goto L3b
            L51:
                s5.y r1 = r3.b
                B3.C$b r2 = r3.d
                boolean r1 = r1.contains(r2)
                if (r1 != 0) goto L5c
                goto L34
            L5c:
                s5.A r4 = r0.c()
                r3.c = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: P2.p0.a.m(O2.Q1):void");
        }
    }

    public p0(d4.e eVar) {
        this.a = (d4.e) d4.a.e(eVar);
        this.g = new d4.A(d4.k0.S(), eVar, new A());
        Q1.b bVar = new Q1.b();
        this.c = bVar;
        this.d = new Q1.d();
        this.e = new a(bVar);
        this.f = new SparseArray();
    }

    public static /* synthetic */ void A0(c.a aVar, boolean z, int i, c cVar) {
        w2(aVar, z, i, cVar);
    }

    public static /* synthetic */ void A2(c.a aVar, boolean z, c cVar) {
        cVar.b0(aVar, z);
    }

    public static /* synthetic */ void B0(c.a aVar, int i, c cVar) {
        D2(aVar, i, cVar);
    }

    public static /* synthetic */ void B2(c.a aVar, boolean z, c cVar) {
        cVar.l0(aVar, z);
    }

    public static /* synthetic */ void C0(c.a aVar, U2.e eVar, c cVar) {
        K2(aVar, eVar, cVar);
    }

    public static /* synthetic */ void C2(c.a aVar, int i, int i2, c cVar) {
        cVar.o(aVar, i, i2);
    }

    public static /* synthetic */ void D0(c.a aVar, B3.x xVar, c cVar) {
        Z1(aVar, xVar, cVar);
    }

    public static /* synthetic */ void D2(c.a aVar, int i, c cVar) {
        cVar.e0(aVar, i);
    }

    public static /* synthetic */ void E0(c.a aVar, int i, c cVar) {
        z2(aVar, i, cVar);
    }

    public static /* synthetic */ void E2(c.a aVar, Z3.z zVar, c cVar) {
        cVar.h(aVar, zVar);
    }

    public static /* synthetic */ void F0(c.a aVar, B3.u uVar, B3.x xVar, c cVar) {
        k2(aVar, uVar, xVar, cVar);
    }

    public static /* synthetic */ void F2(c.a aVar, V1 v1, c cVar) {
        cVar.k(aVar, v1);
    }

    public static /* synthetic */ void G0(c.a aVar, B3.u uVar, B3.x xVar, IOException iOException, boolean z, c cVar) {
        l2(aVar, uVar, xVar, iOException, z, cVar);
    }

    public static /* synthetic */ void G2(c.a aVar, B3.x xVar, c cVar) {
        cVar.G(aVar, xVar);
    }

    public static /* synthetic */ void H0(c.a aVar, Exception exc, c cVar) {
        K1(aVar, exc, cVar);
    }

    public static /* synthetic */ void H2(c.a aVar, Exception exc, c cVar) {
        cVar.U(aVar, exc);
    }

    public static /* synthetic */ void I0(c.a aVar, boolean z, c cVar) {
        A2(aVar, z, cVar);
    }

    public static /* synthetic */ void I1(c.a aVar, c cVar) {
        cVar.i(aVar);
    }

    public static /* synthetic */ void I2(c.a aVar, String str, long j, long j2, c cVar) {
        cVar.u(aVar, str, j);
        cVar.t0(aVar, str, j2, j);
    }

    public static /* synthetic */ void J0(c.a aVar, O2.u uVar, c cVar) {
        X1(aVar, uVar, cVar);
    }

    public static /* synthetic */ void J1(c.a aVar, Q2.e eVar, c cVar) {
        cVar.M(aVar, eVar);
    }

    public static /* synthetic */ void J2(c.a aVar, String str, c cVar) {
        cVar.N(aVar, str);
    }

    public static /* synthetic */ void K0(c.a aVar, B3.u uVar, B3.x xVar, c cVar) {
        m2(aVar, uVar, xVar, cVar);
    }

    public static /* synthetic */ void K1(c.a aVar, Exception exc, c cVar) {
        cVar.I(aVar, exc);
    }

    public static /* synthetic */ void K2(c.a aVar, U2.e eVar, c cVar) {
        cVar.E(aVar, eVar);
    }

    public static /* synthetic */ void L0(c.a aVar, c cVar) {
        a2(aVar, cVar);
    }

    public static /* synthetic */ void L1(c.a aVar, String str, long j, long j2, c cVar) {
        cVar.g0(aVar, str, j);
        cVar.s(aVar, str, j2, j);
    }

    public static /* synthetic */ void L2(c.a aVar, U2.e eVar, c cVar) {
        cVar.T(aVar, eVar);
    }

    public static /* synthetic */ void M0(c.a aVar, int i, c cVar) {
        d2(aVar, i, cVar);
    }

    public static /* synthetic */ void M1(c.a aVar, String str, c cVar) {
        cVar.Z(aVar, str);
    }

    public static /* synthetic */ void M2(c.a aVar, long j, int i, c cVar) {
        cVar.n(aVar, j, i);
    }

    public static /* synthetic */ void N0(c.a aVar, c cVar) {
        f2(aVar, cVar);
    }

    public static /* synthetic */ void N1(c.a aVar, U2.e eVar, c cVar) {
        cVar.s0(aVar, eVar);
    }

    public static /* synthetic */ void N2(c.a aVar, z0 z0Var, U2.h hVar, c cVar) {
        cVar.R(aVar, z0Var);
        cVar.a(aVar, z0Var, hVar);
    }

    public static /* synthetic */ void O0(c.a aVar, t1.b bVar, c cVar) {
        T1(aVar, bVar, cVar);
    }

    public static /* synthetic */ void O1(c.a aVar, U2.e eVar, c cVar) {
        cVar.q(aVar, eVar);
    }

    public static /* synthetic */ void O2(c.a aVar, e4.C c, c cVar) {
        cVar.o0(aVar, c);
        cVar.O(aVar, c.a, c.c, c.d, c.e);
    }

    public static /* synthetic */ void P0(c.a aVar, B3.x xVar, c cVar) {
        G2(aVar, xVar, cVar);
    }

    public static /* synthetic */ void P1(c.a aVar, z0 z0Var, U2.h hVar, c cVar) {
        cVar.n0(aVar, z0Var);
        cVar.l(aVar, z0Var, hVar);
    }

    public static /* synthetic */ void P2(c.a aVar, c cVar) {
        cVar.Q(aVar);
    }

    public static /* synthetic */ void Q0(c.a aVar, e4.C c, c cVar) {
        O2(aVar, c, cVar);
    }

    public static /* synthetic */ void Q1(c.a aVar, long j, c cVar) {
        cVar.c0(aVar, j);
    }

    public static /* synthetic */ void R0(c.a aVar, boolean z, c cVar) {
        i2(aVar, z, cVar);
    }

    public static /* synthetic */ void R1(c.a aVar, Exception exc, c cVar) {
        cVar.j(aVar, exc);
    }

    public static /* synthetic */ void S0(c.a aVar, long j, c cVar) {
        Q1(aVar, j, cVar);
    }

    public static /* synthetic */ void S1(c.a aVar, int i, long j, long j2, c cVar) {
        cVar.B(aVar, i, j, j2);
    }

    public static /* synthetic */ void T0(c.a aVar, c cVar) {
        P2(aVar, cVar);
    }

    public static /* synthetic */ void T1(c.a aVar, t1.b bVar, c cVar) {
        cVar.w(aVar, bVar);
    }

    public static /* synthetic */ void U0(c.a aVar, H0 h0, int i, c cVar) {
        n2(aVar, h0, i, cVar);
    }

    public static /* synthetic */ void U1(c.a aVar, int i, long j, long j2, c cVar) {
        cVar.i0(aVar, i, j, j2);
    }

    public static /* synthetic */ void V0(c.a aVar, int i, int i2, c cVar) {
        C2(aVar, i, i2, cVar);
    }

    public static /* synthetic */ void V1(c.a aVar, List list, c cVar) {
        cVar.q0(aVar, list);
    }

    public static /* synthetic */ void W0(c.a aVar, boolean z, c cVar) {
        h2(aVar, z, cVar);
    }

    public static /* synthetic */ void W1(c.a aVar, P3.f fVar, c cVar) {
        cVar.r(aVar, fVar);
    }

    public static /* synthetic */ void X0(c.a aVar, c cVar) {
        c2(aVar, cVar);
    }

    public static /* synthetic */ void X1(c.a aVar, O2.u uVar, c cVar) {
        cVar.J(aVar, uVar);
    }

    public static /* synthetic */ void Y0(c.a aVar, Object obj, long j, c cVar) {
        y2(aVar, obj, j, cVar);
    }

    public static /* synthetic */ void Y1(c.a aVar, int i, boolean z, c cVar) {
        cVar.m0(aVar, i, z);
    }

    public static /* synthetic */ void Z0(c.a aVar, int i, long j, c cVar) {
        g2(aVar, i, j, cVar);
    }

    public static /* synthetic */ void Z1(c.a aVar, B3.x xVar, c cVar) {
        cVar.Y(aVar, xVar);
    }

    public static /* synthetic */ void a1(c.a aVar, boolean z, int i, c cVar) {
        q2(aVar, z, i, cVar);
    }

    public static /* synthetic */ void a2(c.a aVar, c cVar) {
        cVar.k0(aVar);
    }

    public static /* synthetic */ void b1(c.a aVar, V1 v1, c cVar) {
        F2(aVar, v1, cVar);
    }

    public static /* synthetic */ void b2(c.a aVar, c cVar) {
        cVar.m(aVar);
    }

    public static /* synthetic */ void c1(c.a aVar, int i, c cVar) {
        t2(aVar, i, cVar);
    }

    public static /* synthetic */ void c2(c.a aVar, c cVar) {
        cVar.c(aVar);
    }

    public static /* synthetic */ void d1(c.a aVar, Q2.e eVar, c cVar) {
        J1(aVar, eVar, cVar);
    }

    public static /* synthetic */ void d2(c.a aVar, int i, c cVar) {
        cVar.f(aVar);
        cVar.X(aVar, i);
    }

    public static /* synthetic */ void e1(p0 p0Var, t1 t1Var, c cVar, d4.s sVar) {
        p0Var.Q2(t1Var, cVar, sVar);
    }

    public static /* synthetic */ void e2(c.a aVar, Exception exc, c cVar) {
        cVar.W(aVar, exc);
    }

    public static /* synthetic */ void f1(c.a aVar, q3.a aVar2, c cVar) {
        p2(aVar, aVar2, cVar);
    }

    public static /* synthetic */ void f2(c.a aVar, c cVar) {
        cVar.L(aVar);
    }

    public static /* synthetic */ void g1(c.a aVar, Exception exc, c cVar) {
        H2(aVar, exc, cVar);
    }

    public static /* synthetic */ void g2(c.a aVar, int i, long j, c cVar) {
        cVar.h0(aVar, i, j);
    }

    public static /* synthetic */ void h1(c.a aVar, s1 s1Var, c cVar) {
        r2(aVar, s1Var, cVar);
    }

    public static /* synthetic */ void h2(c.a aVar, boolean z, c cVar) {
        cVar.P(aVar, z);
        cVar.g(aVar, z);
    }

    public static /* synthetic */ void i1(c.a aVar, U2.e eVar, c cVar) {
        O1(aVar, eVar, cVar);
    }

    public static /* synthetic */ void i2(c.a aVar, boolean z, c cVar) {
        cVar.A(aVar, z);
    }

    public static /* synthetic */ void j1(c.a aVar, c cVar) {
        b2(aVar, cVar);
    }

    public static /* synthetic */ void j2(c.a aVar, B3.u uVar, B3.x xVar, c cVar) {
        cVar.p0(aVar, uVar, xVar);
    }

    public static /* synthetic */ void k1(c.a aVar, Exception exc, c cVar) {
        e2(aVar, exc, cVar);
    }

    public static /* synthetic */ void k2(c.a aVar, B3.u uVar, B3.x xVar, c cVar) {
        cVar.y(aVar, uVar, xVar);
    }

    public static /* synthetic */ void l1(c.a aVar, P3.f fVar, c cVar) {
        W1(aVar, fVar, cVar);
    }

    public static /* synthetic */ void l2(c.a aVar, B3.u uVar, B3.x xVar, IOException iOException, boolean z, c cVar) {
        cVar.a0(aVar, uVar, xVar, iOException, z);
    }

    public static /* synthetic */ void m1(c.a aVar, int i, boolean z, c cVar) {
        Y1(aVar, i, z, cVar);
    }

    public static /* synthetic */ void m2(c.a aVar, B3.u uVar, B3.x xVar, c cVar) {
        cVar.d(aVar, uVar, xVar);
    }

    public static /* synthetic */ void n1(c.a aVar, z0 z0Var, U2.h hVar, c cVar) {
        P1(aVar, z0Var, hVar, cVar);
    }

    public static /* synthetic */ void n2(c.a aVar, H0 h0, int i, c cVar) {
        cVar.C(aVar, h0, i);
    }

    public static /* synthetic */ void o0(c.a aVar, int i, long j, long j2, c cVar) {
        U1(aVar, i, j, j2, cVar);
    }

    public static /* synthetic */ void o1(c.a aVar, z0 z0Var, U2.h hVar, c cVar) {
        N2(aVar, z0Var, hVar, cVar);
    }

    public static /* synthetic */ void o2(c.a aVar, R0 r0, c cVar) {
        cVar.H(aVar, r0);
    }

    public static /* synthetic */ void p0(c.a aVar, String str, c cVar) {
        M1(aVar, str, cVar);
    }

    public static /* synthetic */ void p1(c.a aVar, List list, c cVar) {
        V1(aVar, list, cVar);
    }

    public static /* synthetic */ void p2(c.a aVar, q3.a aVar2, c cVar) {
        cVar.d0(aVar, aVar2);
    }

    public static /* synthetic */ void q0(c.a aVar, U2.e eVar, c cVar) {
        N1(aVar, eVar, cVar);
    }

    public static /* synthetic */ void q1(c.a aVar, Z3.z zVar, c cVar) {
        E2(aVar, zVar, cVar);
    }

    public static /* synthetic */ void q2(c.a aVar, boolean z, int i, c cVar) {
        cVar.j0(aVar, z, i);
    }

    public static /* synthetic */ void r0(c.a aVar, boolean z, c cVar) {
        B2(aVar, z, cVar);
    }

    public static /* synthetic */ void r1(p0 p0Var) {
        p0Var.R2();
    }

    public static /* synthetic */ void r2(c.a aVar, s1 s1Var, c cVar) {
        cVar.t(aVar, s1Var);
    }

    public static /* synthetic */ void s0(c.a aVar, long j, int i, c cVar) {
        M2(aVar, j, i, cVar);
    }

    public static /* synthetic */ void s1(c.a aVar, String str, c cVar) {
        J2(aVar, str, cVar);
    }

    public static /* synthetic */ void s2(c.a aVar, int i, c cVar) {
        cVar.V(aVar, i);
    }

    public static /* synthetic */ void t0(c.a aVar, Exception exc, c cVar) {
        R1(aVar, exc, cVar);
    }

    public static /* synthetic */ void t1(c.a aVar, int i, t1.e eVar, t1.e eVar2, c cVar) {
        x2(aVar, i, eVar, eVar2, cVar);
    }

    public static /* synthetic */ void t2(c.a aVar, int i, c cVar) {
        cVar.K(aVar, i);
    }

    public static /* synthetic */ void u0(c.a aVar, B3.u uVar, B3.x xVar, c cVar) {
        j2(aVar, uVar, xVar, cVar);
    }

    public static /* synthetic */ void u1(c.a aVar, c cVar) {
        I1(aVar, cVar);
    }

    public static /* synthetic */ void u2(c.a aVar, p1 p1Var, c cVar) {
        cVar.F(aVar, p1Var);
    }

    public static /* synthetic */ void v0(c.a aVar, int i, c cVar) {
        s2(aVar, i, cVar);
    }

    public static /* synthetic */ void v1(c.a aVar, String str, long j, long j2, c cVar) {
        L1(aVar, str, j, j2, cVar);
    }

    public static /* synthetic */ void v2(c.a aVar, p1 p1Var, c cVar) {
        cVar.r0(aVar, p1Var);
    }

    public static /* synthetic */ void w0(c cVar, d4.s sVar) {
        H1(cVar, sVar);
    }

    public static /* synthetic */ void w1(c.a aVar, String str, long j, long j2, c cVar) {
        I2(aVar, str, j, j2, cVar);
    }

    public static /* synthetic */ void w2(c.a aVar, boolean z, int i, c cVar) {
        cVar.f0(aVar, z, i);
    }

    public static /* synthetic */ void x0(c.a aVar, p1 p1Var, c cVar) {
        v2(aVar, p1Var, cVar);
    }

    public static /* synthetic */ void x1(c.a aVar, p1 p1Var, c cVar) {
        u2(aVar, p1Var, cVar);
    }

    public static /* synthetic */ void x2(c.a aVar, int i, t1.e eVar, t1.e eVar2, c cVar) {
        cVar.e(aVar, i);
        cVar.p(aVar, eVar, eVar2, i);
    }

    public static /* synthetic */ void y0(c.a aVar, U2.e eVar, c cVar) {
        L2(aVar, eVar, cVar);
    }

    public static /* synthetic */ void y1(c.a aVar, int i, long j, long j2, c cVar) {
        S1(aVar, i, j, j2, cVar);
    }

    public static /* synthetic */ void y2(c.a aVar, Object obj, long j, c cVar) {
        cVar.D(aVar, obj, j);
    }

    public static /* synthetic */ void z0(c.a aVar, R0 r0, c cVar) {
        o2(aVar, r0, cVar);
    }

    public static /* synthetic */ void z2(c.a aVar, int i, c cVar) {
        cVar.z(aVar, i);
    }

    public final void A(Q2.e eVar) {
        c.a F1 = F1();
        S2(F1, 20, new m0(F1, eVar));
    }

    public final c.a A1(C.b bVar) {
        d4.a.e(this.h);
        Q1 f = bVar == null ? null : this.e.f(bVar);
        if (bVar != null && f != null) {
            return B1(f, f.m(bVar.a, this.c).d, bVar);
        }
        int X = this.h.X();
        Q1 w = this.h.w();
        if (X >= w.u()) {
            w = Q1.a;
        }
        return B1(w, X, null);
    }

    public final c.a B1(Q1 q1, int i, C.b bVar) {
        C.b bVar2 = q1.v() ? null : bVar;
        long b = this.a.b();
        boolean z = q1.equals(this.h.w()) && i == this.h.X();
        long j = 0;
        if (bVar2 == null || !bVar2.b()) {
            if (z) {
                j = this.h.R();
            } else if (!q1.v()) {
                j = q1.s(i, this.d).d();
            }
        } else if (z && this.h.s() == bVar2.b && this.h.N() == bVar2.c) {
            j = this.h.getCurrentPosition();
        }
        return new c.a(b, q1, i, bVar2, j, this.h.w(), this.h.X(), this.e.d(), this.h.getCurrentPosition(), this.h.e());
    }

    public final void C(int i, C.b bVar) {
        c.a D1 = D1(i, bVar);
        S2(D1, 1025, new i0(D1));
    }

    public final c.a C1() {
        return A1(this.e.e());
    }

    public final void D(int i, C.b bVar, B3.u uVar, B3.x xVar) {
        c.a D1 = D1(i, bVar);
        S2(D1, 1001, new j(D1, uVar, xVar));
    }

    public final c.a D1(int i, C.b bVar) {
        d4.a.e(this.h);
        if (bVar != null) {
            return this.e.f(bVar) != null ? A1(bVar) : B1(Q1.a, i, bVar);
        }
        Q1 w = this.h.w();
        if (i >= w.u()) {
            w = Q1.a;
        }
        return B1(w, i, null);
    }

    public final void E(int i) {
        c.a z1 = z1();
        S2(z1, 4, new x(z1, i));
    }

    public final c.a E1() {
        return A1(this.e.g());
    }

    public final void F(int i, long j, long j2) {
        c.a C1 = C1();
        S2(C1, 1006, new j0(C1, i, j, j2));
    }

    public final c.a F1() {
        return A1(this.e.h());
    }

    public final void G(int i, C.b bVar) {
        c.a D1 = D1(i, bVar);
        S2(D1, 1026, new b0(D1));
    }

    public final c.a G1(p1 p1Var) {
        B3.A a2;
        return (!(p1Var instanceof O2.w) || (a2 = ((O2.w) p1Var).o) == null) ? z1() : A1(new C.b(a2));
    }

    public final void H() {
        if (this.j) {
            return;
        }
        c.a z1 = z1();
        this.j = true;
        S2(z1, -1, new l(z1));
    }

    public final void I(int i, C.b bVar, B3.u uVar, B3.x xVar) {
        c.a D1 = D1(i, bVar);
        S2(D1, 1002, new h0(D1, uVar, xVar));
    }

    public final void J(boolean z) {
        c.a z1 = z1();
        S2(z1, 9, new e(z1, z));
    }

    public /* synthetic */ void K(int i, C.b bVar) {
        V2.p.a(this, i, bVar);
    }

    public final void L(int i, C.b bVar, B3.u uVar, B3.x xVar, IOException iOException, boolean z) {
        c.a D1 = D1(i, bVar);
        S2(D1, 1003, new q(D1, uVar, xVar, iOException, z));
    }

    public void M(int i, boolean z) {
        c.a z1 = z1();
        S2(z1, 30, new Y(z1, i, z));
    }

    public final void N(int i, C.b bVar, int i2) {
        c.a D1 = D1(i, bVar);
        S2(D1, 1022, new V(D1, i2));
    }

    public void O(t1.b bVar) {
        c.a z1 = z1();
        S2(z1, 13, new u(z1, bVar));
    }

    public final void Q(int i, C.b bVar, Exception exc) {
        c.a D1 = D1(i, bVar);
        S2(D1, 1024, new Q(D1, exc));
    }

    public final /* synthetic */ void Q2(t1 t1Var, c cVar, d4.s sVar) {
        cVar.u0(t1Var, new c.b(sVar, this.f));
    }

    public final void R(int i, C.b bVar, B3.u uVar, B3.x xVar) {
        c.a D1 = D1(i, bVar);
        S2(D1, 1000, new K(D1, uVar, xVar));
    }

    public final void R2() {
        c.a z1 = z1();
        S2(z1, 1028, new f0(z1));
        this.g.j();
    }

    public final void S(t1.e eVar, t1.e eVar2, int i) {
        if (i == 1) {
            this.j = false;
        }
        this.e.j((t1) d4.a.e(this.h));
        c.a z1 = z1();
        S2(z1, 11, new S(z1, i, eVar, eVar2));
    }

    public final void S2(c.a aVar, int i, A.a aVar2) {
        this.f.put(i, aVar);
        this.g.l(i, aVar2);
    }

    public final void T(int i, C.b bVar) {
        c.a D1 = D1(i, bVar);
        S2(D1, 1023, new g0(D1));
    }

    public final void U(int i, int i2) {
        c.a F1 = F1();
        S2(F1, 24, new p(F1, i, i2));
    }

    public final void V(Q1 q1, int i) {
        this.e.l((t1) d4.a.e(this.h));
        c.a z1 = z1();
        S2(z1, 0, new U(z1, i));
    }

    public void W(p1 p1Var) {
        c.a G1 = G1(p1Var);
        S2(G1, 10, new L(G1, p1Var));
    }

    public void X(c cVar) {
        d4.a.e(cVar);
        this.g.c(cVar);
    }

    public void Y(Z3.z zVar) {
        c.a z1 = z1();
        S2(z1, 19, new B(z1, zVar));
    }

    public final void Z(int i, C.b bVar, B3.x xVar) {
        c.a D1 = D1(i, bVar);
        S2(D1, 1004, new n(D1, xVar));
    }

    public final void a(boolean z) {
        c.a F1 = F1();
        S2(F1, 23, new k0(F1, z));
    }

    public void a0(O2.u uVar) {
        c.a z1 = z1();
        S2(z1, 29, new X(z1, uVar));
    }

    public final void b(Exception exc) {
        c.a F1 = F1();
        S2(F1, 1014, new N(F1, exc));
    }

    public final void c(String str) {
        c.a F1 = F1();
        S2(F1, 1019, new a0(F1, str));
    }

    public final void c0(int i, C.b bVar) {
        c.a D1 = D1(i, bVar);
        S2(D1, 1027, new G(D1));
    }

    public final void d(String str, long j, long j2) {
        c.a F1 = F1();
        S2(F1, 1016, new y(F1, str, j2, j));
    }

    public final void d0(boolean z) {
        c.a z1 = z1();
        S2(z1, 3, new W(z1, z));
    }

    public final void e(q3.a aVar) {
        c.a z1 = z1();
        S2(z1, 28, new Z(z1, aVar));
    }

    public final void e0(List list, C.b bVar) {
        this.e.k(list, bVar, (t1) d4.a.e(this.h));
    }

    public final void f(String str) {
        c.a F1 = F1();
        S2(F1, 1012, new D(F1, str));
    }

    public void f0(V1 v1) {
        c.a z1 = z1();
        S2(z1, 2, new I(z1, v1));
    }

    public final void g(String str, long j, long j2) {
        c.a F1 = F1();
        S2(F1, 1008, new d(F1, str, j2, j));
    }

    public final void g0(boolean z, int i) {
        c.a z1 = z1();
        S2(z1, -1, new k(z1, z, i));
    }

    public final void h(U2.e eVar) {
        c.a E1 = E1();
        S2(E1, 1020, new z(E1, eVar));
    }

    public final void h0(H0 h0, int i) {
        c.a z1 = z1();
        S2(z1, 1, new s(z1, h0, i));
    }

    public final void i(U2.e eVar) {
        c.a F1 = F1();
        S2(F1, 1007, new T(F1, eVar));
    }

    public void i0(R0 r0) {
        c.a z1 = z1();
        S2(z1, 14, new g(z1, r0));
    }

    public final void j(e4.C c) {
        c.a F1 = F1();
        S2(F1, 25, new c0(F1, c));
    }

    public final void j0(boolean z, int i) {
        c.a z1 = z1();
        S2(z1, 5, new o(z1, z, i));
    }

    public void k(List list) {
        c.a z1 = z1();
        S2(z1, 27, new H(z1, list));
    }

    public void k0(t1 t1Var, Looper looper) {
        d4.a.g(this.h == null || a.a(this.e).isEmpty());
        this.h = (t1) d4.a.e(t1Var);
        this.i = this.a.c(looper, null);
        this.g = this.g.e(looper, new m(this, t1Var));
    }

    public final void l(long j) {
        c.a F1 = F1();
        S2(F1, 1010, new F(F1, j));
    }

    public final void l0(p1 p1Var) {
        c.a G1 = G1(p1Var);
        S2(G1, 10, new r(G1, p1Var));
    }

    public final void m(Exception exc) {
        c.a F1 = F1();
        S2(F1, 1030, new n0(F1, exc));
    }

    public final void n(U2.e eVar) {
        c.a E1 = E1();
        S2(E1, 1013, new C(E1, eVar));
    }

    public void n0(boolean z) {
        c.a z1 = z1();
        S2(z1, 7, new l0(z1, z));
    }

    public final void o(int i, C.b bVar, B3.x xVar) {
        c.a D1 = D1(i, bVar);
        S2(D1, 1005, new P(D1, xVar));
    }

    public final void onRepeatModeChanged(int i) {
        c.a z1 = z1();
        S2(z1, 8, new E(z1, i));
    }

    public final void p(U2.e eVar) {
        c.a F1 = F1();
        S2(F1, 1015, new w(F1, eVar));
    }

    public final void q(z0 z0Var, U2.h hVar) {
        c.a F1 = F1();
        S2(F1, 1017, new v(F1, z0Var, hVar));
    }

    public final void r(z0 z0Var, U2.h hVar) {
        c.a F1 = F1();
        S2(F1, 1009, new f(F1, z0Var, hVar));
    }

    public void release() {
        ((d4.w) d4.a.i(this.i)).i(new h(this));
    }

    public final void s(int i, long j) {
        c.a E1 = E1();
        S2(E1, 1018, new J(E1, i, j));
    }

    public final void t(s1 s1Var) {
        c.a z1 = z1();
        S2(z1, 12, new i(z1, s1Var));
    }

    public void u(P3.f fVar) {
        c.a z1 = z1();
        S2(z1, 27, new t(z1, fVar));
    }

    public final void v(Object obj, long j) {
        c.a F1 = F1();
        S2(F1, 26, new d0(F1, obj, j));
    }

    public final void w(Exception exc) {
        c.a F1 = F1();
        S2(F1, 1029, new o0(F1, exc));
    }

    public final void x(int i, long j, long j2) {
        c.a F1 = F1();
        S2(F1, 1011, new e0(F1, i, j, j2));
    }

    public final void y(long j, int i) {
        c.a E1 = E1();
        S2(E1, 1021, new O(E1, j, i));
    }

    public final void z(int i) {
        c.a z1 = z1();
        S2(z1, 6, new M(z1, i));
    }

    public final c.a z1() {
        return A1(this.e.d());
    }

    public void P() {
    }

    public void B(boolean z) {
    }

    public void b0(int i) {
    }

    public static /* synthetic */ void H1(c cVar, d4.s sVar) {
    }

    public void m0(t1 t1Var, t1.c cVar) {
    }
}
