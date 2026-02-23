package com.google.ads.interactivemedia.v3.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class blt {
    public static final blt c;

    static {
        blt blsVar;
        try {
            try {
                try {
                    Class cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    blsVar = new blp(cls.getMethod("allocateInstance", new Class[]{Class.class}), declaredField.get((Object) null));
                } catch (Exception unused) {
                    Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    declaredMethod.setAccessible(true);
                    blsVar = new blr(declaredMethod);
                }
            } catch (Exception unused2) {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod2.setAccessible(true);
                int intValue = ((Integer) declaredMethod2.invoke((Object) null, new Object[]{Object.class})).intValue();
                Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                declaredMethod3.setAccessible(true);
                blsVar = new blq(declaredMethod3, intValue);
            }
        } catch (Exception unused3) {
            blsVar = new bls();
        }
        c = blsVar;
    }

    public static /* bridge */ /* synthetic */ void b(Class cls) {
        String b = bkw.b(cls);
        if (b != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(b));
        }
    }

    public abstract Object a(Class cls) throws Exception;
}
