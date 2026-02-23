package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class vh extends up {
    private final int c;
    private final s d;
    private long e;
    private boolean p;

    public vh(cy cyVar, dc dcVar, s sVar, int i, long j, long j2, long j3, int i2, s sVar2) {
        super(cyVar, dcVar, sVar, i, j, j2, -9223372036854775807L, -9223372036854775807L, j3);
        this.c = i2;
        this.d = sVar2;
    }

    public final void e() throws IOException {
        zo c = c();
        c.a(0L);
        aae c2 = c.c(this.c);
        c2.b(this.d);
        try {
            long b = this.n.b(this.g.b(this.e));
            if (b != -1) {
                b += this.e;
            }
            zb zbVar = new zb(this.n, this.e, b);
            for (int i = 0; i != -1; i = c2.a(zbVar, Integer.MAX_VALUE, true)) {
                this.e += i;
            }
            c2.f(this.l, 1, (int) this.e, 0, null);
            af.e(this.n);
            this.p = true;
        } catch (Throwable th) {
            af.e(this.n);
            throw th;
        }
    }

    public final boolean g() {
        return this.p;
    }

    public final void r() {
    }
}
