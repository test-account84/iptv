package okio;

import java.io.IOException;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class ForwardingSource implements Source {

    @NotNull
    private final Source delegate;

    public ForwardingSource(@NotNull Source delegate) {
        l.e(delegate, "delegate");
        this.delegate = delegate;
    }

    @NotNull
    public final Source -deprecated_delegate() {
        return this.delegate;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    @NotNull
    public final Source delegate() {
        return this.delegate;
    }

    public long read(@NotNull Buffer sink, long j) throws IOException {
        l.e(sink, "sink");
        return this.delegate.read(sink, j);
    }

    @NotNull
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
