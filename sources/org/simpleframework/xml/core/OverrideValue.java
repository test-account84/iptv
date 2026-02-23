package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class OverrideValue implements Value {
    private final Class type;
    private final Value value;

    public OverrideValue(Value value, Class cls) {
        this.value = value;
        this.type = cls;
    }

    public int getLength() {
        return this.value.getLength();
    }

    public Class getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value.getValue();
    }

    public boolean isReference() {
        return this.value.isReference();
    }

    public void setValue(Object obj) {
        this.value.setValue(obj);
    }
}
