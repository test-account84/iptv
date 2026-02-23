package org.simpleframework.xml.convert;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ConverterFactory {
    private final Cache cache = new ConcurrentCache();

    private Constructor getConstructor(Class cls) throws Exception {
        Constructor declaredConstructor = cls.getDeclaredConstructor((Class[]) null);
        if (!declaredConstructor.isAccessible()) {
            declaredConstructor.setAccessible(true);
        }
        return declaredConstructor;
    }

    private Converter getConverter(Class cls) throws Exception {
        Constructor constructor = getConstructor(cls);
        if (constructor != null) {
            return getConverter(cls, constructor);
        }
        throw new ConvertException("No default constructor for %s", cls);
    }

    public Converter getInstance(Class cls) throws Exception {
        Converter converter = (Converter) this.cache.fetch(cls);
        return converter == null ? getConverter(cls) : converter;
    }

    private Converter getConverter(Class cls, Constructor constructor) throws Exception {
        Converter converter = (Converter) constructor.newInstance((Object[]) null);
        if (converter != null) {
            this.cache.cache(cls, converter);
        }
        return converter;
    }

    public Converter getInstance(Convert convert) throws Exception {
        Class value = convert.value();
        if (value.isInterface()) {
            throw new ConvertException("Can not instantiate %s", value);
        }
        return getInstance(value);
    }
}
