package com.amplifyframework.api.graphql;

import O.c;
import com.amplifyframework.api.graphql.GraphQLRequest;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SimpleGraphQLRequest extends GraphQLRequest {
    private final String document;
    private final Map variables;

    public SimpleGraphQLRequest(String str, Type type, GraphQLRequest.VariablesSerializer variablesSerializer) {
        this(str, Collections.emptyMap(), type, variablesSerializer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SimpleGraphQLRequest.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        SimpleGraphQLRequest simpleGraphQLRequest = (SimpleGraphQLRequest) obj;
        return c.a(this.document, simpleGraphQLRequest.document) && c.a(this.variables, simpleGraphQLRequest.variables);
    }

    public String getQuery() {
        return this.document;
    }

    public Map getVariables() {
        return this.variables;
    }

    public int hashCode() {
        return c.b(Integer.valueOf(super.hashCode()), this.document, this.variables);
    }

    public SimpleGraphQLRequest(String str, Map map, Type type, GraphQLRequest.VariablesSerializer variablesSerializer) {
        super(type, variablesSerializer);
        this.variables = map;
        this.document = str;
    }
}
