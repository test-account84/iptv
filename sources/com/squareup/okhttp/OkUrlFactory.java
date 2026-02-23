package com.squareup.okhttp;

import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.huc.CacheAdapter;
import com.squareup.okhttp.internal.huc.HttpURLConnectionImpl;
import com.squareup.okhttp.internal.huc.HttpsURLConnectionImpl;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ResponseCache;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class OkUrlFactory implements URLStreamHandlerFactory, Cloneable {
    private final OkHttpClient client;

    public class 1 extends URLStreamHandler {
        final /* synthetic */ String val$protocol;

        public 1(String str) {
            this.val$protocol = str;
        }

        public int getDefaultPort() {
            if (this.val$protocol.equals("http")) {
                return 80;
            }
            if (this.val$protocol.equals("https")) {
                return 443;
            }
            throw new AssertionError();
        }

        public URLConnection openConnection(URL url) {
            return OkUrlFactory.this.open(url);
        }

        public URLConnection openConnection(URL url, Proxy proxy) {
            return OkUrlFactory.this.open(url, proxy);
        }
    }

    public OkUrlFactory(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public OkHttpClient client() {
        return this.client;
    }

    public OkUrlFactory clone() {
        return new OkUrlFactory(this.client.clone());
    }

    public URLStreamHandler createURLStreamHandler(String str) {
        if (str.equals("http") || str.equals("https")) {
            return new 1(str);
        }
        return null;
    }

    public ResponseCache getResponseCache() {
        InternalCache internalCache = this.client.internalCache();
        if (internalCache instanceof CacheAdapter) {
            return ((CacheAdapter) internalCache).getDelegate();
        }
        return null;
    }

    public HttpURLConnection open(URL url) {
        return open(url, this.client.getProxy());
    }

    public OkUrlFactory setResponseCache(ResponseCache responseCache) {
        this.client.setInternalCache(responseCache != null ? new CacheAdapter(responseCache) : null);
        return this;
    }

    public HttpURLConnection open(URL url, Proxy proxy) {
        String protocol = url.getProtocol();
        OkHttpClient copyWithDefaults = this.client.copyWithDefaults();
        copyWithDefaults.setProxy(proxy);
        if (protocol.equals("http")) {
            return new HttpURLConnectionImpl(url, copyWithDefaults);
        }
        if (protocol.equals("https")) {
            return new HttpsURLConnectionImpl(url, copyWithDefaults);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol);
    }
}
