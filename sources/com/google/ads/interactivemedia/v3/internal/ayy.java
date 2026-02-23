package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ayy {
    private static final awy a = awy.c().d(new ayu()).a();

    public static ayv a() {
        return ayw.a;
    }

    public static Object b(Future future, Class cls) throws Exception {
        ayx.a.a(cls);
        try {
            return future.get();
        } catch (ExecutionException e) {
            Error cause = e.getCause();
            if (cause instanceof Error) {
                throw new ayo(cause);
            }
            if (cause instanceof RuntimeException) {
                throw new azl(cause);
            }
            throw d(cls, cause);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw d(cls, e2);
        }
    }

    public static void c(Class cls) {
        atp.g(!RuntimeException.class.isAssignableFrom(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        atp.g(f(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    private static Exception d(Class cls, Throwable th) {
        Iterator it = a.e(Arrays.asList(cls.getConstructors())).iterator();
        while (it.hasNext()) {
            Exception exc = (Exception) e((Constructor) it.next(), th);
            if (exc != null) {
                if (exc.getCause() == null) {
                    exc.initCause(th);
                }
                return exc;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    private static Object e(Constructor constructor, Throwable th) {
        Class[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class cls = parameterTypes[i];
            if (cls.equals(String.class)) {
                objArr[i] = th.toString();
            } else {
                if (!cls.equals(Throwable.class)) {
                    return null;
                }
                objArr[i] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalArgumentException | InstantiationException | IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean f(Class cls) {
        try {
            d(cls, new Exception());
            return true;
        } catch (RuntimeException | Error unused) {
            return false;
        }
    }
}
