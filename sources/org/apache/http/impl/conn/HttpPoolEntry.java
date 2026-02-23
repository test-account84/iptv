package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.pool.PoolEntry;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class HttpPoolEntry extends PoolEntry {
    private final Log log;
    private final RouteTracker tracker;

    public HttpPoolEntry(Log log, String str, HttpRoute httpRoute, OperatedClientConnection operatedClientConnection, long j, TimeUnit timeUnit) {
        super(str, httpRoute, operatedClientConnection, j, timeUnit);
        this.log = log;
        this.tracker = new RouteTracker(httpRoute);
    }

    public void close() {
        try {
            ((OperatedClientConnection) getConnection()).close();
        } catch (IOException e) {
            this.log.debug("I/O error closing connection", e);
        }
    }

    public HttpRoute getEffectiveRoute() {
        return this.tracker.toRoute();
    }

    public HttpRoute getPlannedRoute() {
        return (HttpRoute) getRoute();
    }

    public RouteTracker getTracker() {
        return this.tracker;
    }

    public boolean isClosed() {
        return !((OperatedClientConnection) getConnection()).isOpen();
    }

    public boolean isExpired(long j) {
        boolean isExpired = super.isExpired(j);
        if (isExpired && this.log.isDebugEnabled()) {
            this.log.debug("Connection " + this + " expired @ " + new Date(getExpiry()));
        }
        return isExpired;
    }
}
