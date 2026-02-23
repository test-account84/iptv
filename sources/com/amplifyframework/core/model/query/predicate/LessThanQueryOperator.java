package com.amplifyframework.core.model.query.predicate;

import O.c;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class LessThanQueryOperator extends QueryOperator {
    private final Comparable value;

    public LessThanQueryOperator(Comparable comparable) {
        super(QueryOperator.Type.LESS_THAN);
        this.value = comparable;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LessThanQueryOperator.class != obj.getClass()) {
            return false;
        }
        LessThanQueryOperator lessThanQueryOperator = (LessThanQueryOperator) obj;
        return c.a(type(), lessThanQueryOperator.type()) && c.a(value(), lessThanQueryOperator.value());
    }

    public boolean evaluate(Comparable comparable) {
        return comparable.compareTo(this.value) < 0;
    }

    public int hashCode() {
        return c.b(type(), value());
    }

    public String toString() {
        return "LessThanQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public Comparable value() {
        return this.value;
    }
}
