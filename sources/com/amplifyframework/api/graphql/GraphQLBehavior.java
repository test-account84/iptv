package com.amplifyframework.api.graphql;

import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface GraphQLBehavior {
    GraphQLOperation mutate(GraphQLRequest graphQLRequest, Consumer consumer, Consumer consumer2);

    GraphQLOperation mutate(String str, GraphQLRequest graphQLRequest, Consumer consumer, Consumer consumer2);

    GraphQLOperation query(GraphQLRequest graphQLRequest, Consumer consumer, Consumer consumer2);

    GraphQLOperation query(String str, GraphQLRequest graphQLRequest, Consumer consumer, Consumer consumer2);

    GraphQLOperation subscribe(GraphQLRequest graphQLRequest, Consumer consumer, Consumer consumer2, Consumer consumer3, Action action);

    GraphQLOperation subscribe(String str, GraphQLRequest graphQLRequest, Consumer consumer, Consumer consumer2, Consumer consumer3, Action action);
}
