package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aca implements abz {
    private final long[] a;
    private final long[] b;
    private final long c;
    private final long d;

    private aca(long[] jArr, long[] jArr2, long j, long j2) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j;
        this.d = j2;
    }

    public static aca c(long j, long j2, zr zrVar, cj cjVar) {
        int i;
        cjVar.G(10);
        int e = cjVar.e();
        if (e <= 0) {
            return null;
        }
        int i2 = zrVar.d;
        long w = cq.w(e, (i2 >= 32000 ? 1152 : 576) * 1000000, i2);
        int m = cjVar.m();
        int m2 = cjVar.m();
        int m3 = cjVar.m();
        cjVar.G(2);
        long j3 = j2 + zrVar.c;
        long[] jArr = new long[m];
        long[] jArr2 = new long[m];
        int i3 = 0;
        long j4 = j2;
        while (i3 < m) {
            int i4 = m2;
            long j5 = j3;
            jArr[i3] = (i3 * w) / m;
            jArr2[i3] = Math.max(j4, j5);
            if (m3 == 1) {
                i = cjVar.i();
            } else if (m3 == 2) {
                i = cjVar.m();
            } else if (m3 == 3) {
                i = cjVar.k();
            } else {
                if (m3 != 4) {
                    return null;
                }
                i = cjVar.l();
            }
            j4 += i * i4;
            i3++;
            jArr = jArr;
            m2 = i4;
            j3 = j5;
        }
        long[] jArr3 = jArr;
        if (j != -1 && j != j4) {
            cd.e("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new aca(jArr3, jArr2, w, j4);
    }

    public final long a() {
        return this.d;
    }

    public final long b(long j) {
        return this.a[cq.aq(this.b, j, true)];
    }

    public final long e() {
        return this.c;
    }

    public final zz g(long j) {
        int aq = cq.aq(this.a, j, true);
        aac aacVar = new aac(this.a[aq], this.b[aq]);
        if (aacVar.b < j) {
            long[] jArr = this.a;
            if (aq != jArr.length - 1) {
                int i = aq + 1;
                return new zz(aacVar, new aac(jArr[i], this.b[i]));
            }
        }
        return new zz(aacVar, aacVar);
    }

    public final boolean h() {
        return true;
    }
}
