package okhttp3.logging;

import B8.h;
import java.io.EOFException;
import kotlin.jvm.internal.l;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(@NotNull Buffer isProbablyUtf8) {
        l.e(isProbablyUtf8, "$this$isProbablyUtf8");
        try {
            Buffer buffer = new Buffer();
            isProbablyUtf8.copyTo(buffer, 0L, h.f(isProbablyUtf8.size(), 64L));
            for (int i = 0; i < 16; i++) {
                if (buffer.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
