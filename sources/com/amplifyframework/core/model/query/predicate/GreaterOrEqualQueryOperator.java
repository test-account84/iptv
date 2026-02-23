package com.amplifyframework.core.model.query.predicate;

import O.c;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class GreaterOrEqualQueryOperator extends QueryOperator {
    private final Comparable value;

    public GreaterOrEqualQueryOperator(Comparable comparable) {
        super(QueryOperator.Type.GREATER_OR_EQUAL);
        this.value = comparable;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GreaterOrEqualQueryOperator.class != obj.getClass()) {
            return false;
        }
        GreaterOrEqualQueryOperator greaterOrEqualQueryOperator = (GreaterOrEqualQueryOperator) obj;
        return c.a(type(), greaterOrEqualQueryOperator.type()) && c.a(value(), greaterOrEqualQueryOperator.value());
    }

    public boolean evaluate(Comparable comparable) {
        return comparable.compareTo(this.value) >= 0;
    }

    public int hashCode() {
        return c.b(type(), value());
    }

    public String toString() {
        return "GreaterOrEqualQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public Comparable value() {
        return this.value;
    }
}
