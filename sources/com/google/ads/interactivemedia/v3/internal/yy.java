package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class yy {
    protected final ys a;
    protected final yx b;
    protected yu c;
    private final int d;

    public yy(yv yvVar, yx yxVar, long j, long j2, long j3, long j4, long j5, int i) {
        this.b = yxVar;
        this.d = i;
        this.a = new ys(yvVar, j, j2, j3, j4, j5);
    }

    public static final int f(zi ziVar, long j, zy zyVar) {
        if (j == ziVar.d()) {
            return 0;
        }
        zyVar.a = j;
        return 1;
    }

    public static final boolean g(zi ziVar, long j) throws IOException {
        long d = j - ziVar.d();
        if (d < 0 || d > 262144) {
            return false;
        }
        ziVar.i((int) d);
        return true;
    }

    public final int a(zi ziVar, zy zyVar) throws IOException {
        while (true) {
            yu yuVar = this.c;
            af.t(yuVar);
            long b = yu.b(yuVar);
            long a = yu.a(yuVar);
            long c = yu.c(yuVar);
            if (a - b <= this.d) {
                e();
                return f(ziVar, b, zyVar);
            }
            if (!g(ziVar, c)) {
                return f(ziVar, c, zyVar);
            }
            ziVar.h();
            yw a2 = this.b.a(ziVar, yu.e(yuVar));
            int a3 = yw.a(a2);
            if (a3 == -3) {
                e();
                return f(ziVar, c, zyVar);
            }
            if (a3 == -2) {
                yu.h(yuVar, yw.c(a2), yw.b(a2));
            } else {
                if (a3 != -1) {
                    g(ziVar, yw.b(a2));
                    e();
                    return f(ziVar, yw.b(a2), zyVar);
                }
                yu.g(yuVar, yw.c(a2), yw.b(a2));
            }
        }
    }

    public final aab b() {
        return this.a;
    }

    public final void c(long j) {
        yu yuVar = this.c;
        if (yuVar == null || yu.d(yuVar) != j) {
            long f = this.a.f(j);
            ys ysVar = this.a;
            this.c = new yu(j, f, ys.c(ysVar), ys.d(ysVar), ys.b(ysVar), ys.a(ysVar));
        }
    }

    public final boolean d() {
        return this.c != null;
    }

    public final void e() {
        this.c = null;
        this.b.b();
    }
}
