package com.amplifyframework.core.model.query;

import O.c;
import com.amplifyframework.core.model.query.predicate.QueryPredicate;
import com.amplifyframework.core.model.query.predicate.QueryPredicates;
import j$.util.Objects;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ObserveQueryOptions {
    private final QueryPredicate queryPredicate;
    private final List sortBy;

    public ObserveQueryOptions() {
        this(null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObserveQueryOptions)) {
            return false;
        }
        ObserveQueryOptions observeQueryOptions = (ObserveQueryOptions) obj;
        return c.a(this.queryPredicate, observeQueryOptions.queryPredicate) && c.a(this.sortBy, observeQueryOptions.sortBy);
    }

    public QueryPredicate getQueryPredicate() {
        return this.queryPredicate;
    }

    public List getSortBy() {
        return this.sortBy;
    }

    public int hashCode() {
        return c.b(this.queryPredicate, this.sortBy);
    }

    public ObserveQueryOptions matches(QueryPredicate queryPredicate) {
        Objects.requireNonNull(queryPredicate);
        return new ObserveQueryOptions(queryPredicate, this.sortBy);
    }

    public ObserveQueryOptions sorted(QuerySortBy... querySortByArr) {
        QueryPredicate queryPredicate = this.queryPredicate;
        Objects.requireNonNull(querySortByArr);
        return new ObserveQueryOptions(queryPredicate, Arrays.asList(querySortByArr));
    }

    public String toString() {
        return "QueryOptions{queryPredicate=" + this.queryPredicate + ", sortBy=" + this.sortBy + '}';
    }

    public ObserveQueryOptions(QueryPredicate queryPredicate, List list) {
        this.queryPredicate = queryPredicate == null ? QueryPredicates.all() : queryPredicate;
        this.sortBy = list;
    }
}
