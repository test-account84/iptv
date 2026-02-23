package okhttp3;

import java.io.File;
import kotlin.jvm.internal.l;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RequestBody$Companion$asRequestBody$1 extends RequestBody {
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ File $this_asRequestBody;

    public RequestBody$Companion$asRequestBody$1(File file, MediaType mediaType) {
        this.$this_asRequestBody = file;
        this.$contentType = mediaType;
    }

    public long contentLength() {
        return this.$this_asRequestBody.length();
    }

    @Nullable
    public MediaType contentType() {
        return this.$contentType;
    }

    public void writeTo(@NotNull BufferedSink sink) {
        l.e(sink, "sink");
        Source source = Okio.source(this.$this_asRequestBody);
        try {
            sink.writeAll(source);
            u8.a.a(source, null);
        } finally {
        }
    }
}
