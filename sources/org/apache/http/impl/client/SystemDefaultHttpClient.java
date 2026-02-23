package org.apache.http.impl.client;

import java.net.ProxySelector;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.params.HttpParams;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SystemDefaultHttpClient extends DefaultHttpClient {
    public SystemDefaultHttpClient() {
        super(null, null);
    }

    public ClientConnectionManager createClientConnectionManager() {
        PoolingClientConnectionManager poolingClientConnectionManager = new PoolingClientConnectionManager(SchemeRegistryFactory.createSystemDefault());
        if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
            int parseInt = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
            poolingClientConnectionManager.setDefaultMaxPerRoute(parseInt);
            poolingClientConnectionManager.setMaxTotal(parseInt * 2);
        }
        return poolingClientConnectionManager;
    }

    public ConnectionReuseStrategy createConnectionReuseStrategy() {
        return "true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true")) ? new DefaultConnectionReuseStrategy() : new NoConnectionReuseStrategy();
    }

    public HttpRoutePlanner createHttpRoutePlanner() {
        return new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), ProxySelector.getDefault());
    }

    public SystemDefaultHttpClient(HttpParams httpParams) {
        super(null, httpParams);
    }
}
