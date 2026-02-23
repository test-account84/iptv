package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class jt {
    private long A;
    private long B;
    private long C;
    private boolean D;
    private long E;
    private long F;
    private final js a;
    private final long[] b;
    private AudioTrack c;
    private int d;
    private int e;
    private jr f;
    private int g;
    private boolean h;
    private long i;
    private float j;
    private boolean k;
    private long l;
    private long m;
    private Method n;
    private long o;
    private boolean p;
    private boolean q;
    private long r;
    private long s;
    private long t;
    private long u;
    private int v;
    private int w;
    private long x;
    private long y;
    private long z;

    public jt(js jsVar) {
        this.a = jsVar;
        if (cq.a >= 18) {
            try {
                this.n = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.b = new long[10];
    }

    private final long l(long j) {
        return (j * 1000000) / this.g;
    }

    private final long m() {
        AudioTrack audioTrack = this.c;
        af.s(audioTrack);
        if (this.x != -9223372036854775807L) {
            return Math.min(this.A, this.z + ((((SystemClock.elapsedRealtime() * 1000) - this.x) * this.g) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        long j = 0;
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (this.h) {
            if (playState == 2) {
                if (playbackHeadPosition == 0) {
                    this.u = this.s;
                }
                playState = 2;
            }
            playbackHeadPosition += this.u;
        }
        if (cq.a <= 29) {
            if (playbackHeadPosition != 0) {
                j = playbackHeadPosition;
            } else if (this.s > 0 && playState == 3) {
                if (this.y == -9223372036854775807L) {
                    this.y = SystemClock.elapsedRealtime();
                }
                return this.s;
            }
            this.y = -9223372036854775807L;
            playbackHeadPosition = j;
        }
        if (this.s > playbackHeadPosition) {
            this.t++;
        }
        this.s = playbackHeadPosition;
        return playbackHeadPosition + (this.t << 32);
    }

    private final long n() {
        return l(m());
    }

    private final void o() {
        this.l = 0L;
        this.w = 0;
        this.v = 0;
        this.m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.k = false;
    }

    public final int a(long j) {
        return this.e - ((int) (j - (m() * this.d)));
    }

    public final long b(boolean z) {
        long n;
        Method method;
        AudioTrack audioTrack = this.c;
        af.s(audioTrack);
        if (audioTrack.getPlayState() == 3) {
            long n2 = n();
            if (n2 != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.m >= 30000) {
                    long[] jArr = this.b;
                    int i = this.v;
                    jArr[i] = n2 - nanoTime;
                    this.v = (i + 1) % 10;
                    int i2 = this.w;
                    if (i2 < 10) {
                        this.w = i2 + 1;
                    }
                    this.m = nanoTime;
                    this.l = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.w;
                        if (i3 >= i4) {
                            break;
                        }
                        this.l += this.b[i3] / i4;
                        i3++;
                    }
                }
                if (!this.h) {
                    jr jrVar = this.f;
                    af.s(jrVar);
                    if (jrVar.g(nanoTime)) {
                        long b = jrVar.b();
                        long a = jrVar.a();
                        if (Math.abs(b - nanoTime) > 5000000) {
                            this.a.d(a, b, nanoTime, n2);
                        } else if (Math.abs(l(a) - n2) > 5000000) {
                            this.a.c(a, b, nanoTime, n2);
                        } else {
                            jrVar.c();
                        }
                        jrVar.d();
                    }
                    if (this.q && (method = this.n) != null && nanoTime - this.r >= 500000) {
                        try {
                            AudioTrack audioTrack2 = this.c;
                            af.s(audioTrack2);
                            Integer num = (Integer) method.invoke(audioTrack2, (Object[]) null);
                            int i5 = cq.a;
                            long intValue = (num.intValue() * 1000) - this.i;
                            this.o = intValue;
                            long max = Math.max(intValue, 0L);
                            this.o = max;
                            if (max > 5000000) {
                                this.a.a(max);
                                this.o = 0L;
                            }
                        } catch (Exception unused) {
                            this.n = null;
                        }
                        this.r = nanoTime;
                    }
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        jr jrVar2 = this.f;
        af.s(jrVar2);
        boolean f = jrVar2.f();
        if (f) {
            n = l(jrVar2.a()) + cq.q(nanoTime2 - jrVar2.b(), this.j);
        } else {
            n = this.w == 0 ? n() : this.l + nanoTime2;
            if (!z) {
                n = Math.max(0L, n - this.o);
            }
        }
        if (this.D != f) {
            this.F = this.C;
            this.E = this.B;
        }
        long j = nanoTime2 - this.F;
        if (j < 1000000) {
            long j2 = (j * 1000) / 1000000;
            n = ((n * j2) + ((1000 - j2) * (this.E + cq.q(j, this.j)))) / 1000;
        }
        if (!this.k) {
            long j3 = this.B;
            if (n > j3) {
                this.k = true;
                this.a.b(System.currentTimeMillis() - cq.x(cq.s(cq.x(n - j3), this.j)));
            }
        }
        this.C = nanoTime2;
        this.B = n;
        this.D = f;
        return n;
    }

    public final void c(long j) {
        this.z = m();
        this.x = SystemClock.elapsedRealtime() * 1000;
        this.A = j;
    }

    public final void d() {
        o();
        this.c = null;
        this.f = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(android.media.AudioTrack r3, boolean r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.c = r3
            r2.d = r6
            r2.e = r7
            com.google.ads.interactivemedia.v3.internal.jr r0 = new com.google.ads.interactivemedia.v3.internal.jr
            r0.<init>(r3)
            r2.f = r0
            int r3 = r3.getSampleRate()
            r2.g = r3
            r3 = 0
            if (r4 == 0) goto L24
            int r4 = com.google.ads.interactivemedia.v3.internal.cq.a
            r0 = 23
            if (r4 >= r0) goto L24
            r4 = 5
            r0 = 1
            if (r5 == r4) goto L25
            r4 = 6
            if (r5 != r4) goto L24
            goto L25
        L24:
            r0 = 0
        L25:
            r2.h = r0
            boolean r4 = com.google.ads.interactivemedia.v3.internal.cq.Y(r5)
            r2.q = r4
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L3b
            int r7 = r7 / r6
            long r4 = (long) r7
            long r4 = r2.l(r4)
            goto L3c
        L3b:
            r4 = r0
        L3c:
            r2.i = r4
            r4 = 0
            r2.s = r4
            r2.t = r4
            r2.u = r4
            r2.p = r3
            r2.x = r0
            r2.y = r0
            r2.r = r4
            r2.o = r4
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.j = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.jt.e(android.media.AudioTrack, boolean, int, int, int):void");
    }

    public final void f() {
        jr jrVar = this.f;
        af.s(jrVar);
        jrVar.e();
    }

    public final boolean g(long j) {
        if (j > m()) {
            return true;
        }
        if (!this.h) {
            return false;
        }
        AudioTrack audioTrack = this.c;
        af.s(audioTrack);
        return audioTrack.getPlayState() == 2 && m() == 0;
    }

    public final boolean h() {
        AudioTrack audioTrack = this.c;
        af.s(audioTrack);
        return audioTrack.getPlayState() == 3;
    }

    public final boolean i(long j) {
        return this.y != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.y >= 200;
    }

    public final boolean j(long j) {
        AudioTrack audioTrack = this.c;
        af.s(audioTrack);
        int playState = audioTrack.getPlayState();
        if (this.h) {
            if (playState == 2) {
                this.p = false;
                return false;
            }
            if (playState == 1) {
                if (m() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z = this.p;
        boolean g = g(j);
        this.p = g;
        if (z && !g && playState != 1) {
            this.a.e(this.e, cq.x(this.i));
        }
        return true;
    }

    public final boolean k() {
        o();
        if (this.x != -9223372036854775807L) {
            return false;
        }
        jr jrVar = this.f;
        af.s(jrVar);
        jrVar.e();
        return true;
    }
}
