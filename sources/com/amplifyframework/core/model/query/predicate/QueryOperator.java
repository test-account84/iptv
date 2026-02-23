package com.amplifyframework.core.model.query.predicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class QueryOperator implements Evaluable {
    private final Type type;

    public enum Type {
        NOT_EQUAL,
        EQUAL,
        LESS_OR_EQUAL,
        LESS_THAN,
        GREATER_OR_EQUAL,
        GREATER_THAN,
        CONTAINS,
        NOT_CONTAINS,
        BETWEEN,
        BEGINS_WITH
    }

    public QueryOperator(Type type) {
        this.type = type;
    }

    public Type type() {
        return this.type;
    }
}
