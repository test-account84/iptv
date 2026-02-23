package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class acb implements abz {
    private final long a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;
    private final long[] f;

    private acb(long j, int i, long j2, long j3, long[] jArr) {
        this.a = j;
        this.b = i;
        this.c = j2;
        this.f = jArr;
        this.d = j3;
        this.e = j3 != -1 ? j + j3 : -1L;
    }

    public static acb c(long j, long j2, zr zrVar, cj cjVar) {
        int l;
        int i = zrVar.g;
        int i2 = zrVar.d;
        int e = cjVar.e();
        if ((e & 1) != 1 || (l = cjVar.l()) == 0) {
            return null;
        }
        long w = cq.w(l, i * 1000000, i2);
        if ((e & 6) != 6) {
            return new acb(j2, zrVar.c, w, -1L, null);
        }
        long p = cjVar.p();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = cjVar.i();
        }
        if (j != -1) {
            long j3 = j2 + p;
            if (j != j3) {
                cd.e("XingSeeker", "XING data size mismatch: " + j + ", " + j3);
            }
        }
        return new acb(j2, zrVar.c, w, p, jArr);
    }

    private final long d(int i) {
        return (this.c * i) / 100;
    }

    public final long a() {
        return this.e;
    }

    public final long b(long j) {
        long j2 = j - this.a;
        if (!h() || j2 <= this.b) {
            return 0L;
        }
        long[] jArr = (long[]) af.t(this.f);
        double d = (j2 * 256.0d) / this.d;
        int aq = cq.aq(jArr, (long) d, true);
        long d2 = d(aq);
        long j3 = jArr[aq];
        int i = aq + 1;
        long d3 = d(i);
        return d2 + Math.round((j3 == (aq == 99 ? 256L : jArr[i]) ? 0.0d : (d - j3) / (r0 - j3)) * (d3 - d2));
    }

    public final long e() {
        return this.c;
    }

    public final zz g(long j) {
        if (!h()) {
            aac aacVar = new aac(0L, this.a + this.b);
            return new zz(aacVar, aacVar);
        }
        long p = cq.p(j, 0L, this.c);
        double d = (p * 100.0d) / this.c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                double d3 = ((long[]) af.t(this.f))[i];
                d2 = d3 + ((d - i) * ((i == 99 ? 256.0d : r3[i + 1]) - d3));
            }
        }
        aac aacVar2 = new aac(p, this.a + cq.p(Math.round((d2 / 256.0d) * this.d), this.b, this.d - 1));
        return new zz(aacVar2, aacVar2);
    }

    public final boolean h() {
        return this.f != null;
    }
}
