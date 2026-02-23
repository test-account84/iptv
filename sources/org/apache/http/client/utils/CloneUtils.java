package org.apache.http.client.utils;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class CloneUtils {
    private CloneUtils() {
    }

    public static Object clone(Object obj) throws CloneNotSupportedException {
        return cloneObject(obj);
    }

    public static Object cloneObject(Object obj) throws CloneNotSupportedException {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Cloneable)) {
            throw new CloneNotSupportedException();
        }
        try {
            try {
                return obj.getClass().getMethod("clone", (Class[]) null).invoke(obj, (Object[]) null);
            } catch (InvocationTargetException e) {
                CloneNotSupportedException cause = e.getCause();
                if (cause instanceof CloneNotSupportedException) {
                    throw cause;
                }
                throw new Error("Unexpected exception", cause);
            } catch (IllegalAccessException e2) {
                throw new IllegalAccessError(e2.getMessage());
            }
        } catch (NoSuchMethodException e3) {
            throw new NoSuchMethodError(e3.getMessage());
        }
    }
}
