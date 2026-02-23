package k3;

import Q2.b0;
import com.google.android.exoplayer2.extractor.g;
import d3.u;
import d4.B;
import d4.M;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h implements g {
    public final long[] a;
    public final long[] b;
    public final long c;
    public final long d;

    public h(long[] jArr, long[] jArr2, long j, long j2) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j;
        this.d = j2;
    }

    public static h a(long j, long j2, b0.a aVar, M m) {
        int H;
        m.V(10);
        int q = m.q();
        if (q <= 0) {
            return null;
        }
        int i = aVar.d;
        long c1 = k0.c1(q, (i >= 32000 ? 1152 : 576) * 1000000, i);
        int N = m.N();
        int N2 = m.N();
        int N3 = m.N();
        m.V(2);
        long j3 = j2 + aVar.c;
        long[] jArr = new long[N];
        long[] jArr2 = new long[N];
        int i2 = 0;
        long j4 = j2;
        while (i2 < N) {
            int i3 = N2;
            long j5 = j3;
            jArr[i2] = (i2 * c1) / N;
            jArr2[i2] = Math.max(j4, j5);
            if (N3 == 1) {
                H = m.H();
            } else if (N3 == 2) {
                H = m.N();
            } else if (N3 == 3) {
                H = m.K();
            } else {
                if (N3 != 4) {
                    return null;
                }
                H = m.L();
            }
            j4 += H * i3;
            i2++;
            jArr = jArr;
            N2 = i3;
            j3 = j5;
        }
        long[] jArr3 = jArr;
        if (j != -1 && j != j4) {
            B.j("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new h(jArr3, jArr2, c1, j4);
    }

    public long c(long j) {
        return this.a[k0.i(this.b, j, true, true)];
    }

    public g.a e(long j) {
        int i = k0.i(this.a, j, true, true);
        u uVar = new u(this.a[i], this.b[i]);
        if (uVar.a >= j || i == this.a.length - 1) {
            return new g.a(uVar);
        }
        int i2 = i + 1;
        return new g.a(uVar, new u(this.a[i2], this.b[i2]));
    }

    public long f() {
        return this.d;
    }

    public boolean g() {
        return true;
    }

    public long i() {
        return this.c;
    }
}
