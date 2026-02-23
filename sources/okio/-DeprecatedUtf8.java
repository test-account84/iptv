package okio;

import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class -DeprecatedUtf8 {
    public static final -DeprecatedUtf8 INSTANCE = new -DeprecatedUtf8();

    private -DeprecatedUtf8() {
    }

    public final long size(@NotNull String string) {
        l.e(string, "string");
        return Utf8.size$default(string, 0, 0, 3, null);
    }

    public final long size(@NotNull String string, int i, int i2) {
        l.e(string, "string");
        return Utf8.size(string, i, i2);
    }
}
