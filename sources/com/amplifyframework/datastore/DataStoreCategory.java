package com.amplifyframework.datastore;

import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.query.ObserveQueryOptions;
import com.amplifyframework.core.model.query.QueryOptions;
import com.amplifyframework.core.model.query.predicate.QueryPredicate;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class DataStoreCategory extends Category implements DataStoreCategoryBehavior {
    public void clear(Action action, Consumer consumer) {
        ((DataStorePlugin) getSelectedPlugin()).clear(action, consumer);
    }

    public void delete(Model model, Consumer consumer, Consumer consumer2) {
        ((DataStorePlugin) getSelectedPlugin()).delete(model, consumer, consumer2);
    }

    public CategoryType getCategoryType() {
        return CategoryType.DATASTORE;
    }

    public void observe(Consumer consumer, Consumer consumer2, Consumer consumer3, Action action) {
        ((DataStorePlugin) getSelectedPlugin()).observe(consumer, consumer2, consumer3, action);
    }

    public void observeQuery(Class cls, ObserveQueryOptions observeQueryOptions, Consumer consumer, Consumer consumer2, Consumer consumer3, Action action) {
        ((DataStorePlugin) getSelectedPlugin()).observeQuery(cls, observeQueryOptions, consumer, consumer2, consumer3, action);
    }

    public void query(Class cls, Consumer consumer, Consumer consumer2) {
        ((DataStorePlugin) getSelectedPlugin()).query(cls, consumer, consumer2);
    }

    public void save(Model model, Consumer consumer, Consumer consumer2) {
        ((DataStorePlugin) getSelectedPlugin()).save(model, consumer, consumer2);
    }

    public void start(Action action, Consumer consumer) {
        ((DataStorePlugin) getSelectedPlugin()).start(action, consumer);
    }

    public void stop(Action action, Consumer consumer) {
        ((DataStorePlugin) getSelectedPlugin()).stop(action, consumer);
    }

    public void delete(Model model, QueryPredicate queryPredicate, Consumer consumer, Consumer consumer2) {
        ((DataStorePlugin) getSelectedPlugin()).delete(model, queryPredicate, consumer, consumer2);
    }

    public void observe(Class cls, Consumer consumer, Consumer consumer2, Consumer consumer3, Action action) {
        ((DataStorePlugin) getSelectedPlugin()).observe(cls, consumer, consumer2, consumer3, action);
    }

    public void query(Class cls, QueryOptions queryOptions, Consumer consumer, Consumer consumer2) {
        ((DataStorePlugin) getSelectedPlugin()).query(cls, queryOptions, consumer, consumer2);
    }

    public void save(Model model, QueryPredicate queryPredicate, Consumer consumer, Consumer consumer2) {
        ((DataStorePlugin) getSelectedPlugin()).save(model, queryPredicate, consumer, consumer2);
    }

    public void delete(Class cls, QueryPredicate queryPredicate, Action action, Consumer consumer) {
        ((DataStorePlugin) getSelectedPlugin()).delete(cls, queryPredicate, action, consumer);
    }

    public void observe(Class cls, QueryPredicate queryPredicate, Consumer consumer, Consumer consumer2, Consumer consumer3, Action action) {
        ((DataStorePlugin) getSelectedPlugin()).observe(cls, queryPredicate, consumer, consumer2, consumer3, action);
    }

    public void query(Class cls, QueryPredicate queryPredicate, Consumer consumer, Consumer consumer2) {
        ((DataStorePlugin) getSelectedPlugin()).query(cls, queryPredicate, consumer, consumer2);
    }

    public void observe(Class cls, Serializable serializable, Consumer consumer, Consumer consumer2, Consumer consumer3, Action action) {
        ((DataStorePlugin) getSelectedPlugin()).observe(cls, serializable, consumer, consumer2, consumer3, action);
    }
}
