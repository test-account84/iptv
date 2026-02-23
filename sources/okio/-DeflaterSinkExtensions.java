package okio;

import java.util.zip.Deflater;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class -DeflaterSinkExtensions {
    @NotNull
    public static final DeflaterSink deflate(@NotNull Sink deflate, @NotNull Deflater deflater) {
        l.e(deflate, "$this$deflate");
        l.e(deflater, "deflater");
        return new DeflaterSink(deflate, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink deflate, Deflater deflater, int i, Object obj) {
        if ((i & 1) != 0) {
            deflater = new Deflater();
        }
        l.e(deflate, "$this$deflate");
        l.e(deflater, "deflater");
        return new DeflaterSink(deflate, deflater);
    }
}
