package okio.internal;

import java.io.EOFException;
import kotlin.jvm.internal.l;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RealBufferedSinkKt {
    public static final void commonClose(@NotNull RealBufferedSink commonClose) {
        l.e(commonClose, "$this$commonClose");
        if (commonClose.closed) {
            return;
        }
        try {
            if (commonClose.bufferField.size() > 0) {
                Sink sink = commonClose.sink;
                Buffer buffer = commonClose.bufferField;
                sink.write(buffer, buffer.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            commonClose.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        commonClose.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @NotNull
    public static final BufferedSink commonEmit(@NotNull RealBufferedSink commonEmit) {
        l.e(commonEmit, "$this$commonEmit");
        if (!(!commonEmit.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = commonEmit.bufferField.size();
        if (size > 0) {
            commonEmit.sink.write(commonEmit.bufferField, size);
        }
        return commonEmit;
    }

    @NotNull
    public static final BufferedSink commonEmitCompleteSegments(@NotNull RealBufferedSink commonEmitCompleteSegments) {
        l.e(commonEmitCompleteSegments, "$this$commonEmitCompleteSegments");
        if (!(!commonEmitCompleteSegments.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long completeSegmentByteCount = commonEmitCompleteSegments.bufferField.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            commonEmitCompleteSegments.sink.write(commonEmitCompleteSegments.bufferField, completeSegmentByteCount);
        }
        return commonEmitCompleteSegments;
    }

    public static final void commonFlush(@NotNull RealBufferedSink commonFlush) {
        l.e(commonFlush, "$this$commonFlush");
        if (!(!commonFlush.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (commonFlush.bufferField.size() > 0) {
            Sink sink = commonFlush.sink;
            Buffer buffer = commonFlush.bufferField;
            sink.write(buffer, buffer.size());
        }
        commonFlush.sink.flush();
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSink commonTimeout) {
        l.e(commonTimeout, "$this$commonTimeout");
        return commonTimeout.sink.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSink commonToString) {
        l.e(commonToString, "$this$commonToString");
        return "buffer(" + commonToString.sink + ')';
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull ByteString byteString) {
        l.e(commonWrite, "$this$commonWrite");
        l.e(byteString, "byteString");
        if (!(!commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.bufferField.write(byteString);
        return commonWrite.emitCompleteSegments();
    }

    public static final long commonWriteAll(@NotNull RealBufferedSink commonWriteAll, @NotNull Source source) {
        l.e(commonWriteAll, "$this$commonWriteAll");
        l.e(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(commonWriteAll.bufferField, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
            commonWriteAll.emitCompleteSegments();
        }
    }

    @NotNull
    public static final BufferedSink commonWriteByte(@NotNull RealBufferedSink commonWriteByte, int i) {
        l.e(commonWriteByte, "$this$commonWriteByte");
        if (!(!commonWriteByte.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteByte.bufferField.writeByte(i);
        return commonWriteByte.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteDecimalLong(@NotNull RealBufferedSink commonWriteDecimalLong, long j) {
        l.e(commonWriteDecimalLong, "$this$commonWriteDecimalLong");
        if (!(!commonWriteDecimalLong.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteDecimalLong.bufferField.writeDecimalLong(j);
        return commonWriteDecimalLong.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteHexadecimalUnsignedLong(@NotNull RealBufferedSink commonWriteHexadecimalUnsignedLong, long j) {
        l.e(commonWriteHexadecimalUnsignedLong, "$this$commonWriteHexadecimalUnsignedLong");
        if (!(!commonWriteHexadecimalUnsignedLong.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteHexadecimalUnsignedLong.bufferField.writeHexadecimalUnsignedLong(j);
        return commonWriteHexadecimalUnsignedLong.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteInt(@NotNull RealBufferedSink commonWriteInt, int i) {
        l.e(commonWriteInt, "$this$commonWriteInt");
        if (!(!commonWriteInt.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteInt.bufferField.writeInt(i);
        return commonWriteInt.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteIntLe(@NotNull RealBufferedSink commonWriteIntLe, int i) {
        l.e(commonWriteIntLe, "$this$commonWriteIntLe");
        if (!(!commonWriteIntLe.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteIntLe.bufferField.writeIntLe(i);
        return commonWriteIntLe.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteLong(@NotNull RealBufferedSink commonWriteLong, long j) {
        l.e(commonWriteLong, "$this$commonWriteLong");
        if (!(!commonWriteLong.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteLong.bufferField.writeLong(j);
        return commonWriteLong.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteLongLe(@NotNull RealBufferedSink commonWriteLongLe, long j) {
        l.e(commonWriteLongLe, "$this$commonWriteLongLe");
        if (!(!commonWriteLongLe.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteLongLe.bufferField.writeLongLe(j);
        return commonWriteLongLe.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteShort(@NotNull RealBufferedSink commonWriteShort, int i) {
        l.e(commonWriteShort, "$this$commonWriteShort");
        if (!(!commonWriteShort.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteShort.bufferField.writeShort(i);
        return commonWriteShort.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteShortLe(@NotNull RealBufferedSink commonWriteShortLe, int i) {
        l.e(commonWriteShortLe, "$this$commonWriteShortLe");
        if (!(!commonWriteShortLe.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteShortLe.bufferField.writeShortLe(i);
        return commonWriteShortLe.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink commonWriteUtf8, @NotNull String string) {
        l.e(commonWriteUtf8, "$this$commonWriteUtf8");
        l.e(string, "string");
        if (!(!commonWriteUtf8.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteUtf8.bufferField.writeUtf8(string);
        return commonWriteUtf8.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8CodePoint(@NotNull RealBufferedSink commonWriteUtf8CodePoint, int i) {
        l.e(commonWriteUtf8CodePoint, "$this$commonWriteUtf8CodePoint");
        if (!(!commonWriteUtf8CodePoint.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteUtf8CodePoint.bufferField.writeUtf8CodePoint(i);
        return commonWriteUtf8CodePoint.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull ByteString byteString, int i, int i2) {
        l.e(commonWrite, "$this$commonWrite");
        l.e(byteString, "byteString");
        if (!(!commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.bufferField.write(byteString, i, i2);
        return commonWrite.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink commonWriteUtf8, @NotNull String string, int i, int i2) {
        l.e(commonWriteUtf8, "$this$commonWriteUtf8");
        l.e(string, "string");
        if (!(!commonWriteUtf8.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteUtf8.bufferField.writeUtf8(string, i, i2);
        return commonWriteUtf8.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull Source source, long j) {
        l.e(commonWrite, "$this$commonWrite");
        l.e(source, "source");
        while (j > 0) {
            long read = source.read(commonWrite.bufferField, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
            commonWrite.emitCompleteSegments();
        }
        return commonWrite;
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull byte[] source) {
        l.e(commonWrite, "$this$commonWrite");
        l.e(source, "source");
        if (!(!commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.bufferField.write(source);
        return commonWrite.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull byte[] source, int i, int i2) {
        l.e(commonWrite, "$this$commonWrite");
        l.e(source, "source");
        if (!(!commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.bufferField.write(source, i, i2);
        return commonWrite.emitCompleteSegments();
    }

    public static final void commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull Buffer source, long j) {
        l.e(commonWrite, "$this$commonWrite");
        l.e(source, "source");
        if (!(!commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.bufferField.write(source, j);
        commonWrite.emitCompleteSegments();
    }
}
