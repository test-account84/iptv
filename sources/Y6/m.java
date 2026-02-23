package Y6;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class m implements j {
    public Collection a;
    public Map b;
    public String c;
    public int d;

    public m() {
    }

    public i a(Map map) {
        Map enumMap = new EnumMap(x6.e.class);
        enumMap.putAll(map);
        Map map2 = this.b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection collection = this.a;
        if (collection != null) {
            enumMap.put(x6.e.POSSIBLE_FORMATS, collection);
        }
        String str = this.c;
        if (str != null) {
            enumMap.put(x6.e.CHARACTER_SET, str);
        }
        x6.j jVar = new x6.j();
        jVar.e(enumMap);
        int i = this.d;
        return i != 0 ? i != 1 ? i != 2 ? new i(jVar) : new o(jVar) : new n(jVar) : new i(jVar);
    }

    public m(Collection collection, Map map, String str, int i) {
        this.a = collection;
        this.b = map;
        this.c = str;
        this.d = i;
    }
}
