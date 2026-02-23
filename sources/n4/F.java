package n4;

import java.util.Collection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class f {
    public static String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("applicationId cannot be null");
        }
        G0 g0 = new G0(null);
        G0.a(g0, str);
        return I0.a(G0.c(g0));
    }

    public static String b(String str, Collection collection) {
        if (str == null) {
            throw new IllegalArgumentException("applicationId cannot be null");
        }
        if (collection == null) {
            throw new IllegalArgumentException("namespaces cannot be null");
        }
        G0 g0 = new G0(null);
        G0.a(g0, str);
        G0.b(g0, collection);
        return I0.a(G0.c(g0));
    }
}
