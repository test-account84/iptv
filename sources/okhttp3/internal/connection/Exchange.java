package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import kotlin.jvm.internal.l;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Exchange {

    @NotNull
    private final RealCall call;
    private final ExchangeCodec codec;

    @NotNull
    private final RealConnection connection;

    @NotNull
    private final EventListener eventListener;

    @NotNull
    private final ExchangeFinder finder;
    private boolean isDuplex;

    public final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(@NotNull Exchange exchange, Sink delegate, long j) {
            super(delegate);
            l.e(delegate, "delegate");
            this.this$0 = exchange;
            this.contentLength = j;
        }

        private final IOException complete(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            return this.this$0.bodyComplete(this.bytesReceived, false, true, iOException);
        }

        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public void write(@NotNull Buffer source, long j) throws IOException {
            l.e(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.contentLength;
            if (j2 == -1 || this.bytesReceived + j <= j2) {
                try {
                    super.write(source, j);
                    this.bytesReceived += j;
                    return;
                } catch (IOException e) {
                    throw complete(e);
                }
            }
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j));
        }
    }

    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(@NotNull Exchange exchange, Source delegate, long j) {
            super(delegate);
            l.e(delegate, "delegate");
            this.this$0 = exchange;
            this.contentLength = j;
            this.invokeStartEvent = true;
            if (j == 0) {
                complete(null);
            }
        }

        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public final IOException complete(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            if (iOException == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
            }
            return this.this$0.bodyComplete(this.bytesReceived, true, false, iOException);
        }

        public long read(@NotNull Buffer sink, long j) throws IOException {
            l.e(sink, "sink");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long read = delegate().read(sink, j);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                }
                if (read == -1) {
                    complete(null);
                    return -1L;
                }
                long j2 = this.bytesReceived + read;
                long j3 = this.contentLength;
                if (j3 != -1 && j2 > j3) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j2);
                }
                this.bytesReceived = j2;
                if (j2 == j3) {
                    complete(null);
                }
                return read;
            } catch (IOException e) {
                throw complete(e);
            }
        }
    }

    public Exchange(@NotNull RealCall call, @NotNull EventListener eventListener, @NotNull ExchangeFinder finder, @NotNull ExchangeCodec codec) {
        l.e(call, "call");
        l.e(eventListener, "eventListener");
        l.e(finder, "finder");
        l.e(codec, "codec");
        this.call = call;
        this.eventListener = eventListener;
        this.finder = finder;
        this.codec = codec;
        this.connection = codec.getConnection();
    }

    private final void trackFailure(IOException iOException) {
        this.finder.trackFailure(iOException);
        this.codec.getConnection().trackFailure$okhttp(this.call, iOException);
    }

    public final IOException bodyComplete(long j, boolean z, boolean z2, IOException iOException) {
        if (iOException != null) {
            trackFailure(iOException);
        }
        if (z2) {
            EventListener eventListener = this.eventListener;
            RealCall realCall = this.call;
            if (iOException != null) {
                eventListener.requestFailed(realCall, iOException);
            } else {
                eventListener.requestBodyEnd(realCall, j);
            }
        }
        if (z) {
            if (iOException != null) {
                this.eventListener.responseFailed(this.call, iOException);
            } else {
                this.eventListener.responseBodyEnd(this.call, j);
            }
        }
        return this.call.messageDone$okhttp(this, z2, z, iOException);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    @NotNull
    public final Sink createRequestBody(@NotNull Request request, boolean z) throws IOException {
        l.e(request, "request");
        this.isDuplex = z;
        RequestBody body = request.body();
        l.b(body);
        long contentLength = body.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request, contentLength), contentLength);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    @NotNull
    public final RealCall getCall$okhttp() {
        return this.call;
    }

    @NotNull
    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    @NotNull
    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    @NotNull
    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !l.a(this.finder.getAddress$okhttp().url().host(), this.connection.route().address().url().host());
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    @NotNull
    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    @NotNull
    public final ResponseBody openResponseBody(@NotNull Response response) throws IOException {
        l.e(response, "response");
        try {
            String header$default = Response.header$default(response, "Content-Type", null, 2, null);
            long reportedContentLength = this.codec.reportedContentLength(response);
            return new RealResponseBody(header$default, reportedContentLength, Okio.buffer(new ResponseBodySource(this, this.codec.openResponseBodySource(response), reportedContentLength)));
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    @Nullable
    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        try {
            Response.Builder readResponseHeaders = this.codec.readResponseHeaders(z);
            if (readResponseHeaders != null) {
                readResponseHeaders.initExchange$okhttp(this);
            }
            return readResponseHeaders;
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void responseHeadersEnd(@NotNull Response response) {
        l.e(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    @NotNull
    public final Headers trailers() throws IOException {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1L, true, true, null);
    }

    public final void writeRequestHeaders(@NotNull Request request) throws IOException {
        l.e(request, "request");
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }
}
