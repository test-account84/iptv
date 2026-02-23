package I8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class h {
    public static final b b = new b(null);
    public static final c c = new c();
    public final Object a;

    public static final class a extends c {
        public final Throwable a;

        public a(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.l.a(this.a, ((a) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Closed(" + this.a + ')';
        }
    }

    public static final class b {
        public b() {
        }

        public final Object a(Throwable th) {
            return h.c(new a(th));
        }

        public final Object b() {
            return h.c(h.a());
        }

        public final Object c(Object obj) {
            return h.c(obj);
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ h(Object obj) {
        this.a = obj;
    }

    public static final /* synthetic */ c a() {
        return c;
    }

    public static final /* synthetic */ h b(Object obj) {
        return new h(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof h) && kotlin.jvm.internal.l.a(obj, ((h) obj2).j());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.a;
        }
        return null;
    }

    public static final Object f(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return !(obj instanceof c);
    }

    public static String i(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.a, obj);
    }

    public int hashCode() {
        return g(this.a);
    }

    public final /* synthetic */ Object j() {
        return this.a;
    }

    public String toString() {
        return i(this.a);
    }

    public static Object c(Object obj) {
        return obj;
    }
}
