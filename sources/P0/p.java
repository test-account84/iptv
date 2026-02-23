package P0;

import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class p {

    public static class a {
        public static final r a = p.a();
    }

    public static r a() {
        try {
            return new s((WebViewProviderFactoryBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderFactoryBoundaryInterface.class, b()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException unused) {
            return new j();
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static InvocationHandler b() {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, d()).getDeclaredMethod("createWebViewProviderFactory", (Class[]) null).invoke((Object) null, (Object[]) null);
    }

    public static r c() {
        return a.a;
    }

    public static ClassLoader d() {
        return Build.VERSION.SDK_INT >= 28 ? h.b() : e().getClass().getClassLoader();
    }

    public static Object e() {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", (Class[]) null);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke((Object) null, (Object[]) null);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        }
    }
}
