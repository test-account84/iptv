package O2;

import O2.E1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class k implements C1, E1 {
    public final int c;
    public F1 e;
    public int f;
    public P2.v0 g;
    public int h;
    public B3.Y i;
    public z0[] j;
    public long k;
    public long l;
    public boolean n;
    public boolean o;
    public E1.a p;
    public final Object a = new Object();
    public final A0 d = new A0();
    public long m = Long.MIN_VALUE;

    public k(int i) {
        this.c = i;
    }

    public final F1 A() {
        return (F1) d4.a.e(this.e);
    }

    public final A0 B() {
        this.d.a();
        return this.d;
    }

    public final int C() {
        return this.f;
    }

    public final P2.v0 D() {
        return (P2.v0) d4.a.e(this.g);
    }

    public final z0[] E() {
        return (z0[]) d4.a.e(this.j);
    }

    public final boolean F() {
        return h() ? this.n : ((B3.Y) d4.a.e(this.i)).e();
    }

    public abstract void G();

    public abstract void I(long j, boolean z);

    public final void K() {
        E1.a aVar;
        synchronized (this.a) {
            aVar = this.p;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final int P(A0 a0, U2.g gVar, int i) {
        int q = ((B3.Y) d4.a.e(this.i)).q(a0, gVar, i);
        if (q == -4) {
            if (gVar.isEndOfStream()) {
                this.m = Long.MIN_VALUE;
                return this.n ? -4 : -3;
            }
            long j = gVar.f + this.k;
            gVar.f = j;
            this.m = Math.max(this.m, j);
        } else if (q == -5) {
            z0 z0Var = (z0) d4.a.e(a0.b);
            if (z0Var.q != Long.MAX_VALUE) {
                a0.b = z0Var.b().k0(z0Var.q + this.k).G();
            }
        }
        return q;
    }

    public final void Q(long j, boolean z) {
        this.n = false;
        this.l = j;
        this.m = j;
        I(j, z);
    }

    public int R(long j) {
        return ((B3.Y) d4.a.e(this.i)).n(j - this.k);
    }

    public final void disable() {
        d4.a.g(this.h == 1);
        this.d.a();
        this.h = 0;
        this.i = null;
        this.j = null;
        this.n = false;
        G();
    }

    public final B3.Y f() {
        return this.i;
    }

    public final void g() {
        synchronized (this.a) {
            this.p = null;
        }
    }

    public final int getState() {
        return this.h;
    }

    public final int getTrackType() {
        return this.c;
    }

    public final boolean h() {
        return this.m == Long.MIN_VALUE;
    }

    public final void i(E1.a aVar) {
        synchronized (this.a) {
            this.p = aVar;
        }
    }

    public final void j() {
        this.n = true;
    }

    public final void k(F1 f1, z0[] z0VarArr, B3.Y y, long j, boolean z, boolean z2, long j2, long j3) {
        d4.a.g(this.h == 0);
        this.e = f1;
        this.h = 1;
        H(z, z2);
        m(z0VarArr, y, j2, j3);
        Q(j, z);
    }

    public final void l(int i, P2.v0 v0Var) {
        this.f = i;
        this.g = v0Var;
    }

    public final void m(z0[] z0VarArr, B3.Y y, long j, long j2) {
        d4.a.g(!this.n);
        this.i = y;
        if (this.m == Long.MIN_VALUE) {
            this.m = j;
        }
        this.j = z0VarArr;
        this.k = j2;
        O(z0VarArr, j, j2);
    }

    public final void o() {
        ((B3.Y) d4.a.e(this.i)).a();
    }

    public final boolean p() {
        return this.n;
    }

    public final void release() {
        d4.a.g(this.h == 0);
        J();
    }

    public final void reset() {
        d4.a.g(this.h == 0);
        this.d.a();
        L();
    }

    public /* synthetic */ void s(float f, float f2) {
        B1.a(this, f, f2);
    }

    public final void start() {
        d4.a.g(this.h == 1);
        this.h = 2;
        M();
    }

    public final void stop() {
        d4.a.g(this.h == 2);
        this.h = 1;
        N();
    }

    public int t() {
        return 0;
    }

    public final long v() {
        return this.m;
    }

    public final void w(long j) {
        Q(j, false);
    }

    public d4.D x() {
        return null;
    }

    public final w y(Throwable th, z0 z0Var, int i) {
        return z(th, z0Var, false, i);
    }

    public final w z(Throwable th, z0 z0Var, boolean z, int i) {
        int i2;
        if (z0Var == null || this.o) {
            i2 = 4;
        } else {
            this.o = true;
            try {
                int f = D1.f(a(z0Var));
                this.o = false;
                i2 = f;
            } catch (w unused) {
                this.o = false;
            } catch (Throwable th2) {
                this.o = false;
                throw th2;
            }
        }
        return w.i(th, getName(), C(), z0Var, i2, z, i);
    }

    public void J() {
    }

    public void L() {
    }

    public void M() {
    }

    public void N() {
    }

    public final E1 q() {
        return this;
    }

    public void H(boolean z, boolean z2) {
    }

    public void n(int i, Object obj) {
    }

    public void O(z0[] z0VarArr, long j, long j2) {
    }
}
