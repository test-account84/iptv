package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aek implements yx {
    private final co a;
    private final int c;
    private final int d = 112800;
    private final cj b = new cj();

    public aek(int i, co coVar, int i2) {
        this.c = i;
        this.a = coVar;
    }

    public final yw a(zi ziVar, long j) throws IOException {
        int f;
        int f2;
        long j2;
        long d = ziVar.d();
        int min = (int) Math.min(112800L, ziVar.b() - d);
        this.b.B(min);
        ziVar.f(this.b.H(), 0, min);
        cj cjVar = this.b;
        int d2 = cjVar.d();
        long j3 = -1;
        long j4 = -1;
        long j5 = -9223372036854775807L;
        while (cjVar.a() >= 188 && (f2 = (f = afe.f(cjVar.H(), cjVar.c(), d2)) + 188) <= d2) {
            long g = afe.g(cjVar, f, this.c);
            if (g != -9223372036854775807L) {
                long b = this.a.b(g);
                if (b > j) {
                    if (j5 == -9223372036854775807L) {
                        return yw.d(b, d);
                    }
                    j2 = d + j4;
                } else if (100000 + b > j) {
                    j2 = d + f;
                } else {
                    j4 = f;
                    j5 = b;
                }
                return yw.e(j2);
            }
            cjVar.F(f2);
            j3 = f2;
        }
        return j5 != -9223372036854775807L ? yw.f(j5, d + j3) : yw.a;
    }

    public final void b() {
        this.b.C(cq.f);
    }
}
