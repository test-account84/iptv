package kotlin.jvm.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class l {
    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj) {
        if (obj == null) {
            m();
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            n(str);
        }
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw j(new NullPointerException(str + " must not be null"));
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            o(str);
        }
    }

    public static int f(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int g(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static String h(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void i(int i, String str) {
        p();
    }

    public static Throwable j(Throwable th) {
        return k(th, l.class.getName());
    }

    public static Throwable k(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return th;
    }

    public static String l(String str, Object obj) {
        return str + obj;
    }

    public static void m() {
        throw j(new NullPointerException());
    }

    public static void n(String str) {
        throw j(new NullPointerException(str));
    }

    public static void o(String str) {
        throw j(new NullPointerException(h(str)));
    }

    public static void p() {
        q("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void q(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void r(String str) {
        throw j(new k8.p(str));
    }

    public static void s(String str) {
        r("lateinit property " + str + " has not been initialized");
    }
}
