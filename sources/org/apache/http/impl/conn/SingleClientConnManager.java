package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SingleClientConnManager implements ClientConnectionManager {
    public static final String MISUSE_MESSAGE = "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
    protected final boolean alwaysShutDown;
    protected final ClientConnectionOperator connOperator;
    protected volatile long connectionExpiresTime;
    protected volatile boolean isShutDown;
    protected volatile long lastReleaseTime;
    private final Log log;
    protected volatile ConnAdapter managedConn;
    protected final SchemeRegistry schemeRegistry;
    protected volatile PoolEntry uniquePoolEntry;

    public class 1 implements ClientConnectionRequest {
        final /* synthetic */ HttpRoute val$route;
        final /* synthetic */ Object val$state;

        public 1(HttpRoute httpRoute, Object obj) {
            this.val$route = httpRoute;
            this.val$state = obj;
        }

        public void abortRequest() {
        }

        public ManagedClientConnection getConnection(long j, TimeUnit timeUnit) {
            return SingleClientConnManager.this.getConnection(this.val$route, this.val$state);
        }
    }

    public class ConnAdapter extends AbstractPooledConnAdapter {
        public ConnAdapter(PoolEntry poolEntry, HttpRoute httpRoute) {
            super(SingleClientConnManager.this, poolEntry);
            markReusable();
            poolEntry.route = httpRoute;
        }
    }

    public class PoolEntry extends AbstractPoolEntry {
        public PoolEntry() {
            super(SingleClientConnManager.this.connOperator, null);
        }

        public void close() throws IOException {
            shutdownEntry();
            if (this.connection.isOpen()) {
                this.connection.close();
            }
        }

        public void shutdown() throws IOException {
            shutdownEntry();
            if (this.connection.isOpen()) {
                this.connection.shutdown();
            }
        }
    }

    public SingleClientConnManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public final void assertStillUp() throws IllegalStateException {
        Asserts.check(!this.isShutDown, "Manager is shut down");
    }

    public void closeExpiredConnections() {
        if (System.currentTimeMillis() >= this.connectionExpiresTime) {
            closeIdleConnections(0L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036 A[Catch: all -> 0x002c, DONT_GENERATE, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:8:0x0017, B:12:0x0026, B:15:0x002f, B:16:0x0036), top: B:3:0x0009, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void closeIdleConnections(long r3, java.util.concurrent.TimeUnit r5) {
        /*
            r2 = this;
            r2.assertStillUp()
            java.lang.String r0 = "Time unit"
            org.apache.http.util.Args.notNull(r5, r0)
            monitor-enter(r2)
            org.apache.http.impl.conn.SingleClientConnManager$ConnAdapter r0 = r2.managedConn     // Catch: java.lang.Throwable -> L2c
            if (r0 != 0) goto L36
            org.apache.http.impl.conn.SingleClientConnManager$PoolEntry r0 = r2.uniquePoolEntry     // Catch: java.lang.Throwable -> L2c
            org.apache.http.conn.OperatedClientConnection r0 = r0.connection     // Catch: java.lang.Throwable -> L2c
            boolean r0 = r0.isOpen()     // Catch: java.lang.Throwable -> L2c
            if (r0 == 0) goto L36
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2c
            long r3 = r5.toMillis(r3)     // Catch: java.lang.Throwable -> L2c
            long r0 = r0 - r3
            long r3 = r2.lastReleaseTime     // Catch: java.lang.Throwable -> L2c
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 > 0) goto L36
            org.apache.http.impl.conn.SingleClientConnManager$PoolEntry r3 = r2.uniquePoolEntry     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            r3.close()     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            goto L36
        L2c:
            r3 = move-exception
            goto L38
        L2e:
            r3 = move-exception
            org.apache.commons.logging.Log r4 = r2.log     // Catch: java.lang.Throwable -> L2c
            java.lang.String r5 = "Problem closing idle connection."
            r4.debug(r5, r3)     // Catch: java.lang.Throwable -> L2c
        L36:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2c
            return
        L38:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2c
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.SingleClientConnManager.closeIdleConnections(long, java.util.concurrent.TimeUnit):void");
    }

    public ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new DefaultClientConnectionOperator(schemeRegistry);
    }

    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public ManagedClientConnection getConnection(HttpRoute httpRoute, Object obj) {
        boolean z;
        ConnAdapter connAdapter;
        Args.notNull(httpRoute, "Route");
        assertStillUp();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Get connection for route " + httpRoute);
        }
        synchronized (this) {
            boolean z2 = false;
            boolean z3 = true;
            Asserts.check(this.managedConn == null, "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.");
            closeExpiredConnections();
            if (this.uniquePoolEntry.connection.isOpen()) {
                RouteTracker routeTracker = this.uniquePoolEntry.tracker;
                z2 = routeTracker == null || !routeTracker.toRoute().equals(httpRoute);
                z = false;
            } else {
                z = true;
            }
            if (z2) {
                try {
                    this.uniquePoolEntry.shutdown();
                } catch (IOException e) {
                    this.log.debug("Problem shutting down connection.", e);
                }
            } else {
                z3 = z;
            }
            if (z3) {
                this.uniquePoolEntry = new PoolEntry();
            }
            this.managedConn = new ConnAdapter(this.uniquePoolEntry, httpRoute);
            connAdapter = this.managedConn;
        }
        return connAdapter;
    }

    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    public void releaseConnection(ManagedClientConnection managedClientConnection, long j, TimeUnit timeUnit) {
        Args.check(managedClientConnection instanceof ConnAdapter, "Connection class mismatch, connection not obtained from this manager");
        assertStillUp();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Releasing connection " + managedClientConnection);
        }
        ConnAdapter connAdapter = (ConnAdapter) managedClientConnection;
        synchronized (connAdapter) {
            try {
            } catch (IOException e) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Exception shutting down released connection.", e);
                }
                connAdapter.detach();
                synchronized (this) {
                    this.managedConn = null;
                    this.lastReleaseTime = System.currentTimeMillis();
                    if (j > 0) {
                        this.connectionExpiresTime = timeUnit.toMillis(j) + this.lastReleaseTime;
                    } else {
                        this.connectionExpiresTime = Long.MAX_VALUE;
                    }
                }
            } catch (Throwable th) {
                throw th;
            } finally {
            }
            if (connAdapter.poolEntry == null) {
                return;
            }
            Asserts.check(connAdapter.getManager() == this, "Connection not obtained from this manager");
            if (connAdapter.isOpen() && (this.alwaysShutDown || !connAdapter.isMarkedReusable())) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Released connection open but not reusable.");
                }
                connAdapter.shutdown();
            }
            connAdapter.detach();
            synchronized (this) {
                this.managedConn = null;
                this.lastReleaseTime = System.currentTimeMillis();
                if (j > 0) {
                    this.connectionExpiresTime = timeUnit.toMillis(j) + this.lastReleaseTime;
                } else {
                    this.connectionExpiresTime = Long.MAX_VALUE;
                }
            }
        }
    }

    public final ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        return new 1(httpRoute, obj);
    }

    public void revokeConnection() {
        ConnAdapter connAdapter = this.managedConn;
        if (connAdapter == null) {
            return;
        }
        connAdapter.detach();
        synchronized (this) {
            try {
                this.uniquePoolEntry.shutdown();
            } catch (IOException e) {
                this.log.debug("Problem while shutting down connection.", e);
            }
        }
    }

    public void shutdown() {
        this.isShutDown = true;
        synchronized (this) {
            try {
                try {
                    if (this.uniquePoolEntry != null) {
                        this.uniquePoolEntry.shutdown();
                    }
                    this.uniquePoolEntry = null;
                } catch (IOException e) {
                    this.log.debug("Problem while shutting down manager.", e);
                    this.uniquePoolEntry = null;
                }
                this.managedConn = null;
            } catch (Throwable th) {
                this.uniquePoolEntry = null;
                this.managedConn = null;
                throw th;
            }
        }
    }

    public SingleClientConnManager(SchemeRegistry schemeRegistry) {
        this.log = LogFactory.getLog(getClass());
        Args.notNull(schemeRegistry, "Scheme registry");
        this.schemeRegistry = schemeRegistry;
        this.connOperator = createConnectionOperator(schemeRegistry);
        this.uniquePoolEntry = new PoolEntry();
        this.managedConn = null;
        this.lastReleaseTime = -1L;
        this.alwaysShutDown = false;
        this.isShutDown = false;
    }

    @Deprecated
    public SingleClientConnManager(HttpParams httpParams, SchemeRegistry schemeRegistry) {
        this(schemeRegistry);
    }
}
