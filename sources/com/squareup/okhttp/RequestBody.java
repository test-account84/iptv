package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class RequestBody {

    public static class 1 extends RequestBody {
        final /* synthetic */ ByteString val$content;
        final /* synthetic */ MediaType val$contentType;

        public 1(MediaType mediaType, ByteString byteString) {
            this.val$contentType = mediaType;
            this.val$content = byteString;
        }

        public long contentLength() throws IOException {
            return this.val$content.size();
        }

        public MediaType contentType() {
            return this.val$contentType;
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.val$content);
        }
    }

    public static class 2 extends RequestBody {
        final /* synthetic */ int val$byteCount;
        final /* synthetic */ byte[] val$content;
        final /* synthetic */ MediaType val$contentType;
        final /* synthetic */ int val$offset;

        public 2(MediaType mediaType, int i, byte[] bArr, int i2) {
            this.val$contentType = mediaType;
            this.val$byteCount = i;
            this.val$content = bArr;
            this.val$offset = i2;
        }

        public long contentLength() {
            return this.val$byteCount;
        }

        public MediaType contentType() {
            return this.val$contentType;
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.val$content, this.val$offset, this.val$byteCount);
        }
    }

    public static class 3 extends RequestBody {
        final /* synthetic */ MediaType val$contentType;
        final /* synthetic */ File val$file;

        public 3(MediaType mediaType, File file) {
            this.val$contentType = mediaType;
            this.val$file = file;
        }

        public long contentLength() {
            return this.val$file.length();
        }

        public MediaType contentType() {
            return this.val$contentType;
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            Source source = null;
            try {
                source = Okio.source(this.val$file);
                bufferedSink.writeAll(source);
            } finally {
                Util.closeQuietly(source);
            }
        }
    }

    public static RequestBody create(MediaType mediaType, File file) {
        if (file != null) {
            return new 3(mediaType, file);
        }
        throw new NullPointerException("content == null");
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(MediaType mediaType, ByteString byteString) {
        return new 1(mediaType, byteString);
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        Util.checkOffsetAndCount(bArr.length, i, i2);
        return new 2(mediaType, i2, bArr, i);
    }
}
