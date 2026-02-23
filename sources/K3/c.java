package k3;

import android.util.Pair;
import com.google.android.exoplayer2.extractor.g;
import d3.u;
import d4.k0;
import v3.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements g {
    public final long[] a;
    public final long[] b;
    public final long c;

    public c(long[] jArr, long[] jArr2, long j) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j == -9223372036854775807L ? k0.P0(jArr2[jArr2.length - 1]) : j;
    }

    public static c a(long j, k kVar, long j2) {
        int length = kVar.f.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += kVar.d + kVar.f[i3];
            j3 += kVar.e + kVar.g[i3];
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new c(jArr, jArr2, j2);
    }

    public static Pair b(long j, long[] jArr, long[] jArr2) {
        Long valueOf;
        Long valueOf2;
        int i = k0.i(jArr, j, true, true);
        long j2 = jArr[i];
        long j3 = jArr2[i];
        int i2 = i + 1;
        if (i2 == jArr.length) {
            valueOf = Long.valueOf(j2);
            valueOf2 = Long.valueOf(j3);
        } else {
            long j4 = jArr[i2];
            long j5 = jArr2[i2];
            double d = j4 == j2 ? 0.0d : (j - j2) / (j4 - j2);
            valueOf = Long.valueOf(j);
            valueOf2 = Long.valueOf(((long) (d * (j5 - j3))) + j3);
        }
        return Pair.create(valueOf, valueOf2);
    }

    public long c(long j) {
        return k0.P0(((Long) b(j, this.a, this.b).second).longValue());
    }

    public g.a e(long j) {
        Pair b = b(k0.x1(k0.s(j, 0L, this.c)), this.b, this.a);
        return new g.a(new u(k0.P0(((Long) b.first).longValue()), ((Long) b.second).longValue()));
    }

    public long f() {
        return -1L;
    }

    public boolean g() {
        return true;
    }

    public long i() {
        return this.c;
    }
}
