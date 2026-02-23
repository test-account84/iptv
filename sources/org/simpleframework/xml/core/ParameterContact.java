package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class ParameterContact implements Contact {
    protected final Constructor factory;
    protected final int index;
    protected final Annotation label;
    protected final Annotation[] labels;
    protected final Class owner;

    public ParameterContact(Annotation annotation, Constructor constructor, int i) {
        this.labels = constructor.getParameterAnnotations()[i];
        this.owner = constructor.getDeclaringClass();
        this.factory = constructor;
        this.index = i;
        this.label = annotation;
    }

    public Object get(Object obj) {
        return null;
    }

    public Annotation getAnnotation() {
        return this.label;
    }

    public Class getDeclaringClass() {
        return this.owner;
    }

    public Class getDependent() {
        return Reflector.getParameterDependent(this.factory, this.index);
    }

    public Class[] getDependents() {
        return Reflector.getParameterDependents(this.factory, this.index);
    }

    public abstract String getName();

    public Class getType() {
        return this.factory.getParameterTypes()[this.index];
    }

    public boolean isReadOnly() {
        return false;
    }

    public void set(Object obj, Object obj2) {
    }

    public String toString() {
        return String.format("parameter %s of constructor %s", new Object[]{Integer.valueOf(this.index), this.factory});
    }

    public Annotation getAnnotation(Class cls) {
        for (Annotation annotation : this.labels) {
            if (annotation.annotationType().equals(cls)) {
                return annotation;
            }
        }
        return null;
    }
}
