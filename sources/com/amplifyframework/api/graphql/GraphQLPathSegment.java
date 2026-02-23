package com.amplifyframework.api.graphql;

import O.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class GraphQLPathSegment {
    private final Object value;

    public GraphQLPathSegment(int i) {
        this.value = Integer.valueOf(i);
    }

    public boolean equals(Object obj) {
        String valueOf;
        String valueOf2;
        if (this == obj) {
            return true;
        }
        if (obj != null && GraphQLPathSegment.class == obj.getClass()) {
            GraphQLPathSegment graphQLPathSegment = (GraphQLPathSegment) obj;
            if (isString() && graphQLPathSegment.isString()) {
                valueOf = getAsString();
                valueOf2 = graphQLPathSegment.getAsString();
            } else if (isInteger() && graphQLPathSegment.isInteger()) {
                valueOf = Integer.valueOf(getAsInt());
                valueOf2 = Integer.valueOf(graphQLPathSegment.getAsInt());
            }
            return c.a(valueOf, valueOf2);
        }
        return false;
    }

    public int getAsInt() {
        if (isInteger()) {
            return ((Integer) this.value).intValue();
        }
        throw new ClassCastException("Not an int: " + this.value.getClass().getSimpleName());
    }

    public String getAsString() {
        if (isString()) {
            return (String) this.value;
        }
        throw new ClassCastException("Not a String: " + this.value.getClass().getSimpleName());
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean isInteger() {
        return this.value instanceof Integer;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    public String toString() {
        return "GraphQLPathSegment{value='" + this.value + "'}";
    }

    public GraphQLPathSegment(String str) {
        this.value = str;
    }
}
