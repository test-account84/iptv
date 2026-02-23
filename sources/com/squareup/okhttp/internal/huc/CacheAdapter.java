package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.CacheStrategy;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheResponse;
import java.net.ResponseCache;
import okio.Okio;
import okio.Sink;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class CacheAdapter implements InternalCache {
    private final ResponseCache delegate;

    public class 1 implements CacheRequest {
        final /* synthetic */ java.net.CacheRequest val$request;

        public 1(java.net.CacheRequest cacheRequest) {
            this.val$request = cacheRequest;
        }

        public void abort() {
            this.val$request.abort();
        }

        public Sink body() throws IOException {
            OutputStream body = this.val$request.getBody();
            if (body != null) {
                return Okio.sink(body);
            }
            return null;
        }
    }

    public CacheAdapter(ResponseCache responseCache) {
        this.delegate = responseCache;
    }

    private CacheResponse getJavaCachedResponse(Request request) throws IOException {
        return this.delegate.get(request.uri(), request.method(), JavaApiConverter.extractJavaHeaders(request));
    }

    public Response get(Request request) throws IOException {
        CacheResponse javaCachedResponse = getJavaCachedResponse(request);
        if (javaCachedResponse == null) {
            return null;
        }
        return JavaApiConverter.createOkResponse(request, javaCachedResponse);
    }

    public ResponseCache getDelegate() {
        return this.delegate;
    }

    public CacheRequest put(Response response) throws IOException {
        java.net.CacheRequest put = this.delegate.put(response.request().uri(), JavaApiConverter.createJavaUrlConnection(response));
        if (put == null) {
            return null;
        }
        return new 1(put);
    }

    public void remove(Request request) throws IOException {
    }

    public void trackConditionalCacheHit() {
    }

    public void trackResponse(CacheStrategy cacheStrategy) {
    }

    public void update(Response response, Response response2) throws IOException {
    }
}
