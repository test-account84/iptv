package okio;

import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class -GzipSinkExtensions {
    @NotNull
    public static final GzipSink gzip(@NotNull Sink gzip) {
        l.e(gzip, "$this$gzip");
        return new GzipSink(gzip);
    }
}
