package org.apache.http.impl.conn;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.HttpClientConnectionOperator;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.pool.ConnFactory;
import org.apache.http.pool.ConnPoolControl;
import org.apache.http.pool.PoolEntry;
import org.apache.http.pool.PoolEntryCallback;
import org.apache.http.pool.PoolStats;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PoolingHttpClientConnectionManager implements HttpClientConnectionManager, ConnPoolControl, Closeable {
    private final ConfigData configData;
    private final HttpClientConnectionOperator connectionOperator;
    private final AtomicBoolean isShutDown;
    private final Log log;
    private final CPool pool;

    public class 1 implements ConnectionRequest {
        final /* synthetic */ Future val$future;
        final /* synthetic */ HttpRoute val$route;

        public 1(Future future, HttpRoute httpRoute) {
            this.val$future = future;
            this.val$route = httpRoute;
        }

        public boolean cancel() {
            return this.val$future.cancel(true);
        }

        public HttpClientConnection get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException {
            HttpClientConnection leaseConnection = PoolingHttpClientConnectionManager.this.leaseConnection(this.val$future, j, timeUnit);
            if (leaseConnection.isOpen()) {
                leaseConnection.setSocketTimeout(PoolingHttpClientConnectionManager.access$000(PoolingHttpClientConnectionManager.this, this.val$route.getProxyHost() != null ? this.val$route.getProxyHost() : this.val$route.getTargetHost()).getSoTimeout());
            }
            return leaseConnection;
        }
    }

    public static class ConfigData {
        private volatile ConnectionConfig defaultConnectionConfig;
        private volatile SocketConfig defaultSocketConfig;
        private final Map socketConfigMap = new ConcurrentHashMap();
        private final Map connectionConfigMap = new ConcurrentHashMap();

        public ConnectionConfig getConnectionConfig(HttpHost httpHost) {
            return (ConnectionConfig) this.connectionConfigMap.get(httpHost);
        }

        public ConnectionConfig getDefaultConnectionConfig() {
            return this.defaultConnectionConfig;
        }

        public SocketConfig getDefaultSocketConfig() {
            return this.defaultSocketConfig;
        }

        public SocketConfig getSocketConfig(HttpHost httpHost) {
            return (SocketConfig) this.socketConfigMap.get(httpHost);
        }

        public void setConnectionConfig(HttpHost httpHost, ConnectionConfig connectionConfig) {
            this.connectionConfigMap.put(httpHost, connectionConfig);
        }

        public void setDefaultConnectionConfig(ConnectionConfig connectionConfig) {
            this.defaultConnectionConfig = connectionConfig;
        }

        public void setDefaultSocketConfig(SocketConfig socketConfig) {
            this.defaultSocketConfig = socketConfig;
        }

        public void setSocketConfig(HttpHost httpHost, SocketConfig socketConfig) {
            this.socketConfigMap.put(httpHost, socketConfig);
        }
    }

    public static class InternalConnectionFactory implements ConnFactory {
        private final ConfigData configData;
        private final HttpConnectionFactory connFactory;

        public InternalConnectionFactory(ConfigData configData, HttpConnectionFactory httpConnectionFactory) {
            this.configData = configData == null ? new ConfigData() : configData;
            this.connFactory = httpConnectionFactory == null ? ManagedHttpClientConnectionFactory.INSTANCE : httpConnectionFactory;
        }

        public ManagedHttpClientConnection create(HttpRoute httpRoute) throws IOException {
            ConnectionConfig connectionConfig = httpRoute.getProxyHost() != null ? this.configData.getConnectionConfig(httpRoute.getProxyHost()) : null;
            if (connectionConfig == null) {
                connectionConfig = this.configData.getConnectionConfig(httpRoute.getTargetHost());
            }
            if (connectionConfig == null) {
                connectionConfig = this.configData.getDefaultConnectionConfig();
            }
            if (connectionConfig == null) {
                connectionConfig = ConnectionConfig.DEFAULT;
            }
            return (ManagedHttpClientConnection) this.connFactory.create(httpRoute, connectionConfig);
        }
    }

    public PoolingHttpClientConnectionManager() {
        this(getDefaultRegistry());
    }

    public static /* synthetic */ SocketConfig access$000(PoolingHttpClientConnectionManager poolingHttpClientConnectionManager, HttpHost httpHost) {
        return poolingHttpClientConnectionManager.resolveSocketConfig(httpHost);
    }

    private String format(HttpRoute httpRoute, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("[route: ");
        sb.append(httpRoute);
        sb.append("]");
        if (obj != null) {
            sb.append("[state: ");
            sb.append(obj);
            sb.append("]");
        }
        return sb.toString();
    }

    private String formatStats(HttpRoute httpRoute) {
        StringBuilder sb = new StringBuilder();
        PoolStats totalStats = this.pool.getTotalStats();
        PoolStats stats = this.pool.getStats(httpRoute);
        sb.append("[total kept alive: ");
        sb.append(totalStats.getAvailable());
        sb.append("; ");
        sb.append("route allocated: ");
        sb.append(stats.getLeased() + stats.getAvailable());
        sb.append(" of ");
        sb.append(stats.getMax());
        sb.append("; ");
        sb.append("total allocated: ");
        sb.append(totalStats.getLeased() + totalStats.getAvailable());
        sb.append(" of ");
        sb.append(totalStats.getMax());
        sb.append("]");
        return sb.toString();
    }

    private static Registry getDefaultRegistry() {
        return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    private SocketConfig resolveSocketConfig(HttpHost httpHost) {
        SocketConfig socketConfig = this.configData.getSocketConfig(httpHost);
        if (socketConfig == null) {
            socketConfig = this.configData.getDefaultSocketConfig();
        }
        return socketConfig == null ? SocketConfig.DEFAULT : socketConfig;
    }

    public void close() {
        shutdown();
    }

    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpired();
    }

    public void closeIdleConnections(long j, TimeUnit timeUnit) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Closing connections idle longer than " + j + " " + timeUnit);
        }
        this.pool.closeIdle(j, timeUnit);
    }

    public void connect(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int i, HttpContext httpContext) throws IOException {
        ManagedHttpClientConnection managedHttpClientConnection;
        Args.notNull(httpClientConnection, "Managed Connection");
        Args.notNull(httpRoute, "HTTP route");
        synchronized (httpClientConnection) {
            managedHttpClientConnection = (ManagedHttpClientConnection) CPoolProxy.getPoolEntry(httpClientConnection).getConnection();
        }
        HttpHost proxyHost = httpRoute.getProxyHost() != null ? httpRoute.getProxyHost() : httpRoute.getTargetHost();
        this.connectionOperator.connect(managedHttpClientConnection, proxyHost, httpRoute.getLocalSocketAddress(), i, resolveSocketConfig(proxyHost), httpContext);
    }

    public void enumAvailable(PoolEntryCallback poolEntryCallback) {
        this.pool.enumAvailable(poolEntryCallback);
    }

    public void enumLeased(PoolEntryCallback poolEntryCallback) {
        this.pool.enumLeased(poolEntryCallback);
    }

    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public ConnectionConfig getConnectionConfig(HttpHost httpHost) {
        return this.configData.getConnectionConfig(httpHost);
    }

    public ConnectionConfig getDefaultConnectionConfig() {
        return this.configData.getDefaultConnectionConfig();
    }

    public int getDefaultMaxPerRoute() {
        return this.pool.getDefaultMaxPerRoute();
    }

    public SocketConfig getDefaultSocketConfig() {
        return this.configData.getDefaultSocketConfig();
    }

    public int getMaxTotal() {
        return this.pool.getMaxTotal();
    }

    public Set getRoutes() {
        return this.pool.getRoutes();
    }

    public SocketConfig getSocketConfig(HttpHost httpHost) {
        return this.configData.getSocketConfig(httpHost);
    }

    public PoolStats getTotalStats() {
        return this.pool.getTotalStats();
    }

    public int getValidateAfterInactivity() {
        return this.pool.getValidateAfterInactivity();
    }

    public HttpClientConnection leaseConnection(Future future, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException {
        try {
            CPoolEntry cPoolEntry = (CPoolEntry) future.get(j, timeUnit);
            if (cPoolEntry == null || future.isCancelled()) {
                throw new InterruptedException();
            }
            Asserts.check(cPoolEntry.getConnection() != null, "Pool entry with no connection");
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connection leased: " + format(cPoolEntry) + formatStats((HttpRoute) cPoolEntry.getRoute()));
            }
            return CPoolProxy.newProxy(cPoolEntry);
        } catch (TimeoutException unused) {
            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
        }
    }

    public void releaseConnection(HttpClientConnection httpClientConnection, Object obj, long j, TimeUnit timeUnit) {
        String str;
        Args.notNull(httpClientConnection, "Managed connection");
        synchronized (httpClientConnection) {
            try {
                CPoolEntry detach = CPoolProxy.detach(httpClientConnection);
                if (detach == null) {
                    return;
                }
                ManagedHttpClientConnection managedHttpClientConnection = (ManagedHttpClientConnection) detach.getConnection();
                boolean z = true;
                try {
                    if (managedHttpClientConnection.isOpen()) {
                        if (timeUnit == null) {
                            timeUnit = TimeUnit.MILLISECONDS;
                        }
                        detach.setState(obj);
                        detach.updateExpiry(j, timeUnit);
                        if (this.log.isDebugEnabled()) {
                            if (j > 0) {
                                str = "for " + (timeUnit.toMillis(j) / 1000.0d) + " seconds";
                            } else {
                                str = "indefinitely";
                            }
                            this.log.debug("Connection " + format(detach) + " can be kept alive " + str);
                        }
                        managedHttpClientConnection.setSocketTimeout(0);
                    }
                    CPool cPool = this.pool;
                    if (!managedHttpClientConnection.isOpen() || !detach.isRouteComplete()) {
                        z = false;
                    }
                    cPool.release((PoolEntry) detach, z);
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Connection released: " + format(detach) + formatStats((HttpRoute) detach.getRoute()));
                    }
                } catch (Throwable th) {
                    CPool cPool2 = this.pool;
                    if (!managedHttpClientConnection.isOpen() || !detach.isRouteComplete()) {
                        z = false;
                    }
                    cPool2.release((PoolEntry) detach, z);
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Connection released: " + format(detach) + formatStats((HttpRoute) detach.getRoute()));
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public ConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        Args.notNull(httpRoute, "HTTP route");
        if (this.log.isDebugEnabled()) {
            this.log.debug("Connection request: " + format(httpRoute, obj) + formatStats(httpRoute));
        }
        return new 1(this.pool.lease(httpRoute, obj, null), httpRoute);
    }

    public void routeComplete(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
        Args.notNull(httpClientConnection, "Managed Connection");
        Args.notNull(httpRoute, "HTTP route");
        synchronized (httpClientConnection) {
            CPoolProxy.getPoolEntry(httpClientConnection).markRouteComplete();
        }
    }

    public void setConnectionConfig(HttpHost httpHost, ConnectionConfig connectionConfig) {
        this.configData.setConnectionConfig(httpHost, connectionConfig);
    }

    public void setDefaultConnectionConfig(ConnectionConfig connectionConfig) {
        this.configData.setDefaultConnectionConfig(connectionConfig);
    }

    public void setDefaultMaxPerRoute(int i) {
        this.pool.setDefaultMaxPerRoute(i);
    }

    public void setDefaultSocketConfig(SocketConfig socketConfig) {
        this.configData.setDefaultSocketConfig(socketConfig);
    }

    public void setMaxTotal(int i) {
        this.pool.setMaxTotal(i);
    }

    public void setSocketConfig(HttpHost httpHost, SocketConfig socketConfig) {
        this.configData.setSocketConfig(httpHost, socketConfig);
    }

    public void setValidateAfterInactivity(int i) {
        this.pool.setValidateAfterInactivity(i);
    }

    public void shutdown() {
        if (this.isShutDown.compareAndSet(false, true)) {
            this.log.debug("Connection manager is shutting down");
            try {
                this.pool.shutdown();
            } catch (IOException e) {
                this.log.debug("I/O exception shutting down connection manager", e);
            }
            this.log.debug("Connection manager shut down");
        }
    }

    public void upgrade(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
        ManagedHttpClientConnection managedHttpClientConnection;
        Args.notNull(httpClientConnection, "Managed Connection");
        Args.notNull(httpRoute, "HTTP route");
        synchronized (httpClientConnection) {
            managedHttpClientConnection = (ManagedHttpClientConnection) CPoolProxy.getPoolEntry(httpClientConnection).getConnection();
        }
        this.connectionOperator.upgrade(managedHttpClientConnection, httpRoute.getTargetHost(), httpContext);
    }

    public PoolingHttpClientConnectionManager(long j, TimeUnit timeUnit) {
        this(getDefaultRegistry(), null, null, null, j, timeUnit);
    }

    private String format(CPoolEntry cPoolEntry) {
        StringBuilder sb = new StringBuilder();
        sb.append("[id: ");
        sb.append(cPoolEntry.getId());
        sb.append("]");
        sb.append("[route: ");
        sb.append(cPoolEntry.getRoute());
        sb.append("]");
        Object state = cPoolEntry.getState();
        if (state != null) {
            sb.append("[state: ");
            sb.append(state);
            sb.append("]");
        }
        return sb.toString();
    }

    public int getMaxPerRoute(HttpRoute httpRoute) {
        return this.pool.getMaxPerRoute(httpRoute);
    }

    public PoolStats getStats(HttpRoute httpRoute) {
        return this.pool.getStats(httpRoute);
    }

    public void setMaxPerRoute(HttpRoute httpRoute, int i) {
        this.pool.setMaxPerRoute(httpRoute, i);
    }

    public PoolingHttpClientConnectionManager(Registry registry) {
        this(registry, null, null);
    }

    public PoolingHttpClientConnectionManager(Registry registry, DnsResolver dnsResolver) {
        this(registry, null, dnsResolver);
    }

    public PoolingHttpClientConnectionManager(Registry registry, HttpConnectionFactory httpConnectionFactory) {
        this(registry, httpConnectionFactory, null);
    }

    public PoolingHttpClientConnectionManager(Registry registry, HttpConnectionFactory httpConnectionFactory, DnsResolver dnsResolver) {
        this(registry, httpConnectionFactory, null, dnsResolver, -1L, TimeUnit.MILLISECONDS);
    }

    public PoolingHttpClientConnectionManager(Registry registry, HttpConnectionFactory httpConnectionFactory, SchemePortResolver schemePortResolver, DnsResolver dnsResolver, long j, TimeUnit timeUnit) {
        this(new DefaultHttpClientConnectionOperator(registry, schemePortResolver, dnsResolver), httpConnectionFactory, j, timeUnit);
    }

    public PoolingHttpClientConnectionManager(HttpClientConnectionOperator httpClientConnectionOperator, HttpConnectionFactory httpConnectionFactory, long j, TimeUnit timeUnit) {
        this.log = LogFactory.getLog(getClass());
        ConfigData configData = new ConfigData();
        this.configData = configData;
        CPool cPool = new CPool(new InternalConnectionFactory(configData, httpConnectionFactory), 2, 20, j, timeUnit);
        this.pool = cPool;
        cPool.setValidateAfterInactivity(2000);
        this.connectionOperator = (HttpClientConnectionOperator) Args.notNull(httpClientConnectionOperator, "HttpClientConnectionOperator");
        this.isShutDown = new AtomicBoolean(false);
    }

    public PoolingHttpClientConnectionManager(HttpConnectionFactory httpConnectionFactory) {
        this(getDefaultRegistry(), httpConnectionFactory, null);
    }

    public PoolingHttpClientConnectionManager(CPool cPool, Lookup lookup, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        this.log = LogFactory.getLog(getClass());
        this.configData = new ConfigData();
        this.pool = cPool;
        this.connectionOperator = new DefaultHttpClientConnectionOperator(lookup, schemePortResolver, dnsResolver);
        this.isShutDown = new AtomicBoolean(false);
    }
}
