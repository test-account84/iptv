package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RealBufferedSink implements BufferedSink {

    @NotNull
    public final Buffer bufferField;
    public boolean closed;

    @NotNull
    public final Sink sink;

    public static final class 1 extends OutputStream {
        public 1() {
        }

        public void close() {
            RealBufferedSink.this.close();
        }

        public void flush() {
            RealBufferedSink realBufferedSink = RealBufferedSink.this;
            if (realBufferedSink.closed) {
                return;
            }
            realBufferedSink.flush();
        }

        @NotNull
        public String toString() {
            return RealBufferedSink.this + ".outputStream()";
        }

        public void write(int i) {
            RealBufferedSink realBufferedSink = RealBufferedSink.this;
            if (realBufferedSink.closed) {
                throw new IOException("closed");
            }
            realBufferedSink.bufferField.writeByte((int) ((byte) i));
            RealBufferedSink.this.emitCompleteSegments();
        }

        public void write(@NotNull byte[] data, int i, int i2) {
            l.e(data, "data");
            RealBufferedSink realBufferedSink = RealBufferedSink.this;
            if (realBufferedSink.closed) {
                throw new IOException("closed");
            }
            realBufferedSink.bufferField.write(data, i, i2);
            RealBufferedSink.this.emitCompleteSegments();
        }
    }

    public RealBufferedSink(@NotNull Sink sink) {
        l.e(sink, "sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    public void close() {
        if (this.closed) {
            return;
        }
        try {
            if (this.bufferField.size() > 0) {
                Sink sink = this.sink;
                Buffer buffer = this.bufferField;
                sink.write(buffer, buffer.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @NotNull
    public BufferedSink emit() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = this.bufferField.size();
        if (size > 0) {
            this.sink.write(this.bufferField, size);
        }
        return this;
    }

    @NotNull
    public BufferedSink emitCompleteSegments() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            this.sink.write(this.bufferField, completeSegmentByteCount);
        }
        return this;
    }

    public void flush() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.size() > 0) {
            Sink sink = this.sink;
            Buffer buffer = this.bufferField;
            sink.write(buffer, buffer.size());
        }
        this.sink.flush();
    }

    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    public boolean isOpen() {
        return !this.closed;
    }

    @NotNull
    public OutputStream outputStream() {
        return new 1();
    }

    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    public int write(@NotNull ByteBuffer source) {
        l.e(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        int write = this.bufferField.write(source);
        emitCompleteSegments();
        return write;
    }

    public long writeAll(@NotNull Source source) {
        l.e(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(this.bufferField, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
            emitCompleteSegments();
        }
    }

    @NotNull
    public BufferedSink writeByte(int i) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeByte(i);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeDecimalLong(long j) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeDecimalLong(j);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeHexadecimalUnsignedLong(long j) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeHexadecimalUnsignedLong(j);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeInt(int i) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeInt(i);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeIntLe(int i) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeIntLe(i);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeLong(long j) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeLong(j);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeLongLe(long j) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeLongLe(j);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeShort(int i) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeShort(i);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeShortLe(int i) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeShortLe(i);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeString(@NotNull String string, int i, int i2, @NotNull Charset charset) {
        l.e(string, "string");
        l.e(charset, "charset");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeString(string, i, i2, charset);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeUtf8(@NotNull String string) {
        l.e(string, "string");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeUtf8(string);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeUtf8CodePoint(int i) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeUtf8CodePoint(i);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink write(@NotNull ByteString byteString) {
        l.e(byteString, "byteString");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(byteString);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeString(@NotNull String string, @NotNull Charset charset) {
        l.e(string, "string");
        l.e(charset, "charset");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeString(string, charset);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink writeUtf8(@NotNull String string, int i, int i2) {
        l.e(string, "string");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeUtf8(string, i, i2);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink write(@NotNull ByteString byteString, int i, int i2) {
        l.e(byteString, "byteString");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(byteString, i, i2);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink write(@NotNull Source source, long j) {
        l.e(source, "source");
        while (j > 0) {
            long read = source.read(this.bufferField, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
            emitCompleteSegments();
        }
        return this;
    }

    @NotNull
    public BufferedSink write(@NotNull byte[] source) {
        l.e(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source);
        return emitCompleteSegments();
    }

    @NotNull
    public BufferedSink write(@NotNull byte[] source, int i, int i2) {
        l.e(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source, i, i2);
        return emitCompleteSegments();
    }

    public void write(@NotNull Buffer source, long j) {
        l.e(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source, j);
        emitCompleteSegments();
    }
}
