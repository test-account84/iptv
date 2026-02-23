package com.amplifyframework.core.model.query.predicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class MatchNoneQueryPredicate implements QueryPredicate {
    private MatchNoneQueryPredicate() {
    }

    public static MatchNoneQueryPredicate instance() {
        return new MatchNoneQueryPredicate();
    }

    public QueryPredicate and(QueryPredicate queryPredicate) {
        return this;
    }

    public boolean equals(Object obj) {
        return obj instanceof MatchNoneQueryPredicate;
    }

    public boolean evaluate(Object obj) {
        return false;
    }

    public int hashCode() {
        return MatchNoneQueryPredicate.class.hashCode();
    }

    public QueryPredicate or(QueryPredicate queryPredicate) {
        return queryPredicate;
    }

    public String toString() {
        return MatchNoneQueryPredicate.class.getSimpleName();
    }
}
