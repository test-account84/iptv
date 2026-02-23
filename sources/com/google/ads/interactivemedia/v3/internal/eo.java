package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class eo implements hh, hi {
    private final int a;
    private hj c;
    private int d;
    private iw e;
    private int f;
    private uf g;
    private s[] h;
    private long i;
    private boolean k;
    private boolean l;
    private final go b = new go();
    private long j = Long.MIN_VALUE;

    public eo(int i) {
        this.a = i;
    }

    private final void Q(long j, boolean z) throws ev {
        this.k = false;
        this.j = j;
        v(j, z);
    }

    public final void A() {
        af.w(this.f == 0);
        this.b.a();
        w();
    }

    public final void B(long j) throws ev {
        Q(j, false);
    }

    public final void C() {
        this.k = true;
    }

    public /* synthetic */ void D(float f, float f2) {
    }

    public final void E() throws ev {
        af.w(this.f == 1);
        this.f = 2;
        x();
    }

    public final void F() {
        af.w(this.f == 2);
        this.f = 1;
        y();
    }

    public final boolean G() {
        return this.j == Long.MIN_VALUE;
    }

    public final boolean H() {
        return this.k;
    }

    public final boolean I() {
        if (G()) {
            return this.k;
        }
        uf ufVar = this.g;
        af.s(ufVar);
        return ufVar.g();
    }

    public final s[] J() {
        return (s[]) af.s(this.h);
    }

    public void K(long j, long j2) throws ev {
        throw null;
    }

    public final int b() {
        return this.a;
    }

    public final int bg() {
        return this.f;
    }

    public final int bh(go goVar, ef efVar, int i) {
        uf ufVar = this.g;
        af.s(ufVar);
        int a = ufVar.a(goVar, efVar, i);
        if (a == -4) {
            if (efVar.g()) {
                this.j = Long.MIN_VALUE;
                return this.k ? -4 : -3;
            }
            long j = efVar.d + this.i;
            efVar.d = j;
            this.j = Math.max(this.j, j);
        } else if (a == -5) {
            s sVar = goVar.b;
            af.s(sVar);
            long j2 = sVar.p;
            if (j2 != Long.MAX_VALUE) {
                r b = sVar.b();
                b.ai(j2 + this.i);
                goVar.b = b.v();
                return -5;
            }
        }
        return a;
    }

    public final ev bi(Throwable th, s sVar, int i) {
        return h(th, sVar, false, i);
    }

    public final int d(long j) {
        uf ufVar = this.g;
        af.s(ufVar);
        return ufVar.b(j - this.i);
    }

    public int e() throws ev {
        return 0;
    }

    public final long f() {
        return this.j;
    }

    public final ev h(Throwable th, s sVar, boolean z, int i) {
        int i2;
        if (sVar == null || this.l) {
            i2 = 4;
        } else {
            this.l = true;
            try {
                int f = fz.f(P(sVar));
                this.l = false;
                i2 = f;
            } catch (ev unused) {
                this.l = false;
            } catch (Throwable th2) {
                this.l = false;
                throw th2;
            }
        }
        return ev.b(th, L(), this.d, sVar, i2, z, i);
    }

    public final go i() {
        this.b.a();
        return this.b;
    }

    public gp j() {
        return null;
    }

    public final hi k() {
        return this;
    }

    public final hj l() {
        hj hjVar = this.c;
        af.s(hjVar);
        return hjVar;
    }

    public final iw m() {
        iw iwVar = this.e;
        af.s(iwVar);
        return iwVar;
    }

    public final uf n() {
        return this.g;
    }

    public final void o() {
        af.w(this.f == 1);
        this.b.a();
        this.f = 0;
        this.g = null;
        this.h = null;
        this.k = false;
        t();
    }

    public final void p(hj hjVar, s[] sVarArr, uf ufVar, long j, boolean z, boolean z2, long j2, long j3) throws ev {
        af.w(this.f == 0);
        this.c = hjVar;
        this.f = 1;
        u(z, z2);
        z(sVarArr, ufVar, j2, j3);
        Q(j, z);
    }

    public void q(int i, Object obj) throws ev {
    }

    public final void r(int i, iw iwVar) {
        this.d = i;
        this.e = iwVar;
    }

    public final void s() throws IOException {
        uf ufVar = this.g;
        af.s(ufVar);
        ufVar.d();
    }

    public void t() {
        throw null;
    }

    public void u(boolean z, boolean z2) throws ev {
    }

    public void v(long j, boolean z) throws ev {
        throw null;
    }

    public void w() {
    }

    public void x() throws ev {
    }

    public void y() {
    }

    public final void z(s[] sVarArr, uf ufVar, long j, long j2) throws ev {
        af.w(!this.k);
        this.g = ufVar;
        if (this.j == Long.MIN_VALUE) {
            this.j = j;
        }
        this.h = sVarArr;
        this.i = j2;
        K(j, j2);
    }
}
