package com.amplifyframework.core.model.query.predicate;

import O.c;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class BeginsWithQueryOperator extends QueryOperator {
    private final String value;

    public BeginsWithQueryOperator(String str) {
        super(QueryOperator.Type.BEGINS_WITH);
        this.value = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BeginsWithQueryOperator.class != obj.getClass()) {
            return false;
        }
        BeginsWithQueryOperator beginsWithQueryOperator = (BeginsWithQueryOperator) obj;
        return c.a(type(), beginsWithQueryOperator.type()) && c.a(value(), beginsWithQueryOperator.value());
    }

    public int hashCode() {
        return c.b(type(), value());
    }

    public String toString() {
        return "BeginsWithQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public Object value() {
        return this.value;
    }

    public boolean evaluate(String str) {
        return str.indexOf(this.value) == 0;
    }
}
