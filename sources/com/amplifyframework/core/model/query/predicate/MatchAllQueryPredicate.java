package com.amplifyframework.core.model.query.predicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class MatchAllQueryPredicate implements QueryPredicate {
    private MatchAllQueryPredicate() {
    }

    public static MatchAllQueryPredicate instance() {
        return new MatchAllQueryPredicate();
    }

    public QueryPredicate and(QueryPredicate queryPredicate) {
        return queryPredicate;
    }

    public boolean equals(Object obj) {
        return obj instanceof MatchAllQueryPredicate;
    }

    public boolean evaluate(Object obj) {
        return true;
    }

    public int hashCode() {
        return MatchAllQueryPredicate.class.hashCode();
    }

    public QueryPredicate or(QueryPredicate queryPredicate) {
        return this;
    }

    public String toString() {
        return MatchAllQueryPredicate.class.getSimpleName();
    }
}
