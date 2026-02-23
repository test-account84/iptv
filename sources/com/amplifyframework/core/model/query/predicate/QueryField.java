package com.amplifyframework.core.model.query.predicate;

import com.amplifyframework.core.model.query.QuerySortBy;
import com.amplifyframework.core.model.query.QuerySortOrder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class QueryField {
    private final String fieldName;
    private final String modelName;

    private QueryField(String str, String str2) {
        this.modelName = str;
        this.fieldName = str2;
    }

    public static QueryField field(String str) {
        return field(null, str);
    }

    public QuerySortBy ascending() {
        return new QuerySortBy(this.modelName, this.fieldName, QuerySortOrder.ASCENDING);
    }

    public QueryPredicateOperation beginsWith(String str) {
        return new QueryPredicateOperation(this.modelName, this.fieldName, new BeginsWithQueryOperator(str));
    }

    public QueryPredicateOperation between(Comparable comparable, Comparable comparable2) {
        return new QueryPredicateOperation(this.modelName, this.fieldName, new BetweenQueryOperator(comparable, comparable2));
    }

    public QueryPredicateOperation contains(String str) {
        return new QueryPredicateOperation(this.modelName, this.fieldName, new ContainsQueryOperator(str));
    }

    public QuerySortBy descending() {
        return new QuerySortBy(this.modelName, this.fieldName, QuerySortOrder.DESCENDING);
    }

    public QueryPredicateOperation eq(Object obj) {
        return new QueryPredicateOperation(this.modelName, this.fieldName, new EqualQueryOperator(obj));
    }

    public QueryPredicateOperation ge(Comparable comparable) {
        return new QueryPredicateOperation(this.modelName, this.fieldName, new GreaterOrEqualQueryOperator(comparable));
    }

    public QueryPredicateOperation gt(Comparable comparable) {
        return new QueryPredicateOperation(this.modelName, this.fieldName, new GreaterThanQueryOperator(comparable));
    }

    public QueryPredicateOperation le(Comparable comparable) {
        return new QueryPredicateOperation(this.modelName, this.fieldName, new LessOrEqualQueryOperator(comparable));
    }

    public QueryPredicateOperation lt(Comparable comparable) {
        return new QueryPredicateOperation(this.modelName, this.fieldName, new LessThanQueryOperator(comparable));
    }

    public QueryPredicateOperation ne(Object obj) {
        return new QueryPredicateOperation(this.modelName, this.fieldName, new NotEqualQueryOperator(obj));
    }

    public QueryPredicateOperation notContains(String str) {
        return new QueryPredicateOperation(this.modelName, this.fieldName, new NotContainsQueryOperator(str));
    }

    public static QueryField field(String str, String str2) {
        return new QueryField(str, str2);
    }
}
