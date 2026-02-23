package okhttp3;

import j$.time.Duration;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import l8.p;
import l8.s;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.WebSocket;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {

    @NotNull
    private final Authenticator authenticator;

    @Nullable
    private final Cache cache;
    private final int callTimeoutMillis;

    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;

    @NotNull
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;

    @NotNull
    private final ConnectionPool connectionPool;

    @NotNull
    private final List connectionSpecs;

    @NotNull
    private final CookieJar cookieJar;

    @NotNull
    private final Dispatcher dispatcher;

    @NotNull
    private final Dns dns;

    @NotNull
    private final EventListener.Factory eventListenerFactory;
    private final boolean followRedirects;
    private final boolean followSslRedirects;

    @NotNull
    private final HostnameVerifier hostnameVerifier;

    @NotNull
    private final List interceptors;
    private final long minWebSocketMessageToCompress;

    @NotNull
    private final List networkInterceptors;
    private final int pingIntervalMillis;

    @NotNull
    private final List protocols;

    @Nullable
    private final Proxy proxy;

    @NotNull
    private final Authenticator proxyAuthenticator;

    @NotNull
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;

    @NotNull
    private final RouteDatabase routeDatabase;

    @NotNull
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactoryOrNull;
    private final int writeTimeoutMillis;

    @Nullable
    private final X509TrustManager x509TrustManager;
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final List DEFAULT_PROTOCOLS = Util.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);

    @NotNull
    private static final List DEFAULT_CONNECTION_SPECS = Util.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    public static final class Builder {

        @NotNull
        private Authenticator authenticator;

        @Nullable
        private Cache cache;
        private int callTimeout;

        @Nullable
        private CertificateChainCleaner certificateChainCleaner;

        @NotNull
        private CertificatePinner certificatePinner;
        private int connectTimeout;

        @NotNull
        private ConnectionPool connectionPool;

        @NotNull
        private List connectionSpecs;

        @NotNull
        private CookieJar cookieJar;

        @NotNull
        private Dispatcher dispatcher;

        @NotNull
        private Dns dns;

        @NotNull
        private EventListener.Factory eventListenerFactory;
        private boolean followRedirects;
        private boolean followSslRedirects;

        @NotNull
        private HostnameVerifier hostnameVerifier;

        @NotNull
        private final List interceptors;
        private long minWebSocketMessageToCompress;

        @NotNull
        private final List networkInterceptors;
        private int pingInterval;

        @NotNull
        private List protocols;

        @Nullable
        private Proxy proxy;

        @NotNull
        private Authenticator proxyAuthenticator;

        @Nullable
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;

        @Nullable
        private RouteDatabase routeDatabase;

        @NotNull
        private SocketFactory socketFactory;

        @Nullable
        private SSLSocketFactory sslSocketFactoryOrNull;
        private int writeTimeout;

        @Nullable
        private X509TrustManager x509TrustManagerOrNull;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = Util.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            Authenticator authenticator = Authenticator.NONE;
            this.authenticator = authenticator;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = authenticator;
            SocketFactory socketFactory = SocketFactory.getDefault();
            l.d(socketFactory, "SocketFactory.getDefault()");
            this.socketFactory = socketFactory;
            Companion companion = OkHttpClient.Companion;
            this.connectionSpecs = companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.minWebSocketMessageToCompress = 1024L;
        }

        @NotNull
        public final Builder -addInterceptor(@NotNull w8.l block) {
            l.e(block, "block");
            return addInterceptor(new OkHttpClient$Builder$addInterceptor$2(block));
        }

        @NotNull
        public final Builder -addNetworkInterceptor(@NotNull w8.l block) {
            l.e(block, "block");
            return addNetworkInterceptor(new OkHttpClient$Builder$addNetworkInterceptor$2(block));
        }

        @NotNull
        public final Builder addInterceptor(@NotNull Interceptor interceptor) {
            l.e(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        @NotNull
        public final Builder addNetworkInterceptor(@NotNull Interceptor interceptor) {
            l.e(interceptor, "interceptor");
            this.networkInterceptors.add(interceptor);
            return this;
        }

        @NotNull
        public final Builder authenticator(@NotNull Authenticator authenticator) {
            l.e(authenticator, "authenticator");
            this.authenticator = authenticator;
            return this;
        }

        @NotNull
        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        @NotNull
        public final Builder cache(@Nullable Cache cache) {
            this.cache = cache;
            return this;
        }

        @NotNull
        public final Builder callTimeout(long j, @NotNull TimeUnit unit) {
            l.e(unit, "unit");
            this.callTimeout = Util.checkDuration("timeout", j, unit);
            return this;
        }

        @NotNull
        public final Builder certificatePinner(@NotNull CertificatePinner certificatePinner) {
            l.e(certificatePinner, "certificatePinner");
            if (!l.a(certificatePinner, this.certificatePinner)) {
                this.routeDatabase = null;
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        @NotNull
        public final Builder connectTimeout(long j, @NotNull TimeUnit unit) {
            l.e(unit, "unit");
            this.connectTimeout = Util.checkDuration("timeout", j, unit);
            return this;
        }

        @NotNull
        public final Builder connectionPool(@NotNull ConnectionPool connectionPool) {
            l.e(connectionPool, "connectionPool");
            this.connectionPool = connectionPool;
            return this;
        }

        @NotNull
        public final Builder connectionSpecs(@NotNull List connectionSpecs) {
            l.e(connectionSpecs, "connectionSpecs");
            if (!l.a(connectionSpecs, this.connectionSpecs)) {
                this.routeDatabase = null;
            }
            this.connectionSpecs = Util.toImmutableList(connectionSpecs);
            return this;
        }

        @NotNull
        public final Builder cookieJar(@NotNull CookieJar cookieJar) {
            l.e(cookieJar, "cookieJar");
            this.cookieJar = cookieJar;
            return this;
        }

        @NotNull
        public final Builder dispatcher(@NotNull Dispatcher dispatcher) {
            l.e(dispatcher, "dispatcher");
            this.dispatcher = dispatcher;
            return this;
        }

        @NotNull
        public final Builder dns(@NotNull Dns dns) {
            l.e(dns, "dns");
            if (!l.a(dns, this.dns)) {
                this.routeDatabase = null;
            }
            this.dns = dns;
            return this;
        }

        @NotNull
        public final Builder eventListener(@NotNull EventListener eventListener) {
            l.e(eventListener, "eventListener");
            this.eventListenerFactory = Util.asFactory(eventListener);
            return this;
        }

        @NotNull
        public final Builder eventListenerFactory(@NotNull EventListener.Factory eventListenerFactory) {
            l.e(eventListenerFactory, "eventListenerFactory");
            this.eventListenerFactory = eventListenerFactory;
            return this;
        }

        @NotNull
        public final Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        @NotNull
        public final Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        @NotNull
        public final Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        @Nullable
        public final Cache getCache$okhttp() {
            return this.cache;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        @Nullable
        public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        @NotNull
        public final CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        @NotNull
        public final ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        @NotNull
        public final List getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        @NotNull
        public final CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        @NotNull
        public final Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        @NotNull
        public final Dns getDns$okhttp() {
            return this.dns;
        }

        @NotNull
        public final EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        @NotNull
        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        @NotNull
        public final List getInterceptors$okhttp() {
            return this.interceptors;
        }

        public final long getMinWebSocketMessageToCompress$okhttp() {
            return this.minWebSocketMessageToCompress;
        }

        @NotNull
        public final List getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        @NotNull
        public final List getProtocols$okhttp() {
            return this.protocols;
        }

        @Nullable
        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        @NotNull
        public final Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        @Nullable
        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        @Nullable
        public final RouteDatabase getRouteDatabase$okhttp() {
            return this.routeDatabase;
        }

        @NotNull
        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        @Nullable
        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        @Nullable
        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        @NotNull
        public final Builder hostnameVerifier(@NotNull HostnameVerifier hostnameVerifier) {
            l.e(hostnameVerifier, "hostnameVerifier");
            if (!l.a(hostnameVerifier, this.hostnameVerifier)) {
                this.routeDatabase = null;
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        @NotNull
        public final List interceptors() {
            return this.interceptors;
        }

        @NotNull
        public final Builder minWebSocketMessageToCompress(long j) {
            if (j >= 0) {
                this.minWebSocketMessageToCompress = j;
                return this;
            }
            throw new IllegalArgumentException(("minWebSocketMessageToCompress must be positive: " + j).toString());
        }

        @NotNull
        public final List networkInterceptors() {
            return this.networkInterceptors;
        }

        @NotNull
        public final Builder pingInterval(long j, @NotNull TimeUnit unit) {
            l.e(unit, "unit");
            this.pingInterval = Util.checkDuration("interval", j, unit);
            return this;
        }

        @NotNull
        public final Builder protocols(@NotNull List protocols) {
            l.e(protocols, "protocols");
            List N = s.N((Collection) protocols);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!(N.contains(protocol) || N.contains(Protocol.HTTP_1_1))) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + N).toString());
            }
            if (!(!N.contains(protocol) || N.size() <= 1)) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + N).toString());
            }
            if (!(!N.contains(Protocol.HTTP_1_0))) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + N).toString());
            }
            if (!(!N.contains((Object) null))) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            N.remove(Protocol.SPDY_3);
            if (!l.a(N, this.protocols)) {
                this.routeDatabase = null;
            }
            List unmodifiableList = Collections.unmodifiableList(N);
            l.d(unmodifiableList, "Collections.unmodifiableList(protocolsCopy)");
            this.protocols = unmodifiableList;
            return this;
        }

        @NotNull
        public final Builder proxy(@Nullable Proxy proxy) {
            if (!l.a(proxy, this.proxy)) {
                this.routeDatabase = null;
            }
            this.proxy = proxy;
            return this;
        }

        @NotNull
        public final Builder proxyAuthenticator(@NotNull Authenticator proxyAuthenticator) {
            l.e(proxyAuthenticator, "proxyAuthenticator");
            if (!l.a(proxyAuthenticator, this.proxyAuthenticator)) {
                this.routeDatabase = null;
            }
            this.proxyAuthenticator = proxyAuthenticator;
            return this;
        }

        @NotNull
        public final Builder proxySelector(@NotNull ProxySelector proxySelector) {
            l.e(proxySelector, "proxySelector");
            if (!l.a(proxySelector, this.proxySelector)) {
                this.routeDatabase = null;
            }
            this.proxySelector = proxySelector;
            return this;
        }

        @NotNull
        public final Builder readTimeout(long j, @NotNull TimeUnit unit) {
            l.e(unit, "unit");
            this.readTimeout = Util.checkDuration("timeout", j, unit);
            return this;
        }

        @NotNull
        public final Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public final void setAuthenticator$okhttp(@NotNull Authenticator authenticator) {
            l.e(authenticator, "<set-?>");
            this.authenticator = authenticator;
        }

        public final void setCache$okhttp(@Nullable Cache cache) {
            this.cache = cache;
        }

        public final void setCallTimeout$okhttp(int i) {
            this.callTimeout = i;
        }

        public final void setCertificateChainCleaner$okhttp(@Nullable CertificateChainCleaner certificateChainCleaner) {
            this.certificateChainCleaner = certificateChainCleaner;
        }

        public final void setCertificatePinner$okhttp(@NotNull CertificatePinner certificatePinner) {
            l.e(certificatePinner, "<set-?>");
            this.certificatePinner = certificatePinner;
        }

        public final void setConnectTimeout$okhttp(int i) {
            this.connectTimeout = i;
        }

        public final void setConnectionPool$okhttp(@NotNull ConnectionPool connectionPool) {
            l.e(connectionPool, "<set-?>");
            this.connectionPool = connectionPool;
        }

        public final void setConnectionSpecs$okhttp(@NotNull List list) {
            l.e(list, "<set-?>");
            this.connectionSpecs = list;
        }

        public final void setCookieJar$okhttp(@NotNull CookieJar cookieJar) {
            l.e(cookieJar, "<set-?>");
            this.cookieJar = cookieJar;
        }

        public final void setDispatcher$okhttp(@NotNull Dispatcher dispatcher) {
            l.e(dispatcher, "<set-?>");
            this.dispatcher = dispatcher;
        }

        public final void setDns$okhttp(@NotNull Dns dns) {
            l.e(dns, "<set-?>");
            this.dns = dns;
        }

        public final void setEventListenerFactory$okhttp(@NotNull EventListener.Factory factory) {
            l.e(factory, "<set-?>");
            this.eventListenerFactory = factory;
        }

        public final void setFollowRedirects$okhttp(boolean z) {
            this.followRedirects = z;
        }

        public final void setFollowSslRedirects$okhttp(boolean z) {
            this.followSslRedirects = z;
        }

        public final void setHostnameVerifier$okhttp(@NotNull HostnameVerifier hostnameVerifier) {
            l.e(hostnameVerifier, "<set-?>");
            this.hostnameVerifier = hostnameVerifier;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long j) {
            this.minWebSocketMessageToCompress = j;
        }

        public final void setPingInterval$okhttp(int i) {
            this.pingInterval = i;
        }

        public final void setProtocols$okhttp(@NotNull List list) {
            l.e(list, "<set-?>");
            this.protocols = list;
        }

        public final void setProxy$okhttp(@Nullable Proxy proxy) {
            this.proxy = proxy;
        }

        public final void setProxyAuthenticator$okhttp(@NotNull Authenticator authenticator) {
            l.e(authenticator, "<set-?>");
            this.proxyAuthenticator = authenticator;
        }

        public final void setProxySelector$okhttp(@Nullable ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
        }

        public final void setReadTimeout$okhttp(int i) {
            this.readTimeout = i;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z) {
            this.retryOnConnectionFailure = z;
        }

        public final void setRouteDatabase$okhttp(@Nullable RouteDatabase routeDatabase) {
            this.routeDatabase = routeDatabase;
        }

        public final void setSocketFactory$okhttp(@NotNull SocketFactory socketFactory) {
            l.e(socketFactory, "<set-?>");
            this.socketFactory = socketFactory;
        }

        public final void setSslSocketFactoryOrNull$okhttp(@Nullable SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactoryOrNull = sSLSocketFactory;
        }

        public final void setWriteTimeout$okhttp(int i) {
            this.writeTimeout = i;
        }

        public final void setX509TrustManagerOrNull$okhttp(@Nullable X509TrustManager x509TrustManager) {
            this.x509TrustManagerOrNull = x509TrustManager;
        }

        @NotNull
        public final Builder socketFactory(@NotNull SocketFactory socketFactory) {
            l.e(socketFactory, "socketFactory");
            if (!(!(socketFactory instanceof SSLSocketFactory))) {
                throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString());
            }
            if (!l.a(socketFactory, this.socketFactory)) {
                this.routeDatabase = null;
            }
            this.socketFactory = socketFactory;
            return this;
        }

        @NotNull
        public final Builder sslSocketFactory(@NotNull SSLSocketFactory sslSocketFactory) {
            l.e(sslSocketFactory, "sslSocketFactory");
            if (!l.a(sslSocketFactory, this.sslSocketFactoryOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            Platform.Companion companion = Platform.Companion;
            X509TrustManager trustManager = companion.get().trustManager(sslSocketFactory);
            if (trustManager != null) {
                this.x509TrustManagerOrNull = trustManager;
                Platform platform = companion.get();
                X509TrustManager x509TrustManager = this.x509TrustManagerOrNull;
                l.b(x509TrustManager);
                this.certificateChainCleaner = platform.buildCertificateChainCleaner(x509TrustManager);
                return this;
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + companion.get() + ", sslSocketFactory is " + sslSocketFactory.getClass());
        }

        @NotNull
        public final Builder writeTimeout(long j, @NotNull TimeUnit unit) {
            l.e(unit, "unit");
            this.writeTimeout = Util.checkDuration("timeout", j, unit);
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull OkHttpClient okHttpClient) {
            this();
            l.e(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.dispatcher();
            this.connectionPool = okHttpClient.connectionPool();
            p.q(this.interceptors, okHttpClient.interceptors());
            p.q(this.networkInterceptors, okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.authenticator = okHttpClient.authenticator();
            this.followRedirects = okHttpClient.followRedirects();
            this.followSslRedirects = okHttpClient.followSslRedirects();
            this.cookieJar = okHttpClient.cookieJar();
            this.cache = okHttpClient.cache();
            this.dns = okHttpClient.dns();
            this.proxy = okHttpClient.proxy();
            this.proxySelector = okHttpClient.proxySelector();
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
            this.socketFactory = okHttpClient.socketFactory();
            this.sslSocketFactoryOrNull = OkHttpClient.access$getSslSocketFactoryOrNull$p(okHttpClient);
            this.x509TrustManagerOrNull = okHttpClient.x509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.hostnameVerifier();
            this.certificatePinner = okHttpClient.certificatePinner();
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner();
            this.callTimeout = okHttpClient.callTimeoutMillis();
            this.connectTimeout = okHttpClient.connectTimeoutMillis();
            this.readTimeout = okHttpClient.readTimeoutMillis();
            this.writeTimeout = okHttpClient.writeTimeoutMillis();
            this.pingInterval = okHttpClient.pingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.minWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder callTimeout(@NotNull Duration duration) {
            l.e(duration, "duration");
            callTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder connectTimeout(@NotNull Duration duration) {
            l.e(duration, "duration");
            connectTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder pingInterval(@NotNull Duration duration) {
            l.e(duration, "duration");
            pingInterval(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder readTimeout(@NotNull Duration duration) {
            l.e(duration, "duration");
            readTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        public final Builder sslSocketFactory(@NotNull SSLSocketFactory sslSocketFactory, @NotNull X509TrustManager trustManager) {
            l.e(sslSocketFactory, "sslSocketFactory");
            l.e(trustManager, "trustManager");
            if ((!l.a(sslSocketFactory, this.sslSocketFactoryOrNull)) || (!l.a(trustManager, this.x509TrustManagerOrNull))) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.Companion.get(trustManager);
            this.x509TrustManagerOrNull = trustManager;
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder writeTimeout(@NotNull Duration duration) {
            l.e(duration, "duration");
            writeTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final List getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.access$getDEFAULT_CONNECTION_SPECS$cp();
        }

        @NotNull
        public final List getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.access$getDEFAULT_PROTOCOLS$cp();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public OkHttpClient() {
        this(new Builder());
    }

    public static final /* synthetic */ List access$getDEFAULT_CONNECTION_SPECS$cp() {
        return DEFAULT_CONNECTION_SPECS;
    }

    public static final /* synthetic */ List access$getDEFAULT_PROTOCOLS$cp() {
        return DEFAULT_PROTOCOLS;
    }

    public static final /* synthetic */ SSLSocketFactory access$getSslSocketFactoryOrNull$p(OkHttpClient okHttpClient) {
        return okHttpClient.sslSocketFactoryOrNull;
    }

    private final void verifyClientState() {
        if (this.interceptors == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!r0.contains((Object) null))) {
            throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
        }
        if (this.networkInterceptors == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!r0.contains((Object) null))) {
            throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
        }
        Collection collection = (Iterable) this.connectionSpecs;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).isTls()) {
                    if (this.sslSocketFactoryOrNull == null) {
                        throw new IllegalStateException("sslSocketFactory == null".toString());
                    }
                    if (this.certificateChainCleaner == null) {
                        throw new IllegalStateException("certificateChainCleaner == null".toString());
                    }
                    if (this.x509TrustManager == null) {
                        throw new IllegalStateException("x509TrustManager == null".toString());
                    }
                    return;
                }
            }
        }
        if (!(this.sslSocketFactoryOrNull == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.certificateChainCleaner == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.x509TrustManager == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!l.a(this.certificatePinner, CertificatePinner.DEFAULT)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @NotNull
    public final Authenticator -deprecated_authenticator() {
        return this.authenticator;
    }

    @Nullable
    public final Cache -deprecated_cache() {
        return this.cache;
    }

    public final int -deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @NotNull
    public final CertificatePinner -deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    public final int -deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @NotNull
    public final ConnectionPool -deprecated_connectionPool() {
        return this.connectionPool;
    }

    @NotNull
    public final List -deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @NotNull
    public final CookieJar -deprecated_cookieJar() {
        return this.cookieJar;
    }

    @NotNull
    public final Dispatcher -deprecated_dispatcher() {
        return this.dispatcher;
    }

    @NotNull
    public final Dns -deprecated_dns() {
        return this.dns;
    }

    @NotNull
    public final EventListener.Factory -deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final boolean -deprecated_followRedirects() {
        return this.followRedirects;
    }

    public final boolean -deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    @NotNull
    public final HostnameVerifier -deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @NotNull
    public final List -deprecated_interceptors() {
        return this.interceptors;
    }

    @NotNull
    public final List -deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    public final int -deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @NotNull
    public final List -deprecated_protocols() {
        return this.protocols;
    }

    @Nullable
    public final Proxy -deprecated_proxy() {
        return this.proxy;
    }

    @NotNull
    public final Authenticator -deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @NotNull
    public final ProxySelector -deprecated_proxySelector() {
        return this.proxySelector;
    }

    public final int -deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public final boolean -deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @NotNull
    public final SocketFactory -deprecated_socketFactory() {
        return this.socketFactory;
    }

    @NotNull
    public final SSLSocketFactory -deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    public final int -deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @NotNull
    public final Authenticator authenticator() {
        return this.authenticator;
    }

    @Nullable
    public final Cache cache() {
        return this.cache;
    }

    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @Nullable
    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    @NotNull
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @NotNull
    public Object clone() {
        return super.clone();
    }

    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @NotNull
    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    @NotNull
    public final List connectionSpecs() {
        return this.connectionSpecs;
    }

    @NotNull
    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    @NotNull
    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    @NotNull
    public final Dns dns() {
        return this.dns;
    }

    @NotNull
    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final boolean followRedirects() {
        return this.followRedirects;
    }

    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    @NotNull
    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    @NotNull
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @NotNull
    public final List interceptors() {
        return this.interceptors;
    }

    public final long minWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    @NotNull
    public final List networkInterceptors() {
        return this.networkInterceptors;
    }

    @NotNull
    public Builder newBuilder() {
        return new Builder(this);
    }

    @NotNull
    public Call newCall(@NotNull Request request) {
        l.e(request, "request");
        return new RealCall(this, request, false);
    }

    @NotNull
    public WebSocket newWebSocket(@NotNull Request request, @NotNull WebSocketListener listener) {
        l.e(request, "request");
        l.e(listener, "listener");
        RealWebSocket realWebSocket = new RealWebSocket(TaskRunner.INSTANCE, request, listener, new Random(), this.pingIntervalMillis, null, this.minWebSocketMessageToCompress);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @NotNull
    public final List protocols() {
        return this.protocols;
    }

    @Nullable
    public final Proxy proxy() {
        return this.proxy;
    }

    @NotNull
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @NotNull
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @NotNull
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @NotNull
    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @Nullable
    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public OkHttpClient(@org.jetbrains.annotations.NotNull okhttp3.OkHttpClient.Builder r4) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.OkHttpClient.<init>(okhttp3.OkHttpClient$Builder):void");
    }
}
