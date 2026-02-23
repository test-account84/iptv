package com.google.ads.interactivemedia.v3.internal;

import android.os.Looper;
import android.util.SparseArray;
import java.io.IOException;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class im implements hu {
    private final bn a;
    private final bc b;
    private final bd c;
    private final il d;
    private final SparseArray e;
    private ca f;
    private az g;
    private bv h;
    private boolean i;

    public im(bn bnVar) {
        af.s(bnVar);
        this.a = bnVar;
        this.f = new ca(cq.D(), bnVar, hy.a);
        bc bcVar = new bc();
        this.b = bcVar;
        this.c = new bd();
        this.d = new il(bcVar);
        this.e = new SparseArray();
    }

    public static /* synthetic */ void V(im imVar) {
        hv T = imVar.T();
        imVar.Y(T, 1028, new fw(T, 7));
        imVar.f.e();
    }

    private final hv Z(te teVar) {
        af.s(this.g);
        be a = teVar == null ? null : this.d.a(teVar);
        if (teVar != null && a != null) {
            return U(a, a.n(teVar.a, this.b).c, teVar);
        }
        int h = this.g.h();
        be o = this.g.o();
        if (h >= o.c()) {
            o = be.a;
        }
        return U(o, h, null);
    }

    private final hv aa(int i, te teVar) {
        af.s(this.g);
        if (teVar != null) {
            return this.d.a(teVar) != null ? Z(teVar) : U(be.a, i, teVar);
        }
        be o = this.g.o();
        if (i >= o.c()) {
            o = be.a;
        }
        return U(o, i, null);
    }

    private final hv ab() {
        return Z(this.d.d());
    }

    private final hv ac() {
        return Z(this.d.e());
    }

    private final hv ad(at atVar) {
        am amVar;
        return (!(atVar instanceof ev) || (amVar = ((ev) atVar).h) == null) ? T() : Z(new te(amVar));
    }

    public final void A(ep epVar) {
        hv ab = ab();
        Y(ab, 1013, new hx(ab, epVar, 15));
    }

    public final void B(ep epVar) {
        hv ac = ac();
        Y(ac, 1007, new hx(ac, epVar, 12));
    }

    public final void C(s sVar, eq eqVar) {
        hv ac = ac();
        Y(ac, 1009, new if(ac, sVar, eqVar, 4));
    }

    public final void D(long j) {
        hv ac = ac();
        Y(ac, 1010, new ii(ac, j));
    }

    public final void E(Exception exc) {
        hv ac = ac();
        Y(ac, 1014, new hx(ac, exc, 5));
    }

    public final void F(int i, long j, long j2) {
        hv ac = ac();
        Y(ac, 1011, new hz(ac, i, j, j2, 1));
    }

    public final void G(int i, long j) {
        hv ab = ab();
        Y(ab, 1018, new ie(ab, i, j, 0));
    }

    public final void H(Object obj, long j) {
        hv ac = ac();
        Y(ac, 26, new ij(ac, obj, j));
    }

    public final void I(Exception exc) {
        hv ac = ac();
        Y(ac, 1030, new hx(ac, exc, 4));
    }

    public final void J(String str, long j, long j2) {
        hv ac = ac();
        Y(ac, 1016, new ig(ac, str, j2, j, 1));
    }

    public final void K(String str) {
        hv ac = ac();
        Y(ac, 1019, new hx(ac, str, 0));
    }

    public final void L(ep epVar) {
        hv ab = ab();
        Y(ab, 1020, new hx(ab, epVar, 17));
    }

    public final void M(ep epVar) {
        hv ac = ac();
        Y(ac, 1015, new hx(ac, epVar, 10));
    }

    public final void N(long j, int i) {
        hv ab = ab();
        Y(ab, 1021, new ie(ab, j, i, 1));
    }

    public final void O(s sVar, eq eqVar) {
        hv ac = ac();
        Y(ac, 1017, new if(ac, sVar, eqVar, 1));
    }

    public final void P() {
        bv bvVar = this.h;
        af.t(bvVar);
        bvVar.e(new ky(this, 1));
    }

    public final void Q(hw hwVar) {
        this.f.f(hwVar);
    }

    public final void R(az azVar, Looper looper) {
        boolean z = true;
        if (this.g != null && !il.f(this.d).isEmpty()) {
            z = false;
        }
        af.w(z);
        af.s(azVar);
        this.g = azVar;
        this.h = this.a.b(looper, null);
        this.f = this.f.a(looper, new ic(this, azVar));
    }

    public final void S(List list, te teVar) {
        il ilVar = this.d;
        az azVar = this.g;
        af.s(azVar);
        ilVar.h(list, teVar, azVar);
    }

    public final hv T() {
        return Z(this.d.b());
    }

    public final hv U(be beVar, int i, te teVar) {
        te teVar2 = true == beVar.p() ? null : teVar;
        long a = this.a.a();
        boolean z = beVar.equals(this.g.o()) && i == this.g.h();
        long j = 0;
        if (teVar2 == null || !teVar2.b()) {
            if (z) {
                j = this.g.l();
            } else if (!beVar.p()) {
                j = beVar.o(i, this.c).a();
            }
        } else if (z && this.g.f() == teVar2.b && this.g.g() == teVar2.c) {
            j = this.g.m();
        }
        return new hv(a, beVar, i, teVar2, j, this.g.o(), this.g.h(), this.d.b(), this.g.m(), this.g.n());
    }

    public final /* synthetic */ void W(az azVar, hw hwVar, q qVar) {
        hwVar.i(azVar, new aeq(qVar, this.e));
    }

    public final void X(int i, long j, long j2) {
        hv Z = Z(this.d.c());
        Y(Z, 1006, new hz(Z, i, j, j2, 0));
    }

    public final void Y(hv hvVar, int i, bx bxVar) {
        this.e.put(i, hvVar);
        this.f.g(i, bxVar);
    }

    public final void a(aw awVar) {
        hv T = T();
        Y(T, 13, new hx(T, awVar, 6));
    }

    public final void ae(int i, te teVar, tb tbVar) {
        hv aa = aa(i, teVar);
        Y(aa, 1004, new hx(aa, tbVar, 3));
    }

    public final void af(int i, te teVar, sw swVar, tb tbVar) {
        hv aa = aa(i, teVar);
        Y(aa, 1002, new if(aa, swVar, tbVar, 0));
    }

    public final void ag(int i, te teVar, sw swVar, tb tbVar) {
        hv aa = aa(i, teVar);
        Y(aa, 1001, new if(aa, swVar, tbVar, 3));
    }

    public final void ah(int i, te teVar, sw swVar, tb tbVar, IOException iOException, boolean z) {
        hv aa = aa(i, teVar);
        Y(aa, 1003, new id(aa, swVar, tbVar, iOException, z));
    }

    public final void ai(int i, te teVar, sw swVar, tb tbVar) {
        hv aa = aa(i, teVar);
        Y(aa, 1000, new if(aa, swVar, tbVar, 2));
    }

    public final void aj(int i, te teVar, tb tbVar) {
        hv aa = aa(i, teVar);
        Y(aa, 1005, new hx(aa, tbVar, 1));
    }

    public final void ak(int i, te teVar) {
        hv aa = aa(i, teVar);
        Y(aa, 1023, new fw(aa, 5));
    }

    public final void al(int i, te teVar) {
        hv aa = aa(i, teVar);
        Y(aa, 1025, new fw(aa, 3));
    }

    public final void am(int i, te teVar, int i2) {
        hv aa = aa(i, teVar);
        Y(aa, 1022, new fb(aa, i2, 1));
    }

    public final void an(int i, te teVar, Exception exc) {
        hv aa = aa(i, teVar);
        Y(aa, 1024, new hx(aa, exc, 18));
    }

    public final void ao(int i, te teVar) {
        hv aa = aa(i, teVar);
        Y(aa, 1027, new fw(aa, 4));
    }

    public final /* synthetic */ void ap() {
    }

    public final void b(l lVar) {
        hv T = T();
        Y(T, 29, new hx(T, lVar, 7));
    }

    public final void c(int i, boolean z) {
        hv T = T();
        Y(T, 30, new ib(T, i, z, 0));
    }

    public final void d(boolean z) {
        hv T = T();
        Y(T, 3, new ih(T, z, 2));
    }

    public final void e(boolean z) {
        hv T = T();
        Y(T, 7, new ih(T, z, 1));
    }

    public final void f(ai aiVar, int i) {
        hv T = T();
        Y(T, 1, new ft(T, aiVar, i, 1));
    }

    public final void g(al alVar) {
        hv T = T();
        Y(T, 14, new hx(T, alVar, 14));
    }

    public final void h(boolean z, int i) {
        hv T = T();
        Y(T, 5, new ib(T, z, i, 2));
    }

    public final void i(au auVar) {
        hv T = T();
        Y(T, 12, new hx(T, auVar, 2));
    }

    public final void j(int i) {
        hv T = T();
        Y(T, 4, new fb(T, i, 3));
    }

    public final void k(int i) {
        hv T = T();
        Y(T, 6, new fb(T, i, 4));
    }

    public final void l(at atVar) {
        hv ad = ad(atVar);
        Y(ad, 10, new hx(ad, atVar, 11));
    }

    public final void m(at atVar) {
        hv ad = ad(atVar);
        Y(ad, 10, new hx(ad, atVar, 13));
    }

    public final void n(boolean z, int i) {
        hv T = T();
        Y(T, -1, new ib(T, z, i, 1));
    }

    public final void o(ay ayVar, ay ayVar2, int i) {
        if (i == 1) {
            this.i = false;
            i = 1;
        }
        il ilVar = this.d;
        az azVar = this.g;
        af.s(azVar);
        ilVar.g(azVar);
        hv T = T();
        Y(T, 11, new ia(T, i, ayVar, ayVar2));
    }

    public final void p() {
        hv T = T();
        Y(T, -1, new fw(T, 6));
    }

    public final void q(boolean z) {
        hv ac = ac();
        Y(ac, 23, new ih(ac, z, 0));
    }

    public final void r(int i, int i2) {
        hv ac = ac();
        Y(ac, 24, new ik(ac, i, i2));
    }

    public final void s(bk bkVar) {
        hv T = T();
        Y(T, 2, new hx(T, bkVar, 8));
    }

    public final void t(bl blVar) {
        hv ac = ac();
        Y(ac, 25, new hx(ac, blVar, 16));
    }

    public final void u(int i) {
        il ilVar = this.d;
        az azVar = this.g;
        af.s(azVar);
        ilVar.i(azVar);
        hv T = T();
        Y(T, 0, new fb(T, i, 2));
    }

    public final void v(hw hwVar) {
        af.s(hwVar);
        this.f.b(hwVar);
    }

    public final void w() {
        if (this.i) {
            return;
        }
        hv T = T();
        this.i = true;
        Y(T, -1, new fw(T, 8));
    }

    public final void x(Exception exc) {
        hv ac = ac();
        Y(ac, 1029, new hx(ac, exc, 9));
    }

    public final void y(String str, long j, long j2) {
        hv ac = ac();
        Y(ac, 1008, new ig(ac, str, j2, j, 0));
    }

    public final void z(String str) {
        hv ac = ac();
        Y(ac, 1012, new hx(ac, str, 19));
    }
}
