package O2;

import O2.Q1;
import android.util.Pair;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a extends Q1 {
    public final int g;
    public final B3.a0 h;
    public final boolean i;

    public a(boolean z, B3.a0 a0Var) {
        this.i = z;
        this.h = a0Var;
        this.g = a0Var.getLength();
    }

    public static Object A(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object B(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object D(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    public abstract Object C(int i);

    public abstract int E(int i);

    public abstract int F(int i);

    public final int G(int i, boolean z) {
        if (z) {
            return this.h.c(i);
        }
        if (i < this.g - 1) {
            return i + 1;
        }
        return -1;
    }

    public final int H(int i, boolean z) {
        if (z) {
            return this.h.b(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }

    public abstract Q1 I(int i);

    public int e(boolean z) {
        if (this.g == 0) {
            return -1;
        }
        if (this.i) {
            z = false;
        }
        int f = z ? this.h.f() : 0;
        while (I(f).v()) {
            f = G(f, z);
            if (f == -1) {
                return -1;
            }
        }
        return F(f) + I(f).e(z);
    }

    public final int f(Object obj) {
        int f;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object B = B(obj);
        Object A = A(obj);
        int x = x(B);
        if (x == -1 || (f = I(x).f(A)) == -1) {
            return -1;
        }
        return E(x) + f;
    }

    public int g(boolean z) {
        int i = this.g;
        if (i == 0) {
            return -1;
        }
        if (this.i) {
            z = false;
        }
        int d = z ? this.h.d() : i - 1;
        while (I(d).v()) {
            d = H(d, z);
            if (d == -1) {
                return -1;
            }
        }
        return F(d) + I(d).g(z);
    }

    public int j(int i, int i2, boolean z) {
        if (this.i) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int z2 = z(i);
        int F = F(z2);
        int j = I(z2).j(i - F, i2 != 2 ? i2 : 0, z);
        if (j != -1) {
            return F + j;
        }
        int G = G(z2, z);
        while (G != -1 && I(G).v()) {
            G = G(G, z);
        }
        if (G != -1) {
            return F(G) + I(G).e(z);
        }
        if (i2 == 2) {
            return e(z);
        }
        return -1;
    }

    public final Q1.b l(int i, Q1.b bVar, boolean z) {
        int y = y(i);
        int F = F(y);
        I(y).l(i - E(y), bVar, z);
        bVar.d += F;
        if (z) {
            bVar.c = D(C(y), d4.a.e(bVar.c));
        }
        return bVar;
    }

    public final Q1.b m(Object obj, Q1.b bVar) {
        Object B = B(obj);
        Object A = A(obj);
        int x = x(B);
        int F = F(x);
        I(x).m(A, bVar);
        bVar.d += F;
        bVar.c = obj;
        return bVar;
    }

    public int q(int i, int i2, boolean z) {
        if (this.i) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int z2 = z(i);
        int F = F(z2);
        int q = I(z2).q(i - F, i2 != 2 ? i2 : 0, z);
        if (q != -1) {
            return F + q;
        }
        int H = H(z2, z);
        while (H != -1 && I(H).v()) {
            H = H(H, z);
        }
        if (H != -1) {
            return F(H) + I(H).g(z);
        }
        if (i2 == 2) {
            return g(z);
        }
        return -1;
    }

    public final Object r(int i) {
        int y = y(i);
        return D(C(y), I(y).r(i - E(y)));
    }

    public final Q1.d t(int i, Q1.d dVar, long j) {
        int z = z(i);
        int F = F(z);
        int E = E(z);
        I(z).t(i - F, dVar, j);
        Object C = C(z);
        if (!Q1.d.s.equals(dVar.a)) {
            C = D(C, dVar.a);
        }
        dVar.a = C;
        dVar.p += E;
        dVar.q += E;
        return dVar;
    }

    public abstract int x(Object obj);

    public abstract int y(int i);

    public abstract int z(int i);
}
