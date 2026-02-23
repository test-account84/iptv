package com.google.ads.interactivemedia.v3.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class atr {
    private static final Object a;

    static {
        Object b = b();
        a = b;
        if (b != null) {
            c("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        if (b == null) {
            return;
        }
        d(b);
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, (ClassLoader) null).getMethod("getJavaLangAccess", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(String str, Class... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void d(Object obj) {
        try {
            Method c = c("getStackTraceDepth", Throwable.class);
            if (c == null) {
                return;
            }
            c.invoke(obj, new Object[]{new Throwable()});
        } catch (UnsupportedOperationException | IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
