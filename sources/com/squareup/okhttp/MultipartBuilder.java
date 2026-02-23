package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class MultipartBuilder {
    private final ByteString boundary;
    private final List partBodies;
    private final List partHeaders;
    private MediaType type;
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};

    public static final class MultipartRequestBody extends RequestBody {
        private final ByteString boundary;
        private long contentLength = -1;
        private final MediaType contentType;
        private final List partBodies;
        private final List partHeaders;

        public MultipartRequestBody(MediaType mediaType, ByteString byteString, List list, List list2) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            }
            this.boundary = byteString;
            this.contentType = MediaType.parse(mediaType + "; boundary=" + byteString.utf8());
            this.partHeaders = Util.immutableList(list);
            this.partBodies = Util.immutableList(list2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private long writeOrCountBytes(BufferedSink bufferedSink, boolean z) throws IOException {
            Buffer buffer;
            if (z) {
                bufferedSink = new Buffer();
                buffer = bufferedSink;
            } else {
                buffer = 0;
            }
            int size = this.partHeaders.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                Headers headers = (Headers) this.partHeaders.get(i);
                RequestBody requestBody = (RequestBody) this.partBodies.get(i);
                bufferedSink.write(MultipartBuilder.access$000());
                bufferedSink.write(this.boundary);
                bufferedSink.write(MultipartBuilder.access$100());
                if (headers != null) {
                    int size2 = headers.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        bufferedSink.writeUtf8(headers.name(i2)).write(MultipartBuilder.access$200()).writeUtf8(headers.value(i2)).write(MultipartBuilder.access$100());
                    }
                }
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    bufferedSink.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(MultipartBuilder.access$100());
                }
                long contentLength = requestBody.contentLength();
                if (contentLength != -1) {
                    bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(contentLength).write(MultipartBuilder.access$100());
                } else if (z) {
                    buffer.clear();
                    return -1L;
                }
                bufferedSink.write(MultipartBuilder.access$100());
                if (z) {
                    j += contentLength;
                } else {
                    ((RequestBody) this.partBodies.get(i)).writeTo(bufferedSink);
                }
                bufferedSink.write(MultipartBuilder.access$100());
            }
            bufferedSink.write(MultipartBuilder.access$000());
            bufferedSink.write(this.boundary);
            bufferedSink.write(MultipartBuilder.access$000());
            bufferedSink.write(MultipartBuilder.access$100());
            if (!z) {
                return j;
            }
            long size3 = j + buffer.size();
            buffer.clear();
            return size3;
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

        public MediaType contentType() {
            return this.contentType;
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            writeOrCountBytes(bufferedSink, false);
        }
    }

    public MultipartBuilder() {
        this(UUID.randomUUID().toString());
    }

    public static /* synthetic */ byte[] access$000() {
        return DASHDASH;
    }

    public static /* synthetic */ byte[] access$100() {
        return CRLF;
    }

    public static /* synthetic */ byte[] access$200() {
        return COLONSPACE;
    }

    private static StringBuilder appendQuotedString(StringBuilder sb, String str) {
        String str2;
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                str2 = "%0A";
            } else if (charAt == '\r') {
                str2 = "%0D";
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                str2 = "%22";
            }
            sb.append(str2);
        }
        sb.append('\"');
        return sb;
    }

    public MultipartBuilder addFormDataPart(String str, String str2) {
        return addFormDataPart(str, null, RequestBody.create((MediaType) null, str2));
    }

    public MultipartBuilder addPart(Headers headers, RequestBody requestBody) {
        if (requestBody == null) {
            throw new NullPointerException("body == null");
        }
        if (headers != null && headers.get("Content-Type") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        if (headers != null && headers.get("Content-Length") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
        this.partHeaders.add(headers);
        this.partBodies.add(requestBody);
        return this;
    }

    public RequestBody build() {
        if (this.partHeaders.isEmpty()) {
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
        return new MultipartRequestBody(this.type, this.boundary, this.partHeaders, this.partBodies);
    }

    public MultipartBuilder type(MediaType mediaType) {
        if (mediaType == null) {
            throw new NullPointerException("type == null");
        }
        if (mediaType.type().equals("multipart")) {
            this.type = mediaType;
            return this;
        }
        throw new IllegalArgumentException("multipart != " + mediaType);
    }

    public MultipartBuilder(String str) {
        this.type = MIXED;
        this.partHeaders = new ArrayList();
        this.partBodies = new ArrayList();
        this.boundary = ByteString.encodeUtf8(str);
    }

    public MultipartBuilder addFormDataPart(String str, String str2, RequestBody requestBody) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        StringBuilder sb = new StringBuilder("form-data; name=");
        appendQuotedString(sb, str);
        if (str2 != null) {
            sb.append("; filename=");
            appendQuotedString(sb, str2);
        }
        return addPart(Headers.of("Content-Disposition", sb.toString()), requestBody);
    }

    public MultipartBuilder addPart(RequestBody requestBody) {
        return addPart(null, requestBody);
    }
}
