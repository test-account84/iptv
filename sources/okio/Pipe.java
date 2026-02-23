package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import k8.q;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Pipe {

    @NotNull
    private final Buffer buffer = new Buffer();
    private boolean canceled;

    @Nullable
    private Sink foldedSink;
    private final long maxBufferSize;

    @NotNull
    private final Sink sink;
    private boolean sinkClosed;

    @NotNull
    private final Source source;
    private boolean sourceClosed;

    public static final class 1 implements Sink {
        private final Timeout timeout = new Timeout();

        public 1() {
        }

        public void close() {
            synchronized (Pipe.this.getBuffer$okio()) {
                try {
                    if (Pipe.this.getSinkClosed$okio()) {
                        return;
                    }
                    Sink foldedSink$okio = Pipe.this.getFoldedSink$okio();
                    if (foldedSink$okio == null) {
                        if (Pipe.this.getSourceClosed$okio() && Pipe.this.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        Pipe.this.setSinkClosed$okio(true);
                        Buffer buffer$okio = Pipe.this.getBuffer$okio();
                        if (buffer$okio == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        buffer$okio.notifyAll();
                        foldedSink$okio = null;
                    }
                    q qVar = q.a;
                    if (foldedSink$okio != null) {
                        Pipe pipe = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe.sink().timeout();
                        long timeoutNanos = timeout.timeoutNanos();
                        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(minTimeout, timeUnit);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.close();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                    return;
                                }
                                return;
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
                            foldedSink$okio.close();
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                        } catch (Throwable th2) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        public void flush() {
            Sink foldedSink$okio;
            synchronized (Pipe.this.getBuffer$okio()) {
                try {
                    if (!(!Pipe.this.getSinkClosed$okio())) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (Pipe.this.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    foldedSink$okio = Pipe.this.getFoldedSink$okio();
                    if (foldedSink$okio == null) {
                        if (Pipe.this.getSourceClosed$okio() && Pipe.this.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        foldedSink$okio = null;
                    }
                    q qVar = q.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (foldedSink$okio != null) {
                Pipe pipe = Pipe.this;
                Timeout timeout = foldedSink$okio.timeout();
                Timeout timeout2 = pipe.sink().timeout();
                long timeoutNanos = timeout.timeoutNanos();
                long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                timeout.timeout(minTimeout, timeUnit);
                if (!timeout.hasDeadline()) {
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                    }
                    try {
                        foldedSink$okio.flush();
                        timeout.timeout(timeoutNanos, timeUnit);
                        if (timeout2.hasDeadline()) {
                            timeout.clearDeadline();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.hasDeadline()) {
                            timeout.clearDeadline();
                        }
                        throw th2;
                    }
                }
                long deadlineNanoTime = timeout.deadlineNanoTime();
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                }
                try {
                    foldedSink$okio.flush();
                    timeout.timeout(timeoutNanos, timeUnit);
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(deadlineNanoTime);
                    }
                } catch (Throwable th3) {
                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(deadlineNanoTime);
                    }
                    throw th3;
                }
            }
        }

        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x0094, code lost:
        
            r1 = k8.q.a;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void write(@org.jetbrains.annotations.NotNull okio.Buffer r13, long r14) {
            /*
                Method dump skipped, instructions count: 321
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Pipe.sink.1.write(okio.Buffer, long):void");
        }
    }

    public static final class 1 implements Source {
        private final Timeout timeout = new Timeout();

        public 1() {
        }

        public void close() {
            synchronized (Pipe.this.getBuffer$okio()) {
                Pipe.this.setSourceClosed$okio(true);
                Buffer buffer$okio = Pipe.this.getBuffer$okio();
                if (buffer$okio == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                buffer$okio.notifyAll();
                q qVar = q.a;
            }
        }

        public long read(@NotNull Buffer sink, long j) {
            l.e(sink, "sink");
            synchronized (Pipe.this.getBuffer$okio()) {
                try {
                    if (!(!Pipe.this.getSourceClosed$okio())) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (Pipe.this.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    while (Pipe.this.getBuffer$okio().size() == 0) {
                        if (Pipe.this.getSinkClosed$okio()) {
                            return -1L;
                        }
                        this.timeout.waitUntilNotified(Pipe.this.getBuffer$okio());
                        if (Pipe.this.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                    }
                    long read = Pipe.this.getBuffer$okio().read(sink, j);
                    Buffer buffer$okio = Pipe.this.getBuffer$okio();
                    if (buffer$okio == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    buffer$okio.notifyAll();
                    return read;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long j) {
        this.maxBufferSize = j;
        if (j >= 1) {
            this.sink = new 1();
            this.source = new 1();
        } else {
            throw new IllegalArgumentException(("maxBufferSize < 1: " + j).toString());
        }
    }

    public static final /* synthetic */ void access$forward(Pipe pipe, Sink sink, w8.l lVar) {
        pipe.forward(sink, lVar);
    }

    private final void forward(Sink sink, w8.l lVar) {
        Timeout timeout = sink.timeout();
        Timeout timeout2 = sink().timeout();
        long timeoutNanos = timeout.timeoutNanos();
        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(minTimeout, timeUnit);
        if (timeout.hasDeadline()) {
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                lVar.invoke(sink);
                k.b(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
            } catch (Throwable th) {
                k.b(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                k.a(1);
                throw th;
            }
        } else {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                lVar.invoke(sink);
                k.b(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
            } catch (Throwable th2) {
                k.b(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                k.a(1);
                throw th2;
            }
        }
        k.a(1);
    }

    @NotNull
    public final Sink -deprecated_sink() {
        return this.sink;
    }

    @NotNull
    public final Source -deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        synchronized (this.buffer) {
            this.canceled = true;
            this.buffer.clear();
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
            }
            buffer.notifyAll();
            q qVar = q.a;
        }
    }

    public final void fold(@NotNull Sink sink) throws IOException {
        boolean z;
        Buffer buffer;
        l.e(sink, "sink");
        while (true) {
            synchronized (this.buffer) {
                if (!(this.foldedSink == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                }
                if (this.canceled) {
                    this.foldedSink = sink;
                    throw new IOException("canceled");
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                }
                z = this.sinkClosed;
                buffer = new Buffer();
                Buffer buffer2 = this.buffer;
                buffer.write(buffer2, buffer2.size());
                Buffer buffer3 = this.buffer;
                if (buffer3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                buffer3.notifyAll();
                q qVar = q.a;
            }
            try {
                sink.write(buffer, buffer.size());
                if (z) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.buffer) {
                    try {
                        this.sourceClosed = true;
                        Buffer buffer4 = this.buffer;
                        if (buffer4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        buffer4.notifyAll();
                        q qVar2 = q.a;
                        throw th;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    @NotNull
    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    @Nullable
    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    public final void setFoldedSink$okio(@Nullable Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    @NotNull
    public final Sink sink() {
        return this.sink;
    }

    @NotNull
    public final Source source() {
        return this.source;
    }
}
