package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class be {
    public static final be a = new bb();

    public abstract int a(Object obj);

    public abstract int b();

    public abstract int c();

    public abstract bc d(int i, bc bcVar, boolean z);

    public abstract bd e(int i, bd bdVar, long j);

    public final boolean equals(Object obj) {
        int h;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof be)) {
            return false;
        }
        be beVar = (be) obj;
        if (beVar.c() == c() && beVar.b() == b()) {
            bd bdVar = new bd();
            bc bcVar = new bc();
            bd bdVar2 = new bd();
            bc bcVar2 = new bc();
            for (int i = 0; i < c(); i++) {
                if (!o(i, bdVar).equals(beVar.o(i, bdVar2))) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < b(); i2++) {
                if (!d(i2, bcVar, true).equals(beVar.d(i2, bcVar2, true))) {
                    return false;
                }
            }
            int g = g(true);
            if (g == beVar.g(true) && (h = h(true)) == beVar.h(true)) {
                while (g != h) {
                    int j = j(g, 0, true);
                    if (j != beVar.j(g, 0, true)) {
                        return false;
                    }
                    g = j;
                }
                return true;
            }
        }
        return false;
    }

    public abstract Object f(int i);

    public int g(boolean z) {
        return p() ? -1 : 0;
    }

    public int h(boolean z) {
        if (p()) {
            return -1;
        }
        return c() - 1;
    }

    public final int hashCode() {
        int i;
        bd bdVar = new bd();
        bc bcVar = new bc();
        int c = c() + 217;
        int i2 = 0;
        while (true) {
            i = c * 31;
            if (i2 >= c()) {
                break;
            }
            c = i + o(i2, bdVar).hashCode();
            i2++;
        }
        int b = i + b();
        for (int i3 = 0; i3 < b(); i3++) {
            b = (b * 31) + d(i3, bcVar, true).hashCode();
        }
        int g = g(true);
        while (g != -1) {
            b = (b * 31) + g;
            g = j(g, 0, true);
        }
        return b;
    }

    public final int i(int i, bc bcVar, bd bdVar, int i2, boolean z) {
        int i3 = m(i, bcVar).c;
        if (o(i3, bdVar).p != i) {
            return i + 1;
        }
        int j = j(i3, i2, z);
        if (j == -1) {
            return -1;
        }
        return o(j, bdVar).o;
    }

    public int j(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == h(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == h(z) ? g(z) : i + 1;
        }
        throw new IllegalStateException();
    }

    public final Pair k(bd bdVar, bc bcVar, int i, long j) {
        Pair l = l(bdVar, bcVar, i, j, 0L);
        af.s(l);
        return l;
    }

    public final Pair l(bd bdVar, bc bcVar, int i, long j, long j2) {
        af.y(i, c());
        e(i, bdVar, j2);
        if (j == -9223372036854775807L) {
            j = bdVar.m;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bdVar.o;
        m(i2, bcVar);
        while (i2 < bdVar.p && bcVar.e != j) {
            int i3 = i2 + 1;
            if (m(i3, bcVar).e > j) {
                break;
            }
            i2 = i3;
        }
        d(i2, bcVar, true);
        long j3 = j - bcVar.e;
        long j4 = bcVar.d;
        if (j4 != -9223372036854775807L) {
            j3 = Math.min(j3, j4 - 1);
        }
        long max = Math.max(0L, j3);
        Object obj = bcVar.b;
        af.s(obj);
        return Pair.create(obj, Long.valueOf(max));
    }

    public final bc m(int i, bc bcVar) {
        return d(i, bcVar, false);
    }

    public bc n(Object obj, bc bcVar) {
        return d(a(obj), bcVar, true);
    }

    public final bd o(int i, bd bdVar) {
        return e(i, bdVar, 0L);
    }

    public final boolean p() {
        return c() == 0;
    }

    public int q(int i) {
        if (i == g(false)) {
            return -1;
        }
        return i - 1;
    }
}
