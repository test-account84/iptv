package okhttp3.internal.cache;

import E8.n;
import java.io.IOException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Okio;
import okio.Sink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);

    @Nullable
    private final Cache cache;

    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Headers access$combine(Companion companion, Headers headers, Headers headers2) {
            return companion.combine(headers, headers2);
        }

        public static final /* synthetic */ Response access$stripBody(Companion companion, Response response) {
            return companion.stripBody(response);
        }

        private final Headers combine(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                String value = headers.value(i);
                if ((!n.o("Warning", name, true) || !n.B(value, "1", false, 2, null)) && (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String name2 = headers2.name(i2);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.addLenient$okhttp(name2, headers2.value(i2));
                }
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            return n.o("Content-Length", str, true) || n.o("Content-Encoding", str, true) || n.o("Content-Type", str, true);
        }

        private final boolean isEndToEnd(String str) {
            return (n.o("Connection", str, true) || n.o("Keep-Alive", str, true) || n.o("Proxy-Authenticate", str, true) || n.o("Proxy-Authorization", str, true) || n.o("TE", str, true) || n.o("Trailers", str, true) || n.o("Transfer-Encoding", str, true) || n.o("Upgrade", str, true)) ? false : true;
        }

        private final Response stripBody(Response response) {
            return (response != null ? response.body() : null) != null ? response.newBuilder().body(null).build() : response;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public CacheInterceptor(@Nullable Cache cache) {
        this.cache = cache;
    }

    private final Response cacheWritingResponse(CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Sink body = cacheRequest.body();
        ResponseBody body2 = response.body();
        l.b(body2);
        CacheInterceptor$cacheWritingResponse$cacheWritingSource$1 cacheInterceptor$cacheWritingResponse$cacheWritingSource$1 = new CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(body2.source(), cacheRequest, Okio.buffer(body));
        return response.newBuilder().body(new RealResponseBody(Response.header$default(response, "Content-Type", null, 2, null), response.body().contentLength(), Okio.buffer(cacheInterceptor$cacheWritingResponse$cacheWritingSource$1))).build();
    }

    @Nullable
    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        EventListener eventListener;
        ResponseBody body;
        ResponseBody body2;
        l.e(chain, "chain");
        Call call = chain.call();
        Cache cache = this.cache;
        Response response = cache != null ? cache.get$okhttp(chain.request()) : null;
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        Cache cache2 = this.cache;
        if (cache2 != null) {
            cache2.trackResponse$okhttp(compute);
        }
        RealCall realCall = (RealCall) (call instanceof RealCall ? call : null);
        if (realCall == null || (eventListener = realCall.getEventListener$okhttp()) == null) {
            eventListener = EventListener.NONE;
        }
        if (response != null && cacheResponse == null && (body2 = response.body()) != null) {
            Util.closeQuietly(body2);
        }
        if (networkRequest == null && cacheResponse == null) {
            Response build = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener.satisfactionFailure(call, build);
            return build;
        }
        if (networkRequest == null) {
            l.b(cacheResponse);
            Response build2 = cacheResponse.newBuilder().cacheResponse(Companion.access$stripBody(Companion, cacheResponse)).build();
            eventListener.cacheHit(call, build2);
            return build2;
        }
        if (cacheResponse != null) {
            eventListener.cacheConditionalHit(call, cacheResponse);
        } else if (this.cache != null) {
            eventListener.cacheMiss(call);
        }
        try {
            Response proceed = chain.proceed(networkRequest);
            if (proceed == null && response != null && body != null) {
            }
            if (cacheResponse != null) {
                if (proceed != null && proceed.code() == 304) {
                    Response.Builder newBuilder = cacheResponse.newBuilder();
                    Companion companion = Companion;
                    Response build3 = newBuilder.headers(Companion.access$combine(companion, cacheResponse.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(Companion.access$stripBody(companion, cacheResponse)).networkResponse(Companion.access$stripBody(companion, proceed)).build();
                    ResponseBody body3 = proceed.body();
                    l.b(body3);
                    body3.close();
                    Cache cache3 = this.cache;
                    l.b(cache3);
                    cache3.trackConditionalCacheHit$okhttp();
                    this.cache.update$okhttp(cacheResponse, build3);
                    eventListener.cacheHit(call, build3);
                    return build3;
                }
                ResponseBody body4 = cacheResponse.body();
                if (body4 != null) {
                    Util.closeQuietly(body4);
                }
            }
            l.b(proceed);
            Response.Builder newBuilder2 = proceed.newBuilder();
            Companion companion2 = Companion;
            Response build4 = newBuilder2.cacheResponse(Companion.access$stripBody(companion2, cacheResponse)).networkResponse(Companion.access$stripBody(companion2, proceed)).build();
            if (this.cache != null) {
                if (HttpHeaders.promisesBody(build4) && CacheStrategy.Companion.isCacheable(build4, networkRequest)) {
                    Response cacheWritingResponse = cacheWritingResponse(this.cache.put$okhttp(build4), build4);
                    if (cacheResponse != null) {
                        eventListener.cacheMiss(call);
                    }
                    return cacheWritingResponse;
                }
                if (HttpMethod.INSTANCE.invalidatesCache(networkRequest.method())) {
                    try {
                        this.cache.remove$okhttp(networkRequest);
                    } catch (IOException unused) {
                    }
                }
            }
            return build4;
        } finally {
            if (response != null && (body = response.body()) != null) {
                Util.closeQuietly(body);
            }
        }
    }
}
