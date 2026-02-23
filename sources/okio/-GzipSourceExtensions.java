package okio;

import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class -GzipSourceExtensions {
    private static final int FCOMMENT = 4;
    private static final int FEXTRA = 2;
    private static final int FHCRC = 1;
    private static final int FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    public static final /* synthetic */ boolean access$getBit(int i, int i2) {
        return getBit(i, i2);
    }

    private static final boolean getBit(int i, int i2) {
        return ((i >> i2) & 1) == 1;
    }

    @NotNull
    public static final GzipSource gzip(@NotNull Source gzip) {
        l.e(gzip, "$this$gzip");
        return new GzipSource(gzip);
    }
}
