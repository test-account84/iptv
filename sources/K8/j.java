package k8;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class j implements Serializable {
    public static final a c = new a(null);
    public final Object a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class b implements Serializable {
        public final Throwable a;

        public b(Throwable exception) {
            kotlin.jvm.internal.l.e(exception, "exception");
            this.a = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && kotlin.jvm.internal.l.a(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.a + ')';
        }
    }

    public /* synthetic */ j(Object obj) {
        this.a = obj;
    }

    public static final /* synthetic */ j a(Object obj) {
        return new j(obj);
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof j) && kotlin.jvm.internal.l.a(obj, ((j) obj2).i());
    }

    public static final Throwable d(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).a;
        }
        return null;
    }

    public static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean f(Object obj) {
        return obj instanceof b;
    }

    public static final boolean g(Object obj) {
        return !(obj instanceof b);
    }

    public static String h(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public int hashCode() {
        return e(this.a);
    }

    public final /* synthetic */ Object i() {
        return this.a;
    }

    public String toString() {
        return h(this.a);
    }

    public static Object b(Object obj) {
        return obj;
    }
}
