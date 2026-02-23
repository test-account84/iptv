package com.amplifyframework.core.model.query.predicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface QueryPredicate extends Evaluable {
    QueryPredicate and(QueryPredicate queryPredicate);

    QueryPredicate or(QueryPredicate queryPredicate);
}
