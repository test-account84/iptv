package I5;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r {
    public final F a;
    public final int b;
    public final int c;

    public r(F f, int i, int i2) {
        this.a = (F) E.c(f, "Null dependency anInterface.");
        this.b = i;
        this.c = i2;
    }

    public static r a(Class cls) {
        return new r(cls, 0, 2);
    }

    public static String b(int i) {
        if (i == 0) {
            return "direct";
        }
        if (i == 1) {
            return "provider";
        }
        if (i == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i);
    }

    public static r h(Class cls) {
        return new r(cls, 0, 0);
    }

    public static r i(Class cls) {
        return new r(cls, 0, 1);
    }

    public static r j(F f) {
        return new r(f, 1, 0);
    }

    public static r k(Class cls) {
        return new r(cls, 1, 0);
    }

    public static r l(F f) {
        return new r(f, 1, 1);
    }

    public static r m(Class cls) {
        return new r(cls, 1, 1);
    }

    public static r n(Class cls) {
        return new r(cls, 2, 0);
    }

    public F c() {
        return this.a;
    }

    public boolean d() {
        return this.c == 2;
    }

    public boolean e() {
        return this.c == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.a.equals(rVar.a) && this.b == rVar.b && this.c == rVar.c;
    }

    public boolean f() {
        return this.b == 1;
    }

    public boolean g() {
        return this.b == 2;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.a);
        sb.append(", type=");
        int i = this.b;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", injection=");
        sb.append(b(this.c));
        sb.append("}");
        return sb.toString();
    }

    public r(Class cls, int i, int i2) {
        this(F.b(cls), i, i2);
    }
}
