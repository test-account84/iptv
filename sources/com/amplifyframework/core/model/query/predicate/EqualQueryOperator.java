package com.amplifyframework.core.model.query.predicate;

import O.c;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class EqualQueryOperator extends QueryOperator {
    private final Object value;

    public EqualQueryOperator(Object obj) {
        super(QueryOperator.Type.EQUAL);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EqualQueryOperator.class != obj.getClass()) {
            return false;
        }
        EqualQueryOperator equalQueryOperator = (EqualQueryOperator) obj;
        return c.a(type(), equalQueryOperator.type()) && c.a(value(), equalQueryOperator.value());
    }

    public boolean evaluate(Object obj) {
        return obj.equals(this.value);
    }

    public int hashCode() {
        return c.b(type(), value());
    }

    public String toString() {
        return "EqualQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public Object value() {
        return this.value;
    }
}
