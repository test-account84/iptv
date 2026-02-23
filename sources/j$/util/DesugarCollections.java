package j$.util;

import j$.util.Collection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.Predicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class DesugarCollections {
    public static final Class a;
    private static final Field b;
    private static final Field c;
    private static final Constructor d;
    private static final Constructor e;

    static {
        Field field;
        Field field2;
        Constructor constructor;
        Class cls = Collections.synchronizedCollection(new ArrayList()).getClass();
        a = cls;
        Collections.synchronizedList(new LinkedList()).getClass();
        Constructor constructor2 = null;
        try {
            field = cls.getDeclaredField("mutex");
        } catch (NoSuchFieldException unused) {
            field = null;
        }
        b = field;
        if (field != null) {
            field.setAccessible(true);
        }
        try {
            field2 = cls.getDeclaredField("c");
        } catch (NoSuchFieldException unused2) {
            field2 = null;
        }
        c = field2;
        if (field2 != null) {
            field2.setAccessible(true);
        }
        try {
            constructor = Collections.synchronizedSet(new HashSet()).getClass().getDeclaredConstructor(new Class[]{java.util.Set.class, Object.class});
        } catch (NoSuchMethodException unused3) {
            constructor = null;
        }
        e = constructor;
        if (constructor != null) {
            constructor.setAccessible(true);
        }
        try {
            constructor2 = cls.getDeclaredConstructor(new Class[]{java.util.Collection.class, Object.class});
        } catch (NoSuchMethodException unused4) {
        }
        d = constructor2;
        if (constructor2 != null) {
            constructor2.setAccessible(true);
        }
    }

    static /* bridge */ /* synthetic */ Constructor a() {
        return d;
    }

    static /* bridge */ /* synthetic */ Constructor b() {
        return e;
    }

    static boolean c(java.util.Collection collection, Predicate predicate) {
        boolean removeIf;
        Field field = b;
        if (field == null) {
            try {
                Collection collection2 = (java.util.Collection) c.get(collection);
                return collection2 instanceof Collection ? collection2.removeIf(predicate) : Collection.-CC.$default$removeIf(collection2, predicate);
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized collection removeIf fall-back.", e2);
            }
        }
        try {
            synchronized (field.get(collection)) {
                Collection collection3 = (java.util.Collection) c.get(collection);
                removeIf = collection3 instanceof Collection ? collection3.removeIf(predicate) : Collection.-CC.$default$removeIf(collection3, predicate);
            }
            return removeIf;
        } catch (IllegalAccessException e3) {
            throw new Error("Runtime illegal access in synchronized collection removeIf.", e3);
        }
    }

    public static java.util.Map synchronizedMap(java.util.Map map) {
        return new f(map);
    }
}
