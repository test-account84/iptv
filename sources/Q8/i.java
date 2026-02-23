package q8;

import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class i {
    public static final i a = new i();
    public static final a b = new a(null, null, null);
    public static a c;

    public static final class a {
        public final Method a;
        public final Method b;
        public final Method c;

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }

    public final a a(q8.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", (Class[]) null), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", (Class[]) null), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", (Class[]) null));
            c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = b;
            c = aVar3;
            return aVar3;
        }
    }

    public final String b(q8.a continuation) {
        kotlin.jvm.internal.l.e(continuation, "continuation");
        a aVar = c;
        if (aVar == null) {
            aVar = a(continuation);
        }
        if (aVar == b) {
            return null;
        }
        Method method = aVar.a;
        Object invoke = method != null ? method.invoke(continuation.getClass(), (Object[]) null) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar.b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, (Object[]) null) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar.c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, (Object[]) null) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
