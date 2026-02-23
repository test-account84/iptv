package n4;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j0 {
    public final Map a = new HashMap();
    public final Map b = new HashMap();
    public final Map c = new HashMap();

    public final int a(String str) {
        Integer num = (Integer) this.c.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final j0 b(String str, String str2, int i) {
        this.a.put(str, str2);
        this.b.put(str2, str);
        this.c.put(str, Integer.valueOf(i));
        return this;
    }

    public final String c(String str) {
        return (String) this.a.get(str);
    }

    public final String d(String str) {
        return (String) this.b.get(str);
    }
}
