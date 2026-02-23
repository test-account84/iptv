package okhttp3.internal.cache;

import java.io.IOException;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface CacheRequest {
    void abort();

    @NotNull
    Sink body() throws IOException;
}
