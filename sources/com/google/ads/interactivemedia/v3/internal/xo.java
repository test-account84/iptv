package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class xo {
    private boolean c;
    private int e;
    private xn a = new xn();
    private xn b = new xn();
    private long d = -9223372036854775807L;

    public final float a() {
        if (g()) {
            return (float) (1.0E9d / this.a.a());
        }
        return -1.0f;
    }

    public final int b() {
        return this.e;
    }

    public final long c() {
        if (g()) {
            return this.a.a();
        }
        return -9223372036854775807L;
    }

    public final long d() {
        if (g()) {
            return this.a.b();
        }
        return -9223372036854775807L;
    }

    public final void e(long j) {
        this.a.c(j);
        if (this.a.f()) {
            this.c = false;
        } else if (this.d != -9223372036854775807L) {
            if (!this.c || this.b.e()) {
                this.b.d();
                this.b.c(this.d);
            }
            this.c = true;
            this.b.c(j);
        }
        if (this.c && this.b.f()) {
            xn xnVar = this.a;
            this.a = this.b;
            this.b = xnVar;
            this.c = false;
        }
        this.d = j;
        this.e = this.a.f() ? 0 : this.e + 1;
    }

    public final void f() {
        this.a.d();
        this.b.d();
        this.c = false;
        this.d = -9223372036854775807L;
        this.e = 0;
    }

    public final boolean g() {
        return this.a.f();
    }
}
