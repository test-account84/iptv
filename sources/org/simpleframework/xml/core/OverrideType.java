package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class OverrideType implements Type {
    private final Class override;
    private final Type type;

    public OverrideType(Type type, Class cls) {
        this.override = cls;
        this.type = type;
    }

    public Annotation getAnnotation(Class cls) {
        return this.type.getAnnotation(cls);
    }

    public Class getType() {
        return this.override;
    }

    public String toString() {
        return this.type.toString();
    }
}
