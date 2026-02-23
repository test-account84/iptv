package com.squareup.okhttp;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.internal.http.HttpMethod;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Request {
    private final RequestBody body;
    private volatile CacheControl cacheControl;
    private final Headers headers;
    private volatile URI javaNetUri;
    private volatile URL javaNetUrl;
    private final String method;
    private final Object tag;
    private final HttpUrl url;

    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Object tag;
        private HttpUrl url;

        public Builder() {
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ HttpUrl access$000(Builder builder) {
            return builder.url;
        }

        public static /* synthetic */ String access$100(Builder builder) {
            return builder.method;
        }

        public static /* synthetic */ Headers.Builder access$200(Builder builder) {
            return builder.headers;
        }

        public static /* synthetic */ RequestBody access$300(Builder builder) {
            return builder.body;
        }

        public static /* synthetic */ Object access$400(Builder builder) {
            return builder.tag;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            if (this.url != null) {
                return new Request(this, null);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.isEmpty() ? removeHeader("Cache-Control") : header("Cache-Control", cacheControl2);
        }

        public Builder delete() {
            return delete(RequestBody.create((MediaType) null, new byte[0]));
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (requestBody != null || !HttpMethod.requiresRequestBody(str)) {
                this.method = str;
                this.body = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder tag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.url = httpUrl;
            return this;
        }

        private Builder(Request request) {
            this.url = Request.access$600(request);
            this.method = Request.access$700(request);
            this.body = Request.access$800(request);
            this.tag = Request.access$900(request);
            this.headers = Request.access$1000(request).newBuilder();
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.squareup.okhttp.Request.Builder url(java.lang.String r7) {
            /*
                r6 = this;
                if (r7 == 0) goto L61
                r4 = 0
                r5 = 3
                r1 = 1
                r2 = 0
                java.lang.String r3 = "ws:"
                r0 = r7
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L26
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "http:"
                r0.append(r1)
                r1 = 3
            L1a:
                java.lang.String r7 = r7.substring(r1)
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                goto L3f
            L26:
                r4 = 0
                r5 = 4
                r1 = 1
                r2 = 0
                java.lang.String r3 = "wss:"
                r0 = r7
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L3f
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "https:"
                r0.append(r1)
                r1 = 4
                goto L1a
            L3f:
                com.squareup.okhttp.HttpUrl r0 = com.squareup.okhttp.HttpUrl.parse(r7)
                if (r0 == 0) goto L4a
                com.squareup.okhttp.Request$Builder r7 = r6.url(r0)
                return r7
            L4a:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "unexpected url: "
                r1.append(r2)
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                r0.<init>(r7)
                throw r0
            L61:
                java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "url == null"
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.Request.Builder.url(java.lang.String):com.squareup.okhttp.Request$Builder");
        }

        public /* synthetic */ Builder(Request request, 1 r2) {
            this(request);
        }

        public Builder url(URL url) {
            if (url == null) {
                throw new IllegalArgumentException("url == null");
            }
            HttpUrl httpUrl = HttpUrl.get(url);
            if (httpUrl != null) {
                return url(httpUrl);
            }
            throw new IllegalArgumentException("unexpected url: " + url);
        }
    }

    private Request(Builder builder) {
        this.url = Builder.access$000(builder);
        this.method = Builder.access$100(builder);
        this.headers = Builder.access$200(builder).build();
        this.body = Builder.access$300(builder);
        this.tag = Builder.access$400(builder) != null ? Builder.access$400(builder) : this;
    }

    public static /* synthetic */ Headers access$1000(Request request) {
        return request.headers;
    }

    public static /* synthetic */ HttpUrl access$600(Request request) {
        return request.url;
    }

    public static /* synthetic */ String access$700(Request request) {
        return request.method;
    }

    public static /* synthetic */ RequestBody access$800(Request request) {
        return request.body;
    }

    public static /* synthetic */ Object access$900(Request request) {
        return request.tag;
    }

    public RequestBody body() {
        return this.body;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.headers);
        this.cacheControl = parse;
        return parse;
    }

    public String header(String str) {
        return this.headers.get(str);
    }

    public Headers headers() {
        return this.headers;
    }

    public HttpUrl httpUrl() {
        return this.url;
    }

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public String method() {
        return this.method;
    }

    public Builder newBuilder() {
        return new Builder(this, null);
    }

    public Object tag() {
        return this.tag;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", tag=");
        Object obj = this.tag;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public URI uri() throws IOException {
        try {
            URI uri = this.javaNetUri;
            if (uri != null) {
                return uri;
            }
            URI uri2 = this.url.uri();
            this.javaNetUri = uri2;
            return uri2;
        } catch (IllegalStateException e) {
            throw new IOException(e.getMessage());
        }
    }

    public URL url() {
        URL url = this.javaNetUrl;
        if (url != null) {
            return url;
        }
        URL url2 = this.url.url();
        this.javaNetUrl = url2;
        return url2;
    }

    public String urlString() {
        return this.url.toString();
    }

    public /* synthetic */ Request(Builder builder, 1 r2) {
        this(builder);
    }

    public List headers(String str) {
        return this.headers.values(str);
    }
}
