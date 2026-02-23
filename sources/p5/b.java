package P5;

import O5.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b {
    public final Map a = new HashMap();
    public final int b;
    public final int c;

    public b(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public static String c(String str, int i) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > i ? trim.substring(0, i) : trim;
    }

    public synchronized Map a() {
        return Collections.unmodifiableMap(new HashMap(this.a));
    }

    public final String b(String str) {
        if (str != null) {
            return c(str, this.c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public synchronized boolean d(String str, String str2) {
        String b = b(str);
        if (this.a.size() >= this.b && !this.a.containsKey(b)) {
            L5.f.f().k("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.b);
            return false;
        }
        String c = c(str2, this.c);
        if (i.B((String) this.a.get(b), c)) {
            return false;
        }
        Map map = this.a;
        if (str2 == null) {
            c = "";
        }
        map.put(b, c);
        return true;
    }

    public synchronized void e(Map map) {
        try {
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                String b = b((String) entry.getKey());
                if (this.a.size() < this.b || this.a.containsKey(b)) {
                    String str = (String) entry.getValue();
                    this.a.put(b, str == null ? "" : c(str, this.c));
                } else {
                    i++;
                }
            }
            if (i > 0) {
                L5.f.f().k("Ignored " + i + " entries when adding custom keys. Maximum allowable: " + this.b);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
