package okhttp3.internal.http;

import kotlin.jvm.internal.l;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(@Nullable String str, long j, @NotNull BufferedSource source) {
        l.e(source, "source");
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = source;
    }

    public long contentLength() {
        return this.contentLength;
    }

    @Nullable
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @NotNull
    public BufferedSource source() {
        return this.source;
    }
}
