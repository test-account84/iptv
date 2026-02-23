package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class la extends be {
    private final long b;
    private final long c;
    private final long d;
    private final int e;
    private final long f;
    private final long g;
    private final long h;
    private final lu i;
    private final ai j;
    private final ac k;

    public la(long j, long j2, long j3, int i, long j4, long j5, long j6, lu luVar, ai aiVar, ac acVar) {
        af.w(luVar.d == (acVar != null));
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = i;
        this.f = j4;
        this.g = j5;
        this.h = j6;
        this.i = luVar;
        this.j = aiVar;
        this.k = acVar;
    }

    private static boolean r(lu luVar) {
        return luVar.d && luVar.e != -9223372036854775807L && luVar.b == -9223372036854775807L;
    }

    public final int a(Object obj) {
        int intValue;
        if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.e) >= 0 && intValue < b()) {
            return intValue;
        }
        return -1;
    }

    public final int b() {
        return this.i.a();
    }

    public final int c() {
        return 1;
    }

    public final bc d(int i, bc bcVar, boolean z) {
        af.y(i, b());
        return bcVar.m(z ? this.i.d(i).a : null, z ? Integer.valueOf(this.e + i) : null, this.i.c(i), cq.t(this.i.d(i).b - this.i.d(0).b) - this.f);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b A[PHI: r1
      0x002b: PHI (r1v2 long) = (r1v1 long), (r1v5 long) binds: [B:8:0x001b, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.v3.internal.bd e(int r26, com.google.ads.interactivemedia.v3.internal.bd r27, long r28) {
        /*
            r25 = this;
            r0 = r25
            r1 = 1
            r2 = r26
            com.google.ads.interactivemedia.v3.internal.af.y(r2, r1)
            long r1 = r0.h
            com.google.ads.interactivemedia.v3.internal.lu r3 = r0.i
            boolean r3 = r(r3)
            r4 = -1
            if (r3 != 0) goto L17
        L13:
            r18 = r1
            goto L9b
        L17:
            r5 = 0
            int r3 = (r28 > r5 ? 1 : (r28 == r5 ? 0 : -1))
            if (r3 <= 0) goto L2b
            long r1 = r1 + r28
            long r7 = r0.g
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 <= 0) goto L2b
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L13
        L2b:
            long r7 = r0.f
            long r7 = r7 + r1
            com.google.ads.interactivemedia.v3.internal.lu r3 = r0.i
            r9 = 0
            long r10 = r3.c(r9)
            r3 = 0
        L36:
            com.google.ads.interactivemedia.v3.internal.lu r12 = r0.i
            int r12 = r12.a()
            int r12 = r12 + r4
            if (r3 >= r12) goto L4d
            int r12 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r12 < 0) goto L4d
            long r7 = r7 - r10
            int r3 = r3 + 1
            com.google.ads.interactivemedia.v3.internal.lu r10 = r0.i
            long r10 = r10.c(r3)
            goto L36
        L4d:
            com.google.ads.interactivemedia.v3.internal.lu r12 = r0.i
            com.google.ads.interactivemedia.v3.internal.lz r3 = r12.d(r3)
            java.util.List r12 = r3.c
            int r12 = r12.size()
            r13 = 0
        L5a:
            if (r13 >= r12) goto L6c
            java.util.List r14 = r3.c
            java.lang.Object r14 = r14.get(r13)
            com.google.ads.interactivemedia.v3.internal.ls r14 = (com.google.ads.interactivemedia.v3.internal.ls) r14
            int r14 = r14.b
            r15 = 2
            if (r14 == r15) goto L6d
            int r13 = r13 + 1
            goto L5a
        L6c:
            r13 = -1
        L6d:
            if (r13 != r4) goto L70
            goto L13
        L70:
            java.util.List r3 = r3.c
            java.lang.Object r3 = r3.get(r13)
            com.google.ads.interactivemedia.v3.internal.ls r3 = (com.google.ads.interactivemedia.v3.internal.ls) r3
            java.util.List r3 = r3.c
            java.lang.Object r3 = r3.get(r9)
            com.google.ads.interactivemedia.v3.internal.me r3 = (com.google.ads.interactivemedia.v3.internal.me) r3
            com.google.ads.interactivemedia.v3.internal.li r3 = r3.k()
            if (r3 == 0) goto L13
            long r12 = r3.f(r10)
            int r9 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r9 != 0) goto L8f
            goto L13
        L8f:
            long r5 = r3.g(r7, r10)
            long r5 = r3.h(r5)
            long r1 = r1 + r5
            long r1 = r1 - r7
            goto L13
        L9b:
            java.lang.Object r6 = com.google.ads.interactivemedia.v3.internal.bd.a
            com.google.ads.interactivemedia.v3.internal.ai r7 = r0.j
            com.google.ads.interactivemedia.v3.internal.lu r1 = r0.i
            r8 = r1
            long r9 = r0.b
            long r11 = r0.c
            long r13 = r0.d
            boolean r16 = r(r1)
            com.google.ads.interactivemedia.v3.internal.ac r1 = r0.k
            r17 = r1
            long r1 = r0.g
            r20 = r1
            int r1 = r25.b()
            int r22 = r1 + (-1)
            long r1 = r0.f
            r23 = r1
            r15 = 1
            r5 = r27
            r5.d(r6, r7, r8, r9, r11, r13, r15, r16, r17, r18, r20, r22, r23)
            return r27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.la.e(int, com.google.ads.interactivemedia.v3.internal.bd, long):com.google.ads.interactivemedia.v3.internal.bd");
    }

    public final Object f(int i) {
        af.y(i, b());
        return Integer.valueOf(this.e + i);
    }
}
