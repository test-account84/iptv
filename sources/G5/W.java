package G5;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class w {
    public String a;
    public Map b;

    public w(String str, Map map) {
        this.a = str;
        this.b = map;
    }

    public Map a() {
        return this.b;
    }

    public String b() {
        Map map = (Map) this.b.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_provider");
        }
        return null;
    }
}
