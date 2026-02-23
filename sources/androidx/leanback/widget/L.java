package androidx.leanback.widget;

import android.util.SparseIntArray;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class l {
    public b b;
    public boolean c;
    public int d;
    public int e;
    public s.d[] h;
    public Object[] a = new Object[1];
    public int f = -1;
    public int g = -1;
    public int i = -1;

    public static class a {
        public int a;

        public a(int i) {
            this.a = i;
        }
    }

    public interface b {
        int a();

        int b(int i);

        void c(Object obj, int i, int i2, int i3, int i4);

        int d(int i);

        int e(int i, boolean z, Object[] objArr, boolean z2);

        int getCount();

        void removeItem(int i);
    }

    public static l g(int i) {
        if (i == 1) {
            return new T();
        }
        W w = new W();
        w.C(i);
        return w;
    }

    public void A() {
        this.g = -1;
        this.f = -1;
    }

    public final void B() {
        if (this.g < this.f) {
            A();
        }
    }

    public void C(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        if (this.e == i) {
            return;
        }
        this.e = i;
        this.h = new s.d[i];
        for (int i2 = 0; i2 < this.e; i2++) {
            this.h[i2] = new s.d();
        }
    }

    public void D(b bVar) {
        this.b = bVar;
    }

    public final void E(boolean z) {
        this.c = z;
    }

    public final void F(int i) {
        this.d = i;
    }

    public void G(int i) {
        this.i = i;
    }

    public boolean a() {
        return c(this.c ? Integer.MAX_VALUE : Integer.MIN_VALUE, true);
    }

    public final void b(int i) {
        c(i, false);
    }

    public abstract boolean c(int i, boolean z);

    public final boolean d(int i) {
        if (this.g < 0) {
            return false;
        }
        if (this.c) {
            if (l(true, null) > i + this.d) {
                return false;
            }
        } else if (j(false, null) < i - this.d) {
            return false;
        }
        return true;
    }

    public final boolean e(int i) {
        if (this.g < 0) {
            return false;
        }
        if (this.c) {
            if (j(false, null) < i - this.d) {
                return false;
            }
        } else if (l(true, null) > i + this.d) {
            return false;
        }
        return true;
    }

    public void f(int i, int i2, RecyclerView.o.c cVar) {
    }

    public void h(int[] iArr, int i, SparseIntArray sparseIntArray) {
        int p = p();
        int binarySearch = p >= 0 ? Arrays.binarySearch(iArr, 0, i, p) : 0;
        if (binarySearch < 0) {
            int b2 = this.c ? (this.b.b(p) - this.b.d(p)) - this.d : this.b.b(p) + this.b.d(p) + this.d;
            for (int i2 = (-binarySearch) - 1; i2 < i; i2++) {
                int i3 = iArr[i2];
                int i4 = sparseIntArray.get(i3);
                int i5 = i4 < 0 ? 0 : i4;
                int e = this.b.e(i3, true, this.a, true);
                this.b.c(this.a[0], i3, e, i5, b2);
                b2 = this.c ? (b2 - e) - this.d : b2 + e + this.d;
            }
        }
        int m = m();
        int binarySearch2 = m >= 0 ? Arrays.binarySearch(iArr, 0, i, m) : 0;
        if (binarySearch2 < 0) {
            boolean z = this.c;
            int b3 = this.b.b(m);
            for (int i6 = (-binarySearch2) - 2; i6 >= 0; i6--) {
                int i7 = iArr[i6];
                int i8 = sparseIntArray.get(i7);
                int i9 = i8 < 0 ? 0 : i8;
                int e2 = this.b.e(i7, false, this.a, true);
                b3 = this.c ? b3 + this.d + e2 : (b3 - this.d) - e2;
                this.b.c(this.a[0], i7, e2, i9, b3);
            }
        }
    }

    public abstract int i(boolean z, int i, int[] iArr);

    public final int j(boolean z, int[] iArr) {
        return i(z, this.c ? this.f : this.g, iArr);
    }

    public abstract int k(boolean z, int i, int[] iArr);

    public final int l(boolean z, int[] iArr) {
        return k(z, this.c ? this.g : this.f, iArr);
    }

    public final int m() {
        return this.f;
    }

    public final s.d[] n() {
        return o(m(), p());
    }

    public abstract s.d[] o(int i, int i2);

    public final int p() {
        return this.g;
    }

    public abstract a q(int i);

    public int r() {
        return this.e;
    }

    public final int s(int i) {
        a q = q(i);
        if (q == null) {
            return -1;
        }
        return q.a;
    }

    public void t(int i) {
        int i2;
        if (i >= 0 && (i2 = this.g) >= 0) {
            if (i2 >= i) {
                this.g = i - 1;
            }
            B();
            if (m() < 0) {
                G(i);
            }
        }
    }

    public boolean u() {
        return this.c;
    }

    public final boolean v() {
        return x(this.c ? Integer.MIN_VALUE : Integer.MAX_VALUE, true);
    }

    public final void w(int i) {
        x(i, false);
    }

    public abstract boolean x(int i, boolean z);

    public void y(int i, int i2) {
        while (true) {
            int i3 = this.g;
            if (i3 < this.f || i3 <= i) {
                break;
            }
            if (!this.c) {
                if (this.b.b(i3) < i2) {
                    break;
                }
                this.b.removeItem(this.g);
                this.g--;
            } else {
                if (this.b.b(i3) > i2) {
                    break;
                }
                this.b.removeItem(this.g);
                this.g--;
            }
        }
        B();
    }

    public void z(int i, int i2) {
        while (true) {
            int i3 = this.g;
            int i4 = this.f;
            if (i3 < i4 || i4 >= i) {
                break;
            }
            int d = this.b.d(i4);
            if (!this.c) {
                if (this.b.b(this.f) + d > i2) {
                    break;
                }
                this.b.removeItem(this.f);
                this.f++;
            } else {
                if (this.b.b(this.f) - d < i2) {
                    break;
                }
                this.b.removeItem(this.f);
                this.f++;
            }
        }
        B();
    }
}
