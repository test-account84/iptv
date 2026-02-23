package com.amplifyframework.api;

import com.amplifyframework.api.graphql.GraphQLOperation;
import com.amplifyframework.api.graphql.GraphQLRequest;
import com.amplifyframework.api.rest.RestOperation;
import com.amplifyframework.api.rest.RestOptions;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ApiCategory extends Category implements ApiCategoryBehavior {
    public RestOperation delete(RestOptions restOptions, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).delete(restOptions, consumer, consumer2);
    }

    public RestOperation get(RestOptions restOptions, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).get(restOptions, consumer, consumer2);
    }

    public CategoryType getCategoryType() {
        return CategoryType.API;
    }

    public RestOperation head(RestOptions restOptions, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).head(restOptions, consumer, consumer2);
    }

    public GraphQLOperation mutate(GraphQLRequest graphQLRequest, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).mutate(graphQLRequest, consumer, consumer2);
    }

    public RestOperation patch(RestOptions restOptions, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).patch(restOptions, consumer, consumer2);
    }

    public RestOperation post(RestOptions restOptions, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).post(restOptions, consumer, consumer2);
    }

    public RestOperation put(RestOptions restOptions, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).put(restOptions, consumer, consumer2);
    }

    public GraphQLOperation query(GraphQLRequest graphQLRequest, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).query(graphQLRequest, consumer, consumer2);
    }

    public GraphQLOperation subscribe(GraphQLRequest graphQLRequest, Consumer consumer, Consumer consumer2, Consumer consumer3, Action action) {
        return ((ApiPlugin) getSelectedPlugin()).subscribe(graphQLRequest, consumer, consumer2, consumer3, action);
    }

    public RestOperation delete(String str, RestOptions restOptions, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).delete(str, restOptions, consumer, consumer2);
    }

    public RestOperation get(String str, RestOptions restOptions, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).get(str, restOptions, consumer, consumer2);
    }

    public RestOperation head(String str, RestOptions restOptions, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).head(str, restOptions, consumer, consumer2);
    }

    public GraphQLOperation mutate(String str, GraphQLRequest graphQLRequest, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).mutate(str, graphQLRequest, consumer, consumer2);
    }

    public RestOperation patch(String str, RestOptions restOptions, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).patch(str, restOptions, consumer, consumer2);
    }

    public RestOperation post(String str, RestOptions restOptions, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).post(str, restOptions, consumer, consumer2);
    }

    public RestOperation put(String str, RestOptions restOptions, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).put(str, restOptions, consumer, consumer2);
    }

    public GraphQLOperation query(String str, GraphQLRequest graphQLRequest, Consumer consumer, Consumer consumer2) {
        return ((ApiPlugin) getSelectedPlugin()).query(str, graphQLRequest, consumer, consumer2);
    }

    public GraphQLOperation subscribe(String str, GraphQLRequest graphQLRequest, Consumer consumer, Consumer consumer2, Consumer consumer3, Action action) {
        return ((ApiPlugin) getSelectedPlugin()).subscribe(str, graphQLRequest, consumer, consumer2, consumer3, action);
    }
}
