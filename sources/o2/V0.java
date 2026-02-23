package O2;

import B3.C;
import B3.z;
import O2.C1;
import O2.E1;
import O2.H0;
import O2.Q1;
import O2.k1;
import O2.r;
import O2.x1;
import V2.o;
import Z3.C;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import q3.a;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v0 implements Handler.Callback, z.a, C.a, k1.d, r.a, x1.a {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public int K;
    public h L;
    public long M;
    public int N;
    public boolean O;
    public w P;
    public long Q;
    public long R = -9223372036854775807L;
    public final C1[] a;
    public final Set c;
    public final E1[] d;
    public final Z3.C e;
    public final Z3.D f;
    public final F0 g;
    public final b4.f h;
    public final d4.w i;
    public final HandlerThread j;
    public final Looper k;
    public final Q1.d l;
    public final Q1.b m;
    public final long n;
    public final boolean o;
    public final r p;
    public final ArrayList q;
    public final d4.e r;
    public final f s;
    public final V0 t;
    public final k1 u;
    public final E0 v;
    public final long w;
    public H1 x;
    public q1 y;
    public e z;

    public class a implements C1.a {
        public a() {
        }

        public void a() {
            v0.h(v0.this, true);
        }

        public void b() {
            v0.i(v0.this).j(2);
        }
    }

    public static final class b {
        public final List a;
        public final B3.a0 b;
        public final int c;
        public final long d;

        public b(List list, B3.a0 a0Var, int i, long j) {
            this.a = list;
            this.b = a0Var;
            this.c = i;
            this.d = j;
        }

        public static /* synthetic */ int a(b bVar) {
            return bVar.c;
        }

        public static /* synthetic */ List b(b bVar) {
            return bVar.a;
        }

        public static /* synthetic */ B3.a0 c(b bVar) {
            return bVar.b;
        }

        public static /* synthetic */ long d(b bVar) {
            return bVar.d;
        }

        public /* synthetic */ b(List list, B3.a0 a0Var, int i, long j, a aVar) {
            this(list, a0Var, i, j);
        }
    }

    public static class c {
    }

    public static final class d implements Comparable {
        public final x1 a;
        public int c;
        public long d;
        public Object e;

        public d(x1 x1Var) {
            this.a = x1Var;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.e;
            if ((obj == null) != (dVar.e == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.c - dVar.c;
            return i != 0 ? i : d4.k0.p(this.d, dVar.d);
        }

        public void b(int i, long j, Object obj) {
            this.c = i;
            this.d = j;
            this.e = obj;
        }
    }

    public static final class e {
        public boolean a;
        public q1 b;
        public int c;
        public boolean d;
        public int e;
        public boolean f;
        public int g;

        public e(q1 q1Var) {
            this.b = q1Var;
        }

        public static /* synthetic */ boolean a(e eVar) {
            return eVar.a;
        }

        public void b(int i) {
            this.a |= i > 0;
            this.c += i;
        }

        public void c(int i) {
            this.a = true;
            this.f = true;
            this.g = i;
        }

        public void d(q1 q1Var) {
            this.a |= this.b != q1Var;
            this.b = q1Var;
        }

        public void e(int i) {
            if (this.d && this.e != 5) {
                d4.a.a(i == 5);
                return;
            }
            this.a = true;
            this.d = true;
            this.e = i;
        }
    }

    public interface f {
        void a(e eVar);
    }

    public static final class g {
        public final C.b a;
        public final long b;
        public final long c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public g(C.b bVar, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.a = bVar;
            this.b = j;
            this.c = j2;
            this.d = z;
            this.e = z2;
            this.f = z3;
        }
    }

    public static final class h {
        public final Q1 a;
        public final int b;
        public final long c;

        public h(Q1 q1, int i, long j) {
            this.a = q1;
            this.b = i;
            this.c = j;
        }
    }

    public v0(C1[] c1Arr, Z3.C c2, Z3.D d2, F0 f0, b4.f fVar, int i, boolean z, P2.a aVar, H1 h1, E0 e0, long j, boolean z2, Looper looper, d4.e eVar, f fVar2, P2.v0 v0Var, Looper looper2) {
        this.s = fVar2;
        this.a = c1Arr;
        this.e = c2;
        this.f = d2;
        this.g = f0;
        this.h = fVar;
        this.F = i;
        this.G = z;
        this.x = h1;
        this.v = e0;
        this.w = j;
        this.Q = j;
        this.B = z2;
        this.r = eVar;
        this.n = f0.b();
        this.o = f0.a();
        q1 k = q1.k(d2);
        this.y = k;
        this.z = new e(k);
        this.d = new E1[c1Arr.length];
        E1.a d3 = c2.d();
        for (int i2 = 0; i2 < c1Arr.length; i2++) {
            c1Arr[i2].l(i2, v0Var);
            this.d[i2] = c1Arr[i2].q();
            if (d3 != null) {
                this.d[i2].i(d3);
            }
        }
        this.p = new r(this, eVar);
        this.q = new ArrayList();
        this.c = s5.Z.h();
        this.l = new Q1.d();
        this.m = new Q1.b();
        c2.e(this, fVar);
        this.O = true;
        d4.w c3 = eVar.c(looper, null);
        this.t = new V0(aVar, c3);
        this.u = new k1(this, aVar, c3, v0Var);
        if (looper2 != null) {
            this.j = null;
            this.k = looper2;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.j = handlerThread;
            handlerThread.start();
            this.k = handlerThread.getLooper();
        }
        this.i = eVar.c(this.k, this);
    }

    public static Pair A0(Q1 q1, h hVar, boolean z, int i, boolean z2, Q1.d dVar, Q1.b bVar) {
        Pair o;
        Object B0;
        Q1 q12 = hVar.a;
        if (q1.v()) {
            return null;
        }
        Q1 q13 = q12.v() ? q1 : q12;
        try {
            o = q13.o(dVar, bVar, hVar.b, hVar.c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (q1.equals(q13)) {
            return o;
        }
        if (q1.f(o.first) != -1) {
            return (q13.m(o.first, bVar).g && q13.s(bVar.d, dVar).p == q13.f(o.first)) ? q1.o(dVar, bVar, q1.m(o.first, bVar).d, hVar.c) : o;
        }
        if (z && (B0 = B0(dVar, bVar, i, z2, o.first, q13, q1)) != null) {
            return q1.o(dVar, bVar, q1.m(B0, bVar).d, -9223372036854775807L);
        }
        return null;
    }

    public static Object B0(Q1.d dVar, Q1.b bVar, int i, boolean z, Object obj, Q1 q1, Q1 q12) {
        int f2 = q1.f(obj);
        int n = q1.n();
        int i2 = f2;
        int i3 = -1;
        for (int i4 = 0; i4 < n && i3 == -1; i4++) {
            i2 = q1.i(i2, bVar, dVar, i, z);
            if (i2 == -1) {
                break;
            }
            i3 = q12.f(q1.r(i2));
        }
        if (i3 == -1) {
            return null;
        }
        return q12.r(i3);
    }

    public static boolean Q(boolean z, C.b bVar, long j, C.b bVar2, Q1.b bVar3, long j2) {
        if (!z && j == j2 && bVar.a.equals(bVar2.a)) {
            return (bVar.b() && bVar3.x(bVar.b)) ? (bVar3.l(bVar.b, bVar.c) == 4 || bVar3.l(bVar.b, bVar.c) == 2) ? false : true : bVar2.b() && bVar3.x(bVar2.b);
        }
        return false;
    }

    public static boolean S(C1 c1) {
        return c1.getState() != 0;
    }

    public static boolean U(q1 q1Var, Q1.b bVar) {
        C.b bVar2 = q1Var.b;
        Q1 q1 = q1Var.a;
        return q1.v() || q1.m(bVar2.a, bVar).g;
    }

    public static /* synthetic */ Boolean f(v0 v0Var) {
        return v0Var.V();
    }

    public static /* synthetic */ void g(v0 v0Var, x1 x1Var) {
        v0Var.W(x1Var);
    }

    public static /* synthetic */ boolean h(v0 v0Var, boolean z) {
        v0Var.I = z;
        return z;
    }

    public static /* synthetic */ d4.w i(v0 v0Var) {
        return v0Var.i;
    }

    private void n0() {
        t0(true, false, true, false);
        o0();
        this.g.f();
        d1(1);
        HandlerThread handlerThread = this.j;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        synchronized (this) {
            this.A = true;
            notifyAll();
        }
    }

    public static void w0(Q1 q1, d dVar, Q1.d dVar2, Q1.b bVar) {
        int i = q1.s(q1.m(dVar.e, bVar).d, dVar2).q;
        Object obj = q1.l(i, bVar, true).c;
        long j = bVar.e;
        dVar.b(i, j != -9223372036854775807L ? j - 1 : Long.MAX_VALUE, obj);
    }

    public static boolean x0(d dVar, Q1 q1, Q1 q12, int i, boolean z, Q1.d dVar2, Q1.b bVar) {
        Object obj = dVar.e;
        if (obj == null) {
            Pair A0 = A0(q1, new h(dVar.a.h(), dVar.a.d(), dVar.a.f() == Long.MIN_VALUE ? -9223372036854775807L : d4.k0.P0(dVar.a.f())), false, i, z, dVar2, bVar);
            if (A0 == null) {
                return false;
            }
            dVar.b(q1.f(A0.first), ((Long) A0.second).longValue(), A0.first);
            if (dVar.a.f() == Long.MIN_VALUE) {
                w0(q1, dVar, dVar2, bVar);
            }
            return true;
        }
        int f2 = q1.f(obj);
        if (f2 == -1) {
            return false;
        }
        if (dVar.a.f() == Long.MIN_VALUE) {
            w0(q1, dVar, dVar2, bVar);
            return true;
        }
        dVar.c = f2;
        q12.m(dVar.e, bVar);
        if (bVar.g && q12.s(bVar.d, dVar2).p == q12.f(dVar.e)) {
            Pair o = q1.o(dVar2, bVar, q1.m(dVar.e, bVar).d, dVar.d + bVar.t());
            dVar.b(q1.f(o.first), ((Long) o.second).longValue(), o.first);
        }
        return true;
    }

    public static z0[] z(Z3.s sVar) {
        int length = sVar != null ? sVar.length() : 0;
        z0[] z0VarArr = new z0[length];
        for (int i = 0; i < length; i++) {
            z0VarArr[i] = sVar.c(i);
        }
        return z0VarArr;
    }

    public static g z0(Q1 q1, q1 q1Var, h hVar, V0 v0, int i, boolean z, Q1.d dVar, Q1.b bVar) {
        int i2;
        C.b bVar2;
        long j;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        boolean z5;
        V0 v02;
        long j2;
        int i6;
        boolean z6;
        int i7;
        boolean z7;
        boolean z8;
        if (q1.v()) {
            return new g(q1.l(), 0L, -9223372036854775807L, false, true, false);
        }
        C.b bVar3 = q1Var.b;
        Object obj = bVar3.a;
        boolean U = U(q1Var, bVar);
        long j3 = (q1Var.b.b() || U) ? q1Var.c : q1Var.r;
        if (hVar != null) {
            i2 = -1;
            Pair A0 = A0(q1, hVar, true, i, z, dVar, bVar);
            if (A0 == null) {
                i7 = q1.e(z);
                j = j3;
                z6 = false;
                z7 = false;
                z8 = true;
            } else {
                if (hVar.c == -9223372036854775807L) {
                    i7 = q1.m(A0.first, bVar).d;
                    j = j3;
                    z6 = false;
                } else {
                    obj = A0.first;
                    j = ((Long) A0.second).longValue();
                    z6 = true;
                    i7 = -1;
                }
                z7 = q1Var.e == 4;
                z8 = false;
            }
            z4 = z6;
            z2 = z7;
            z3 = z8;
            i3 = i7;
            bVar2 = bVar3;
        } else {
            i2 = -1;
            if (q1Var.a.v()) {
                i4 = q1.e(z);
            } else if (q1.f(obj) == -1) {
                Object B0 = B0(dVar, bVar, i, z, obj, q1Var.a, q1);
                if (B0 == null) {
                    i5 = q1.e(z);
                    z5 = true;
                } else {
                    i5 = q1.m(B0, bVar).d;
                    z5 = false;
                }
                i3 = i5;
                z3 = z5;
                j = j3;
                bVar2 = bVar3;
                z2 = false;
                z4 = false;
            } else if (j3 == -9223372036854775807L) {
                i4 = q1.m(obj, bVar).d;
            } else if (U) {
                bVar2 = bVar3;
                q1Var.a.m(bVar2.a, bVar);
                if (q1Var.a.s(bVar.d, dVar).p == q1Var.a.f(bVar2.a)) {
                    Pair o = q1.o(dVar, bVar, q1.m(obj, bVar).d, j3 + bVar.t());
                    obj = o.first;
                    j = ((Long) o.second).longValue();
                } else {
                    j = j3;
                }
                i3 = -1;
                z2 = false;
                z3 = false;
                z4 = true;
            } else {
                bVar2 = bVar3;
                j = j3;
                i3 = -1;
                z2 = false;
                z3 = false;
                z4 = false;
            }
            i3 = i4;
            j = j3;
            bVar2 = bVar3;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        if (i3 != i2) {
            Pair o2 = q1.o(dVar, bVar, i3, -9223372036854775807L);
            obj = o2.first;
            j = ((Long) o2.second).longValue();
            v02 = v0;
            j2 = -9223372036854775807L;
        } else {
            v02 = v0;
            j2 = j;
        }
        C.b F = v02.F(q1, obj, j);
        int i8 = F.e;
        boolean z9 = bVar2.a.equals(obj) && !bVar2.b() && !F.b() && (i8 == i2 || ((i6 = bVar2.e) != i2 && i8 >= i6));
        C.b bVar4 = bVar2;
        boolean Q = Q(U, bVar2, j3, F, q1.m(obj, bVar), j2);
        if (z9 || Q) {
            F = bVar4;
        }
        if (F.b()) {
            if (F.equals(bVar4)) {
                j = q1Var.r;
            } else {
                q1.m(F.a, bVar);
                j = F.c == bVar.q(F.b) ? bVar.k() : 0L;
            }
        }
        return new g(F, j, j2, z2, z3, z4);
    }

    public final long A(Q1 q1, Object obj, long j) {
        q1.s(q1.m(obj, this.m).d, this.l);
        Q1.d dVar = this.l;
        if (dVar.g != -9223372036854775807L && dVar.i()) {
            Q1.d dVar2 = this.l;
            if (dVar2.j) {
                return d4.k0.P0(dVar2.c() - this.l.g) - (j + this.m.t());
            }
        }
        return -9223372036854775807L;
    }

    public final long B() {
        S0 s = this.t.s();
        if (s == null) {
            return 0L;
        }
        long l = s.l();
        if (!s.d) {
            return l;
        }
        int i = 0;
        while (true) {
            C1[] c1Arr = this.a;
            if (i >= c1Arr.length) {
                return l;
            }
            if (S(c1Arr[i]) && this.a[i].f() == s.c[i]) {
                long v = this.a[i].v();
                if (v == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                l = Math.max(v, l);
            }
            i++;
        }
    }

    public final Pair C(Q1 q1) {
        if (q1.v()) {
            return Pair.create(q1.l(), 0L);
        }
        Pair o = q1.o(this.l, this.m, q1.e(this.G), -9223372036854775807L);
        C.b F = this.t.F(q1, o.first, 0L);
        long longValue = ((Long) o.second).longValue();
        if (F.b()) {
            q1.m(F.a, this.m);
            longValue = F.c == this.m.q(F.b) ? this.m.k() : 0L;
        }
        return Pair.create(F, Long.valueOf(longValue));
    }

    public final void C0(long j, long j2) {
        this.i.k(2, j + j2);
    }

    public Looper D() {
        return this.k;
    }

    public void D0(Q1 q1, int i, long j) {
        this.i.d(3, new h(q1, i, j)).a();
    }

    public final long E() {
        return F(this.y.p);
    }

    public final void E0(boolean z) {
        C.b bVar = this.t.r().f.a;
        long H0 = H0(bVar, this.y.r, true, false);
        if (H0 != this.y.r) {
            q1 q1Var = this.y;
            this.y = N(bVar, H0, q1Var.c, q1Var.d, z, 5);
        }
    }

    public final long F(long j) {
        S0 l = this.t.l();
        if (l == null) {
            return 0L;
        }
        return Math.max(0L, j - l.y(this.M));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ab A[Catch: all -> 0x00ae, TryCatch #1 {all -> 0x00ae, blocks: (B:6:0x00a1, B:8:0x00ab, B:15:0x00b5, B:17:0x00bb, B:18:0x00be, B:19:0x00c4, B:21:0x00ce, B:23:0x00d6, B:27:0x00de, B:28:0x00e8, B:30:0x00f8, B:34:0x0102, B:37:0x0114, B:40:0x011d), top: B:5:0x00a1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void F0(O2.v0.h r20) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: O2.v0.F0(O2.v0$h):void");
    }

    public final void G(B3.z zVar) {
        if (this.t.y(zVar)) {
            this.t.C(this.M);
            X();
        }
    }

    public final long G0(C.b bVar, long j, boolean z) {
        return H0(bVar, j, this.t.r() != this.t.s(), z);
    }

    public final void H(IOException iOException, int i) {
        w j = w.j(iOException, i);
        S0 r = this.t.r();
        if (r != null) {
            j = j.g(r.f.a);
        }
        d4.B.e("ExoPlayerImplInternal", "Playback error", j);
        l1(false, false);
        this.y = this.y.f(j);
    }

    public final long H0(C.b bVar, long j, boolean z, boolean z2) {
        m1();
        this.D = false;
        if (z2 || this.y.e == 3) {
            d1(2);
        }
        S0 r = this.t.r();
        S0 s0 = r;
        while (s0 != null && !bVar.equals(s0.f.a)) {
            s0 = s0.j();
        }
        if (z || r != s0 || (s0 != null && s0.z(j) < 0)) {
            for (C1 c1 : this.a) {
                p(c1);
            }
            if (s0 != null) {
                while (this.t.r() != s0) {
                    this.t.b();
                }
                this.t.D(s0);
                s0.x(1000000000000L);
                s();
            }
        }
        V0 v0 = this.t;
        if (s0 != null) {
            v0.D(s0);
            if (!s0.d) {
                s0.f = s0.f.b(j);
            } else if (s0.e) {
                j = s0.a.l(j);
                s0.a.v(j - this.n, this.o);
            }
            v0(j);
            X();
        } else {
            v0.f();
            v0(j);
        }
        I(false);
        this.i.j(2);
        return j;
    }

    public final void I(boolean z) {
        S0 l = this.t.l();
        C.b bVar = l == null ? this.y.b : l.f.a;
        boolean z2 = !this.y.k.equals(bVar);
        if (z2) {
            this.y = this.y.c(bVar);
        }
        q1 q1Var = this.y;
        q1Var.p = l == null ? q1Var.r : l.i();
        this.y.q = E();
        if ((z2 || z) && l != null && l.d) {
            o1(l.f.a, l.n(), l.o());
        }
    }

    public final void I0(x1 x1Var) {
        if (x1Var.f() == -9223372036854775807L) {
            J0(x1Var);
            return;
        }
        if (this.y.a.v()) {
            this.q.add(new d(x1Var));
            return;
        }
        d dVar = new d(x1Var);
        Q1 q1 = this.y.a;
        if (!x0(dVar, q1, q1, this.F, this.G, this.l, this.m)) {
            x1Var.k(false);
        } else {
            this.q.add(dVar);
            Collections.sort(this.q);
        }
    }

    /* JADX WARN: Not initialized variable reg: 25, insn: 0x007c: MOVE (r5 I:??[long, double]) = (r25 I:??[long, double]) (LINE:125), block:B:105:0x007b */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void J(O2.Q1 r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: O2.v0.J(O2.Q1, boolean):void");
    }

    public final void J0(x1 x1Var) {
        if (x1Var.c() != this.k) {
            this.i.d(15, x1Var).a();
            return;
        }
        o(x1Var);
        int i = this.y.e;
        if (i == 3 || i == 2) {
            this.i.j(2);
        }
    }

    public final void K(B3.z zVar) {
        if (this.t.y(zVar)) {
            S0 l = this.t.l();
            l.p(this.p.c().a, this.y.a);
            o1(l.f.a, l.n(), l.o());
            if (l == this.t.r()) {
                v0(l.f.b);
                s();
                q1 q1Var = this.y;
                C.b bVar = q1Var.b;
                long j = l.f.b;
                this.y = N(bVar, j, q1Var.c, j, false, 5);
            }
            X();
        }
    }

    public final void K0(x1 x1Var) {
        Looper c2 = x1Var.c();
        if (c2.getThread().isAlive()) {
            this.r.c(c2, null).i(new u0(this, x1Var));
        } else {
            d4.B.j("TAG", "Trying to send message on a dead thread.");
            x1Var.k(false);
        }
    }

    public final void L(s1 s1Var, float f2, boolean z, boolean z2) {
        if (z) {
            if (z2) {
                this.z.b(1);
            }
            this.y = this.y.g(s1Var);
        }
        s1(s1Var.a);
        for (C1 c1 : this.a) {
            if (c1 != null) {
                c1.s(f2, s1Var.a);
            }
        }
    }

    public final void L0(long j) {
        for (C1 c1 : this.a) {
            if (c1.f() != null) {
                M0(c1, j);
            }
        }
    }

    public final void M(s1 s1Var, boolean z) {
        L(s1Var, s1Var.a, true, z);
    }

    public final void M0(C1 c1, long j) {
        c1.j();
        if (c1 instanceof P3.r) {
            ((P3.r) c1).c0(j);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    public final q1 N(C.b bVar, long j, long j2, long j3, boolean z, int i) {
        s5.y yVar;
        B3.i0 i0Var;
        Z3.D d2;
        this.O = (!this.O && j == this.y.r && bVar.equals(this.y.b)) ? false : true;
        u0();
        q1 q1Var = this.y;
        B3.i0 i0Var2 = q1Var.h;
        Z3.D d3 = q1Var.i;
        ?? r1 = q1Var.j;
        if (this.u.t()) {
            S0 r = this.t.r();
            B3.i0 n = r == null ? B3.i0.e : r.n();
            Z3.D o = r == null ? this.f : r.o();
            s5.y x = x(o.c);
            if (r != null) {
                T0 t0 = r.f;
                if (t0.c != j2) {
                    r.f = t0.a(j2);
                }
            }
            i0Var = n;
            d2 = o;
            yVar = x;
        } else if (bVar.equals(this.y.b)) {
            yVar = r1;
            i0Var = i0Var2;
            d2 = d3;
        } else {
            i0Var = B3.i0.e;
            d2 = this.f;
            yVar = s5.y.z();
        }
        if (z) {
            this.z.e(i);
        }
        return this.y.d(bVar, j, j2, j3, E(), i0Var, d2, yVar);
    }

    public final void N0(boolean z, AtomicBoolean atomicBoolean) {
        if (this.H != z) {
            this.H = z;
            if (!z) {
                for (C1 c1 : this.a) {
                    if (!S(c1) && this.c.remove(c1)) {
                        c1.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final boolean O(C1 c1, S0 s0) {
        S0 j = s0.j();
        return s0.f.f && j.d && ((c1 instanceof P3.r) || (c1 instanceof q3.g) || c1.v() >= j.m());
    }

    public final void O0(s1 s1Var) {
        this.i.l(16);
        this.p.b(s1Var);
    }

    public final boolean P() {
        S0 s = this.t.s();
        if (!s.d) {
            return false;
        }
        int i = 0;
        while (true) {
            C1[] c1Arr = this.a;
            if (i >= c1Arr.length) {
                return true;
            }
            C1 c1 = c1Arr[i];
            B3.Y y = s.c[i];
            if (c1.f() != y || (y != null && !c1.h() && !O(c1, s))) {
                break;
            }
            i++;
        }
        return false;
    }

    public final void P0(b bVar) {
        this.z.b(1);
        if (b.a(bVar) != -1) {
            this.L = new h(new y1(b.b(bVar), b.c(bVar)), b.a(bVar), b.d(bVar));
        }
        J(this.u.C(b.b(bVar), b.c(bVar)), false);
    }

    public void Q0(List list, int i, long j, B3.a0 a0Var) {
        this.i.d(17, new b(list, a0Var, i, j, null)).a();
    }

    public final boolean R() {
        S0 l = this.t.l();
        return (l == null || l.k() == Long.MIN_VALUE) ? false : true;
    }

    public final void R0(boolean z) {
        if (z == this.J) {
            return;
        }
        this.J = z;
        if (z || !this.y.o) {
            return;
        }
        this.i.j(2);
    }

    public final void S0(boolean z) {
        this.B = z;
        u0();
        if (!this.C || this.t.s() == this.t.r()) {
            return;
        }
        E0(true);
        I(false);
    }

    public final boolean T() {
        S0 r = this.t.r();
        long j = r.f.e;
        return r.d && (j == -9223372036854775807L || this.y.r < j || !g1());
    }

    public void T0(boolean z, int i) {
        this.i.g(1, z ? 1 : 0, i).a();
    }

    public final void U0(boolean z, int i, boolean z2, int i2) {
        this.z.b(z2 ? 1 : 0);
        this.z.c(i2);
        this.y = this.y.e(z, i);
        this.D = false;
        h0(z);
        if (!g1()) {
            m1();
            q1();
            return;
        }
        int i3 = this.y.e;
        if (i3 == 3) {
            j1();
        } else if (i3 != 2) {
            return;
        }
        this.i.j(2);
    }

    public final /* synthetic */ Boolean V() {
        return Boolean.valueOf(this.A);
    }

    public void V0(s1 s1Var) {
        this.i.d(4, s1Var).a();
    }

    public final /* synthetic */ void W(x1 x1Var) {
        try {
            o(x1Var);
        } catch (w e2) {
            d4.B.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    public final void W0(s1 s1Var) {
        O0(s1Var);
        M(this.p.c(), true);
    }

    public final void X() {
        boolean f1 = f1();
        this.E = f1;
        if (f1) {
            this.t.l().d(this.M);
        }
        n1();
    }

    public void X0(int i) {
        this.i.g(11, i, 0).a();
    }

    public final void Y() {
        this.z.d(this.y);
        if (e.a(this.z)) {
            this.s.a(this.z);
            this.z = new e(this.y);
        }
    }

    public final void Y0(int i) {
        this.F = i;
        if (!this.t.K(this.y.a, i)) {
            E0(true);
        }
        I(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (r1 < r8.q.size()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        r3 = (O2.v0.d) r8.q.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0079, code lost:
    
        if (r3 == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007d, code lost:
    
        if (r3.e == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
    
        r4 = r3.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0081, code lost:
    
        if (r4 < r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0083, code lost:
    
        if (r4 != r0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
    
        if (r3.d > r9) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
    
        if (r3 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
    
        if (r3.e == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
    
        if (r3.c != r0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a0, code lost:
    
        r4 = r3.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a4, code lost:
    
        if (r4 <= r9) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a8, code lost:
    
        if (r4 > r11) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00aa, code lost:
    
        J0(r3.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b5, code lost:
    
        if (r3.a.b() != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bd, code lost:
    
        if (r3.a.j() == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c0, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ce, code lost:
    
        if (r1 >= r8.q.size()) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d9, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d0, code lost:
    
        r3 = (O2.v0.d) r8.q.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c3, code lost:
    
        r8.q.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00db, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e2, code lost:
    
        if (r3.a.b() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f1, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ec, code lost:
    
        r8.q.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f2, code lost:
    
        r8.N = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f4, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x008b, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0093, code lost:
    
        if (r1 >= r8.q.size()) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0078, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0079, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0093 -> B:24:0x006f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Z(long r9, long r11) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: O2.v0.Z(long, long):void");
    }

    public final void Z0(H1 h1) {
        this.x = h1;
    }

    public void a(C1 c1) {
        this.i.j(26);
    }

    public final void a0() {
        T0 q;
        this.t.C(this.M);
        if (this.t.H() && (q = this.t.q(this.M, this.y)) != null) {
            S0 g2 = this.t.g(this.d, this.e, this.g.d(), this.u, q, this.f);
            g2.a.s(this, q.b);
            if (this.t.r() == g2) {
                v0(q.b);
            }
            I(false);
        }
        if (!this.E) {
            X();
        } else {
            this.E = R();
            n1();
        }
    }

    public void a1(boolean z) {
        this.i.g(12, z ? 1 : 0, 0).a();
    }

    public void b() {
        this.i.j(10);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b0() {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
        L2:
            boolean r2 = r14.e1()
            if (r2 == 0) goto L61
            if (r1 == 0) goto Ld
            r14.Y()
        Ld:
            O2.V0 r1 = r14.t
            O2.S0 r1 = r1.b()
            java.lang.Object r1 = d4.a.e(r1)
            O2.S0 r1 = (O2.S0) r1
            O2.q1 r2 = r14.y
            B3.C$b r2 = r2.b
            java.lang.Object r2 = r2.a
            O2.T0 r3 = r1.f
            B3.C$b r3 = r3.a
            java.lang.Object r3 = r3.a
            boolean r2 = r2.equals(r3)
            r3 = 1
            if (r2 == 0) goto L45
            O2.q1 r2 = r14.y
            B3.C$b r2 = r2.b
            int r4 = r2.b
            r5 = -1
            if (r4 != r5) goto L45
            O2.T0 r4 = r1.f
            B3.C$b r4 = r4.a
            int r6 = r4.b
            if (r6 != r5) goto L45
            int r2 = r2.e
            int r4 = r4.e
            if (r2 == r4) goto L45
            r2 = 1
            goto L46
        L45:
            r2 = 0
        L46:
            O2.T0 r1 = r1.f
            B3.C$b r5 = r1.a
            long r10 = r1.b
            long r8 = r1.c
            r12 = r2 ^ 1
            r13 = 0
            r4 = r14
            r6 = r10
            O2.q1 r1 = r4.N(r5, r6, r8, r10, r12, r13)
            r14.y = r1
            r14.u0()
            r14.q1()
            r1 = 1
            goto L2
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: O2.v0.b0():void");
    }

    public final void b1(boolean z) {
        this.G = z;
        if (!this.t.L(this.y.a, z)) {
            E0(true);
        }
        I(false);
    }

    public void c() {
        this.i.j(22);
    }

    public final void c0() {
        S0 s = this.t.s();
        if (s == null) {
            return;
        }
        int i = 0;
        if (s.j() != null && !this.C) {
            if (P()) {
                if (s.j().d || this.M >= s.j().m()) {
                    Z3.D o = s.o();
                    S0 c2 = this.t.c();
                    Z3.D o2 = c2.o();
                    Q1 q1 = this.y.a;
                    r1(q1, c2.f.a, q1, s.f.a, -9223372036854775807L, false);
                    if (c2.d && c2.a.m() != -9223372036854775807L) {
                        L0(c2.m());
                        return;
                    }
                    for (int i2 = 0; i2 < this.a.length; i2++) {
                        boolean c3 = o.c(i2);
                        boolean c4 = o2.c(i2);
                        if (c3 && !this.a[i2].p()) {
                            boolean z = this.d[i2].getTrackType() == -2;
                            F1 f1 = o.b[i2];
                            F1 f12 = o2.b[i2];
                            if (!c4 || !f12.equals(f1) || z) {
                                M0(this.a[i2], c2.m());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!s.f.i && !this.C) {
            return;
        }
        while (true) {
            C1[] c1Arr = this.a;
            if (i >= c1Arr.length) {
                return;
            }
            C1 c1 = c1Arr[i];
            B3.Y y = s.c[i];
            if (y != null && c1.f() == y && c1.h()) {
                long j = s.f.e;
                M0(c1, (j == -9223372036854775807L || j == Long.MIN_VALUE) ? -9223372036854775807L : s.l() + s.f.e);
            }
            i++;
        }
    }

    public final void c1(B3.a0 a0Var) {
        this.z.b(1);
        J(this.u.D(a0Var), false);
    }

    public synchronized void d(x1 x1Var) {
        if (!this.A && this.k.getThread().isAlive()) {
            this.i.d(14, x1Var).a();
            return;
        }
        d4.B.j("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        x1Var.k(false);
    }

    public final void d0() {
        S0 s = this.t.s();
        if (s == null || this.t.r() == s || s.g || !q0()) {
            return;
        }
        s();
    }

    public final void d1(int i) {
        q1 q1Var = this.y;
        if (q1Var.e != i) {
            if (i != 2) {
                this.R = -9223372036854775807L;
            }
            this.y = q1Var.h(i);
        }
    }

    public void e(B3.z zVar) {
        this.i.d(8, zVar).a();
    }

    public final void e0() {
        J(this.u.i(), true);
    }

    public final boolean e1() {
        S0 r;
        S0 j;
        return g1() && !this.C && (r = this.t.r()) != null && (j = r.j()) != null && this.M >= j.m() && j.g;
    }

    public final void f0(c cVar) {
        this.z.b(1);
        throw null;
    }

    public final boolean f1() {
        if (!R()) {
            return false;
        }
        S0 l = this.t.l();
        long F = F(l.k());
        long y = l == this.t.r() ? l.y(this.M) : l.y(this.M) - l.f.b;
        boolean h2 = this.g.h(y, F, this.p.c().a);
        if (h2 || F >= 500000) {
            return h2;
        }
        if (this.n <= 0 && !this.o) {
            return h2;
        }
        this.t.r().a.v(this.y.r, false);
        return this.g.h(y, F, this.p.c().a);
    }

    public final void g0() {
        for (S0 r = this.t.r(); r != null; r = r.j()) {
            for (Z3.s sVar : r.o().c) {
                if (sVar != null) {
                    sVar.h();
                }
            }
        }
    }

    public final boolean g1() {
        q1 q1Var = this.y;
        return q1Var.l && q1Var.m == 0;
    }

    public final void h0(boolean z) {
        for (S0 r = this.t.r(); r != null; r = r.j()) {
            for (Z3.s sVar : r.o().c) {
                if (sVar != null) {
                    sVar.m(z);
                }
            }
        }
    }

    public final boolean h1(boolean z) {
        if (this.K == 0) {
            return T();
        }
        if (!z) {
            return false;
        }
        if (!this.y.g) {
            return true;
        }
        S0 r = this.t.r();
        long b2 = i1(this.y.a, r.f.a) ? this.v.b() : -9223372036854775807L;
        S0 l = this.t.l();
        return (l.q() && l.f.i) || (l.f.a.b() && !l.d) || this.g.g(this.y.a, r.f.a, E(), this.p.c().a, this.D, b2);
    }

    public boolean handleMessage(Message message) {
        w e2;
        int i;
        S0 s;
        IOException iOException;
        try {
            switch (message.what) {
                case 0:
                    l0();
                    break;
                case 1:
                    U0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    q();
                    break;
                case 3:
                    F0((h) message.obj);
                    break;
                case 4:
                    W0((s1) message.obj);
                    break;
                case 5:
                    Z0((H1) message.obj);
                    break;
                case 6:
                    l1(false, true);
                    break;
                case 7:
                    n0();
                    return true;
                case 8:
                    K((B3.z) message.obj);
                    break;
                case 9:
                    G((B3.z) message.obj);
                    break;
                case 10:
                    r0();
                    break;
                case 11:
                    Y0(message.arg1);
                    break;
                case 12:
                    b1(message.arg1 != 0);
                    break;
                case 13:
                    N0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    I0((x1) message.obj);
                    break;
                case 15:
                    K0((x1) message.obj);
                    break;
                case 16:
                    M((s1) message.obj, false);
                    break;
                case 17:
                    P0((b) message.obj);
                    break;
                case 18:
                    k((b) message.obj, message.arg1);
                    break;
                case 19:
                    d.D.a(message.obj);
                    f0(null);
                    break;
                case 20:
                    p0(message.arg1, message.arg2, (B3.a0) message.obj);
                    break;
                case 21:
                    c1((B3.a0) message.obj);
                    break;
                case 22:
                    e0();
                    break;
                case 23:
                    S0(message.arg1 != 0);
                    break;
                case 24:
                    R0(message.arg1 == 1);
                    break;
                case 25:
                    m();
                    break;
                case 26:
                    s0();
                    break;
                default:
                    return false;
            }
        } catch (B3.b e3) {
            i = 1002;
            iOException = e3;
            H(iOException, i);
        } catch (l1 e4) {
            int i2 = e4.c;
            if (i2 == 1) {
                r3 = e4.a ? 3001 : 3003;
            } else if (i2 == 4) {
                r3 = e4.a ? 3002 : 3004;
            }
            H(e4, r3);
        } catch (w e5) {
            e2 = e5;
            if (e2.j == 1 && (s = this.t.s()) != null) {
                e2 = e2.g(s.f.a);
            }
            if (e2.p && this.P == null) {
                d4.B.k("ExoPlayerImplInternal", "Recoverable renderer error", e2);
                this.P = e2;
                d4.w wVar = this.i;
                wVar.h(wVar.d(25, e2));
            } else {
                w wVar2 = this.P;
                if (wVar2 != null) {
                    wVar2.addSuppressed(e2);
                    e2 = this.P;
                }
                d4.B.e("ExoPlayerImplInternal", "Playback error", e2);
                if (e2.j == 1 && this.t.r() != this.t.s()) {
                    while (this.t.r() != this.t.s()) {
                        this.t.b();
                    }
                    T0 t0 = ((S0) d4.a.e(this.t.r())).f;
                    C.b bVar = t0.a;
                    long j = t0.b;
                    this.y = N(bVar, j, t0.c, j, true, 0);
                }
                l1(true, false);
                this.y = this.y.f(e2);
            }
        } catch (o.a e6) {
            i = e6.a;
            iOException = e6;
            H(iOException, i);
        } catch (b4.p e7) {
            i = e7.a;
            iOException = e7;
            H(iOException, i);
        } catch (IOException e8) {
            i = 2000;
            iOException = e8;
            H(iOException, i);
        } catch (RuntimeException e9) {
            e2 = w.l(e9, ((e9 instanceof IllegalStateException) || (e9 instanceof IllegalArgumentException)) ? 1004 : 1000);
            d4.B.e("ExoPlayerImplInternal", "Playback error", e2);
            l1(true, false);
            this.y = this.y.f(e2);
        }
        Y();
        return true;
    }

    public final void i0() {
        for (S0 r = this.t.r(); r != null; r = r.j()) {
            for (Z3.s sVar : r.o().c) {
                if (sVar != null) {
                    sVar.s();
                }
            }
        }
    }

    public final boolean i1(Q1 q1, C.b bVar) {
        if (bVar.b() || q1.v()) {
            return false;
        }
        q1.s(q1.m(bVar.a, this.m).d, this.l);
        if (!this.l.i()) {
            return false;
        }
        Q1.d dVar = this.l;
        return dVar.j && dVar.g != -9223372036854775807L;
    }

    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void j(B3.z zVar) {
        this.i.d(9, zVar).a();
    }

    public final void j1() {
        this.D = false;
        this.p.g();
        for (C1 c1 : this.a) {
            if (S(c1)) {
                c1.start();
            }
        }
    }

    public final void k(b bVar, int i) {
        this.z.b(1);
        k1 k1Var = this.u;
        if (i == -1) {
            i = k1Var.r();
        }
        J(k1Var.f(i, b.b(bVar), b.c(bVar)), false);
    }

    public void k0() {
        this.i.a(0).a();
    }

    public void k1() {
        this.i.a(6).a();
    }

    public void l(int i, List list, B3.a0 a0Var) {
        this.i.c(18, i, 0, new b(list, a0Var, -1, -9223372036854775807L, null)).a();
    }

    public final void l0() {
        this.z.b(1);
        t0(false, false, false, true);
        this.g.onPrepared();
        d1(this.y.a.v() ? 4 : 2);
        this.u.w(this.h.d());
        this.i.j(2);
    }

    public final void l1(boolean z, boolean z2) {
        t0(z || !this.H, false, true, false);
        this.z.b(z2 ? 1 : 0);
        this.g.e();
        d1(1);
    }

    public final void m() {
        s0();
    }

    public synchronized boolean m0() {
        if (!this.A && this.k.getThread().isAlive()) {
            this.i.j(7);
            t1(new t0(this), this.w);
            return this.A;
        }
        return true;
    }

    public final void m1() {
        this.p.h();
        for (C1 c1 : this.a) {
            if (S(c1)) {
                v(c1);
            }
        }
    }

    public final void n1() {
        S0 l = this.t.l();
        boolean z = this.E || (l != null && l.a.b());
        q1 q1Var = this.y;
        if (z != q1Var.g) {
            this.y = q1Var.b(z);
        }
    }

    public final void o(x1 x1Var) {
        if (x1Var.j()) {
            return;
        }
        try {
            x1Var.g().n(x1Var.i(), x1Var.e());
        } finally {
            x1Var.k(true);
        }
    }

    public final void o0() {
        for (int i = 0; i < this.a.length; i++) {
            this.d[i].g();
            this.a[i].release();
        }
    }

    public final void o1(C.b bVar, B3.i0 i0Var, Z3.D d2) {
        this.g.c(this.y.a, bVar, this.a, i0Var, d2.c);
    }

    public final void p(C1 c1) {
        if (S(c1)) {
            this.p.a(c1);
            v(c1);
            c1.disable();
            this.K--;
        }
    }

    public final void p0(int i, int i2, B3.a0 a0Var) {
        this.z.b(1);
        J(this.u.A(i, i2, a0Var), false);
    }

    public final void p1() {
        if (this.y.a.v() || !this.u.t()) {
            return;
        }
        a0();
        c0();
        d0();
        b0();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q() {
        /*
            Method dump skipped, instructions count: 487
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: O2.v0.q():void");
    }

    public final boolean q0() {
        S0 s = this.t.s();
        Z3.D o = s.o();
        int i = 0;
        boolean z = false;
        while (true) {
            C1[] c1Arr = this.a;
            if (i >= c1Arr.length) {
                return !z;
            }
            C1 c1 = c1Arr[i];
            if (S(c1)) {
                boolean z2 = c1.f() != s.c[i];
                if (!o.c(i) || z2) {
                    if (!c1.p()) {
                        c1.m(z(o.c[i]), s.c[i], s.m(), s.l());
                    } else if (c1.d()) {
                        p(c1);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    public final void q1() {
        S0 r = this.t.r();
        if (r == null) {
            return;
        }
        long m = r.d ? r.a.m() : -9223372036854775807L;
        if (m != -9223372036854775807L) {
            v0(m);
            if (m != this.y.r) {
                q1 q1Var = this.y;
                this.y = N(q1Var.b, m, q1Var.c, m, true, 5);
            }
        } else {
            long i = this.p.i(r != this.t.s());
            this.M = i;
            long y = r.y(i);
            Z(this.y.r, y);
            this.y.o(y);
        }
        this.y.p = this.t.l().i();
        this.y.q = E();
        q1 q1Var2 = this.y;
        if (q1Var2.l && q1Var2.e == 3 && i1(q1Var2.a, q1Var2.b) && this.y.n.a == 1.0f) {
            float a2 = this.v.a(y(), E());
            if (this.p.c().a != a2) {
                O0(this.y.n.d(a2));
                L(this.y.n, this.p.c().a, false, false);
            }
        }
    }

    public final void r(int i, boolean z) {
        C1 c1 = this.a[i];
        if (S(c1)) {
            return;
        }
        S0 s = this.t.s();
        boolean z2 = s == this.t.r();
        Z3.D o = s.o();
        F1 f1 = o.b[i];
        z0[] z3 = z(o.c[i]);
        boolean z4 = g1() && this.y.e == 3;
        boolean z5 = !z && z4;
        this.K++;
        this.c.add(c1);
        c1.k(f1, z3, s.c[i], this.M, z5, z2, s.m(), s.l());
        c1.n(11, new a());
        this.p.d(c1);
        if (z4) {
            c1.start();
        }
    }

    public final void r0() {
        float f2 = this.p.c().a;
        S0 s = this.t.s();
        boolean z = true;
        for (S0 r = this.t.r(); r != null && r.d; r = r.j()) {
            Z3.D v = r.v(f2, this.y.a);
            if (!v.a(r.o())) {
                V0 v0 = this.t;
                if (z) {
                    S0 r2 = v0.r();
                    boolean D = this.t.D(r2);
                    boolean[] zArr = new boolean[this.a.length];
                    long b2 = r2.b(v, this.y.r, D, zArr);
                    q1 q1Var = this.y;
                    boolean z2 = (q1Var.e == 4 || b2 == q1Var.r) ? false : true;
                    q1 q1Var2 = this.y;
                    this.y = N(q1Var2.b, b2, q1Var2.c, q1Var2.d, z2, 5);
                    if (z2) {
                        v0(b2);
                    }
                    boolean[] zArr2 = new boolean[this.a.length];
                    int i = 0;
                    while (true) {
                        C1[] c1Arr = this.a;
                        if (i >= c1Arr.length) {
                            break;
                        }
                        C1 c1 = c1Arr[i];
                        boolean S = S(c1);
                        zArr2[i] = S;
                        B3.Y y = r2.c[i];
                        if (S) {
                            if (y != c1.f()) {
                                p(c1);
                            } else if (zArr[i]) {
                                c1.w(this.M);
                            }
                        }
                        i++;
                    }
                    u(zArr2);
                } else {
                    v0.D(r);
                    if (r.d) {
                        r.a(v, Math.max(r.f.b, r.y(this.M)), false);
                    }
                }
                I(true);
                if (this.y.e != 4) {
                    X();
                    q1();
                    this.i.j(2);
                    return;
                }
                return;
            }
            if (r == s) {
                z = false;
            }
        }
    }

    public final void r1(Q1 q1, C.b bVar, Q1 q12, C.b bVar2, long j, boolean z) {
        if (!i1(q1, bVar)) {
            s1 s1Var = bVar.b() ? s1.e : this.y.n;
            if (this.p.c().equals(s1Var)) {
                return;
            }
            O0(s1Var);
            L(this.y.n, s1Var.a, false, false);
            return;
        }
        q1.s(q1.m(bVar.a, this.m).d, this.l);
        this.v.e((H0.g) d4.k0.j(this.l.l));
        if (j != -9223372036854775807L) {
            this.v.d(A(q1, bVar.a, j));
            return;
        }
        if (!d4.k0.c(!q12.v() ? q12.s(q12.m(bVar2.a, this.m).d, this.l).a : null, this.l.a) || z) {
            this.v.d(-9223372036854775807L);
        }
    }

    public final void s() {
        u(new boolean[this.a.length]);
    }

    public final void s0() {
        r0();
        E0(true);
    }

    public final void s1(float f2) {
        for (S0 r = this.t.r(); r != null; r = r.j()) {
            for (Z3.s sVar : r.o().c) {
                if (sVar != null) {
                    sVar.f(f2);
                }
            }
        }
    }

    public void t(s1 s1Var) {
        this.i.d(16, s1Var).a();
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00a6 A[PHI: r4 r5 r7
      0x00a6: PHI (r4v3 B3.C$b) = (r4v2 B3.C$b), (r4v11 B3.C$b) binds: [B:34:0x0079, B:36:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a6: PHI (r5v2 long) = (r5v1 long), (r5v4 long) binds: [B:34:0x0079, B:36:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a6: PHI (r7v3 long) = (r7v2 long), (r7v5 long) binds: [B:34:0x0079, B:36:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void t0(boolean r31, boolean r32, boolean r33, boolean r34) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: O2.v0.t0(boolean, boolean, boolean, boolean):void");
    }

    public final synchronized void t1(r5.r rVar, long j) {
        long b2 = this.r.b() + j;
        boolean z = false;
        while (!((Boolean) rVar.get()).booleanValue() && j > 0) {
            try {
                this.r.d();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = b2 - this.r.b();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final void u(boolean[] zArr) {
        S0 s = this.t.s();
        Z3.D o = s.o();
        for (int i = 0; i < this.a.length; i++) {
            if (!o.c(i) && this.c.remove(this.a[i])) {
                this.a[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.a.length; i2++) {
            if (o.c(i2)) {
                r(i2, zArr[i2]);
            }
        }
        s.g = true;
    }

    public final void u0() {
        S0 r = this.t.r();
        this.C = r != null && r.f.h && this.B;
    }

    public final void v(C1 c1) {
        if (c1.getState() == 2) {
            c1.stop();
        }
    }

    public final void v0(long j) {
        S0 r = this.t.r();
        long z = r == null ? j + 1000000000000L : r.z(j);
        this.M = z;
        this.p.e(z);
        for (C1 c1 : this.a) {
            if (S(c1)) {
                c1.w(this.M);
            }
        }
        g0();
    }

    public void w(long j) {
        this.Q = j;
    }

    public final s5.y x(Z3.s[] sVarArr) {
        y.a aVar = new y.a();
        boolean z = false;
        for (Z3.s sVar : sVarArr) {
            if (sVar != null) {
                q3.a aVar2 = sVar.c(0).k;
                if (aVar2 == null) {
                    aVar.h(new q3.a(new a.b[0]));
                } else {
                    aVar.h(aVar2);
                    z = true;
                }
            }
        }
        return z ? aVar.k() : s5.y.z();
    }

    public final long y() {
        q1 q1Var = this.y;
        return A(q1Var.a, q1Var.b.a, q1Var.r);
    }

    public final void y0(Q1 q1, Q1 q12) {
        if (q1.v() && q12.v()) {
            return;
        }
        for (int size = this.q.size() - 1; size >= 0; size--) {
            if (!x0((d) this.q.get(size), q1, q12, this.F, this.G, this.l, this.m)) {
                ((d) this.q.get(size)).a.k(false);
                this.q.remove(size);
            }
        }
        Collections.sort(this.q);
    }
}
