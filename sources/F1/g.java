package F1;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g {
    public static int a(Object obj, Object obj2) {
        return b(obj) - b(obj2);
    }

    public static int b(Object obj) {
        int i = 16;
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                i += b(it.next());
            }
            return i;
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes().length;
        }
        if (obj instanceof Boolean) {
            return 16;
        }
        if (obj instanceof BigDecimal) {
            return 32;
        }
        if (obj instanceof z1.d) {
            return ((z1.d) obj).c().getBytes().length + 16;
        }
        if (obj == null) {
            return 4;
        }
        throw new IllegalStateException("Unknown field type in Record. " + obj.getClass().getName());
    }
}
