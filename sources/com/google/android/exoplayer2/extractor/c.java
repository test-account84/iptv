package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.g;
import d3.u;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class c implements g {
    public final long a;
    public final long b;
    public final int c;
    public final long d;
    public final int e;
    public final long f;
    public final boolean g;

    public c(long j, long j2, int i, int i2, boolean z) {
        long d;
        this.a = j;
        this.b = j2;
        this.c = i2 == -1 ? 1 : i2;
        this.e = i;
        this.g = z;
        if (j == -1) {
            this.d = -1L;
            d = -9223372036854775807L;
        } else {
            this.d = j - j2;
            d = d(j, j2, i);
        }
        this.f = d;
    }

    public static long d(long j, long j2, int i) {
        return (Math.max(0L, j - j2) * 8000000) / i;
    }

    public final long a(long j) {
        int i = this.c;
        long j2 = (((j * this.e) / 8000000) / i) * i;
        long j3 = this.d;
        if (j3 != -1) {
            j2 = Math.min(j2, j3 - i);
        }
        return this.b + Math.max(j2, 0L);
    }

    public long b(long j) {
        return d(j, this.b, this.e);
    }

    public g.a e(long j) {
        if (this.d == -1 && !this.g) {
            return new g.a(new u(0L, this.b));
        }
        long a = a(j);
        long b = b(a);
        u uVar = new u(b, a);
        if (this.d != -1 && b < j) {
            int i = this.c;
            if (i + a < this.a) {
                long j2 = a + i;
                return new g.a(uVar, new u(b(j2), j2));
            }
        }
        return new g.a(uVar);
    }

    public boolean g() {
        return this.d != -1 || this.g;
    }

    public long i() {
        return this.f;
    }
}
