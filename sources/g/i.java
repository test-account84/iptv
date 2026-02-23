package G;

import F.e;
import M.g;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i extends g {
    public final Class g;
    public final Constructor h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;
    public final Method m;

    public i() {
        Class cls;
        Constructor constructor;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            cls = u();
            constructor = v(cls);
            method = r(cls);
            method2 = s(cls);
            method3 = w(cls);
            method4 = q(cls);
            method5 = t(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            cls = null;
            constructor = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.g = cls;
        this.h = constructor;
        this.i = method;
        this.j = method2;
        this.k = method3;
        this.l = method4;
        this.m = method5;
    }

    public Typeface a(Context context, e.c cVar, Resources resources, int i) {
        if (!p()) {
            return super.a(context, cVar, resources, i);
        }
        Object k = k();
        if (k == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            if (!m(context, k, dVar.a(), dVar.c(), dVar.e(), dVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d()))) {
                l(k);
                return null;
            }
        }
        if (o(k)) {
            return h(k);
        }
        return null;
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i) {
        Typeface h;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!p()) {
            g.b f = f(bVarArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(f.d(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(f.e()).setItalic(f.f()).build();
                    openFileDescriptor.close();
                    return build;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map h2 = m.h(context, bVarArr, cancellationSignal);
        Object k = k();
        if (k == null) {
            return null;
        }
        boolean z = false;
        for (g.b bVar : bVarArr) {
            ByteBuffer byteBuffer = (ByteBuffer) h2.get(bVar.d());
            if (byteBuffer != null) {
                if (!n(k, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    l(k);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            l(k);
            return null;
        }
        if (o(k) && (h = h(k)) != null) {
            return Typeface.create(h, i);
        }
        return null;
    }

    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        if (!p()) {
            return super.d(context, resources, i, str, i2);
        }
        Object k = k();
        if (k == null) {
            return null;
        }
        if (!m(context, k, str, 0, -1, -1, null)) {
            l(k);
            return null;
        }
        if (o(k)) {
            return h(k);
        }
        return null;
    }

    public Typeface h(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.m.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final Object k() {
        try {
            return this.h.newInstance((Object[]) null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public final void l(Object obj) {
        try {
            this.l.invoke(obj, (Object[]) null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean m(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.i.invoke(obj, new Object[]{context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean n(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.j.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean o(Object obj) {
        try {
            return ((Boolean) this.k.invoke(obj, (Object[]) null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean p() {
        if (this.i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }

    public Method q(Class cls) {
        return cls.getMethod("abortCreation", (Class[]) null);
    }

    public Method r(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }

    public Method s(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    public Method t(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class u() {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor v(Class cls) {
        return cls.getConstructor((Class[]) null);
    }

    public Method w(Class cls) {
        return cls.getMethod("freeze", (Class[]) null);
    }
}
