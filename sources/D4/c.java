package d4;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class c {
    public static Method a;
    public static Method b;

    public static IBinder a(Bundle bundle, String str) {
        return k0.a >= 18 ? bundle.getBinder(str) : b(bundle, str);
    }

    public static IBinder b(Bundle bundle, String str) {
        String str2;
        Method method = a;
        if (method != null) {
            return (IBinder) method.invoke(bundle, new Object[]{str});
        }
        try {
            Method method2 = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
            a = method2;
            method2.setAccessible(true);
            method = a;
            try {
                return (IBinder) method.invoke(bundle, new Object[]{str});
            } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                e = e;
                str2 = "Failed to invoke getIBinder via reflection";
            }
        } catch (NoSuchMethodException e2) {
            e = e2;
            str2 = "Failed to retrieve getIBinder method";
        }
        B.h("BundleUtil", str2, e);
        return null;
    }

    public static void c(Bundle bundle, String str, IBinder iBinder) {
        if (k0.a >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            d(bundle, str, iBinder);
        }
    }

    public static void d(Bundle bundle, String str, IBinder iBinder) {
        Method method = b;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                b = method2;
                method2.setAccessible(true);
                method = b;
            } catch (NoSuchMethodException e) {
                B.h("BundleUtil", "Failed to retrieve putIBinder method", e);
                return;
            }
        }
        try {
            method.invoke(bundle, new Object[]{str, iBinder});
        } catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException e2) {
            B.h("BundleUtil", "Failed to invoke putIBinder via reflection", e2);
        }
    }
}
