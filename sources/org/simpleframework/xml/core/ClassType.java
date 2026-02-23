package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ClassType implements Type {
    private final Class type;

    public ClassType(Class cls) {
        this.type = cls;
    }

    public Annotation getAnnotation(Class cls) {
        return null;
    }

    public Class getType() {
        return this.type;
    }

    public String toString() {
        return this.type.toString();
    }
}
