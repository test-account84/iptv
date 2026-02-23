package org.apache.http.protocol;

import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HttpProcessorBuilder {
    private ChainBuilder requestChainBuilder;
    private ChainBuilder responseChainBuilder;

    public static HttpProcessorBuilder create() {
        return new HttpProcessorBuilder();
    }

    private ChainBuilder getRequestChainBuilder() {
        if (this.requestChainBuilder == null) {
            this.requestChainBuilder = new ChainBuilder();
        }
        return this.requestChainBuilder;
    }

    private ChainBuilder getResponseChainBuilder() {
        if (this.responseChainBuilder == null) {
            this.responseChainBuilder = new ChainBuilder();
        }
        return this.responseChainBuilder;
    }

    public HttpProcessorBuilder add(HttpRequestInterceptor httpRequestInterceptor) {
        return addLast(httpRequestInterceptor);
    }

    public HttpProcessorBuilder addAll(HttpRequestInterceptor... httpRequestInterceptorArr) {
        return addAllLast(httpRequestInterceptorArr);
    }

    public HttpProcessorBuilder addAllFirst(HttpRequestInterceptor... httpRequestInterceptorArr) {
        if (httpRequestInterceptorArr == null) {
            return this;
        }
        getRequestChainBuilder().addAllFirst(httpRequestInterceptorArr);
        return this;
    }

    public HttpProcessorBuilder addAllLast(HttpRequestInterceptor... httpRequestInterceptorArr) {
        if (httpRequestInterceptorArr == null) {
            return this;
        }
        getRequestChainBuilder().addAllLast(httpRequestInterceptorArr);
        return this;
    }

    public HttpProcessorBuilder addFirst(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return this;
        }
        getRequestChainBuilder().addFirst(httpRequestInterceptor);
        return this;
    }

    public HttpProcessorBuilder addLast(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return this;
        }
        getRequestChainBuilder().addLast(httpRequestInterceptor);
        return this;
    }

    public HttpProcessor build() {
        ChainBuilder chainBuilder = this.requestChainBuilder;
        LinkedList build = chainBuilder != null ? chainBuilder.build() : null;
        ChainBuilder chainBuilder2 = this.responseChainBuilder;
        return new ImmutableHttpProcessor((List) build, (List) (chainBuilder2 != null ? chainBuilder2.build() : null));
    }

    public HttpProcessorBuilder add(HttpResponseInterceptor httpResponseInterceptor) {
        return addLast(httpResponseInterceptor);
    }

    public HttpProcessorBuilder addAll(HttpResponseInterceptor... httpResponseInterceptorArr) {
        return addAllLast(httpResponseInterceptorArr);
    }

    public HttpProcessorBuilder addAllFirst(HttpResponseInterceptor... httpResponseInterceptorArr) {
        if (httpResponseInterceptorArr == null) {
            return this;
        }
        getResponseChainBuilder().addAllFirst(httpResponseInterceptorArr);
        return this;
    }

    public HttpProcessorBuilder addAllLast(HttpResponseInterceptor... httpResponseInterceptorArr) {
        if (httpResponseInterceptorArr == null) {
            return this;
        }
        getResponseChainBuilder().addAllLast(httpResponseInterceptorArr);
        return this;
    }

    public HttpProcessorBuilder addFirst(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return this;
        }
        getResponseChainBuilder().addFirst(httpResponseInterceptor);
        return this;
    }

    public HttpProcessorBuilder addLast(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return this;
        }
        getResponseChainBuilder().addLast(httpResponseInterceptor);
        return this;
    }
}
