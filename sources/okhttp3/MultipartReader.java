package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.http1.HeadersReader;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class MultipartReader implements Closeable {
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Options afterBoundaryOptions;

    @NotNull
    private final String boundary;
    private boolean closed;
    private final ByteString crlfDashDashBoundary;
    private PartSource currentPart;
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final BufferedSource source;

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Options getAfterBoundaryOptions() {
            return MultipartReader.access$getAfterBoundaryOptions$cp();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final class Part implements Closeable {

        @NotNull
        private final BufferedSource body;

        @NotNull
        private final Headers headers;

        public Part(@NotNull Headers headers, @NotNull BufferedSource body) {
            l.e(headers, "headers");
            l.e(body, "body");
            this.headers = headers;
            this.body = body;
        }

        @NotNull
        public final BufferedSource body() {
            return this.body;
        }

        public void close() {
            this.body.close();
        }

        @NotNull
        public final Headers headers() {
            return this.headers;
        }
    }

    public final class PartSource implements Source {
        private final Timeout timeout = new Timeout();

        public PartSource() {
        }

        public void close() {
            if (l.a(MultipartReader.access$getCurrentPart$p(MultipartReader.this), this)) {
                MultipartReader.access$setCurrentPart$p(MultipartReader.this, null);
            }
        }

        public long read(@NotNull Buffer sink, long j) {
            l.e(sink, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (!l.a(MultipartReader.access$getCurrentPart$p(MultipartReader.this), this)) {
                throw new IllegalStateException("closed".toString());
            }
            Timeout timeout = MultipartReader.access$getSource$p(MultipartReader.this).timeout();
            Timeout timeout2 = this.timeout;
            long timeoutNanos = timeout.timeoutNanos();
            long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            timeout.timeout(minTimeout, timeUnit);
            if (!timeout.hasDeadline()) {
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                }
                try {
                    long access$currentPartBytesRemaining = MultipartReader.access$currentPartBytesRemaining(MultipartReader.this, j);
                    long read = access$currentPartBytesRemaining == 0 ? -1L : MultipartReader.access$getSource$p(MultipartReader.this).read(sink, access$currentPartBytesRemaining);
                    timeout.timeout(timeoutNanos, timeUnit);
                    if (timeout2.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                    return read;
                } catch (Throwable th) {
                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout2.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                    throw th;
                }
            }
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                long access$currentPartBytesRemaining2 = MultipartReader.access$currentPartBytesRemaining(MultipartReader.this, j);
                long read2 = access$currentPartBytesRemaining2 == 0 ? -1L : MultipartReader.access$getSource$p(MultipartReader.this).read(sink, access$currentPartBytesRemaining2);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                return read2;
            } catch (Throwable th2) {
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                throw th2;
            }
        }

        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        afterBoundaryOptions = companion.of(companion2.encodeUtf8("\r\n"), companion2.encodeUtf8("--"), companion2.encodeUtf8(" "), companion2.encodeUtf8("\t"));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MultipartReader(@NotNull ResponseBody response) throws IOException {
        String parameter;
        l.e(response, "response");
        BufferedSource source = response.source();
        MediaType contentType = response.contentType();
        if (contentType == null || (parameter = contentType.parameter("boundary")) == null) {
            throw new ProtocolException("expected the Content-Type to have a boundary parameter");
        }
        this(source, parameter);
    }

    public static final /* synthetic */ long access$currentPartBytesRemaining(MultipartReader multipartReader, long j) {
        return multipartReader.currentPartBytesRemaining(j);
    }

    public static final /* synthetic */ Options access$getAfterBoundaryOptions$cp() {
        return afterBoundaryOptions;
    }

    public static final /* synthetic */ PartSource access$getCurrentPart$p(MultipartReader multipartReader) {
        return multipartReader.currentPart;
    }

    public static final /* synthetic */ BufferedSource access$getSource$p(MultipartReader multipartReader) {
        return multipartReader.source;
    }

    public static final /* synthetic */ void access$setCurrentPart$p(MultipartReader multipartReader, PartSource partSource) {
        multipartReader.currentPart = partSource;
    }

    private final long currentPartBytesRemaining(long j) {
        this.source.require(this.crlfDashDashBoundary.size());
        long indexOf = this.source.getBuffer().indexOf(this.crlfDashDashBoundary);
        if (indexOf == -1) {
            indexOf = (this.source.getBuffer().size() - this.crlfDashDashBoundary.size()) + 1;
        }
        return Math.min(j, indexOf);
    }

    @NotNull
    public final String boundary() {
        return this.boundary;
    }

    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    @Nullable
    public final Part nextPart() throws IOException {
        BufferedSource bufferedSource;
        ByteString byteString;
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.noMoreParts) {
            return null;
        }
        if (this.partCount == 0 && this.source.rangeEquals(0L, this.dashDashBoundary)) {
            bufferedSource = this.source;
            byteString = this.dashDashBoundary;
        } else {
            while (true) {
                long currentPartBytesRemaining = currentPartBytesRemaining(8192L);
                if (currentPartBytesRemaining == 0) {
                    break;
                }
                this.source.skip(currentPartBytesRemaining);
            }
            bufferedSource = this.source;
            byteString = this.crlfDashDashBoundary;
        }
        bufferedSource.skip(byteString.size());
        boolean z = false;
        while (true) {
            int select = this.source.select(afterBoundaryOptions);
            if (select == -1) {
                throw new ProtocolException("unexpected characters after boundary");
            }
            if (select == 0) {
                this.partCount++;
                Headers readHeaders = new HeadersReader(this.source).readHeaders();
                PartSource partSource = new PartSource();
                this.currentPart = partSource;
                return new Part(readHeaders, Okio.buffer(partSource));
            }
            if (select == 1) {
                if (z) {
                    throw new ProtocolException("unexpected characters after boundary");
                }
                if (this.partCount == 0) {
                    throw new ProtocolException("expected at least 1 part");
                }
                this.noMoreParts = true;
                return null;
            }
            if (select == 2 || select == 3) {
                z = true;
            }
        }
    }

    public MultipartReader(@NotNull BufferedSource source, @NotNull String boundary) throws IOException {
        l.e(source, "source");
        l.e(boundary, "boundary");
        this.source = source;
        this.boundary = boundary;
        this.dashDashBoundary = new Buffer().writeUtf8("--").writeUtf8(boundary).readByteString();
        this.crlfDashDashBoundary = new Buffer().writeUtf8("\r\n--").writeUtf8(boundary).readByteString();
    }
}
