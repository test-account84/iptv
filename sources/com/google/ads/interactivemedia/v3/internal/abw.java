package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class abw implements abz {
    private final long[] a;
    private final long[] b;
    private final long c;

    private abw(long[] jArr, long[] jArr2, long j) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j == -9223372036854775807L ? cq.t(jArr2[jArr2.length - 1]) : j;
    }

    public static abw c(long j, abc abcVar, long j2) {
        int length = abcVar.d.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += abcVar.b + abcVar.d[i3];
            j3 += abcVar.c + abcVar.e[i3];
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new abw(jArr, jArr2, j2);
    }

    private static Pair d(long j, long[] jArr, long[] jArr2) {
        Long valueOf;
        Long valueOf2;
        int aq = cq.aq(jArr, j, true);
        long j2 = jArr[aq];
        long j3 = jArr2[aq];
        int i = aq + 1;
        if (i == jArr.length) {
            valueOf = Long.valueOf(j2);
            valueOf2 = Long.valueOf(j3);
        } else {
            long j4 = jArr[i];
            long j5 = jArr2[i];
            double d = j4 == j2 ? 0.0d : (j - j2) / (j4 - j2);
            valueOf = Long.valueOf(j);
            valueOf2 = Long.valueOf(((long) (d * (j5 - j3))) + j3);
        }
        return Pair.create(valueOf, valueOf2);
    }

    public final long a() {
        return -1L;
    }

    public final long b(long j) {
        return cq.t(((Long) d(j, this.a, this.b).second).longValue());
    }

    public final long e() {
        return this.c;
    }

    public final zz g(long j) {
        Pair d = d(cq.x(cq.p(j, 0L, this.c)), this.b, this.a);
        long longValue = ((Long) d.first).longValue();
        aac aacVar = new aac(cq.t(longValue), ((Long) d.second).longValue());
        return new zz(aacVar, aacVar);
    }

    public final boolean h() {
        return true;
    }
}
