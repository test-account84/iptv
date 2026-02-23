package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Timeout {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final Timeout NONE = new Timeout$Companion$NONE$1();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public static final class Companion {
        private Companion() {
        }

        public final long minTimeout(long j, long j2) {
            return (j != 0 && (j2 == 0 || j < j2)) ? j : j2;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @NotNull
    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    @NotNull
    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    @NotNull
    public final Timeout deadline(long j, @NotNull TimeUnit unit) {
        l.e(unit, "unit");
        if (j > 0) {
            return deadlineNanoTime(System.nanoTime() + unit.toNanos(j));
        }
        throw new IllegalArgumentException(("duration <= 0: " + j).toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(@NotNull Timeout other, @NotNull w8.a block) {
        l.e(other, "other");
        l.e(block, "block");
        long timeoutNanos = timeoutNanos();
        long minTimeout = Companion.minTimeout(other.timeoutNanos(), timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(minTimeout, timeUnit);
        if (hasDeadline()) {
            long deadlineNanoTime = deadlineNanoTime();
            if (other.hasDeadline()) {
                deadlineNanoTime(Math.min(deadlineNanoTime(), other.deadlineNanoTime()));
            }
            try {
                block.invoke();
                k.b(1);
                timeout(timeoutNanos, timeUnit);
                if (other.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime);
                }
            } catch (Throwable th) {
                k.b(1);
                timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (other.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime);
                }
                k.a(1);
                throw th;
            }
        } else {
            if (other.hasDeadline()) {
                deadlineNanoTime(other.deadlineNanoTime());
            }
            try {
                block.invoke();
                k.b(1);
                timeout(timeoutNanos, timeUnit);
                if (other.hasDeadline()) {
                    clearDeadline();
                }
            } catch (Throwable th2) {
                k.b(1);
                timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (other.hasDeadline()) {
                    clearDeadline();
                }
                k.a(1);
                throw th2;
            }
        }
        k.a(1);
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    @NotNull
    public Timeout timeout(long j, @NotNull TimeUnit unit) {
        l.e(unit, "unit");
        if (j >= 0) {
            this.timeoutNanos = unit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(@NotNull Object monitor) throws InterruptedIOException {
        l.e(monitor, "monitor");
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            long j = 0;
            if (!hasDeadline && timeoutNanos == 0) {
                monitor.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos > 0) {
                long j2 = timeoutNanos / 1000000;
                Long.signum(j2);
                monitor.wait(j2, (int) (timeoutNanos - (1000000 * j2)));
                j = System.nanoTime() - nanoTime;
            }
            if (j >= timeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    @NotNull
    public Timeout deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }
}
