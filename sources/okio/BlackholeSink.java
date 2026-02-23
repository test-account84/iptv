package okio;

import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class BlackholeSink implements Sink {
    public void close() {
    }

    public void flush() {
    }

    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void write(@NotNull Buffer source, long j) {
        l.e(source, "source");
        source.skip(j);
    }
}
