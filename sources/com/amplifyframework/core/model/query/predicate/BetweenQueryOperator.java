package com.amplifyframework.core.model.query.predicate;

import O.c;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class BetweenQueryOperator extends QueryOperator {
    private final Comparable end;
    private final Comparable start;

    public BetweenQueryOperator(Comparable comparable, Comparable comparable2) {
        super(QueryOperator.Type.BETWEEN);
        this.start = comparable;
        this.end = comparable2;
    }

    public Comparable end() {
        return this.end;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BetweenQueryOperator.class != obj.getClass()) {
            return false;
        }
        BetweenQueryOperator betweenQueryOperator = (BetweenQueryOperator) obj;
        return c.a(type(), betweenQueryOperator.type()) && c.a(start(), betweenQueryOperator.start()) && c.a(end(), betweenQueryOperator.end());
    }

    public boolean evaluate(Comparable comparable) {
        return comparable.compareTo(this.start) >= 0 && comparable.compareTo(this.end) <= 0;
    }

    public int hashCode() {
        return c.b(type(), start(), end());
    }

    public Comparable start() {
        return this.start;
    }

    public String toString() {
        return "BetweenQueryOperator { type: " + type() + ", start: " + this.start + ", end: " + this.end + " }";
    }
}
