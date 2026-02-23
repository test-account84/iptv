package org.apache.http.conn.params;

import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ConnManagerParams implements ConnManagerPNames {
    private static final ConnPerRoute DEFAULT_CONN_PER_ROUTE = new 1();
    public static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 20;

    public static class 1 implements ConnPerRoute {
        public int getMaxForRoute(HttpRoute httpRoute) {
            return 2;
        }
    }

    public static ConnPerRoute getMaxConnectionsPerRoute(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        ConnPerRoute connPerRoute = (ConnPerRoute) httpParams.getParameter("http.conn-manager.max-per-route");
        return connPerRoute == null ? DEFAULT_CONN_PER_ROUTE : connPerRoute;
    }

    public static int getMaxTotalConnections(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        return httpParams.getIntParameter("http.conn-manager.max-total", 20);
    }

    @Deprecated
    public static long getTimeout(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        return httpParams.getLongParameter("http.conn-manager.timeout", 0L);
    }

    public static void setMaxConnectionsPerRoute(HttpParams httpParams, ConnPerRoute connPerRoute) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setParameter("http.conn-manager.max-per-route", connPerRoute);
    }

    public static void setMaxTotalConnections(HttpParams httpParams, int i) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setIntParameter("http.conn-manager.max-total", i);
    }

    @Deprecated
    public static void setTimeout(HttpParams httpParams, long j) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setLongParameter("http.conn-manager.timeout", j);
    }
}
