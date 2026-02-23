package com.amplifyframework.api.graphql;

import com.amplifyframework.api.ApiException;
import com.amplifyframework.api.ApiOperation;
import com.amplifyframework.api.graphql.GraphQLResponse;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class GraphQLOperation extends ApiOperation {
    private final GraphQLResponse.Factory responseFactory;

    public GraphQLOperation(GraphQLRequest graphQLRequest, GraphQLResponse.Factory factory) {
        super(graphQLRequest);
        this.responseFactory = factory;
    }

    public final GraphQLResponse wrapResponse(String str) throws ApiException {
        try {
            return this.responseFactory.buildResponse((GraphQLRequest) getRequest(), str);
        } catch (ClassCastException unused) {
            throw new ApiException("Amplify encountered an error while deserializing an object", "Sorry, we don't have a suggested fix for this error yet.");
        }
    }
}
