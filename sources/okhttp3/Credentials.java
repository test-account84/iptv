package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.l;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    @NotNull
    public static final String basic(@NotNull String str, @NotNull String str2) {
        return basic$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset ISO_8859_1, int i, Object obj) {
        if ((i & 4) != 0) {
            ISO_8859_1 = StandardCharsets.ISO_8859_1;
            l.d(ISO_8859_1, "ISO_8859_1");
        }
        return basic(str, str2, ISO_8859_1);
    }

    @NotNull
    public static final String basic(@NotNull String username, @NotNull String password, @NotNull Charset charset) {
        l.e(username, "username");
        l.e(password, "password");
        l.e(charset, "charset");
        return "Basic " + ByteString.Companion.encodeString(username + ':' + password, charset).base64();
    }
}
