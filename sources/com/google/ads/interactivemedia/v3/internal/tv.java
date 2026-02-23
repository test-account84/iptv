package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class tv implements td, zk, ww, wz, ud {
    private static final Map a;
    private static final s c;
    private boolean B;
    private boolean C;
    private int D;
    private boolean E;
    private long F;
    private boolean H;
    private int I;
    private boolean J;
    private boolean K;
    private final wr L;
    private final ws N;
    private final Uri d;
    private final cy e;
    private final nt f;
    private final tj g;
    private final nn h;
    private final tr i;
    private final long j;
    private final tl l;
    private tc p;
    private aao q;
    private boolean t;
    private boolean u;
    private boolean v;
    private tu w;
    private aab x;
    private boolean z;
    private final xc k = new xc("ProgressiveMediaPeriod");
    private final agp M = new agp();
    private final Runnable m = new tm(this);
    private final Runnable n = new tn(this);
    private final Handler o = cq.A();
    private tt[] s = new tt[0];
    private ue[] r = new ue[0];
    private long G = -9223372036854775807L;
    private long y = -9223372036854775807L;
    private int A = 1;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        a = Collections.unmodifiableMap(hashMap);
        r rVar = new r();
        rVar.S("icy");
        rVar.ae("application/x-icy");
        c = rVar.v();
    }

    public tv(Uri uri, cy cyVar, tl tlVar, nt ntVar, nn nnVar, ws wsVar, tj tjVar, tr trVar, wr wrVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.d = uri;
        this.e = cyVar;
        this.f = ntVar;
        this.h = nnVar;
        this.N = wsVar;
        this.g = tjVar;
        this.i = trVar;
        this.L = wrVar;
        this.j = i;
        this.l = tlVar;
    }

    public static /* bridge */ /* synthetic */ void A(tv tvVar, aao aaoVar) {
        tvVar.q = aaoVar;
    }

    public static /* bridge */ /* synthetic */ void B(tv tvVar) {
        tvVar.o.post(new to(tvVar));
    }

    public static /* bridge */ /* synthetic */ long K(tv tvVar) {
        return tvVar.M(true);
    }

    private final int L() {
        int i = 0;
        for (ue ueVar : this.r) {
            i += ueVar.m();
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long M(boolean r6) {
        /*
            r5 = this;
            r0 = -9223372036854775808
            r2 = 0
        L3:
            com.google.ads.interactivemedia.v3.internal.ue[] r3 = r5.r
            int r3 = r3.length
            if (r2 >= r3) goto L24
            if (r6 != 0) goto L15
            com.google.ads.interactivemedia.v3.internal.tu r3 = r5.w
            com.google.ads.interactivemedia.v3.internal.af.s(r3)
            boolean[] r3 = r3.c
            boolean r3 = r3[r2]
            if (r3 == 0) goto L21
        L15:
            com.google.ads.interactivemedia.v3.internal.ue[] r3 = r5.r
            r3 = r3[r2]
            long r3 = r3.r()
            long r0 = java.lang.Math.max(r0, r3)
        L21:
            int r2 = r2 + 1
            goto L3
        L24:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.tv.M(boolean):long");
    }

    private final aae N(tt ttVar) {
        int length = this.r.length;
        for (int i = 0; i < length; i++) {
            if (ttVar.equals(this.s[i])) {
                return this.r[i];
            }
        }
        ue N = ue.N(this.L, this.f, this.h);
        N.F(this);
        int i2 = length + 1;
        tt[] ttVarArr = (tt[]) Arrays.copyOf(this.s, i2);
        ttVarArr[length] = ttVar;
        this.s = (tt[]) cq.af(ttVarArr);
        ue[] ueVarArr = (ue[]) Arrays.copyOf(this.r, i2);
        ueVarArr[length] = N;
        this.r = (ue[]) cq.af(ueVarArr);
        return N;
    }

    private final void O() {
        af.w(this.u);
        af.s(this.w);
        af.s(this.x);
    }

    private final void P() {
        int i;
        if (this.K || this.u || !this.t || this.x == null) {
            return;
        }
        for (ue ueVar : this.r) {
            if (ueVar.t() == null) {
                return;
            }
        }
        this.M.g();
        int length = this.r.length;
        bf[] bfVarArr = new bf[length];
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            s t = this.r[i2].t();
            af.s(t);
            String str = t.l;
            boolean m = ar.m(str);
            boolean z = m || ar.q(str);
            zArr[i2] = z;
            this.v = z | this.v;
            aao aaoVar = this.q;
            if (aaoVar != null) {
                if (m || this.s[i2].b) {
                    ao aoVar = t.j;
                    ao aoVar2 = aoVar == null ? new ao(aaoVar) : aoVar.c(aaoVar);
                    r b = t.b();
                    b.X(aoVar2);
                    t = b.v();
                }
                if (m && t.f == -1 && t.g == -1 && (i = aaoVar.a) != -1) {
                    r b2 = t.b();
                    b2.G(i);
                    t = b2.v();
                }
            }
            bfVarArr[i2] = new bf(Integer.toString(i2), t.c(this.f.b(t)));
        }
        this.w = new tu(new um(bfVarArr), zArr);
        this.u = true;
        tc tcVar = this.p;
        af.s(tcVar);
        tcVar.bl(this);
    }

    private final void Q(int i) {
        O();
        tu tuVar = this.w;
        boolean[] zArr = tuVar.d;
        if (zArr[i]) {
            return;
        }
        s b = tuVar.a.b(i).b(0);
        this.g.o(ar.b(b.l), b, 0, this.F);
        zArr[i] = true;
    }

    private final void R(int i) {
        O();
        boolean[] zArr = this.w.b;
        if (this.H && zArr[i]) {
            if (this.r[i].K(false)) {
                return;
            }
            this.G = 0L;
            this.H = false;
            this.C = true;
            this.F = 0L;
            this.I = 0;
            for (ue ueVar : this.r) {
                ueVar.B();
            }
            tc tcVar = this.p;
            af.s(tcVar);
            tcVar.g(this);
        }
    }

    private final void S() {
        tq tqVar = new tq(this, this.d, this.e, this.l, this, this.M, null);
        if (this.u) {
            af.w(T());
            long j = this.y;
            if (j != -9223372036854775807L && this.G > j) {
                this.J = true;
                this.G = -9223372036854775807L;
                return;
            }
            aab aabVar = this.x;
            af.s(aabVar);
            tq.h(tqVar, aabVar.g(this.G).a.c, this.G);
            for (ue ueVar : this.r) {
                ueVar.E(this.G);
            }
            this.G = -9223372036854775807L;
        }
        this.I = L();
        this.k.b(tqVar, this, ws.c(this.A));
        dc f = tq.f(tqVar);
        tj tjVar = this.g;
        tq.c(tqVar);
        tjVar.s(new sw(f), 1, -1, null, 0, tq.d(tqVar), this.y);
    }

    private final boolean T() {
        return this.G != -9223372036854775807L;
    }

    private final boolean U() {
        return this.C || T();
    }

    public static /* bridge */ /* synthetic */ long m(tv tvVar) {
        return tvVar.j;
    }

    public static /* bridge */ /* synthetic */ Handler r(tv tvVar) {
        return tvVar.o;
    }

    public static /* bridge */ /* synthetic */ s s() {
        return c;
    }

    public static /* bridge */ /* synthetic */ aao v(tv tvVar) {
        return tvVar.q;
    }

    public static /* bridge */ /* synthetic */ Runnable w(tv tvVar) {
        return tvVar.n;
    }

    public static /* bridge */ /* synthetic */ Map y() {
        return a;
    }

    public static /* synthetic */ void z(tv tvVar) {
        tvVar.P();
    }

    public final /* synthetic */ void C() {
        if (this.K) {
            return;
        }
        tc tcVar = this.p;
        af.s(tcVar);
        tcVar.g(this);
    }

    public final /* synthetic */ void D() {
        this.E = true;
    }

    public final /* synthetic */ void E(aab aabVar) {
        this.x = this.q == null ? aabVar : new aaa(-9223372036854775807L);
        this.y = aabVar.e();
        boolean z = false;
        if (!this.E && aabVar.e() == -9223372036854775807L) {
            z = true;
        }
        this.z = z;
        this.A = true == z ? 7 : 1;
        this.i.b(this.y, aabVar.h(), this.z);
        if (this.u) {
            return;
        }
        P();
    }

    public final void F() throws IOException {
        this.k.i(ws.c(this.A));
    }

    public final void G(int i) throws IOException {
        this.r[i].y();
        F();
    }

    public final void H() {
        this.o.post(this.m);
    }

    public final void I() {
        if (this.u) {
            for (ue ueVar : this.r) {
                ueVar.z();
            }
        }
        this.k.k(this);
        this.o.removeCallbacksAndMessages((Object) null);
        this.p = null;
        this.K = true;
    }

    public final boolean J(int i) {
        return !U() && this.r[i].K(this.J);
    }

    public final long a(long j, hl hlVar) {
        O();
        if (!this.x.h()) {
            return 0L;
        }
        zz g = this.x.g(j);
        return hlVar.a(j, g.a.b, g.b.b);
    }

    public final /* bridge */ /* synthetic */ void bj(wy wyVar, long j, long j2) {
        aab aabVar;
        tq tqVar = (tq) wyVar;
        if (this.y == -9223372036854775807L && (aabVar = this.x) != null) {
            boolean h = aabVar.h();
            long M = M(true);
            long j3 = M == Long.MIN_VALUE ? 0L : M + 10000;
            this.y = j3;
            this.i.b(j3, h, this.z);
        }
        tq.g(tqVar);
        tq.c(tqVar);
        tq.f(tqVar);
        sw swVar = new sw();
        tq.c(tqVar);
        this.g.q(swVar, 1, -1, null, 0, tq.d(tqVar), this.y);
        this.J = true;
        tc tcVar = this.p;
        af.s(tcVar);
        tcVar.g(this);
    }

    public final /* bridge */ /* synthetic */ wv bk(wy wyVar, long j, long j2, IOException iOException, int i) {
        wv n;
        aab aabVar;
        tq tqVar = (tq) wyVar;
        tq.g(tqVar);
        tq.c(tqVar);
        tq.f(tqVar);
        sw swVar = new sw();
        tq.d(tqVar);
        int i2 = cq.a;
        long e = ws.e(new bdz(iOException, i));
        if (e == -9223372036854775807L) {
            n = xc.c;
        } else {
            int L = L();
            boolean z = L > this.I;
            if (this.E || !((aabVar = this.x) == null || aabVar.e() == -9223372036854775807L)) {
                this.I = L;
            } else {
                boolean z2 = this.u;
                if (!z2 || U()) {
                    this.C = z2;
                    this.F = 0L;
                    this.I = 0;
                    for (ue ueVar : this.r) {
                        ueVar.B();
                    }
                    tq.h(tqVar, 0L, 0L);
                } else {
                    this.H = true;
                    n = xc.b;
                }
            }
            n = xc.n(z, e);
        }
        wv wvVar = n;
        boolean z3 = !wvVar.a();
        this.g.r(swVar, 1, -1, null, 0, tq.d(tqVar), this.y, iOException, z3);
        if (z3) {
            tq.c(tqVar);
        }
        return wvVar;
    }

    public final void bm() throws IOException {
        F();
        if (this.J && !this.u) {
            throw as.a("Loading finished before preparation is complete.", null);
        }
    }

    public final /* bridge */ /* synthetic */ void bn(wy wyVar, long j, long j2, boolean z) {
        tq tqVar = (tq) wyVar;
        tq.g(tqVar);
        tq.c(tqVar);
        tq.f(tqVar);
        sw swVar = new sw();
        tq.c(tqVar);
        this.g.p(swVar, 1, -1, null, 0, tq.d(tqVar), this.y);
        if (z) {
            return;
        }
        for (ue ueVar : this.r) {
            ueVar.B();
        }
        if (this.D > 0) {
            tc tcVar = this.p;
            af.s(tcVar);
            tcVar.g(this);
        }
    }

    public final long bo() {
        long j;
        O();
        if (this.J || this.D == 0) {
            return Long.MIN_VALUE;
        }
        if (T()) {
            return this.G;
        }
        if (this.v) {
            int length = this.r.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                tu tuVar = this.w;
                if (tuVar.b[i] && tuVar.c[i] && !this.r[i].J()) {
                    j = Math.min(j, this.r[i].r());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = M(false);
        }
        return j == Long.MIN_VALUE ? this.F : j;
    }

    public final long c() {
        return bo();
    }

    public final long d() {
        if (!this.C) {
            return -9223372036854775807L;
        }
        if (!this.J && L() <= this.I) {
            return -9223372036854775807L;
        }
        this.C = false;
        return this.F;
    }

    public final long e(long j) {
        int i;
        O();
        boolean[] zArr = this.w.b;
        if (true != this.x.h()) {
            j = 0;
        }
        int i2 = 0;
        this.C = false;
        this.F = j;
        if (T()) {
            this.G = j;
            return j;
        }
        if (this.A != 7) {
            int length = this.r.length;
            while (i < length) {
                i = (this.r[i].M(j, false) || (!zArr[i] && this.v)) ? i + 1 : 0;
            }
            return j;
        }
        this.H = false;
        this.G = j;
        this.J = false;
        xc xcVar = this.k;
        if (xcVar.m()) {
            ue[] ueVarArr = this.r;
            int length2 = ueVarArr.length;
            while (i2 < length2) {
                ueVarArr[i2].u();
                i2++;
            }
            this.k.g();
        } else {
            xcVar.h();
            ue[] ueVarArr2 = this.r;
            int length3 = ueVarArr2.length;
            while (i2 < length3) {
                ueVarArr2[i2].B();
                i2++;
            }
        }
        return j;
    }

    public final long f(we[] weVarArr, boolean[] zArr, uf[] ufVarArr, boolean[] zArr2, long j) {
        boolean z;
        we weVar;
        O();
        tu tuVar = this.w;
        um umVar = tuVar.a;
        boolean[] zArr3 = tuVar.c;
        int i = this.D;
        int i2 = 0;
        for (int i3 = 0; i3 < weVarArr.length; i3++) {
            uf ufVar = ufVarArr[i3];
            if (ufVar != null && (weVarArr[i3] == null || !zArr[i3])) {
                int c2 = ts.c((ts) ufVar);
                af.w(zArr3[c2]);
                this.D--;
                zArr3[c2] = false;
                ufVarArr[i3] = null;
            }
        }
        if (this.B) {
            z = i == 0;
        } else if (j == 0) {
            j = 0;
        }
        for (int i4 = 0; i4 < weVarArr.length; i4++) {
            if (ufVarArr[i4] == null && (weVar = weVarArr[i4]) != null) {
                af.w(weVar.n() == 1);
                af.w(weVar.j(0) == 0);
                int a2 = umVar.a(weVar.q());
                af.w(!zArr3[a2]);
                this.D++;
                zArr3[a2] = true;
                ufVarArr[i4] = new ts(this, a2);
                zArr2[i4] = true;
                if (!z) {
                    ue ueVar = this.r[a2];
                    z = (ueVar.M(j, true) || ueVar.k() == 0) ? false : true;
                }
            }
        }
        if (this.D == 0) {
            this.H = false;
            this.C = false;
            if (this.k.m()) {
                ue[] ueVarArr = this.r;
                int length = ueVarArr.length;
                while (i2 < length) {
                    ueVarArr[i2].u();
                    i2++;
                }
                this.k.g();
            } else {
                ue[] ueVarArr2 = this.r;
                int length2 = ueVarArr2.length;
                while (i2 < length2) {
                    ueVarArr2[i2].B();
                    i2++;
                }
            }
        } else if (z) {
            j = e(j);
            while (i2 < ufVarArr.length) {
                if (ufVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.B = true;
        return j;
    }

    public final int g(int i, go goVar, ef efVar, int i2) {
        if (U()) {
            return -3;
        }
        Q(i);
        int o = this.r[i].o(goVar, efVar, i2, this.J);
        if (o == -3) {
            R(i);
        }
        return o;
    }

    public final um h() {
        O();
        return this.w.a;
    }

    public final aae i(int i, int i2) {
        return N(new tt(i, false));
    }

    public final int j(int i, long j) {
        if (U()) {
            return 0;
        }
        Q(i);
        ue ueVar = this.r[i];
        int l = ueVar.l(j, this.J);
        ueVar.G(l);
        if (l != 0) {
            return l;
        }
        R(i);
        return 0;
    }

    public final void k(tc tcVar, long j) {
        this.p = tcVar;
        this.M.f();
        S();
    }

    public final void l(long j) {
    }

    public final void n() {
        this.t = true;
        this.o.post(this.m);
    }

    public final boolean o(long j) {
        if (this.J || this.k.l() || this.H) {
            return false;
        }
        if (this.u && this.D == 0) {
            return false;
        }
        boolean f = this.M.f();
        if (this.k.m()) {
            return f;
        }
        S();
        return true;
    }

    public final boolean p() {
        return this.k.m() && this.M.e();
    }

    public final void q(long j) {
        O();
        if (T()) {
            return;
        }
        boolean[] zArr = this.w.c;
        int length = this.r.length;
        for (int i = 0; i < length; i++) {
            this.r[i].P(j, zArr[i]);
        }
    }

    public final void t() {
        for (ue ueVar : this.r) {
            ueVar.A();
        }
        this.l.e();
    }

    public final aae u() {
        return N(new tt(0, true));
    }

    public final void x(aab aabVar) {
        this.o.post(new tp(this, aabVar));
    }
}
