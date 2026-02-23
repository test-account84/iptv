package org.simpleframework.xml.convert;

import org.simpleframework.xml.strategy.Value;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Reference implements Value {
    private Class actual;
    private Object data;
    private Value value;

    public Reference(Value value, Object obj, Class cls) {
        this.actual = cls;
        this.value = value;
        this.data = obj;
    }

    public int getLength() {
        return 0;
    }

    public Class getType() {
        Object obj = this.data;
        return obj != null ? obj.getClass() : this.actual;
    }

    public Object getValue() {
        return this.data;
    }

    public boolean isReference() {
        return true;
    }

    public void setValue(Object obj) {
        Value value = this.value;
        if (value != null) {
            value.setValue(obj);
        }
        this.data = obj;
    }
}
