package androidx.fragment.app;

import androidx.fragment.app.Fragment;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class i {
    public static final s.i a = new s.i();

    public static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class c(ClassLoader classLoader, String str) {
        s.i iVar = a;
        s.i iVar2 = (s.i) iVar.get(classLoader);
        if (iVar2 == null) {
            iVar2 = new s.i();
            iVar.put(classLoader, iVar2);
        }
        Class cls = (Class) iVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class cls2 = Class.forName(str, false, classLoader);
        iVar2.put(str, cls2);
        return cls2;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassNotFoundException e) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class name exists", e);
        } catch (ClassCastException e2) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e2);
        }
    }

    public abstract Fragment a(ClassLoader classLoader, String str);
}
