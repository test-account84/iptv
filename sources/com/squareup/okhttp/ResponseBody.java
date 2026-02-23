package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class ResponseBody implements Closeable {
    private Reader reader;

    public static class 1 extends ResponseBody {
        final /* synthetic */ BufferedSource val$content;
        final /* synthetic */ long val$contentLength;
        final /* synthetic */ MediaType val$contentType;

        public 1(MediaType mediaType, long j, BufferedSource bufferedSource) {
            this.val$contentType = mediaType;
            this.val$contentLength = j;
            this.val$content = bufferedSource;
        }

        public long contentLength() {
            return this.val$contentLength;
        }

        public MediaType contentType() {
            return this.val$contentType;
        }

        public BufferedSource source() {
            return this.val$content;
        }
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public static ResponseBody create(MediaType mediaType, long j, BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new 1(mediaType, j, bufferedSource);
        }
        throw new NullPointerException("source == null");
    }

    public final InputStream byteStream() throws IOException {
        return source().inputStream();
    }

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        BufferedSource source = source();
        try {
            byte[] readByteArray = source.readByteArray();
            Util.closeQuietly(source);
            if (contentLength == -1 || contentLength == readByteArray.length) {
                return readByteArray;
            }
            throw new IOException("Content-Length and stream length disagree");
        } catch (Throwable th) {
            Util.closeQuietly(source);
            throw th;
        }
    }

    public final Reader charStream() throws IOException {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(byteStream(), charset());
        this.reader = inputStreamReader;
        return inputStreamReader;
    }

    public void close() throws IOException {
        source().close();
    }

    public abstract long contentLength() throws IOException;

    public abstract MediaType contentType();

    public abstract BufferedSource source() throws IOException;

    public final String string() throws IOException {
        return new String(bytes(), charset().name());
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        Buffer writeString = new Buffer().writeString(str, charset);
        return create(mediaType, writeString.size(), writeString);
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr.length, new Buffer().write(bArr));
    }
}
