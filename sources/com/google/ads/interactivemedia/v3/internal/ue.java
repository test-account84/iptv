package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class ue implements aae {
    private s A;
    private s B;
    private int C;
    private boolean D;
    private boolean E;
    private long F;
    private boolean G;
    private final ua a;
    private final nt d;
    private final nn e;
    private ud f;
    private s g;
    private nm h;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean w;
    private boolean z;
    private final ub b = new ub();
    private int i = 1000;
    private int[] j = new int[1000];
    private long[] k = new long[1000];
    private long[] n = new long[1000];
    private int[] m = new int[1000];
    private int[] l = new int[1000];
    private aad[] o = new aad[1000];
    private final ul c = new ul(uk.b);
    private long t = Long.MIN_VALUE;
    private long u = Long.MIN_VALUE;
    private long v = Long.MIN_VALUE;
    private boolean y = true;
    private boolean x = true;

    public ue(wr wrVar, nt ntVar, nn nnVar) {
        this.d = ntVar;
        this.e = nnVar;
        this.a = new ua(wrVar);
    }

    public static ue N(wr wrVar, nt ntVar, nn nnVar) {
        af.s(ntVar);
        return new ue(wrVar, ntVar, nnVar);
    }

    public static ue O(wr wrVar) {
        return new ue(wrVar, null, null);
    }

    private final synchronized int Q(go goVar, ef efVar, boolean z, boolean z2, ub ubVar) {
        try {
            efVar.c = false;
            if (!aa()) {
                if (!z2 && !this.w) {
                    s sVar = this.B;
                    if (sVar == null || (!z && sVar == this.g)) {
                        return -3;
                    }
                    af.s(sVar);
                    W(sVar, goVar);
                    return -5;
                }
                efVar.c(4);
                return -4;
            }
            Object obj = ((uc) this.c.a(k())).a;
            if (!z && obj == this.g) {
                int g = g(this.s);
                if (!ab(g)) {
                    efVar.c = true;
                    return -3;
                }
                efVar.c(this.m[g]);
                long j = this.n[g];
                efVar.d = j;
                if (j < this.t) {
                    efVar.a(Integer.MIN_VALUE);
                }
                ubVar.a = this.l[g];
                ubVar.b = this.k[g];
                ubVar.c = this.o[g];
                return -4;
            }
            W((s) obj, goVar);
            return -5;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized long R() {
        int i = this.p;
        if (i == 0) {
            return -1L;
        }
        return S(i);
    }

    private final long S(int i) {
        this.u = Math.max(this.u, U(i));
        this.p -= i;
        int i2 = this.q + i;
        this.q = i2;
        int i3 = this.r + i;
        this.r = i3;
        int i4 = this.i;
        if (i3 >= i4) {
            this.r = i3 - i4;
        }
        int i5 = this.s - i;
        this.s = i5;
        if (i5 < 0) {
            this.s = 0;
        }
        this.c.f(i2);
        if (this.p != 0) {
            return this.k[this.r];
        }
        int i6 = this.r;
        if (i6 == 0) {
            i6 = this.i;
        }
        return this.k[i6 - 1] + this.l[r6];
    }

    private final long T(int i) {
        int m = m() - i;
        af.u(m >= 0 && m <= this.p - this.s);
        int i2 = this.p - m;
        this.p = i2;
        this.v = Math.max(this.u, U(i2));
        this.w = m == 0 && this.w;
        this.c.e(i);
        int i3 = this.p;
        if (i3 == 0) {
            return 0L;
        }
        return this.k[g(i3 - 1)] + this.l[r9];
    }

    private final long U(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int g = g(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.n[g]);
            if ((this.m[g] & 1) != 0) {
                break;
            }
            g--;
            if (g == -1) {
                g = this.i - 1;
            }
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0073 A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0001, B:5:0x0007, B:8:0x001e, B:10:0x0025, B:13:0x002d, B:15:0x005f, B:17:0x0095, B:19:0x009e, B:26:0x0073, B:28:0x0077, B:29:0x0082, B:30:0x0080), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized void V(long r9, int r11, long r12, int r14, com.google.ads.interactivemedia.v3.internal.aad r15) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ue.V(long, int, long, int, com.google.ads.interactivemedia.v3.internal.aad):void");
    }

    private final void W(s sVar, go goVar) {
        s sVar2 = this.g;
        boolean z = sVar2 == null;
        o oVar = z ? null : sVar2.o;
        this.g = sVar;
        o oVar2 = sVar.o;
        nt ntVar = this.d;
        goVar.b = ntVar != null ? sVar.c(ntVar.b(sVar)) : sVar;
        goVar.a = this.h;
        if (this.d == null) {
            return;
        }
        if (z || !cq.V(oVar, oVar2)) {
            nm nmVar = this.h;
            nm i = this.d.i(this.e, sVar);
            this.h = i;
            goVar.a = i;
            if (nmVar != null) {
                nmVar.m(this.e);
            }
        }
    }

    private final void X() {
        nm nmVar = this.h;
        if (nmVar != null) {
            nmVar.m(this.e);
            this.h = null;
            this.g = null;
        }
    }

    private final synchronized void Y() {
        this.s = 0;
        this.a.h();
    }

    private final synchronized boolean Z(long j) {
        if (this.p == 0) {
            return j > this.u;
        }
        if (s() >= j) {
            return false;
        }
        int i = this.p;
        int g = g(i - 1);
        while (i > this.s && this.n[g] >= j) {
            i--;
            g--;
            if (g == -1) {
                g = this.i - 1;
            }
        }
        T(this.q + i);
        return true;
    }

    private final boolean aa() {
        return this.s != this.p;
    }

    private final boolean ab(int i) {
        nm nmVar = this.h;
        if (nmVar == null || nmVar.a() == 4) {
            return true;
        }
        return (this.m[i] & 1073741824) == 0 && this.h.o();
    }

    private final synchronized boolean ac(s sVar) {
        try {
            this.y = false;
            if (cq.V(sVar, this.B)) {
                return false;
            }
            if (!this.c.g() && ((s) ((uc) this.c.b()).a).equals(sVar)) {
                sVar = (s) ((uc) this.c.b()).a;
            }
            this.B = sVar;
            s sVar2 = this.B;
            this.D = ar.k(sVar2.l, sVar2.i);
            this.E = false;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized long ad(long j, boolean z) {
        int i;
        try {
            int i2 = this.p;
            if (i2 != 0) {
                long[] jArr = this.n;
                int i3 = this.r;
                if (j >= jArr[i3]) {
                    if (z && (i = this.s) != i2) {
                        i2 = i + 1;
                    }
                    int d = d(i3, i2, j, false);
                    if (d == -1) {
                        return -1L;
                    }
                    return S(d);
                }
            }
            return -1L;
        } finally {
        }
    }

    private final int d(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.n[i];
            if (j2 > j) {
                break;
            }
            if (!z || (this.m[i] & 1) != 0) {
                i3 = i4;
                if (j2 == j) {
                    break;
                }
            }
            i++;
            if (i == this.i) {
                i = 0;
            }
        }
        return i3;
    }

    private final int g(int i) {
        int i2 = this.r + i;
        int i3 = this.i;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final void A() {
        C(true);
        X();
    }

    public final void B() {
        C(false);
    }

    public final void C(boolean z) {
        this.a.g();
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.x = true;
        this.t = Long.MIN_VALUE;
        this.u = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.w = false;
        this.c.d();
        if (z) {
            this.A = null;
            this.B = null;
            this.y = true;
        }
    }

    public final void D(long j) {
        if (this.F != j) {
            this.F = j;
            x();
        }
    }

    public final void E(long j) {
        this.t = j;
    }

    public final void F(ud udVar) {
        this.f = udVar;
    }

    public final synchronized void G(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.s + i <= this.p) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        af.u(z);
        this.s += i;
    }

    public final void H(int i) {
        this.C = i;
    }

    public final void I() {
        this.G = true;
    }

    public final synchronized boolean J() {
        return this.w;
    }

    public final synchronized boolean K(boolean z) {
        boolean z2 = true;
        if (aa()) {
            if (((uc) this.c.a(k())).a != this.g) {
                return true;
            }
            return ab(g(this.s));
        }
        if (!z && !this.w) {
            s sVar = this.B;
            if (sVar == null) {
                z2 = false;
            } else if (sVar == this.g) {
                return false;
            }
        }
        return z2;
    }

    public final synchronized boolean L(int i) {
        Y();
        int i2 = this.q;
        if (i >= i2 && i <= this.p + i2) {
            this.t = Long.MIN_VALUE;
            this.s = i - i2;
            return true;
        }
        return false;
    }

    public final synchronized boolean M(long j, boolean z) {
        Y();
        int i = this.s;
        int g = g(i);
        if (!aa() || j < this.n[g] || (j > this.v && !z)) {
            return false;
        }
        int d = d(g, this.p - i, j, true);
        if (d == -1) {
            return false;
        }
        this.t = j;
        this.s += d;
        return true;
    }

    public final void P(long j, boolean z) {
        this.a.c(ad(j, z));
    }

    public final /* synthetic */ int a(k kVar, int i, boolean z) {
        return fz.h(this, kVar, i, z);
    }

    public final void b(s sVar) {
        s c = c(sVar);
        this.z = false;
        this.A = sVar;
        boolean ac = ac(c);
        ud udVar = this.f;
        if (udVar == null || !ac) {
            return;
        }
        udVar.H();
    }

    public s c(s sVar) {
        if (this.F == 0 || sVar.p == Long.MAX_VALUE) {
            return sVar;
        }
        r b = sVar.b();
        b.ai(sVar.p + this.F);
        return b.v();
    }

    public final /* synthetic */ void e(cj cjVar, int i) {
        fz.i(this, cjVar, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(long r12, int r14, int r15, int r16, com.google.ads.interactivemedia.v3.internal.aad r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.z
            if (r0 == 0) goto Ld
            com.google.ads.interactivemedia.v3.internal.s r0 = r8.A
            com.google.ads.interactivemedia.v3.internal.af.t(r0)
            r11.b(r0)
        Ld:
            r0 = r14 & 1
            boolean r1 = r8.x
            r2 = 0
            if (r1 == 0) goto L19
            if (r0 != 0) goto L17
            return
        L17:
            r8.x = r2
        L19:
            long r3 = r8.F
            long r3 = r3 + r12
            boolean r1 = r8.D
            if (r1 == 0) goto L45
            long r5 = r8.t
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L27
            return
        L27:
            if (r0 != 0) goto L45
            boolean r1 = r8.E
            if (r1 != 0) goto L41
            com.google.ads.interactivemedia.v3.internal.s r1 = r8.B
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r5 = "Overriding unexpected non-sync sample for format: "
            java.lang.String r1 = r5.concat(r1)
            java.lang.String r5 = "SampleQueue"
            com.google.ads.interactivemedia.v3.internal.cd.e(r5, r1)
            r1 = 1
            r8.E = r1
        L41:
            r1 = r14 | 1
            r5 = r1
            goto L46
        L45:
            r5 = r14
        L46:
            boolean r1 = r8.G
            if (r1 == 0) goto L57
            if (r0 == 0) goto L56
            boolean r0 = r11.Z(r3)
            if (r0 != 0) goto L53
            goto L56
        L53:
            r8.G = r2
            goto L57
        L56:
            return
        L57:
            com.google.ads.interactivemedia.v3.internal.ua r0 = r8.a
            long r0 = r0.b()
            r6 = r15
            long r9 = (long) r6
            long r0 = r0 - r9
            r2 = r16
            long r9 = (long) r2
            long r9 = r0 - r9
            r0 = r11
            r1 = r3
            r3 = r5
            r4 = r9
            r7 = r17
            r0.V(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ue.f(long, int, int, int, com.google.ads.interactivemedia.v3.internal.aad):void");
    }

    public final int h(k kVar, int i, boolean z) throws IOException {
        return this.a.a(kVar, i, z);
    }

    public final void i(cj cjVar, int i) {
        this.a.i(cjVar, i);
    }

    public final int j() {
        return this.q;
    }

    public final int k() {
        return this.q + this.s;
    }

    public final synchronized int l(long j, boolean z) {
        int i = this.s;
        int g = g(i);
        if (aa() && j >= this.n[g]) {
            if (j > this.v && z) {
                return this.p - i;
            }
            int d = d(g, this.p - i, j, true);
            if (d == -1) {
                return 0;
            }
            return d;
        }
        return 0;
    }

    public final int m() {
        return this.q + this.p;
    }

    public final synchronized int n() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return aa() ? this.j[g(this.s)] : this.C;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        if (r9 != 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int o(com.google.ads.interactivemedia.v3.internal.go r9, com.google.ads.interactivemedia.v3.internal.ef r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = r11 & 2
            r1 = 1
            if (r0 == 0) goto L7
            r5 = 1
            goto L9
        L7:
            r0 = 0
            r5 = 0
        L9:
            com.google.ads.interactivemedia.v3.internal.ub r7 = r8.b
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            int r9 = r2.Q(r3, r4, r5, r6, r7)
            r12 = -4
            if (r9 != r12) goto L3e
            boolean r9 = r10.g()
            if (r9 != 0) goto L2b
            r9 = r11 & 1
            r11 = r11 & 4
            if (r11 != 0) goto L35
            if (r9 == 0) goto L2d
            com.google.ads.interactivemedia.v3.internal.ua r9 = r8.a
            com.google.ads.interactivemedia.v3.internal.ub r11 = r8.b
            r9.e(r10, r11)
        L2b:
            r9 = -4
            goto L3e
        L2d:
            com.google.ads.interactivemedia.v3.internal.ua r9 = r8.a
            com.google.ads.interactivemedia.v3.internal.ub r11 = r8.b
            r9.f(r10, r11)
            goto L38
        L35:
            if (r9 == 0) goto L38
            goto L2b
        L38:
            int r9 = r8.s
            int r9 = r9 + r1
            r8.s = r9
            return r12
        L3e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ue.o(com.google.ads.interactivemedia.v3.internal.go, com.google.ads.interactivemedia.v3.internal.ef, int, boolean):int");
    }

    public final synchronized long p() {
        int i = this.s;
        if (i == 0) {
            return -1L;
        }
        return S(i);
    }

    public final synchronized long q() {
        if (this.p == 0) {
            return Long.MIN_VALUE;
        }
        return this.n[this.r];
    }

    public final synchronized long r() {
        return this.v;
    }

    public final synchronized long s() {
        return Math.max(this.u, U(this.s));
    }

    public final synchronized s t() {
        if (this.y) {
            return null;
        }
        return this.B;
    }

    public final void u() {
        this.a.c(R());
    }

    public final void v() {
        this.a.c(p());
    }

    public final void w(int i) {
        this.a.d(T(i));
    }

    public final void x() {
        this.z = true;
    }

    public final void y() throws IOException {
        nm nmVar = this.h;
        if (nmVar == null || nmVar.a() != 1) {
            return;
        }
        nl c = this.h.c();
        af.s(c);
        throw c;
    }

    public final void z() {
        u();
        X();
    }
}
