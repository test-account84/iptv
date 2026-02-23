package androidx.lifecycle;

import androidx.lifecycle.j;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b {
    public static b c = new b();
    public final Map a = new HashMap();
    public final Map b = new HashMap();

    public static class a {
        public final Map a = new HashMap();
        public final Map b;

        public a(Map map) {
            this.b = map;
            for (Map.Entry entry : map.entrySet()) {
                j.b bVar = (j.b) entry.getValue();
                ArrayList arrayList = (List) this.a.get(bVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.a.put(bVar, arrayList);
                }
                arrayList.add((b) entry.getKey());
            }
        }

        public static void b(List list, p pVar, j.b bVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((b) list.get(size)).a(pVar, bVar, obj);
                }
            }
        }

        public void a(p pVar, j.b bVar, Object obj) {
            b((List) this.a.get(bVar), pVar, bVar, obj);
            b((List) this.a.get(j.b.ON_ANY), pVar, bVar, obj);
        }
    }

    public static final class b {
        public final int a;
        public final Method b;

        public b(int i, Method method) {
            this.a = i;
            this.b = method;
            method.setAccessible(true);
        }

        public void a(p pVar, j.b bVar, Object obj) {
            try {
                int i = this.a;
                if (i == 0) {
                    this.b.invoke(obj, (Object[]) null);
                } else if (i == 1) {
                    this.b.invoke(obj, new Object[]{pVar});
                } else {
                    if (i != 2) {
                        return;
                    }
                    this.b.invoke(obj, new Object[]{pVar, bVar});
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b.getName().equals(bVar.b.getName());
        }

        public int hashCode() {
            return (this.a * 31) + this.b.getName().hashCode();
        }
    }

    public final a a(Class cls, Method[] methodArr) {
        int i;
        a c2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c2 = c(superclass)) != null) {
            hashMap.putAll(c2.b);
        }
        for (Class cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).b.entrySet()) {
                e(hashMap, (b) entry.getKey(), (j.b) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            w wVar = (w) method.getAnnotation(w.class);
            if (wVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(p.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                j.b value = wVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(j.b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != j.b.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new b(i, method), value, cls);
                z = true;
            }
        }
        a aVar = new a(hashMap);
        this.a.put(cls, aVar);
        this.b.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    public final Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    public a c(Class cls) {
        a aVar = (a) this.a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class cls) {
        Boolean bool = (Boolean) this.b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b2 = b(cls);
        for (Method method : b2) {
            if (((w) method.getAnnotation(w.class)) != null) {
                a(cls, b2);
                return true;
            }
        }
        this.b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map map, b bVar, j.b bVar2, Class cls) {
        j.b bVar3 = (j.b) map.get(bVar);
        if (bVar3 == null || bVar2 == bVar3) {
            if (bVar3 == null) {
                map.put(bVar, bVar2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bVar3 + ", new value " + bVar2);
    }
}
