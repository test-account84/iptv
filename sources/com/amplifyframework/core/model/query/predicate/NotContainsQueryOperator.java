package com.amplifyframework.core.model.query.predicate;

import O.c;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class NotContainsQueryOperator extends QueryOperator {
    private final String value;

    public NotContainsQueryOperator(String str) {
        super(QueryOperator.Type.NOT_CONTAINS);
        this.value = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NotContainsQueryOperator.class != obj.getClass()) {
            return false;
        }
        NotContainsQueryOperator notContainsQueryOperator = (NotContainsQueryOperator) obj;
        return c.a(type(), notContainsQueryOperator.type()) && c.a(value(), notContainsQueryOperator.value());
    }

    public int hashCode() {
        return c.b(type(), value());
    }

    public String toString() {
        return "NotContainsQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public Object value() {
        return this.value;
    }

    public boolean evaluate(String str) {
        return !str.contains(this.value);
    }
}
