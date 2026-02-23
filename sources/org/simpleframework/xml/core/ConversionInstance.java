package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ConversionInstance implements Instance {
    private final Context context;
    private final Class convert;
    private final Value value;

    public ConversionInstance(Context context, Value value, Class cls) throws Exception {
        this.context = context;
        this.convert = cls;
        this.value = value;
    }

    public Object getInstance() throws Exception {
        if (this.value.isReference()) {
            return this.value.getValue();
        }
        Object conversionInstance = getInstance(this.convert);
        if (conversionInstance != null) {
            setInstance(conversionInstance);
        }
        return conversionInstance;
    }

    public Class getType() {
        return this.convert;
    }

    public boolean isReference() {
        return this.value.isReference();
    }

    public Object setInstance(Object obj) throws Exception {
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
