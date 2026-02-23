package r5;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class m {
    public static String a(int i, int i2, String str) {
        if (i < 0) {
            return q.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return q.b("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static String b(int i, int i2, String str) {
        if (i < 0) {
            return q.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return q.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static String c(int i, int i2, int i3) {
        return (i < 0 || i > i3) ? b(i, i3, "start index") : (i2 < 0 || i2 > i3) ? b(i2, i3, "end index") : q.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    public static void d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(q.b(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void g(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(q.b(str, Long.valueOf(j)));
        }
    }

    public static void h(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(q.b(str, obj));
        }
    }

    public static int i(int i, int i2) {
        return j(i, i2, "index");
    }

    public static int j(int i, int i2, String str) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(a(i, i2, str));
        }
        return i;
    }

    public static Object k(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object l(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static int m(int i, int i2) {
        return n(i, i2, "index");
    }

    public static int n(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(b(i, i2, str));
        }
        return i;
    }

    public static void o(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(c(i, i2, i3));
        }
    }

    public static void p(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void q(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void r(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(q.b(str, obj));
        }
    }
}
