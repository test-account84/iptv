package com.amplifyframework.core.model.query;

import O.c;
import com.amplifyframework.core.model.query.predicate.QueryPredicate;
import com.amplifyframework.core.model.query.predicate.QueryPredicates;
import j$.util.Objects;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class QueryOptions {
    private QueryPaginationInput paginationInput;
    private QueryPredicate queryPredicate;
    private List sortBy;

    public QueryOptions() {
        this(null, null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryOptions)) {
            return false;
        }
        QueryOptions queryOptions = (QueryOptions) obj;
        return c.a(this.queryPredicate, queryOptions.queryPredicate) && c.a(this.paginationInput, queryOptions.paginationInput) && c.a(this.sortBy, queryOptions.sortBy);
    }

    public QueryPaginationInput getPaginationInput() {
        return this.paginationInput;
    }

    public QueryPredicate getQueryPredicate() {
        return this.queryPredicate;
    }

    public List getSortBy() {
        return this.sortBy;
    }

    public int hashCode() {
        return c.b(this.queryPredicate, this.paginationInput, this.sortBy);
    }

    public QueryOptions matches(QueryPredicate queryPredicate) {
        Objects.requireNonNull(queryPredicate);
        return new QueryOptions(queryPredicate, this.paginationInput, this.sortBy);
    }

    public QueryOptions paginated(QueryPaginationInput queryPaginationInput) {
        QueryPredicate queryPredicate = this.queryPredicate;
        Objects.requireNonNull(queryPaginationInput);
        return new QueryOptions(queryPredicate, queryPaginationInput, this.sortBy);
    }

    public QueryOptions sorted(QuerySortBy... querySortByArr) {
        QueryPredicate queryPredicate = this.queryPredicate;
        QueryPaginationInput queryPaginationInput = this.paginationInput;
        Objects.requireNonNull(querySortByArr);
        return new QueryOptions(queryPredicate, queryPaginationInput, Arrays.asList(querySortByArr));
    }

    public String toString() {
        return "QueryOptions{queryPredicate=" + this.queryPredicate + ", paginationInput=" + this.paginationInput + ", sortBy=" + this.sortBy + '}';
    }

    public QueryOptions(QueryPredicate queryPredicate, QueryPaginationInput queryPaginationInput, List list) {
        this.queryPredicate = queryPredicate == null ? QueryPredicates.all() : queryPredicate;
        this.paginationInput = queryPaginationInput;
        this.sortBy = list;
    }
}
