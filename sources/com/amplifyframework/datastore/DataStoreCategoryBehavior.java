package com.amplifyframework.datastore;

import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.query.ObserveQueryOptions;
import com.amplifyframework.core.model.query.QueryOptions;
import com.amplifyframework.core.model.query.predicate.QueryPredicate;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface DataStoreCategoryBehavior {
    void clear(Action action, Consumer consumer);

    void delete(Model model, Consumer consumer, Consumer consumer2);

    void delete(Model model, QueryPredicate queryPredicate, Consumer consumer, Consumer consumer2);

    void delete(Class cls, QueryPredicate queryPredicate, Action action, Consumer consumer);

    void observe(Consumer consumer, Consumer consumer2, Consumer consumer3, Action action);

    void observe(Class cls, Consumer consumer, Consumer consumer2, Consumer consumer3, Action action);

    void observe(Class cls, QueryPredicate queryPredicate, Consumer consumer, Consumer consumer2, Consumer consumer3, Action action);

    void observe(Class cls, Serializable serializable, Consumer consumer, Consumer consumer2, Consumer consumer3, Action action);

    void observeQuery(Class cls, ObserveQueryOptions observeQueryOptions, Consumer consumer, Consumer consumer2, Consumer consumer3, Action action);

    void query(Class cls, Consumer consumer, Consumer consumer2);

    void query(Class cls, QueryOptions queryOptions, Consumer consumer, Consumer consumer2);

    void query(Class cls, QueryPredicate queryPredicate, Consumer consumer, Consumer consumer2);

    void save(Model model, Consumer consumer, Consumer consumer2);

    void save(Model model, QueryPredicate queryPredicate, Consumer consumer, Consumer consumer2);

    void start(Action action, Consumer consumer);

    void stop(Action action, Consumer consumer);
}
