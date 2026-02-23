package s5;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class c extends d implements F {
    public c(Map map) {
        super(map);
    }

    public Map b() {
        return super.b();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    public Collection x(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    public Collection y(Object obj, Collection collection) {
        return z(obj, (List) collection, null);
    }

    public List get(Object obj) {
        return super.get(obj);
    }
}
