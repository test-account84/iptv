package G;

import F.e;
import M.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h extends l {
    public static final Class b;
    public static final Constructor c;
    public static final Method d;
    public static final Method e;

    static {
        Method method;
        Class cls;
        Method method2;
        Constructor constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor constructor2 = cls.getConstructor((Class[]) null);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE});
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        c = constructor;
        b = cls;
        d = method2;
        e = method;
    }

    public static boolean g(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface h(Object obj) {
        try {
            Object newInstance = Array.newInstance(b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean i() {
        Method method = d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object j() {
        try {
            return c.newInstance((Object[]) null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Typeface a(Context context, e.c cVar, Resources resources, int i) {
        Object j = j();
        if (j == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            ByteBuffer b2 = m.b(context, resources, dVar.b());
            if (b2 == null || !g(j, b2, dVar.c(), dVar.e(), dVar.f())) {
                return null;
            }
        }
        return h(j);
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i) {
        Object j = j();
        if (j == null) {
            return null;
        }
        s.i iVar = new s.i();
        for (g.b bVar : bVarArr) {
            Uri d2 = bVar.d();
            ByteBuffer byteBuffer = (ByteBuffer) iVar.get(d2);
            if (byteBuffer == null) {
                byteBuffer = m.f(context, cancellationSignal, d2);
                iVar.put(d2, byteBuffer);
            }
            if (byteBuffer == null || !g(j, byteBuffer, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface h = h(j);
        if (h == null) {
            return null;
        }
        return Typeface.create(h, i);
    }
}
