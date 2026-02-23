package com.amplifyframework.core.model.query;

import O.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class QueryPaginationInput {
    public static final int DEFAULT_LIMIT = 100;
    private final int limit;
    private final int page;

    public QueryPaginationInput(int i, int i2) {
        this.page = i;
        this.limit = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryPaginationInput)) {
            return false;
        }
        QueryPaginationInput queryPaginationInput = (QueryPaginationInput) obj;
        return this.page == queryPaginationInput.page && this.limit == queryPaginationInput.limit;
    }

    public int getLimit() {
        return this.limit;
    }

    public int getPage() {
        return this.page;
    }

    public int hashCode() {
        return c.b(Integer.valueOf(this.page), Integer.valueOf(this.limit));
    }

    public String toString() {
        return "QueryPaginationInput{page=" + this.page + ", limit=" + this.limit + '}';
    }

    public QueryPaginationInput withLimit(Integer num) {
        return new QueryPaginationInput(this.page, num.intValue());
    }
}
