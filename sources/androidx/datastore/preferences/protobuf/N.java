package androidx.datastore.preferences.protobuf;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class n {
    public static final Class a = c();

    public static o a() {
        if (a != null) {
            try {
                return b("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return o.e;
    }

    public static final o b(String str) {
        return (o) a.getDeclaredMethod(str, (Class[]) null).invoke((Object) null, (Object[]) null);
    }

    public static Class c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
