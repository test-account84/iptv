package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class FieldContact implements Contact {
    private final Cache cache = new ConcurrentCache();
    private final Field field;
    private final Annotation label;
    private final Annotation[] list;
    private final int modifier;
    private final String name;

    public FieldContact(Field field, Annotation annotation, Annotation[] annotationArr) {
        this.modifier = field.getModifiers();
        this.name = field.getName();
        this.label = annotation;
        this.field = field;
        this.list = annotationArr;
    }

    private Annotation getCache(Class cls) {
        if (this.cache.isEmpty()) {
            for (Annotation annotation : this.list) {
                this.cache.cache(annotation.annotationType(), annotation);
            }
        }
        return (Annotation) this.cache.fetch(cls);
    }

    public Object get(Object obj) throws Exception {
        return this.field.get(obj);
    }

    public Annotation getAnnotation() {
        return this.label;
    }

    public Class getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public Class getDependent() {
        return Reflector.getDependent(this.field);
    }

    public Class[] getDependents() {
        return Reflector.getDependents(this.field);
    }

    public String getName() {
        return this.name;
    }

    public Class getType() {
        return this.field.getType();
    }

    public boolean isFinal() {
        return Modifier.isFinal(this.modifier);
    }

    public boolean isReadOnly() {
        return !isStatic() && isFinal();
    }

    public boolean isStatic() {
        return Modifier.isStatic(this.modifier);
    }

    public void set(Object obj, Object obj2) throws Exception {
        if (isFinal()) {
            return;
        }
        this.field.set(obj, obj2);
    }

    public String toString() {
        return String.format("field '%s' %s", new Object[]{getName(), this.field.toString()});
    }

    public Annotation getAnnotation(Class cls) {
        return cls == this.label.annotationType() ? this.label : getCache(cls);
    }
}
