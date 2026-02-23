package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.RouteDatabase;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RouteSelector {
    private final Address address;
    private InetSocketAddress lastInetSocketAddress;
    private Proxy lastProxy;
    private int nextInetSocketAddressIndex;
    private int nextProxyIndex;
    private final RouteDatabase routeDatabase;
    private List proxies = Collections.emptyList();
    private List inetSocketAddresses = Collections.emptyList();
    private final List postponedRoutes = new ArrayList();

    public RouteSelector(Address address, RouteDatabase routeDatabase) {
        this.address = address;
        this.routeDatabase = routeDatabase;
        resetNextProxy(address.url(), address.getProxy());
    }

    public static String getHostString(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private boolean hasNextInetSocketAddress() {
        return this.nextInetSocketAddressIndex < this.inetSocketAddresses.size();
    }

    private boolean hasNextPostponed() {
        return !this.postponedRoutes.isEmpty();
    }

    private boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private InetSocketAddress nextInetSocketAddress() throws IOException {
        if (hasNextInetSocketAddress()) {
            List list = this.inetSocketAddresses;
            int i = this.nextInetSocketAddressIndex;
            this.nextInetSocketAddressIndex = i + 1;
            return (InetSocketAddress) list.get(i);
        }
        throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted inet socket addresses: " + this.inetSocketAddresses);
    }

    private Route nextPostponed() {
        return (Route) this.postponedRoutes.remove(0);
    }

    private Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List list = this.proxies;
            int i = this.nextProxyIndex;
            this.nextProxyIndex = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted proxy configurations: " + this.proxies);
    }

    private void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String uriHost;
        int uriPort;
        this.inetSocketAddresses = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            uriHost = this.address.getUriHost();
            uriPort = this.address.getUriPort();
        } else {
            InetSocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = address;
            uriHost = getHostString(inetSocketAddress);
            uriPort = inetSocketAddress.getPort();
        }
        if (uriPort < 1 || uriPort > 65535) {
            throw new SocketException("No route to " + uriHost + ":" + uriPort + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.inetSocketAddresses.add(InetSocketAddress.createUnresolved(uriHost, uriPort));
        } else {
            List lookup = this.address.getDns().lookup(uriHost);
            int size = lookup.size();
            for (int i = 0; i < size; i++) {
                this.inetSocketAddresses.add(new InetSocketAddress((InetAddress) lookup.get(i), uriPort));
            }
        }
        this.nextInetSocketAddressIndex = 0;
    }

    private void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.proxies = Collections.singletonList(proxy);
        } else {
            this.proxies = new ArrayList();
            List select = this.address.getProxySelector().select(httpUrl.uri());
            if (select != null) {
                this.proxies.addAll(select);
            }
            List list = this.proxies;
            Proxy proxy2 = Proxy.NO_PROXY;
            list.removeAll(Collections.singleton(proxy2));
            this.proxies.add(proxy2);
        }
        this.nextProxyIndex = 0;
    }

    public void connectFailed(Route route, IOException iOException) {
        if (route.getProxy().type() != Proxy.Type.DIRECT && this.address.getProxySelector() != null) {
            this.address.getProxySelector().connectFailed(this.address.url().uri(), route.getProxy().address(), iOException);
        }
        this.routeDatabase.failed(route);
    }

    public boolean hasNext() {
        return hasNextInetSocketAddress() || hasNextProxy() || hasNextPostponed();
    }

    public Route next() throws IOException {
        if (!hasNextInetSocketAddress()) {
            if (!hasNextProxy()) {
                if (hasNextPostponed()) {
                    return nextPostponed();
                }
                throw new NoSuchElementException();
            }
            this.lastProxy = nextProxy();
        }
        InetSocketAddress nextInetSocketAddress = nextInetSocketAddress();
        this.lastInetSocketAddress = nextInetSocketAddress;
        Route route = new Route(this.address, this.lastProxy, nextInetSocketAddress);
        if (!this.routeDatabase.shouldPostpone(route)) {
            return route;
        }
        this.postponedRoutes.add(route);
        return next();
    }
}
