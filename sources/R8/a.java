package r8;

import java.lang.reflect.Method;
import kotlin.jvm.internal.l;
import l8.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a {

    public static final class a {
        public static final a a = new a();
        public static final Method b;
        public static final Method c;

        static {
            Method method;
            Method method2;
            Method[] throwableMethods = Throwable.class.getMethods();
            l.d(throwableMethods, "throwableMethods");
            int length = throwableMethods.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                method = null;
                if (i2 >= length) {
                    method2 = null;
                    break;
                }
                method2 = throwableMethods[i2];
                if (l.a(method2.getName(), "addSuppressed")) {
                    Class[] parameterTypes = method2.getParameterTypes();
                    l.d(parameterTypes, "it.parameterTypes");
                    if (l.a(h.M(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i2++;
            }
            b = method2;
            int length2 = throwableMethods.length;
            while (true) {
                if (i >= length2) {
                    break;
                }
                Method method3 = throwableMethods[i];
                if (l.a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i++;
            }
            c = method;
        }
    }

    public void a(Throwable cause, Throwable exception) {
        l.e(cause, "cause");
        l.e(exception, "exception");
        Method method = a.b;
        if (method != null) {
            method.invoke(cause, new Object[]{exception});
        }
    }

    public z8.c b() {
        return new z8.b();
    }
}
