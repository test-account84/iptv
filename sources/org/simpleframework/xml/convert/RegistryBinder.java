package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class RegistryBinder {
    private final Cache cache = new ConcurrentCache();
    private final ConverterFactory factory = new ConverterFactory();

    private Converter create(Class cls) throws Exception {
        return this.factory.getInstance(cls);
    }

    public void bind(Class cls, Class cls2) throws Exception {
        this.cache.cache(cls, cls2);
    }

    public Converter lookup(Class cls) throws Exception {
        Class cls2 = (Class) this.cache.fetch(cls);
        if (cls2 != null) {
            return create(cls2);
        }
        return null;
    }
}
