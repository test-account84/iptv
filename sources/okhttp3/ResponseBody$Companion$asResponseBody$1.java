package okhttp3;

import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ResponseBody$Companion$asResponseBody$1 extends ResponseBody {
    final /* synthetic */ long $contentLength;
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ BufferedSource $this_asResponseBody;

    public ResponseBody$Companion$asResponseBody$1(BufferedSource bufferedSource, MediaType mediaType, long j) {
        this.$this_asResponseBody = bufferedSource;
        this.$contentType = mediaType;
        this.$contentLength = j;
    }

    public long contentLength() {
        return this.$contentLength;
    }

    @Nullable
    public MediaType contentType() {
        return this.$contentType;
    }

    @NotNull
    public BufferedSource source() {
        return this.$this_asResponseBody;
    }
}
