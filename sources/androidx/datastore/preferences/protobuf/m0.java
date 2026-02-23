package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.s0;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class m0 {
    public static final m0 f = new m0(0, new int[0], new Object[0], false);
    public int a;
    public int[] b;
    public Object[] c;
    public int d;
    public boolean e;

    public m0() {
        this(0, new int[8], new Object[8], true);
    }

    public static boolean c(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(Object[] objArr, Object[] objArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!objArr[i2].equals(objArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    public static m0 e() {
        return f;
    }

    public static int h(int[] iArr, int i) {
        int i2 = 17;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    public static int i(Object[] objArr, int i) {
        int i2 = 17;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + objArr[i3].hashCode();
        }
        return i2;
    }

    public static m0 k(m0 m0Var, m0 m0Var2) {
        int i = m0Var.a + m0Var2.a;
        int[] copyOf = Arrays.copyOf(m0Var.b, i);
        System.arraycopy(m0Var2.b, 0, copyOf, m0Var.a, m0Var2.a);
        Object[] copyOf2 = Arrays.copyOf(m0Var.c, i);
        System.arraycopy(m0Var2.c, 0, copyOf2, m0Var.a, m0Var2.a);
        return new m0(i, copyOf, copyOf2, true);
    }

    public static m0 l() {
        return new m0();
    }

    public static void p(int i, Object obj, s0 s0Var) {
        int a = r0.a(i);
        int b = r0.b(i);
        if (b == 0) {
            s0Var.A(a, ((Long) obj).longValue());
            return;
        }
        if (b == 1) {
            s0Var.x(a, ((Long) obj).longValue());
            return;
        }
        if (b == 2) {
            s0Var.j(a, (g) obj);
            return;
        }
        if (b != 3) {
            if (b != 5) {
                throw new RuntimeException(z.d());
            }
            s0Var.c(a, ((Integer) obj).intValue());
        } else if (s0Var.y() == s0.a.ASCENDING) {
            s0Var.D(a);
            ((m0) obj).q(s0Var);
            s0Var.I(a);
        } else {
            s0Var.I(a);
            ((m0) obj).q(s0Var);
            s0Var.D(a);
        }
    }

    public void a() {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b() {
        int i = this.a;
        int[] iArr = this.b;
        if (i == iArr.length) {
            int i2 = i + (i < 4 ? 8 : i >> 1);
            this.b = Arrays.copyOf(iArr, i2);
            this.c = Arrays.copyOf(this.c, i2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        int i = this.a;
        return i == m0Var.a && c(this.b, m0Var.b, i) && d(this.c, m0Var.c, this.a);
    }

    public int f() {
        int S;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.a; i3++) {
            int i4 = this.b[i3];
            int a = r0.a(i4);
            int b = r0.b(i4);
            if (b == 0) {
                S = j.S(a, ((Long) this.c[i3]).longValue());
            } else if (b == 1) {
                S = j.n(a, ((Long) this.c[i3]).longValue());
            } else if (b == 2) {
                S = j.f(a, (g) this.c[i3]);
            } else if (b == 3) {
                S = (j.P(a) * 2) + ((m0) this.c[i3]).f();
            } else {
                if (b != 5) {
                    throw new IllegalStateException(z.d());
                }
                S = j.l(a, ((Integer) this.c[i3]).intValue());
            }
            i2 += S;
        }
        this.d = i2;
        return i2;
    }

    public int g() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.a; i3++) {
            i2 += j.D(r0.a(this.b[i3]), (g) this.c[i3]);
        }
        this.d = i2;
        return i2;
    }

    public int hashCode() {
        int i = this.a;
        return ((((527 + i) * 31) + h(this.b, i)) * 31) + i(this.c, this.a);
    }

    public void j() {
        this.e = false;
    }

    public final void m(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.a; i2++) {
            Q.c(sb, i, String.valueOf(r0.a(this.b[i2])), this.c[i2]);
        }
    }

    public void n(int i, Object obj) {
        a();
        b();
        int[] iArr = this.b;
        int i2 = this.a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.a = i2 + 1;
    }

    public void o(s0 s0Var) {
        if (s0Var.y() == s0.a.DESCENDING) {
            for (int i = this.a - 1; i >= 0; i--) {
                s0Var.b(r0.a(this.b[i]), this.c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.a; i2++) {
            s0Var.b(r0.a(this.b[i2]), this.c[i2]);
        }
    }

    public void q(s0 s0Var) {
        if (this.a == 0) {
            return;
        }
        if (s0Var.y() == s0.a.ASCENDING) {
            for (int i = 0; i < this.a; i++) {
                p(this.b[i], this.c[i], s0Var);
            }
            return;
        }
        for (int i2 = this.a - 1; i2 >= 0; i2--) {
            p(this.b[i2], this.c[i2], s0Var);
        }
    }

    public m0(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }
}
