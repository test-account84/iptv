package W3;

import android.text.Layout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g {
    public String a;
    public int b;
    public boolean c;
    public int d;
    public boolean e;
    public float k;
    public String l;
    public Layout.Alignment o;
    public Layout.Alignment p;
    public b r;
    public int f = -1;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public int m = -1;
    public int n = -1;
    public int q = -1;
    public float s = Float.MAX_VALUE;

    public g A(String str) {
        this.l = str;
        return this;
    }

    public g B(boolean z) {
        this.i = z ? 1 : 0;
        return this;
    }

    public g C(boolean z) {
        this.f = z ? 1 : 0;
        return this;
    }

    public g D(Layout.Alignment alignment) {
        this.p = alignment;
        return this;
    }

    public g E(int i) {
        this.n = i;
        return this;
    }

    public g F(int i) {
        this.m = i;
        return this;
    }

    public g G(float f) {
        this.s = f;
        return this;
    }

    public g H(Layout.Alignment alignment) {
        this.o = alignment;
        return this;
    }

    public g I(boolean z) {
        this.q = z ? 1 : 0;
        return this;
    }

    public g J(b bVar) {
        this.r = bVar;
        return this;
    }

    public g K(boolean z) {
        this.g = z ? 1 : 0;
        return this;
    }

    public g a(g gVar) {
        return r(gVar, true);
    }

    public int b() {
        if (this.e) {
            return this.d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.c) {
            return this.b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String d() {
        return this.a;
    }

    public float e() {
        return this.k;
    }

    public int f() {
        return this.j;
    }

    public String g() {
        return this.l;
    }

    public Layout.Alignment h() {
        return this.p;
    }

    public int i() {
        return this.n;
    }

    public int j() {
        return this.m;
    }

    public float k() {
        return this.s;
    }

    public int l() {
        int i = this.h;
        if (i == -1 && this.i == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.i == 1 ? 2 : 0);
    }

    public Layout.Alignment m() {
        return this.o;
    }

    public boolean n() {
        return this.q == 1;
    }

    public b o() {
        return this.r;
    }

    public boolean p() {
        return this.e;
    }

    public boolean q() {
        return this.c;
    }

    public final g r(g gVar, boolean z) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.c && gVar.c) {
                w(gVar.b);
            }
            if (this.h == -1) {
                this.h = gVar.h;
            }
            if (this.i == -1) {
                this.i = gVar.i;
            }
            if (this.a == null && (str = gVar.a) != null) {
                this.a = str;
            }
            if (this.f == -1) {
                this.f = gVar.f;
            }
            if (this.g == -1) {
                this.g = gVar.g;
            }
            if (this.n == -1) {
                this.n = gVar.n;
            }
            if (this.o == null && (alignment2 = gVar.o) != null) {
                this.o = alignment2;
            }
            if (this.p == null && (alignment = gVar.p) != null) {
                this.p = alignment;
            }
            if (this.q == -1) {
                this.q = gVar.q;
            }
            if (this.j == -1) {
                this.j = gVar.j;
                this.k = gVar.k;
            }
            if (this.r == null) {
                this.r = gVar.r;
            }
            if (this.s == Float.MAX_VALUE) {
                this.s = gVar.s;
            }
            if (z && !this.e && gVar.e) {
                u(gVar.d);
            }
            if (z && this.m == -1 && (i = gVar.m) != -1) {
                this.m = i;
            }
        }
        return this;
    }

    public boolean s() {
        return this.f == 1;
    }

    public boolean t() {
        return this.g == 1;
    }

    public g u(int i) {
        this.d = i;
        this.e = true;
        return this;
    }

    public g v(boolean z) {
        this.h = z ? 1 : 0;
        return this;
    }

    public g w(int i) {
        this.b = i;
        this.c = true;
        return this;
    }

    public g x(String str) {
        this.a = str;
        return this;
    }

    public g y(float f) {
        this.k = f;
        return this;
    }

    public g z(int i) {
        this.j = i;
        return this;
    }
}
