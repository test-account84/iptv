package com.google.gson;

import com.google.gson.internal.$Gson$Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class FieldAttributes {
    private final Field field;

    public FieldAttributes(Field field) {
        $Gson$Preconditions.checkNotNull(field);
        this.field = field;
    }

    public Object get(Object obj) throws IllegalAccessException {
        return this.field.get(obj);
    }

    public Annotation getAnnotation(Class cls) {
        return this.field.getAnnotation(cls);
    }

    public Collection getAnnotations() {
        return Arrays.asList(this.field.getAnnotations());
    }

    public Class getDeclaredClass() {
        return this.field.getType();
    }

    public Type getDeclaredType() {
        return this.field.getGenericType();
    }

    public Class getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public String getName() {
        return this.field.getName();
    }

    public boolean hasModifier(int i) {
        return (i & this.field.getModifiers()) != 0;
    }

    public boolean isSynthetic() {
        return this.field.isSynthetic();
    }
}
