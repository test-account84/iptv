package org.apache.http.conn.params;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ConnPerRouteBean implements ConnPerRoute {
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 2;
    private volatile int defaultMax;
    private final ConcurrentHashMap maxPerHostMap;

    public ConnPerRouteBean() {
        this(2);
    }

    public int getDefaultMax() {
        return this.defaultMax;
    }

    public int getDefaultMaxPerRoute() {
        return this.defaultMax;
    }

    public int getMaxForRoute(HttpRoute httpRoute) {
        Args.notNull(httpRoute, "HTTP route");
        Integer num = (Integer) this.maxPerHostMap.get(httpRoute);
        return num != null ? num.intValue() : this.defaultMax;
    }

    public void setDefaultMaxPerRoute(int i) {
        Args.positive(i, "Default max per route");
        this.defaultMax = i;
    }

    public void setMaxForRoute(HttpRoute httpRoute, int i) {
        Args.notNull(httpRoute, "HTTP route");
        Args.positive(i, "Max per route");
        this.maxPerHostMap.put(httpRoute, Integer.valueOf(i));
    }

    public void setMaxForRoutes(Map map) {
        if (map == null) {
            return;
        }
        this.maxPerHostMap.clear();
        this.maxPerHostMap.putAll(map);
    }

    public String toString() {
        return this.maxPerHostMap.toString();
    }

    public ConnPerRouteBean(int i) {
        this.maxPerHostMap = new ConcurrentHashMap();
        setDefaultMaxPerRoute(i);
    }
}
