package k8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class d implements Comparable {
    public static final a f = new a(null);
    public static final d g = e.a();
    public final int a;
    public final int c;
    public final int d;
    public final int e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public d(int i, int i2, int i3) {
        this.a = i;
        this.c = i2;
        this.d = i3;
        this.e = b(i, i2, i3);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(d other) {
        kotlin.jvm.internal.l.e(other, "other");
        return this.e - other.e;
    }

    public final int b(int i, int i2, int i3) {
        if (new B8.c(0, 255).l(i) && new B8.c(0, 255).l(i2) && new B8.c(0, 255).l(i3)) {
            return (i << 16) + (i2 << 8) + i3;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        d dVar = obj instanceof d ? (d) obj : null;
        return dVar != null && this.e == dVar.e;
    }

    public int hashCode() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('.');
        sb.append(this.c);
        sb.append('.');
        sb.append(this.d);
        return sb.toString();
    }
}
