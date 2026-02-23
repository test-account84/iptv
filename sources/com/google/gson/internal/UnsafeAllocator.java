package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class UnsafeAllocator {

    public class 1 extends UnsafeAllocator {
        final /* synthetic */ Method val$allocateInstance;
        final /* synthetic */ Object val$unsafe;

        public 1(Method method, Object obj) {
            this.val$allocateInstance = method;
            this.val$unsafe = obj;
        }

        public Object newInstance(Class cls) throws Exception {
            UnsafeAllocator.assertInstantiable(cls);
            return this.val$allocateInstance.invoke(this.val$unsafe, new Object[]{cls});
        }
    }

    public class 2 extends UnsafeAllocator {
        final /* synthetic */ int val$constructorId;
        final /* synthetic */ Method val$newInstance;

        public 2(Method method, int i) {
            this.val$newInstance = method;
            this.val$constructorId = i;
        }

        public Object newInstance(Class cls) throws Exception {
            UnsafeAllocator.assertInstantiable(cls);
            return this.val$newInstance.invoke((Object) null, new Object[]{cls, Integer.valueOf(this.val$constructorId)});
        }
    }

    public class 3 extends UnsafeAllocator {
        final /* synthetic */ Method val$newInstance;

        public 3(Method method) {
            this.val$newInstance = method;
        }

        public Object newInstance(Class cls) throws Exception {
            UnsafeAllocator.assertInstantiable(cls);
            return this.val$newInstance.invoke((Object) null, new Object[]{cls, Object.class});
        }
    }

    public class 4 extends UnsafeAllocator {
        public Object newInstance(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static void assertInstantiable(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static UnsafeAllocator create() {
        try {
            try {
                try {
                    Class cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    return new 1(cls.getMethod("allocateInstance", new Class[]{Class.class}), declaredField.get((Object) null));
                } catch (Exception unused) {
                    Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    declaredMethod.setAccessible(true);
                    return new 3(declaredMethod);
                }
            } catch (Exception unused2) {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod2.setAccessible(true);
                int intValue = ((Integer) declaredMethod2.invoke((Object) null, new Object[]{Object.class})).intValue();
                Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                declaredMethod3.setAccessible(true);
                return new 2(declaredMethod3, intValue);
            }
        } catch (Exception unused3) {
            return new 4();
        }
    }

    public abstract Object newInstance(Class cls) throws Exception;
}
