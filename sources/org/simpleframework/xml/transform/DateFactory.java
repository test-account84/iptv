package org.simpleframework.xml.transform;

import java.lang.reflect.Constructor;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class DateFactory {
    private final Constructor factory;

    public DateFactory(Class cls) throws Exception {
        this(cls, Long.TYPE);
    }

    public Date getInstance(Object... objArr) throws Exception {
        return (Date) this.factory.newInstance(objArr);
    }

    public DateFactory(Class cls, Class... clsArr) throws Exception {
        this.factory = cls.getDeclaredConstructor(clsArr);
    }
}
