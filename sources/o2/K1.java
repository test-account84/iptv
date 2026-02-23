package O2;

import B3.C;
import B3.a0;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k1 {
    public final P2.v0 a;
    public final d e;
    public final P2.a h;
    public final d4.w i;
    public boolean k;
    public b4.S l;
    public B3.a0 j = new a0.a(0);
    public final IdentityHashMap c = new IdentityHashMap();
    public final Map d = new HashMap();
    public final List b = new ArrayList();
    public final HashMap f = new HashMap();
    public final Set g = new HashSet();

    public final class a implements B3.J, V2.w {
        public final c a;

        public a(c cVar) {
            this.a = cVar;
        }

        public static /* synthetic */ void A(a aVar, Pair pair, B3.x xVar) {
            aVar.g0(pair, xVar);
        }

        public static /* synthetic */ void B(a aVar, Pair pair, B3.x xVar) {
            aVar.O(pair, xVar);
        }

        public static /* synthetic */ void E(a aVar, Pair pair, B3.u uVar, B3.x xVar) {
            aVar.f0(pair, uVar, xVar);
        }

        public static /* synthetic */ void F(a aVar, Pair pair, Exception exc) {
            aVar.W(pair, exc);
        }

        public static /* synthetic */ void J(a aVar, Pair pair) {
            aVar.U(pair);
        }

        public static /* synthetic */ void a(a aVar, Pair pair, B3.u uVar, B3.x xVar, IOException iOException, boolean z) {
            aVar.d0(pair, uVar, xVar, iOException, z);
        }

        public static /* synthetic */ void e(a aVar, Pair pair) {
            aVar.S(pair);
        }

        public static /* synthetic */ void j(a aVar, Pair pair, B3.u uVar, B3.x xVar) {
            aVar.a0(pair, uVar, xVar);
        }

        public static /* synthetic */ void k(a aVar, Pair pair) {
            aVar.Y(pair);
        }

        public static /* synthetic */ void t(a aVar, Pair pair, B3.u uVar, B3.x xVar) {
            aVar.b0(pair, uVar, xVar);
        }

        public static /* synthetic */ void u(a aVar, Pair pair, int i) {
            aVar.V(pair, i);
        }

        public static /* synthetic */ void z(a aVar, Pair pair) {
            aVar.P(pair);
        }

        public void C(int i, C.b bVar) {
            Pair M = M(i, bVar);
            if (M != null) {
                k1.b(k1.this).i(new j1(this, M));
            }
        }

        public void D(int i, C.b bVar, B3.u uVar, B3.x xVar) {
            Pair M = M(i, bVar);
            if (M != null) {
                k1.b(k1.this).i(new Y0(this, M, uVar, xVar));
            }
        }

        public void G(int i, C.b bVar) {
            Pair M = M(i, bVar);
            if (M != null) {
                k1.b(k1.this).i(new Z0(this, M));
            }
        }

        public void I(int i, C.b bVar, B3.u uVar, B3.x xVar) {
            Pair M = M(i, bVar);
            if (M != null) {
                k1.b(k1.this).i(new g1(this, M, uVar, xVar));
            }
        }

        public /* synthetic */ void K(int i, C.b bVar) {
            V2.p.a(this, i, bVar);
        }

        public void L(int i, C.b bVar, B3.u uVar, B3.x xVar, IOException iOException, boolean z) {
            Pair M = M(i, bVar);
            if (M != null) {
                k1.b(k1.this).i(new h1(this, M, uVar, xVar, iOException, z));
            }
        }

        public final Pair M(int i, C.b bVar) {
            C.b bVar2 = null;
            if (bVar != null) {
                C.b c = k1.c(this.a, bVar);
                if (c == null) {
                    return null;
                }
                bVar2 = c;
            }
            return Pair.create(Integer.valueOf(k1.d(this.a, i)), bVar2);
        }

        public void N(int i, C.b bVar, int i2) {
            Pair M = M(i, bVar);
            if (M != null) {
                k1.b(k1.this).i(new f1(this, M, i2));
            }
        }

        public final /* synthetic */ void O(Pair pair, B3.x xVar) {
            k1.e(k1.this).Z(((Integer) pair.first).intValue(), (C.b) pair.second, xVar);
        }

        public final /* synthetic */ void P(Pair pair) {
            k1.e(k1.this).T(((Integer) pair.first).intValue(), (C.b) pair.second);
        }

        public void Q(int i, C.b bVar, Exception exc) {
            Pair M = M(i, bVar);
            if (M != null) {
                k1.b(k1.this).i(new d1(this, M, exc));
            }
        }

        public void R(int i, C.b bVar, B3.u uVar, B3.x xVar) {
            Pair M = M(i, bVar);
            if (M != null) {
                k1.b(k1.this).i(new e1(this, M, uVar, xVar));
            }
        }

        public final /* synthetic */ void S(Pair pair) {
            k1.e(k1.this).G(((Integer) pair.first).intValue(), (C.b) pair.second);
        }

        public void T(int i, C.b bVar) {
            Pair M = M(i, bVar);
            if (M != null) {
                k1.b(k1.this).i(new a1(this, M));
            }
        }

        public final /* synthetic */ void U(Pair pair) {
            k1.e(k1.this).C(((Integer) pair.first).intValue(), (C.b) pair.second);
        }

        public final /* synthetic */ void V(Pair pair, int i) {
            k1.e(k1.this).N(((Integer) pair.first).intValue(), (C.b) pair.second, i);
        }

        public final /* synthetic */ void W(Pair pair, Exception exc) {
            k1.e(k1.this).Q(((Integer) pair.first).intValue(), (C.b) pair.second, exc);
        }

        public final /* synthetic */ void Y(Pair pair) {
            k1.e(k1.this).c0(((Integer) pair.first).intValue(), (C.b) pair.second);
        }

        public void Z(int i, C.b bVar, B3.x xVar) {
            Pair M = M(i, bVar);
            if (M != null) {
                k1.b(k1.this).i(new b1(this, M, xVar));
            }
        }

        public final /* synthetic */ void a0(Pair pair, B3.u uVar, B3.x xVar) {
            k1.e(k1.this).I(((Integer) pair.first).intValue(), (C.b) pair.second, uVar, xVar);
        }

        public final /* synthetic */ void b0(Pair pair, B3.u uVar, B3.x xVar) {
            k1.e(k1.this).D(((Integer) pair.first).intValue(), (C.b) pair.second, uVar, xVar);
        }

        public void c0(int i, C.b bVar) {
            Pair M = M(i, bVar);
            if (M != null) {
                k1.b(k1.this).i(new c1(this, M));
            }
        }

        public final /* synthetic */ void d0(Pair pair, B3.u uVar, B3.x xVar, IOException iOException, boolean z) {
            k1.e(k1.this).L(((Integer) pair.first).intValue(), (C.b) pair.second, uVar, xVar, iOException, z);
        }

        public final /* synthetic */ void f0(Pair pair, B3.u uVar, B3.x xVar) {
            k1.e(k1.this).R(((Integer) pair.first).intValue(), (C.b) pair.second, uVar, xVar);
        }

        public final /* synthetic */ void g0(Pair pair, B3.x xVar) {
            k1.e(k1.this).o(((Integer) pair.first).intValue(), (C.b) d4.a.e((C.b) pair.second), xVar);
        }

        public void o(int i, C.b bVar, B3.x xVar) {
            Pair M = M(i, bVar);
            if (M != null) {
                k1.b(k1.this).i(new i1(this, M, xVar));
            }
        }
    }

    public static final class b {
        public final B3.C a;
        public final C.c b;
        public final a c;

        public b(B3.C c, C.c cVar, a aVar) {
            this.a = c;
            this.b = cVar;
            this.c = aVar;
        }
    }

    public static final class c implements W0 {
        public final B3.w a;
        public int d;
        public boolean e;
        public final List c = new ArrayList();
        public final Object b = new Object();

        public c(B3.C c, boolean z) {
            this.a = new B3.w(c, z);
        }

        public Object a() {
            return this.b;
        }

        public Q1 b() {
            return this.a.J0();
        }

        public void c(int i) {
            this.d = i;
            this.e = false;
            this.c.clear();
        }
    }

    public interface d {
        void c();
    }

    public k1(d dVar, P2.a aVar, d4.w wVar, P2.v0 v0Var) {
        this.a = v0Var;
        this.e = dVar;
        this.h = aVar;
        this.i = wVar;
    }

    public static /* synthetic */ void a(k1 k1Var, B3.C c2, Q1 q1) {
        k1Var.u(c2, q1);
    }

    public static /* synthetic */ d4.w b(k1 k1Var) {
        return k1Var.i;
    }

    public static /* synthetic */ C.b c(c cVar, C.b bVar) {
        return n(cVar, bVar);
    }

    public static /* synthetic */ int d(c cVar, int i) {
        return s(cVar, i);
    }

    public static /* synthetic */ P2.a e(k1 k1Var) {
        return k1Var.h;
    }

    public static Object m(Object obj) {
        return O2.a.A(obj);
    }

    public static C.b n(c cVar, C.b bVar) {
        for (int i = 0; i < cVar.c.size(); i++) {
            if (((C.b) cVar.c.get(i)).d == bVar.d) {
                return bVar.c(p(cVar, bVar.a));
            }
        }
        return null;
    }

    public static Object o(Object obj) {
        return O2.a.B(obj);
    }

    public static Object p(c cVar, Object obj) {
        return O2.a.D(cVar.b, obj);
    }

    public static int s(c cVar, int i) {
        return i + cVar.d;
    }

    public Q1 A(int i, int i2, B3.a0 a0Var) {
        d4.a.a(i >= 0 && i <= i2 && i2 <= r());
        this.j = a0Var;
        B(i, i2);
        return i();
    }

    public final void B(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c cVar = (c) this.b.remove(i3);
            this.d.remove(cVar.b);
            g(i3, -cVar.a.J0().u());
            cVar.e = true;
            if (this.k) {
                v(cVar);
            }
        }
    }

    public Q1 C(List list, B3.a0 a0Var) {
        B(0, this.b.size());
        return f(this.b.size(), list, a0Var);
    }

    public Q1 D(B3.a0 a0Var) {
        int r = r();
        if (a0Var.getLength() != r) {
            a0Var = a0Var.e().g(0, r);
        }
        this.j = a0Var;
        return i();
    }

    public Q1 f(int i, List list, B3.a0 a0Var) {
        int i2;
        if (!list.isEmpty()) {
            this.j = a0Var;
            for (int i3 = i; i3 < list.size() + i; i3++) {
                c cVar = (c) list.get(i3 - i);
                if (i3 > 0) {
                    c cVar2 = (c) this.b.get(i3 - 1);
                    i2 = cVar2.d + cVar2.a.J0().u();
                } else {
                    i2 = 0;
                }
                cVar.c(i2);
                g(i3, cVar.a.J0().u());
                this.b.add(i3, cVar);
                this.d.put(cVar.b, cVar);
                if (this.k) {
                    x(cVar);
                    if (this.c.isEmpty()) {
                        this.g.add(cVar);
                    } else {
                        j(cVar);
                    }
                }
            }
        }
        return i();
    }

    public final void g(int i, int i2) {
        while (i < this.b.size()) {
            ((c) this.b.get(i)).d += i2;
            i++;
        }
    }

    public B3.z h(C.b bVar, b4.b bVar2, long j) {
        Object o = o(bVar.a);
        C.b c2 = bVar.c(m(bVar.a));
        c cVar = (c) d4.a.e((c) this.d.get(o));
        l(cVar);
        cVar.c.add(c2);
        B3.v E = cVar.a.E(c2, bVar2, j);
        this.c.put(E, cVar);
        k();
        return E;
    }

    public Q1 i() {
        if (this.b.isEmpty()) {
            return Q1.a;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            c cVar = (c) this.b.get(i2);
            cVar.d = i;
            i += cVar.a.J0().u();
        }
        return new y1(this.b, this.j);
    }

    public final void j(c cVar) {
        b bVar = (b) this.f.get(cVar);
        if (bVar != null) {
            bVar.a.B(bVar.b);
        }
    }

    public final void k() {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.c.isEmpty()) {
                j(cVar);
                it.remove();
            }
        }
    }

    public final void l(c cVar) {
        this.g.add(cVar);
        b bVar = (b) this.f.get(cVar);
        if (bVar != null) {
            bVar.a.F(bVar.b);
        }
    }

    public B3.a0 q() {
        return this.j;
    }

    public int r() {
        return this.b.size();
    }

    public boolean t() {
        return this.k;
    }

    public final /* synthetic */ void u(B3.C c2, Q1 q1) {
        this.e.c();
    }

    public final void v(c cVar) {
        if (cVar.e && cVar.c.isEmpty()) {
            b bVar = (b) d4.a.e((b) this.f.remove(cVar));
            bVar.a.V(bVar.b);
            bVar.a.u(bVar.c);
            bVar.a.z(bVar.c);
            this.g.remove(cVar);
        }
    }

    public void w(b4.S s) {
        d4.a.g(!this.k);
        this.l = s;
        for (int i = 0; i < this.b.size(); i++) {
            c cVar = (c) this.b.get(i);
            x(cVar);
            this.g.add(cVar);
        }
        this.k = true;
    }

    public final void x(c cVar) {
        B3.w wVar = cVar.a;
        X0 x0 = new X0(this);
        a aVar = new a(cVar);
        this.f.put(cVar, new b(wVar, x0, aVar));
        wVar.k(d4.k0.z(), aVar);
        wVar.A(d4.k0.z(), aVar);
        wVar.a(x0, this.l, this.a);
    }

    public void y() {
        for (b bVar : this.f.values()) {
            try {
                bVar.a.V(bVar.b);
            } catch (RuntimeException e) {
                d4.B.e("MediaSourceList", "Failed to release child source.", e);
            }
            bVar.a.u(bVar.c);
            bVar.a.z(bVar.c);
        }
        this.f.clear();
        this.g.clear();
        this.k = false;
    }

    public void z(B3.z zVar) {
        c cVar = (c) d4.a.e((c) this.c.remove(zVar));
        cVar.a.Y(zVar);
        cVar.c.remove(((B3.v) zVar).a);
        if (!this.c.isEmpty()) {
            k();
        }
        v(cVar);
    }
}
