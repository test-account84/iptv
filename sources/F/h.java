package F;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class h {
    public static final ThreadLocal a = new ThreadLocal();
    public static final WeakHashMap b = new WeakHashMap(0);
    public static final Object c = new Object();

    public static class a {
        public static Drawable a(Resources resources, int i, Resources.Theme theme) {
            return resources.getDrawable(i, theme);
        }

        public static Drawable b(Resources resources, int i, int i2, Resources.Theme theme) {
            return resources.getDrawableForDensity(i, i2, theme);
        }
    }

    public static class b {
        public static int a(Resources resources, int i, Resources.Theme theme) {
            return resources.getColor(i, theme);
        }

        public static ColorStateList b(Resources resources, int i, Resources.Theme theme) {
            return resources.getColorStateList(i, theme);
        }
    }

    public static class c {
        public final ColorStateList a;
        public final Configuration b;
        public final int c;

        public c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.a = colorStateList;
            this.b = configuration;
            this.c = theme == null ? 0 : theme.hashCode();
        }
    }

    public static final class d {
        public final Resources a;
        public final Resources.Theme b;

        public d(Resources resources, Resources.Theme theme) {
            this.a = resources;
            this.b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.a.equals(dVar.a) && O.c.a(this.b, dVar.b);
        }

        public int hashCode() {
            return O.c.b(this.a, this.b);
        }
    }

    public static abstract class e {
        public static /* synthetic */ void a(e eVar, Typeface typeface) {
            eVar.g(typeface);
        }

        public static /* synthetic */ void b(e eVar, int i) {
            eVar.f(i);
        }

        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(int i, Handler handler) {
            e(handler).post(new j(this, i));
        }

        public final void d(Typeface typeface, Handler handler) {
            e(handler).post(new i(this, typeface));
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract void f(int i);

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public abstract void g(Typeface typeface);
    }

    public static final class f {

        public static class a {
            public static final Object a = new Object();
            public static Method b;
            public static boolean c;

            /* JADX WARN: Removed duplicated region for block: B:20:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public static void a(android.content.res.Resources.Theme r6) {
                /*
                    java.lang.Object r0 = F.h.f.a.a
                    monitor-enter(r0)
                    boolean r1 = F.h.f.a.c     // Catch: java.lang.Throwable -> L17
                    r2 = 0
                    if (r1 != 0) goto L23
                    r1 = 1
                    java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
                    java.lang.String r4 = "rebase"
                    java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r2)     // Catch: java.lang.Throwable -> L17 java.lang.NoSuchMethodException -> L19
                    F.h.f.a.b = r3     // Catch: java.lang.Throwable -> L17 java.lang.NoSuchMethodException -> L19
                    r3.setAccessible(r1)     // Catch: java.lang.Throwable -> L17 java.lang.NoSuchMethodException -> L19
                    goto L21
                L17:
                    r6 = move-exception
                    goto L39
                L19:
                    r3 = move-exception
                    java.lang.String r4 = "ResourcesCompat"
                    java.lang.String r5 = "Failed to retrieve rebase() method"
                    android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L17
                L21:
                    F.h.f.a.c = r1     // Catch: java.lang.Throwable -> L17
                L23:
                    java.lang.reflect.Method r1 = F.h.f.a.b     // Catch: java.lang.Throwable -> L17
                    if (r1 == 0) goto L37
                    r1.invoke(r6, r2)     // Catch: java.lang.Throwable -> L17 java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalAccessException -> L2d
                    goto L37
                L2b:
                    r6 = move-exception
                    goto L2e
                L2d:
                    r6 = move-exception
                L2e:
                    java.lang.String r1 = "ResourcesCompat"
                    java.lang.String r3 = "Failed to invoke rebase() method via reflection"
                    android.util.Log.i(r1, r3, r6)     // Catch: java.lang.Throwable -> L17
                    F.h.f.a.b = r2     // Catch: java.lang.Throwable -> L17
                L37:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
                    return
                L39:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: F.h.f.a.a(android.content.res.Resources$Theme):void");
            }
        }

        public static class b {
            public static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                b.a(theme);
            } else if (i >= 23) {
                a.a(theme);
            }
        }
    }

    public static void a(d dVar, int i, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (c) {
            try {
                WeakHashMap weakHashMap = b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(dVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(dVar, sparseArray);
                }
                sparseArray.append(i, new c(colorStateList, dVar.a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        if (r2.c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.res.ColorStateList b(F.h.d r5, int r6) {
        /*
            java.lang.Object r0 = F.h.c
            monitor-enter(r0)
            java.util.WeakHashMap r1 = F.h.b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            F.h$c r2 = (F.h.c) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.a     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: F.h.b(F.h$d, int):android.content.res.ColorStateList");
    }

    public static Typeface c(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i, new TypedValue(), 0, null, null, false, true);
    }

    public static int d(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 23 ? b.a(resources, i, theme) : resources.getColor(i);
    }

    public static ColorStateList e(Resources resources, int i, Resources.Theme theme) {
        d dVar = new d(resources, theme);
        ColorStateList b2 = b(dVar, i);
        if (b2 != null) {
            return b2;
        }
        ColorStateList l = l(resources, i, theme);
        if (l == null) {
            return Build.VERSION.SDK_INT >= 23 ? b.b(resources, i, theme) : resources.getColorStateList(i);
        }
        a(dVar, i, l, theme);
        return l;
    }

    public static Drawable f(Resources resources, int i, Resources.Theme theme) {
        return a.a(resources, i, theme);
    }

    public static Drawable g(Resources resources, int i, int i2, Resources.Theme theme) {
        return a.b(resources, i, i2, theme);
    }

    public static Typeface h(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface i(Context context, int i, TypedValue typedValue, int i2, e eVar) {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i, typedValue, i2, eVar, null, true, false);
    }

    public static void j(Context context, int i, e eVar, Handler handler) {
        O.h.f(eVar);
        if (context.isRestricted()) {
            eVar.c(-4, handler);
        } else {
            n(context, i, new TypedValue(), 0, eVar, handler, false, false);
        }
    }

    public static TypedValue k() {
        ThreadLocal threadLocal = a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList l(Resources resources, int i, Resources.Theme theme) {
        if (m(resources, i)) {
            return null;
        }
        try {
            return F.c.a(resources, resources.getXml(i), theme);
        } catch (Exception e2) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    public static boolean m(Resources resources, int i) {
        TypedValue k = k();
        resources.getValue(i, k, true);
        int i2 = k.type;
        return i2 >= 28 && i2 <= 31;
    }

    public static Typeface n(Context context, int i, TypedValue typedValue, int i2, e eVar, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface o = o(context, resources, typedValue, i, i2, eVar, handler, z, z2);
        if (o != null || eVar != null || z2) {
            return o;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface o(android.content.Context r16, android.content.res.Resources r17, android.util.TypedValue r18, int r19, int r20, F.h.e r21, android.os.Handler r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: F.h.o(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, F.h$e, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
