package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class es {
    private final wr a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private int g;
    private boolean h;

    public es() {
        wr wrVar = new wr();
        i(2500, 0, "bufferForPlaybackMs", "0");
        i(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        i(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        i(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        i(50000, 50000, "maxBufferMs", "minBufferMs");
        i(0, 0, "backBufferDurationMs", "0");
        this.a = wrVar;
        this.b = cq.t(50000L);
        this.c = cq.t(50000L);
        this.d = cq.t(2500L);
        this.e = cq.t(5000L);
        this.g = 13107200;
        this.f = cq.t(0L);
    }

    private static void i(int i, int i2, String str, String str2) {
        af.v(i >= i2, str + " cannot be less than " + str2);
    }

    private final void j(boolean z) {
        this.g = 13107200;
        this.h = false;
        if (z) {
            this.a.c();
        }
    }

    public final long a() {
        return this.f;
    }

    public final void b() {
        j(false);
    }

    public final void c() {
        j(true);
    }

    public final void d() {
        j(true);
    }

    public final boolean e(long j, float f, boolean z, long j2) {
        long s = cq.s(j, f);
        long j3 = z ? this.e : this.d;
        if (j2 != -9223372036854775807L) {
            j3 = Math.min(j2 / 2, j3);
        }
        return j3 <= 0 || s >= j3 || this.a.a() >= this.g;
    }

    public final wr f() {
        return this.a;
    }

    public final void g(hh[] hhVarArr, we[] weVarArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int length = hhVarArr.length;
            if (i >= 2) {
                int max = Math.max(13107200, i2);
                this.g = max;
                this.a.d(max);
                return;
            } else {
                if (weVarArr[i] != null) {
                    i2 += hhVarArr[i].b() != 1 ? 131072000 : 13107200;
                }
                i++;
            }
        }
    }

    public final boolean h(long j, float f) {
        int a = this.a.a();
        int i = this.g;
        long j2 = this.b;
        if (f > 1.0f) {
            j2 = Math.min(cq.q(j2, f), this.c);
        }
        if (j < Math.max(j2, 500000L)) {
            boolean z = a < i;
            this.h = z;
            if (!z && j < 500000) {
                cd.e("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j >= this.c || a >= i) {
            this.h = false;
        }
        return this.h;
    }
}
