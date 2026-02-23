package com.amplifyframework.core.model.query.predicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class QueryPredicates {
    private QueryPredicates() {
    }

    public static QueryPredicate all() {
        return MatchAllQueryPredicate.instance();
    }

    public static QueryPredicate none() {
        return MatchNoneQueryPredicate.instance();
    }
}
