package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class za implements aab {
    private final long a;
    private final long b;
    private final int c;
    private final long d;
    private final int e;
    private final long f;

    public za(long j, long j2, int i, int i2) {
        long b;
        this.a = j;
        this.b = j2;
        this.c = i2 == -1 ? 1 : i2;
        this.e = i;
        if (j == -1) {
            this.d = -1L;
            b = -9223372036854775807L;
        } else {
            this.d = j - j2;
            b = b(j, j2, i);
        }
        this.f = b;
    }

    private static long b(long j, long j2, int i) {
        return (Math.max(0L, j - j2) * 8000000) / i;
    }

    public final long B(long j) {
        return b(j, this.b, this.e);
    }

    public final long e() {
        return this.f;
    }

    public final zz g(long j) {
        long j2 = this.d;
        if (j2 == -1) {
            aac aacVar = new aac(0L, this.b);
            return new zz(aacVar, aacVar);
        }
        int i = this.e;
        long j3 = this.c;
        long j4 = (((i * j) / 8000000) / j3) * j3;
        if (j2 != -1) {
            j4 = Math.min(j4, j2 - j3);
        }
        long max = this.b + Math.max(j4, 0L);
        long B = B(max);
        aac aacVar2 = new aac(B, max);
        if (this.d != -1 && B < j) {
            long j5 = max + this.c;
            if (j5 < this.a) {
                return new zz(aacVar2, new aac(B(j5), j5));
            }
        }
        return new zz(aacVar2, aacVar2);
    }

    public final boolean h() {
        return this.d != -1;
    }
}
