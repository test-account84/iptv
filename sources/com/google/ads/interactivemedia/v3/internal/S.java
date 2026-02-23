package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    private int F;
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final String i;
    public final ao j;
    public final String k;
    public final String l;
    public final int m;
    public final List n;
    public final o o;
    public final long p;
    public final int q;
    public final int r;
    public final float s;
    public final int t;
    public final float u;
    public final byte[] v;
    public final int w;
    public final j x;
    public final int y;
    public final int z;

    static {
        new r().v();
    }

    public /* synthetic */ s(r rVar) {
        this.a = r.z(rVar);
        this.b = r.A(rVar);
        this.c = cq.Q(r.B(rVar));
        this.d = r.p(rVar);
        this.e = r.m(rVar);
        int d = r.d(rVar);
        this.f = d;
        int l = r.l(rVar);
        this.g = l;
        this.h = l != -1 ? l : d;
        this.i = r.x(rVar);
        this.j = r.w(rVar);
        this.k = r.y(rVar);
        this.l = r.C(rVar);
        this.m = r.j(rVar);
        this.n = r.D(rVar) == null ? Collections.emptyList() : r.D(rVar);
        o u = r.u(rVar);
        this.o = u;
        this.p = r.s(rVar);
        this.q = r.r(rVar);
        this.r = r.i(rVar);
        this.s = r.a(rVar);
        this.t = r.n(rVar) == -1 ? 0 : r.n(rVar);
        this.u = r.b(rVar) == -1.0f ? 1.0f : r.b(rVar);
        this.v = r.E(rVar);
        this.w = r.q(rVar);
        this.x = r.t(rVar);
        this.y = r.e(rVar);
        this.z = r.o(rVar);
        this.A = r.k(rVar);
        this.B = r.g(rVar) == -1 ? 0 : r.g(rVar);
        this.C = r.h(rVar) != -1 ? r.h(rVar) : 0;
        this.D = r.c(rVar);
        this.E = (r.f(rVar) != 0 || u == null) ? r.f(rVar) : 1;
    }

    public final int a() {
        int i;
        int i2 = this.q;
        if (i2 == -1 || (i = this.r) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final r b() {
        return new r(this);
    }

    public final s c(int i) {
        r b = b();
        b.L(i);
        return b.v();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.v3.internal.s d(com.google.ads.interactivemedia.v3.internal.s r14) {
        /*
            r13 = this;
            if (r13 != r14) goto L3
            return r13
        L3:
            java.lang.String r0 = r13.l
            int r0 = com.google.ads.interactivemedia.v3.internal.ar.b(r0)
            java.lang.String r1 = r14.a
            java.lang.String r2 = r14.b
            if (r2 != 0) goto L11
            java.lang.String r2 = r13.b
        L11:
            java.lang.String r3 = r13.c
            r4 = 3
            r5 = 1
            if (r0 == r4) goto L1a
            if (r0 != r5) goto L1f
            r0 = 1
        L1a:
            java.lang.String r4 = r14.c
            if (r4 == 0) goto L1f
            r3 = r4
        L1f:
            int r4 = r13.f
            r6 = -1
            if (r4 != r6) goto L26
            int r4 = r14.f
        L26:
            int r7 = r13.g
            if (r7 != r6) goto L2c
            int r7 = r14.g
        L2c:
            java.lang.String r6 = r13.i
            if (r6 != 0) goto L3e
            java.lang.String r8 = r14.i
            java.lang.String r8 = com.google.ads.interactivemedia.v3.internal.cq.K(r8, r0)
            java.lang.String[] r9 = com.google.ads.interactivemedia.v3.internal.cq.am(r8)
            int r9 = r9.length
            if (r9 != r5) goto L3e
            r6 = r8
        L3e:
            com.google.ads.interactivemedia.v3.internal.ao r5 = r13.j
            if (r5 != 0) goto L45
            com.google.ads.interactivemedia.v3.internal.ao r5 = r14.j
            goto L4b
        L45:
            com.google.ads.interactivemedia.v3.internal.ao r8 = r14.j
            com.google.ads.interactivemedia.v3.internal.ao r5 = r5.d(r8)
        L4b:
            float r8 = r13.s
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 != 0) goto L58
            r9 = 2
            if (r0 != r9) goto L58
            float r8 = r14.s
        L58:
            int r0 = r13.d
            int r9 = r14.d
            int r10 = r13.e
            int r11 = r14.e
            com.google.ads.interactivemedia.v3.internal.o r14 = r14.o
            com.google.ads.interactivemedia.v3.internal.o r12 = r13.o
            com.google.ads.interactivemedia.v3.internal.o r14 = com.google.ads.interactivemedia.v3.internal.o.c(r14, r12)
            com.google.ads.interactivemedia.v3.internal.r r12 = r13.b()
            r12.S(r1)
            r12.U(r2)
            r12.V(r3)
            r0 = r0 | r9
            r12.ag(r0)
            r0 = r10 | r11
            r12.ac(r0)
            r12.G(r4)
            r12.Z(r7)
            r12.I(r6)
            r12.X(r5)
            r12.M(r14)
            r12.P(r8)
            com.google.ads.interactivemedia.v3.internal.s r14 = r12.v()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.s.d(com.google.ads.interactivemedia.v3.internal.s):com.google.ads.interactivemedia.v3.internal.s");
    }

    public final boolean e(s sVar) {
        if (this.n.size() != sVar.n.size()) {
            return false;
        }
        for (int i = 0; i < this.n.size(); i++) {
            if (!Arrays.equals((byte[]) this.n.get(i), (byte[]) sVar.n.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && s.class == obj.getClass()) {
            s sVar = (s) obj;
            int i2 = this.F;
            if ((i2 == 0 || (i = sVar.F) == 0 || i2 == i) && this.d == sVar.d && this.e == sVar.e && this.f == sVar.f && this.g == sVar.g && this.m == sVar.m && this.p == sVar.p && this.q == sVar.q && this.r == sVar.r && this.t == sVar.t && this.w == sVar.w && this.y == sVar.y && this.z == sVar.z && this.A == sVar.A && this.B == sVar.B && this.C == sVar.C && this.D == sVar.D && this.E == sVar.E && Float.compare(this.s, sVar.s) == 0 && Float.compare(this.u, sVar.u) == 0 && cq.V(this.a, sVar.a) && cq.V(this.b, sVar.b) && cq.V(this.i, sVar.i) && cq.V(this.k, sVar.k) && cq.V(this.l, sVar.l) && cq.V(this.c, sVar.c) && Arrays.equals(this.v, sVar.v) && cq.V(this.j, sVar.j) && cq.V(this.x, sVar.x) && cq.V(this.o, sVar.o) && e(sVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.F;
        if (i != 0) {
            return i;
        }
        String str = this.a;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31;
        String str4 = this.i;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        ao aoVar = this.j;
        int hashCode5 = (hashCode4 + (aoVar == null ? 0 : aoVar.hashCode())) * 31;
        String str5 = this.k;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.l;
        int hashCode7 = ((((((((((((((((((((((((((((((hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.m) * 31) + ((int) this.p)) * 31) + this.q) * 31) + this.r) * 31) + Float.floatToIntBits(this.s)) * 31) + this.t) * 31) + Float.floatToIntBits(this.u)) * 31) + this.w) * 31) + this.y) * 31) + this.z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E;
        this.F = hashCode7;
        return hashCode7;
    }

    public final String toString() {
        return "Format(" + this.a + ", " + this.b + ", " + this.k + ", " + this.l + ", " + this.i + ", " + this.h + ", " + this.c + ", [" + this.q + ", " + this.r + ", " + this.s + "], [" + this.y + ", " + this.z + "])";
    }
}
