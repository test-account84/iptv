package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class er {
    private final long e;
    private final long f;
    private final float a = 0.97f;
    private final float b = 1.03f;
    private final long c = 1000;
    private final float d = 1.0E-7f;
    private final float g = 0.999f;
    private long h = -9223372036854775807L;
    private long i = -9223372036854775807L;
    private long k = -9223372036854775807L;
    private long l = -9223372036854775807L;
    private float o = 0.97f;
    private float n = 1.03f;
    private float p = 1.0f;
    private long q = -9223372036854775807L;
    private long j = -9223372036854775807L;
    private long m = -9223372036854775807L;
    private long r = -9223372036854775807L;
    private long s = -9223372036854775807L;

    public /* synthetic */ er(float f, float f2, long j, float f3, long j2, long j3, float f4) {
        this.e = j2;
        this.f = j3;
    }

    private static long f(long j, long j2, float f) {
        return (long) ((j * 0.999f) + (j2 * 9.999871E-4f));
    }

    private final void g() {
        long j = this.h;
        if (j != -9223372036854775807L) {
            long j2 = this.i;
            if (j2 != -9223372036854775807L) {
                j = j2;
            }
            long j3 = this.k;
            if (j3 != -9223372036854775807L && j < j3) {
                j = j3;
            }
            long j4 = this.l;
            if (j4 != -9223372036854775807L && j > j4) {
                j = j4;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.j == j) {
            return;
        }
        this.j = j;
        this.m = j;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.q = -9223372036854775807L;
    }

    public final float a(long j, long j2) {
        long f;
        long p;
        if (this.h == -9223372036854775807L) {
            return 1.0f;
        }
        long j3 = j - j2;
        long j4 = this.r;
        if (j4 == -9223372036854775807L) {
            this.r = j3;
            f = 0;
        } else {
            long max = Math.max(j3, f(j4, j3, 0.999f));
            this.r = max;
            f = f(this.s, Math.abs(j3 - max), 0.999f);
        }
        this.s = f;
        if (this.q != -9223372036854775807L && SystemClock.elapsedRealtime() - this.q < 1000) {
            return this.p;
        }
        this.q = SystemClock.elapsedRealtime();
        long j5 = this.r + (this.s * 3);
        if (this.m > j5) {
            float t = cq.t(1000L);
            long[] jArr = {j5, this.j, this.m - (((long) ((this.p - 1.0f) * t)) + ((long) ((this.n - 1.0f) * t)))};
            atp.e(true);
            p = jArr[0];
            for (int i = 1; i < 3; i++) {
                long j6 = jArr[i];
                if (j6 > p) {
                    p = j6;
                }
            }
            this.m = p;
        } else {
            p = cq.p(j - ((long) (Math.max(0.0f, this.p - 1.0f) / 1.0E-7f)), this.m, j5);
            this.m = p;
            long j7 = this.l;
            if (j7 != -9223372036854775807L && p > j7) {
                this.m = j7;
                p = j7;
            }
        }
        long j8 = j - p;
        if (Math.abs(j8) < this.e) {
            this.p = 1.0f;
            return 1.0f;
        }
        float a = cq.a((j8 * 1.0E-7f) + 1.0f, this.o, this.n);
        this.p = a;
        return a;
    }

    public final long b() {
        return this.m;
    }

    public final void c() {
        long j = this.m;
        if (j == -9223372036854775807L) {
            return;
        }
        long j2 = j + this.f;
        this.m = j2;
        long j3 = this.l;
        if (j3 != -9223372036854775807L && j2 > j3) {
            this.m = j3;
        }
        this.q = -9223372036854775807L;
    }

    public final void d(ac acVar) {
        this.h = cq.t(acVar.a);
        this.k = cq.t(acVar.b);
        this.l = cq.t(acVar.c);
        float f = acVar.d;
        if (f == -3.4028235E38f) {
            f = 0.97f;
        }
        this.o = f;
        float f2 = acVar.e;
        if (f2 == -3.4028235E38f) {
            f2 = 1.03f;
        }
        this.n = f2;
        if (f == 1.0f && f2 == 1.0f) {
            this.h = -9223372036854775807L;
        }
        g();
    }

    public final void e(long j) {
        this.i = j;
        g();
    }
}
