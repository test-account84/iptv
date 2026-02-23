package retrofit2;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class g {
    public static /* bridge */ /* synthetic */ MethodHandle a(MethodHandles.Lookup lookup, Method method, Class cls) {
        return lookup.unreflectSpecial(method, cls);
    }
}
