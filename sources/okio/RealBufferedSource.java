package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.l;
import okio.internal.BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RealBufferedSource implements BufferedSource {

    @NotNull
    public final Buffer bufferField;
    public boolean closed;

    @NotNull
    public final Source source;

    public static final class 1 extends InputStream {
        public 1() {
        }

        public int available() {
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            if (realBufferedSource.closed) {
                throw new IOException("closed");
            }
            return (int) Math.min(realBufferedSource.bufferField.size(), Integer.MAX_VALUE);
        }

        public void close() {
            RealBufferedSource.this.close();
        }

        public int read() {
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            if (realBufferedSource.closed) {
                throw new IOException("closed");
            }
            if (realBufferedSource.bufferField.size() == 0) {
                RealBufferedSource realBufferedSource2 = RealBufferedSource.this;
                if (realBufferedSource2.source.read(realBufferedSource2.bufferField, 8192) == -1) {
                    return -1;
                }
            }
            return RealBufferedSource.this.bufferField.readByte() & 255;
        }

        @NotNull
        public String toString() {
            return RealBufferedSource.this + ".inputStream()";
        }

        public int read(@NotNull byte[] data, int i, int i2) {
            l.e(data, "data");
            if (RealBufferedSource.this.closed) {
                throw new IOException("closed");
            }
            -Util.checkOffsetAndCount(data.length, i, i2);
            if (RealBufferedSource.this.bufferField.size() == 0) {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                    return -1;
                }
            }
            return RealBufferedSource.this.bufferField.read(data, i, i2);
        }
    }

    public RealBufferedSource(@NotNull Source source) {
        l.e(source, "source");
        this.source = source;
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
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    public boolean exhausted() {
        if (!this.closed) {
            return this.bufferField.exhausted() && this.source.read(this.bufferField, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    public long indexOfElement(@NotNull ByteString targetBytes) {
        l.e(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @NotNull
    public InputStream inputStream() {
        return new 1();
    }

    public boolean isOpen() {
        return !this.closed;
    }

    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    public boolean rangeEquals(long j, @NotNull ByteString bytes) {
        l.e(bytes, "bytes");
        return rangeEquals(j, bytes, 0, bytes.size());
    }

    public int read(@NotNull ByteBuffer sink) {
        l.e(sink, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }

    public long readAll(@NotNull Sink sink) {
        Buffer buffer;
        l.e(sink, "sink");
        long j = 0;
        while (true) {
            long read = this.source.read(this.bufferField, 8192);
            buffer = this.bufferField;
            if (read == -1) {
                break;
            }
            long completeSegmentByteCount = buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j += completeSegmentByteCount;
                sink.write(this.bufferField, completeSegmentByteCount);
            }
        }
        if (buffer.size() <= 0) {
            return j;
        }
        long size = j + this.bufferField.size();
        Buffer buffer2 = this.bufferField;
        sink.write(buffer2, buffer2.size());
        return size;
    }

    public byte readByte() {
        require(1L);
        return this.bufferField.readByte();
    }

    @NotNull
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @NotNull
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("Expected leading [0-9] or '-' character but was 0x");
        r2 = java.lang.Integer.toString(r8, E8.a.a(E8.a.a(16)));
        kotlin.jvm.internal.l.d(r2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        r1.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        throw new java.lang.NumberFormatException(r1.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() {
        /*
            r10 = this;
            r0 = 1
            r10.require(r0)
            r2 = 0
            r4 = r2
        L8:
            long r6 = r4 + r0
            boolean r8 = r10.request(r6)
            if (r8 == 0) goto L59
            okio.Buffer r8 = r10.bufferField
            byte r8 = r8.getByte(r4)
            r9 = 48
            byte r9 = (byte) r9
            if (r8 < r9) goto L20
            r9 = 57
            byte r9 = (byte) r9
            if (r8 <= r9) goto L2a
        L20:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L2c
            r4 = 45
            byte r4 = (byte) r4
            if (r8 == r4) goto L2a
            goto L2c
        L2a:
            r4 = r6
            goto L8
        L2c:
            if (r9 == 0) goto L2f
            goto L59
        L2f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            r1.append(r2)
            r2 = 16
            int r2 = E8.a.a(r2)
            int r2 = E8.a.a(r2)
            java.lang.String r2 = java.lang.Integer.toString(r8, r2)
            java.lang.String r3 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.l.d(r2, r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L59:
            okio.Buffer r0 = r10.bufferField
            long r0 = r0.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.readDecimalLong():long");
    }

    public void readFully(@NotNull Buffer sink, long j) {
        l.e(sink, "sink");
        try {
            require(j);
            this.bufferField.readFully(sink, j);
        } catch (EOFException e) {
            sink.writeAll(this.bufferField);
            throw e;
        }
    }

    public long readHexadecimalUnsignedLong() {
        byte b;
        require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request(i2)) {
                break;
            }
            b = this.bufferField.getByte(i);
            if ((b < ((byte) 48) || b > ((byte) 57)) && ((b < ((byte) 97) || b > ((byte) 102)) && (b < ((byte) 65) || b > ((byte) 70)))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            String num = Integer.toString(b, E8.a.a(E8.a.a(16)));
            l.d(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(num);
            throw new NumberFormatException(sb.toString());
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    public int readInt() {
        require(4L);
        return this.bufferField.readInt();
    }

    public int readIntLe() {
        require(4L);
        return this.bufferField.readIntLe();
    }

    public long readLong() {
        require(8L);
        return this.bufferField.readLong();
    }

    public long readLongLe() {
        require(8L);
        return this.bufferField.readLongLe();
    }

    public short readShort() {
        require(2L);
        return this.bufferField.readShort();
    }

    public short readShortLe() {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @NotNull
    public String readString(long j, @NotNull Charset charset) {
        l.e(charset, "charset");
        require(j);
        return this.bufferField.readString(j, charset);
    }

    @NotNull
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    public int readUtf8CodePoint() {
        long j;
        require(1L);
        byte b = this.bufferField.getByte(0L);
        if ((b & 224) == 192) {
            j = 2;
        } else {
            if ((b & 240) != 224) {
                if ((b & 248) == 240) {
                    j = 4;
                }
                return this.bufferField.readUtf8CodePoint();
            }
            j = 3;
        }
        require(j);
        return this.bufferField.readUtf8CodePoint();
    }

    @Nullable
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(this.bufferField, indexOf);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    @NotNull
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j) {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.bufferField.size() < j) {
            if (this.source.read(this.bufferField, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    public void require(long j) {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    public int select(@NotNull Options options) {
        l.e(options, "options");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            int selectPrefix = BufferKt.selectPrefix(this.bufferField, options, true);
            if (selectPrefix != -2) {
                if (selectPrefix != -1) {
                    this.bufferField.skip(options.getByteStrings$okio()[selectPrefix].size());
                    return selectPrefix;
                }
            } else if (this.source.read(this.bufferField, 8192) == -1) {
                break;
            }
        }
        return -1;
    }

    public void skip(long j) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j > 0) {
            if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.bufferField.size());
            this.bufferField.skip(min);
            j -= min;
        }
    }

    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.source + ')';
    }

    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    public long indexOfElement(@NotNull ByteString targetBytes, long j) {
        l.e(targetBytes, "targetBytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOfElement = this.bufferField.indexOfElement(targetBytes, j);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, size);
        }
    }

    public boolean rangeEquals(long j, @NotNull ByteString bytes, int i, int i2) {
        int i3;
        l.e(bytes, "bytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j >= 0 && i >= 0 && i2 >= 0 && bytes.size() - i >= i2) {
            while (i3 < i2) {
                long j2 = i3 + j;
                i3 = (request(1 + j2) && this.bufferField.getByte(j2) == bytes.getByte(i + i3)) ? i3 + 1 : 0;
            }
            return true;
        }
        return false;
    }

    public int read(@NotNull byte[] sink) {
        l.e(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @NotNull
    public byte[] readByteArray(long j) {
        require(j);
        return this.bufferField.readByteArray(j);
    }

    @NotNull
    public ByteString readByteString(long j) {
        require(j);
        return this.bufferField.readByteString(j);
    }

    public void readFully(@NotNull byte[] sink) {
        l.e(sink, "sink");
        try {
            require(sink.length);
            this.bufferField.readFully(sink);
        } catch (EOFException e) {
            int i = 0;
            while (this.bufferField.size() > 0) {
                Buffer buffer = this.bufferField;
                int read = buffer.read(sink, i, (int) buffer.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
            throw e;
        }
    }

    @NotNull
    public String readString(@NotNull Charset charset) {
        l.e(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @NotNull
    public String readUtf8(long j) {
        require(j);
        return this.bufferField.readUtf8(j);
    }

    @NotNull
    public String readUtf8LineStrict(long j) {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        byte b = (byte) 10;
        long indexOf = indexOf(b, 0L, j2);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(this.bufferField, indexOf);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && this.bufferField.getByte(j2 - 1) == ((byte) 13) && request(1 + j2) && this.bufferField.getByte(j2) == b) {
            return BufferKt.readUtf8Line(this.bufferField, j2);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), j) + " content=" + buffer.readByteString().hex() + "…");
    }

    public long indexOf(byte b, long j, long j2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long indexOf = this.bufferField.indexOf(b, j, j2);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = this.bufferField.size();
            if (size >= j2 || this.source.read(this.bufferField, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, size);
        }
        return -1L;
    }

    public int read(@NotNull byte[] sink, int i, int i2) {
        l.e(sink, "sink");
        long j = i2;
        -Util.checkOffsetAndCount(sink.length, i, j);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(sink, i, (int) Math.min(j, this.bufferField.size()));
    }

    public long indexOf(@NotNull ByteString bytes) {
        l.e(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    public long read(@NotNull Buffer sink, long j) {
        l.e(sink, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(true ^ this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
            return -1L;
        }
        return this.bufferField.read(sink, Math.min(j, this.bufferField.size()));
    }

    public long indexOf(@NotNull ByteString bytes, long j) {
        l.e(bytes, "bytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOf = this.bufferField.indexOf(bytes, j);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, (size - bytes.size()) + 1);
        }
    }
}
