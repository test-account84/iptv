package com.amplifyframework.core.model.query.predicate;

import O.c;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class LessOrEqualQueryOperator extends QueryOperator {
    private final Comparable value;

    public LessOrEqualQueryOperator(Comparable comparable) {
        super(QueryOperator.Type.LESS_OR_EQUAL);
        this.value = comparable;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LessOrEqualQueryOperator.class != obj.getClass()) {
            return false;
        }
        LessOrEqualQueryOperator lessOrEqualQueryOperator = (LessOrEqualQueryOperator) obj;
        return c.a(type(), lessOrEqualQueryOperator.type()) && c.a(value(), lessOrEqualQueryOperator.value());
    }

    public boolean evaluate(Comparable comparable) {
        return comparable.compareTo(this.value) <= 0;
    }

    public int hashCode() {
        return c.b(type(), value());
    }

    public String toString() {
        return "LessOrEqualQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public Comparable value() {
        return this.value;
    }
}
