package org.simpleframework.xml.strategy;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Allocate implements Value {
    private String key;
    private Map map;
    private Value value;

    public Allocate(Value value, Map map, String str) {
        this.value = value;
        this.map = map;
        this.key = str;
    }

    public int getLength() {
        return this.value.getLength();
    }

    public Class getType() {
        return this.value.getType();
    }

    public Object getValue() {
        return this.map.get(this.key);
    }

    public boolean isReference() {
        return false;
    }

    public void setValue(Object obj) {
        String str = this.key;
        if (str != null) {
            this.map.put(str, obj);
        }
        this.value.setValue(obj);
    }
}
