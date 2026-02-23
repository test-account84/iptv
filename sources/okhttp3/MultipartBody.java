package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class MultipartBody extends RequestBody {

    @NotNull
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final Companion Companion = new Companion(null);
    private static final byte[] DASHDASH;

    @NotNull
    public static final MediaType DIGEST;

    @NotNull
    public static final MediaType FORM;

    @NotNull
    public static final MediaType MIXED;

    @NotNull
    public static final MediaType PARALLEL;
    private final ByteString boundaryByteString;
    private long contentLength;
    private final MediaType contentType;

    @NotNull
    private final List parts;

    @NotNull
    private final MediaType type;

    public static final class Builder {
        private final ByteString boundary;
        private final List parts;
        private MediaType type;

        public Builder() {
            this(null, 1, null);
        }

        @NotNull
        public final Builder addFormDataPart(@NotNull String name, @NotNull String value) {
            l.e(name, "name");
            l.e(value, "value");
            addPart(Part.Companion.createFormData(name, value));
            return this;
        }

        @NotNull
        public final Builder addPart(@Nullable Headers headers, @NotNull RequestBody body) {
            l.e(body, "body");
            addPart(Part.Companion.create(headers, body));
            return this;
        }

        @NotNull
        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        @NotNull
        public final Builder setType(@NotNull MediaType type) {
            l.e(type, "type");
            if (l.a(type.type(), "multipart")) {
                this.type = type;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + type).toString());
        }

        public Builder(@NotNull String boundary) {
            l.e(boundary, "boundary");
            this.boundary = ByteString.Companion.encodeUtf8(boundary);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        @NotNull
        public final Builder addFormDataPart(@NotNull String name, @Nullable String str, @NotNull RequestBody body) {
            l.e(name, "name");
            l.e(body, "body");
            addPart(Part.Companion.createFormData(name, str, body));
            return this;
        }

        @NotNull
        public final Builder addPart(@NotNull Part part) {
            l.e(part, "part");
            this.parts.add(part);
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Builder(String str, int i, g gVar) {
            if ((i & 1) != 0) {
                str = UUID.randomUUID().toString();
                l.d(str, "UUID.randomUUID().toString()");
            }
            this(str);
        }

        @NotNull
        public final Builder addPart(@NotNull RequestBody body) {
            l.e(body, "body");
            addPart(Part.Companion.create(body));
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public final void appendQuotedString$okhttp(@NotNull StringBuilder appendQuotedString, @NotNull String key) {
            String str;
            l.e(appendQuotedString, "$this$appendQuotedString");
            l.e(key, "key");
            appendQuotedString.append('\"');
            int length = key.length();
            for (int i = 0; i < length; i++) {
                char charAt = key.charAt(i);
                if (charAt == '\n') {
                    str = "%0A";
                } else if (charAt == '\r') {
                    str = "%0D";
                } else if (charAt != '\"') {
                    appendQuotedString.append(charAt);
                } else {
                    str = "%22";
                }
                appendQuotedString.append(str);
            }
            appendQuotedString.append('\"');
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final class Part {
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final RequestBody body;

        @Nullable
        private final Headers headers;

        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final Part create(@Nullable Headers headers, @NotNull RequestBody body) {
                l.e(body, "body");
                if (!((headers != null ? headers.get("Content-Type") : null) == null)) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
                }
                if ((headers != null ? headers.get("Content-Length") : null) == null) {
                    return new Part(headers, body, null);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            }

            @NotNull
            public final Part createFormData(@NotNull String name, @NotNull String value) {
                l.e(name, "name");
                l.e(value, "value");
                return createFormData(name, null, RequestBody.Companion.create$default(RequestBody.Companion, value, (MediaType) null, 1, (Object) null));
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }

            @NotNull
            public final Part create(@NotNull RequestBody body) {
                l.e(body, "body");
                return create(null, body);
            }

            @NotNull
            public final Part createFormData(@NotNull String name, @Nullable String str, @NotNull RequestBody body) {
                l.e(name, "name");
                l.e(body, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb, name);
                if (str != null) {
                    sb.append("; filename=");
                    companion.appendQuotedString$okhttp(sb, str);
                }
                String sb2 = sb.toString();
                l.d(sb2, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb2).build(), body);
            }
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        @NotNull
        public static final Part create(@Nullable Headers headers, @NotNull RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        @NotNull
        public static final Part createFormData(@NotNull String str, @NotNull String str2) {
            return Companion.createFormData(str, str2);
        }

        @NotNull
        public final RequestBody -deprecated_body() {
            return this.body;
        }

        @Nullable
        public final Headers -deprecated_headers() {
            return this.headers;
        }

        @NotNull
        public final RequestBody body() {
            return this.body;
        }

        @Nullable
        public final Headers headers() {
            return this.headers;
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, g gVar) {
            this(headers, requestBody);
        }

        @NotNull
        public static final Part create(@NotNull RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        @NotNull
        public static final Part createFormData(@NotNull String str, @Nullable String str2, @NotNull RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get("multipart/form-data");
        COLONSPACE = new byte[]{(byte) 58, (byte) 32};
        CRLF = new byte[]{(byte) 13, (byte) 10};
        byte b = (byte) 45;
        DASHDASH = new byte[]{b, b};
    }

    public MultipartBody(@NotNull ByteString boundaryByteString, @NotNull MediaType type, @NotNull List parts) {
        l.e(boundaryByteString, "boundaryByteString");
        l.e(type, "type");
        l.e(parts, "parts");
        this.boundaryByteString = boundaryByteString;
        this.type = type;
        this.parts = parts;
        this.contentType = MediaType.Companion.get(type + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        if (z) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Part part = (Part) this.parts.get(i);
            Headers headers = part.headers();
            RequestBody body = part.body();
            l.b(bufferedSink);
            bufferedSink.write(DASHDASH);
            bufferedSink.write(this.boundaryByteString);
            bufferedSink.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bufferedSink.writeUtf8(headers.name(i2)).write(COLONSPACE).writeUtf8(headers.value(i2)).write(CRLF);
                }
            }
            MediaType contentType = body.contentType();
            if (contentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(CRLF);
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(contentLength).write(CRLF);
            } else if (z) {
                l.b(buffer);
                buffer.clear();
                return -1L;
            }
            byte[] bArr = CRLF;
            bufferedSink.write(bArr);
            if (z) {
                j += contentLength;
            } else {
                body.writeTo(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        l.b(bufferedSink);
        byte[] bArr2 = DASHDASH;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.boundaryByteString);
        bufferedSink.write(bArr2);
        bufferedSink.write(CRLF);
        if (!z) {
            return j;
        }
        l.b(buffer);
        long size3 = j + buffer.size();
        buffer.clear();
        return size3;
    }

    @NotNull
    public final String -deprecated_boundary() {
        return boundary();
    }

    @NotNull
    public final List -deprecated_parts() {
        return this.parts;
    }

    public final int -deprecated_size() {
        return size();
    }

    @NotNull
    public final MediaType -deprecated_type() {
        return this.type;
    }

    @NotNull
    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    public long contentLength() throws IOException {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        long writeOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = writeOrCountBytes;
        return writeOrCountBytes;
    }

    @NotNull
    public MediaType contentType() {
        return this.contentType;
    }

    @NotNull
    public final Part part(int i) {
        return (Part) this.parts.get(i);
    }

    @NotNull
    public final List parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    @NotNull
    public final MediaType type() {
        return this.type;
    }

    public void writeTo(@NotNull BufferedSink sink) throws IOException {
        l.e(sink, "sink");
        writeOrCountBytes(sink, false);
    }
}
