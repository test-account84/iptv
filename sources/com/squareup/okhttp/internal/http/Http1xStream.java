package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Http1xStream implements HttpStream {
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private HttpEngine httpEngine;
    private final BufferedSink sink;
    private final BufferedSource source;
    private int state = 0;
    private final StreamAllocation streamAllocation;

    public abstract class AbstractSource implements Source {
        protected boolean closed;
        protected final ForwardingTimeout timeout;

        private AbstractSource() {
            this.timeout = new ForwardingTimeout(Http1xStream.access$600(Http1xStream.this).timeout());
        }

        public final void endOfInput() throws IOException {
            if (Http1xStream.access$500(Http1xStream.this) != 5) {
                throw new IllegalStateException("state: " + Http1xStream.access$500(Http1xStream.this));
            }
            Http1xStream.access$400(Http1xStream.this, this.timeout);
            Http1xStream.access$502(Http1xStream.this, 6);
            if (Http1xStream.access$700(Http1xStream.this) != null) {
                Http1xStream.access$700(Http1xStream.this).streamFinished(Http1xStream.this);
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public final void unexpectedEndOfInput() {
            if (Http1xStream.access$500(Http1xStream.this) == 6) {
                return;
            }
            Http1xStream.access$502(Http1xStream.this, 6);
            if (Http1xStream.access$700(Http1xStream.this) != null) {
                Http1xStream.access$700(Http1xStream.this).noNewStreams();
                Http1xStream.access$700(Http1xStream.this).streamFinished(Http1xStream.this);
            }
        }

        public /* synthetic */ AbstractSource(Http1xStream http1xStream, 1 r2) {
            this();
        }
    }

    public final class ChunkedSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout;

        private ChunkedSink() {
            this.timeout = new ForwardingTimeout(Http1xStream.access$300(Http1xStream.this).timeout());
        }

        public synchronized void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1xStream.access$300(Http1xStream.this).writeUtf8("0\r\n\r\n");
            Http1xStream.access$400(Http1xStream.this, this.timeout);
            Http1xStream.access$502(Http1xStream.this, 3);
        }

        public synchronized void flush() throws IOException {
            if (this.closed) {
                return;
            }
            Http1xStream.access$300(Http1xStream.this).flush();
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            Http1xStream.access$300(Http1xStream.this).writeHexadecimalUnsignedLong(j);
            Http1xStream.access$300(Http1xStream.this).writeUtf8("\r\n");
            Http1xStream.access$300(Http1xStream.this).write(buffer, j);
            Http1xStream.access$300(Http1xStream.this).writeUtf8("\r\n");
        }

        public /* synthetic */ ChunkedSink(Http1xStream http1xStream, 1 r2) {
            this();
        }
    }

    public class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpEngine httpEngine;

        public ChunkedSource(HttpEngine httpEngine) throws IOException {
            super(Http1xStream.this, null);
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
            this.httpEngine = httpEngine;
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Http1xStream.access$600(Http1xStream.this).readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = Http1xStream.access$600(Http1xStream.this).readHexadecimalUnsignedLong();
                String trim = Http1xStream.access$600(Http1xStream.this).readUtf8LineStrict().trim();
                if (this.bytesRemainingInChunk < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + "\"");
                }
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    this.httpEngine.receiveHeaders(Http1xStream.this.readHeaders());
                    endOfInput();
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                unexpectedEndOfInput();
            }
            this.closed = true;
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
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
            long read = Http1xStream.access$600(Http1xStream.this).read(buffer, Math.min(j, this.bytesRemainingInChunk));
            if (read != -1) {
                this.bytesRemainingInChunk -= read;
                return read;
            }
            unexpectedEndOfInput();
            throw new ProtocolException("unexpected end of stream");
        }
    }

    public final class FixedLengthSink implements Sink {
        private long bytesRemaining;
        private boolean closed;
        private final ForwardingTimeout timeout;

        private FixedLengthSink(long j) {
            this.timeout = new ForwardingTimeout(Http1xStream.access$300(Http1xStream.this).timeout());
            this.bytesRemaining = j;
        }

        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.bytesRemaining > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            Http1xStream.access$400(Http1xStream.this, this.timeout);
            Http1xStream.access$502(Http1xStream.this, 3);
        }

        public void flush() throws IOException {
            if (this.closed) {
                return;
            }
            Http1xStream.access$300(Http1xStream.this).flush();
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(buffer.size(), 0L, j);
            if (j <= this.bytesRemaining) {
                Http1xStream.access$300(Http1xStream.this).write(buffer, j);
                this.bytesRemaining -= j;
                return;
            }
            throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j);
        }

        public /* synthetic */ FixedLengthSink(Http1xStream http1xStream, long j, 1 r4) {
            this(j);
        }
    }

    public class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j) throws IOException {
            super(Http1xStream.this, null);
            this.bytesRemaining = j;
            if (j == 0) {
                endOfInput();
            }
        }

        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                unexpectedEndOfInput();
            }
            this.closed = true;
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (this.bytesRemaining == 0) {
                return -1L;
            }
            long read = Http1xStream.access$600(Http1xStream.this).read(buffer, Math.min(this.bytesRemaining, j));
            if (read == -1) {
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
            long j2 = this.bytesRemaining - read;
            this.bytesRemaining = j2;
            if (j2 == 0) {
                endOfInput();
            }
            return read;
        }
    }

    public class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        private UnknownLengthSource() {
            super(Http1xStream.this, null);
        }

        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                unexpectedEndOfInput();
            }
            this.closed = true;
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long read = Http1xStream.access$600(Http1xStream.this).read(buffer, j);
            if (read != -1) {
                return read;
            }
            this.inputExhausted = true;
            endOfInput();
            return -1L;
        }

        public /* synthetic */ UnknownLengthSource(Http1xStream http1xStream, 1 r2) {
            this();
        }
    }

    public Http1xStream(StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.streamAllocation = streamAllocation;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    public static /* synthetic */ BufferedSink access$300(Http1xStream http1xStream) {
        return http1xStream.sink;
    }

    public static /* synthetic */ void access$400(Http1xStream http1xStream, ForwardingTimeout forwardingTimeout) {
        http1xStream.detachTimeout(forwardingTimeout);
    }

    public static /* synthetic */ int access$500(Http1xStream http1xStream) {
        return http1xStream.state;
    }

    public static /* synthetic */ int access$502(Http1xStream http1xStream, int i) {
        http1xStream.state = i;
        return i;
    }

    public static /* synthetic */ BufferedSource access$600(Http1xStream http1xStream) {
        return http1xStream.source;
    }

    public static /* synthetic */ StreamAllocation access$700(Http1xStream http1xStream) {
        return http1xStream.streamAllocation;
    }

    private void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    private Source getTransferStream(Response response) throws IOException {
        if (!HttpEngine.hasBody(response)) {
            return newFixedLengthSource(0L);
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return newChunkedSource(this.httpEngine);
        }
        long contentLength = OkHeaders.contentLength(response);
        return contentLength != -1 ? newFixedLengthSource(contentLength) : newUnknownLengthSource();
    }

    public void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public Sink createRequestBody(Request request, long j) throws IOException {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    public Sink newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink(this, null);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newChunkedSource(HttpEngine httpEngine) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(httpEngine);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Sink newFixedLengthSink(long j) {
        if (this.state == 1) {
            this.state = 2;
            return new FixedLengthSink(this, j, null);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newFixedLengthSource(long j) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.state = 5;
        streamAllocation.noNewStreams();
        return new UnknownLengthSource(this, null);
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), Okio.buffer(getTransferStream(response)));
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readUtf8LineStrict = this.source.readUtf8LineStrict();
            if (readUtf8LineStrict.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, readUtf8LineStrict);
        }
    }

    public Response.Builder readResponse() throws IOException {
        StatusLine parse;
        Response.Builder headers;
        int i = this.state;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.state);
        }
        do {
            try {
                parse = StatusLine.parse(this.source.readUtf8LineStrict());
                headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
            } catch (EOFException e) {
                IOException iOException = new IOException("unexpected end of stream on " + this.streamAllocation);
                iOException.initCause(e);
                throw iOException;
            }
        } while (parse.code == 100);
        this.state = 4;
        return headers;
    }

    public Response.Builder readResponseHeaders() throws IOException {
        return readResponse();
    }

    public void setHttpEngine(HttpEngine httpEngine) {
        this.httpEngine = httpEngine;
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.state != 0) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.sink.writeUtf8(str).writeUtf8("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.sink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
        }
        this.sink.writeUtf8("\r\n");
        this.state = 1;
    }

    public void writeRequestBody(RetryableSink retryableSink) throws IOException {
        if (this.state == 1) {
            this.state = 3;
            retryableSink.writeToSocket(this.sink);
        } else {
            throw new IllegalStateException("state: " + this.state);
        }
    }

    public void writeRequestHeaders(Request request) throws IOException {
        this.httpEngine.writingRequestHeaders();
        writeRequest(request.headers(), RequestLine.get(request, this.httpEngine.getConnection().getRoute().getProxy().type()));
    }
}
