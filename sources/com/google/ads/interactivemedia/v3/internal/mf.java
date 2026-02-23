package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class mf extends mk {
    final long a;
    final long b;
    final List c;
    final long d;
    private final long e;
    private final long f;

    public mf(mb mbVar, long j, long j2, long j3, long j4, List list, long j5, long j6, long j7) {
        super(mbVar, j, j2);
        this.a = j3;
        this.b = j4;
        this.c = list;
        this.d = j5;
        this.e = j6;
        this.f = j7;
    }

    public final long a(long j, long j2) {
        long c = c(j);
        return c != -1 ? c : (int) (e((j2 - this.f) + this.d, j) - b(j, j2));
    }

    public final long b(long j, long j2) {
        if (c(j) == -1) {
            long j3 = this.e;
            if (j3 != -9223372036854775807L) {
                return Math.max(this.a, e((j2 - this.f) - j3, j));
            }
        }
        return this.a;
    }

    public abstract long c(long j);

    public final long d(long j, long j2) {
        List list = this.c;
        if (list != null) {
            return (((mi) list.get((int) (j - this.a))).b * 1000000) / this.i;
        }
        long c = c(j2);
        return (c == -1 || j != (this.a + c) + (-1)) ? (this.b * 1000000) / this.i : j2 - f(j);
    }

    public final long e(long j, long j2) {
        long j3 = this.a;
        long c = c(j2);
        if (c == 0) {
            return j3;
        }
        if (this.c == null) {
            long j4 = this.a + (j / ((this.b * 1000000) / this.i));
            return j4 < j3 ? j3 : c != -1 ? Math.min(j4, (j3 + c) - 1) : j4;
        }
        long j5 = (c + j3) - 1;
        long j6 = j3;
        while (j6 <= j5) {
            long j7 = ((j5 - j6) / 2) + j6;
            long f = f(j7);
            if (f < j) {
                j6 = 1 + j7;
            } else {
                if (f <= j) {
                    return j7;
                }
                j5 = j7 - 1;
            }
        }
        return j6 == j3 ? j6 : j5;
    }

    public final long f(long j) {
        List list = this.c;
        return cq.w(list != null ? ((mi) list.get((int) (j - this.a))).a - this.j : (j - this.a) * this.b, 1000000L, this.i);
    }

    public abstract mb g(me meVar, long j);

    public boolean h() {
        return this.c != null;
    }
}
