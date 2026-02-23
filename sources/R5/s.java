package r5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class s {
    public static final Object a;
    public static final Method b;
    public static final Method c;

    static {
        Object b2 = b();
        a = b2;
        b = b2 == null ? null : a();
        c = b2 != null ? d(b2) : null;
    }

    public static Method a() {
        return c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    public static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, (ClassLoader) null).getMethod("getJavaLangAccess", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(String str, Class... clsArr) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Object obj) {
        try {
            Method c2 = c("getStackTraceDepth", Throwable.class);
            if (c2 == null) {
                return null;
            }
            c2.invoke(obj, new Object[]{new Throwable()});
            return c2;
        } catch (UnsupportedOperationException | IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static void e(Throwable th) {
        m.k(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }
}
