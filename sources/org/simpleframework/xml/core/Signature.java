package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Signature implements Iterable {
    private final Constructor factory;
    private final ParameterMap parameters;
    private final Class type;

    public Signature(Constructor constructor) {
        this(constructor, constructor.getDeclaringClass());
    }

    public void add(Parameter parameter) {
        Object key = parameter.getKey();
        if (key != null) {
            this.parameters.put(key, parameter);
        }
    }

    public boolean contains(Object obj) {
        return this.parameters.containsKey(obj);
    }

    public Signature copy() throws Exception {
        Signature signature = new Signature(this);
        Iterator it = iterator();
        while (it.hasNext()) {
            signature.add((Parameter) it.next());
        }
        return signature;
    }

    public Object create() throws Exception {
        if (!this.factory.isAccessible()) {
            this.factory.setAccessible(true);
        }
        return this.factory.newInstance((Object[]) null);
    }

    public Parameter get(int i) {
        return this.parameters.get(i);
    }

    public List getAll() {
        return this.parameters.getAll();
    }

    public Class getType() {
        return this.type;
    }

    public boolean isEmpty() {
        return this.parameters.isEmpty();
    }

    public Iterator iterator() {
        return this.parameters.iterator();
    }

    public Parameter remove(Object obj) {
        return (Parameter) this.parameters.remove(obj);
    }

    public void set(Object obj, Parameter parameter) {
        this.parameters.put(obj, parameter);
    }

    public int size() {
        return this.parameters.size();
    }

    public String toString() {
        return this.factory.toString();
    }

    public Signature(Constructor constructor, Class cls) {
        this.parameters = new ParameterMap();
        this.factory = constructor;
        this.type = cls;
    }

    public Object create(Object[] objArr) throws Exception {
        if (!this.factory.isAccessible()) {
            this.factory.setAccessible(true);
        }
        return this.factory.newInstance(objArr);
    }

    public Parameter get(Object obj) {
        return (Parameter) this.parameters.get(obj);
    }

    public Signature(Signature signature) {
        this(signature.factory, signature.type);
    }
}
