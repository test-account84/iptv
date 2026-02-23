package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.pool.ConnPoolControl;
import org.apache.http.pool.PoolStats;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PoolingClientConnectionManager implements ClientConnectionManager, ConnPoolControl {
    private final DnsResolver dnsResolver;
    private final Log log;
    private final ClientConnectionOperator operator;
    private final HttpConnPool pool;
    private final SchemeRegistry schemeRegistry;

    public class 1 implements ClientConnectionRequest {
        final /* synthetic */ Future val$future;

        public 1(Future future) {
            this.val$future = future;
        }

        public void abortRequest() {
            this.val$future.cancel(true);
        }

        public ManagedClientConnection getConnection(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
            return PoolingClientConnectionManager.this.leaseConnection(this.val$future, j, timeUnit);
        }
    }

    public PoolingClientConnectionManager() {
        this(SchemeRegistryFactory.createDefault());
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

    public ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new DefaultClientConnectionOperator(schemeRegistry, this.dnsResolver);
    }

    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public int getDefaultMaxPerRoute() {
        return this.pool.getDefaultMaxPerRoute();
    }

    public int getMaxTotal() {
        return this.pool.getMaxTotal();
    }

    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    public PoolStats getTotalStats() {
        return this.pool.getTotalStats();
    }

    public ManagedClientConnection leaseConnection(Future future, long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
        try {
            HttpPoolEntry httpPoolEntry = (HttpPoolEntry) future.get(j, timeUnit);
            if (httpPoolEntry == null || future.isCancelled()) {
                throw new InterruptedException();
            }
            Asserts.check(httpPoolEntry.getConnection() != null, "Pool entry with no connection");
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connection leased: " + format(httpPoolEntry) + formatStats((HttpRoute) httpPoolEntry.getRoute()));
            }
            return new ManagedClientConnectionImpl(this, this.operator, httpPoolEntry);
        } catch (ExecutionException e) {
            e = e;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            this.log.error("Unexpected exception leasing connection from pool", e);
            throw new InterruptedException();
        } catch (TimeoutException unused) {
            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b2 A[Catch: all -> 0x0020, TryCatch #0 {, blocks: (B:7:0x0018, B:9:0x001e, B:37:0x00a1, B:39:0x00b2, B:40:0x00d9, B:43:0x00db, B:44:0x00e4, B:13:0x0023, B:15:0x0029, B:18:0x002f, B:21:0x0037, B:23:0x003f, B:24:0x0046, B:28:0x0052, B:32:0x0063, B:33:0x007f, B:36:0x0050), top: B:6:0x0018, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void releaseConnection(org.apache.http.conn.ManagedClientConnection r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof org.apache.http.impl.conn.ManagedClientConnectionImpl
            java.lang.String r1 = "Connection class mismatch, connection not obtained from this manager"
            org.apache.http.util.Args.check(r0, r1)
            org.apache.http.impl.conn.ManagedClientConnectionImpl r5 = (org.apache.http.impl.conn.ManagedClientConnectionImpl) r5
            org.apache.http.conn.ClientConnectionManager r0 = r5.getManager()
            if (r0 != r4) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            java.lang.String r1 = "Connection not obtained from this manager"
            org.apache.http.util.Asserts.check(r0, r1)
            monitor-enter(r5)
            org.apache.http.impl.conn.HttpPoolEntry r0 = r5.detach()     // Catch: java.lang.Throwable -> L20
            if (r0 != 0) goto L23
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L20
            return
        L20:
            r6 = move-exception
            goto Le5
        L23:
            boolean r1 = r5.isOpen()     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto L46
            boolean r1 = r5.isMarkedReusable()     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L46
            r5.shutdown()     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L36
            goto L46
        L33:
            r6 = move-exception
            goto Ldb
        L36:
            r1 = move-exception
            org.apache.commons.logging.Log r2 = r4.log     // Catch: java.lang.Throwable -> L33
            boolean r2 = r2.isDebugEnabled()     // Catch: java.lang.Throwable -> L33
            if (r2 == 0) goto L46
            org.apache.commons.logging.Log r2 = r4.log     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = "I/O exception shutting down released connection"
            r2.debug(r3, r1)     // Catch: java.lang.Throwable -> L33
        L46:
            boolean r1 = r5.isMarkedReusable()     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto La1
            if (r8 == 0) goto L50
            r1 = r8
            goto L52
        L50:
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L33
        L52:
            r0.updateExpiry(r6, r1)     // Catch: java.lang.Throwable -> L33
            org.apache.commons.logging.Log r1 = r4.log     // Catch: java.lang.Throwable -> L33
            boolean r1 = r1.isDebugEnabled()     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto La1
            r1 = 0
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 <= 0) goto L7d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33
            r1.<init>()     // Catch: java.lang.Throwable -> L33
            java.lang.String r2 = "for "
            r1.append(r2)     // Catch: java.lang.Throwable -> L33
            r1.append(r6)     // Catch: java.lang.Throwable -> L33
            java.lang.String r6 = " "
            r1.append(r6)     // Catch: java.lang.Throwable -> L33
            r1.append(r8)     // Catch: java.lang.Throwable -> L33
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> L33
            goto L7f
        L7d:
            java.lang.String r6 = "indefinitely"
        L7f:
            org.apache.commons.logging.Log r7 = r4.log     // Catch: java.lang.Throwable -> L33
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33
            r8.<init>()     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = "Connection "
            r8.append(r1)     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = r4.format(r0)     // Catch: java.lang.Throwable -> L33
            r8.append(r1)     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = " can be kept alive "
            r8.append(r1)     // Catch: java.lang.Throwable -> L33
            r8.append(r6)     // Catch: java.lang.Throwable -> L33
            java.lang.String r6 = r8.toString()     // Catch: java.lang.Throwable -> L33
            r7.debug(r6)     // Catch: java.lang.Throwable -> L33
        La1:
            org.apache.http.impl.conn.HttpConnPool r6 = r4.pool     // Catch: java.lang.Throwable -> L20
            boolean r7 = r5.isMarkedReusable()     // Catch: java.lang.Throwable -> L20
            r6.release(r0, r7)     // Catch: java.lang.Throwable -> L20
            org.apache.commons.logging.Log r6 = r4.log     // Catch: java.lang.Throwable -> L20
            boolean r6 = r6.isDebugEnabled()     // Catch: java.lang.Throwable -> L20
            if (r6 == 0) goto Ld9
            org.apache.commons.logging.Log r6 = r4.log     // Catch: java.lang.Throwable -> L20
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L20
            r7.<init>()     // Catch: java.lang.Throwable -> L20
            java.lang.String r8 = "Connection released: "
            r7.append(r8)     // Catch: java.lang.Throwable -> L20
            java.lang.String r8 = r4.format(r0)     // Catch: java.lang.Throwable -> L20
            r7.append(r8)     // Catch: java.lang.Throwable -> L20
            java.lang.Object r8 = r0.getRoute()     // Catch: java.lang.Throwable -> L20
            org.apache.http.conn.routing.HttpRoute r8 = (org.apache.http.conn.routing.HttpRoute) r8     // Catch: java.lang.Throwable -> L20
            java.lang.String r8 = r4.formatStats(r8)     // Catch: java.lang.Throwable -> L20
            r7.append(r8)     // Catch: java.lang.Throwable -> L20
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L20
            r6.debug(r7)     // Catch: java.lang.Throwable -> L20
        Ld9:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L20
            return
        Ldb:
            org.apache.http.impl.conn.HttpConnPool r7 = r4.pool     // Catch: java.lang.Throwable -> L20
            boolean r8 = r5.isMarkedReusable()     // Catch: java.lang.Throwable -> L20
            r7.release(r0, r8)     // Catch: java.lang.Throwable -> L20
            throw r6     // Catch: java.lang.Throwable -> L20
        Le5:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L20
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.PoolingClientConnectionManager.releaseConnection(org.apache.http.conn.ManagedClientConnection, long, java.util.concurrent.TimeUnit):void");
    }

    public ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        Args.notNull(httpRoute, "HTTP route");
        if (this.log.isDebugEnabled()) {
            this.log.debug("Connection request: " + format(httpRoute, obj) + formatStats(httpRoute));
        }
        return new 1(this.pool.lease(httpRoute, obj));
    }

    public void setDefaultMaxPerRoute(int i) {
        this.pool.setDefaultMaxPerRoute(i);
    }

    public void setMaxTotal(int i) {
        this.pool.setMaxTotal(i);
    }

    public void shutdown() {
        this.log.debug("Connection manager is shutting down");
        try {
            this.pool.shutdown();
        } catch (IOException e) {
            this.log.debug("I/O exception shutting down connection manager", e);
        }
        this.log.debug("Connection manager shut down");
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry) {
        this(schemeRegistry, -1L, TimeUnit.MILLISECONDS);
    }

    private String format(HttpPoolEntry httpPoolEntry) {
        StringBuilder sb = new StringBuilder();
        sb.append("[id: ");
        sb.append(httpPoolEntry.getId());
        sb.append("]");
        sb.append("[route: ");
        sb.append(httpPoolEntry.getRoute());
        sb.append("]");
        Object state = httpPoolEntry.getState();
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

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, long j, TimeUnit timeUnit) {
        this(schemeRegistry, j, timeUnit, new SystemDefaultDnsResolver());
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, long j, TimeUnit timeUnit, DnsResolver dnsResolver) {
        Log log = LogFactory.getLog(getClass());
        this.log = log;
        Args.notNull(schemeRegistry, "Scheme registry");
        Args.notNull(dnsResolver, "DNS resolver");
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = dnsResolver;
        ClientConnectionOperator createConnectionOperator = createConnectionOperator(schemeRegistry);
        this.operator = createConnectionOperator;
        this.pool = new HttpConnPool(log, createConnectionOperator, 2, 20, j, timeUnit);
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, DnsResolver dnsResolver) {
        this(schemeRegistry, -1L, TimeUnit.MILLISECONDS, dnsResolver);
    }
}
