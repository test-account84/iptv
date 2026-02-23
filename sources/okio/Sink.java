package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Sink extends Closeable, Flushable {
    void close() throws IOException;

    void flush() throws IOException;

    @NotNull
    Timeout timeout();

    void write(@NotNull Buffer buffer, long j) throws IOException;
}
