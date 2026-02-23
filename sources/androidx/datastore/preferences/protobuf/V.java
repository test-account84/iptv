package androidx.datastore.preferences.protobuf;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class v implements N {
    public static final v a = new v();

    public static v c() {
        return a;
    }

    public M a(Class cls) {
        if (!w.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (M) w.u(cls.asSubclass(w.class)).m();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
        }
    }

    public boolean b(Class cls) {
        return w.class.isAssignableFrom(cls);
    }
}
