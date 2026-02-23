package com.squareup.okhttp;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.AuthenticatorAdapter;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.net.CookieHandler;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class OkHttpClient implements Cloneable {
    public static final /* synthetic */ int a = 0;
    private static SSLSocketFactory defaultSslSocketFactory;
    private Authenticator authenticator;
    private Cache cache;
    private CertificatePinner certificatePinner;
    private int connectTimeout;
    private ConnectionPool connectionPool;
    private List connectionSpecs;
    private CookieHandler cookieHandler;
    private Dispatcher dispatcher;
    private Dns dns;
    private boolean followRedirects;
    private boolean followSslRedirects;
    private HostnameVerifier hostnameVerifier;
    private final List interceptors;
    private InternalCache internalCache;
    private final List networkInterceptors;
    private List protocols;
    private Proxy proxy;
    private ProxySelector proxySelector;
    private int readTimeout;
    private boolean retryOnConnectionFailure;
    private final RouteDatabase routeDatabase;
    private SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;
    private int writeTimeout;
    private static final List DEFAULT_PROTOCOLS = Util.immutableList(Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1);
    private static final List DEFAULT_CONNECTION_SPECS = Util.immutableList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT);

    public static class 1 extends Internal {
        public void addLenient(Headers.Builder builder, String str) {
            builder.addLenient(str);
        }

        public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
            connectionSpec.apply(sSLSocket, z);
        }

        public StreamAllocation callEngineGetStreamAllocation(Call call) {
            return call.engine.streamAllocation;
        }

        public void callEnqueue(Call call, Callback callback, boolean z) {
            call.enqueue(callback, z);
        }

        public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
            return connectionPool.connectionBecameIdle(realConnection);
        }

        public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
            return connectionPool.get(address, streamAllocation);
        }

        public HttpUrl getHttpUrlChecked(String str) throws MalformedURLException, UnknownHostException {
            return HttpUrl.getChecked(str);
        }

        public InternalCache internalCache(OkHttpClient okHttpClient) {
            return okHttpClient.internalCache();
        }

        public void put(ConnectionPool connectionPool, RealConnection realConnection) {
            connectionPool.put(realConnection);
        }

        public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
            return connectionPool.routeDatabase;
        }

        public void setCache(OkHttpClient okHttpClient, InternalCache internalCache) {
            okHttpClient.setInternalCache(internalCache);
        }

        public void addLenient(Headers.Builder builder, String str, String str2) {
            builder.addLenient(str, str2);
        }
    }

    static {
        Internal.instance = new 1();
    }

    public OkHttpClient() {
        this.interceptors = new ArrayList();
        this.networkInterceptors = new ArrayList();
        this.followSslRedirects = true;
        this.followRedirects = true;
        this.retryOnConnectionFailure = true;
        this.connectTimeout = 10000;
        this.readTimeout = 10000;
        this.writeTimeout = 10000;
        this.routeDatabase = new RouteDatabase();
        this.dispatcher = new Dispatcher();
    }

    private synchronized SSLSocketFactory getDefaultSSLSocketFactory() {
        if (defaultSslSocketFactory == null) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                defaultSslSocketFactory = sSLContext.getSocketFactory();
            } catch (GeneralSecurityException unused) {
                throw new AssertionError();
            }
        }
        return defaultSslSocketFactory;
    }

    public OkHttpClient cancel(Object obj) {
        getDispatcher().cancel(obj);
        return this;
    }

    public OkHttpClient clone() {
        return new OkHttpClient(this);
    }

    public OkHttpClient copyWithDefaults() {
        OkHttpClient okHttpClient = new OkHttpClient(this);
        if (okHttpClient.proxySelector == null) {
            okHttpClient.proxySelector = ProxySelector.getDefault();
        }
        if (okHttpClient.cookieHandler == null) {
            okHttpClient.cookieHandler = CookieHandler.getDefault();
        }
        if (okHttpClient.socketFactory == null) {
            okHttpClient.socketFactory = SocketFactory.getDefault();
        }
        if (okHttpClient.sslSocketFactory == null) {
            okHttpClient.sslSocketFactory = getDefaultSSLSocketFactory();
        }
        if (okHttpClient.hostnameVerifier == null) {
            okHttpClient.hostnameVerifier = OkHostnameVerifier.INSTANCE;
        }
        if (okHttpClient.certificatePinner == null) {
            okHttpClient.certificatePinner = CertificatePinner.DEFAULT;
        }
        if (okHttpClient.authenticator == null) {
            okHttpClient.authenticator = AuthenticatorAdapter.INSTANCE;
        }
        if (okHttpClient.connectionPool == null) {
            okHttpClient.connectionPool = ConnectionPool.getDefault();
        }
        if (okHttpClient.protocols == null) {
            okHttpClient.protocols = DEFAULT_PROTOCOLS;
        }
        if (okHttpClient.connectionSpecs == null) {
            okHttpClient.connectionSpecs = DEFAULT_CONNECTION_SPECS;
        }
        if (okHttpClient.dns == null) {
            okHttpClient.dns = Dns.SYSTEM;
        }
        return okHttpClient;
    }

    public Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public Cache getCache() {
        return this.cache;
    }

    public CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public List getConnectionSpecs() {
        return this.connectionSpecs;
    }

    public CookieHandler getCookieHandler() {
        return this.cookieHandler;
    }

    public Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public Dns getDns() {
        return this.dns;
    }

    public boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public boolean getFollowSslRedirects() {
        return this.followSslRedirects;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List getProtocols() {
        return this.protocols;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public int getWriteTimeout() {
        return this.writeTimeout;
    }

    public List interceptors() {
        return this.interceptors;
    }

    public InternalCache internalCache() {
        return this.internalCache;
    }

    public List networkInterceptors() {
        return this.networkInterceptors;
    }

    public Call newCall(Request request) {
        return new Call(this, request);
    }

    public RouteDatabase routeDatabase() {
        return this.routeDatabase;
    }

    public OkHttpClient setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
        return this;
    }

    public OkHttpClient setCache(Cache cache) {
        this.cache = cache;
        this.internalCache = null;
        return this;
    }

    public OkHttpClient setCertificatePinner(CertificatePinner certificatePinner) {
        this.certificatePinner = certificatePinner;
        return this;
    }

    public void setConnectTimeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (millis == 0 && j > 0) {
            throw new IllegalArgumentException("Timeout too small.");
        }
        this.connectTimeout = (int) millis;
    }

    public OkHttpClient setConnectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        return this;
    }

    public OkHttpClient setConnectionSpecs(List list) {
        this.connectionSpecs = Util.immutableList(list);
        return this;
    }

    public OkHttpClient setCookieHandler(CookieHandler cookieHandler) {
        this.cookieHandler = cookieHandler;
        return this;
    }

    public OkHttpClient setDispatcher(Dispatcher dispatcher) {
        if (dispatcher == null) {
            throw new IllegalArgumentException("dispatcher == null");
        }
        this.dispatcher = dispatcher;
        return this;
    }

    public OkHttpClient setDns(Dns dns) {
        this.dns = dns;
        return this;
    }

    public void setFollowRedirects(boolean z) {
        this.followRedirects = z;
    }

    public OkHttpClient setFollowSslRedirects(boolean z) {
        this.followSslRedirects = z;
        return this;
    }

    public OkHttpClient setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
        return this;
    }

    public void setInternalCache(InternalCache internalCache) {
        this.internalCache = internalCache;
        this.cache = null;
    }

    public OkHttpClient setProtocols(List list) {
        List immutableList = Util.immutableList(list);
        if (!immutableList.contains(Protocol.HTTP_1_1)) {
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + immutableList);
        }
        if (immutableList.contains(Protocol.HTTP_1_0)) {
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + immutableList);
        }
        if (immutableList.contains((Object) null)) {
            throw new IllegalArgumentException("protocols must not contain null");
        }
        this.protocols = Util.immutableList(immutableList);
        return this;
    }

    public OkHttpClient setProxy(Proxy proxy) {
        this.proxy = proxy;
        return this;
    }

    public OkHttpClient setProxySelector(ProxySelector proxySelector) {
        this.proxySelector = proxySelector;
        return this;
    }

    public void setReadTimeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (millis == 0 && j > 0) {
            throw new IllegalArgumentException("Timeout too small.");
        }
        this.readTimeout = (int) millis;
    }

    public void setRetryOnConnectionFailure(boolean z) {
        this.retryOnConnectionFailure = z;
    }

    public OkHttpClient setSocketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
        return this;
    }

    public OkHttpClient setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
        return this;
    }

    public void setWriteTimeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (millis == 0 && j > 0) {
            throw new IllegalArgumentException("Timeout too small.");
        }
        this.writeTimeout = (int) millis;
    }

    private OkHttpClient(OkHttpClient okHttpClient) {
        ArrayList arrayList = new ArrayList();
        this.interceptors = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.networkInterceptors = arrayList2;
        this.followSslRedirects = true;
        this.followRedirects = true;
        this.retryOnConnectionFailure = true;
        this.connectTimeout = 10000;
        this.readTimeout = 10000;
        this.writeTimeout = 10000;
        this.routeDatabase = okHttpClient.routeDatabase;
        this.dispatcher = okHttpClient.dispatcher;
        this.proxy = okHttpClient.proxy;
        this.protocols = okHttpClient.protocols;
        this.connectionSpecs = okHttpClient.connectionSpecs;
        arrayList.addAll(okHttpClient.interceptors);
        arrayList2.addAll(okHttpClient.networkInterceptors);
        this.proxySelector = okHttpClient.proxySelector;
        this.cookieHandler = okHttpClient.cookieHandler;
        Cache cache = okHttpClient.cache;
        this.cache = cache;
        this.internalCache = cache != null ? cache.internalCache : okHttpClient.internalCache;
        this.socketFactory = okHttpClient.socketFactory;
        this.sslSocketFactory = okHttpClient.sslSocketFactory;
        this.hostnameVerifier = okHttpClient.hostnameVerifier;
        this.certificatePinner = okHttpClient.certificatePinner;
        this.authenticator = okHttpClient.authenticator;
        this.connectionPool = okHttpClient.connectionPool;
        this.dns = okHttpClient.dns;
        this.followSslRedirects = okHttpClient.followSslRedirects;
        this.followRedirects = okHttpClient.followRedirects;
        this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
        this.connectTimeout = okHttpClient.connectTimeout;
        this.readTimeout = okHttpClient.readTimeout;
        this.writeTimeout = okHttpClient.writeTimeout;
    }
}
