package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class MethodContact implements Contact {
    private MethodPart get;
    private Class item;
    private Class[] items;
    private Annotation label;
    private String name;
    private Class owner;
    private MethodPart set;
    private Class type;

    public MethodContact(MethodPart methodPart) {
        this(methodPart, null);
    }

    public Object get(Object obj) throws Exception {
        return this.get.getMethod().invoke(obj, (Object[]) null);
    }

    public Annotation getAnnotation() {
        return this.label;
    }

    public Class getDeclaringClass() {
        return this.owner;
    }

    public Class getDependent() {
        return this.item;
    }

    public Class[] getDependents() {
        return this.items;
    }

    public String getName() {
        return this.name;
    }

    public MethodPart getRead() {
        return this.get;
    }

    public Class getType() {
        return this.type;
    }

    public MethodPart getWrite() {
        return this.set;
    }

    public boolean isReadOnly() {
        return this.set == null;
    }

    public void set(Object obj, Object obj2) throws Exception {
        Class declaringClass = this.get.getMethod().getDeclaringClass();
        MethodPart methodPart = this.set;
        if (methodPart == null) {
            throw new MethodException("Property '%s' is read only in %s", this.name, declaringClass);
        }
        methodPart.getMethod().invoke(obj, new Object[]{obj2});
    }

    public String toString() {
        return String.format("method '%s'", new Object[]{this.name});
    }

    public MethodContact(MethodPart methodPart, MethodPart methodPart2) {
        this.owner = methodPart.getDeclaringClass();
        this.label = methodPart.getAnnotation();
        this.items = methodPart.getDependents();
        this.item = methodPart.getDependent();
        this.type = methodPart.getType();
        this.name = methodPart.getName();
        this.set = methodPart2;
        this.get = methodPart;
    }

    public Annotation getAnnotation(Class cls) {
        MethodPart methodPart;
        Annotation annotation = this.get.getAnnotation(cls);
        return cls == this.label.annotationType() ? this.label : (annotation != null || (methodPart = this.set) == null) ? annotation : methodPart.getAnnotation(cls);
    }
}
