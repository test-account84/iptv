package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ForwardingTimeout extends Timeout {

    @NotNull
    private Timeout delegate;

    public ForwardingTimeout(@NotNull Timeout delegate) {
        l.e(delegate, "delegate");
        this.delegate = delegate;
    }

    @NotNull
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @NotNull
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @NotNull
    public final Timeout delegate() {
        return this.delegate;
    }

    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    @NotNull
    public final ForwardingTimeout setDelegate(@NotNull Timeout delegate) {
        l.e(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }

    public void throwIfReached() throws IOException {
        this.delegate.throwIfReached();
    }

    @NotNull
    public Timeout timeout(long j, @NotNull TimeUnit unit) {
        l.e(unit, "unit");
        return this.delegate.timeout(j, unit);
    }

    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @NotNull
    public Timeout deadlineNanoTime(long j) {
        return this.delegate.deadlineNanoTime(j);
    }

    public final /* synthetic */ void setDelegate(@NotNull Timeout timeout) {
        l.e(timeout, "<set-?>");
        this.delegate = timeout;
    }
}
