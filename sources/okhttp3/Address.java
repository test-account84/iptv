package okhttp3;

import j$.util.Objects;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.l;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Address {

    @Nullable
    private final CertificatePinner certificatePinner;

    @NotNull
    private final List connectionSpecs;

    @NotNull
    private final Dns dns;

    @Nullable
    private final HostnameVerifier hostnameVerifier;

    @NotNull
    private final List protocols;

    @Nullable
    private final Proxy proxy;

    @NotNull
    private final Authenticator proxyAuthenticator;

    @NotNull
    private final ProxySelector proxySelector;

    @NotNull
    private final SocketFactory socketFactory;

    @Nullable
    private final SSLSocketFactory sslSocketFactory;

    @NotNull
    private final HttpUrl url;

    public Address(@NotNull String uriHost, int i, @NotNull Dns dns, @NotNull SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable CertificatePinner certificatePinner, @NotNull Authenticator proxyAuthenticator, @Nullable Proxy proxy, @NotNull List protocols, @NotNull List connectionSpecs, @NotNull ProxySelector proxySelector) {
        l.e(uriHost, "uriHost");
        l.e(dns, "dns");
        l.e(socketFactory, "socketFactory");
        l.e(proxyAuthenticator, "proxyAuthenticator");
        l.e(protocols, "protocols");
        l.e(connectionSpecs, "connectionSpecs");
        l.e(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(uriHost).port(i).build();
        this.protocols = Util.toImmutableList(protocols);
        this.connectionSpecs = Util.toImmutableList(connectionSpecs);
    }

    @Nullable
    public final CertificatePinner -deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @NotNull
    public final List -deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @NotNull
    public final Dns -deprecated_dns() {
        return this.dns;
    }

    @Nullable
    public final HostnameVerifier -deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @NotNull
    public final List -deprecated_protocols() {
        return this.protocols;
    }

    @Nullable
    public final Proxy -deprecated_proxy() {
        return this.proxy;
    }

    @NotNull
    public final Authenticator -deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @NotNull
    public final ProxySelector -deprecated_proxySelector() {
        return this.proxySelector;
    }

    @NotNull
    public final SocketFactory -deprecated_socketFactory() {
        return this.socketFactory;
    }

    @Nullable
    public final SSLSocketFactory -deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @NotNull
    public final HttpUrl -deprecated_url() {
        return this.url;
    }

    @Nullable
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @NotNull
    public final List connectionSpecs() {
        return this.connectionSpecs;
    }

    @NotNull
    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (l.a(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(@NotNull Address that) {
        l.e(that, "that");
        return l.a(this.dns, that.dns) && l.a(this.proxyAuthenticator, that.proxyAuthenticator) && l.a(this.protocols, that.protocols) && l.a(this.connectionSpecs, that.connectionSpecs) && l.a(this.proxySelector, that.proxySelector) && l.a(this.proxy, that.proxy) && l.a(this.sslSocketFactory, that.sslSocketFactory) && l.a(this.hostnameVerifier, that.hostnameVerifier) && l.a(this.certificatePinner, that.certificatePinner) && this.url.port() == that.url.port();
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    @Nullable
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @NotNull
    public final List protocols() {
        return this.protocols;
    }

    @Nullable
    public final Proxy proxy() {
        return this.proxy;
    }

    @NotNull
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @NotNull
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @NotNull
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @Nullable
    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        Proxy proxy;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.url.host());
        sb2.append(':');
        sb2.append(this.url.port());
        sb2.append(", ");
        if (this.proxy != null) {
            sb = new StringBuilder();
            sb.append("proxy=");
            proxy = this.proxy;
        } else {
            sb = new StringBuilder();
            sb.append("proxySelector=");
            proxy = this.proxySelector;
        }
        sb.append(proxy);
        sb2.append(sb.toString());
        sb2.append("}");
        return sb2.toString();
    }

    @NotNull
    public final HttpUrl url() {
        return this.url;
    }
}
