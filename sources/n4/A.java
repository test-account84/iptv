package N4;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;
import org.chromium.net.ApiVersion;
import w4.i;
import w4.j;
import w4.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a {
    public static final String a = "a";
    public static final i b = i.h();
    public static final Object c = new Object();
    public static DynamiteModule d = null;
    public static String e = "0";

    public static boolean a() {
        return b() != null;
    }

    public static DynamiteModule b() {
        DynamiteModule dynamiteModule;
        synchronized (c) {
            dynamiteModule = d;
        }
        return dynamiteModule;
    }

    public static String c() {
        String str;
        synchronized (c) {
            str = e;
        }
        return str;
    }

    public static void d(Context context) {
        synchronized (c) {
            try {
                if (a()) {
                    return;
                }
                r.n(context, "Context must not be null");
                try {
                    ((ClassLoader) r.m(a.class.getClassLoader())).loadClass("org.chromium.net.CronetEngine");
                    int apiLevel = ApiVersion.getApiLevel();
                    i iVar = b;
                    iVar.n(context, 11925000);
                    try {
                        DynamiteModule e2 = DynamiteModule.e(context, DynamiteModule.b, "com.google.android.gms.cronet_dynamite");
                        try {
                            Class loadClass = e2.b().getClassLoader().loadClass("org.chromium.net.impl.ImplVersion");
                            if (loadClass.getClassLoader() == a.class.getClassLoader()) {
                                Log.e(a, "ImplVersion class is missing from Cronet module.");
                                throw new j(8);
                            }
                            Method method = loadClass.getMethod("getApiLevel", (Class[]) null);
                            Method method2 = loadClass.getMethod("getCronetVersion", (Class[]) null);
                            int intValue = ((Integer) r.m((Integer) method.invoke((Object) null, (Object[]) null))).intValue();
                            e = (String) r.m((String) method2.invoke((Object) null, (Object[]) null));
                            if (apiLevel <= intValue) {
                                d = e2;
                                return;
                            }
                            Intent d2 = iVar.d(context, 2, "cr");
                            if (d2 == null) {
                                Log.e(a, "Unable to fetch error resolution intent");
                                throw new j(2);
                            }
                            String str = e;
                            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 174);
                            sb.append("Google Play Services update is required. The API Level of the client is ");
                            sb.append(apiLevel);
                            sb.append(". The API Level of the implementation is ");
                            sb.append(intValue);
                            sb.append(". The Cronet implementation version is ");
                            sb.append(str);
                            throw new k(2, sb.toString(), d2);
                        } catch (Exception e3) {
                            Log.e(a, "Unable to read Cronet version from the Cronet module ", e3);
                            throw new j(8).initCause(e3);
                        }
                    } catch (DynamiteModule.a e4) {
                        Log.e(a, "Unable to load Cronet module", e4);
                        throw new j(8).initCause(e4);
                    }
                } catch (ClassNotFoundException e5) {
                    Log.e(a, "Cronet API is not available. Have you included all required dependencies?");
                    throw new j(10).initCause(e5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
