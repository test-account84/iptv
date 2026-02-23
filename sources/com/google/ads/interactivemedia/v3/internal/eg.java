package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class eg extends be {
    private final int b;
    private final ui c;

    public eg(ui uiVar) {
        this.c = uiVar;
        this.b = uiVar.c();
    }

    private final int A(int i, boolean z) {
        if (z) {
            return this.c.d(i);
        }
        if (i >= this.b - 1) {
            return -1;
        }
        return i + 1;
    }

    private final int B(int i, boolean z) {
        if (z) {
            return this.c.e(i);
        }
        if (i <= 0) {
            return -1;
        }
        return i - 1;
    }

    public static Object x(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object y(Object obj) {
        return ((Pair) obj).first;
    }

    public final int a(Object obj) {
        int a;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object y = y(obj);
        Object x = x(obj);
        int r = r(y);
        if (r == -1 || (a = w(r).a(x)) == -1) {
            return -1;
        }
        return u(r) + a;
    }

    public final bc d(int i, bc bcVar, boolean z) {
        int s = s(i);
        int v = v(s);
        w(s).d(i - u(s), bcVar, z);
        bcVar.c += v;
        if (z) {
            Object z2 = z(s);
            Object obj = bcVar.b;
            af.s(obj);
            bcVar.b = Pair.create(z2, obj);
        }
        return bcVar;
    }

    public final bd e(int i, bd bdVar, long j) {
        int t = t(i);
        int v = v(t);
        int u = u(t);
        w(t).e(i - v, bdVar, j);
        Object z = z(t);
        if (!bd.a.equals(bdVar.b)) {
            z = Pair.create(z, bdVar.b);
        }
        bdVar.b = z;
        bdVar.o += u;
        bdVar.p += u;
        return bdVar;
    }

    public final Object f(int i) {
        int s = s(i);
        return Pair.create(z(s), w(s).f(i - u(s)));
    }

    public final int g(boolean z) {
        if (this.b == 0) {
            return -1;
        }
        int a = z ? this.c.a() : 0;
        while (w(a).p()) {
            a = A(a, z);
            if (a == -1) {
                return -1;
            }
        }
        return v(a) + w(a).g(z);
    }

    public final int h(boolean z) {
        int i = this.b;
        if (i == 0) {
            return -1;
        }
        int b = z ? this.c.b() : i - 1;
        while (w(b).p()) {
            b = B(b, z);
            if (b == -1) {
                return -1;
            }
        }
        return v(b) + w(b).h(z);
    }

    public final int j(int i, int i2, boolean z) {
        int t = t(i);
        int v = v(t);
        int j = w(t).j(i - v, i2 == 2 ? 0 : i2, z);
        if (j != -1) {
            return v + j;
        }
        int A = A(t, z);
        while (A != -1 && w(A).p()) {
            A = A(A, z);
        }
        if (A != -1) {
            return v(A) + w(A).g(z);
        }
        if (i2 == 2) {
            return g(z);
        }
        return -1;
    }

    public final bc n(Object obj, bc bcVar) {
        Object y = y(obj);
        Object x = x(obj);
        int r = r(y);
        int v = v(r);
        w(r).n(x, bcVar);
        bcVar.c += v;
        bcVar.b = obj;
        return bcVar;
    }

    public final int q(int i) {
        int t = t(i);
        int v = v(t);
        int q = w(t).q(i - v);
        if (q != -1) {
            return v + q;
        }
        do {
            t = B(t, false);
            if (t == -1) {
                break;
            }
        } while (w(t).p());
        if (t != -1) {
            return v(t) + w(t).h(false);
        }
        return -1;
    }

    public abstract int r(Object obj);

    public abstract int s(int i);

    public abstract int t(int i);

    public abstract int u(int i);

    public abstract int v(int i);

    public abstract be w(int i);

    public abstract Object z(int i);
}
