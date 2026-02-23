package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import k8.q;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public static final class 1 extends ForwardingSink {
        final /* synthetic */ Sink $sink;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 1(Sink sink, Sink sink2) {
            super(sink2);
            this.$sink = sink;
        }

        public void write(@NotNull Buffer source, long j) throws IOException {
            l.e(source, "source");
            while (j > 0) {
                try {
                    long take$okio = Throttler.this.take$okio(j);
                    super.write(source, take$okio);
                    j -= take$okio;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        }
    }

    public static final class 1 extends ForwardingSource {
        final /* synthetic */ Source $source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 1(Source source, Source source2) {
            super(source2);
            this.$source = source;
        }

        public long read(@NotNull Buffer sink, long j) {
            l.e(sink, "sink");
            try {
                return super.read(sink, Throttler.this.take$okio(j));
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException("interrupted");
            }
        }
    }

    public Throttler() {
        this(System.nanoTime());
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j, long j2, long j3, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = throttler.waitByteCount;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            j3 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j, j4, j3);
    }

    private final long bytesToNanos(long j) {
        return (j * 1000000000) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j) {
        return (j * this.bytesPerSecond) / 1000000000;
    }

    private final void waitNanos(long j) {
        long j2 = j / 1000000;
        wait(j2, (int) (j - (1000000 * j2)));
    }

    public final long byteCountOrWaitNanos$okio(long j, long j2) {
        long bytesToNanos;
        if (this.bytesPerSecond == 0) {
            return j2;
        }
        long max = Math.max(this.allocatedUntil - j, 0L);
        long nanosToBytes = this.maxByteCount - nanosToBytes(max);
        if (nanosToBytes >= j2) {
            j += max;
            bytesToNanos = bytesToNanos(j2);
        } else {
            long j3 = this.waitByteCount;
            if (nanosToBytes >= j3) {
                this.allocatedUntil = j + bytesToNanos(this.maxByteCount);
                return nanosToBytes;
            }
            j2 = Math.min(j3, j2);
            long bytesToNanos2 = max + bytesToNanos(j2 - this.maxByteCount);
            if (bytesToNanos2 != 0) {
                return -bytesToNanos2;
            }
            bytesToNanos = bytesToNanos(this.maxByteCount);
        }
        this.allocatedUntil = j + bytesToNanos;
        return j2;
    }

    public final void bytesPerSecond(long j) {
        bytesPerSecond$default(this, j, 0L, 0L, 6, null);
    }

    @NotNull
    public final Sink sink(@NotNull Sink sink) {
        l.e(sink, "sink");
        return new 1(sink, sink);
    }

    @NotNull
    public final Source source(@NotNull Source source) {
        l.e(source, "source");
        return new 1(source, source);
    }

    public final long take$okio(long j) {
        long byteCountOrWaitNanos$okio;
        if (!(j > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            while (true) {
                byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j);
                if (byteCountOrWaitNanos$okio < 0) {
                    waitNanos(-byteCountOrWaitNanos$okio);
                }
            }
        }
        return byteCountOrWaitNanos$okio;
    }

    public Throttler(long j) {
        this.allocatedUntil = j;
        this.waitByteCount = 8192L;
        this.maxByteCount = 262144L;
    }

    public final void bytesPerSecond(long j, long j2) {
        bytesPerSecond$default(this, j, j2, 0L, 4, null);
    }

    public final void bytesPerSecond(long j, long j2, long j3) {
        synchronized (this) {
            if (!(j >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(j2 > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(j3 >= j2)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.bytesPerSecond = j;
            this.waitByteCount = j2;
            this.maxByteCount = j3;
            notifyAll();
            q qVar = q.a;
        }
    }
}
