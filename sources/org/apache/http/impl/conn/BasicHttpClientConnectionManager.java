package org.apache.http.impl.conn;

import java.io.Closeable;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
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
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.LangUtils;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BasicHttpClientConnectionManager implements HttpClientConnectionManager, Closeable {
    private ManagedHttpClientConnection conn;
    private ConnectionConfig connConfig;
    private final HttpConnectionFactory connFactory;
    private final HttpClientConnectionOperator connectionOperator;
    private long expiry;
    private final AtomicBoolean isShutdown;
    private boolean leased;
    private final Log log;
    private HttpRoute route;
    private SocketConfig socketConfig;
    private Object state;
    private long updated;

    public class 1 implements ConnectionRequest {
        final /* synthetic */ HttpRoute val$route;
        final /* synthetic */ Object val$state;

        public 1(HttpRoute httpRoute, Object obj) {
            this.val$route = httpRoute;
            this.val$state = obj;
        }

        public boolean cancel() {
            return false;
        }

        public HttpClientConnection get(long j, TimeUnit timeUnit) {
            return BasicHttpClientConnectionManager.this.getConnection(this.val$route, this.val$state);
        }
    }

    public BasicHttpClientConnectionManager() {
        this(getDefaultRegistry(), null, null, null);
    }

    private void checkExpiry() {
        if (this.conn == null || System.currentTimeMillis() < this.expiry) {
            return;
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("Connection expired @ " + new Date(this.expiry));
        }
        closeConnection();
    }

    private synchronized void closeConnection() {
        if (this.conn != null) {
            this.log.debug("Closing connection");
            try {
                this.conn.close();
            } catch (IOException e) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("I/O exception closing connection", e);
                }
            }
            this.conn = null;
        }
    }

    private static Registry getDefaultRegistry() {
        return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    public void close() {
        if (this.isShutdown.compareAndSet(false, true)) {
            closeConnection();
        }
    }

    public synchronized void closeExpiredConnections() {
        if (this.isShutdown.get()) {
            return;
        }
        if (!this.leased) {
            checkExpiry();
        }
    }

    public synchronized void closeIdleConnections(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        if (this.isShutdown.get()) {
            return;
        }
        if (!this.leased) {
            long millis = timeUnit.toMillis(j);
            if (millis < 0) {
                millis = 0;
            }
            if (this.updated <= System.currentTimeMillis() - millis) {
                closeConnection();
            }
        }
    }

    public void connect(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int i, HttpContext httpContext) throws IOException {
        Args.notNull(httpClientConnection, "Connection");
        Args.notNull(httpRoute, "HTTP route");
        Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
        this.connectionOperator.connect(this.conn, httpRoute.getProxyHost() != null ? httpRoute.getProxyHost() : httpRoute.getTargetHost(), httpRoute.getLocalSocketAddress(), i, this.socketConfig, httpContext);
    }

    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public synchronized HttpClientConnection getConnection(HttpRoute httpRoute, Object obj) {
        try {
            Asserts.check(!this.isShutdown.get(), "Connection manager has been shut down");
            if (this.log.isDebugEnabled()) {
                this.log.debug("Get connection for route " + httpRoute);
            }
            Asserts.check(!this.leased, "Connection is still allocated");
            if (!LangUtils.equals(this.route, httpRoute) || !LangUtils.equals(this.state, obj)) {
                closeConnection();
            }
            this.route = httpRoute;
            this.state = obj;
            checkExpiry();
            if (this.conn == null) {
                this.conn = (ManagedHttpClientConnection) this.connFactory.create(httpRoute, this.connConfig);
            }
            this.conn.setSocketTimeout(this.socketConfig.getSoTimeout());
            this.leased = true;
        } catch (Throwable th) {
            throw th;
        }
        return this.conn;
    }

    public synchronized ConnectionConfig getConnectionConfig() {
        return this.connConfig;
    }

    public HttpRoute getRoute() {
        return this.route;
    }

    public synchronized SocketConfig getSocketConfig() {
        return this.socketConfig;
    }

    public Object getState() {
        return this.state;
    }

    public synchronized void releaseConnection(HttpClientConnection httpClientConnection, Object obj, long j, TimeUnit timeUnit) {
        String str;
        try {
            Args.notNull(httpClientConnection, "Connection");
            Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
            if (this.log.isDebugEnabled()) {
                this.log.debug("Releasing connection " + httpClientConnection);
            }
            if (this.isShutdown.get()) {
                return;
            }
            try {
                this.updated = System.currentTimeMillis();
                if (this.conn.isOpen()) {
                    this.state = obj;
                    this.conn.setSocketTimeout(0);
                    if (this.log.isDebugEnabled()) {
                        if (j > 0) {
                            str = "for " + j + " " + timeUnit;
                        } else {
                            str = "indefinitely";
                        }
                        this.log.debug("Connection can be kept alive " + str);
                    }
                    if (j > 0) {
                        this.expiry = this.updated + timeUnit.toMillis(j);
                    }
                    this.leased = false;
                }
                this.route = null;
                this.conn = null;
                this.expiry = Long.MAX_VALUE;
                this.leased = false;
            } catch (Throwable th) {
                this.leased = false;
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final ConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        Args.notNull(httpRoute, "Route");
        return new 1(httpRoute, obj);
    }

    public void routeComplete(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
    }

    public synchronized void setConnectionConfig(ConnectionConfig connectionConfig) {
        if (connectionConfig != null) {
            this.connConfig = connectionConfig;
        } else {
            connectionConfig = ConnectionConfig.DEFAULT;
            this.connConfig = connectionConfig;
        }
    }

    public synchronized void setSocketConfig(SocketConfig socketConfig) {
        if (socketConfig != null) {
            this.socketConfig = socketConfig;
        } else {
            socketConfig = SocketConfig.DEFAULT;
            this.socketConfig = socketConfig;
        }
    }

    public void shutdown() {
        close();
    }

    public void upgrade(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
        Args.notNull(httpClientConnection, "Connection");
        Args.notNull(httpRoute, "HTTP route");
        Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
        this.connectionOperator.upgrade(this.conn, httpRoute.getTargetHost(), httpContext);
    }

    public BasicHttpClientConnectionManager(Lookup lookup) {
        this(lookup, null, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup lookup, HttpConnectionFactory httpConnectionFactory) {
        this(lookup, httpConnectionFactory, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup lookup, HttpConnectionFactory httpConnectionFactory, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        this(new DefaultHttpClientConnectionOperator(lookup, schemePortResolver, dnsResolver), httpConnectionFactory);
    }

    public BasicHttpClientConnectionManager(HttpClientConnectionOperator httpClientConnectionOperator, HttpConnectionFactory httpConnectionFactory) {
        this.log = LogFactory.getLog(getClass());
        this.connectionOperator = (HttpClientConnectionOperator) Args.notNull(httpClientConnectionOperator, "Connection operator");
        this.connFactory = httpConnectionFactory == null ? ManagedHttpClientConnectionFactory.INSTANCE : httpConnectionFactory;
        this.expiry = Long.MAX_VALUE;
        this.socketConfig = SocketConfig.DEFAULT;
        this.connConfig = ConnectionConfig.DEFAULT;
        this.isShutdown = new AtomicBoolean(false);
    }
}
