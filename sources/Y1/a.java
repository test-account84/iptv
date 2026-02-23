package y1;

import java.util.Collections;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a {
    public static final a b = new a(Collections.emptyMap());
    public final Map a;

    public a(Map map) {
        this.a = map;
    }

    public boolean a(String str) {
        return this.a.containsKey(str);
    }
}
