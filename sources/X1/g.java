package x1;

import java.util.Iterator;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g {
    public static boolean a(Set set, Set set2) {
        if (set != null && set2 != null) {
            if (set.size() > set2.size()) {
                set2 = set;
                set = set2;
            }
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (set2.contains(it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Object b(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object c(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }
}
