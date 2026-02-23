package okhttp3.logging;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class LoggingEventListener extends EventListener {
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    public static class Factory implements EventListener.Factory {
        private final HttpLoggingInterceptor.Logger logger;

        public Factory() {
            this(null, 1, null);
        }

        @NotNull
        public EventListener create(@NotNull Call call) {
            l.e(call, "call");
            return new LoggingEventListener(this.logger, null);
        }

        public Factory(@NotNull HttpLoggingInterceptor.Logger logger) {
            l.e(logger, "logger");
            this.logger = logger;
        }

        public /* synthetic */ Factory(HttpLoggingInterceptor.Logger logger, int i, g gVar) {
            this((i & 1) != 0 ? HttpLoggingInterceptor.Logger.DEFAULT : logger);
        }
    }

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger) {
        this.logger = logger;
    }

    private final void logWithTime(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        this.logger.log('[' + millis + " ms] " + str);
    }

    public void cacheConditionalHit(@NotNull Call call, @NotNull Response cachedResponse) {
        l.e(call, "call");
        l.e(cachedResponse, "cachedResponse");
        logWithTime("cacheConditionalHit: " + cachedResponse);
    }

    public void cacheHit(@NotNull Call call, @NotNull Response response) {
        l.e(call, "call");
        l.e(response, "response");
        logWithTime("cacheHit: " + response);
    }

    public void cacheMiss(@NotNull Call call) {
        l.e(call, "call");
        logWithTime("cacheMiss");
    }

    public void callEnd(@NotNull Call call) {
        l.e(call, "call");
        logWithTime("callEnd");
    }

    public void callFailed(@NotNull Call call, @NotNull IOException ioe) {
        l.e(call, "call");
        l.e(ioe, "ioe");
        logWithTime("callFailed: " + ioe);
    }

    public void callStart(@NotNull Call call) {
        l.e(call, "call");
        this.startNs = System.nanoTime();
        logWithTime("callStart: " + call.request());
    }

    public void canceled(@NotNull Call call) {
        l.e(call, "call");
        logWithTime("canceled");
    }

    public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol) {
        l.e(call, "call");
        l.e(inetSocketAddress, "inetSocketAddress");
        l.e(proxy, "proxy");
        logWithTime("connectEnd: " + protocol);
    }

    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol, @NotNull IOException ioe) {
        l.e(call, "call");
        l.e(inetSocketAddress, "inetSocketAddress");
        l.e(proxy, "proxy");
        l.e(ioe, "ioe");
        logWithTime("connectFailed: " + protocol + ' ' + ioe);
    }

    public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        l.e(call, "call");
        l.e(inetSocketAddress, "inetSocketAddress");
        l.e(proxy, "proxy");
        logWithTime("connectStart: " + inetSocketAddress + ' ' + proxy);
    }

    public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
        l.e(call, "call");
        l.e(connection, "connection");
        logWithTime("connectionAcquired: " + connection);
    }

    public void connectionReleased(@NotNull Call call, @NotNull Connection connection) {
        l.e(call, "call");
        l.e(connection, "connection");
        logWithTime("connectionReleased");
    }

    public void dnsEnd(@NotNull Call call, @NotNull String domainName, @NotNull List inetAddressList) {
        l.e(call, "call");
        l.e(domainName, "domainName");
        l.e(inetAddressList, "inetAddressList");
        logWithTime("dnsEnd: " + inetAddressList);
    }

    public void dnsStart(@NotNull Call call, @NotNull String domainName) {
        l.e(call, "call");
        l.e(domainName, "domainName");
        logWithTime("dnsStart: " + domainName);
    }

    public void proxySelectEnd(@NotNull Call call, @NotNull HttpUrl url, @NotNull List proxies) {
        l.e(call, "call");
        l.e(url, "url");
        l.e(proxies, "proxies");
        logWithTime("proxySelectEnd: " + proxies);
    }

    public void proxySelectStart(@NotNull Call call, @NotNull HttpUrl url) {
        l.e(call, "call");
        l.e(url, "url");
        logWithTime("proxySelectStart: " + url);
    }

    public void requestBodyEnd(@NotNull Call call, long j) {
        l.e(call, "call");
        logWithTime("requestBodyEnd: byteCount=" + j);
    }

    public void requestBodyStart(@NotNull Call call) {
        l.e(call, "call");
        logWithTime("requestBodyStart");
    }

    public void requestFailed(@NotNull Call call, @NotNull IOException ioe) {
        l.e(call, "call");
        l.e(ioe, "ioe");
        logWithTime("requestFailed: " + ioe);
    }

    public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
        l.e(call, "call");
        l.e(request, "request");
        logWithTime("requestHeadersEnd");
    }

    public void requestHeadersStart(@NotNull Call call) {
        l.e(call, "call");
        logWithTime("requestHeadersStart");
    }

    public void responseBodyEnd(@NotNull Call call, long j) {
        l.e(call, "call");
        logWithTime("responseBodyEnd: byteCount=" + j);
    }

    public void responseBodyStart(@NotNull Call call) {
        l.e(call, "call");
        logWithTime("responseBodyStart");
    }

    public void responseFailed(@NotNull Call call, @NotNull IOException ioe) {
        l.e(call, "call");
        l.e(ioe, "ioe");
        logWithTime("responseFailed: " + ioe);
    }

    public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
        l.e(call, "call");
        l.e(response, "response");
        logWithTime("responseHeadersEnd: " + response);
    }

    public void responseHeadersStart(@NotNull Call call) {
        l.e(call, "call");
        logWithTime("responseHeadersStart");
    }

    public void satisfactionFailure(@NotNull Call call, @NotNull Response response) {
        l.e(call, "call");
        l.e(response, "response");
        logWithTime("satisfactionFailure: " + response);
    }

    public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
        l.e(call, "call");
        logWithTime("secureConnectEnd: " + handshake);
    }

    public void secureConnectStart(@NotNull Call call) {
        l.e(call, "call");
        logWithTime("secureConnectStart");
    }

    public /* synthetic */ LoggingEventListener(HttpLoggingInterceptor.Logger logger, g gVar) {
        this(logger);
    }
}
