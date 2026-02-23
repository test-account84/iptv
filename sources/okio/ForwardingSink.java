package okio;

import java.io.IOException;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class ForwardingSink implements Sink {

    @NotNull
    private final Sink delegate;

    public ForwardingSink(@NotNull Sink delegate) {
        l.e(delegate, "delegate");
        this.delegate = delegate;
    }

    @NotNull
    public final Sink -deprecated_delegate() {
        return this.delegate;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    @NotNull
    public final Sink delegate() {
        return this.delegate;
    }

    public void flush() throws IOException {
        this.delegate.flush();
    }

    @NotNull
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    public void write(@NotNull Buffer source, long j) throws IOException {
        l.e(source, "source");
        this.delegate.write(source, j);
    }
}
