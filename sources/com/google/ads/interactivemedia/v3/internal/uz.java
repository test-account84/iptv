package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class uz implements uf, uh, ww, wz {
    public final int a;
    boolean b;
    private final int[] c;
    private final s[] d;
    private final boolean[] e;
    private final va f;
    private final ug g;
    private final tj h;
    private final xc i;
    private final uw j;
    private final ArrayList k;
    private final List l;
    private final ue m;
    private final ue[] n;
    private uu o;
    private s p;
    private uy q;
    private long r;
    private long s;
    private int t;
    private up u;
    private final zo v;
    private final ws w;

    public uz(int i, int[] iArr, s[] sVarArr, va vaVar, ug ugVar, wr wrVar, long j, nt ntVar, nn nnVar, ws wsVar, tj tjVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.a = i;
        int i2 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.c = iArr;
        this.d = sVarArr == null ? new s[0] : sVarArr;
        this.f = vaVar;
        this.g = ugVar;
        this.h = tjVar;
        this.w = wsVar;
        this.i = new xc("ChunkSampleStream");
        this.j = new uw();
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        this.l = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.n = new ue[length];
        this.e = new boolean[length];
        int i3 = length + 1;
        int[] iArr2 = new int[i3];
        ue[] ueVarArr = new ue[i3];
        ue N = ue.N(wrVar, ntVar, nnVar);
        this.m = N;
        iArr2[0] = i;
        ueVarArr[0] = N;
        while (i2 < length) {
            ue O = ue.O(wrVar);
            this.n[i2] = O;
            int i4 = i2 + 1;
            ueVarArr[i4] = O;
            iArr2[i4] = this.c[i2];
            i2 = i4;
        }
        this.v = new zo(iArr2, ueVarArr);
        this.r = j;
        this.s = j;
    }

    private final boolean A(int i) {
        up upVar = (up) this.k.get(i);
        if (this.m.k() > upVar.a(0)) {
            return true;
        }
        int i2 = 0;
        while (true) {
            ue[] ueVarArr = this.n;
            if (i2 >= ueVarArr.length) {
                return false;
            }
            int i3 = i2 + 1;
            if (ueVarArr[i2].k() > upVar.a(i3)) {
                return true;
            }
            i2 = i3;
        }
    }

    public static /* bridge */ /* synthetic */ long e(uz uzVar) {
        return uzVar.s;
    }

    public static /* bridge */ /* synthetic */ tj h(uz uzVar) {
        return uzVar.h;
    }

    public static /* bridge */ /* synthetic */ int[] q(uz uzVar) {
        return uzVar.c;
    }

    public static /* bridge */ /* synthetic */ s[] r(uz uzVar) {
        return uzVar.d;
    }

    public static /* bridge */ /* synthetic */ boolean[] s(uz uzVar) {
        return uzVar.e;
    }

    private final int v(int i, int i2) {
        do {
            i2++;
            if (i2 >= this.k.size()) {
                return this.k.size() - 1;
            }
        } while (((up) this.k.get(i2)).a(0) <= i);
        return i2 - 1;
    }

    private final up w(int i) {
        up upVar = (up) this.k.get(i);
        ArrayList arrayList = this.k;
        cq.T(arrayList, i, arrayList.size());
        this.t = Math.max(this.t, this.k.size());
        int i2 = 0;
        this.m.w(upVar.a(0));
        while (true) {
            ue[] ueVarArr = this.n;
            if (i2 >= ueVarArr.length) {
                return upVar;
            }
            int i3 = i2 + 1;
            ueVarArr[i2].w(upVar.a(i3));
            i2 = i3;
        }
    }

    private final up x() {
        return (up) this.k.get(r0.size() - 1);
    }

    private final void y() {
        int v = v(this.m.k(), this.t - 1);
        while (true) {
            int i = this.t;
            if (i > v) {
                return;
            }
            this.t = i + 1;
            up upVar = (up) this.k.get(i);
            s sVar = upVar.i;
            if (!sVar.equals(this.p)) {
                this.h.o(this.a, sVar, upVar.j, upVar.l);
            }
            this.p = sVar;
        }
    }

    private final void z() {
        this.m.B();
        for (ue ueVar : this.n) {
            ueVar.B();
        }
    }

    public final int a(go goVar, ef efVar, int i) {
        if (n()) {
            return -3;
        }
        y();
        return this.m.o(goVar, efVar, i, this.b);
    }

    public final int b(long j) {
        if (n()) {
            return 0;
        }
        int l = this.m.l(j, this.b);
        this.m.G(l);
        y();
        return l;
    }

    public final /* bridge */ /* synthetic */ void bj(wy wyVar, long j, long j2) {
        uu uuVar = (uu) wyVar;
        this.o = null;
        this.f.g(uuVar);
        long j3 = uuVar.f;
        uuVar.l();
        uuVar.m();
        uuVar.k();
        this.h.q(new sw(), uuVar.h, this.a, uuVar.i, uuVar.j, uuVar.l, uuVar.m);
        this.g.g(this);
    }

    public final /* bridge */ /* synthetic */ wv bk(wy wyVar, long j, long j2, IOException iOException, int i) {
        wv wvVar;
        uu uuVar = (uu) wyVar;
        long k = uuVar.k();
        boolean z = uuVar instanceof up;
        int size = this.k.size() - 1;
        boolean z2 = (k != 0 && z && A(size)) ? false : true;
        uuVar.l();
        uuVar.m();
        sw swVar = new sw();
        int i2 = cq.a;
        bdz bdzVar = new bdz(iOException, i);
        if (!this.f.j(uuVar, z2, bdzVar, this.w)) {
            wvVar = null;
        } else if (z2) {
            wvVar = xc.b;
            if (z) {
                af.w(w(size) == uuVar);
                if (this.k.isEmpty()) {
                    this.r = this.s;
                }
            }
        } else {
            cd.e("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            wvVar = null;
        }
        if (wvVar == null) {
            long e = ws.e(bdzVar);
            wvVar = e != -9223372036854775807L ? xc.n(false, e) : xc.c;
        }
        boolean z3 = !wvVar.a();
        this.h.r(swVar, uuVar.h, this.a, uuVar.i, uuVar.j, uuVar.l, uuVar.m, iOException, z3);
        if (z3) {
            this.o = null;
            this.g.g(this);
        }
        return wvVar;
    }

    public final /* bridge */ /* synthetic */ void bn(wy wyVar, long j, long j2, boolean z) {
        uu uuVar = (uu) wyVar;
        this.o = null;
        this.u = null;
        long j3 = uuVar.f;
        uuVar.l();
        uuVar.m();
        uuVar.k();
        this.h.p(new sw(), uuVar.h, this.a, uuVar.i, uuVar.j, uuVar.l, uuVar.m);
        if (z) {
            return;
        }
        if (n()) {
            z();
        } else if (uuVar instanceof up) {
            w(this.k.size() - 1);
            if (this.k.isEmpty()) {
                this.r = this.s;
            }
        }
        this.g.g(this);
    }

    public final long bo() {
        if (this.b) {
            return Long.MIN_VALUE;
        }
        if (n()) {
            return this.r;
        }
        long j = this.s;
        up x = x();
        if (!x.g()) {
            if (this.k.size() > 1) {
                x = (up) this.k.get(r2.size() - 2);
            } else {
                x = null;
            }
        }
        if (x != null) {
            j = Math.max(j, x.m);
        }
        return Math.max(j, this.m.r());
    }

    public final long c() {
        if (n()) {
            return this.r;
        }
        if (this.b) {
            return Long.MIN_VALUE;
        }
        return x().m;
    }

    public final void d() throws IOException {
        this.i.a();
        this.m.y();
        if (this.i.m()) {
            return;
        }
        this.f.f();
    }

    public final long f(long j, hl hlVar) {
        return this.f.d(j, hlVar);
    }

    public final boolean g() {
        return !n() && this.m.K(this.b);
    }

    public final ux i(long j, int i) {
        for (int i2 = 0; i2 < this.n.length; i2++) {
            if (this.c[i2] == i) {
                af.w(!this.e[i2]);
                this.e[i2] = true;
                this.n[i2].M(j, true);
                return new ux(this, this, this.n[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public final va j() {
        return this.f;
    }

    public final void k(uy uyVar) {
        this.q = uyVar;
        this.m.z();
        for (ue ueVar : this.n) {
            ueVar.z();
        }
        this.i.k(this);
    }

    public final void l(long j) {
        xc xcVar = this.i;
        if (xcVar.l() || n()) {
            return;
        }
        if (xcVar.m()) {
            uu uuVar = this.o;
            af.s(uuVar);
            if ((uuVar instanceof up) && A(this.k.size() - 1)) {
                return;
            }
            this.f.i(j, uuVar, this.l);
            return;
        }
        int c = this.f.c(j, this.l);
        if (c < this.k.size()) {
            af.w(!this.i.m());
            int size = this.k.size();
            while (true) {
                if (c >= size) {
                    c = -1;
                    break;
                } else if (!A(c)) {
                    break;
                } else {
                    c++;
                }
            }
            if (c == -1) {
                return;
            }
            long j2 = x().m;
            up w = w(c);
            if (this.k.isEmpty()) {
                this.r = this.s;
            }
            this.b = false;
            this.h.n(this.a, w.l, j2);
        }
    }

    public final void m(long j) {
        up upVar;
        boolean M;
        this.s = j;
        if (n()) {
            this.r = j;
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            upVar = null;
            if (i2 >= this.k.size()) {
                break;
            }
            up upVar2 = (up) this.k.get(i2);
            long j2 = upVar2.l;
            if (j2 == j && upVar2.a == -9223372036854775807L) {
                upVar = upVar2;
                break;
            } else if (j2 > j) {
                break;
            } else {
                i2++;
            }
        }
        ue ueVar = this.m;
        if (upVar != null) {
            M = ueVar.L(upVar.a(0));
        } else {
            M = ueVar.M(j, j < c());
        }
        if (M) {
            this.t = v(this.m.k(), 0);
            ue[] ueVarArr = this.n;
            int length = ueVarArr.length;
            while (i < length) {
                ueVarArr[i].M(j, true);
                i++;
            }
            return;
        }
        this.r = j;
        this.b = false;
        this.k.clear();
        this.t = 0;
        xc xcVar = this.i;
        if (!xcVar.m()) {
            xcVar.h();
            z();
            return;
        }
        this.m.u();
        ue[] ueVarArr2 = this.n;
        int length2 = ueVarArr2.length;
        while (i < length2) {
            ueVarArr2[i].u();
            i++;
        }
        this.i.g();
    }

    public final boolean n() {
        return this.r != -9223372036854775807L;
    }

    public final boolean o(long j) {
        List list;
        long j2;
        if (!this.b) {
            xc xcVar = this.i;
            if (!xcVar.m() && !xcVar.l()) {
                boolean n = n();
                if (n) {
                    list = Collections.emptyList();
                    j2 = this.r;
                } else {
                    list = this.l;
                    j2 = x().m;
                }
                this.f.e(j, j2, list, this.j);
                uw uwVar = this.j;
                boolean z = uwVar.b;
                uu uuVar = uwVar.a;
                uwVar.a = null;
                uwVar.b = false;
                if (z) {
                    this.r = -9223372036854775807L;
                    this.b = true;
                    return true;
                }
                if (uuVar == null) {
                    return false;
                }
                this.o = uuVar;
                if (uuVar instanceof up) {
                    up upVar = (up) uuVar;
                    if (n) {
                        long j3 = upVar.l;
                        long j4 = this.r;
                        if (j3 != j4) {
                            this.m.E(j4);
                            for (ue ueVar : this.n) {
                                ueVar.E(this.r);
                            }
                        }
                        this.r = -9223372036854775807L;
                    }
                    upVar.d(this.v);
                    this.k.add(upVar);
                } else if (uuVar instanceof vd) {
                    ((vd) uuVar).a(this.v);
                }
                this.i.b(uuVar, this, ws.c(uuVar.h));
                this.h.s(new sw(uuVar.g), uuVar.h, this.a, uuVar.i, uuVar.j, uuVar.l, uuVar.m);
                return true;
            }
        }
        return false;
    }

    public final boolean p() {
        return this.i.m();
    }

    public final void t() {
        this.m.A();
        for (ue ueVar : this.n) {
            ueVar.A();
        }
        this.f.h();
        uy uyVar = this.q;
        if (uyVar != null) {
            uyVar.j(this);
        }
    }

    public final void u(long j) {
        if (n()) {
            return;
        }
        ue ueVar = this.m;
        int j2 = ueVar.j();
        ueVar.P(j, true);
        ue ueVar2 = this.m;
        int j3 = ueVar2.j();
        if (j3 > j2) {
            long q = ueVar2.q();
            int i = 0;
            while (true) {
                ue[] ueVarArr = this.n;
                if (i >= ueVarArr.length) {
                    break;
                }
                ueVarArr[i].P(q, this.e[i]);
                i++;
            }
        }
        int min = Math.min(v(j3, 0), this.t);
        if (min > 0) {
            cq.T(this.k, 0, min);
            this.t -= min;
        }
    }
}
