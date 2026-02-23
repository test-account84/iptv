package okhttp3;

import E8.c;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = new Companion(null);
    private Reader reader;

    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final BufferedSource source;

        public BomAwareReader(@NotNull BufferedSource source, @NotNull Charset charset) {
            l.e(source, "source");
            l.e(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        public int read(@NotNull char[] cbuf, int i, int i2) throws IOException {
            l.e(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            InputStreamReader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, i, i2);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @NotNull
        public final ResponseBody create(@NotNull String toResponseBody, @Nullable MediaType mediaType) {
            l.e(toResponseBody, "$this$toResponseBody");
            Charset charset = c.b;
            if (mediaType != null) {
                Charset charset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charset$default;
                }
            }
            Buffer writeString = new Buffer().writeString(toResponseBody, charset);
            return create(writeString, mediaType, writeString.size());
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, BufferedSource bufferedSource, MediaType mediaType, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            if ((i & 2) != 0) {
                j = -1;
            }
            return companion.create(bufferedSource, mediaType, j);
        }

        @NotNull
        public final ResponseBody create(@Nullable MediaType mediaType, long j, @NotNull BufferedSource content) {
            l.e(content, "content");
            return create(content, mediaType, j);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        @NotNull
        public final ResponseBody create(@Nullable MediaType mediaType, @NotNull String content) {
            l.e(content, "content");
            return create(content, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        @NotNull
        public final ResponseBody create(@Nullable MediaType mediaType, @NotNull ByteString content) {
            l.e(content, "content");
            return create(content, mediaType);
        }

        @NotNull
        public final ResponseBody create(@Nullable MediaType mediaType, @NotNull byte[] content) {
            l.e(content, "content");
            return create(content, mediaType);
        }

        @NotNull
        public final ResponseBody create(@NotNull BufferedSource asResponseBody, @Nullable MediaType mediaType, long j) {
            l.e(asResponseBody, "$this$asResponseBody");
            return new ResponseBody$Companion$asResponseBody$1(asResponseBody, mediaType, j);
        }

        @NotNull
        public final ResponseBody create(@NotNull ByteString toResponseBody, @Nullable MediaType mediaType) {
            l.e(toResponseBody, "$this$toResponseBody");
            return create(new Buffer().write(toResponseBody), mediaType, toResponseBody.size());
        }

        @NotNull
        public final ResponseBody create(@NotNull byte[] toResponseBody, @Nullable MediaType mediaType) {
            l.e(toResponseBody, "$this$toResponseBody");
            return create(new Buffer().write(toResponseBody), mediaType, toResponseBody.length);
        }
    }

    private final Charset charset() {
        Charset charset;
        MediaType contentType = contentType();
        return (contentType == null || (charset = contentType.charset(c.b)) == null) ? c.b : charset;
    }

    private final Object consumeSource(w8.l lVar, w8.l lVar2) {
        long contentLength = contentLength();
        if (contentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        BufferedSource source = source();
        try {
            Object invoke = lVar.invoke(source);
            k.b(1);
            u8.a.a(source, null);
            k.a(1);
            int intValue = ((Number) lVar2.invoke(invoke)).intValue();
            if (contentLength == -1 || contentLength == intValue) {
                return invoke;
            }
            throw new IOException("Content-Length (" + contentLength + ") and stream length (" + intValue + ") disagree");
        } finally {
        }
    }

    @NotNull
    public static final ResponseBody create(@NotNull String str, @Nullable MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    @NotNull
    public final InputStream byteStream() {
        return source().inputStream();
    }

    @NotNull
    public final ByteString byteString() throws IOException {
        long contentLength = contentLength();
        if (contentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        BufferedSource source = source();
        try {
            ByteString readByteString = source.readByteString();
            u8.a.a(source, null);
            int size = readByteString.size();
            if (contentLength == -1 || contentLength == size) {
                return readByteString;
            }
            throw new IOException("Content-Length (" + contentLength + ") and stream length (" + size + ") disagree");
        } finally {
        }
    }

    @NotNull
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        BufferedSource source = source();
        try {
            byte[] readByteArray = source.readByteArray();
            u8.a.a(source, null);
            int length = readByteArray.length;
            if (contentLength == -1 || contentLength == length) {
                return readByteArray;
            }
            throw new IOException("Content-Length (" + contentLength + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }

    @NotNull
    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    @NotNull
    public abstract BufferedSource source();

    @NotNull
    public final String string() throws IOException {
        BufferedSource source = source();
        try {
            String readString = source.readString(Util.readBomAsCharset(source, charset()));
            u8.a.a(source, null);
            return readString;
        } finally {
        }
    }

    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType, long j, @NotNull BufferedSource bufferedSource) {
        return Companion.create(mediaType, j, bufferedSource);
    }

    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType, @NotNull String str) {
        return Companion.create(mediaType, str);
    }

    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType, @NotNull ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    @NotNull
    public static final ResponseBody create(@NotNull BufferedSource bufferedSource, @Nullable MediaType mediaType, long j) {
        return Companion.create(bufferedSource, mediaType, j);
    }

    @NotNull
    public static final ResponseBody create(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    @NotNull
    public static final ResponseBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }
}
