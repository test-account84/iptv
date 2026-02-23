package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class co {
    private long a;
    private long b;
    private long c;
    private final ThreadLocal d = new ThreadLocal();

    public co(long j) {
        h(j);
    }

    public static long f(long j) {
        return (j * 1000000) / 90000;
    }

    public static long g(long j) {
        return (j * 90000) / 1000000;
    }

    public final synchronized long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (this.b == -9223372036854775807L) {
                long j2 = this.a;
                if (j2 == 9223372036854775806L) {
                    Long l = (Long) this.d.get();
                    af.s(l);
                    j2 = l.longValue();
                }
                this.b = j2 - j;
                notifyAll();
            }
            this.c = j;
            return j + this.b;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j2 = this.c;
            if (j2 != -9223372036854775807L) {
                long g = g(j2);
                long j3 = (4294967296L + g) / 8589934592L;
                long j4 = (((-1) + j3) * 8589934592L) + j;
                j += j3 * 8589934592L;
                if (Math.abs(j4 - g) < Math.abs(j - g)) {
                    j = j4;
                }
            }
            return a(f(j));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long c() {
        long j = this.a;
        if (j == Long.MAX_VALUE || j == 9223372036854775806L) {
            return -9223372036854775807L;
        }
        return j;
    }

    public final synchronized long d() {
        long j;
        try {
            j = this.c;
        } catch (Throwable th) {
            throw th;
        }
        return j != -9223372036854775807L ? j + this.b : c();
    }

    public final synchronized long e() {
        return this.b;
    }

    public final synchronized void h(long j) {
        this.a = j;
        this.b = j == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.c = -9223372036854775807L;
    }

    public final synchronized void i(boolean z, long j) throws InterruptedException {
        af.w(this.a == 9223372036854775806L);
        if (this.b != -9223372036854775807L) {
            return;
        }
        if (z) {
            this.d.set(Long.valueOf(j));
        } else {
            while (this.b == -9223372036854775807L) {
                wait();
            }
        }
    }
}
