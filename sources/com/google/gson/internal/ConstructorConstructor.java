package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ConstructorConstructor {
    private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
    private final Map instanceCreators;

    public class 1 implements ObjectConstructor {
        final /* synthetic */ Type val$type;
        final /* synthetic */ InstanceCreator val$typeCreator;

        public 1(InstanceCreator instanceCreator, Type type) {
            this.val$typeCreator = instanceCreator;
            this.val$type = type;
        }

        public Object construct() {
            return this.val$typeCreator.createInstance(this.val$type);
        }
    }

    public class 10 implements ObjectConstructor {
        public 10() {
        }

        public Object construct() {
            return new ConcurrentHashMap();
        }
    }

    public class 11 implements ObjectConstructor {
        public 11() {
        }

        public Object construct() {
            return new TreeMap();
        }
    }

    public class 12 implements ObjectConstructor {
        public 12() {
        }

        public Object construct() {
            return new LinkedHashMap();
        }
    }

    public class 13 implements ObjectConstructor {
        public 13() {
        }

        public Object construct() {
            return new LinkedTreeMap();
        }
    }

    public class 14 implements ObjectConstructor {
        private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
        final /* synthetic */ Class val$rawType;
        final /* synthetic */ Type val$type;

        public 14(Class cls, Type type) {
            this.val$rawType = cls;
            this.val$type = type;
        }

        public Object construct() {
            try {
                return this.unsafeAllocator.newInstance(this.val$rawType);
            } catch (Exception e) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.val$type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
            }
        }
    }

    public class 2 implements ObjectConstructor {
        final /* synthetic */ InstanceCreator val$rawTypeCreator;
        final /* synthetic */ Type val$type;

        public 2(InstanceCreator instanceCreator, Type type) {
            this.val$rawTypeCreator = instanceCreator;
            this.val$type = type;
        }

        public Object construct() {
            return this.val$rawTypeCreator.createInstance(this.val$type);
        }
    }

    public class 3 implements ObjectConstructor {
        final /* synthetic */ Constructor val$constructor;

        public 3(Constructor constructor) {
            this.val$constructor = constructor;
        }

        public Object construct() {
            try {
                return this.val$constructor.newInstance((Object[]) null);
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to invoke " + this.val$constructor + " with no args", e.getTargetException());
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke " + this.val$constructor + " with no args", e2);
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    public class 4 implements ObjectConstructor {
        public 4() {
        }

        public Object construct() {
            return new TreeSet();
        }
    }

    public class 5 implements ObjectConstructor {
        final /* synthetic */ Type val$type;

        public 5(Type type) {
            this.val$type = type;
        }

        public Object construct() {
            ParameterizedType parameterizedType = this.val$type;
            if (!(parameterizedType instanceof ParameterizedType)) {
                throw new JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
            }
            Class cls = parameterizedType.getActualTypeArguments()[0];
            if (cls instanceof Class) {
                return EnumSet.noneOf(cls);
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
        }
    }

    public class 6 implements ObjectConstructor {
        public 6() {
        }

        public Object construct() {
            return new LinkedHashSet();
        }
    }

    public class 7 implements ObjectConstructor {
        public 7() {
        }

        public Object construct() {
            return new ArrayDeque();
        }
    }

    public class 8 implements ObjectConstructor {
        public 8() {
        }

        public Object construct() {
            return new ArrayList();
        }
    }

    public class 9 implements ObjectConstructor {
        public 9() {
        }

        public Object construct() {
            return new ConcurrentSkipListMap();
        }
    }

    public ConstructorConstructor(Map map) {
        this.instanceCreators = map;
    }

    private ObjectConstructor newDefaultConstructor(Class cls) {
        try {
            AccessibleObject declaredConstructor = cls.getDeclaredConstructor((Class[]) null);
            if (!declaredConstructor.isAccessible()) {
                this.accessor.makeAccessible(declaredConstructor);
            }
            return new 3(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private ObjectConstructor newDefaultImplementationConstructor(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new 4() : EnumSet.class.isAssignableFrom(cls) ? new 5(type) : Set.class.isAssignableFrom(cls) ? new 6() : Queue.class.isAssignableFrom(cls) ? new 7() : new 8();
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new 9() : ConcurrentMap.class.isAssignableFrom(cls) ? new 10() : SortedMap.class.isAssignableFrom(cls) ? new 11() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new 13() : new 12();
        }
        return null;
    }

    private ObjectConstructor newUnsafeAllocator(Type type, Class cls) {
        return new 14(cls, type);
    }

    public ObjectConstructor get(TypeToken typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        InstanceCreator instanceCreator = (InstanceCreator) this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new 1(instanceCreator, type);
        }
        InstanceCreator instanceCreator2 = (InstanceCreator) this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new 2(instanceCreator2, type);
        }
        ObjectConstructor newDefaultConstructor = newDefaultConstructor(rawType);
        if (newDefaultConstructor != null) {
            return newDefaultConstructor;
        }
        ObjectConstructor newDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        return newDefaultImplementationConstructor != null ? newDefaultImplementationConstructor : newUnsafeAllocator(type, rawType);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
