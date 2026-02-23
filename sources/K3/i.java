package k3;

import Q2.b0;
import com.google.android.exoplayer2.extractor.g;
import d3.u;
import d4.B;
import d4.M;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i implements g {
    public final long a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final long[] f;

    public i(long j, int i, long j2) {
        this(j, i, j2, -1L, null);
    }

    public static i a(long j, long j2, b0.a aVar, M m) {
        int L;
        int i = aVar.g;
        int i2 = aVar.d;
        int q = m.q();
        if ((q & 1) != 1 || (L = m.L()) == 0) {
            return null;
        }
        long c1 = k0.c1(L, i * 1000000, i2);
        if ((q & 6) != 6) {
            return new i(j2, aVar.c, c1);
        }
        long J = m.J();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = m.H();
        }
        if (j != -1) {
            long j3 = j2 + J;
            if (j != j3) {
                B.j("XingSeeker", "XING data size mismatch: " + j + ", " + j3);
            }
        }
        return new i(j2, aVar.c, c1, J, jArr);
    }

    public final long b(int i) {
        return (this.c * i) / 100;
    }

    public long c(long j) {
        long j2 = j - this.a;
        if (!g() || j2 <= this.b) {
            return 0L;
        }
        long[] jArr = (long[]) d4.a.i(this.f);
        double d = (j2 * 256.0d) / this.d;
        int i = k0.i(jArr, (long) d, true, true);
        long b = b(i);
        long j3 = jArr[i];
        int i2 = i + 1;
        long b2 = b(i2);
        return b + Math.round((j3 == (i == 99 ? 256L : jArr[i2]) ? 0.0d : (d - j3) / (r0 - j3)) * (b2 - b));
    }

    public g.a e(long j) {
        if (!g()) {
            return new g.a(new u(0L, this.a + this.b));
        }
        long s = k0.s(j, 0L, this.c);
        double d = (s * 100.0d) / this.c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                double d3 = ((long[]) d4.a.i(this.f))[i];
                d2 = d3 + ((d - i) * ((i == 99 ? 256.0d : r3[i + 1]) - d3));
            }
        }
        return new g.a(new u(s, this.a + k0.s(Math.round((d2 / 256.0d) * this.d), this.b, this.d - 1)));
    }

    public long f() {
        return this.e;
    }

    public boolean g() {
        return this.f != null;
    }

    public long i() {
        return this.c;
    }

    public i(long j, int i, long j2, long j3, long[] jArr) {
        this.a = j;
        this.b = i;
        this.c = j2;
        this.f = jArr;
        this.d = j3;
        this.e = j3 != -1 ? j + j3 : -1L;
    }
}
