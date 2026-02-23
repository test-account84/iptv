package com.amplifyframework.core.model.query.predicate;

import O.c;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class GreaterThanQueryOperator extends QueryOperator {
    private final Comparable value;

    public GreaterThanQueryOperator(Comparable comparable) {
        super(QueryOperator.Type.GREATER_THAN);
        this.value = comparable;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GreaterThanQueryOperator.class != obj.getClass()) {
            return false;
        }
        GreaterThanQueryOperator greaterThanQueryOperator = (GreaterThanQueryOperator) obj;
        return c.a(type(), greaterThanQueryOperator.type()) && c.a(value(), greaterThanQueryOperator.value());
    }

    public boolean evaluate(Comparable comparable) {
        return comparable.compareTo(this.value) > 0;
    }

    public int hashCode() {
        return c.b(type(), value());
    }

    public String toString() {
        return "GreaterThanQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public Comparable value() {
        return this.value;
    }
}
