package com.amplifyframework.api.graphql;

import O.c;
import com.amplifyframework.api.ApiException;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class GraphQLResponse {
    private final Object data;
    private final List errors;

    public static final class Error {
        private final Map extensions;
        private final List locations;
        private final String message;
        private final List path;

        public Error(String str, List list, List list2, Map map) {
            Objects.requireNonNull(str);
            this.message = str;
            this.locations = list;
            this.path = list2;
            this.extensions = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Error.class != obj.getClass()) {
                return false;
            }
            Error error = (Error) obj;
            return c.a(this.message, error.message) && c.a(this.locations, error.locations) && c.a(this.path, error.path) && c.a(this.extensions, error.extensions);
        }

        public Map getExtensions() {
            return Immutable.of(this.extensions);
        }

        public List getLocations() {
            return Immutable.of(this.locations);
        }

        public String getMessage() {
            return this.message;
        }

        public List getPath() {
            return Immutable.of(this.path);
        }

        public int hashCode() {
            int hashCode = this.message.hashCode() * 31;
            List list = this.locations;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            List list2 = this.path;
            int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            Map map = this.extensions;
            return hashCode3 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            return "GraphQLResponse.Error{message='" + this.message + "', locations='" + this.locations + "', path='" + this.path + "', extensions='" + this.extensions + "'}";
        }
    }

    public interface Factory {
        GraphQLResponse buildResponse(GraphQLRequest graphQLRequest, String str) throws ApiException;
    }

    public GraphQLResponse(Object obj, List list) {
        this.data = obj;
        ArrayList arrayList = new ArrayList();
        this.errors = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GraphQLResponse.class != obj.getClass()) {
            return false;
        }
        GraphQLResponse graphQLResponse = (GraphQLResponse) obj;
        if (c.a(this.data, graphQLResponse.data)) {
            return c.a(this.errors, graphQLResponse.errors);
        }
        return false;
    }

    public Object getData() {
        return this.data;
    }

    public List getErrors() {
        return this.errors;
    }

    public boolean hasData() {
        return this.data != null;
    }

    public boolean hasErrors() {
        return this.errors.size() > 0;
    }

    public int hashCode() {
        Object obj = this.data;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        List list = this.errors;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "GraphQLResponse{data='" + this.data + "', errors='" + this.errors + "'}";
    }
}
