package com.amplifyframework.api.rest;

import O.c;
import com.amplifyframework.util.Immutable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class RestOptions {
    private final byte[] data;
    private final Map headers;
    private final String path;
    private final Map queryParameters;

    public static final class Builder {
        private byte[] data;
        private Map headers;
        private String path;
        private Map queryParameters;

        public Builder addBody(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public Builder addHeader(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            this.headers.put(str, str2);
            return this;
        }

        public Builder addHeaders(Map map) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            this.headers.putAll(map);
            return this;
        }

        public Builder addPath(String str) {
            this.path = str;
            return this;
        }

        public Builder addQueryParameters(Map map) {
            if (this.queryParameters == null) {
                this.queryParameters = new HashMap();
            }
            this.queryParameters.putAll(map);
            return this;
        }

        public RestOptions build() {
            return new RestOptions(this.path, this.data, this.headers, this.queryParameters, null);
        }
    }

    private RestOptions(String str, byte[] bArr, Map map, Map map2) {
        this.path = str;
        this.data = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.headers = map == null ? Collections.emptyMap() : Immutable.of(map);
        this.queryParameters = map2 == null ? Collections.emptyMap() : Immutable.of(map2);
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RestOptions.class != obj.getClass()) {
            return false;
        }
        RestOptions restOptions = (RestOptions) obj;
        if (c.a(getPath(), restOptions.getPath()) && c.a(getData(), restOptions.getData()) && c.a(getHeaders(), restOptions.getHeaders())) {
            return c.a(getQueryParameters(), restOptions.getQueryParameters());
        }
        return false;
    }

    public byte[] getData() {
        return this.data;
    }

    public Map getHeaders() {
        return this.headers;
    }

    public String getPath() {
        return this.path;
    }

    public Map getQueryParameters() {
        return this.queryParameters;
    }

    public boolean hasData() {
        return this.data != null;
    }

    public int hashCode() {
        return ((((((getPath() != null ? getPath().hashCode() : 0) * 31) + Arrays.hashCode(getData())) * 31) + (getHeaders() != null ? getHeaders().hashCode() : 0)) * 31) + (getQueryParameters() != null ? getQueryParameters().hashCode() : 0);
    }

    public String toString() {
        return "RestOptions{path='" + this.path + "', data=" + Arrays.toString(this.data) + ", headers=" + this.headers + ", queryParameters=" + this.queryParameters + '}';
    }

    public /* synthetic */ RestOptions(String str, byte[] bArr, Map map, Map map2, 1 r5) {
        this(str, bArr, map, map2);
    }
}
