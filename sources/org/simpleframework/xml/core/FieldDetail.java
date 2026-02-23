package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class FieldDetail {
    private final Field field;
    private final Annotation[] list;
    private final String name;

    public FieldDetail(Field field) {
        this.list = field.getDeclaredAnnotations();
        this.name = field.getName();
        this.field = field;
    }

    public Annotation[] getAnnotations() {
        return this.list;
    }

    public Field getField() {
        return this.field;
    }

    public String getName() {
        return this.name;
    }
}
