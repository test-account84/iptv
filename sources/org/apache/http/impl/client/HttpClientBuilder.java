package org.apache.http.impl.client;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.BackoffManager;
import org.apache.http.client.ConnectionBackoffStrategy;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.RequestAcceptEncoding;
import org.apache.http.client.protocol.RequestAddCookies;
import org.apache.http.client.protocol.RequestAuthCache;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.apache.http.client.protocol.RequestExpectContinue;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.apache.http.client.protocol.ResponseProcessCookies;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.auth.DigestSchemeFactory;
import org.apache.http.impl.auth.KerberosSchemeFactory;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.DefaultRoutePlanner;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.apache.http.impl.execchain.BackoffStrategyExec;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.impl.execchain.MainClientExec;
import org.apache.http.impl.execchain.ProtocolExec;
import org.apache.http.impl.execchain.RedirectExec;
import org.apache.http.impl.execchain.RetryExec;
import org.apache.http.impl.execchain.ServiceUnavailableRetryExec;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpProcessorBuilder;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.TextUtils;
import org.apache.http.util.VersionInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HttpClientBuilder {
    private boolean authCachingDisabled;
    private Lookup authSchemeRegistry;
    private boolean automaticRetriesDisabled;
    private BackoffManager backoffManager;
    private List closeables;
    private HttpClientConnectionManager connManager;
    private boolean connManagerShared;
    private ConnectionBackoffStrategy connectionBackoffStrategy;
    private boolean connectionStateDisabled;
    private boolean contentCompressionDisabled;
    private Map contentDecoderMap;
    private boolean cookieManagementDisabled;
    private Lookup cookieSpecRegistry;
    private CookieStore cookieStore;
    private CredentialsProvider credentialsProvider;
    private ConnectionConfig defaultConnectionConfig;
    private Collection defaultHeaders;
    private RequestConfig defaultRequestConfig;
    private SocketConfig defaultSocketConfig;
    private DnsResolver dnsResolver;
    private boolean evictExpiredConnections;
    private boolean evictIdleConnections;
    private HostnameVerifier hostnameVerifier;
    private HttpProcessor httpprocessor;
    private ConnectionKeepAliveStrategy keepAliveStrategy;
    private long maxIdleTime;
    private TimeUnit maxIdleTimeUnit;
    private HttpHost proxy;
    private AuthenticationStrategy proxyAuthStrategy;
    private PublicSuffixMatcher publicSuffixMatcher;
    private boolean redirectHandlingDisabled;
    private RedirectStrategy redirectStrategy;
    private HttpRequestExecutor requestExec;
    private LinkedList requestFirst;
    private LinkedList requestLast;
    private LinkedList responseFirst;
    private LinkedList responseLast;
    private HttpRequestRetryHandler retryHandler;
    private ConnectionReuseStrategy reuseStrategy;
    private HttpRoutePlanner routePlanner;
    private SchemePortResolver schemePortResolver;
    private ServiceUnavailableRetryStrategy serviceUnavailStrategy;
    private SSLContext sslContext;
    private LayeredConnectionSocketFactory sslSocketFactory;
    private boolean systemProperties;
    private AuthenticationStrategy targetAuthStrategy;
    private String userAgent;
    private UserTokenHandler userTokenHandler;
    private int maxConnTotal = 0;
    private int maxConnPerRoute = 0;
    private long connTimeToLive = -1;
    private TimeUnit connTimeToLiveTimeUnit = TimeUnit.MILLISECONDS;

    public class 1 implements Closeable {
        final /* synthetic */ IdleConnectionEvictor val$connectionEvictor;

        public 1(IdleConnectionEvictor idleConnectionEvictor) {
            this.val$connectionEvictor = idleConnectionEvictor;
        }

        public void close() throws IOException {
            this.val$connectionEvictor.shutdown();
            try {
                this.val$connectionEvictor.awaitTermination(1L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public class 2 implements Closeable {
        final /* synthetic */ HttpClientConnectionManager val$cm;

        public 2(HttpClientConnectionManager httpClientConnectionManager) {
            this.val$cm = httpClientConnectionManager;
        }

        public void close() throws IOException {
            this.val$cm.shutdown();
        }
    }

    public static HttpClientBuilder create() {
        return new HttpClientBuilder();
    }

    private static String[] split(String str) {
        if (TextUtils.isBlank(str)) {
            return null;
        }
        return str.split(" *, *");
    }

    public void addCloseable(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        if (this.closeables == null) {
            this.closeables = new ArrayList();
        }
        this.closeables.add(closeable);
    }

    public final HttpClientBuilder addInterceptorFirst(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return this;
        }
        if (this.requestFirst == null) {
            this.requestFirst = new LinkedList();
        }
        this.requestFirst.addFirst(httpRequestInterceptor);
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return this;
        }
        if (this.requestLast == null) {
            this.requestLast = new LinkedList();
        }
        this.requestLast.addLast(httpRequestInterceptor);
        return this;
    }

    public CloseableHttpClient build() {
        HttpClientConnectionManager httpClientConnectionManager;
        HttpRoutePlanner httpRoutePlanner;
        HttpClientConnectionManager httpClientConnectionManager2;
        ConnectionBackoffStrategy connectionBackoffStrategy;
        SSLConnectionSocketFactory sSLConnectionSocketFactory;
        PublicSuffixMatcher publicSuffixMatcher = this.publicSuffixMatcher;
        if (publicSuffixMatcher == null) {
            publicSuffixMatcher = PublicSuffixMatcherLoader.getDefault();
        }
        PublicSuffixMatcher publicSuffixMatcher2 = publicSuffixMatcher;
        HttpRequestExecutor httpRequestExecutor = this.requestExec;
        if (httpRequestExecutor == null) {
            httpRequestExecutor = new HttpRequestExecutor();
        }
        HttpRequestExecutor httpRequestExecutor2 = httpRequestExecutor;
        HttpClientConnectionManager httpClientConnectionManager3 = this.connManager;
        if (httpClientConnectionManager3 == null) {
            Object obj = this.sslSocketFactory;
            if (obj == null) {
                String[] split = this.systemProperties ? split(System.getProperty("https.protocols")) : null;
                String[] split2 = this.systemProperties ? split(System.getProperty("https.cipherSuites")) : null;
                HostnameVerifier hostnameVerifier = this.hostnameVerifier;
                if (hostnameVerifier == null) {
                    hostnameVerifier = new DefaultHostnameVerifier(publicSuffixMatcher2);
                }
                if (this.sslContext != null) {
                    sSLConnectionSocketFactory = new SSLConnectionSocketFactory(this.sslContext, split, split2, hostnameVerifier);
                } else if (this.systemProperties) {
                    sSLConnectionSocketFactory = new SSLConnectionSocketFactory(SSLSocketFactory.getDefault(), split, split2, hostnameVerifier);
                } else {
                    obj = new SSLConnectionSocketFactory(SSLContexts.createDefault(), hostnameVerifier);
                }
                obj = sSLConnectionSocketFactory;
            }
            Registry build = RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", obj).build();
            DnsResolver dnsResolver = this.dnsResolver;
            long j = this.connTimeToLive;
            TimeUnit timeUnit = this.connTimeToLiveTimeUnit;
            if (timeUnit == null) {
                timeUnit = TimeUnit.MILLISECONDS;
            }
            PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(build, null, null, dnsResolver, j, timeUnit);
            SocketConfig socketConfig = this.defaultSocketConfig;
            if (socketConfig != null) {
                poolingHttpClientConnectionManager.setDefaultSocketConfig(socketConfig);
            }
            ConnectionConfig connectionConfig = this.defaultConnectionConfig;
            if (connectionConfig != null) {
                poolingHttpClientConnectionManager.setDefaultConnectionConfig(connectionConfig);
            }
            if (this.systemProperties && "true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
                int parseInt = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
                poolingHttpClientConnectionManager.setDefaultMaxPerRoute(parseInt);
                poolingHttpClientConnectionManager.setMaxTotal(parseInt * 2);
            }
            int i = this.maxConnTotal;
            if (i > 0) {
                poolingHttpClientConnectionManager.setMaxTotal(i);
            }
            int i2 = this.maxConnPerRoute;
            if (i2 > 0) {
                poolingHttpClientConnectionManager.setDefaultMaxPerRoute(i2);
            }
            httpClientConnectionManager = poolingHttpClientConnectionManager;
        } else {
            httpClientConnectionManager = httpClientConnectionManager3;
        }
        ConnectionReuseStrategy connectionReuseStrategy = this.reuseStrategy;
        if (connectionReuseStrategy == null) {
            connectionReuseStrategy = (!this.systemProperties || "true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) ? DefaultClientConnectionReuseStrategy.INSTANCE : NoConnectionReuseStrategy.INSTANCE;
        }
        ConnectionReuseStrategy connectionReuseStrategy2 = connectionReuseStrategy;
        ConnectionKeepAliveStrategy connectionKeepAliveStrategy = this.keepAliveStrategy;
        if (connectionKeepAliveStrategy == null) {
            connectionKeepAliveStrategy = DefaultConnectionKeepAliveStrategy.INSTANCE;
        }
        ConnectionKeepAliveStrategy connectionKeepAliveStrategy2 = connectionKeepAliveStrategy;
        AuthenticationStrategy authenticationStrategy = this.targetAuthStrategy;
        if (authenticationStrategy == null) {
            authenticationStrategy = TargetAuthenticationStrategy.INSTANCE;
        }
        AuthenticationStrategy authenticationStrategy2 = authenticationStrategy;
        AuthenticationStrategy authenticationStrategy3 = this.proxyAuthStrategy;
        if (authenticationStrategy3 == null) {
            authenticationStrategy3 = ProxyAuthenticationStrategy.INSTANCE;
        }
        AuthenticationStrategy authenticationStrategy4 = authenticationStrategy3;
        UserTokenHandler userTokenHandler = this.userTokenHandler;
        if (userTokenHandler == null) {
            userTokenHandler = !this.connectionStateDisabled ? DefaultUserTokenHandler.INSTANCE : NoopUserTokenHandler.INSTANCE;
        }
        UserTokenHandler userTokenHandler2 = userTokenHandler;
        String str = this.userAgent;
        if (str == null) {
            if (this.systemProperties) {
                str = System.getProperty("http.agent");
            }
            if (str == null) {
                str = VersionInfo.getUserAgent("Apache-HttpClient", "org.apache.http.client", getClass());
            }
        }
        String str2 = str;
        ClientExecChain decorateMainExec = decorateMainExec(createMainExec(httpRequestExecutor2, httpClientConnectionManager, connectionReuseStrategy2, connectionKeepAliveStrategy2, new ImmutableHttpProcessor(new RequestTargetHost(), new RequestUserAgent(str2)), authenticationStrategy2, authenticationStrategy4, userTokenHandler2));
        HttpProcessor httpProcessor = this.httpprocessor;
        if (httpProcessor == null) {
            HttpProcessorBuilder create = HttpProcessorBuilder.create();
            LinkedList linkedList = this.requestFirst;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    create.addFirst((HttpRequestInterceptor) it.next());
                }
            }
            LinkedList linkedList2 = this.responseFirst;
            if (linkedList2 != null) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    create.addFirst((HttpResponseInterceptor) it2.next());
                }
            }
            create.addAll(new RequestDefaultHeaders(this.defaultHeaders), new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(str2), new RequestExpectContinue());
            if (!this.cookieManagementDisabled) {
                create.add(new RequestAddCookies());
            }
            if (!this.contentCompressionDisabled) {
                if (this.contentDecoderMap != null) {
                    ArrayList arrayList = new ArrayList(this.contentDecoderMap.keySet());
                    Collections.sort(arrayList);
                    create.add(new RequestAcceptEncoding(arrayList));
                } else {
                    create.add(new RequestAcceptEncoding());
                }
            }
            if (!this.authCachingDisabled) {
                create.add(new RequestAuthCache());
            }
            if (!this.cookieManagementDisabled) {
                create.add(new ResponseProcessCookies());
            }
            if (!this.contentCompressionDisabled) {
                if (this.contentDecoderMap != null) {
                    RegistryBuilder create2 = RegistryBuilder.create();
                    for (Map.Entry entry : this.contentDecoderMap.entrySet()) {
                        create2.register((String) entry.getKey(), entry.getValue());
                    }
                    create.add(new ResponseContentEncoding(create2.build()));
                } else {
                    create.add(new ResponseContentEncoding());
                }
            }
            LinkedList linkedList3 = this.requestLast;
            if (linkedList3 != null) {
                Iterator it3 = linkedList3.iterator();
                while (it3.hasNext()) {
                    create.addLast((HttpRequestInterceptor) it3.next());
                }
            }
            LinkedList linkedList4 = this.responseLast;
            if (linkedList4 != null) {
                Iterator it4 = linkedList4.iterator();
                while (it4.hasNext()) {
                    create.addLast((HttpResponseInterceptor) it4.next());
                }
            }
            httpProcessor = create.build();
        }
        ClientExecChain decorateProtocolExec = decorateProtocolExec(new ProtocolExec(decorateMainExec, httpProcessor));
        if (!this.automaticRetriesDisabled) {
            HttpRequestRetryHandler httpRequestRetryHandler = this.retryHandler;
            if (httpRequestRetryHandler == null) {
                httpRequestRetryHandler = DefaultHttpRequestRetryHandler.INSTANCE;
            }
            decorateProtocolExec = new RetryExec(decorateProtocolExec, httpRequestRetryHandler);
        }
        HttpRoutePlanner httpRoutePlanner2 = this.routePlanner;
        if (httpRoutePlanner2 == null) {
            SchemePortResolver schemePortResolver = this.schemePortResolver;
            if (schemePortResolver == null) {
                schemePortResolver = DefaultSchemePortResolver.INSTANCE;
            }
            HttpHost httpHost = this.proxy;
            httpRoutePlanner = httpHost != null ? new DefaultProxyRoutePlanner(httpHost, schemePortResolver) : this.systemProperties ? new SystemDefaultRoutePlanner(schemePortResolver, ProxySelector.getDefault()) : new DefaultRoutePlanner(schemePortResolver);
        } else {
            httpRoutePlanner = httpRoutePlanner2;
        }
        ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy = this.serviceUnavailStrategy;
        if (serviceUnavailableRetryStrategy != null) {
            decorateProtocolExec = new ServiceUnavailableRetryExec(decorateProtocolExec, serviceUnavailableRetryStrategy);
        }
        if (!this.redirectHandlingDisabled) {
            RedirectStrategy redirectStrategy = this.redirectStrategy;
            if (redirectStrategy == null) {
                redirectStrategy = DefaultRedirectStrategy.INSTANCE;
            }
            decorateProtocolExec = new RedirectExec(decorateProtocolExec, httpRoutePlanner, redirectStrategy);
        }
        BackoffManager backoffManager = this.backoffManager;
        if (backoffManager != null && (connectionBackoffStrategy = this.connectionBackoffStrategy) != null) {
            decorateProtocolExec = new BackoffStrategyExec(decorateProtocolExec, connectionBackoffStrategy, backoffManager);
        }
        Lookup lookup = this.authSchemeRegistry;
        if (lookup == null) {
            lookup = RegistryBuilder.create().register("Basic", new BasicSchemeFactory()).register("Digest", new DigestSchemeFactory()).register("NTLM", new NTLMSchemeFactory()).register("Negotiate", new SPNegoSchemeFactory()).register("Kerberos", new KerberosSchemeFactory()).build();
        }
        Lookup lookup2 = this.cookieSpecRegistry;
        if (lookup2 == null) {
            lookup2 = CookieSpecRegistries.createDefault(publicSuffixMatcher2);
        }
        CookieStore cookieStore = this.cookieStore;
        if (cookieStore == null) {
            cookieStore = new BasicCookieStore();
        }
        CredentialsProvider credentialsProvider = this.credentialsProvider;
        if (credentialsProvider == null) {
            credentialsProvider = this.systemProperties ? new SystemDefaultCredentialsProvider() : new BasicCredentialsProvider();
        }
        ArrayList arrayList2 = this.closeables != null ? new ArrayList(this.closeables) : null;
        if (this.connManagerShared) {
            httpClientConnectionManager2 = httpClientConnectionManager;
        } else {
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(1);
            }
            if (this.evictExpiredConnections || this.evictIdleConnections) {
                long j2 = this.maxIdleTime;
                long j3 = j2 > 0 ? j2 : 10L;
                TimeUnit timeUnit2 = this.maxIdleTimeUnit;
                httpClientConnectionManager2 = httpClientConnectionManager;
                IdleConnectionEvictor idleConnectionEvictor = new IdleConnectionEvictor(httpClientConnectionManager2, j3, timeUnit2 != null ? timeUnit2 : TimeUnit.SECONDS, j2, timeUnit2);
                arrayList2.add(new 1(idleConnectionEvictor));
                idleConnectionEvictor.start();
            } else {
                httpClientConnectionManager2 = httpClientConnectionManager;
            }
            arrayList2.add(new 2(httpClientConnectionManager2));
        }
        ArrayList arrayList3 = arrayList2;
        RequestConfig requestConfig = this.defaultRequestConfig;
        if (requestConfig == null) {
            requestConfig = RequestConfig.DEFAULT;
        }
        return new InternalHttpClient(decorateProtocolExec, httpClientConnectionManager2, httpRoutePlanner, lookup2, lookup, cookieStore, credentialsProvider, requestConfig, arrayList3);
    }

    public ClientExecChain createMainExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpProcessor httpProcessor, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        return new MainClientExec(httpRequestExecutor, httpClientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpProcessor, authenticationStrategy, authenticationStrategy2, userTokenHandler);
    }

    public ClientExecChain decorateMainExec(ClientExecChain clientExecChain) {
        return clientExecChain;
    }

    public ClientExecChain decorateProtocolExec(ClientExecChain clientExecChain) {
        return clientExecChain;
    }

    public final HttpClientBuilder disableAuthCaching() {
        this.authCachingDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableAutomaticRetries() {
        this.automaticRetriesDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableConnectionState() {
        this.connectionStateDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableContentCompression() {
        this.contentCompressionDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableCookieManagement() {
        this.cookieManagementDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableRedirectHandling() {
        this.redirectHandlingDisabled = true;
        return this;
    }

    public final HttpClientBuilder evictExpiredConnections() {
        this.evictExpiredConnections = true;
        return this;
    }

    public final HttpClientBuilder evictIdleConnections(long j, TimeUnit timeUnit) {
        this.evictIdleConnections = true;
        this.maxIdleTime = j;
        this.maxIdleTimeUnit = timeUnit;
        return this;
    }

    public final HttpClientBuilder setBackoffManager(BackoffManager backoffManager) {
        this.backoffManager = backoffManager;
        return this;
    }

    public final HttpClientBuilder setConnectionBackoffStrategy(ConnectionBackoffStrategy connectionBackoffStrategy) {
        this.connectionBackoffStrategy = connectionBackoffStrategy;
        return this;
    }

    public final HttpClientBuilder setConnectionManager(HttpClientConnectionManager httpClientConnectionManager) {
        this.connManager = httpClientConnectionManager;
        return this;
    }

    public final HttpClientBuilder setConnectionManagerShared(boolean z) {
        this.connManagerShared = z;
        return this;
    }

    public final HttpClientBuilder setConnectionReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        this.reuseStrategy = connectionReuseStrategy;
        return this;
    }

    public final HttpClientBuilder setConnectionTimeToLive(long j, TimeUnit timeUnit) {
        this.connTimeToLive = j;
        this.connTimeToLiveTimeUnit = timeUnit;
        return this;
    }

    public final HttpClientBuilder setContentDecoderRegistry(Map map) {
        this.contentDecoderMap = map;
        return this;
    }

    public final HttpClientBuilder setDefaultAuthSchemeRegistry(Lookup lookup) {
        this.authSchemeRegistry = lookup;
        return this;
    }

    public final HttpClientBuilder setDefaultConnectionConfig(ConnectionConfig connectionConfig) {
        this.defaultConnectionConfig = connectionConfig;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieSpecRegistry(Lookup lookup) {
        this.cookieSpecRegistry = lookup;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
        return this;
    }

    public final HttpClientBuilder setDefaultCredentialsProvider(CredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
        return this;
    }

    public final HttpClientBuilder setDefaultHeaders(Collection collection) {
        this.defaultHeaders = collection;
        return this;
    }

    public final HttpClientBuilder setDefaultRequestConfig(RequestConfig requestConfig) {
        this.defaultRequestConfig = requestConfig;
        return this;
    }

    public final HttpClientBuilder setDefaultSocketConfig(SocketConfig socketConfig) {
        this.defaultSocketConfig = socketConfig;
        return this;
    }

    public final HttpClientBuilder setDnsResolver(DnsResolver dnsResolver) {
        this.dnsResolver = dnsResolver;
        return this;
    }

    @Deprecated
    public final HttpClientBuilder setHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.hostnameVerifier = x509HostnameVerifier;
        return this;
    }

    public final HttpClientBuilder setHttpProcessor(HttpProcessor httpProcessor) {
        this.httpprocessor = httpProcessor;
        return this;
    }

    public final HttpClientBuilder setKeepAliveStrategy(ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        return this;
    }

    public final HttpClientBuilder setMaxConnPerRoute(int i) {
        this.maxConnPerRoute = i;
        return this;
    }

    public final HttpClientBuilder setMaxConnTotal(int i) {
        this.maxConnTotal = i;
        return this;
    }

    public final HttpClientBuilder setProxy(HttpHost httpHost) {
        this.proxy = httpHost;
        return this;
    }

    public final HttpClientBuilder setProxyAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.proxyAuthStrategy = authenticationStrategy;
        return this;
    }

    public final HttpClientBuilder setPublicSuffixMatcher(PublicSuffixMatcher publicSuffixMatcher) {
        this.publicSuffixMatcher = publicSuffixMatcher;
        return this;
    }

    public final HttpClientBuilder setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
        return this;
    }

    public final HttpClientBuilder setRequestExecutor(HttpRequestExecutor httpRequestExecutor) {
        this.requestExec = httpRequestExecutor;
        return this;
    }

    public final HttpClientBuilder setRetryHandler(HttpRequestRetryHandler httpRequestRetryHandler) {
        this.retryHandler = httpRequestRetryHandler;
        return this;
    }

    public final HttpClientBuilder setRoutePlanner(HttpRoutePlanner httpRoutePlanner) {
        this.routePlanner = httpRoutePlanner;
        return this;
    }

    public final HttpClientBuilder setSSLContext(SSLContext sSLContext) {
        this.sslContext = sSLContext;
        return this;
    }

    public final HttpClientBuilder setSSLHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
        return this;
    }

    public final HttpClientBuilder setSSLSocketFactory(LayeredConnectionSocketFactory layeredConnectionSocketFactory) {
        this.sslSocketFactory = layeredConnectionSocketFactory;
        return this;
    }

    public final HttpClientBuilder setSchemePortResolver(SchemePortResolver schemePortResolver) {
        this.schemePortResolver = schemePortResolver;
        return this;
    }

    public final HttpClientBuilder setServiceUnavailableRetryStrategy(ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        this.serviceUnavailStrategy = serviceUnavailableRetryStrategy;
        return this;
    }

    @Deprecated
    public final HttpClientBuilder setSslcontext(SSLContext sSLContext) {
        return setSSLContext(sSLContext);
    }

    public final HttpClientBuilder setTargetAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.targetAuthStrategy = authenticationStrategy;
        return this;
    }

    public final HttpClientBuilder setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }

    public final HttpClientBuilder setUserTokenHandler(UserTokenHandler userTokenHandler) {
        this.userTokenHandler = userTokenHandler;
        return this;
    }

    public final HttpClientBuilder useSystemProperties() {
        this.systemProperties = true;
        return this;
    }

    public final HttpClientBuilder addInterceptorFirst(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return this;
        }
        if (this.responseFirst == null) {
            this.responseFirst = new LinkedList();
        }
        this.responseFirst.addFirst(httpResponseInterceptor);
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return this;
        }
        if (this.responseLast == null) {
            this.responseLast = new LinkedList();
        }
        this.responseLast.addLast(httpResponseInterceptor);
        return this;
    }

    @Deprecated
    public final HttpClientBuilder evictIdleConnections(Long l, TimeUnit timeUnit) {
        return evictIdleConnections(l.longValue(), timeUnit);
    }
}
