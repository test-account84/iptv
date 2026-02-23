package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class pk implements ww, wz, uh, zk, ud {
    private static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{1, 2, 5})));
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private int E;
    private s F;
    private s G;
    private boolean H;
    private um I;
    private Set J;
    private int[] K;
    private int L;
    private boolean M;
    private boolean[] N;
    private boolean[] O;
    private long P;
    private long Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private long V;
    private o W;
    private oy X;
    private final wr Y;
    private final ws Z;
    private final String c;
    private final int d;
    private final pg e;
    private final ow f;
    private final s g;
    private final nt h;
    private final nn i;
    private final tj k;
    private final ArrayList n;
    private final List o;
    private final Runnable p;
    private final Runnable q;
    private final Handler r;
    private final ArrayList s;
    private final Map t;
    private uu u;
    private pj[] v;
    private final Set x;
    private final SparseIntArray y;
    private aae z;
    private final int l = 1;
    private final xc j = new xc("Loader:HlsSampleStreamWrapper");
    private final os m = new os();
    private int[] w = new int[0];

    public pk(String str, int i, pg pgVar, ow owVar, Map map, wr wrVar, long j, s sVar, nt ntVar, nn nnVar, ws wsVar, tj tjVar, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.c = str;
        this.d = i;
        this.e = pgVar;
        this.f = owVar;
        this.t = map;
        this.Y = wrVar;
        this.g = sVar;
        this.h = ntVar;
        this.i = nnVar;
        this.Z = wsVar;
        this.k = tjVar;
        Set set = a;
        this.x = new HashSet(set.size());
        this.y = new SparseIntArray(set.size());
        this.v = new pj[0];
        this.O = new boolean[0];
        this.N = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        this.o = Collections.unmodifiableList(arrayList);
        this.s = new ArrayList();
        this.p = new pe(this);
        this.q = new pf(this);
        this.r = cq.A();
        this.P = j;
        this.Q = j;
    }

    private static int K(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 3;
    }

    private static s L(s sVar, s sVar2, boolean z) {
        String f;
        String str;
        if (sVar == null) {
            return sVar2;
        }
        int b = ar.b(sVar2.l);
        if (cq.h(sVar.i, b) == 1) {
            f = cq.K(sVar.i, b);
            str = ar.g(f);
        } else {
            f = ar.f(sVar.i, sVar2.l);
            str = sVar2.l;
        }
        r b2 = sVar2.b();
        b2.S(sVar.a);
        b2.U(sVar.b);
        b2.V(sVar.c);
        b2.ag(sVar.d);
        b2.ac(sVar.e);
        b2.G(z ? sVar.f : -1);
        b2.Z(z ? sVar.g : -1);
        b2.I(f);
        if (b == 2) {
            b2.aj(sVar.q);
            b2.Q(sVar.r);
            b2.P(sVar.s);
            b = 2;
        }
        if (str != null) {
            b2.ae(str);
        }
        int i = sVar.y;
        if (i != -1 && b == 1) {
            b2.H(i);
        }
        ao aoVar = sVar.j;
        if (aoVar != null) {
            ao aoVar2 = sVar2.j;
            if (aoVar2 != null) {
                aoVar = aoVar2.d(aoVar);
            }
            b2.X(aoVar);
        }
        return b2.v();
    }

    private final oy M() {
        return (oy) this.n.get(r0.size() - 1);
    }

    private final um N(bf[] bfVarArr) {
        for (int i = 0; i < bfVarArr.length; i++) {
            bf bfVar = bfVarArr[i];
            s[] sVarArr = new s[bfVar.a];
            for (int i2 = 0; i2 < bfVar.a; i2++) {
                s b = bfVar.b(i2);
                sVarArr[i2] = b.c(this.h.b(b));
            }
            bfVarArr[i] = new bf(bfVar.b, sVarArr);
        }
        return new um(bfVarArr);
    }

    private static zg O(int i, int i2) {
        cd.e("HlsSampleStreamWrapper", "Unmapped track with id " + i + " of type " + i2);
        return new zg();
    }

    private final void P() {
        af.w(this.D);
        af.s(this.I);
        af.s(this.J);
    }

    private final void Q(int i) {
        int i2;
        af.w(!this.j.m());
        loop0: while (true) {
            if (i >= this.n.size()) {
                i = -1;
                break;
            }
            int i3 = i;
            while (true) {
                if (i3 >= this.n.size()) {
                    oy oyVar = (oy) this.n.get(i);
                    while (i2 < this.v.length) {
                        i2 = this.v[i2].k() <= oyVar.a(i2) ? i2 + 1 : 0;
                    }
                    break loop0;
                } else if (((oy) this.n.get(i3)).d) {
                    break;
                } else {
                    i3++;
                }
            }
            i++;
        }
        if (i == -1) {
            return;
        }
        long j = M().m;
        oy oyVar2 = (oy) this.n.get(i);
        ArrayList arrayList = this.n;
        cq.T(arrayList, i, arrayList.size());
        for (int i4 = 0; i4 < this.v.length; i4++) {
            this.v[i4].w(oyVar2.a(i4));
        }
        if (this.n.isEmpty()) {
            this.Q = this.P;
        } else {
            ((oy) axo.z(this.n)).d();
        }
        this.T = false;
        this.k.n(this.A, oyVar2.l, j);
    }

    private final void R() {
        s sVar;
        if (!this.H && this.K == null && this.C) {
            for (pj pjVar : this.v) {
                if (pjVar.t() == null) {
                    return;
                }
            }
            um umVar = this.I;
            if (umVar != null) {
                int i = umVar.b;
                int[] iArr = new int[i];
                this.K = iArr;
                Arrays.fill(iArr, -1);
                for (int i2 = 0; i2 < i; i2++) {
                    int i3 = 0;
                    while (true) {
                        pj[] pjVarArr = this.v;
                        if (i3 < pjVarArr.length) {
                            s t = pjVarArr[i3].t();
                            af.t(t);
                            s b = this.I.b(i2).b(0);
                            String str = t.l;
                            String str2 = b.l;
                            int b2 = ar.b(str);
                            if (b2 == 3) {
                                if (cq.V(str, str2)) {
                                    if ((!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) || t.D == b.D) {
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                                i3++;
                            } else if (b2 == ar.b(str2)) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    this.K[i2] = i3;
                }
                ArrayList arrayList = this.s;
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((pd) arrayList.get(i4)).c();
                }
                return;
            }
            int length = this.v.length;
            int i5 = 0;
            int i6 = -2;
            int i7 = -1;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                s t2 = this.v[i5].t();
                af.t(t2);
                String str3 = t2.l;
                int i8 = ar.q(str3) ? 2 : ar.m(str3) ? 1 : ar.p(str3) ? 3 : -2;
                if (K(i8) > K(i6)) {
                    i7 = i5;
                    i6 = i8;
                } else if (i8 == i6) {
                    i7 = -1;
                }
                i5++;
            }
            bf d = this.f.d();
            int i9 = d.a;
            this.L = -1;
            this.K = new int[length];
            for (int i10 = 0; i10 < length; i10++) {
                this.K[i10] = i10;
            }
            bf[] bfVarArr = new bf[length];
            int i11 = 0;
            while (i11 < length) {
                s t3 = this.v[i11].t();
                af.t(t3);
                if (i11 == i7) {
                    s[] sVarArr = new s[i9];
                    for (int i12 = 0; i12 < i9; i12++) {
                        s b3 = d.b(i12);
                        if (i6 == 1 && (sVar = this.g) != null) {
                            b3 = b3.d(sVar);
                        }
                        sVarArr[i12] = i9 == 1 ? t3.d(b3) : L(b3, t3, true);
                    }
                    bfVarArr[i11] = new bf(this.c, sVarArr);
                    this.L = i11;
                } else {
                    s sVar2 = null;
                    if (i6 == 2 && ar.m(t3.l)) {
                        sVar2 = this.g;
                    }
                    bfVarArr[i11] = new bf(this.c + ":muxed:" + (i11 < i7 ? i11 : i11 - 1), L(sVar2, t3, false));
                }
                i11++;
            }
            this.I = N(bfVarArr);
            af.w(this.J == null);
            this.J = Collections.emptySet();
            T();
            this.e.n();
        }
    }

    private final void S() {
        for (pj pjVar : this.v) {
            pjVar.C(this.R);
        }
        this.R = false;
    }

    private final void T() {
        this.D = true;
    }

    private final boolean U() {
        return this.Q != -9223372036854775807L;
    }

    public static /* synthetic */ void j(pk pkVar) {
        pkVar.C = true;
        pkVar.R();
    }

    public static /* synthetic */ void k(pk pkVar) {
        pkVar.R();
    }

    public final void A(long j) {
        if (this.V != j) {
            this.V = j;
            for (pj pjVar : this.v) {
                pjVar.D(j);
            }
        }
    }

    public final void B(int i) {
        P();
        af.s(this.K);
        int i2 = this.K[i];
        af.w(this.N[i2]);
        this.N[i2] = false;
    }

    public final boolean C(int i) {
        return !U() && this.v[i].K(this.T);
    }

    public final boolean D() {
        return this.A == 2;
    }

    public final boolean E(long j, boolean z) {
        int i;
        this.P = j;
        if (U()) {
            this.Q = j;
            return true;
        }
        if (this.C && !z) {
            int length = this.v.length;
            while (i < length) {
                i = (this.v[i].M(j, false) || (!this.O[i] && this.M)) ? i + 1 : 0;
            }
            return false;
        }
        this.Q = j;
        this.T = false;
        this.n.clear();
        xc xcVar = this.j;
        if (xcVar.m()) {
            if (this.C) {
                for (pj pjVar : this.v) {
                    pjVar.u();
                }
            }
            this.j.g();
        } else {
            xcVar.h();
            S();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean F(com.google.ads.interactivemedia.v3.internal.we[] r20, boolean[] r21, com.google.ads.interactivemedia.v3.internal.uf[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.pk.F(com.google.ads.interactivemedia.v3.internal.we[], boolean[], com.google.ads.interactivemedia.v3.internal.uf[], boolean[], long, boolean):boolean");
    }

    public final void G(long j) {
        if (!this.C || U()) {
            return;
        }
        int length = this.v.length;
        for (int i = 0; i < length; i++) {
            this.v[i].P(j, this.N[i]);
        }
    }

    public final void H() {
        this.r.post(this.p);
    }

    public final void I(bf[] bfVarArr, int... iArr) {
        this.I = N(bfVarArr);
        this.J = new HashSet();
        for (int i : iArr) {
            this.J.add(this.I.b(i));
        }
        this.L = 0;
        this.r.post(new ky(this.e, 3));
        T();
    }

    public final boolean J(Uri uri, bdz bdzVar, boolean z) {
        wv d;
        if (!this.f.m(uri)) {
            return true;
        }
        long j = (z || (d = ws.d(ws.b(this.f.e()), bdzVar)) == null || d.a != 2) ? -9223372036854775807L : d.b;
        return this.f.n(uri, j) && j != -9223372036854775807L;
    }

    public final /* bridge */ /* synthetic */ void bj(wy wyVar, long j, long j2) {
        uu uuVar = (uu) wyVar;
        this.u = null;
        this.f.h(uuVar);
        long j3 = uuVar.f;
        uuVar.l();
        uuVar.m();
        uuVar.k();
        this.k.q(new sw(), uuVar.h, this.d, uuVar.i, uuVar.j, uuVar.l, uuVar.m);
        if (this.D) {
            this.e.g(this);
        } else {
            o(this.P);
        }
    }

    public final /* bridge */ /* synthetic */ wv bk(wy wyVar, long j, long j2, IOException iOException, int i) {
        wv n;
        int i2;
        uu uuVar = (uu) wyVar;
        boolean z = uuVar instanceof oy;
        if (z && !((oy) uuVar).h() && (iOException instanceof dq) && ((i2 = ((dq) iOException).c) == 410 || i2 == 404)) {
            return xc.a;
        }
        long k = uuVar.k();
        uuVar.l();
        uuVar.m();
        sw swVar = new sw();
        int i3 = cq.a;
        bdz bdzVar = new bdz(iOException, i);
        wv d = ws.d(ws.b(this.f.e()), bdzVar);
        boolean l = (d == null || d.a != 2) ? false : this.f.l(uuVar, d.b);
        if (l) {
            if (z && k == 0) {
                ArrayList arrayList = this.n;
                af.w(((oy) arrayList.remove(arrayList.size() + (-1))) == uuVar);
                if (this.n.isEmpty()) {
                    this.Q = this.P;
                } else {
                    ((oy) axo.z(this.n)).d();
                }
            }
            n = xc.b;
        } else {
            long e = ws.e(bdzVar);
            n = e != -9223372036854775807L ? xc.n(false, e) : xc.c;
        }
        wv wvVar = n;
        boolean z2 = !wvVar.a();
        this.k.r(swVar, uuVar.h, this.d, uuVar.i, uuVar.j, uuVar.l, uuVar.m, iOException, z2);
        if (z2) {
            this.u = null;
        }
        if (l) {
            if (this.D) {
                this.e.g(this);
            } else {
                o(this.P);
            }
        }
        return wvVar;
    }

    public final /* bridge */ /* synthetic */ void bn(wy wyVar, long j, long j2, boolean z) {
        uu uuVar = (uu) wyVar;
        this.u = null;
        long j3 = uuVar.f;
        uuVar.l();
        uuVar.m();
        uuVar.k();
        this.k.p(new sw(), uuVar.h, this.d, uuVar.i, uuVar.j, uuVar.l, uuVar.m);
        if (z) {
            return;
        }
        if (U() || this.E == 0) {
            S();
        }
        if (this.E > 0) {
            this.e.g(this);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Attempt to invoke virtual method 'void jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)' on a null object reference
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(Unknown Source:89)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(Unknown Source:106)
        */
    public final long bo() {
        /*
            r7 = this;
            boolean r0 = r7.T
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.U()
            if (r0 == 0) goto L10
            long r0 = r7.Q
            return r0
        L10:
            long r0 = r7.P
            com.google.ads.interactivemedia.v3.internal.oy r2 = r7.M()
            boolean r3 = r2.g()
            if (r3 != 0) goto L35
            java.util.ArrayList r2 = r7.n
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L34
            java.util.ArrayList r2 = r7.n
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            com.google.ads.interactivemedia.v3.internal.oy r2 = (com.google.ads.interactivemedia.v3.internal.oy) r2
            goto L35
        L34:
            r2 = 0
        L35:
            if (r2 == 0) goto L3d
            long r2 = r2.m
            long r0 = java.lang.Math.max(r0, r2)
        L3d:
            boolean r2 = r7.C
            if (r2 == 0) goto L54
            com.google.ads.interactivemedia.v3.internal.pj[] r2 = r7.v
            int r3 = r2.length
            r4 = 0
        L45:
            if (r4 >= r3) goto L54
            r5 = r2[r4]
            long r5 = r5.r()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L45
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.pk.bo():long");
    }

    public final long c() {
        if (U()) {
            return this.Q;
        }
        if (this.T) {
            return Long.MIN_VALUE;
        }
        return M().m;
    }

    public final int d(int i) {
        P();
        af.s(this.K);
        int i2 = this.K[i];
        if (i2 == -1) {
            return this.J.contains(this.I.b(i)) ? -3 : -2;
        }
        boolean[] zArr = this.N;
        if (zArr[i2]) {
            return -2;
        }
        zArr[i2] = true;
        return i2;
    }

    public final int e(int i, go goVar, ef efVar, int i2) {
        s sVar;
        if (U()) {
            return -3;
        }
        int i3 = 0;
        if (!this.n.isEmpty()) {
            int i4 = 0;
            loop0: while (i4 < this.n.size() - 1) {
                int i5 = ((oy) this.n.get(i4)).a;
                int length = this.v.length;
                for (int i6 = 0; i6 < length; i6++) {
                    if (this.N[i6] && this.v[i6].n() == i5) {
                        break loop0;
                    }
                }
                i4++;
            }
            cq.T(this.n, 0, i4);
            oy oyVar = (oy) this.n.get(0);
            s sVar2 = oyVar.i;
            if (!sVar2.equals(this.G)) {
                this.k.o(this.d, sVar2, oyVar.j, oyVar.l);
            }
            this.G = sVar2;
        }
        if (!this.n.isEmpty() && !((oy) this.n.get(0)).h()) {
            return -3;
        }
        int o = this.v[i].o(goVar, efVar, i2, this.T);
        if (o == -5) {
            s sVar3 = goVar.b;
            af.s(sVar3);
            if (i == this.B) {
                int n = this.v[i].n();
                while (i3 < this.n.size() && ((oy) this.n.get(i3)).a != n) {
                    i3++;
                }
                if (i3 < this.n.size()) {
                    sVar = ((oy) this.n.get(i3)).i;
                } else {
                    sVar = this.F;
                    af.s(sVar);
                }
                sVar3 = sVar3.d(sVar);
            }
            goVar.b = sVar3;
        }
        return o;
    }

    public final int f(int i, long j) {
        if (U()) {
            return 0;
        }
        pj pjVar = this.v[i];
        int l = pjVar.l(j, this.T);
        oy oyVar = (oy) axo.C(this.n);
        if (oyVar != null && !oyVar.h()) {
            l = Math.min(l, oyVar.a(i) - pjVar.k());
        }
        pjVar.G(l);
        return l;
    }

    public final long g(long j, hl hlVar) {
        return this.f.c(j, hlVar);
    }

    public final um h() {
        P();
        return this.I;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.v3.internal.aae i(int r10, int r11) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.pk.i(int, int):com.google.ads.interactivemedia.v3.internal.aae");
    }

    public final void l(long j) {
        xc xcVar = this.j;
        if (xcVar.l() || U()) {
            return;
        }
        if (xcVar.m()) {
            af.s(this.u);
            this.f.p(j, this.u, this.o);
            return;
        }
        int size = this.o.size();
        while (size > 0) {
            int i = size - 1;
            if (this.f.a((oy) this.o.get(i)) != 2) {
                break;
            } else {
                size = i;
            }
        }
        if (size < this.o.size()) {
            Q(size);
        }
        int b = this.f.b(j, this.o);
        if (b < this.n.size()) {
            Q(b);
        }
    }

    public final void m() {
        if (this.D) {
            return;
        }
        o(this.P);
    }

    public final void n() {
        this.U = true;
        this.r.post(this.q);
    }

    public final boolean o(long j) {
        List list;
        long max;
        if (!this.T) {
            xc xcVar = this.j;
            if (!xcVar.m() && !xcVar.l()) {
                if (U()) {
                    list = Collections.emptyList();
                    max = this.Q;
                    for (pj pjVar : this.v) {
                        pjVar.E(this.Q);
                    }
                } else {
                    list = this.o;
                    oy M = M();
                    max = M.g() ? M.m : Math.max(this.P, M.l);
                }
                List list2 = list;
                long j2 = max;
                this.m.a();
                this.f.f(j, j2, list2, this.D || !list2.isEmpty(), this.m);
                os osVar = this.m;
                boolean z = osVar.b;
                uu uuVar = osVar.a;
                Uri uri = osVar.c;
                if (z) {
                    this.Q = -9223372036854775807L;
                    this.T = true;
                    return true;
                }
                if (uuVar == null) {
                    if (uri != null) {
                        this.e.m(uri);
                    }
                    return false;
                }
                if (uuVar instanceof oy) {
                    oy oyVar = (oy) uuVar;
                    this.X = oyVar;
                    this.F = oyVar.i;
                    this.Q = -9223372036854775807L;
                    this.n.add(oyVar);
                    avk j3 = avo.j();
                    for (pj pjVar2 : this.v) {
                        j3.g(Integer.valueOf(pjVar2.m()));
                    }
                    oyVar.c(this, j3.f());
                    for (pj pjVar3 : this.v) {
                        pjVar3.g(oyVar);
                        if (oyVar.d) {
                            pjVar3.I();
                        }
                    }
                }
                this.u = uuVar;
                this.j.b(uuVar, this, ws.c(uuVar.h));
                this.k.s(new sw(uuVar.g), uuVar.h, this.d, uuVar.i, uuVar.j, uuVar.l, uuVar.m);
                return true;
            }
        }
        return false;
    }

    public final boolean p() {
        return this.j.m();
    }

    public final void q() throws IOException {
        this.j.a();
        this.f.g();
    }

    public final void r(int i) throws IOException {
        q();
        this.v[i].y();
    }

    public final void s() throws IOException {
        q();
        if (this.T && !this.D) {
            throw as.a("Loading finished before preparation is complete.", null);
        }
    }

    public final void t() {
        for (pj pjVar : this.v) {
            pjVar.A();
        }
    }

    public final void u() {
        this.x.clear();
    }

    public final void v() {
        if (this.n.isEmpty()) {
            return;
        }
        oy oyVar = (oy) axo.z(this.n);
        int a2 = this.f.a(oyVar);
        if (a2 == 1) {
            oyVar.f();
            return;
        }
        if (a2 != 2 || this.T) {
            return;
        }
        xc xcVar = this.j;
        if (xcVar.m()) {
            xcVar.g();
        }
    }

    public final void w() {
        if (this.D) {
            for (pj pjVar : this.v) {
                pjVar.z();
            }
        }
        this.j.k(this);
        this.r.removeCallbacksAndMessages((Object) null);
        this.H = true;
        this.s.clear();
    }

    public final void x(aab aabVar) {
    }

    public final void y(o oVar) {
        if (cq.V(this.W, oVar)) {
            return;
        }
        this.W = oVar;
        int i = 0;
        while (true) {
            pj[] pjVarArr = this.v;
            if (i >= pjVarArr.length) {
                return;
            }
            if (this.O[i]) {
                pjVarArr[i].d(oVar);
            }
            i++;
        }
    }

    public final void z(boolean z) {
        this.f.j(z);
    }
}
