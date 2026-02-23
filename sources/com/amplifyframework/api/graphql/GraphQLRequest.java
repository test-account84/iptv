package com.amplifyframework.api.graphql;

import O.c;
import android.text.TextUtils;
import com.amplifyframework.util.Wrap;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class GraphQLRequest {
    private final Type responseType;
    private final VariablesSerializer variablesSerializer;

    public interface VariablesSerializer {
        String serialize(Map map);
    }

    public GraphQLRequest(Type type, VariablesSerializer variablesSerializer) {
        this.responseType = type;
        this.variablesSerializer = variablesSerializer;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GraphQLRequest graphQLRequest = (GraphQLRequest) obj;
        return c.a(this.responseType, graphQLRequest.responseType) && c.a(this.variablesSerializer, graphQLRequest.variablesSerializer);
    }

    public String getContent() {
        String replace = getQuery().replace("\"", "\\\"").replace("\n", "\\n");
        String serialize = getVariables().isEmpty() ? null : this.variablesSerializer.serialize(getVariables());
        return Wrap.inBraces(TextUtils.join(", ", Arrays.asList(new String[]{Wrap.inDoubleQuotes("query") + ": " + Wrap.inDoubleQuotes(replace), Wrap.inDoubleQuotes("variables") + ": " + serialize})));
    }

    public abstract String getQuery();

    public Type getResponseType() {
        return this.responseType;
    }

    public abstract Map getVariables();

    public VariablesSerializer getVariablesSerializer() {
        return this.variablesSerializer;
    }

    public int hashCode() {
        int hashCode = this.responseType.hashCode() * 31;
        VariablesSerializer variablesSerializer = this.variablesSerializer;
        return hashCode + (variablesSerializer != null ? variablesSerializer.hashCode() : 0);
    }

    public String toString() {
        return "GraphQLRequest{, responseType='" + this.responseType + "', variablesSerializer='" + this.variablesSerializer + "'}";
    }
}
