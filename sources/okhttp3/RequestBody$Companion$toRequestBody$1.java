package okhttp3;

import kotlin.jvm.internal.l;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RequestBody$Companion$toRequestBody$1 extends RequestBody {
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ ByteString $this_toRequestBody;

    public RequestBody$Companion$toRequestBody$1(ByteString byteString, MediaType mediaType) {
        this.$this_toRequestBody = byteString;
        this.$contentType = mediaType;
    }

    public long contentLength() {
        return this.$this_toRequestBody.size();
    }

    @Nullable
    public MediaType contentType() {
        return this.$contentType;
    }

    public void writeTo(@NotNull BufferedSink sink) {
        l.e(sink, "sink");
        sink.write(this.$this_toRequestBody);
    }
}
