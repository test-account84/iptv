package com.amplifyframework.core.model.query;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.model.ModelIdentifier;
import com.amplifyframework.core.model.ModelSchema;
import com.amplifyframework.core.model.PrimaryKey;
import com.amplifyframework.core.model.query.predicate.QueryField;
import com.amplifyframework.core.model.query.predicate.QueryPredicate;
import j$.util.Objects;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Where {
    private Where() {
    }

    @Deprecated
    public static QueryOptions id(String str) {
        QueryField field = QueryField.field(PrimaryKey.fieldName());
        Objects.requireNonNull(str);
        return matches(field.eq(str)).paginated(Page.firstResult());
    }

    public static QueryOptions identifier(Class cls, Serializable serializable) throws AmplifyException {
        QueryOptions queryOptions;
        List primaryIndexFields = ModelSchema.fromModelClass(cls).getPrimaryIndexFields();
        ListIterator listIterator = primaryIndexFields.listIterator();
        QueryField field = QueryField.field(cls.getSimpleName(), (String) listIterator.next());
        if (primaryIndexFields.size() != 1 || (serializable instanceof ModelIdentifier)) {
            ModelIdentifier modelIdentifier = (ModelIdentifier) serializable;
            ListIterator listIterator2 = modelIdentifier.sortedKeys().listIterator();
            Serializable key = modelIdentifier.key();
            Objects.requireNonNull(key);
            QueryOptions matches = matches(field.eq(key));
            while (listIterator2.hasNext()) {
                QueryField field2 = QueryField.field(cls.getSimpleName(), (String) listIterator.next());
                Object next = listIterator2.next();
                Objects.requireNonNull(next);
                matches.matches(field2.eq(next));
            }
            queryOptions = matches;
        } else {
            String obj = serializable.toString();
            Objects.requireNonNull(obj);
            queryOptions = matches(field.eq(obj));
        }
        return queryOptions.paginated(Page.firstResult());
    }

    public static QueryOptions matches(QueryPredicate queryPredicate) {
        Objects.requireNonNull(queryPredicate);
        return new QueryOptions(queryPredicate, null, null);
    }

    public static QueryOptions matchesAll() {
        return new QueryOptions();
    }

    public static QueryOptions matchesAndSorts(QueryPredicate queryPredicate, List list) {
        return new QueryOptions(queryPredicate, null, list);
    }

    public static QueryOptions paginated(QueryPaginationInput queryPaginationInput) {
        Objects.requireNonNull(queryPaginationInput);
        return new QueryOptions(null, queryPaginationInput, null);
    }

    public static QueryOptions sorted(QuerySortBy... querySortByArr) {
        Objects.requireNonNull(querySortByArr);
        return new QueryOptions(null, null, Arrays.asList(querySortByArr));
    }
}
