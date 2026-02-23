package x5;

import java.lang.reflect.Type;
import r5.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class c {
    public static final g a = g.g(", ").i("null");

    public static String a(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
