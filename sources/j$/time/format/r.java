package j$.time.format;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class r {
    private final Map a;

    r(Map map) {
        this.a = map;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                String str = (String) entry2.getValue();
                String str2 = (String) entry2.getValue();
                Long l = (Long) entry2.getKey();
                int i = b.c;
                hashMap2.put(str, new AbstractMap.SimpleImmutableEntry(str2, l));
            }
            ArrayList arrayList2 = new ArrayList(hashMap2.values());
            Collections.sort(arrayList2, b.a());
            hashMap.put((v) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            hashMap.put((Object) null, arrayList);
        }
        Collections.sort(arrayList, b.a());
    }

    final String a(long j, v vVar) {
        Map map = (Map) this.a.get(vVar);
        if (map != null) {
            return (String) map.get(Long.valueOf(j));
        }
        return null;
    }
}
