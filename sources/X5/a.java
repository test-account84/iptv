package x5;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import r5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a {
    public final Type a() {
        ParameterizedType genericSuperclass = getClass().getGenericSuperclass();
        m.h(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return genericSuperclass.getActualTypeArguments()[0];
    }
}
