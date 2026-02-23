package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import k8.q;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AsyncTimeout extends Timeout {
    public static final Companion Companion = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ boolean access$cancelScheduledTimeout(Companion companion, AsyncTimeout asyncTimeout) {
            return companion.cancelScheduledTimeout(asyncTimeout);
        }

        public static final /* synthetic */ void access$scheduleTimeout(Companion companion, AsyncTimeout asyncTimeout, long j, boolean z) {
            companion.scheduleTimeout(asyncTimeout, j, z);
        }

        private final boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
            synchronized (AsyncTimeout.class) {
                for (AsyncTimeout access$getHead$cp = AsyncTimeout.access$getHead$cp(); access$getHead$cp != null; access$getHead$cp = AsyncTimeout.access$getNext$p(access$getHead$cp)) {
                    if (AsyncTimeout.access$getNext$p(access$getHead$cp) == asyncTimeout) {
                        AsyncTimeout.access$setNext$p(access$getHead$cp, AsyncTimeout.access$getNext$p(asyncTimeout));
                        AsyncTimeout.access$setNext$p(asyncTimeout, null);
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0053 A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x001c, B:10:0x0028, B:11:0x0031, B:12:0x0042, B:13:0x004a, B:15:0x0053, B:17:0x0063, B:20:0x0068, B:22:0x0078, B:23:0x007d, B:31:0x003b, B:32:0x0081, B:33:0x0086), top: B:3:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0078 A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x001c, B:10:0x0028, B:11:0x0031, B:12:0x0042, B:13:0x004a, B:15:0x0053, B:17:0x0063, B:20:0x0068, B:22:0x0078, B:23:0x007d, B:31:0x003b, B:32:0x0081, B:33:0x0086), top: B:3:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[EDGE_INSN: B:27:0x0068->B:20:0x0068 BREAK  A[LOOP:0: B:13:0x004a->B:17:0x0063], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void scheduleTimeout(okio.AsyncTimeout r7, long r8, boolean r10) {
            /*
                r6 = this;
                java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
                monitor-enter(r0)
                okio.AsyncTimeout r1 = okio.AsyncTimeout.access$getHead$cp()     // Catch: java.lang.Throwable -> L1a
                if (r1 != 0) goto L1c
                okio.AsyncTimeout r1 = new okio.AsyncTimeout     // Catch: java.lang.Throwable -> L1a
                r1.<init>()     // Catch: java.lang.Throwable -> L1a
                okio.AsyncTimeout.access$setHead$cp(r1)     // Catch: java.lang.Throwable -> L1a
                okio.AsyncTimeout$Watchdog r1 = new okio.AsyncTimeout$Watchdog     // Catch: java.lang.Throwable -> L1a
                r1.<init>()     // Catch: java.lang.Throwable -> L1a
                r1.start()     // Catch: java.lang.Throwable -> L1a
                goto L1c
            L1a:
                r7 = move-exception
                goto L87
            L1c:
                long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L1a
                r3 = 0
                int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r5 == 0) goto L36
                if (r10 == 0) goto L36
                long r3 = r7.deadlineNanoTime()     // Catch: java.lang.Throwable -> L1a
                long r3 = r3 - r1
                long r8 = java.lang.Math.min(r8, r3)     // Catch: java.lang.Throwable -> L1a
            L31:
                long r8 = r8 + r1
                okio.AsyncTimeout.access$setTimeoutAt$p(r7, r8)     // Catch: java.lang.Throwable -> L1a
                goto L42
            L36:
                if (r5 == 0) goto L39
                goto L31
            L39:
                if (r10 == 0) goto L81
                long r8 = r7.deadlineNanoTime()     // Catch: java.lang.Throwable -> L1a
                okio.AsyncTimeout.access$setTimeoutAt$p(r7, r8)     // Catch: java.lang.Throwable -> L1a
            L42:
                long r8 = okio.AsyncTimeout.access$remainingNanos(r7, r1)     // Catch: java.lang.Throwable -> L1a
                okio.AsyncTimeout r10 = okio.AsyncTimeout.access$getHead$cp()     // Catch: java.lang.Throwable -> L1a
            L4a:
                kotlin.jvm.internal.l.b(r10)     // Catch: java.lang.Throwable -> L1a
                okio.AsyncTimeout r3 = okio.AsyncTimeout.access$getNext$p(r10)     // Catch: java.lang.Throwable -> L1a
                if (r3 == 0) goto L68
                okio.AsyncTimeout r3 = okio.AsyncTimeout.access$getNext$p(r10)     // Catch: java.lang.Throwable -> L1a
                kotlin.jvm.internal.l.b(r3)     // Catch: java.lang.Throwable -> L1a
                long r3 = okio.AsyncTimeout.access$remainingNanos(r3, r1)     // Catch: java.lang.Throwable -> L1a
                int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r5 >= 0) goto L63
                goto L68
            L63:
                okio.AsyncTimeout r10 = okio.AsyncTimeout.access$getNext$p(r10)     // Catch: java.lang.Throwable -> L1a
                goto L4a
            L68:
                okio.AsyncTimeout r8 = okio.AsyncTimeout.access$getNext$p(r10)     // Catch: java.lang.Throwable -> L1a
                okio.AsyncTimeout.access$setNext$p(r7, r8)     // Catch: java.lang.Throwable -> L1a
                okio.AsyncTimeout.access$setNext$p(r10, r7)     // Catch: java.lang.Throwable -> L1a
                okio.AsyncTimeout r7 = okio.AsyncTimeout.access$getHead$cp()     // Catch: java.lang.Throwable -> L1a
                if (r10 != r7) goto L7d
                java.lang.Class<okio.AsyncTimeout> r7 = okio.AsyncTimeout.class
                r7.notify()     // Catch: java.lang.Throwable -> L1a
            L7d:
                k8.q r7 = k8.q.a     // Catch: java.lang.Throwable -> L1a
                monitor-exit(r0)
                return
            L81:
                java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L1a
                r7.<init>()     // Catch: java.lang.Throwable -> L1a
                throw r7     // Catch: java.lang.Throwable -> L1a
            L87:
                monitor-exit(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Companion.scheduleTimeout(okio.AsyncTimeout, long, boolean):void");
        }

        @Nullable
        public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout access$getHead$cp = AsyncTimeout.access$getHead$cp();
            l.b(access$getHead$cp);
            AsyncTimeout access$getNext$p = AsyncTimeout.access$getNext$p(access$getHead$cp);
            long nanoTime = System.nanoTime();
            if (access$getNext$p == null) {
                AsyncTimeout.class.wait(AsyncTimeout.access$getIDLE_TIMEOUT_MILLIS$cp());
                AsyncTimeout access$getHead$cp2 = AsyncTimeout.access$getHead$cp();
                l.b(access$getHead$cp2);
                if (AsyncTimeout.access$getNext$p(access$getHead$cp2) != null || System.nanoTime() - nanoTime < AsyncTimeout.access$getIDLE_TIMEOUT_NANOS$cp()) {
                    return null;
                }
                return AsyncTimeout.access$getHead$cp();
            }
            long access$remainingNanos = AsyncTimeout.access$remainingNanos(access$getNext$p, nanoTime);
            if (access$remainingNanos > 0) {
                long j = access$remainingNanos / 1000000;
                AsyncTimeout.class.wait(j, (int) (access$remainingNanos - (1000000 * j)));
                return null;
            }
            AsyncTimeout access$getHead$cp3 = AsyncTimeout.access$getHead$cp();
            l.b(access$getHead$cp3);
            AsyncTimeout.access$setNext$p(access$getHead$cp3, AsyncTimeout.access$getNext$p(access$getNext$p));
            AsyncTimeout.access$setNext$p(access$getNext$p, null);
            return access$getNext$p;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public void run() {
            AsyncTimeout awaitTimeout$okio;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        awaitTimeout$okio = AsyncTimeout.Companion.awaitTimeout$okio();
                        if (awaitTimeout$okio == AsyncTimeout.access$getHead$cp()) {
                            AsyncTimeout.access$setHead$cp(null);
                            return;
                        }
                        q qVar = q.a;
                    }
                    if (awaitTimeout$okio != null) {
                        awaitTimeout$okio.timedOut();
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
            }
        }
    }

    public static final class 1 implements Sink {
        final /* synthetic */ Sink $sink;

        public 1(Sink sink) {
            this.$sink = sink;
        }

        public void close() {
            AsyncTimeout asyncTimeout = AsyncTimeout.this;
            asyncTimeout.enter();
            try {
                this.$sink.close();
                q qVar = q.a;
                if (asyncTimeout.exit()) {
                    throw asyncTimeout.access$newTimeoutException(null);
                }
            } catch (IOException e) {
                if (!asyncTimeout.exit()) {
                    throw e;
                }
                throw asyncTimeout.access$newTimeoutException(e);
            } finally {
                asyncTimeout.exit();
            }
        }

        public void flush() {
            AsyncTimeout asyncTimeout = AsyncTimeout.this;
            asyncTimeout.enter();
            try {
                this.$sink.flush();
                q qVar = q.a;
                if (asyncTimeout.exit()) {
                    throw asyncTimeout.access$newTimeoutException(null);
                }
            } catch (IOException e) {
                if (!asyncTimeout.exit()) {
                    throw e;
                }
                throw asyncTimeout.access$newTimeoutException(e);
            } finally {
                asyncTimeout.exit();
            }
        }

        @NotNull
        public AsyncTimeout timeout() {
            return AsyncTimeout.this;
        }

        @NotNull
        public String toString() {
            return "AsyncTimeout.sink(" + this.$sink + ')';
        }

        public void write(@NotNull Buffer source, long j) {
            l.e(source, "source");
            -Util.checkOffsetAndCount(source.size(), 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                Segment segment = source.head;
                while (true) {
                    l.b(segment);
                    if (j2 >= 65536) {
                        break;
                    }
                    j2 += segment.limit - segment.pos;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    segment = segment.next;
                }
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    this.$sink.write(source, j2);
                    q qVar = q.a;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                    j -= j2;
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.access$newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }
        }
    }

    public static final class 1 implements Source {
        final /* synthetic */ Source $source;

        public 1(Source source) {
            this.$source = source;
        }

        public void close() {
            AsyncTimeout asyncTimeout = AsyncTimeout.this;
            asyncTimeout.enter();
            try {
                this.$source.close();
                q qVar = q.a;
                if (asyncTimeout.exit()) {
                    throw asyncTimeout.access$newTimeoutException(null);
                }
            } catch (IOException e) {
                if (!asyncTimeout.exit()) {
                    throw e;
                }
                throw asyncTimeout.access$newTimeoutException(e);
            } finally {
                asyncTimeout.exit();
            }
        }

        public long read(@NotNull Buffer sink, long j) {
            l.e(sink, "sink");
            AsyncTimeout asyncTimeout = AsyncTimeout.this;
            asyncTimeout.enter();
            try {
                long read = this.$source.read(sink, j);
                if (asyncTimeout.exit()) {
                    throw asyncTimeout.access$newTimeoutException(null);
                }
                return read;
            } catch (IOException e) {
                if (asyncTimeout.exit()) {
                    throw asyncTimeout.access$newTimeoutException(e);
                }
                throw e;
            } finally {
                asyncTimeout.exit();
            }
        }

        @NotNull
        public AsyncTimeout timeout() {
            return AsyncTimeout.this;
        }

        @NotNull
        public String toString() {
            return "AsyncTimeout.source(" + this.$source + ')';
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static final /* synthetic */ AsyncTimeout access$getHead$cp() {
        return head;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_MILLIS$cp() {
        return IDLE_TIMEOUT_MILLIS;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_NANOS$cp() {
        return IDLE_TIMEOUT_NANOS;
    }

    public static final /* synthetic */ AsyncTimeout access$getNext$p(AsyncTimeout asyncTimeout) {
        return asyncTimeout.next;
    }

    public static final /* synthetic */ long access$getTimeoutAt$p(AsyncTimeout asyncTimeout) {
        return asyncTimeout.timeoutAt;
    }

    public static final /* synthetic */ long access$remainingNanos(AsyncTimeout asyncTimeout, long j) {
        return asyncTimeout.remainingNanos(j);
    }

    public static final /* synthetic */ void access$setHead$cp(AsyncTimeout asyncTimeout) {
        head = asyncTimeout;
    }

    public static final /* synthetic */ void access$setNext$p(AsyncTimeout asyncTimeout, AsyncTimeout asyncTimeout2) {
        asyncTimeout.next = asyncTimeout2;
    }

    public static final /* synthetic */ void access$setTimeoutAt$p(AsyncTimeout asyncTimeout, long j) {
        asyncTimeout.timeoutAt = j;
    }

    private final long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    @NotNull
    public final IOException access$newTimeoutException(@Nullable IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        if (!(!this.inQueue)) {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.inQueue = true;
            Companion.access$scheduleTimeout(Companion, this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return Companion.access$cancelScheduledTimeout(Companion, this);
    }

    @NotNull
    public IOException newTimeoutException(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @NotNull
    public final Sink sink(@NotNull Sink sink) {
        l.e(sink, "sink");
        return new 1(sink);
    }

    @NotNull
    public final Source source(@NotNull Source source) {
        l.e(source, "source");
        return new 1(source);
    }

    public void timedOut() {
    }

    public final Object withTimeout(@NotNull w8.a block) {
        l.e(block, "block");
        enter();
        try {
            try {
                Object invoke = block.invoke();
                k.b(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                k.a(1);
                return invoke;
            } catch (IOException e) {
                if (exit()) {
                    throw access$newTimeoutException(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            k.b(1);
            exit();
            k.a(1);
            throw th;
        }
    }
}
