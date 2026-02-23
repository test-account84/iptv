package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class yu {
    private final long a;
    private final long b;
    private final long c;
    private long d = 0;
    private long e;
    private long f;
    private long g;
    private long h;

    public yu(long j, long j2, long j3, long j4, long j5, long j6) {
        this.a = j;
        this.b = j2;
        this.e = j3;
        this.f = j4;
        this.g = j5;
        this.c = j6;
        this.h = f(j2, 0L, j3, j4, j5, j6);
    }

    public static /* synthetic */ long a(yu yuVar) {
        return yuVar.g;
    }

    public static /* synthetic */ long b(yu yuVar) {
        return yuVar.f;
    }

    public static /* synthetic */ long c(yu yuVar) {
        return yuVar.h;
    }

    public static /* synthetic */ long d(yu yuVar) {
        return yuVar.a;
    }

    public static /* synthetic */ long e(yu yuVar) {
        return yuVar.b;
    }

    public static long f(long j, long j2, long j3, long j4, long j5, long j6) {
        if (j4 + 1 >= j5 || 1 + j2 >= j3) {
            return j4;
        }
        long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
        return cq.p(((j4 + j7) - j6) - (j7 / 20), j4, (-1) + j5);
    }

    public static /* bridge */ /* synthetic */ void g(yu yuVar, long j, long j2) {
        yuVar.e = j;
        yuVar.g = j2;
        yuVar.i();
    }

    public static /* bridge */ /* synthetic */ void h(yu yuVar, long j, long j2) {
        yuVar.d = j;
        yuVar.f = j2;
        yuVar.i();
    }

    private final void i() {
        this.h = f(this.b, this.d, this.e, this.f, this.g, this.c);
    }
}
