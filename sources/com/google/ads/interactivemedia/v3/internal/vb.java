package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class vb extends up {
    private final int c;
    private final long d;
    private final uv e;
    private long p;
    private volatile boolean q;
    private boolean r;

    public vb(cy cyVar, dc dcVar, s sVar, int i, long j, long j2, long j3, long j4, long j5, int i2, long j6, uv uvVar) {
        super(cyVar, dcVar, sVar, i, j, j2, j3, j4, j5);
        this.c = i2;
        this.d = j6;
        this.e = uvVar;
    }

    public final void e() throws IOException {
        if (this.p == 0) {
            zo c = c();
            c.a(this.d);
            uv uvVar = this.e;
            long j = this.a;
            long j2 = j == -9223372036854775807L ? -9223372036854775807L : j - this.d;
            long j3 = this.b;
            uvVar.e(c, j2, j3 == -9223372036854775807L ? -9223372036854775807L : j3 - this.d);
        }
        try {
            dc b = this.g.b(this.p);
            dv dvVar = this.n;
            zb zbVar = new zb(dvVar, b.e, dvVar.b(b));
            do {
                try {
                    if (this.q) {
                        break;
                    }
                } finally {
                    this.p = zbVar.d() - this.g.e;
                }
            } while (this.e.c(zbVar));
            af.e(this.n);
            this.r = !this.q;
        } catch (Throwable th) {
            af.e(this.n);
            throw th;
        }
    }

    public final boolean g() {
        return this.r;
    }

    public final void r() {
        this.q = true;
    }

    public final long s() {
        return this.o + this.c;
    }
}
