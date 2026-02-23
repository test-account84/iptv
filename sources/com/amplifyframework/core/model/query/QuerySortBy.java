package com.amplifyframework.core.model.query;

import O.c;
import com.amplifyframework.util.Wrap;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class QuerySortBy {
    private final String field;
    private final String modelName;
    private final QuerySortOrder sortOrder;

    public QuerySortBy(String str, QuerySortOrder querySortOrder) {
        this(null, str, querySortOrder);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || QuerySortBy.class != obj.getClass()) {
            return false;
        }
        QuerySortBy querySortBy = (QuerySortBy) obj;
        return c.a(this.modelName, querySortBy.modelName) && c.a(this.field, querySortBy.field) && c.a(this.sortOrder, querySortBy.sortOrder);
    }

    public String getField() {
        return this.field;
    }

    public String getModelName() {
        return this.modelName;
    }

    public QuerySortOrder getSortOrder() {
        return this.sortOrder;
    }

    public int hashCode() {
        return c.b(this.modelName, this.field, this.sortOrder);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QuerySortBy{model=");
        String str = this.modelName;
        sb.append(str == null ? null : Wrap.inSingleQuotes(str));
        sb.append(", field=");
        sb.append(Wrap.inSingleQuotes(this.field));
        sb.append(", sortOrder=");
        sb.append(this.sortOrder);
        sb.append('}');
        return sb.toString();
    }

    public QuerySortBy(String str, String str2, QuerySortOrder querySortOrder) {
        this.modelName = str;
        Objects.requireNonNull(str2);
        this.field = str2;
        Objects.requireNonNull(querySortOrder);
        this.sortOrder = querySortOrder;
    }
}
