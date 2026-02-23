package androidx.navigation;

import androidx.navigation.s;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class t {
    public static final HashMap b = new HashMap();
    public final HashMap a = new HashMap();

    public static String c(Class cls) {
        HashMap hashMap = b;
        String str = (String) hashMap.get(cls);
        if (str == null) {
            s.b bVar = (s.b) cls.getAnnotation(s.b.class);
            str = bVar != null ? bVar.value() : null;
            if (!g(str)) {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for " + cls.getSimpleName());
            }
            hashMap.put(cls, str);
        }
        return str;
    }

    public static boolean g(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    public final s a(s sVar) {
        return b(c(sVar.getClass()), sVar);
    }

    public s b(String str, s sVar) {
        if (g(str)) {
            return (s) this.a.put(str, sVar);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    public final s d(Class cls) {
        return e(c(cls));
    }

    public s e(String str) {
        if (!g(str)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        s sVar = (s) this.a.get(str);
        if (sVar != null) {
            return sVar;
        }
        throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
    }

    public Map f() {
        return this.a;
    }
}
