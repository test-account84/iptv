package org.simpleframework.xml.util;

import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ConcurrentCache extends ConcurrentHashMap implements Cache {
    public void cache(Object obj, Object obj2) {
        put(obj, obj2);
    }

    public boolean contains(Object obj) {
        return containsKey(obj);
    }

    public Object fetch(Object obj) {
        return get(obj);
    }

    public Object take(Object obj) {
        return remove(obj);
    }
}
