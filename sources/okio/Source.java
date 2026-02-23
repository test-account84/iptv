package okio;

import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Source extends Closeable {
    void close() throws IOException;

    long read(@NotNull Buffer buffer, long j) throws IOException;

    @NotNull
    Timeout timeout();
}
