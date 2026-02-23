package B3;

import B3.C;
import B3.J;
import O2.Q1;
import V2.w;
import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class g extends B3.a {
    public final HashMap i = new HashMap();
    public Handler j;
    public b4.S k;

    public final class a implements J, V2.w {
        public final Object a;
        public J.a c;
        public w.a d;

        public a(Object obj) {
            this.c = g.this.f0(null);
            this.d = g.this.b0(null);
            this.a = obj;
        }

        public void C(int i, C.b bVar) {
            if (a(i, bVar)) {
                this.d.j();
            }
        }

        public void D(int i, C.b bVar, u uVar, x xVar) {
            if (a(i, bVar)) {
                this.c.u(uVar, e(xVar));
            }
        }

        public void G(int i, C.b bVar) {
            if (a(i, bVar)) {
                this.d.i();
            }
        }

        public void I(int i, C.b bVar, u uVar, x xVar) {
            if (a(i, bVar)) {
                this.c.r(uVar, e(xVar));
            }
        }

        public /* synthetic */ void K(int i, C.b bVar) {
            V2.p.a(this, i, bVar);
        }

        public void L(int i, C.b bVar, u uVar, x xVar, IOException iOException, boolean z) {
            if (a(i, bVar)) {
                this.c.x(uVar, e(xVar), iOException, z);
            }
        }

        public void N(int i, C.b bVar, int i2) {
            if (a(i, bVar)) {
                this.d.k(i2);
            }
        }

        public void Q(int i, C.b bVar, Exception exc) {
            if (a(i, bVar)) {
                this.d.l(exc);
            }
        }

        public void R(int i, C.b bVar, u uVar, x xVar) {
            if (a(i, bVar)) {
                this.c.A(uVar, e(xVar));
            }
        }

        public void T(int i, C.b bVar) {
            if (a(i, bVar)) {
                this.d.h();
            }
        }

        public void Z(int i, C.b bVar, x xVar) {
            if (a(i, bVar)) {
                this.c.i(e(xVar));
            }
        }

        public final boolean a(int i, C.b bVar) {
            C.b bVar2;
            if (bVar != null) {
                bVar2 = g.this.p0(this.a, bVar);
                if (bVar2 == null) {
                    return false;
                }
            } else {
                bVar2 = null;
            }
            int r0 = g.this.r0(this.a, i);
            J.a aVar = this.c;
            if (aVar.a != r0 || !d4.k0.c(aVar.b, bVar2)) {
                this.c = g.this.d0(r0, bVar2);
            }
            w.a aVar2 = this.d;
            if (aVar2.a == r0 && d4.k0.c(aVar2.b, bVar2)) {
                return true;
            }
            this.d = g.this.a0(r0, bVar2);
            return true;
        }

        public void c0(int i, C.b bVar) {
            if (a(i, bVar)) {
                this.d.m();
            }
        }

        public final x e(x xVar) {
            long q0 = g.this.q0(this.a, xVar.f);
            long q02 = g.this.q0(this.a, xVar.g);
            return (q0 == xVar.f && q02 == xVar.g) ? xVar : new x(xVar.a, xVar.b, xVar.c, xVar.d, xVar.e, q0, q02);
        }

        public void o(int i, C.b bVar, x xVar) {
            if (a(i, bVar)) {
                this.c.D(e(xVar));
            }
        }
    }

    public static final class b {
        public final C a;
        public final C.c b;
        public final a c;

        public b(C c, C.c cVar, a aVar) {
            this.a = c;
            this.b = cVar;
            this.c = aVar;
        }
    }

    public static /* synthetic */ void o0(g gVar, Object obj, C c, Q1 q1) {
        gVar.s0(obj, c, q1);
    }

    public void P() {
        Iterator it = this.i.values().iterator();
        while (it.hasNext()) {
            ((b) it.next()).a.P();
        }
    }

    public void g0() {
        for (b bVar : this.i.values()) {
            bVar.a.B(bVar.b);
        }
    }

    public void h0() {
        for (b bVar : this.i.values()) {
            bVar.a.F(bVar.b);
        }
    }

    public void l0(b4.S s) {
        this.k = s;
        this.j = d4.k0.x();
    }

    public void n0() {
        for (b bVar : this.i.values()) {
            bVar.a.V(bVar.b);
            bVar.a.u(bVar.c);
            bVar.a.z(bVar.c);
        }
        this.i.clear();
    }

    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public abstract void s0(Object obj, C c, Q1 q1);

    public final void u0(Object obj, C c) {
        d4.a.a(!this.i.containsKey(obj));
        C.c fVar = new f(this, obj);
        a aVar = new a(obj);
        this.i.put(obj, new b(c, fVar, aVar));
        c.k((Handler) d4.a.e(this.j), aVar);
        c.A((Handler) d4.a.e(this.j), aVar);
        c.a(fVar, this.k, i0());
        if (j0()) {
            return;
        }
        c.B(fVar);
    }

    public final void v0(Object obj) {
        b bVar = (b) d4.a.e((b) this.i.remove(obj));
        bVar.a.V(bVar.b);
        bVar.a.u(bVar.c);
        bVar.a.z(bVar.c);
    }

    public C.b p0(Object obj, C.b bVar) {
        return bVar;
    }

    public long q0(Object obj, long j) {
        return j;
    }

    public int r0(Object obj, int i) {
        return i;
    }
}
