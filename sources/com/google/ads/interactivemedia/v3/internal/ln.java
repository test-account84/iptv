package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ln implements uf {
    private final s a;
    private long[] b;
    private boolean c;
    private ly d;
    private boolean e;
    private int f;
    private final bdy h = new bdy((char[]) null);
    private long g = -9223372036854775807L;

    public ln(ly lyVar, s sVar, boolean z) {
        this.a = sVar;
        this.d = lyVar;
        this.b = (long[]) lyVar.b;
        f(lyVar, z);
    }

    public final int a(go goVar, ef efVar, int i) {
        int i2 = this.f;
        boolean z = i2 == this.b.length;
        if (z && !this.c) {
            efVar.c(4);
            return -4;
        }
        if ((i & 2) != 0 || !this.e) {
            goVar.b = this.a;
            this.e = true;
            return -5;
        }
        if (z) {
            return -3;
        }
        if ((i & 1) == 0) {
            this.f = i2 + 1;
        }
        if ((i & 4) == 0) {
            byte[] m = this.h.m(((aal[]) this.d.a)[i2]);
            efVar.i(m.length);
            efVar.b.put(m);
        }
        efVar.d = this.b[i2];
        efVar.c(1);
        return -4;
    }

    public final int b(long j) {
        int max = Math.max(this.f, cq.ao(this.b, j, true));
        int i = this.f;
        this.f = max;
        return max - i;
    }

    public final String c() {
        return this.d.a();
    }

    public final void d() throws IOException {
    }

    public final void e(long j) {
        int ao = cq.ao(this.b, j, true);
        this.f = ao;
        if (!this.c || ao != this.b.length) {
            j = -9223372036854775807L;
        }
        this.g = j;
    }

    public final void f(ly lyVar, boolean z) {
        int i = this.f;
        long j = i == 0 ? -9223372036854775807L : this.b[i - 1];
        this.c = z;
        this.d = lyVar;
        long[] jArr = (long[]) lyVar.b;
        this.b = jArr;
        long j2 = this.g;
        if (j2 != -9223372036854775807L) {
            e(j2);
        } else if (j != -9223372036854775807L) {
            this.f = cq.ao(jArr, j, false);
        }
    }

    public final boolean g() {
        return true;
    }
}
