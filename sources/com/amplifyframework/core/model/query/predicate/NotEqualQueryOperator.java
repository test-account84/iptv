package com.amplifyframework.core.model.query.predicate;

import O.c;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class NotEqualQueryOperator extends QueryOperator {
    private final Object value;

    public NotEqualQueryOperator(Object obj) {
        super(QueryOperator.Type.NOT_EQUAL);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NotEqualQueryOperator.class != obj.getClass()) {
            return false;
        }
        NotEqualQueryOperator notEqualQueryOperator = (NotEqualQueryOperator) obj;
        return c.a(type(), notEqualQueryOperator.type()) && c.a(value(), notEqualQueryOperator.value());
    }

    public boolean evaluate(Object obj) {
        return !obj.equals(this.value);
    }

    public int hashCode() {
        return c.b(type(), value());
    }

    public String toString() {
        return "NotEqualQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public Object value() {
        return this.value;
    }
}
