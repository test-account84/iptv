package org.apache.http.client.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class JdkIdn implements Idn {
    private final Method toUnicode;

    public JdkIdn() throws ClassNotFoundException {
        try {
            this.toUnicode = Class.forName("java.net.IDN").getMethod("toUnicode", new Class[]{String.class});
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e.getMessage(), e);
        } catch (SecurityException e2) {
            throw new IllegalStateException(e2.getMessage(), e2);
        }
    }

    public String toUnicode(String str) {
        try {
            return (String) this.toUnicode.invoke((Object) null, new Object[]{str});
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException(e2.getMessage(), e2);
        }
    }
}
