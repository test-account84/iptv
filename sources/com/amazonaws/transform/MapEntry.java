package com.amazonaws.transform;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MapEntry implements Map.Entry {
    private Object key;
    private Object value;

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public Object setKey(Object obj) {
        this.key = obj;
        return obj;
    }

    public Object setValue(Object obj) {
        this.value = obj;
        return obj;
    }
}
