package androidx.navigation;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class p {
    public boolean a;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;

    public static final class a {
        public boolean a;
        public boolean c;
        public int b = -1;
        public int d = -1;
        public int e = -1;
        public int f = -1;
        public int g = -1;

        public p a() {
            return new p(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }

        public a b(int i) {
            this.d = i;
            return this;
        }

        public a c(int i) {
            this.e = i;
            return this;
        }

        public a d(boolean z) {
            this.a = z;
            return this;
        }

        public a e(int i) {
            this.f = i;
            return this;
        }

        public a f(int i) {
            this.g = i;
            return this;
        }

        public a g(int i, boolean z) {
            this.b = i;
            this.c = z;
            return this;
        }
    }

    public p(boolean z, int i, boolean z2, int i2, int i3, int i4, int i5) {
        this.a = z;
        this.b = i;
        this.c = z2;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }

    public int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.a == pVar.a && this.b == pVar.b && this.c == pVar.c && this.d == pVar.d && this.e == pVar.e && this.f == pVar.f && this.g == pVar.g;
    }

    public boolean f() {
        return this.c;
    }

    public boolean g() {
        return this.a;
    }

    public int hashCode() {
        return ((((((((((((g() ? 1 : 0) * 31) + e()) * 31) + (f() ? 1 : 0)) * 31) + a()) * 31) + b()) * 31) + c()) * 31) + d();
    }
}
