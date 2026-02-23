package okhttp3;

import java.util.Comparator;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class CipherSuite$Companion$ORDER_BY_NAME$1 implements Comparator {
    public int compare(@NotNull String a, @NotNull String b) {
        l.e(a, "a");
        l.e(b, "b");
        int min = Math.min(a.length(), b.length());
        for (int i = 4; i < min; i++) {
            char charAt = a.charAt(i);
            char charAt2 = b.charAt(i);
            if (charAt != charAt2) {
                return l.f(charAt, charAt2) < 0 ? -1 : 1;
            }
        }
        int length = a.length();
        int length2 = b.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }
}
