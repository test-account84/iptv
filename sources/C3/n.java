package C3;

import B3.A;
import C3.b;
import O2.Q1;
import O2.t1;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class n {
    public static b a(b bVar, long j, long j2, long... jArr) {
        long f = f(j, -1, bVar);
        int i = bVar.f;
        while (i < bVar.c && bVar.e(i).a != Long.MIN_VALUE && bVar.e(i).a <= f) {
            i++;
        }
        b u = bVar.y(i, f).v(i, true).l(i, jArr.length).m(i, jArr).u(i, j2);
        b bVar2 = u;
        for (int i2 = 0; i2 < jArr.length && jArr[i2] == 0; i2++) {
            bVar2 = bVar2.B(i, i2);
        }
        return b(bVar2, i, k0.n1(jArr), j2);
    }

    public static b b(b bVar, int i, long j, long j2) {
        long j3 = (-j) + j2;
        while (true) {
            i++;
            if (i >= bVar.c) {
                return bVar;
            }
            long j4 = bVar.e(i).a;
            if (j4 != Long.MIN_VALUE) {
                bVar = bVar.o(i, j4 + j3);
            }
        }
    }

    public static int c(b bVar, int i) {
        int i2 = bVar.e(i).c;
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    public static long d(long j, A a, b bVar) {
        return a.b() ? e(j, a.b, a.c, bVar) : f(j, a.e, bVar);
    }

    public static long e(long j, int i, int i2, b bVar) {
        int i3;
        b.b e = bVar.e(i);
        long j2 = j - e.a;
        int i4 = bVar.f;
        while (true) {
            i3 = 0;
            if (i4 >= i) {
                break;
            }
            b.b e2 = bVar.e(i4);
            while (i3 < c(bVar, i4)) {
                j2 -= e2.g[i3];
                i3++;
            }
            j2 += e2.h;
            i4++;
        }
        if (i2 < c(bVar, i)) {
            while (i3 < i2) {
                j2 -= e.g[i3];
                i3++;
            }
        }
        return j2;
    }

    public static long f(long j, int i, b bVar) {
        if (i == -1) {
            i = bVar.c;
        }
        long j2 = 0;
        for (int i2 = bVar.f; i2 < i; i2++) {
            b.b e = bVar.e(i2);
            long j3 = e.a;
            if (j3 == Long.MIN_VALUE || j3 > j - j2) {
                break;
            }
            for (int i3 = 0; i3 < c(bVar, i2); i3++) {
                j2 += e.g[i3];
            }
            long j4 = e.h;
            j2 -= j4;
            long j5 = e.a;
            long j6 = j - j2;
            if (j4 + j5 > j6) {
                return Math.max(j5, j6);
            }
        }
        return j - j2;
    }

    public static long g(long j, A a, b bVar) {
        return a.b() ? i(j, a.b, a.c, bVar) : j(j, a.e, bVar);
    }

    public static long h(t1 t1Var, b bVar) {
        Q1 w = t1Var.w();
        if (w.v()) {
            return -9223372036854775807L;
        }
        Q1.b k = w.k(t1Var.J(), new Q1.b());
        if (!k0.c(k.m(), bVar.a)) {
            return -9223372036854775807L;
        }
        if (!t1Var.d()) {
            return j(k0.P0(t1Var.getCurrentPosition()) - k.t(), -1, bVar);
        }
        return i(k0.P0(t1Var.getCurrentPosition()), t1Var.s(), t1Var.N(), bVar);
    }

    public static long i(long j, int i, int i2, b bVar) {
        int i3;
        b.b e = bVar.e(i);
        long j2 = j + e.a;
        int i4 = bVar.f;
        while (true) {
            i3 = 0;
            if (i4 >= i) {
                break;
            }
            b.b e2 = bVar.e(i4);
            while (i3 < c(bVar, i4)) {
                j2 += e2.g[i3];
                i3++;
            }
            j2 -= e2.h;
            i4++;
        }
        if (i2 < c(bVar, i)) {
            while (i3 < i2) {
                j2 += e.g[i3];
                i3++;
            }
        }
        return j2;
    }

    public static long j(long j, int i, b bVar) {
        if (i == -1) {
            i = bVar.c;
        }
        long j2 = 0;
        for (int i2 = bVar.f; i2 < i; i2++) {
            b.b e = bVar.e(i2);
            long j3 = e.a;
            if (j3 == Long.MIN_VALUE || j3 > j) {
                break;
            }
            long j4 = j3 + j2;
            for (int i3 = 0; i3 < c(bVar, i2); i3++) {
                j2 += e.g[i3];
            }
            long j5 = e.h;
            j2 -= j5;
            if (e.a + j5 > j) {
                return Math.max(j4, j + j2);
            }
        }
        return j + j2;
    }
}
