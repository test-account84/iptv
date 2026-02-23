package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.view.Display;
import android.view.Surface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class yb {
    private final xo a = new xo();
    private final xx b;
    private final ya c;
    private boolean d;
    private Surface e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;

    public yb(Context context) {
        xx xxVar;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            xxVar = cq.a >= 17 ? xz.c(applicationContext) : null;
            if (xxVar == null) {
                xxVar = xy.c(applicationContext);
            }
        } else {
            xxVar = null;
        }
        this.b = xxVar;
        this.c = xxVar != null ? ya.a() : null;
        this.k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.f = -1.0f;
        this.i = 1.0f;
        this.j = 0;
    }

    public static /* synthetic */ void b(yb ybVar, Display display) {
        long j;
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            ybVar.k = refreshRate;
            j = (refreshRate * 80) / 100;
        } else {
            cd.e("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            j = -9223372036854775807L;
            ybVar.k = -9223372036854775807L;
        }
        ybVar.l = j;
    }

    private final void k() {
        Surface surface;
        if (cq.a < 30 || (surface = this.e) == null || this.j == Integer.MIN_VALUE || this.h == 0.0f) {
            return;
        }
        this.h = 0.0f;
        xw.a(surface, 0.0f);
    }

    private final void l() {
        this.m = 0L;
        this.p = -1L;
        this.n = -1L;
    }

    private final void m() {
        if (cq.a < 30 || this.e == null) {
            return;
        }
        float a = this.a.g() ? this.a.a() : this.f;
        float f = this.g;
        if (a == f) {
            return;
        }
        if (a != -1.0f && f != -1.0f) {
            float f2 = 1.0f;
            if (this.a.g() && this.a.d() >= 5000000000L) {
                f2 = 0.02f;
            }
            if (Math.abs(a - this.g) < f2) {
                return;
            }
        } else if (a == -1.0f && this.a.b() < 30) {
            return;
        }
        this.g = a;
        n(false);
    }

    private final void n(boolean z) {
        Surface surface;
        if (cq.a < 30 || (surface = this.e) == null || this.j == Integer.MIN_VALUE) {
            return;
        }
        float f = 0.0f;
        if (this.d) {
            float f2 = this.g;
            if (f2 != -1.0f) {
                f = this.i * f2;
            }
        }
        if (z || this.h != f) {
            this.h = f;
            xw.a(surface, f);
        }
    }

    public final long a(long j) {
        long j2;
        if (this.p != -1 && this.a.g()) {
            long c = this.q + ((long) ((this.a.c() * (this.m - this.p)) / this.i));
            if (Math.abs(j - c) <= 20000000) {
                j = c;
            } else {
                l();
            }
        }
        this.n = this.m;
        this.o = j;
        ya yaVar = this.c;
        if (yaVar == null || this.k == -9223372036854775807L) {
            return j;
        }
        long j3 = yaVar.a;
        if (j3 == -9223372036854775807L) {
            return j;
        }
        long j4 = this.k;
        long j5 = j3 + (((j - j3) / j4) * j4);
        if (j <= j5) {
            j2 = j5 - j4;
        } else {
            j5 = j4 + j5;
            j2 = j5;
        }
        if (j5 - j >= j - j2) {
            j5 = j2;
        }
        return j5 - this.l;
    }

    public final void c(float f) {
        this.f = f;
        this.a.f();
        m();
    }

    public final void d(long j) {
        long j2 = this.n;
        if (j2 != -1) {
            this.p = j2;
            this.q = this.o;
        }
        this.m++;
        this.a.e(j * 1000);
        m();
    }

    public final void e(float f) {
        this.i = f;
        l();
        n(false);
    }

    public final void f() {
        l();
    }

    public final void g() {
        this.d = true;
        l();
        if (this.b != null) {
            ya yaVar = this.c;
            af.s(yaVar);
            yaVar.b();
            this.b.b(new xv(this));
        }
        n(false);
    }

    public final void h() {
        this.d = false;
        xx xxVar = this.b;
        if (xxVar != null) {
            xxVar.a();
            ya yaVar = this.c;
            af.s(yaVar);
            yaVar.c();
        }
        k();
    }

    public final void i(Surface surface) {
        if (true == (surface instanceof xt)) {
            surface = null;
        }
        if (this.e == surface) {
            return;
        }
        k();
        this.e = surface;
        n(true);
    }

    public final void j(int i) {
        if (this.j == i) {
            return;
        }
        this.j = i;
        n(true);
    }
}
