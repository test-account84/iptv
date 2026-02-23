package B8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class f extends d {
    public static final a f = new a(null);
    public static final f g = new f(1, 0);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public f(long j, long j2) {
        super(j, j2, 1L);
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            if (!isEmpty() || !((f) obj).isEmpty()) {
                f fVar = (f) obj;
                if (d() != fVar.d() || f() != fVar.f()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean h(long j) {
        return d() <= j && j <= f();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (d() ^ (d() >>> 32))) + (f() ^ (f() >>> 32)));
    }

    public boolean isEmpty() {
        return d() > f();
    }

    public String toString() {
        return d() + ".." + f();
    }
}
