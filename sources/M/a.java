package m;

import java.util.HashMap;
import java.util.Map;
import m.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a extends b {
    public HashMap f = new HashMap();

    public boolean contains(Object obj) {
        return this.f.containsKey(obj);
    }

    public b.c e(Object obj) {
        return (b.c) this.f.get(obj);
    }

    public Object i(Object obj, Object obj2) {
        b.c e = e(obj);
        if (e != null) {
            return e.c;
        }
        this.f.put(obj, h(obj, obj2));
        return null;
    }

    public Object j(Object obj) {
        Object j = super.j(obj);
        this.f.remove(obj);
        return j;
    }

    public Map.Entry l(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f.get(obj)).e;
        }
        return null;
    }
}
