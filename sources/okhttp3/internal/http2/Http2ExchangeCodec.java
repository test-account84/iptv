package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {
    private static final String CONNECTION = "connection";
    private static final String ENCODING = "encoding";
    private static final String HOST = "host";
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String UPGRADE = "upgrade";
    private volatile boolean canceled;
    private final RealInterceptorChain chain;

    @NotNull
    private final RealConnection connection;
    private final Http2Connection http2Connection;
    private final Protocol protocol;
    private volatile Http2Stream stream;
    public static final Companion Companion = new Companion(null);
    private static final List HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    private static final List HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final List http2HeadersList(@NotNull Request request) {
            l.e(request, "request");
            Headers headers = request.headers();
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
            arrayList.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(request.url())));
            String header = request.header("Host");
            if (header != null) {
                arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
            }
            arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                Locale locale = Locale.US;
                l.d(locale, "Locale.US");
                if (name == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = name.toLowerCase(locale);
                l.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!Http2ExchangeCodec.access$getHTTP_2_SKIPPED_REQUEST_HEADERS$cp().contains(lowerCase) || (l.a(lowerCase, "te") && l.a(headers.value(i), "trailers"))) {
                    arrayList.add(new Header(lowerCase, headers.value(i)));
                }
            }
            return arrayList;
        }

        @NotNull
        public final Response.Builder readHttp2HeadersList(@NotNull Headers headerBlock, @NotNull Protocol protocol) {
            l.e(headerBlock, "headerBlock");
            l.e(protocol, "protocol");
            Headers.Builder builder = new Headers.Builder();
            int size = headerBlock.size();
            StatusLine statusLine = null;
            for (int i = 0; i < size; i++) {
                String name = headerBlock.name(i);
                String value = headerBlock.value(i);
                if (l.a(name, ":status")) {
                    statusLine = StatusLine.Companion.parse("HTTP/1.1 " + value);
                } else if (!Http2ExchangeCodec.access$getHTTP_2_SKIPPED_RESPONSE_HEADERS$cp().contains(name)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            if (statusLine != null) {
                return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public Http2ExchangeCodec(@NotNull OkHttpClient client, @NotNull RealConnection connection, @NotNull RealInterceptorChain chain, @NotNull Http2Connection http2Connection) {
        l.e(client, "client");
        l.e(connection, "connection");
        l.e(chain, "chain");
        l.e(http2Connection, "http2Connection");
        this.connection = connection;
        this.chain = chain;
        this.http2Connection = http2Connection;
        List protocols = client.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = protocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    public static final /* synthetic */ List access$getHTTP_2_SKIPPED_REQUEST_HEADERS$cp() {
        return HTTP_2_SKIPPED_REQUEST_HEADERS;
    }

    public static final /* synthetic */ List access$getHTTP_2_SKIPPED_RESPONSE_HEADERS$cp() {
        return HTTP_2_SKIPPED_RESPONSE_HEADERS;
    }

    public void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @NotNull
    public Sink createRequestBody(@NotNull Request request, long j) {
        l.e(request, "request");
        Http2Stream http2Stream = this.stream;
        l.b(http2Stream);
        return http2Stream.getSink();
    }

    public void finishRequest() {
        Http2Stream http2Stream = this.stream;
        l.b(http2Stream);
        http2Stream.getSink().close();
    }

    public void flushRequest() {
        this.http2Connection.flush();
    }

    @NotNull
    public RealConnection getConnection() {
        return this.connection;
    }

    @NotNull
    public Source openResponseBodySource(@NotNull Response response) {
        l.e(response, "response");
        Http2Stream http2Stream = this.stream;
        l.b(http2Stream);
        return http2Stream.getSource$okhttp();
    }

    @Nullable
    public Response.Builder readResponseHeaders(boolean z) {
        Http2Stream http2Stream = this.stream;
        l.b(http2Stream);
        Response.Builder readHttp2HeadersList = Companion.readHttp2HeadersList(http2Stream.takeHeaders(), this.protocol);
        if (z && readHttp2HeadersList.getCode$okhttp() == 100) {
            return null;
        }
        return readHttp2HeadersList;
    }

    public long reportedContentLength(@NotNull Response response) {
        l.e(response, "response");
        if (HttpHeaders.promisesBody(response)) {
            return Util.headersContentLength(response);
        }
        return 0L;
    }

    @NotNull
    public Headers trailers() {
        Http2Stream http2Stream = this.stream;
        l.b(http2Stream);
        return http2Stream.trailers();
    }

    public void writeRequestHeaders(@NotNull Request request) {
        l.e(request, "request");
        if (this.stream != null) {
            return;
        }
        this.stream = this.http2Connection.newStream(Companion.http2HeadersList(request), request.body() != null);
        if (this.canceled) {
            Http2Stream http2Stream = this.stream;
            l.b(http2Stream);
            http2Stream.closeLater(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        Http2Stream http2Stream2 = this.stream;
        l.b(http2Stream2);
        Timeout readTimeout = http2Stream2.readTimeout();
        long readTimeoutMillis$okhttp = this.chain.getReadTimeoutMillis$okhttp();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        readTimeout.timeout(readTimeoutMillis$okhttp, timeUnit);
        Http2Stream http2Stream3 = this.stream;
        l.b(http2Stream3);
        http2Stream3.writeTimeout().timeout(this.chain.getWriteTimeoutMillis$okhttp(), timeUnit);
    }
}
