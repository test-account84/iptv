package com.amplifyframework.core.model.query.predicate;

import O.c;
import com.amplifyframework.core.model.query.predicate.QueryPredicateGroup;
import com.amplifyframework.util.FieldFinder;
import j$.util.Objects;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class QueryPredicateOperation implements QueryPredicate {
    private final String field;
    private final String modelName;
    private final QueryOperator operator;

    public QueryPredicateOperation(String str, QueryOperator queryOperator) {
        this(null, str, queryOperator);
    }

    public static QueryPredicateGroup not(QueryPredicateOperation queryPredicateOperation) {
        return new QueryPredicateGroup(QueryPredicateGroup.Type.NOT, Collections.singletonList(queryPredicateOperation));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || QueryPredicateOperation.class != obj.getClass()) {
            return false;
        }
        QueryPredicateOperation queryPredicateOperation = (QueryPredicateOperation) obj;
        return c.a(modelName(), queryPredicateOperation.modelName()) && c.a(field(), queryPredicateOperation.field()) && c.a(operator(), queryPredicateOperation.operator());
    }

    public boolean evaluate(Object obj) throws IllegalArgumentException {
        try {
            return this.operator.evaluate(FieldFinder.extractFieldValue(obj, this.field));
        } catch (Exception unused) {
            return false;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(this.field + " field inside provided object cannot be evaluated by the operator type: " + this.operator.type().name(), e);
        }
    }

    public String field() {
        return this.field;
    }

    public int hashCode() {
        return c.b(modelName(), field(), operator());
    }

    public String modelName() {
        return this.modelName;
    }

    public QueryOperator operator() {
        return this.operator;
    }

    public String toString() {
        return "QueryPredicateOperation { model: " + modelName() + ", field: " + field() + ", operator: " + operator() + " }";
    }

    public QueryPredicateOperation(String str, String str2, QueryOperator queryOperator) {
        this.modelName = str;
        Objects.requireNonNull(str2);
        this.field = str2;
        Objects.requireNonNull(queryOperator);
        this.operator = queryOperator;
    }

    public QueryPredicateGroup and(QueryPredicate queryPredicate) {
        return new QueryPredicateGroup(QueryPredicateGroup.Type.AND, Arrays.asList(new QueryPredicate[]{this, queryPredicate}));
    }

    public QueryPredicateGroup or(QueryPredicate queryPredicate) {
        return new QueryPredicateGroup(QueryPredicateGroup.Type.OR, Arrays.asList(new QueryPredicate[]{this, queryPredicate}));
    }
}
