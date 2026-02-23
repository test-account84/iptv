package org.apache.http.impl.conn.tsccm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ThreadSafeClientConnManager implements ClientConnectionManager {
    protected final ClientConnectionOperator connOperator;
    protected final ConnPerRouteBean connPerRoute;
    protected final AbstractConnPool connectionPool;
    private final Log log;
    protected final ConnPoolByRoute pool;
    protected final SchemeRegistry schemeRegistry;

    public class 1 implements ClientConnectionRequest {
        final /* synthetic */ PoolEntryRequest val$poolRequest;
        final /* synthetic */ HttpRoute val$route;

        public 1(PoolEntryRequest poolEntryRequest, HttpRoute httpRoute) {
            this.val$poolRequest = poolEntryRequest;
            this.val$route = httpRoute;
        }

        public void abortRequest() {
            this.val$poolRequest.abortRequest();
        }

        public ManagedClientConnection getConnection(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
            Args.notNull(this.val$route, "Route");
            if (ThreadSafeClientConnManager.access$000(ThreadSafeClientConnManager.this).isDebugEnabled()) {
                ThreadSafeClientConnManager.access$000(ThreadSafeClientConnManager.this).debug("Get connection: " + this.val$route + ", timeout = " + j);
            }
            return new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, this.val$poolRequest.getPoolEntry(j, timeUnit));
        }
    }

    public ThreadSafeClientConnManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public static /* synthetic */ Log access$000(ThreadSafeClientConnManager threadSafeClientConnManager) {
        return threadSafeClientConnManager.log;
    }

    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpiredConnections();
    }

    public void closeIdleConnections(long j, TimeUnit timeUnit) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Closing connections idle longer than " + j + " " + timeUnit);
        }
        this.pool.closeIdleConnections(j, timeUnit);
    }

    public ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new DefaultClientConnectionOperator(schemeRegistry);
    }

    @Deprecated
    public AbstractConnPool createConnectionPool(HttpParams httpParams) {
        return new ConnPoolByRoute(this.connOperator, httpParams);
    }

    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public int getConnectionsInPool() {
        return this.pool.getConnectionsInPool();
    }

    public int getDefaultMaxPerRoute() {
        return this.connPerRoute.getDefaultMaxPerRoute();
    }

    public int getMaxForRoute(HttpRoute httpRoute) {
        return this.connPerRoute.getMaxForRoute(httpRoute);
    }

    public int getMaxTotal() {
        return this.pool.getMaxTotalConnections();
    }

    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    public void releaseConnection(ManagedClientConnection managedClientConnection, long j, TimeUnit timeUnit) {
        Log log;
        String str;
        boolean isMarkedReusable;
        ConnPoolByRoute connPoolByRoute;
        Log log2;
        String str2;
        Log log3;
        String str3;
        Args.check(managedClientConnection instanceof BasicPooledConnAdapter, "Connection class mismatch, connection not obtained from this manager");
        BasicPooledConnAdapter basicPooledConnAdapter = (BasicPooledConnAdapter) managedClientConnection;
        if (basicPooledConnAdapter.getPoolEntry() != null) {
            Asserts.check(basicPooledConnAdapter.getManager() == this, "Connection not obtained from this manager");
        }
        synchronized (basicPooledConnAdapter) {
            BasicPoolEntry basicPoolEntry = (BasicPoolEntry) basicPooledConnAdapter.getPoolEntry();
            try {
                if (basicPoolEntry == null) {
                    return;
                }
                try {
                    if (basicPooledConnAdapter.isOpen() && !basicPooledConnAdapter.isMarkedReusable()) {
                        basicPooledConnAdapter.shutdown();
                    }
                    isMarkedReusable = basicPooledConnAdapter.isMarkedReusable();
                    if (this.log.isDebugEnabled()) {
                        if (isMarkedReusable) {
                            log3 = this.log;
                            str3 = "Released connection is reusable.";
                        } else {
                            log3 = this.log;
                            str3 = "Released connection is not reusable.";
                        }
                        log3.debug(str3);
                    }
                    basicPooledConnAdapter.detach();
                    connPoolByRoute = this.pool;
                } catch (IOException e) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Exception shutting down released connection.", e);
                    }
                    isMarkedReusable = basicPooledConnAdapter.isMarkedReusable();
                    if (this.log.isDebugEnabled()) {
                        if (isMarkedReusable) {
                            log2 = this.log;
                            str2 = "Released connection is reusable.";
                        } else {
                            log2 = this.log;
                            str2 = "Released connection is not reusable.";
                        }
                        log2.debug(str2);
                    }
                    basicPooledConnAdapter.detach();
                    connPoolByRoute = this.pool;
                }
                connPoolByRoute.freeEntry(basicPoolEntry, isMarkedReusable, j, timeUnit);
            } catch (Throwable th) {
                boolean isMarkedReusable2 = basicPooledConnAdapter.isMarkedReusable();
                if (this.log.isDebugEnabled()) {
                    if (isMarkedReusable2) {
                        log = this.log;
                        str = "Released connection is reusable.";
                    } else {
                        log = this.log;
                        str = "Released connection is not reusable.";
                    }
                    log.debug(str);
                }
                basicPooledConnAdapter.detach();
                this.pool.freeEntry(basicPoolEntry, isMarkedReusable2, j, timeUnit);
                throw th;
            }
        }
    }

    public ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        return new 1(this.pool.requestPoolEntry(httpRoute, obj), httpRoute);
    }

    public void setDefaultMaxPerRoute(int i) {
        this.connPerRoute.setDefaultMaxPerRoute(i);
    }

    public void setMaxForRoute(HttpRoute httpRoute, int i) {
        this.connPerRoute.setMaxForRoute(httpRoute, i);
    }

    public void setMaxTotal(int i) {
        this.pool.setMaxTotalConnections(i);
    }

    public void shutdown() {
        this.log.debug("Shutting down");
        this.pool.shutdown();
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry) {
        this(schemeRegistry, -1L, TimeUnit.MILLISECONDS);
    }

    public ConnPoolByRoute createConnectionPool(long j, TimeUnit timeUnit) {
        return new ConnPoolByRoute(this.connOperator, this.connPerRoute, 20, j, timeUnit);
    }

    public int getConnectionsInPool(HttpRoute httpRoute) {
        return this.pool.getConnectionsInPool(httpRoute);
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry, long j, TimeUnit timeUnit) {
        this(schemeRegistry, j, timeUnit, new ConnPerRouteBean());
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry, long j, TimeUnit timeUnit, ConnPerRouteBean connPerRouteBean) {
        Args.notNull(schemeRegistry, "Scheme registry");
        this.log = LogFactory.getLog(getClass());
        this.schemeRegistry = schemeRegistry;
        this.connPerRoute = connPerRouteBean;
        this.connOperator = createConnectionOperator(schemeRegistry);
        ConnPoolByRoute createConnectionPool = createConnectionPool(j, timeUnit);
        this.pool = createConnectionPool;
        this.connectionPool = createConnectionPool;
    }

    @Deprecated
    public ThreadSafeClientConnManager(HttpParams httpParams, SchemeRegistry schemeRegistry) {
        Args.notNull(schemeRegistry, "Scheme registry");
        this.log = LogFactory.getLog(getClass());
        this.schemeRegistry = schemeRegistry;
        this.connPerRoute = new ConnPerRouteBean();
        this.connOperator = createConnectionOperator(schemeRegistry);
        ConnPoolByRoute connPoolByRoute = (ConnPoolByRoute) createConnectionPool(httpParams);
        this.pool = connPoolByRoute;
        this.connectionPool = connPoolByRoute;
    }
}
