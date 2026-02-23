package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ObjectInstance implements Instance {
    private final Context context;
    private final Class type;
    private final Value value;

    public ObjectInstance(Context context, Value value) {
        this.type = value.getType();
        this.context = context;
        this.value = value;
    }

    public Object getInstance() throws Exception {
        if (this.value.isReference()) {
            return this.value.getValue();
        }
        Object objectInstance = getInstance(this.type);
        Value value = this.value;
        if (value != null) {
            value.setValue(objectInstance);
        }
        return objectInstance;
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

    public Object getInstance(Class cls) throws Exception {
        return this.context.getInstance(cls).getInstance();
    }
}
