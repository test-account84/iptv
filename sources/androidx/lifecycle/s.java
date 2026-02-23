package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class s {
    public static Map a = new HashMap();
    public static Map b = new HashMap();

    public static g a(Constructor constructor, Object obj) {
        try {
            d.D.a(constructor.newInstance(new Object[]{obj}));
            return null;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static Constructor b(Class cls) {
        try {
            Package r1 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r1 != null ? r1.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String c = c(canonicalName);
            if (!name.isEmpty()) {
                c = name + "." + c;
            }
            Constructor declaredConstructor = Class.forName(c).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static String c(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    public static int d(Class cls) {
        Integer num = (Integer) a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g = g(cls);
        a.put(cls, Integer.valueOf(g));
        return g;
    }

    public static boolean e(Class cls) {
        return cls != null && o.class.isAssignableFrom(cls);
    }

    public static n f(Object obj) {
        boolean z = obj instanceof n;
        boolean z2 = obj instanceof f;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((f) obj, (n) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((f) obj, null);
        }
        if (z) {
            return (n) obj;
        }
        Class cls = obj.getClass();
        if (d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = (List) b.get(cls);
        if (list.size() == 1) {
            a((Constructor) list.get(0), obj);
            return new SingleGeneratedAdapterObserver(null);
        }
        g[] gVarArr = new g[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a((Constructor) list.get(i), obj);
            gVarArr[i] = null;
        }
        return new CompositeGeneratedAdaptersObserver(gVarArr);
    }

    public static int g(Class cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor b2 = b(cls);
        if (b2 != null) {
            b.put(cls, Collections.singletonList(b2));
            return 2;
        }
        if (b.c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (!e(superclass)) {
            arrayList = null;
        } else {
            if (d(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList((Collection) b.get(superclass));
        }
        for (Class cls2 : cls.getInterfaces()) {
            if (e(cls2)) {
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll((Collection) b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        b.put(cls, arrayList);
        return 2;
    }
}
