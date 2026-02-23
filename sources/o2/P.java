package O2;

import O2.H0;
import android.os.SystemClock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class p implements E0 {
    public final float a;
    public final float b;
    public final long c;
    public final float d;
    public final long e;
    public final long f;
    public final float g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public float n;
    public float o;
    public float p;
    public long q;
    public long r;
    public long s;

    public static final class b {
        public float a = 0.97f;
        public float b = 1.03f;
        public long c = 1000;
        public float d = 1.0E-7f;
        public long e = d4.k0.P0(20);
        public long f = d4.k0.P0(500);
        public float g = 0.999f;

        public p a() {
            return new p(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }
    }

    public p(float f, float f2, long j, float f3, long j2, long j3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = j;
        this.d = f3;
        this.e = j2;
        this.f = j3;
        this.g = f4;
        this.h = -9223372036854775807L;
        this.i = -9223372036854775807L;
        this.k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.o = f;
        this.n = f2;
        this.p = 1.0f;
        this.q = -9223372036854775807L;
        this.j = -9223372036854775807L;
        this.m = -9223372036854775807L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
    }

    public static long h(long j, long j2, float f) {
        return (long) ((j * f) + ((1.0f - f) * j2));
    }

    public float a(long j, long j2) {
        if (this.h == -9223372036854775807L) {
            return 1.0f;
        }
        i(j, j2);
        if (this.q != -9223372036854775807L && SystemClock.elapsedRealtime() - this.q < this.c) {
            return this.p;
        }
        this.q = SystemClock.elapsedRealtime();
        f(j);
        long j3 = j - this.m;
        if (Math.abs(j3) < this.e) {
            this.p = 1.0f;
        } else {
            this.p = d4.k0.q((this.d * j3) + 1.0f, this.o, this.n);
        }
        return this.p;
    }

    public long b() {
        return this.m;
    }

    public void c() {
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

    public void d(long j) {
        this.i = j;
        g();
    }

    public void e(H0.g gVar) {
        this.h = d4.k0.P0(gVar.a);
        this.k = d4.k0.P0(gVar.c);
        this.l = d4.k0.P0(gVar.d);
        float f = gVar.e;
        if (f == -3.4028235E38f) {
            f = this.a;
        }
        this.o = f;
        float f2 = gVar.f;
        if (f2 == -3.4028235E38f) {
            f2 = this.b;
        }
        this.n = f2;
        if (f == 1.0f && f2 == 1.0f) {
            this.h = -9223372036854775807L;
        }
        g();
    }

    public final void f(long j) {
        long j2 = this.r + (this.s * 3);
        if (this.m > j2) {
            float P0 = d4.k0.P0(this.c);
            this.m = w5.h.c(j2, this.j, this.m - (((long) ((this.p - 1.0f) * P0)) + ((long) ((this.n - 1.0f) * P0))));
            return;
        }
        long s = d4.k0.s(j - ((long) (Math.max(0.0f, this.p - 1.0f) / this.d)), this.m, j2);
        this.m = s;
        long j3 = this.l;
        if (j3 == -9223372036854775807L || s <= j3) {
            return;
        }
        this.m = j3;
    }

    public final void g() {
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

    public final void i(long j, long j2) {
        long h;
        long j3 = j - j2;
        long j4 = this.r;
        if (j4 == -9223372036854775807L) {
            this.r = j3;
            h = 0;
        } else {
            long max = Math.max(j3, h(j4, j3, this.g));
            this.r = max;
            h = h(this.s, Math.abs(j3 - max), this.g);
        }
        this.s = h;
    }

    public /* synthetic */ p(float f, float f2, long j, float f3, long j2, long j3, float f4, a aVar) {
        this(f, f2, j, f3, j2, j3, f4);
    }
}
