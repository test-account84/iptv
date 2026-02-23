package F1;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import okio.Buffer;
import v1.f;
import v1.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f implements F1.a {
    public final Comparator a = new a();

    public class a implements Comparator {
        public a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public String a(k kVar, f.b bVar) {
        x1.g.c(kVar, "field == null");
        x1.g.c(bVar, "variables == null");
        if (kVar.a().isEmpty()) {
            return kVar.c();
        }
        Map b = b(kVar.a(), bVar);
        try {
            Buffer buffer = new Buffer();
            J1.h i = J1.h.i(buffer);
            i.m(true);
            J1.j.a(b, i);
            i.close();
            return String.format("%s(%s)", new Object[]{kVar.c(), buffer.readUtf8()});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final Map b(Map map, f.b bVar) {
        TreeMap treeMap = new TreeMap(this.a);
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() instanceof Map) {
                Map map2 = (Map) entry.getValue();
                treeMap.put(entry.getKey(), k.h(map2) ? c(map2, bVar) : b(map2, bVar));
            } else {
                treeMap.put(entry.getKey(), entry.getValue());
            }
        }
        return treeMap;
    }

    public final Object c(Map map, f.b bVar) {
        Object obj = bVar.valueMap().get(map.get("variableName"));
        if (obj == null) {
            return null;
        }
        return obj instanceof Map ? b((Map) obj, bVar) : obj;
    }
}
