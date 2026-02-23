package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class pd implements uf {
    private final int a;
    private final pk b;
    private int c = -1;

    public pd(pk pkVar, int i) {
        this.b = pkVar;
        this.a = i;
    }

    private final boolean f() {
        int i = this.c;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    public final int a(go goVar, ef efVar, int i) {
        int i2 = this.c;
        if (i2 == -3) {
            efVar.a(4);
            return -4;
        }
        if (f()) {
            return this.b.e(i2, goVar, efVar, i);
        }
        return -3;
    }

    public final int b(long j) {
        if (f()) {
            return this.b.f(this.c, j);
        }
        return 0;
    }

    public final void c() {
        af.u(this.c == -1);
        this.c = this.b.d(this.a);
    }

    public final void d() throws IOException {
        int i = this.c;
        if (i == -2) {
            throw new po(this.b.h().b(this.a).b(0).l);
        }
        if (i == -1) {
            this.b.q();
        } else if (i != -3) {
            this.b.r(i);
        }
    }

    public final void e() {
        if (this.c != -1) {
            this.b.B(this.a);
            this.c = -1;
        }
    }

    public final boolean g() {
        int i = this.c;
        if (i != -3) {
            return f() && this.b.C(i);
        }
        return true;
    }
}
