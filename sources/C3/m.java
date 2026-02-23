package C3;

import B3.C;
import B3.J;
import B3.Y;
import B3.g0;
import B3.i0;
import B3.r;
import B3.u;
import B3.x;
import B3.z;
import C3.b;
import O2.A0;
import O2.H0;
import O2.H1;
import O2.Q1;
import O2.z0;
import V2.p;
import V2.w;
import Z3.s;
import android.os.Handler;
import android.util.Pair;
import b4.S;
import d4.k0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s5.A;
import s5.D;
import s5.F;
import s5.c0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m extends B3.a implements C.c, J, w {
    public final C i;
    public final a m;
    public Handler n;
    public e o;
    public final F j = s5.g.A();
    public A p = A.k();
    public final J.a k = f0(null);
    public final w.a l = b0(null);

    public interface a {
        boolean o(Q1 q1);
    }

    public static final class b implements z {
        public final e a;
        public final C.b c;
        public final J.a d;
        public final w.a e;
        public z.a f;
        public long g;
        public boolean[] h = new boolean[0];
        public boolean i;

        public b(e eVar, C.b bVar, J.a aVar, w.a aVar2) {
            this.a = eVar;
            this.c = bVar;
            this.d = aVar;
            this.e = aVar2;
        }

        public void a() {
            z.a aVar = this.f;
            if (aVar != null) {
                aVar.e(this);
            }
            this.i = true;
        }

        public boolean b() {
            return this.a.t(this);
        }

        public long c() {
            return this.a.p(this);
        }

        public long d(long j, H1 h1) {
            return this.a.k(this, j, h1);
        }

        public boolean f(long j) {
            return this.a.g(this, j);
        }

        public long g() {
            return this.a.l(this);
        }

        public void h(long j) {
            this.a.G(this, j);
        }

        public long i(s[] sVarArr, boolean[] zArr, Y[] yArr, boolean[] zArr2, long j) {
            if (this.h.length == 0) {
                this.h = new boolean[yArr.length];
            }
            return this.a.K(this, sVarArr, zArr, yArr, zArr2, j);
        }

        public List k(List list) {
            return this.a.q(list);
        }

        public long l(long j) {
            return this.a.J(this, j);
        }

        public long m() {
            return this.a.F(this);
        }

        public void p() {
            this.a.y();
        }

        public void s(z.a aVar, long j) {
            this.f = aVar;
            this.a.D(this, j);
        }

        public i0 u() {
            return this.a.s();
        }

        public void v(long j, boolean z) {
            this.a.h(this, j, z);
        }
    }

    public static final class c implements Y {
        public final b a;
        public final int c;

        public c(b bVar, int i) {
            this.a = bVar;
            this.c = i;
        }

        public void a() {
            this.a.a.x(this.c);
        }

        public boolean e() {
            return this.a.a.u(this.c);
        }

        public int n(long j) {
            b bVar = this.a;
            return bVar.a.L(bVar, this.c, j);
        }

        public int q(A0 a0, U2.g gVar, int i) {
            b bVar = this.a;
            return bVar.a.E(bVar, this.c, a0, gVar, i);
        }
    }

    public static final class d extends B3.s {
        public final A h;

        public d(Q1 q1, A a) {
            super(q1);
            d4.a.g(q1.u() == 1);
            Q1.b bVar = new Q1.b();
            for (int i = 0; i < q1.n(); i++) {
                q1.l(i, bVar, true);
                d4.a.g(a.containsKey(d4.a.e(bVar.c)));
            }
            this.h = a;
        }

        public Q1.b l(int i, Q1.b bVar, boolean z) {
            super.l(i, bVar, true);
            C3.b bVar2 = (C3.b) d4.a.e((C3.b) this.h.get(bVar.c));
            long j = bVar.e;
            long f = j == -9223372036854775807L ? bVar2.e : n.f(j, -1, bVar2);
            Q1.b bVar3 = new Q1.b();
            long j2 = 0;
            for (int i2 = 0; i2 < i + 1; i2++) {
                this.g.l(i2, bVar3, true);
                C3.b bVar4 = (C3.b) d4.a.e((C3.b) this.h.get(bVar3.c));
                if (i2 == 0) {
                    j2 = -n.f(-bVar3.t(), -1, bVar4);
                }
                if (i2 != i) {
                    j2 += n.f(bVar3.e, -1, bVar4);
                }
            }
            bVar.z(bVar.a, bVar.c, bVar.d, f, j2, bVar2, bVar.g);
            return bVar;
        }

        public Q1.d t(int i, Q1.d dVar, long j) {
            super.t(i, dVar, j);
            Q1.b bVar = new Q1.b();
            C3.b bVar2 = (C3.b) d4.a.e((C3.b) this.h.get(d4.a.e(l(dVar.p, bVar, true).c)));
            long f = n.f(dVar.r, -1, bVar2);
            if (dVar.o == -9223372036854775807L) {
                long j2 = bVar2.e;
                if (j2 != -9223372036854775807L) {
                    dVar.o = j2 - f;
                }
            } else {
                Q1.b l = super.l(dVar.q, bVar, true);
                long j3 = l.f;
                C3.b bVar3 = (C3.b) d4.a.e((C3.b) this.h.get(l.c));
                Q1.b k = k(dVar.q, bVar);
                dVar.o = k.f + n.f(dVar.o - j3, -1, bVar3);
            }
            dVar.r = f;
            return dVar;
        }
    }

    public static final class e implements z.a {
        public final z a;
        public final Object e;
        public C3.b f;
        public b g;
        public boolean h;
        public boolean i;
        public final List c = new ArrayList();
        public final Map d = new HashMap();
        public s[] j = new s[0];
        public Y[] k = new Y[0];
        public x[] l = new x[0];

        public e(z zVar, Object obj, C3.b bVar) {
            this.a = zVar;
            this.e = obj;
            this.f = bVar;
        }

        public static /* synthetic */ Object a(e eVar) {
            return eVar.e;
        }

        public static /* synthetic */ b b(e eVar) {
            return eVar.g;
        }

        public static /* synthetic */ List c(e eVar) {
            return eVar.c;
        }

        public void A(b bVar, x xVar) {
            int i = i(xVar);
            if (i != -1) {
                this.l[i] = xVar;
                bVar.h[i] = true;
            }
        }

        public void B(u uVar) {
            this.d.remove(Long.valueOf(uVar.a));
        }

        public void C(u uVar, x xVar) {
            this.d.put(Long.valueOf(uVar.a), Pair.create(uVar, xVar));
        }

        public void D(b bVar, long j) {
            bVar.g = j;
            if (this.h) {
                if (this.i) {
                    bVar.a();
                }
            } else {
                this.h = true;
                this.a.s(this, n.g(j, bVar.c, this.f));
            }
        }

        public int E(b bVar, int i, A0 a0, U2.g gVar, int i2) {
            int q = ((Y) k0.j(this.k[i])).q(a0, gVar, i2 | 5);
            long o = o(bVar, gVar.f);
            if ((q == -4 && o == Long.MIN_VALUE) || (q == -3 && l(bVar) == Long.MIN_VALUE && !gVar.e)) {
                w(bVar, i);
                gVar.clear();
                gVar.addFlag(4);
                return -4;
            }
            if (q == -4) {
                w(bVar, i);
                ((Y) k0.j(this.k[i])).q(a0, gVar, i2);
                gVar.f = o;
            }
            return q;
        }

        public long F(b bVar) {
            if (!bVar.equals(this.c.get(0))) {
                return -9223372036854775807L;
            }
            long m = this.a.m();
            if (m == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return n.d(m, bVar.c, this.f);
        }

        public void G(b bVar, long j) {
            this.a.h(r(bVar, j));
        }

        public void H(C c) {
            c.Y(this.a);
        }

        public void I(b bVar) {
            if (bVar.equals(this.g)) {
                this.g = null;
                this.d.clear();
            }
            this.c.remove(bVar);
        }

        public long J(b bVar, long j) {
            return n.d(this.a.l(n.g(j, bVar.c, this.f)), bVar.c, this.f);
        }

        public long K(b bVar, s[] sVarArr, boolean[] zArr, Y[] yArr, boolean[] zArr2, long j) {
            bVar.g = j;
            if (!bVar.equals(this.c.get(0))) {
                for (int i = 0; i < sVarArr.length; i++) {
                    s sVar = sVarArr[i];
                    boolean z = true;
                    if (sVar != null) {
                        if (zArr[i] && yArr[i] != null) {
                            z = false;
                        }
                        zArr2[i] = z;
                        if (z) {
                            yArr[i] = k0.c(this.j[i], sVar) ? new c(bVar, i) : new r();
                        }
                    } else {
                        yArr[i] = null;
                        zArr2[i] = true;
                    }
                }
                return j;
            }
            this.j = (s[]) Arrays.copyOf(sVarArr, sVarArr.length);
            long g = n.g(j, bVar.c, this.f);
            Y[] yArr2 = this.k;
            Y[] yArr3 = yArr2.length == 0 ? new Y[sVarArr.length] : (Y[]) Arrays.copyOf(yArr2, yArr2.length);
            long i2 = this.a.i(sVarArr, zArr, yArr3, zArr2, g);
            this.k = (Y[]) Arrays.copyOf(yArr3, yArr3.length);
            this.l = (x[]) Arrays.copyOf(this.l, yArr3.length);
            for (int i3 = 0; i3 < yArr3.length; i3++) {
                if (yArr3[i3] == null) {
                    yArr[i3] = null;
                    this.l[i3] = null;
                } else if (yArr[i3] == null || zArr2[i3]) {
                    yArr[i3] = new c(bVar, i3);
                    this.l[i3] = null;
                }
            }
            return n.d(i2, bVar.c, this.f);
        }

        public int L(b bVar, int i, long j) {
            return ((Y) k0.j(this.k[i])).n(n.g(j, bVar.c, this.f));
        }

        public void M(C3.b bVar) {
            this.f = bVar;
        }

        public void d(b bVar) {
            this.c.add(bVar);
        }

        public void e(z zVar) {
            this.i = true;
            for (int i = 0; i < this.c.size(); i++) {
                ((b) this.c.get(i)).a();
            }
        }

        public boolean f(C.b bVar, long j) {
            b bVar2 = (b) D.d(this.c);
            return n.g(j, bVar, this.f) == n.g(m.p0(bVar2, this.f), bVar2.c, this.f);
        }

        public boolean g(b bVar, long j) {
            b bVar2 = this.g;
            if (bVar2 != null && !bVar.equals(bVar2)) {
                for (Pair pair : this.d.values()) {
                    bVar2.d.u((u) pair.first, m.q0(bVar2, (x) pair.second, this.f));
                    bVar.d.A((u) pair.first, m.q0(bVar, (x) pair.second, this.f));
                }
            }
            this.g = bVar;
            return this.a.f(r(bVar, j));
        }

        public void h(b bVar, long j, boolean z) {
            this.a.v(n.g(j, bVar.c, this.f), z);
        }

        public final int i(x xVar) {
            String str;
            if (xVar.c == null) {
                return -1;
            }
            int i = 0;
            loop0: while (true) {
                s[] sVarArr = this.j;
                if (i >= sVarArr.length) {
                    return -1;
                }
                s sVar = sVarArr[i];
                if (sVar != null) {
                    g0 k = sVar.k();
                    boolean z = xVar.b == 0 && k.equals(s().b(0));
                    for (int i2 = 0; i2 < k.a; i2++) {
                        z0 c = k.c(i2);
                        if (c.equals(xVar.c) || (z && (str = c.a) != null && str.equals(xVar.c.a))) {
                            break loop0;
                        }
                    }
                }
                i++;
            }
            return i;
        }

        public long k(b bVar, long j, H1 h1) {
            return n.d(this.a.d(n.g(j, bVar.c, this.f), h1), bVar.c, this.f);
        }

        public long l(b bVar) {
            return o(bVar, this.a.g());
        }

        public b m(x xVar) {
            if (xVar == null || xVar.f == -9223372036854775807L) {
                return null;
            }
            for (int i = 0; i < this.c.size(); i++) {
                b bVar = (b) this.c.get(i);
                if (bVar.i) {
                    long d = n.d(k0.P0(xVar.f), bVar.c, this.f);
                    long p0 = m.p0(bVar, this.f);
                    if (d >= 0 && d < p0) {
                        return bVar;
                    }
                }
            }
            return null;
        }

        public final long o(b bVar, long j) {
            if (j == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            long d = n.d(j, bVar.c, this.f);
            if (d >= m.p0(bVar, this.f)) {
                return Long.MIN_VALUE;
            }
            return d;
        }

        public long p(b bVar) {
            return o(bVar, this.a.c());
        }

        public List q(List list) {
            return this.a.k(list);
        }

        public final long r(b bVar, long j) {
            long j2 = bVar.g;
            return j < j2 ? n.g(j2, bVar.c, this.f) - (bVar.g - j) : n.g(j, bVar.c, this.f);
        }

        public i0 s() {
            return this.a.u();
        }

        public boolean t(b bVar) {
            return bVar.equals(this.g) && this.a.b();
        }

        public boolean u(int i) {
            return ((Y) k0.j(this.k[i])).e();
        }

        public boolean v() {
            return this.c.isEmpty();
        }

        public final void w(b bVar, int i) {
            x xVar;
            boolean[] zArr = bVar.h;
            if (zArr[i] || (xVar = this.l[i]) == null) {
                return;
            }
            zArr[i] = true;
            bVar.d.i(m.q0(bVar, xVar, this.f));
        }

        public void x(int i) {
            ((Y) k0.j(this.k[i])).a();
        }

        public void y() {
            this.a.p();
        }

        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public void j(z zVar) {
            b bVar = this.g;
            if (bVar == null) {
                return;
            }
            ((z.a) d4.a.e(bVar.f)).j(this.g);
        }
    }

    public m(C c2, a aVar) {
        this.i = c2;
        this.m = aVar;
    }

    public static /* synthetic */ void o0(m mVar, A a2, Q1 q1) {
        mVar.v0(a2, q1);
    }

    public static /* synthetic */ long p0(b bVar, C3.b bVar2) {
        return t0(bVar, bVar2);
    }

    public static /* synthetic */ x q0(b bVar, x xVar, C3.b bVar2) {
        return r0(bVar, xVar, bVar2);
    }

    public static x r0(b bVar, x xVar, C3.b bVar2) {
        return new x(xVar.a, xVar.b, xVar.c, xVar.d, xVar.e, s0(xVar.f, bVar, bVar2), s0(xVar.g, bVar, bVar2));
    }

    public static long s0(long j, b bVar, C3.b bVar2) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long P0 = k0.P0(j);
        C.b bVar3 = bVar.c;
        return k0.x1(bVar3.b() ? n.e(P0, bVar3.b, bVar3.c, bVar2) : n.f(P0, -1, bVar2));
    }

    public static long t0(b bVar, C3.b bVar2) {
        C.b bVar3 = bVar.c;
        if (bVar3.b()) {
            b.b e2 = bVar2.e(bVar3.b);
            if (e2.c == -1) {
                return 0L;
            }
            return e2.g[bVar3.c];
        }
        int i = bVar3.e;
        if (i == -1) {
            return Long.MAX_VALUE;
        }
        long j = bVar2.e(i).a;
        if (j == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    public void C(int i, C.b bVar) {
        b u0 = u0(bVar, null, false);
        (u0 == null ? this.l : u0.e).j();
    }

    public void D(int i, C.b bVar, u uVar, x xVar) {
        b u0 = u0(bVar, xVar, true);
        if (u0 == null) {
            this.k.u(uVar, xVar);
        } else {
            u0.a.B(uVar);
            u0.d.u(uVar, r0(u0, xVar, (C3.b) d4.a.e((C3.b) this.p.get(u0.c.a))));
        }
    }

    public z E(C.b bVar, b4.b bVar2, long j) {
        e eVar;
        Pair pair = new Pair(Long.valueOf(bVar.d), bVar.a);
        e eVar2 = this.o;
        boolean z = false;
        if (eVar2 != null) {
            if (e.a(eVar2).equals(bVar.a)) {
                eVar = this.o;
                this.j.put(pair, eVar);
                z = true;
            } else {
                this.o.H(this.i);
                eVar = null;
            }
            this.o = null;
        } else {
            eVar = null;
        }
        if (eVar == null && ((eVar = (e) D.e(this.j.get((Object) pair), null)) == null || !eVar.f(bVar, j))) {
            C3.b bVar3 = (C3.b) d4.a.e((C3.b) this.p.get(bVar.a));
            e eVar3 = new e(this.i.E(new C.b(bVar.a, bVar.d), bVar2, n.g(j, bVar, bVar3)), bVar.a, bVar3);
            this.j.put(pair, eVar3);
            eVar = eVar3;
        }
        b bVar4 = new b(eVar, bVar, f0(bVar), b0(bVar));
        eVar.d(bVar4);
        if (z && eVar.j.length > 0) {
            bVar4.l(j);
        }
        return bVar4;
    }

    public void G(int i, C.b bVar) {
        b u0 = u0(bVar, null, false);
        (u0 == null ? this.l : u0.e).i();
    }

    public void I(int i, C.b bVar, u uVar, x xVar) {
        b u0 = u0(bVar, xVar, true);
        if (u0 == null) {
            this.k.r(uVar, xVar);
        } else {
            u0.a.B(uVar);
            u0.d.r(uVar, r0(u0, xVar, (C3.b) d4.a.e((C3.b) this.p.get(u0.c.a))));
        }
    }

    public void J(C c2, Q1 q1) {
        a aVar = this.m;
        if ((aVar == null || !aVar.o(q1)) && !this.p.isEmpty()) {
            m0(new d(q1, this.p));
        }
    }

    public /* synthetic */ void K(int i, C.b bVar) {
        p.a(this, i, bVar);
    }

    public void L(int i, C.b bVar, u uVar, x xVar, IOException iOException, boolean z) {
        b u0 = u0(bVar, xVar, true);
        if (u0 == null) {
            this.k.x(uVar, xVar, iOException, z);
            return;
        }
        if (z) {
            u0.a.B(uVar);
        }
        u0.d.x(uVar, r0(u0, xVar, (C3.b) d4.a.e((C3.b) this.p.get(u0.c.a))), iOException, z);
    }

    public void N(int i, C.b bVar, int i2) {
        b u0 = u0(bVar, null, true);
        (u0 == null ? this.l : u0.e).k(i2);
    }

    public void P() {
        this.i.P();
    }

    public void Q(int i, C.b bVar, Exception exc) {
        b u0 = u0(bVar, null, false);
        (u0 == null ? this.l : u0.e).l(exc);
    }

    public void R(int i, C.b bVar, u uVar, x xVar) {
        b u0 = u0(bVar, xVar, true);
        if (u0 == null) {
            this.k.A(uVar, xVar);
        } else {
            u0.a.C(uVar, xVar);
            u0.d.A(uVar, r0(u0, xVar, (C3.b) d4.a.e((C3.b) this.p.get(u0.c.a))));
        }
    }

    public void T(int i, C.b bVar) {
        b u0 = u0(bVar, null, false);
        (u0 == null ? this.l : u0.e).h();
    }

    public void Y(z zVar) {
        b bVar = (b) zVar;
        bVar.a.I(bVar);
        if (bVar.a.v()) {
            this.j.remove(new Pair(Long.valueOf(bVar.c.d), bVar.c.a), bVar.a);
            boolean isEmpty = this.j.isEmpty();
            e eVar = bVar.a;
            if (isEmpty) {
                this.o = eVar;
            } else {
                eVar.H(this.i);
            }
        }
    }

    public void Z(int i, C.b bVar, x xVar) {
        b u0 = u0(bVar, xVar, false);
        if (u0 == null) {
            this.k.i(xVar);
        } else {
            u0.a.A(u0, xVar);
            u0.d.i(r0(u0, xVar, (C3.b) d4.a.e((C3.b) this.p.get(u0.c.a))));
        }
    }

    public void c0(int i, C.b bVar) {
        b u0 = u0(bVar, null, false);
        (u0 == null ? this.l : u0.e).m();
    }

    public H0 e() {
        return this.i.e();
    }

    public void g0() {
        w0();
        this.i.B(this);
    }

    public void h0() {
        this.i.F(this);
    }

    public void l0(S s) {
        Handler x = k0.x();
        synchronized (this) {
            this.n = x;
        }
        this.i.k(x, this);
        this.i.A(x, this);
        this.i.a(this, s, i0());
    }

    public void n0() {
        w0();
        synchronized (this) {
            this.n = null;
        }
        this.i.V(this);
        this.i.u(this);
        this.i.z(this);
    }

    public void o(int i, C.b bVar, x xVar) {
        b u0 = u0(bVar, xVar, false);
        if (u0 == null) {
            this.k.D(xVar);
        } else {
            u0.d.D(r0(u0, xVar, (C3.b) d4.a.e((C3.b) this.p.get(u0.c.a))));
        }
    }

    public final b u0(C.b bVar, x xVar, boolean z) {
        if (bVar == null) {
            return null;
        }
        List list = this.j.get((Object) new Pair(Long.valueOf(bVar.d), bVar.a));
        if (list.isEmpty()) {
            return null;
        }
        if (z) {
            e eVar = (e) D.d(list);
            return e.b(eVar) != null ? e.b(eVar) : (b) D.d(e.c(eVar));
        }
        for (int i = 0; i < list.size(); i++) {
            b m = ((e) list.get(i)).m(xVar);
            if (m != null) {
                return m;
            }
        }
        return (b) e.c((e) list.get(0)).get(0);
    }

    public final /* synthetic */ void v0(A a2, Q1 q1) {
        C3.b bVar;
        for (e eVar : this.j.values()) {
            C3.b bVar2 = (C3.b) a2.get(e.a(eVar));
            if (bVar2 != null) {
                eVar.M(bVar2);
            }
        }
        e eVar2 = this.o;
        if (eVar2 != null && (bVar = (C3.b) a2.get(e.a(eVar2))) != null) {
            this.o.M(bVar);
        }
        this.p = a2;
        m0(new d(q1, a2));
    }

    public final void w0() {
        e eVar = this.o;
        if (eVar != null) {
            eVar.H(this.i);
            this.o = null;
        }
    }

    public void x0(A a2, Q1 q1) {
        d4.a.a(!a2.isEmpty());
        Object e2 = d4.a.e(((C3.b) a2.n().d().get(0)).a);
        c0 l = a2.h().l();
        while (l.hasNext()) {
            Map.Entry entry = (Map.Entry) l.next();
            Object key = entry.getKey();
            C3.b bVar = (C3.b) entry.getValue();
            d4.a.a(k0.c(e2, bVar.a));
            C3.b bVar2 = (C3.b) this.p.get(key);
            if (bVar2 != null) {
                for (int i = bVar.f; i < bVar.c; i++) {
                    b.b e3 = bVar.e(i);
                    d4.a.a(e3.i);
                    if (i < bVar2.c && n.c(bVar, i) < n.c(bVar2, i)) {
                        b.b e4 = bVar.e(i + 1);
                        d4.a.a(e3.h + e4.h == bVar2.e(i).h);
                        d4.a.a(e3.a + e3.h == e4.a);
                    }
                    if (e3.a == Long.MIN_VALUE) {
                        d4.a.a(n.c(bVar, i) == 0);
                    }
                }
            }
        }
        synchronized (this) {
            try {
                Handler handler = this.n;
                if (handler == null) {
                    this.p = a2;
                } else {
                    handler.post(new l(this, a2, q1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
