package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class FormBody extends RequestBody {
    private final List encodedNames;
    private final List encodedValues;
    public static final Companion Companion = new Companion(null);
    private static final MediaType CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");

    public static final class Builder {
        private final Charset charset;
        private final List names;
        private final List values;

        public Builder() {
            this(null, 1, null);
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull String value) {
            l.e(name, "name");
            l.e(value, "value");
            Collection collection = this.names;
            HttpUrl.Companion companion = HttpUrl.Companion;
            collection.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.charset, 91, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.charset, 91, null));
            return this;
        }

        @NotNull
        public final Builder addEncoded(@NotNull String name, @NotNull String value) {
            l.e(name, "name");
            l.e(value, "value");
            Collection collection = this.names;
            HttpUrl.Companion companion = HttpUrl.Companion;
            collection.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.charset, 83, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.charset, 83, null));
            return this;
        }

        @NotNull
        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder(@Nullable Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public /* synthetic */ Builder(Charset charset, int i, g gVar) {
            this((i & 1) != 0 ? null : charset);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public FormBody(@NotNull List encodedNames, @NotNull List encodedValues) {
        l.e(encodedNames, "encodedNames");
        l.e(encodedValues, "encodedValues");
        this.encodedNames = Util.toImmutableList(encodedNames);
        this.encodedValues = Util.toImmutableList(encodedValues);
    }

    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean z) {
        Buffer buffer;
        if (z) {
            buffer = new Buffer();
        } else {
            l.b(bufferedSink);
            buffer = bufferedSink.getBuffer();
        }
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8((String) this.encodedNames.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8((String) this.encodedValues.get(i));
        }
        if (!z) {
            return 0L;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    public final int -deprecated_size() {
        return size();
    }

    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @NotNull
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    @NotNull
    public final String encodedName(int i) {
        return (String) this.encodedNames.get(i);
    }

    @NotNull
    public final String encodedValue(int i) {
        return (String) this.encodedValues.get(i);
    }

    @NotNull
    public final String name(int i) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(i), 0, 0, true, 3, null);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    @NotNull
    public final String value(int i) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(i), 0, 0, true, 3, null);
    }

    public void writeTo(@NotNull BufferedSink sink) throws IOException {
        l.e(sink, "sink");
        writeOrCountBytes(sink, false);
    }
}
