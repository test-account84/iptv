package com.amplifyframework.api.rest;

import O.c;
import com.amplifyframework.util.Immutable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class RestOperationRequest {
    private final byte[] data;
    private final Map headers;
    private final HttpMethod httpMethod;
    private final String path;
    private final Map queryParameters;

    public RestOperationRequest(HttpMethod httpMethod, String str, Map map, Map map2) {
        this(httpMethod, str, null, map, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RestOperationRequest.class != obj.getClass()) {
            return false;
        }
        RestOperationRequest restOperationRequest = (RestOperationRequest) obj;
        if (c.a(getHttpMethod(), restOperationRequest.getHttpMethod()) && c.a(getPath(), restOperationRequest.getPath()) && c.a(getData(), restOperationRequest.getData()) && c.a(getHeaders(), restOperationRequest.getHeaders())) {
            return c.a(getQueryParameters(), restOperationRequest.getQueryParameters());
        }
        return false;
    }

    public byte[] getData() {
        return this.data;
    }

    public Map getHeaders() {
        return this.headers;
    }

    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public String getPath() {
        return this.path;
    }

    public Map getQueryParameters() {
        return this.queryParameters;
    }

    public int hashCode() {
        return ((((((((getHttpMethod() != null ? getHttpMethod().hashCode() : 0) * 31) + (getPath() != null ? getPath().hashCode() : 0)) * 31) + Arrays.hashCode(getData())) * 31) + (getHeaders() != null ? getHeaders().hashCode() : 0)) * 31) + (getQueryParameters() != null ? getQueryParameters().hashCode() : 0);
    }

    public String toString() {
        return "RestOperationRequest{httpMethod=" + this.httpMethod + ", path='" + this.path + "', data=" + Arrays.toString(this.data) + ", headers=" + this.headers + ", queryParameters=" + this.queryParameters + '}';
    }

    public RestOperationRequest(HttpMethod httpMethod, String str, byte[] bArr, Map map, Map map2) {
        this.httpMethod = httpMethod;
        this.path = str;
        this.headers = map == null ? Collections.emptyMap() : Immutable.of(map);
        this.data = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.queryParameters = map2 == null ? Collections.emptyMap() : Immutable.of(map2);
    }
}
