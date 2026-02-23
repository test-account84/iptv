package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;
import org.jetbrains.annotations.NotNull;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;

    @NotNull
    private final l onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaultHidingSink(@NotNull Sink delegate, @NotNull l onException) {
        super(delegate);
        kotlin.jvm.internal.l.e(delegate, "delegate");
        kotlin.jvm.internal.l.e(onException, "onException");
        this.onException = onException;
    }

    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    @NotNull
    public final l getOnException() {
        return this.onException;
    }

    public void write(@NotNull Buffer source, long j) {
        kotlin.jvm.internal.l.e(source, "source");
        if (this.hasErrors) {
            source.skip(j);
            return;
        }
        try {
            super.write(source, j);
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }
}
