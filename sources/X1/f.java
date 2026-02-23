package x1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f {
    public final Map a;

    public f(int i) {
        this.a = new HashMap(i);
    }

    public Map a() {
        return Collections.unmodifiableMap(this.a);
    }

    public f b(Object obj, Object obj2) {
        this.a.put(obj, obj2);
        return this;
    }
}
