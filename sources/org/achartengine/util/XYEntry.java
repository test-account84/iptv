package org.achartengine.util;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class XYEntry implements Map.Entry {
    private final Object key;
    private Object value;

    public XYEntry(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public Object setValue(Object obj) {
        this.value = obj;
        return obj;
    }
}
