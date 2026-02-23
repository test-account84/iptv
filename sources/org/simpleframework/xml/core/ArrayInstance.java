package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Value;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ArrayInstance implements Instance {
    private final int length;
    private final Class type;
    private final Value value;

    public ArrayInstance(Value value) {
        this.length = value.getLength();
        this.type = value.getType();
        this.value = value;
    }

    public Object getInstance() throws Exception {
        if (this.value.isReference()) {
            return this.value.getValue();
        }
        Object newInstance = Array.newInstance(this.type, this.length);
        Value value = this.value;
        if (value != null) {
            value.setValue(newInstance);
        }
        return newInstance;
    }

    public Class getType() {
        return this.type;
    }

    public boolean isReference() {
        return this.value.isReference();
    }

    public Object setInstance(Object obj) {
        Value value = this.value;
        if (value != null) {
            value.setValue(obj);
        }
        return obj;
    }
}
