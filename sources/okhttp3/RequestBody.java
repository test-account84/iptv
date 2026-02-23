package okhttp3;

import E8.c;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class RequestBody {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        @NotNull
        public final RequestBody create(@NotNull File asRequestBody, @Nullable MediaType mediaType) {
            l.e(asRequestBody, "$this$asRequestBody");
            return new RequestBody$Companion$asRequestBody$1(asRequestBody, mediaType);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @NotNull
        public final RequestBody create(@NotNull String toRequestBody, @Nullable MediaType mediaType) {
            l.e(toRequestBody, "$this$toRequestBody");
            Charset charset = c.b;
            if (mediaType != null) {
                Charset charset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charset$default;
                }
            }
            byte[] bytes = toRequestBody.getBytes(charset);
            l.d(bytes, "(this as java.lang.String).getBytes(charset)");
            return create(bytes, mediaType, 0, bytes.length);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return companion.create(mediaType, bArr, i, i2);
        }

        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull File file) {
            l.e(file, "file");
            return create(file, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull String content) {
            l.e(content, "content");
            return create(content, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return companion.create(bArr, mediaType, i, i2);
        }

        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull ByteString content) {
            l.e(content, "content");
            return create(content, mediaType);
        }

        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr) {
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr, int i) {
            return create$default(this, mediaType, bArr, i, 0, 8, (Object) null);
        }

        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] content, int i, int i2) {
            l.e(content, "content");
            return create(content, mediaType, i, i2);
        }

        @NotNull
        public final RequestBody create(@NotNull ByteString toRequestBody, @Nullable MediaType mediaType) {
            l.e(toRequestBody, "$this$toRequestBody");
            return new RequestBody$Companion$toRequestBody$1(toRequestBody, mediaType);
        }

        @NotNull
        public final RequestBody create(@NotNull byte[] bArr) {
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        @NotNull
        public final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        @NotNull
        public final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i) {
            return create$default(this, bArr, mediaType, i, 0, 4, (Object) null);
        }

        @NotNull
        public final RequestBody create(@NotNull byte[] toRequestBody, @Nullable MediaType mediaType, int i, int i2) {
            l.e(toRequestBody, "$this$toRequestBody");
            Util.checkOffsetAndCount(toRequestBody.length, i, i2);
            return new RequestBody$Companion$toRequestBody$2(toRequestBody, mediaType, i2, i);
        }
    }

    @NotNull
    public static final RequestBody create(@NotNull File file, @Nullable MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    @Nullable
    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(@NotNull BufferedSink bufferedSink) throws IOException;

    @NotNull
    public static final RequestBody create(@NotNull String str, @Nullable MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull File file) {
        return Companion.create(mediaType, file);
    }

    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull String str) {
        return Companion.create(mediaType, str);
    }

    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr) {
        return Companion.create$default(Companion, mediaType, bArr, 0, 0, 12, (Object) null);
    }

    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr, int i) {
        return Companion.create$default(Companion, mediaType, bArr, i, 0, 8, (Object) null);
    }

    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr, int i, int i2) {
        return Companion.create(mediaType, bArr, i, i2);
    }

    @NotNull
    public static final RequestBody create(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    @NotNull
    public static final RequestBody create(@NotNull byte[] bArr) {
        return Companion.create$default(Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
    }

    @NotNull
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
        return Companion.create$default(Companion, bArr, mediaType, 0, 0, 6, (Object) null);
    }

    @NotNull
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i) {
        return Companion.create$default(Companion, bArr, mediaType, i, 0, 4, (Object) null);
    }

    @NotNull
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i, int i2) {
        return Companion.create(bArr, mediaType, i, i2);
    }
}
