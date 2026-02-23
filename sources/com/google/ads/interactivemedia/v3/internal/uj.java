package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class uj extends be {
    private static final Object b = new Object();
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final Object l;
    private final ai m;
    private final ac n;

    static {
        v vVar = new v();
        vVar.b("SinglePeriodTimeline");
        vVar.c(Uri.EMPTY);
        vVar.a();
    }

    public uj(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2, boolean z3, Object obj, ai aiVar, ac acVar) {
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.g = j5;
        this.h = j6;
        this.i = z;
        this.j = z2;
        this.k = z3;
        this.l = obj;
        this.m = aiVar;
        this.n = acVar;
    }

    public final int a(Object obj) {
        return b.equals(obj) ? 0 : -1;
    }

    public final int b() {
        return 1;
    }

    public final int c() {
        return 1;
    }

    public final bc d(int i, bc bcVar, boolean z) {
        af.y(i, 1);
        return bcVar.m(null, z ? b : null, this.e, -this.g);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[PHI: r1
      0x002d: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v5 long) binds: [B:2:0x000c, B:4:0x0010, B:6:0x0016, B:14:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.v3.internal.bd e(int r24, com.google.ads.interactivemedia.v3.internal.bd r25, long r26) {
        /*
            r23 = this;
            r0 = r23
            r1 = 1
            r2 = r24
            com.google.ads.interactivemedia.v3.internal.af.y(r2, r1)
            long r1 = r0.h
            boolean r14 = r0.j
            if (r14 == 0) goto L2d
            boolean r3 = r0.k
            if (r3 != 0) goto L2d
            r3 = 0
            int r5 = (r26 > r3 ? 1 : (r26 == r3 ? 0 : -1))
            if (r5 == 0) goto L2d
            long r3 = r0.f
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L26
        L23:
            r16 = r5
            goto L2f
        L26:
            long r1 = r1 + r26
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L2d
            goto L23
        L2d:
            r16 = r1
        L2f:
            java.lang.Object r4 = com.google.ads.interactivemedia.v3.internal.bd.a
            com.google.ads.interactivemedia.v3.internal.ai r5 = r0.m
            java.lang.Object r6 = r0.l
            long r7 = r0.c
            long r9 = r0.d
            boolean r13 = r0.i
            com.google.ads.interactivemedia.v3.internal.ac r15 = r0.n
            long r1 = r0.f
            r18 = r1
            r20 = 0
            long r1 = r0.g
            r21 = r1
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3 = r25
            r3.d(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21)
            return r25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.uj.e(int, com.google.ads.interactivemedia.v3.internal.bd, long):com.google.ads.interactivemedia.v3.internal.bd");
    }

    public final Object f(int i) {
        af.y(i, 1);
        return b;
    }
}
