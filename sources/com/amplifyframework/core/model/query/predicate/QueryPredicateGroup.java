package com.amplifyframework.core.model.query.predicate;

import O.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class QueryPredicateGroup implements QueryPredicate {
    private final List predicates;
    private final Type type;

    public static /* synthetic */ class 1 {
        static final /* synthetic */ int[] $SwitchMap$com$amplifyframework$core$model$query$predicate$QueryPredicateGroup$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$amplifyframework$core$model$query$predicate$QueryPredicateGroup$Type = iArr;
            try {
                iArr[Type.OR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amplifyframework$core$model$query$predicate$QueryPredicateGroup$Type[Type.AND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amplifyframework$core$model$query$predicate$QueryPredicateGroup$Type[Type.NOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum Type {
        AND,
        OR,
        NOT
    }

    public QueryPredicateGroup(Type type, List list) {
        this.type = type;
        this.predicates = new ArrayList(list);
        if (list.isEmpty()) {
            throw new IllegalArgumentException("A predicate group must contain at least one predicate element");
        }
    }

    public static QueryPredicate andOf(QueryPredicate queryPredicate) {
        return new QueryPredicateGroup(Type.AND, Arrays.asList(new QueryPredicate[]{queryPredicate}));
    }

    public static QueryPredicateGroup not(QueryPredicateGroup queryPredicateGroup) {
        return new QueryPredicateGroup(Type.NOT, Collections.singletonList(queryPredicateGroup));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || QueryPredicateGroup.class != obj.getClass()) {
            return false;
        }
        QueryPredicateGroup queryPredicateGroup = (QueryPredicateGroup) obj;
        return c.a(type(), queryPredicateGroup.type()) && c.a(predicates(), queryPredicateGroup.predicates());
    }

    public boolean evaluate(Object obj) throws IllegalArgumentException {
        int i = 1.$SwitchMap$com$amplifyframework$core$model$query$predicate$QueryPredicateGroup$Type[this.type.ordinal()];
        if (i == 1) {
            Iterator it = this.predicates.iterator();
            while (it.hasNext()) {
                if (((QueryPredicate) it.next()).evaluate(obj)) {
                    return true;
                }
            }
            return false;
        }
        if (i != 2) {
            if (i != 3) {
                return false;
            }
            return !((QueryPredicate) this.predicates.get(0)).evaluate(obj);
        }
        Iterator it2 = this.predicates.iterator();
        while (it2.hasNext()) {
            if (!((QueryPredicate) it2.next()).evaluate(obj)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return c.b(type(), predicates());
    }

    public List predicates() {
        return this.predicates;
    }

    public String toString() {
        return "QueryPredicateGroup { type: " + type() + ", predicates: " + predicates() + " }";
    }

    public Type type() {
        return this.type;
    }

    public QueryPredicateGroup and(QueryPredicate queryPredicate) {
        Type type = Type.AND;
        if (!type.equals(this.type)) {
            return new QueryPredicateGroup(type, Arrays.asList(new QueryPredicate[]{this, queryPredicate}));
        }
        this.predicates.add(queryPredicate);
        return this;
    }

    public QueryPredicateGroup or(QueryPredicate queryPredicate) {
        Type type = Type.OR;
        if (!type.equals(this.type)) {
            return new QueryPredicateGroup(type, Arrays.asList(new QueryPredicate[]{this, queryPredicate}));
        }
        this.predicates.add(queryPredicate);
        return this;
    }
}
