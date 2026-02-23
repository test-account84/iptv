package org.simpleframework.xml.core;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class SignatureCreator implements Creator {
    private final List list;
    private final Signature signature;
    private final Class type;

    public SignatureCreator(Signature signature) {
        this.type = signature.getType();
        this.list = signature.getAll();
        this.signature = signature;
    }

    private double getAdjustment(double d) {
        return d > 0.0d ? (this.list.size() / 1000.0d) + (d / this.list.size()) : d / this.list.size();
    }

    private double getPercentage(Criteria criteria) throws Exception {
        double d = 0.0d;
        for (Parameter parameter : this.list) {
            if (criteria.get(parameter.getKey()) != null) {
                d += 1.0d;
            } else if (parameter.isRequired() || parameter.isPrimitive()) {
                return -1.0d;
            }
        }
        return getAdjustment(d);
    }

    private Object getVariable(Criteria criteria, int i) throws Exception {
        Variable remove = criteria.remove(((Parameter) this.list.get(i)).getKey());
        if (remove != null) {
            return remove.getValue();
        }
        return null;
    }

    public Object getInstance() throws Exception {
        return this.signature.create();
    }

    public double getScore(Criteria criteria) throws Exception {
        Signature copy = this.signature.copy();
        for (Object obj : criteria) {
            Parameter parameter = copy.get(obj);
            Variable variable = criteria.get(obj);
            Contact contact = variable.getContact();
            if (parameter != null && !Support.isAssignable(variable.getValue().getClass(), parameter.getType())) {
                return -1.0d;
            }
            if (contact.isReadOnly() && parameter == null) {
                return -1.0d;
            }
        }
        return getPercentage(criteria);
    }

    public Signature getSignature() {
        return this.signature;
    }

    public Class getType() {
        return this.type;
    }

    public String toString() {
        return this.signature.toString();
    }

    public Object getInstance(Criteria criteria) throws Exception {
        Object[] array = this.list.toArray();
        for (int i = 0; i < this.list.size(); i++) {
            array[i] = getVariable(criteria, i);
        }
        return this.signature.create(array);
    }
}
