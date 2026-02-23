package okhttp3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final EventListener NONE = new EventListener$Companion$NONE$1();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public interface Factory {
        @NotNull
        EventListener create(@NotNull Call call);
    }

    public void cacheConditionalHit(@NotNull Call call, @NotNull Response cachedResponse) {
        l.e(call, "call");
        l.e(cachedResponse, "cachedResponse");
    }

    public void cacheHit(@NotNull Call call, @NotNull Response response) {
        l.e(call, "call");
        l.e(response, "response");
    }

    public void cacheMiss(@NotNull Call call) {
        l.e(call, "call");
    }

    public void callEnd(@NotNull Call call) {
        l.e(call, "call");
    }

    public void callFailed(@NotNull Call call, @NotNull IOException ioe) {
        l.e(call, "call");
        l.e(ioe, "ioe");
    }

    public void callStart(@NotNull Call call) {
        l.e(call, "call");
    }

    public void canceled(@NotNull Call call) {
        l.e(call, "call");
    }

    public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol) {
        l.e(call, "call");
        l.e(inetSocketAddress, "inetSocketAddress");
        l.e(proxy, "proxy");
    }

    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol, @NotNull IOException ioe) {
        l.e(call, "call");
        l.e(inetSocketAddress, "inetSocketAddress");
        l.e(proxy, "proxy");
        l.e(ioe, "ioe");
    }

    public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        l.e(call, "call");
        l.e(inetSocketAddress, "inetSocketAddress");
        l.e(proxy, "proxy");
    }

    public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
        l.e(call, "call");
        l.e(connection, "connection");
    }

    public void connectionReleased(@NotNull Call call, @NotNull Connection connection) {
        l.e(call, "call");
        l.e(connection, "connection");
    }

    public void dnsEnd(@NotNull Call call, @NotNull String domainName, @NotNull List inetAddressList) {
        l.e(call, "call");
        l.e(domainName, "domainName");
        l.e(inetAddressList, "inetAddressList");
    }

    public void dnsStart(@NotNull Call call, @NotNull String domainName) {
        l.e(call, "call");
        l.e(domainName, "domainName");
    }

    public void proxySelectEnd(@NotNull Call call, @NotNull HttpUrl url, @NotNull List proxies) {
        l.e(call, "call");
        l.e(url, "url");
        l.e(proxies, "proxies");
    }

    public void proxySelectStart(@NotNull Call call, @NotNull HttpUrl url) {
        l.e(call, "call");
        l.e(url, "url");
    }

    public void requestBodyEnd(@NotNull Call call, long j) {
        l.e(call, "call");
    }

    public void requestBodyStart(@NotNull Call call) {
        l.e(call, "call");
    }

    public void requestFailed(@NotNull Call call, @NotNull IOException ioe) {
        l.e(call, "call");
        l.e(ioe, "ioe");
    }

    public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
        l.e(call, "call");
        l.e(request, "request");
    }

    public void requestHeadersStart(@NotNull Call call) {
        l.e(call, "call");
    }

    public void responseBodyEnd(@NotNull Call call, long j) {
        l.e(call, "call");
    }

    public void responseBodyStart(@NotNull Call call) {
        l.e(call, "call");
    }

    public void responseFailed(@NotNull Call call, @NotNull IOException ioe) {
        l.e(call, "call");
        l.e(ioe, "ioe");
    }

    public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
        l.e(call, "call");
        l.e(response, "response");
    }

    public void responseHeadersStart(@NotNull Call call) {
        l.e(call, "call");
    }

    public void satisfactionFailure(@NotNull Call call, @NotNull Response response) {
        l.e(call, "call");
        l.e(response, "response");
    }

    public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
        l.e(call, "call");
    }

    public void secureConnectStart(@NotNull Call call) {
        l.e(call, "call");
    }
}
