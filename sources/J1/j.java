package J1;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class j {
    public static void a(Object obj, h hVar) {
        if (obj == null) {
            hVar.h();
            return;
        }
        if (obj instanceof Map) {
            hVar.c();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                hVar.g(entry.getKey().toString());
                a(entry.getValue(), hVar);
            }
            hVar.e();
            return;
        }
        if (obj instanceof List) {
            hVar.a();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(it.next(), hVar);
            }
            hVar.d();
            return;
        }
        if (obj instanceof Boolean) {
            hVar.n((Boolean) obj);
        } else if (obj instanceof Number) {
            hVar.o((Number) obj);
        } else {
            hVar.p(obj.toString());
        }
    }
}
