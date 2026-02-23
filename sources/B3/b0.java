package B3;

import O2.H0;
import O2.Q1;
import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b0 extends Q1 {
    public static final Object t = new Object();
    public static final H0 u = new H0.c().g("SinglePeriodTimeline").m(Uri.EMPTY).a();
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final long k;
    public final long l;
    public final long m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final Object q;
    public final H0 r;
    public final H0.g s;

    public b0(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, H0 h0, H0.g gVar) {
        this.g = j;
        this.h = j2;
        this.i = j3;
        this.j = j4;
        this.k = j5;
        this.l = j6;
        this.m = j7;
        this.n = z;
        this.o = z2;
        this.p = z3;
        this.q = obj;
        this.r = (H0) d4.a.e(h0);
        this.s = gVar;
    }

    public int f(Object obj) {
        return t.equals(obj) ? 0 : -1;
    }

    public Q1.b l(int i, Q1.b bVar, boolean z) {
        d4.a.c(i, 0, 1);
        return bVar.y(null, z ? t : null, 0, this.j, -this.l);
    }

    public int n() {
        return 1;
    }

    public Object r(int i) {
        d4.a.c(i, 0, 1);
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e A[PHI: r1
      0x002e: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:2:0x000d, B:4:0x0011, B:6:0x0017, B:14:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public O2.Q1.d t(int r25, O2.Q1.d r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            d4.a.c(r3, r1, r2)
            long r1 = r0.m
            boolean r14 = r0.o
            if (r14 == 0) goto L2e
            boolean r3 = r0.p
            if (r3 != 0) goto L2e
            r3 = 0
            int r5 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r5 == 0) goto L2e
            long r3 = r0.k
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L27
        L24:
            r16 = r5
            goto L30
        L27:
            long r1 = r1 + r27
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L2e
            goto L24
        L2e:
            r16 = r1
        L30:
            java.lang.Object r4 = O2.Q1.d.s
            O2.H0 r5 = r0.r
            java.lang.Object r6 = r0.q
            long r7 = r0.g
            long r9 = r0.h
            long r11 = r0.i
            boolean r13 = r0.n
            O2.H0$g r15 = r0.s
            long r1 = r0.k
            r18 = r1
            r21 = 0
            long r1 = r0.l
            r22 = r1
            r20 = 0
            r3 = r26
            O2.Q1$d r1 = r3.j(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.b0.t(int, O2.Q1$d, long):O2.Q1$d");
    }

    public int u() {
        return 1;
    }

    public b0(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, Object obj, H0 h0) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, false, obj, h0, z3 ? h0.e : null);
    }

    public b0(long j, boolean z, boolean z2, boolean z3, Object obj, H0 h0) {
        this(j, j, 0L, 0L, z, z2, z3, obj, h0);
    }
}
