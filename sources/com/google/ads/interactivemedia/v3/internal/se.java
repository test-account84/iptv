package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class se implements td, tc {
    public final td a;
    long b;
    private tc c;
    private sd[] d = new sd[0];
    private long e = 0;

    public se(td tdVar, long j) {
        this.a = tdVar;
        this.b = j;
    }

    public final long a(long j, hl hlVar) {
        if (j == 0) {
            return 0L;
        }
        long p = cq.p(hlVar.c, 0L, j);
        long j2 = hlVar.d;
        long j3 = this.b;
        long p2 = cq.p(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        if (p != hlVar.c || p2 != hlVar.d) {
            hlVar = new hl(p, p2);
        }
        return this.a.a(j, hlVar);
    }

    public final void bl(td tdVar) {
        tc tcVar = this.c;
        af.s(tcVar);
        tcVar.bl(this);
    }

    public final void bm() throws IOException {
        this.a.bm();
    }

    public final long bo() {
        long bo = this.a.bo();
        if (bo != Long.MIN_VALUE) {
            long j = this.b;
            if (j == Long.MIN_VALUE || bo < j) {
                return bo;
            }
        }
        return Long.MIN_VALUE;
    }

    public final long c() {
        long c = this.a.c();
        if (c != Long.MIN_VALUE) {
            long j = this.b;
            if (j == Long.MIN_VALUE || c < j) {
                return c;
            }
        }
        return Long.MIN_VALUE;
    }

    public final long d() {
        if (j()) {
            long j = this.e;
            this.e = -9223372036854775807L;
            long d = d();
            return d != -9223372036854775807L ? d : j;
        }
        long d2 = this.a.d();
        if (d2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        af.w(d2 >= 0);
        long j2 = this.b;
        af.w(j2 == Long.MIN_VALUE || d2 <= j2);
        return d2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long e(long r8) {
        /*
            r7 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.e = r0
            com.google.ads.interactivemedia.v3.internal.sd[] r0 = r7.d
            int r1 = r0.length
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.c()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            com.google.ads.interactivemedia.v3.internal.td r0 = r7.a
            long r0 = r0.e(r8)
            r3 = 1
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 == 0) goto L35
            r8 = 0
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 < 0) goto L36
            long r8 = r7.b
            r4 = -9223372036854775808
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L35
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 > 0) goto L36
        L35:
            r2 = 1
        L36:
            com.google.ads.interactivemedia.v3.internal.af.w(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.se.e(long):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long f(com.google.ads.interactivemedia.v3.internal.we[] r15, boolean[] r16, com.google.ads.interactivemedia.v3.internal.uf[] r17, boolean[] r18, long r19) {
        /*
            r14 = this;
            r0 = r14
            r1 = r17
            int r2 = r1.length
            com.google.ads.interactivemedia.v3.internal.sd[] r3 = new com.google.ads.interactivemedia.v3.internal.sd[r2]
            r0.d = r3
            com.google.ads.interactivemedia.v3.internal.uf[] r2 = new com.google.ads.interactivemedia.v3.internal.uf[r2]
            r3 = 0
            r4 = 0
        Lc:
            int r5 = r1.length
            r11 = 0
            if (r4 >= r5) goto L21
            com.google.ads.interactivemedia.v3.internal.sd[] r5 = r0.d
            r6 = r1[r4]
            com.google.ads.interactivemedia.v3.internal.sd r6 = (com.google.ads.interactivemedia.v3.internal.sd) r6
            r5[r4] = r6
            if (r6 == 0) goto L1c
            com.google.ads.interactivemedia.v3.internal.uf r11 = r6.a
        L1c:
            r2[r4] = r11
            int r4 = r4 + 1
            goto Lc
        L21:
            com.google.ads.interactivemedia.v3.internal.td r4 = r0.a
            r5 = r15
            r6 = r16
            r7 = r2
            r8 = r18
            r9 = r19
            long r4 = r4.f(r5, r6, r7, r8, r9)
            boolean r6 = r14.j()
            r7 = 0
            if (r6 == 0) goto L3d
            int r6 = (r19 > r7 ? 1 : (r19 == r7 ? 0 : -1))
            if (r6 != 0) goto L3d
            r9 = r7
            goto L3f
        L3d:
            r9 = r19
        L3f:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.e = r12
            r6 = 1
            int r12 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r12 == 0) goto L5d
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 < 0) goto L5c
            long r7 = r0.b
            r9 = -9223372036854775808
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 == 0) goto L5d
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 > 0) goto L5c
            goto L5d
        L5c:
            r6 = 0
        L5d:
            com.google.ads.interactivemedia.v3.internal.af.w(r6)
        L60:
            int r6 = r1.length
            if (r3 >= r6) goto L86
            r6 = r2[r3]
            if (r6 != 0) goto L6c
            com.google.ads.interactivemedia.v3.internal.sd[] r6 = r0.d
            r6[r3] = r11
            goto L7d
        L6c:
            com.google.ads.interactivemedia.v3.internal.sd[] r7 = r0.d
            r8 = r7[r3]
            if (r8 == 0) goto L76
            com.google.ads.interactivemedia.v3.internal.uf r8 = r8.a
            if (r8 == r6) goto L7d
        L76:
            com.google.ads.interactivemedia.v3.internal.sd r8 = new com.google.ads.interactivemedia.v3.internal.sd
            r8.<init>(r14, r6)
            r7[r3] = r8
        L7d:
            com.google.ads.interactivemedia.v3.internal.sd[] r6 = r0.d
            r6 = r6[r3]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L60
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.se.f(com.google.ads.interactivemedia.v3.internal.we[], boolean[], com.google.ads.interactivemedia.v3.internal.uf[], boolean[], long):long");
    }

    public final /* bridge */ /* synthetic */ void g(uh uhVar) {
        tc tcVar = this.c;
        af.s(tcVar);
        tcVar.g(this);
    }

    public final um h() {
        return this.a.h();
    }

    public final boolean j() {
        return this.e != -9223372036854775807L;
    }

    public final void k(tc tcVar, long j) {
        this.c = tcVar;
        this.a.k(this, j);
    }

    public final void l(long j) {
        this.a.l(j);
    }

    public final void m(long j) {
        this.b = j;
    }

    public final boolean o(long j) {
        return this.a.o(j);
    }

    public final boolean p() {
        return this.a.p();
    }

    public final void q(long j) {
        this.a.q(j);
    }
}
