package okhttp3;

import kotlin.jvm.internal.l;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RequestBody$Companion$toRequestBody$2 extends RequestBody {
    final /* synthetic */ int $byteCount;
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ int $offset;
    final /* synthetic */ byte[] $this_toRequestBody;

    public RequestBody$Companion$toRequestBody$2(byte[] bArr, MediaType mediaType, int i, int i2) {
        this.$this_toRequestBody = bArr;
        this.$contentType = mediaType;
        this.$byteCount = i;
        this.$offset = i2;
    }

    public long contentLength() {
        return this.$byteCount;
    }

    @Nullable
    public MediaType contentType() {
        return this.$contentType;
    }

    public void writeTo(@NotNull BufferedSink sink) {
        l.e(sink, "sink");
        sink.write(this.$this_toRequestBody, this.$offset, this.$byteCount);
    }
}
