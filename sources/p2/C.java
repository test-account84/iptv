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
import android.util.SparseArray;
import java.io.IOException;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface c {

    public static final class a {
        public final long a;
        public final Q1 b;
        public final int c;
        public final C.b d;
        public final long e;
        public final Q1 f;
        public final int g;
        public final C.b h;
        public final long i;
        public final long j;

        public a(long j, Q1 q1, int i, C.b bVar, long j2, Q1 q12, int i2, C.b bVar2, long j3, long j4) {
            this.a = j;
            this.b = q1;
            this.c = i;
            this.d = bVar;
            this.e = j2;
            this.f = q12;
            this.g = i2;
            this.h = bVar2;
            this.i = j3;
            this.j = j4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.c == aVar.c && this.e == aVar.e && this.g == aVar.g && this.i == aVar.i && this.j == aVar.j && r5.j.a(this.b, aVar.b) && r5.j.a(this.d, aVar.d) && r5.j.a(this.f, aVar.f) && r5.j.a(this.h, aVar.h);
        }

        public int hashCode() {
            return r5.j.b(Long.valueOf(this.a), this.b, Integer.valueOf(this.c), this.d, Long.valueOf(this.e), this.f, Integer.valueOf(this.g), this.h, Long.valueOf(this.i), Long.valueOf(this.j));
        }
    }

    public static final class b {
        public final d4.s a;
        public final SparseArray b;

        public b(d4.s sVar, SparseArray sparseArray) {
            this.a = sVar;
            SparseArray sparseArray2 = new SparseArray(sVar.d());
            for (int i = 0; i < sVar.d(); i++) {
                int c = sVar.c(i);
                sparseArray2.append(c, (a) d4.a.e((a) sparseArray.get(c)));
            }
            this.b = sparseArray2;
        }

        public boolean a(int i) {
            return this.a.a(i);
        }

        public int b(int i) {
            return this.a.c(i);
        }

        public a c(int i) {
            return (a) d4.a.e((a) this.b.get(i));
        }

        public int d() {
            return this.a.d();
        }
    }

    void A(a aVar, boolean z);

    void B(a aVar, int i, long j, long j2);

    void C(a aVar, H0 h0, int i);

    void D(a aVar, Object obj, long j);

    void E(a aVar, U2.e eVar);

    void F(a aVar, p1 p1Var);

    void G(a aVar, B3.x xVar);

    void H(a aVar, R0 r0);

    void I(a aVar, Exception exc);

    void J(a aVar, O2.u uVar);

    void K(a aVar, int i);

    void L(a aVar);

    void M(a aVar, Q2.e eVar);

    void N(a aVar, String str);

    void O(a aVar, int i, int i2, int i3, float f);

    void P(a aVar, boolean z);

    void Q(a aVar);

    void R(a aVar, z0 z0Var);

    void T(a aVar, U2.e eVar);

    void U(a aVar, Exception exc);

    void V(a aVar, int i);

    void W(a aVar, Exception exc);

    void X(a aVar, int i);

    void Y(a aVar, B3.x xVar);

    void Z(a aVar, String str);

    void a(a aVar, z0 z0Var, U2.h hVar);

    void a0(a aVar, B3.u uVar, B3.x xVar, IOException iOException, boolean z);

    void b0(a aVar, boolean z);

    void c(a aVar);

    void c0(a aVar, long j);

    void d(a aVar, B3.u uVar, B3.x xVar);

    void d0(a aVar, q3.a aVar2);

    void e(a aVar, int i);

    void e0(a aVar, int i);

    void f(a aVar);

    void f0(a aVar, boolean z, int i);

    void g(a aVar, boolean z);

    void g0(a aVar, String str, long j);

    void h(a aVar, Z3.z zVar);

    void h0(a aVar, int i, long j);

    void i(a aVar);

    void i0(a aVar, int i, long j, long j2);

    void j(a aVar, Exception exc);

    void j0(a aVar, boolean z, int i);

    void k(a aVar, V1 v1);

    void k0(a aVar);

    void l(a aVar, z0 z0Var, U2.h hVar);

    void l0(a aVar, boolean z);

    void m(a aVar);

    void m0(a aVar, int i, boolean z);

    void n(a aVar, long j, int i);

    void n0(a aVar, z0 z0Var);

    void o(a aVar, int i, int i2);

    void o0(a aVar, e4.C c);

    void p(a aVar, t1.e eVar, t1.e eVar2, int i);

    void p0(a aVar, B3.u uVar, B3.x xVar);

    void q(a aVar, U2.e eVar);

    void q0(a aVar, List list);

    void r(a aVar, P3.f fVar);

    void r0(a aVar, p1 p1Var);

    void s(a aVar, String str, long j, long j2);

    void s0(a aVar, U2.e eVar);

    void t(a aVar, s1 s1Var);

    void t0(a aVar, String str, long j, long j2);

    void u(a aVar, String str, long j);

    void u0(t1 t1Var, b bVar);

    void w(a aVar, t1.b bVar);

    void y(a aVar, B3.u uVar, B3.x xVar);

    void z(a aVar, int i);
}
