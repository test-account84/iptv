package okhttp3.internal.http1;

import E8.n;
import E8.o;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    public static final Companion Companion = new Companion(null);
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final OkHttpClient client;

    @NotNull
    private final RealConnection connection;
    private final HeadersReader headersReader;
    private final BufferedSink sink;
    private final BufferedSource source;
    private int state;
    private Headers trailers;

    public abstract class AbstractSource implements Source {
        private boolean closed;

        @NotNull
        private final ForwardingTimeout timeout;

        public AbstractSource() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSource$p(Http1ExchangeCodec.this).timeout());
        }

        public final boolean getClosed() {
            return this.closed;
        }

        @NotNull
        public final ForwardingTimeout getTimeout() {
            return this.timeout;
        }

        public long read(@NotNull Buffer sink, long j) {
            l.e(sink, "sink");
            try {
                return Http1ExchangeCodec.access$getSource$p(Http1ExchangeCodec.this).read(sink, j);
            } catch (IOException e) {
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
                throw e;
            }
        }

        public final void responseBodyComplete() {
            if (Http1ExchangeCodec.access$getState$p(Http1ExchangeCodec.this) == 6) {
                return;
            }
            if (Http1ExchangeCodec.access$getState$p(Http1ExchangeCodec.this) == 5) {
                Http1ExchangeCodec.access$detachTimeout(Http1ExchangeCodec.this, this.timeout);
                Http1ExchangeCodec.access$setState$p(Http1ExchangeCodec.this, 6);
            } else {
                throw new IllegalStateException("state: " + Http1ExchangeCodec.access$getState$p(Http1ExchangeCodec.this));
            }
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    public final class ChunkedSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout;

        public ChunkedSink() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSink$p(Http1ExchangeCodec.this).timeout());
        }

        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.access$getSink$p(Http1ExchangeCodec.this).writeUtf8("0\r\n\r\n");
            Http1ExchangeCodec.access$detachTimeout(Http1ExchangeCodec.this, this.timeout);
            Http1ExchangeCodec.access$setState$p(Http1ExchangeCodec.this, 3);
        }

        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.access$getSink$p(Http1ExchangeCodec.this).flush();
        }

        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        public void write(@NotNull Buffer source, long j) {
            l.e(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j == 0) {
                return;
            }
            Http1ExchangeCodec.access$getSink$p(Http1ExchangeCodec.this).writeHexadecimalUnsignedLong(j);
            Http1ExchangeCodec.access$getSink$p(Http1ExchangeCodec.this).writeUtf8("\r\n");
            Http1ExchangeCodec.access$getSink$p(Http1ExchangeCodec.this).write(source, j);
            Http1ExchangeCodec.access$getSink$p(Http1ExchangeCodec.this).writeUtf8("\r\n");
        }
    }

    public final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final HttpUrl url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(@NotNull Http1ExchangeCodec http1ExchangeCodec, HttpUrl url) {
            super();
            l.e(url, "url");
            this.this$0 = http1ExchangeCodec;
            this.url = url;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        private final void readChunkSize() {
            if (this.bytesRemainingInChunk != -1) {
                Http1ExchangeCodec.access$getSource$p(this.this$0).readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = Http1ExchangeCodec.access$getSource$p(this.this$0).readHexadecimalUnsignedLong();
                String readUtf8LineStrict = Http1ExchangeCodec.access$getSource$p(this.this$0).readUtf8LineStrict();
                if (readUtf8LineStrict == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String obj = o.D0(readUtf8LineStrict).toString();
                if (this.bytesRemainingInChunk < 0 || (obj.length() > 0 && !n.B(obj, ";", false, 2, null))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + obj + '\"');
                }
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    Http1ExchangeCodec http1ExchangeCodec = this.this$0;
                    Http1ExchangeCodec.access$setTrailers$p(http1ExchangeCodec, Http1ExchangeCodec.access$getHeadersReader$p(http1ExchangeCodec).readHeaders());
                    OkHttpClient access$getClient$p = Http1ExchangeCodec.access$getClient$p(this.this$0);
                    l.b(access$getClient$p);
                    CookieJar cookieJar = access$getClient$p.cookieJar();
                    HttpUrl httpUrl = this.url;
                    Headers access$getTrailers$p = Http1ExchangeCodec.access$getTrailers$p(this.this$0);
                    l.b(access$getTrailers$p);
                    HttpHeaders.receiveHeaders(cookieJar, httpUrl, access$getTrailers$p);
                    responseBodyComplete();
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
            }
            setClosed(true);
        }

        public long read(@NotNull Buffer sink, long j) {
            l.e(sink, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (!(true ^ getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j2 = this.bytesRemainingInChunk;
            if (j2 == 0 || j2 == -1) {
                readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long read = super.read(sink, Math.min(j, this.bytesRemainingInChunk));
            if (read != -1) {
                this.bytesRemainingInChunk -= read;
                return read;
            }
            this.this$0.getConnection().noNewExchanges$okhttp();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            responseBodyComplete();
            throw protocolException;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j) {
            super();
            this.bytesRemaining = j;
            if (j == 0) {
                responseBodyComplete();
            }
        }

        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
            }
            setClosed(true);
        }

        public long read(@NotNull Buffer sink, long j) {
            l.e(sink, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (!(true ^ getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.bytesRemaining;
            if (j2 == 0) {
                return -1L;
            }
            long read = super.read(sink, Math.min(j2, j));
            if (read == -1) {
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete();
                throw protocolException;
            }
            long j3 = this.bytesRemaining - read;
            this.bytesRemaining = j3;
            if (j3 == 0) {
                responseBodyComplete();
            }
            return read;
        }
    }

    public final class KnownLengthSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout;

        public KnownLengthSink() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSink$p(Http1ExchangeCodec.this).timeout());
        }

        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.access$detachTimeout(Http1ExchangeCodec.this, this.timeout);
            Http1ExchangeCodec.access$setState$p(Http1ExchangeCodec.this, 3);
        }

        public void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.access$getSink$p(Http1ExchangeCodec.this).flush();
        }

        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        public void write(@NotNull Buffer source, long j) {
            l.e(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Util.checkOffsetAndCount(source.size(), 0L, j);
            Http1ExchangeCodec.access$getSink$p(Http1ExchangeCodec.this).write(source, j);
        }
    }

    public final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        public UnknownLengthSource() {
            super();
        }

        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete();
            }
            setClosed(true);
        }

        public long read(@NotNull Buffer sink, long j) {
            l.e(sink, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (!(!getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long read = super.read(sink, j);
            if (read != -1) {
                return read;
            }
            this.inputExhausted = true;
            responseBodyComplete();
            return -1L;
        }
    }

    public Http1ExchangeCodec(@Nullable OkHttpClient okHttpClient, @NotNull RealConnection connection, @NotNull BufferedSource source, @NotNull BufferedSink sink) {
        l.e(connection, "connection");
        l.e(source, "source");
        l.e(sink, "sink");
        this.client = okHttpClient;
        this.connection = connection;
        this.source = source;
        this.sink = sink;
        this.headersReader = new HeadersReader(source);
    }

    public static final /* synthetic */ void access$detachTimeout(Http1ExchangeCodec http1ExchangeCodec, ForwardingTimeout forwardingTimeout) {
        http1ExchangeCodec.detachTimeout(forwardingTimeout);
    }

    public static final /* synthetic */ OkHttpClient access$getClient$p(Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.client;
    }

    public static final /* synthetic */ HeadersReader access$getHeadersReader$p(Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.headersReader;
    }

    public static final /* synthetic */ BufferedSink access$getSink$p(Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.sink;
    }

    public static final /* synthetic */ BufferedSource access$getSource$p(Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.source;
    }

    public static final /* synthetic */ int access$getState$p(Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.state;
    }

    public static final /* synthetic */ Headers access$getTrailers$p(Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.trailers;
    }

    public static final /* synthetic */ void access$setState$p(Http1ExchangeCodec http1ExchangeCodec, int i) {
        http1ExchangeCodec.state = i;
    }

    public static final /* synthetic */ void access$setTrailers$p(Http1ExchangeCodec http1ExchangeCodec, Headers headers) {
        http1ExchangeCodec.trailers = headers;
    }

    private final void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    private final boolean isChunked(Request request) {
        return n.o("chunked", request.header("Transfer-Encoding"), true);
    }

    private final Sink newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Source newChunkedSource(HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(this, httpUrl);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Source newFixedLengthSource(long j) {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Sink newKnownLengthSink() {
        if (this.state == 1) {
            this.state = 2;
            return new KnownLengthSink();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Source newUnknownLengthSource() {
        if (this.state == 4) {
            this.state = 5;
            getConnection().noNewExchanges$okhttp();
            return new UnknownLengthSource();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    public void cancel() {
        getConnection().cancel();
    }

    @NotNull
    public Sink createRequestBody(@NotNull Request request, long j) {
        l.e(request, "request");
        if (request.body() != null && request.body().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (isChunked(request)) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newKnownLengthSink();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void finishRequest() {
        this.sink.flush();
    }

    public void flushRequest() {
        this.sink.flush();
    }

    @NotNull
    public RealConnection getConnection() {
        return this.connection;
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    @NotNull
    public Source openResponseBodySource(@NotNull Response response) {
        long headersContentLength;
        l.e(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            headersContentLength = 0;
        } else {
            if (isChunked(response)) {
                return newChunkedSource(response.request().url());
            }
            headersContentLength = Util.headersContentLength(response);
            if (headersContentLength == -1) {
                return newUnknownLengthSource();
            }
        }
        return newFixedLengthSource(headersContentLength);
    }

    @Nullable
    public Response.Builder readResponseHeaders(boolean z) {
        int i = this.state;
        boolean z2 = true;
        if (i != 1 && i != 3) {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        try {
            StatusLine parse = StatusLine.Companion.parse(this.headersReader.readLine());
            Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(this.headersReader.readHeaders());
            if (z && parse.code == 100) {
                return null;
            }
            if (parse.code == 100) {
                this.state = 3;
                return headers;
            }
            this.state = 4;
            return headers;
        } catch (EOFException e) {
            throw new IOException("unexpected end of stream on " + getConnection().route().address().url().redact(), e);
        }
    }

    public long reportedContentLength(@NotNull Response response) {
        l.e(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        if (isChunked(response)) {
            return -1L;
        }
        return Util.headersContentLength(response);
    }

    public final void skipConnectBody(@NotNull Response response) {
        l.e(response, "response");
        long headersContentLength = Util.headersContentLength(response);
        if (headersContentLength == -1) {
            return;
        }
        Source newFixedLengthSource = newFixedLengthSource(headersContentLength);
        Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        newFixedLengthSource.close();
    }

    @NotNull
    public Headers trailers() {
        if (!(this.state == 6)) {
            throw new IllegalStateException("too early; can't read the trailers yet".toString());
        }
        Headers headers = this.trailers;
        return headers != null ? headers : Util.EMPTY_HEADERS;
    }

    public final void writeRequest(@NotNull Headers headers, @NotNull String requestLine) {
        l.e(headers, "headers");
        l.e(requestLine, "requestLine");
        if (!(this.state == 0)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.sink.writeUtf8(requestLine).writeUtf8("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.sink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
        }
        this.sink.writeUtf8("\r\n");
        this.state = 1;
    }

    public void writeRequestHeaders(@NotNull Request request) {
        l.e(request, "request");
        RequestLine requestLine = RequestLine.INSTANCE;
        Proxy.Type type = getConnection().route().proxy().type();
        l.d(type, "connection.route().proxy.type()");
        writeRequest(request.headers(), requestLine.get(request, type));
    }

    private final boolean isChunked(Response response) {
        return n.o("chunked", Response.header$default(response, "Transfer-Encoding", null, 2, null), true);
    }
}
