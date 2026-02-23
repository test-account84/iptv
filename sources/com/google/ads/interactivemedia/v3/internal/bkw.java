package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bkw {
    private final Map a;
    private final boolean b = true;
    private final List c;

    public bkw(Map map, boolean z, List list) {
        this.a = map;
        this.c = list;
    }

    public static String b(Class cls) {
        String name;
        String str;
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            name = cls.getName();
            str = "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ";
        } else {
            if (!Modifier.isAbstract(modifiers)) {
                return null;
            }
            name = cls.getName();
            str = "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ";
        }
        return str.concat(name);
    }

    public final blk a(bof bofVar) {
        bku bkuVar;
        String f;
        ParameterizedType d = bofVar.d();
        Class c = bofVar.c();
        bjv bjvVar = (bjv) this.a.get(d);
        if (bjvVar != null) {
            return new bkv(bjvVar, d, 1);
        }
        bjv bjvVar2 = (bjv) this.a.get(c);
        if (bjvVar2 != null) {
            return new bkv(bjvVar2, d, 0);
        }
        bkt bktVar = null;
        bku bkuVar2 = EnumSet.class.isAssignableFrom(c) ? new bku((Type) d, 4) : c == EnumMap.class ? new bku((Type) d, 5) : null;
        if (bkuVar2 != null) {
            return bkuVar2;
        }
        int d2 = blo.d(this.c, c);
        if (Modifier.isAbstract(c.getModifiers())) {
            bkuVar = null;
        } else {
            try {
                Constructor declaredConstructor = c.getDeclaredConstructor((Class[]) null);
                if (d2 == 1 || (blo.c(declaredConstructor, null) && (d2 != 4 || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                    bkuVar = (d2 != 1 || (f = blo.f(declaredConstructor)) == null) ? new bku(declaredConstructor, 8) : new bku(f, 7);
                } else {
                    bkuVar = new bku("Unable to invoke no-args constructor of " + String.valueOf(c) + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.", 6);
                }
            } catch (NoSuchMethodException unused) {
            }
        }
        if (bkuVar != null) {
            return bkuVar;
        }
        if (Collection.class.isAssignableFrom(c)) {
            if (SortedSet.class.isAssignableFrom(c)) {
                bktVar = new bkt(1);
            } else if (Set.class.isAssignableFrom(c)) {
                bktVar = new bkt(0);
            } else {
                bktVar = Queue.class.isAssignableFrom(c) ? new bkt(2) : new bkt(3);
            }
        } else if (Map.class.isAssignableFrom(c)) {
            bktVar = ConcurrentNavigableMap.class.isAssignableFrom(c) ? new bkt(4) : ConcurrentMap.class.isAssignableFrom(c) ? new bkt(5) : SortedMap.class.isAssignableFrom(c) ? new bkt(6) : (!(d instanceof ParameterizedType) || String.class.isAssignableFrom(bof.b(d.getActualTypeArguments()[0]).c())) ? new bkt(8) : new bkt(7);
        }
        if (bktVar != null) {
            return bktVar;
        }
        String b = b(c);
        if (b != null) {
            return new bku(b, 2);
        }
        if (d2 == 1) {
            return new bku(c, 1);
        }
        return new bku("Unable to create instance of " + String.valueOf(c) + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.", 3);
    }

    public final String toString() {
        return this.a.toString();
    }
}
