package okhttp3;

import E8.n;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k8.i;
import kotlin.jvm.internal.l;
import l8.B;
import l8.k;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Request {

    @Nullable
    private final RequestBody body;

    @NotNull
    private final Headers headers;
    private CacheControl lazyCacheControl;

    @NotNull
    private final String method;

    @NotNull
    private final Map tags;

    @NotNull
    private final HttpUrl url;

    public static class Builder {

        @Nullable
        private RequestBody body;

        @NotNull
        private Headers.Builder headers;

        @NotNull
        private String method;

        @NotNull
        private Map tags;

        @Nullable
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i & 1) != 0) {
                requestBody = Util.EMPTY_REQUEST;
            }
            return builder.delete(requestBody);
        }

        @NotNull
        public Builder addHeader(@NotNull String name, @NotNull String value) {
            l.e(name, "name");
            l.e(value, "value");
            this.headers.add(name, value);
            return this;
        }

        @NotNull
        public Request build() {
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new Request(httpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
            }
            throw new IllegalStateException("url == null".toString());
        }

        @NotNull
        public Builder cacheControl(@NotNull CacheControl cacheControl) {
            l.e(cacheControl, "cacheControl");
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", cacheControl2);
        }

        @NotNull
        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        @NotNull
        public Builder get() {
            return method("GET", null);
        }

        @Nullable
        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        @NotNull
        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @NotNull
        public final String getMethod$okhttp() {
            return this.method;
        }

        @NotNull
        public final Map getTags$okhttp() {
            return this.tags;
        }

        @Nullable
        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        @NotNull
        public Builder head() {
            return method("HEAD", null);
        }

        @NotNull
        public Builder header(@NotNull String name, @NotNull String value) {
            l.e(name, "name");
            l.e(value, "value");
            this.headers.set(name, value);
            return this;
        }

        @NotNull
        public Builder headers(@NotNull Headers headers) {
            l.e(headers, "headers");
            this.headers = headers.newBuilder();
            return this;
        }

        @NotNull
        public Builder method(@NotNull String method, @Nullable RequestBody requestBody) {
            l.e(method, "method");
            if (!(method.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (requestBody == null) {
                if (!(true ^ HttpMethod.requiresRequestBody(method))) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!HttpMethod.permitsRequestBody(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            this.method = method;
            this.body = requestBody;
            return this;
        }

        @NotNull
        public Builder patch(@NotNull RequestBody body) {
            l.e(body, "body");
            return method("PATCH", body);
        }

        @NotNull
        public Builder post(@NotNull RequestBody body) {
            l.e(body, "body");
            return method("POST", body);
        }

        @NotNull
        public Builder put(@NotNull RequestBody body) {
            l.e(body, "body");
            return method("PUT", body);
        }

        @NotNull
        public Builder removeHeader(@NotNull String name) {
            l.e(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        public final void setBody$okhttp(@Nullable RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(@NotNull Headers.Builder builder) {
            l.e(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(@NotNull String str) {
            l.e(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(@NotNull Map map) {
            l.e(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(@Nullable HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        @NotNull
        public Builder tag(@NotNull Class type, @Nullable Object obj) {
            l.e(type, "type");
            if (obj == null) {
                this.tags.remove(type);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                Map map = this.tags;
                Object cast = type.cast(obj);
                l.b(cast);
                map.put(type, cast);
            }
            return this;
        }

        @NotNull
        public Builder url(@NotNull String url) {
            StringBuilder sb;
            int i;
            l.e(url, "url");
            if (!n.z(url, "ws:", true)) {
                if (n.z(url, "wss:", true)) {
                    sb = new StringBuilder();
                    sb.append("https:");
                    i = 4;
                }
                return url(HttpUrl.Companion.get(url));
            }
            sb = new StringBuilder();
            sb.append("http:");
            i = 3;
            String substring = url.substring(i);
            l.d(substring, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            url = sb.toString();
            return url(HttpUrl.Companion.get(url));
        }

        public Builder(@NotNull Request request) {
            l.e(request, "request");
            this.tags = new LinkedHashMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            this.tags = request.getTags$okhttp().isEmpty() ? new LinkedHashMap() : B.n(request.getTags$okhttp());
            this.headers = request.headers().newBuilder();
        }

        @NotNull
        public Builder delete(@Nullable RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        @NotNull
        public Builder tag(@Nullable Object obj) {
            return tag(Object.class, obj);
        }

        @NotNull
        public Builder url(@NotNull URL url) {
            l.e(url, "url");
            HttpUrl.Companion companion = HttpUrl.Companion;
            String url2 = url.toString();
            l.d(url2, "url.toString()");
            return url(companion.get(url2));
        }

        @NotNull
        public Builder url(@NotNull HttpUrl url) {
            l.e(url, "url");
            this.url = url;
            return this;
        }
    }

    public Request(@NotNull HttpUrl url, @NotNull String method, @NotNull Headers headers, @Nullable RequestBody requestBody, @NotNull Map tags) {
        l.e(url, "url");
        l.e(method, "method");
        l.e(headers, "headers");
        l.e(tags, "tags");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = requestBody;
        this.tags = tags;
    }

    @Nullable
    public final RequestBody -deprecated_body() {
        return this.body;
    }

    @NotNull
    public final CacheControl -deprecated_cacheControl() {
        return cacheControl();
    }

    @NotNull
    public final Headers -deprecated_headers() {
        return this.headers;
    }

    @NotNull
    public final String -deprecated_method() {
        return this.method;
    }

    @NotNull
    public final HttpUrl -deprecated_url() {
        return this.url;
    }

    @Nullable
    public final RequestBody body() {
        return this.body;
    }

    @NotNull
    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = parse;
        return parse;
    }

    @NotNull
    public final Map getTags$okhttp() {
        return this.tags;
    }

    @Nullable
    public final String header(@NotNull String name) {
        l.e(name, "name");
        return this.headers.get(name);
    }

    @NotNull
    public final List headers(@NotNull String name) {
        l.e(name, "name");
        return this.headers.values(name);
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    @NotNull
    public final String method() {
        return this.method;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Nullable
    public final Object tag() {
        return tag(Object.class);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Object obj : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    k.n();
                }
                i iVar = (i) obj;
                String str = (String) iVar.a();
                String str2 = (String) iVar.b();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                sb.append(str2);
                i = i2;
            }
            sb.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        String sb2 = sb.toString();
        l.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final HttpUrl url() {
        return this.url;
    }

    @NotNull
    public final Headers headers() {
        return this.headers;
    }

    @Nullable
    public final Object tag(@NotNull Class type) {
        l.e(type, "type");
        return type.cast(this.tags.get(type));
    }
}
