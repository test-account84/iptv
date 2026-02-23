package com.squareup.okhttp.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class OptionalMethod {
    private final String methodName;
    private final Class[] methodParams;
    private final Class returnType;

    public OptionalMethod(Class cls, String str, Class... clsArr) {
        this.returnType = cls;
        this.methodName = str;
        this.methodParams = clsArr;
    }

    private Method getMethod(Class cls) {
        Class cls2;
        String str = this.methodName;
        if (str == null) {
            return null;
        }
        Method publicMethod = getPublicMethod(cls, str, this.methodParams);
        if (publicMethod == null || (cls2 = this.returnType) == null || cls2.isAssignableFrom(publicMethod.getReturnType())) {
            return publicMethod;
        }
        return null;
    }

    private static Method getPublicMethod(Class cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public Object invoke(Object obj, Object... objArr) throws InvocationTargetException {
        Method method = getMethod(obj.getClass());
        if (method == null) {
            throw new AssertionError("Method " + this.methodName + " not supported for object " + obj);
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + method);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public Object invokeOptional(Object obj, Object... objArr) throws InvocationTargetException {
        Method method = getMethod(obj.getClass());
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object invokeOptionalWithoutCheckedException(Object obj, Object... objArr) {
        try {
            return invokeOptional(obj, objArr);
        } catch (InvocationTargetException e) {
            RuntimeException targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw targetException;
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object invokeWithoutCheckedException(Object obj, Object... objArr) {
        try {
            return invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            RuntimeException targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw targetException;
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public boolean isSupported(Object obj) {
        return getMethod(obj.getClass()) != null;
    }
}
