package org.simpleframework.xml.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class LimitedCache extends LinkedHashMap implements Cache {
    private final int capacity;

    public LimitedCache() {
        this(50000);
    }

    public void cache(Object obj, Object obj2) {
        put(obj, obj2);
    }

    public boolean contains(Object obj) {
        return containsKey(obj);
    }

    public Object fetch(Object obj) {
        return get(obj);
    }

    public boolean removeEldestEntry(Map.Entry entry) {
        return size() > this.capacity;
    }

    public Object take(Object obj) {
        return remove(obj);
    }

    public LimitedCache(int i) {
        this.capacity = i;
    }
}
