package v1;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import v1.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class k {
    public final b a;
    public final String b;
    public final String c;
    public final Map d;
    public final boolean e;
    public final List f;

    public static final class a extends k {
        public final s g;

        public a(String str, String str2, Map map, boolean z, s sVar, List list) {
            super(b.CUSTOM, str, str2, map, z, list, null);
            this.g = sVar;
        }

        public s m() {
            return this.g;
        }
    }

    public enum b {
        STRING,
        INT,
        LONG,
        DOUBLE,
        BOOLEAN,
        ENUM,
        OBJECT,
        LIST,
        CUSTOM,
        FRAGMENT,
        INLINE_FRAGMENT
    }

    public k(b bVar, String str, String str2, Map map, boolean z, List list) {
        this.a = bVar;
        this.b = str;
        this.c = str2;
        this.d = map == null ? Collections.emptyMap() : Collections.unmodifiableMap(map);
        this.e = z;
        this.f = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public static a d(String str, String str2, Map map, boolean z, s sVar, List list) {
        return new a(str, str2, map, z, sVar, list);
    }

    public static k e(String str, String str2, Map map, boolean z, List list) {
        return new k(b.LIST, str, str2, map, z, list);
    }

    public static k f(String str, String str2, Map map, boolean z, List list) {
        return new k(b.OBJECT, str, str2, map, z, list);
    }

    public static k g(String str, String str2, Map map, boolean z, List list) {
        return new k(b.STRING, str, str2, map, z, list);
    }

    public static boolean h(Map map) {
        return map.containsKey("kind") && map.get("kind").equals("Variable") && map.containsKey("variableName");
    }

    public Map a() {
        return this.d;
    }

    public List b() {
        return this.f;
    }

    public String c() {
        return this.c;
    }

    public boolean i() {
        return this.e;
    }

    public Object j(String str, f.b bVar) {
        x1.g.c(str, "name == null");
        x1.g.c(bVar, "variables == null");
        Map valueMap = bVar.valueMap();
        Object obj = this.d.get(str);
        if (!(obj instanceof Map)) {
            return obj;
        }
        Map map = (Map) obj;
        if (h(map)) {
            return valueMap.get(map.get("variableName").toString());
        }
        return null;
    }

    public String k() {
        return this.b;
    }

    public b l() {
        return this.a;
    }

    public /* synthetic */ k(b bVar, String str, String str2, Map map, boolean z, List list, j jVar) {
        this(bVar, str, str2, map, z, list);
    }
}
