package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import l8.j;
import l8.k;
import l8.p;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import w8.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RouteSelector {
    public static final Companion Companion = new Companion(null);
    private final Address address;
    private final Call call;
    private final EventListener eventListener;
    private List inetSocketAddresses;
    private int nextProxyIndex;
    private final List postponedRoutes;
    private List proxies;
    private final RouteDatabase routeDatabase;

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getSocketHost(@NotNull InetSocketAddress socketHost) {
            String hostName;
            String str;
            l.e(socketHost, "$this$socketHost");
            InetAddress address = socketHost.getAddress();
            if (address != null) {
                hostName = address.getHostAddress();
                str = "address.hostAddress";
            } else {
                hostName = socketHost.getHostName();
                str = "hostName";
            }
            l.d(hostName, str);
            return hostName;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final class Selection {
        private int nextRouteIndex;

        @NotNull
        private final List routes;

        public Selection(@NotNull List routes) {
            l.e(routes, "routes");
            this.routes = routes;
        }

        @NotNull
        public final List getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        @NotNull
        public final Route next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            List list = this.routes;
            int i = this.nextRouteIndex;
            this.nextRouteIndex = i + 1;
            return (Route) list.get(i);
        }
    }

    public static final class 1 extends m implements a {
        final /* synthetic */ Proxy $proxy;
        final /* synthetic */ HttpUrl $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 1(Proxy proxy, HttpUrl httpUrl) {
            super(0);
            this.$proxy = proxy;
            this.$url = httpUrl;
        }

        @NotNull
        public final List invoke() {
            Proxy proxy = this.$proxy;
            if (proxy != null) {
                return j.b(proxy);
            }
            URI uri = this.$url.uri();
            if (uri.getHost() == null) {
                return Util.immutableListOf(Proxy.NO_PROXY);
            }
            Collection select = RouteSelector.access$getAddress$p(RouteSelector.this).proxySelector().select(uri);
            Collection collection = select;
            return (collection == null || collection.isEmpty()) ? Util.immutableListOf(Proxy.NO_PROXY) : Util.toImmutableList(select);
        }
    }

    public RouteSelector(@NotNull Address address, @NotNull RouteDatabase routeDatabase, @NotNull Call call, @NotNull EventListener eventListener) {
        l.e(address, "address");
        l.e(routeDatabase, "routeDatabase");
        l.e(call, "call");
        l.e(eventListener, "eventListener");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.eventListener = eventListener;
        this.proxies = k.f();
        this.inetSocketAddresses = k.f();
        this.postponedRoutes = new ArrayList();
        resetNextProxy(address.url(), address.proxy());
    }

    public static final /* synthetic */ Address access$getAddress$p(RouteSelector routeSelector) {
        return routeSelector.address;
    }

    private final boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private final Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List list = this.proxies;
            int i = this.nextProxyIndex;
            this.nextProxyIndex = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
    }

    private final void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String host;
        int port;
        ArrayList arrayList = new ArrayList();
        this.inetSocketAddresses = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            host = this.address.url().host();
            port = this.address.url().port();
        } else {
            InetSocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + address.getClass()).toString());
            }
            InetSocketAddress inetSocketAddress = address;
            host = Companion.getSocketHost(inetSocketAddress);
            port = inetSocketAddress.getPort();
        }
        if (1 > port || 65535 < port) {
            throw new SocketException("No route to " + host + ':' + port + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(host, port));
            return;
        }
        this.eventListener.dnsStart(this.call, host);
        List lookup = this.address.dns().lookup(host);
        if (lookup.isEmpty()) {
            throw new UnknownHostException(this.address.dns() + " returned no addresses for " + host);
        }
        this.eventListener.dnsEnd(this.call, host, lookup);
        Iterator it = lookup.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress((InetAddress) it.next(), port));
        }
    }

    private final void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        1 r0 = new 1(proxy, httpUrl);
        this.eventListener.proxySelectStart(this.call, httpUrl);
        List invoke = r0.invoke();
        this.proxies = invoke;
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, httpUrl, invoke);
    }

    public final boolean hasNext() {
        return hasNextProxy() || (this.postponedRoutes.isEmpty() ^ true);
    }

    @NotNull
    public final Selection next() throws IOException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (hasNextProxy()) {
            Proxy nextProxy = nextProxy();
            Iterator it = this.inetSocketAddresses.iterator();
            while (it.hasNext()) {
                Route route = new Route(this.address, nextProxy, (InetSocketAddress) it.next());
                if (this.routeDatabase.shouldPostpone(route)) {
                    this.postponedRoutes.add(route);
                } else {
                    arrayList.add(route);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            p.q(arrayList, this.postponedRoutes);
            this.postponedRoutes.clear();
        }
        return new Selection(arrayList);
    }
}
