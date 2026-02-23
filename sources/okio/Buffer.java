package okio;

import E8.c;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.l;
import l8.g;
import okio.internal.BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    @Nullable
    public Segment head;
    private long size;

    public static final class UnsafeCursor implements Closeable {

        @Nullable
        public Buffer buffer;

        @Nullable
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        public void close() {
            if (!(this.buffer != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i) {
            if (!(i > 0)) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i).toString());
            }
            if (!(i <= 8192)) {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i).toString());
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
            }
            long size = buffer.size();
            Segment writableSegment$okio = buffer.writableSegment$okio(i);
            int i2 = 8192 - writableSegment$okio.limit;
            writableSegment$okio.limit = 8192;
            long j = i2;
            buffer.setSize$okio(size + j);
            this.segment = writableSegment$okio;
            this.offset = size;
            this.data = writableSegment$okio.data;
            this.start = 8192 - i2;
            this.end = 8192;
            return j;
        }

        public final int next() {
            long j = this.offset;
            Buffer buffer = this.buffer;
            l.b(buffer);
            if (!(j != buffer.size())) {
                throw new IllegalStateException("no more bytes".toString());
            }
            long j2 = this.offset;
            return seek(j2 == -1 ? 0L : j2 + (this.end - this.start));
        }

        public final long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long size = buffer.size();
            int i = 1;
            if (j <= size) {
                if (!(j >= 0)) {
                    throw new IllegalArgumentException(("newSize < 0: " + j).toString());
                }
                long j2 = size - j;
                while (true) {
                    if (j2 <= 0) {
                        break;
                    }
                    Segment segment = buffer.head;
                    l.b(segment);
                    Segment segment2 = segment.prev;
                    l.b(segment2);
                    int i2 = segment2.limit;
                    long j3 = i2 - segment2.pos;
                    if (j3 > j2) {
                        segment2.limit = i2 - ((int) j2);
                        break;
                    }
                    buffer.head = segment2.pop();
                    SegmentPool.recycle(segment2);
                    j2 -= j3;
                }
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j > size) {
                long j4 = j - size;
                boolean z = true;
                while (j4 > 0) {
                    Segment writableSegment$okio = buffer.writableSegment$okio(i);
                    int min = (int) Math.min(j4, 8192 - writableSegment$okio.limit);
                    int i3 = writableSegment$okio.limit + min;
                    writableSegment$okio.limit = i3;
                    j4 -= min;
                    if (z) {
                        this.segment = writableSegment$okio;
                        this.offset = size;
                        this.data = writableSegment$okio.data;
                        this.start = i3 - min;
                        this.end = i3;
                        z = false;
                    }
                    i = 1;
                }
            }
            buffer.setSize$okio(j);
            return size;
        }

        public final int seek(long j) {
            Segment segment;
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (j < -1 || j > buffer.size()) {
                E e = E.a;
                String format = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j), Long.valueOf(buffer.size())}, 2));
                l.d(format, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(format);
            }
            if (j == -1 || j == buffer.size()) {
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long size = buffer.size();
            Segment segment2 = buffer.head;
            Segment segment3 = this.segment;
            long j2 = 0;
            if (segment3 != null) {
                long j3 = this.offset;
                int i = this.start;
                l.b(segment3);
                long j4 = j3 - (i - segment3.pos);
                if (j4 > j) {
                    segment = segment2;
                    segment2 = this.segment;
                    size = j4;
                } else {
                    segment = this.segment;
                    j2 = j4;
                }
            } else {
                segment = segment2;
            }
            if (size - j > j - j2) {
                while (true) {
                    l.b(segment);
                    int i2 = segment.limit;
                    int i3 = segment.pos;
                    if (j < (i2 - i3) + j2) {
                        break;
                    }
                    j2 += i2 - i3;
                    segment = segment.next;
                }
            } else {
                while (size > j) {
                    l.b(segment2);
                    segment2 = segment2.prev;
                    l.b(segment2);
                    size -= segment2.limit - segment2.pos;
                }
                segment = segment2;
                j2 = size;
            }
            if (this.readWrite) {
                l.b(segment);
                if (segment.shared) {
                    Segment unsharedCopy = segment.unsharedCopy();
                    if (buffer.head == segment) {
                        buffer.head = unsharedCopy;
                    }
                    segment = segment.push(unsharedCopy);
                    Segment segment4 = segment.prev;
                    l.b(segment4);
                    segment4.pop();
                }
            }
            this.segment = segment;
            this.offset = j;
            l.b(segment);
            this.data = segment.data;
            int i4 = segment.pos + ((int) (j - j2));
            this.start = i4;
            int i5 = segment.limit;
            this.end = i5;
            return i5 - i4;
        }
    }

    public static final class 1 extends InputStream {
        public 1() {
        }

        public int available() {
            return (int) Math.min(Buffer.this.size(), Integer.MAX_VALUE);
        }

        public void close() {
        }

        public int read() {
            if (Buffer.this.size() > 0) {
                return Buffer.this.readByte() & 255;
            }
            return -1;
        }

        @NotNull
        public String toString() {
            return Buffer.this + ".inputStream()";
        }

        public int read(@NotNull byte[] sink, int i, int i2) {
            l.e(sink, "sink");
            return Buffer.this.read(sink, i, i2);
        }
    }

    public static final class 1 extends OutputStream {
        public 1() {
        }

        public void close() {
        }

        public void flush() {
        }

        @NotNull
        public String toString() {
            return Buffer.this + ".outputStream()";
        }

        public void write(int i) {
            Buffer.this.writeByte(i);
        }

        public void write(@NotNull byte[] data, int i, int i2) {
            l.e(data, "data");
            Buffer.this.write(data, i, i2);
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j, long j2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = buffer.size - j3;
        }
        return buffer.copyTo(outputStream, j3, j2);
    }

    private final ByteString digest(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i = segment.pos;
            messageDigest.update(bArr, i, segment.limit - i);
            Segment segment2 = segment.next;
            while (true) {
                l.b(segment2);
                if (segment2 == segment) {
                    break;
                }
                byte[] bArr2 = segment2.data;
                int i2 = segment2.pos;
                messageDigest.update(bArr2, i2, segment2.limit - i2);
                segment2 = segment2.next;
            }
        }
        byte[] digest = messageDigest.digest();
        l.d(digest, "messageDigest.digest()");
        return new ByteString(digest);
    }

    private final ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i = segment.pos;
                mac.update(bArr, i, segment.limit - i);
                Segment segment2 = segment.next;
                while (true) {
                    l.b(segment2);
                    if (segment2 == segment) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i2 = segment2.pos;
                    mac.update(bArr2, i2, segment2.limit - i2);
                    segment2 = segment2.next;
                }
            }
            byte[] doFinal = mac.doFinal();
            l.d(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = buffer.size;
        }
        return buffer.writeTo(outputStream, j);
    }

    public final byte -deprecated_getByte(long j) {
        return getByte(j);
    }

    public final long -deprecated_size() {
        return this.size;
    }

    @NotNull
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        skip(size());
    }

    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.head;
        l.b(segment);
        Segment segment2 = segment.prev;
        l.b(segment2);
        if (segment2.limit < 8192 && segment2.owner) {
            size -= r3 - segment2.pos;
        }
        return size;
    }

    @NotNull
    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            l.b(segment);
            Segment sharedCopy = segment.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = sharedCopy;
            sharedCopy.next = sharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = sharedCopy.prev;
                l.b(segment3);
                l.b(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream) throws IOException {
        return copyTo$default(this, outputStream, 0L, 0L, 6, (Object) null);
    }

    @NotNull
    public Buffer emit() {
        return this;
    }

    @NotNull
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            if (size() == buffer.size()) {
                if (size() == 0) {
                    return true;
                }
                Segment segment = this.head;
                l.b(segment);
                Segment segment2 = buffer.head;
                l.b(segment2);
                int i = segment.pos;
                int i2 = segment2.pos;
                long j = 0;
                while (j < size()) {
                    long min = Math.min(segment.limit - i, segment2.limit - i2);
                    long j2 = 0;
                    while (j2 < min) {
                        int i3 = i + 1;
                        int i4 = i2 + 1;
                        if (segment.data[i] == segment2.data[i2]) {
                            j2++;
                            i = i3;
                            i2 = i4;
                        }
                    }
                    if (i == segment.limit) {
                        segment = segment.next;
                        l.b(segment);
                        i = segment.pos;
                    }
                    if (i2 == segment2.limit) {
                        segment2 = segment2.next;
                        l.b(segment2);
                        i2 = segment2.pos;
                    }
                    j += min;
                }
                return true;
            }
        }
        return false;
    }

    public boolean exhausted() {
        return this.size == 0;
    }

    public void flush() {
    }

    @NotNull
    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j) {
        -Util.checkOffsetAndCount(size(), j, 1L);
        Segment segment = this.head;
        if (segment == null) {
            l.b(null);
            throw null;
        }
        if (size() - j < j) {
            long size = size();
            while (size > j) {
                segment = segment.prev;
                l.b(segment);
                size -= segment.limit - segment.pos;
            }
            l.b(segment);
            return segment.data[(int) ((segment.pos + j) - size)];
        }
        long j2 = 0;
        while (true) {
            long j3 = (segment.limit - segment.pos) + j2;
            if (j3 > j) {
                l.b(segment);
                return segment.data[(int) ((segment.pos + j) - j2)];
            }
            segment = segment.next;
            l.b(segment);
            j2 = j3;
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            l.b(segment);
        } while (segment != this.head);
        return i;
    }

    @NotNull
    public final ByteString hmacSha1(@NotNull ByteString key) {
        l.e(key, "key");
        return hmac("HmacSHA1", key);
    }

    @NotNull
    public final ByteString hmacSha256(@NotNull ByteString key) {
        l.e(key, "key");
        return hmac("HmacSHA256", key);
    }

    @NotNull
    public final ByteString hmacSha512(@NotNull ByteString key) {
        l.e(key, "key");
        return hmac("HmacSHA512", key);
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
        return true;
    }

    @NotNull
    public final ByteString md5() {
        return digest("MD5");
    }

    @NotNull
    public OutputStream outputStream() {
        return new 1();
    }

    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    public boolean rangeEquals(long j, @NotNull ByteString bytes) {
        l.e(bytes, "bytes");
        return rangeEquals(j, bytes, 0, bytes.size());
    }

    public int read(@NotNull ByteBuffer sink) throws IOException {
        l.e(sink, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), segment.limit - segment.pos);
        sink.put(segment.data, segment.pos, min);
        int i = segment.pos + min;
        segment.pos = i;
        this.size -= min;
        if (i == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public long readAll(@NotNull Sink sink) throws IOException {
        l.e(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    @NotNull
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        Segment segment = this.head;
        l.b(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        setSize$okio(size() - 1);
        if (i3 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i3;
        }
        return b;
    }

    @NotNull
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @NotNull
    public ByteString readByteString() {
        return readByteString(size());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6 A[EDGE_INSN: B:46:0x00b6->B:40:0x00b6 BREAK  A[LOOP:0: B:4:0x0013->B:45:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            r17 = this;
            r0 = r17
            long r1 = r17.size()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lc4
            r1 = 0
            r5 = -7
            r6 = r5
            r2 = 0
            r4 = r3
            r3 = 0
        L13:
            okio.Segment r8 = r0.head
            kotlin.jvm.internal.l.b(r8)
            byte[] r9 = r8.data
            int r10 = r8.pos
            int r11 = r8.limit
        L1e:
            if (r10 >= r11) goto La2
            r12 = r9[r10]
            r13 = 48
            byte r13 = (byte) r13
            if (r12 < r13) goto L72
            r14 = 57
            byte r14 = (byte) r14
            if (r12 > r14) goto L72
            int r13 = r13 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 < 0) goto L45
            if (r16 != 0) goto L3e
            long r14 = (long) r13
            int r16 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r16 >= 0) goto L3e
            goto L45
        L3e:
            r14 = 10
            long r4 = r4 * r14
            long r12 = (long) r13
            long r4 = r4 + r12
            goto L7e
        L45:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.writeDecimalLong(r4)
            okio.Buffer r1 = r1.writeByte(r12)
            if (r2 != 0) goto L57
            r1.readByte()
        L57:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L72:
            r13 = 45
            byte r13 = (byte) r13
            r14 = 1
            if (r12 != r13) goto L83
            if (r1 != 0) goto L83
            r12 = 1
            long r6 = r6 - r12
            r2 = 1
        L7e:
            int r10 = r10 + 1
            int r1 = r1 + 1
            goto L1e
        L83:
            if (r1 == 0) goto L87
            r3 = 1
            goto La2
        L87:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = okio.-Util.toHexString(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        La2:
            if (r10 != r11) goto Lae
            okio.Segment r9 = r8.pop()
            r0.head = r9
            okio.SegmentPool.recycle(r8)
            goto Lb0
        Lae:
            r8.pos = r10
        Lb0:
            if (r3 != 0) goto Lb6
            okio.Segment r8 = r0.head
            if (r8 != 0) goto L13
        Lb6:
            long r6 = r17.size()
            long r8 = (long) r1
            long r6 = r6 - r8
            r0.setSize$okio(r6)
            if (r2 == 0) goto Lc2
            goto Lc3
        Lc2:
            long r4 = -r4
        Lc3:
            return r4
        Lc4:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream input) throws IOException {
        l.e(input, "input");
        readFrom(input, Long.MAX_VALUE, true);
        return this;
    }

    public void readFully(@NotNull Buffer sink, long j) throws EOFException {
        l.e(sink, "sink");
        if (size() >= j) {
            sink.write(this, j);
        } else {
            sink.write(this, size());
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae A[EDGE_INSN: B:39:0x00ae->B:36:0x00ae BREAK  A[LOOP:0: B:4:0x000d->B:38:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lb8
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            okio.Segment r6 = r15.head
            kotlin.jvm.internal.l.b(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L18:
            if (r8 >= r9) goto L9a
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L29
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L29
            int r11 = r10 - r11
            goto L43
        L29:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L38
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L38
        L33:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L43
        L38:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L7b
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L7b
            goto L33
        L43:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L53
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L53:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L7b:
            if (r0 == 0) goto L7f
            r1 = 1
            goto L9a
        L7f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = okio.-Util.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L9a:
            if (r8 != r9) goto La6
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto La8
        La6:
            r6.pos = r8
        La8:
            if (r1 != 0) goto Lae
            okio.Segment r6 = r15.head
            if (r6 != 0) goto Ld
        Lae:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lb8:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        Segment segment = this.head;
        l.b(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        setSize$okio(size() - 4);
        if (i5 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return i6;
    }

    public int readIntLe() throws EOFException {
        return -Util.reverseBytes(readInt());
    }

    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        Segment segment = this.head;
        l.b(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment.data;
        int i3 = i + 7;
        long j = ((bArr[i + 3] & 255) << 32) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
        int i4 = i + 8;
        long j2 = j | (bArr[i3] & 255);
        setSize$okio(size() - 8);
        if (i4 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return j2;
    }

    public long readLongLe() throws EOFException {
        return -Util.reverseBytes(readLong());
    }

    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        Segment segment = this.head;
        l.b(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        setSize$okio(size() - 2);
        if (i5 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    public short readShortLe() throws EOFException {
        return -Util.reverseBytes(readShort());
    }

    @NotNull
    public String readString(long j, @NotNull Charset charset) throws EOFException {
        l.e(charset, "charset");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (this.size < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        Segment segment = this.head;
        l.b(segment);
        int i = segment.pos;
        if (i + j > segment.limit) {
            return new String(readByteArray(j), charset);
        }
        int i2 = (int) j;
        String str = new String(segment.data, i, i2, charset);
        int i3 = segment.pos + i2;
        segment.pos = i3;
        this.size -= j;
        if (i3 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    @NotNull
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @NotNull
    public String readUtf8() {
        return readString(this.size, c.b);
    }

    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (size() == 0) {
            throw new EOFException();
        }
        byte b = getByte(0L);
        if ((b & 128) == 0) {
            i = b & Byte.MAX_VALUE;
            i2 = 1;
            i3 = 0;
        } else if ((b & 224) == 192) {
            i = b & 31;
            i2 = 2;
            i3 = 128;
        } else if ((b & 240) == 224) {
            i = b & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((b & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (size() < j) {
            throw new EOFException("size < " + i2 + ": " + size() + " (to read code point prefixed 0x" + -Util.toHexString(b) + ')');
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = getByte(j2);
            if ((b2 & 192) != 128) {
                skip(j2);
                return 65533;
            }
            i = (i << 6) | (b2 & 63);
        }
        skip(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((55296 <= i && 57343 >= i) || i < i3) {
            return 65533;
        }
        return i;
    }

    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @NotNull
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j) {
        return this.size >= j;
    }

    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    public int select(@NotNull Options options) {
        l.e(options, "options");
        int selectPrefix$default = BufferKt.selectPrefix$default(this, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public final void setSize$okio(long j) {
        this.size = j;
    }

    @NotNull
    public final ByteString sha1() {
        return digest("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return digest("SHA-256");
    }

    @NotNull
    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = min;
            setSize$okio(size() - j2);
            j -= j2;
            int i = segment.pos + min;
            segment.pos = i;
            if (i == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @NotNull
    public final ByteString snapshot() {
        if (size() <= ((long) Integer.MAX_VALUE)) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @NotNull
    public String toString() {
        return snapshot().toString();
    }

    @NotNull
    public final Segment writableSegment$okio(int i) {
        if (!(i >= 1 && i <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment segment = this.head;
        if (segment != null) {
            l.b(segment);
            Segment segment2 = segment.prev;
            l.b(segment2);
            return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment take = SegmentPool.take();
        this.head = take;
        take.prev = take;
        take.next = take;
        return take;
    }

    public int write(@NotNull ByteBuffer source) throws IOException {
        l.e(source, "source");
        int remaining = source.remaining();
        int i = remaining;
        while (i > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i, 8192 - writableSegment$okio.limit);
            source.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i -= min;
            writableSegment$okio.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    public long writeAll(@NotNull Source source) throws IOException {
        l.e(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(this, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @NotNull
    public Buffer writeByte(int i) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        setSize$okio(size() + 1);
        return this;
    }

    @NotNull
    public Buffer writeDecimalLong(long j) {
        boolean z;
        if (j == 0) {
            return writeByte(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        Segment writableSegment$okio = writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit + i;
        while (j != 0) {
            long j2 = 10;
            i2--;
            bArr[i2] = BufferKt.getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i2 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i;
        setSize$okio(size() + i);
        return this;
    }

    @NotNull
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        setSize$okio(size() + i);
        return this;
    }

    @NotNull
    public Buffer writeInt(int i) {
        Segment writableSegment$okio = writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        writableSegment$okio.limit = i2 + 4;
        setSize$okio(size() + 4);
        return this;
    }

    @NotNull
    public Buffer writeIntLe(int i) {
        return writeInt(-Util.reverseBytes(i));
    }

    @NotNull
    public Buffer writeLong(long j) {
        Segment writableSegment$okio = writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i = writableSegment$okio.limit;
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
        writableSegment$okio.limit = i + 8;
        setSize$okio(size() + 8);
        return this;
    }

    @NotNull
    public Buffer writeLongLe(long j) {
        return writeLong(-Util.reverseBytes(j));
    }

    @NotNull
    public Buffer writeShort(int i) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        writableSegment$okio.limit = i2 + 2;
        setSize$okio(size() + 2);
        return this;
    }

    @NotNull
    public Buffer writeShortLe(int i) {
        return writeShort((int) -Util.reverseBytes((short) i));
    }

    @NotNull
    public Buffer writeString(@NotNull String string, int i, int i2, @NotNull Charset charset) {
        l.e(string, "string");
        l.e(charset, "charset");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (!(i2 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + string.length()).toString());
        }
        if (l.a(charset, c.b)) {
            return writeUtf8(string, i, i2);
        }
        String substring = string.substring(i, i2);
        l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = substring.getBytes(charset);
        l.d(bytes, "(this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    @NotNull
    public final Buffer writeTo(@NotNull OutputStream outputStream) throws IOException {
        return writeTo$default(this, outputStream, 0L, 2, null);
    }

    @NotNull
    public Buffer writeUtf8(@NotNull String string) {
        l.e(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    @NotNull
    public Buffer writeUtf8CodePoint(int i) {
        long size;
        long j;
        if (i < 128) {
            writeByte(i);
        } else {
            if (i < 2048) {
                Segment writableSegment$okio = writableSegment$okio(2);
                byte[] bArr = writableSegment$okio.data;
                int i2 = writableSegment$okio.limit;
                bArr[i2] = (byte) ((i >> 6) | 192);
                bArr[i2 + 1] = (byte) ((i & 63) | 128);
                writableSegment$okio.limit = i2 + 2;
                size = size();
                j = 2;
            } else if (55296 <= i && 57343 >= i) {
                writeByte(63);
            } else if (i < 65536) {
                Segment writableSegment$okio2 = writableSegment$okio(3);
                byte[] bArr2 = writableSegment$okio2.data;
                int i3 = writableSegment$okio2.limit;
                bArr2[i3] = (byte) ((i >> 12) | 224);
                bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
                bArr2[i3 + 2] = (byte) ((i & 63) | 128);
                writableSegment$okio2.limit = i3 + 3;
                size = size();
                j = 3;
            } else {
                if (i > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: 0x" + -Util.toHexString(i));
                }
                Segment writableSegment$okio3 = writableSegment$okio(4);
                byte[] bArr3 = writableSegment$okio3.data;
                int i4 = writableSegment$okio3.limit;
                bArr3[i4] = (byte) ((i >> 18) | 240);
                bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
                bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
                bArr3[i4 + 3] = (byte) ((i & 63) | 128);
                writableSegment$okio3.limit = i4 + 4;
                size = size();
                j = 4;
            }
            setSize$okio(size + j);
        }
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j);
    }

    @NotNull
    public Buffer clone() {
        return copy();
    }

    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream, long j) throws IOException {
        return copyTo$default(this, outputStream, j, 0L, 4, (Object) null);
    }

    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    public long indexOfElement(@NotNull ByteString targetBytes, long j) {
        int i;
        l.e(targetBytes, "targetBytes");
        long j2 = 0;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        if (size() - j < j) {
            j2 = size();
            while (j2 > j) {
                segment = segment.prev;
                l.b(segment);
                j2 -= segment.limit - segment.pos;
            }
            if (targetBytes.size() == 2) {
                byte b = targetBytes.getByte(0);
                byte b2 = targetBytes.getByte(1);
                while (j2 < size()) {
                    byte[] bArr = segment.data;
                    i = (int) ((segment.pos + j) - j2);
                    int i2 = segment.limit;
                    while (i < i2) {
                        byte b3 = bArr[i];
                        if (b3 != b && b3 != b2) {
                            i++;
                        }
                    }
                    j2 += segment.limit - segment.pos;
                    segment = segment.next;
                    l.b(segment);
                    j = j2;
                }
                return -1L;
            }
            byte[] internalArray$okio = targetBytes.internalArray$okio();
            while (j2 < size()) {
                byte[] bArr2 = segment.data;
                i = (int) ((segment.pos + j) - j2);
                int i3 = segment.limit;
                while (i < i3) {
                    byte b4 = bArr2[i];
                    for (byte b5 : internalArray$okio) {
                        if (b4 != b5) {
                        }
                    }
                    i++;
                }
                j2 += segment.limit - segment.pos;
                segment = segment.next;
                l.b(segment);
                j = j2;
            }
            return -1L;
        }
        while (true) {
            long j3 = (segment.limit - segment.pos) + j2;
            if (j3 > j) {
                break;
            }
            segment = segment.next;
            l.b(segment);
            j2 = j3;
        }
        if (targetBytes.size() == 2) {
            byte b6 = targetBytes.getByte(0);
            byte b7 = targetBytes.getByte(1);
            while (j2 < size()) {
                byte[] bArr3 = segment.data;
                i = (int) ((segment.pos + j) - j2);
                int i4 = segment.limit;
                while (i < i4) {
                    byte b8 = bArr3[i];
                    if (b8 != b6 && b8 != b7) {
                        i++;
                    }
                }
                j2 += segment.limit - segment.pos;
                segment = segment.next;
                l.b(segment);
                j = j2;
            }
            return -1L;
        }
        byte[] internalArray$okio2 = targetBytes.internalArray$okio();
        while (j2 < size()) {
            byte[] bArr4 = segment.data;
            i = (int) ((segment.pos + j) - j2);
            int i5 = segment.limit;
            while (i < i5) {
                byte b9 = bArr4[i];
                for (byte b10 : internalArray$okio2) {
                    if (b9 != b10) {
                    }
                }
                i++;
            }
            j2 += segment.limit - segment.pos;
            segment = segment.next;
            l.b(segment);
            j = j2;
        }
        return -1L;
        return (i - segment.pos) + j2;
    }

    public boolean rangeEquals(long j, @NotNull ByteString bytes, int i, int i2) {
        l.e(bytes, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || size() - j < i2 || bytes.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(i3 + j) != bytes.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public int read(@NotNull byte[] sink) {
        l.e(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @NotNull
    public final UnsafeCursor readAndWriteUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        l.e(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @NotNull
    public byte[] readByteArray(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (size() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @NotNull
    public ByteString readByteString(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (size() < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(readByteArray(j));
        }
        ByteString snapshot = snapshot((int) j);
        skip(j);
        return snapshot;
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream input, long j) throws IOException {
        l.e(input, "input");
        if (j >= 0) {
            readFrom(input, j, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
    }

    public void readFully(@NotNull byte[] sink) throws EOFException {
        l.e(sink, "sink");
        int i = 0;
        while (i < sink.length) {
            int read = read(sink, i, sink.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    @NotNull
    public String readString(@NotNull Charset charset) {
        l.e(charset, "charset");
        return readString(this.size, charset);
    }

    @NotNull
    public final UnsafeCursor readUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        l.e(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @NotNull
    public String readUtf8(long j) throws EOFException {
        return readString(j, c.b);
    }

    @NotNull
    public String readUtf8LineStrict(long j) throws EOFException {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        byte b = (byte) 10;
        long indexOf = indexOf(b, 0L, j2);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(this, indexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == ((byte) 13) && getByte(j2) == b) {
            return BufferKt.readUtf8Line(this, j2);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @NotNull
    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        -Util.checkOffsetAndCount(size(), 0L, i);
        Segment segment = this.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            l.b(segment);
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            segment = segment.next;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        Segment segment2 = this.head;
        int i7 = 0;
        while (i2 < i) {
            l.b(segment2);
            bArr[i7] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment2.pos;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public Buffer write(@NotNull ByteString byteString) {
        l.e(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @NotNull
    public Buffer writeString(@NotNull String string, @NotNull Charset charset) {
        l.e(string, "string");
        l.e(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    @NotNull
    public final Buffer writeTo(@NotNull OutputStream out, long j) throws IOException {
        l.e(out, "out");
        -Util.checkOffsetAndCount(this.size, 0L, j);
        Segment segment = this.head;
        while (j > 0) {
            l.b(segment);
            int min = (int) Math.min(j, segment.limit - segment.pos);
            out.write(segment.data, segment.pos, min);
            int i = segment.pos + min;
            segment.pos = i;
            long j2 = min;
            this.size -= j2;
            j -= j2;
            if (i == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    @NotNull
    public Buffer writeUtf8(@NotNull String string, int i, int i2) {
        long size;
        long j;
        l.e(string, "string");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (!(i2 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + string.length()).toString());
        }
        while (i < i2) {
            char charAt = string.charAt(i);
            if (charAt < 128) {
                Segment writableSegment$okio = writableSegment$okio(1);
                byte[] bArr = writableSegment$okio.data;
                int i3 = writableSegment$okio.limit - i;
                int min = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) charAt;
                while (i4 < min) {
                    char charAt2 = string.charAt(i4);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i4 + i3] = (byte) charAt2;
                    i4++;
                }
                int i5 = writableSegment$okio.limit;
                int i6 = (i3 + i4) - i5;
                writableSegment$okio.limit = i5 + i6;
                setSize$okio(size() + i6);
                i = i4;
            } else {
                if (charAt < 2048) {
                    Segment writableSegment$okio2 = writableSegment$okio(2);
                    byte[] bArr2 = writableSegment$okio2.data;
                    int i7 = writableSegment$okio2.limit;
                    bArr2[i7] = (byte) ((charAt >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((charAt & '?') | 128);
                    writableSegment$okio2.limit = i7 + 2;
                    size = size();
                    j = 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    Segment writableSegment$okio3 = writableSegment$okio(3);
                    byte[] bArr3 = writableSegment$okio3.data;
                    int i8 = writableSegment$okio3.limit;
                    bArr3[i8] = (byte) ((charAt >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((charAt & '?') | 128);
                    writableSegment$okio3.limit = i8 + 3;
                    size = size();
                    j = 3;
                } else {
                    int i9 = i + 1;
                    char charAt3 = i9 < i2 ? string.charAt(i9) : (char) 0;
                    if (charAt > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                        writeByte(63);
                        i = i9;
                    } else {
                        int i10 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 65536;
                        Segment writableSegment$okio4 = writableSegment$okio(4);
                        byte[] bArr4 = writableSegment$okio4.data;
                        int i11 = writableSegment$okio4.limit;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        writableSegment$okio4.limit = i11 + 4;
                        setSize$okio(size() + 4);
                        i += 2;
                    }
                }
                setSize$okio(size + j);
                i++;
            }
        }
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j, j2);
    }

    private final void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            Segment writableSegment$okio = writableSegment$okio(1);
            int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j, 8192 - writableSegment$okio.limit));
            if (read == -1) {
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    this.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment$okio.limit += read;
            long j2 = read;
            this.size += j2;
            j -= j2;
        }
    }

    @NotNull
    public final Buffer copyTo(@NotNull OutputStream out, long j, long j2) throws IOException {
        l.e(out, "out");
        -Util.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            l.b(segment);
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            segment = segment.next;
        }
        while (j2 > 0) {
            l.b(segment);
            int min = (int) Math.min(segment.limit - r10, j2);
            out.write(segment.data, (int) (segment.pos + j), min);
            j2 -= min;
            segment = segment.next;
            j = 0;
        }
        return this;
    }

    public long indexOf(byte b, long j, long j2) {
        Segment segment;
        int i;
        long j3 = 0;
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > size()) {
            j2 = size();
        }
        if (j == j2 || (segment = this.head) == null) {
            return -1L;
        }
        if (size() - j < j) {
            j3 = size();
            while (j3 > j) {
                segment = segment.prev;
                l.b(segment);
                j3 -= segment.limit - segment.pos;
            }
            while (j3 < j2) {
                byte[] bArr = segment.data;
                int min = (int) Math.min(segment.limit, (segment.pos + j2) - j3);
                i = (int) ((segment.pos + j) - j3);
                while (i < min) {
                    if (bArr[i] != b) {
                        i++;
                    }
                }
                j3 += segment.limit - segment.pos;
                segment = segment.next;
                l.b(segment);
                j = j3;
            }
            return -1L;
        }
        while (true) {
            long j4 = (segment.limit - segment.pos) + j3;
            if (j4 > j) {
                break;
            }
            segment = segment.next;
            l.b(segment);
            j3 = j4;
        }
        while (j3 < j2) {
            byte[] bArr2 = segment.data;
            int min2 = (int) Math.min(segment.limit, (segment.pos + j2) - j3);
            i = (int) ((segment.pos + j) - j3);
            while (i < min2) {
                if (bArr2[i] != b) {
                    i++;
                }
            }
            j3 += segment.limit - segment.pos;
            segment = segment.next;
            l.b(segment);
            j = j3;
        }
        return -1L;
        return (i - segment.pos) + j3;
    }

    public int read(@NotNull byte[] sink, int i, int i2) {
        l.e(sink, "sink");
        -Util.checkOffsetAndCount(sink.length, i, i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i3 = segment.pos;
        g.c(bArr, sink, i, i3, i3 + min);
        segment.pos += min;
        setSize$okio(size() - min);
        if (segment.pos != segment.limit) {
            return min;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return min;
    }

    @NotNull
    public Buffer write(@NotNull ByteString byteString, int i, int i2) {
        l.e(byteString, "byteString");
        byteString.write$okio(this, i, i2);
        return this;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer out, long j) {
        l.e(out, "out");
        return copyTo(out, j, this.size - j);
    }

    public long indexOf(@NotNull ByteString bytes) throws IOException {
        l.e(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    public long read(@NotNull Buffer sink, long j) {
        l.e(sink, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j > size()) {
            j = size();
        }
        sink.write(this, j);
        return j;
    }

    @NotNull
    public Buffer write(@NotNull Source source, long j) throws IOException {
        l.e(source, "source");
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer out, long j, long j2) {
        l.e(out, "out");
        -Util.checkOffsetAndCount(size(), j, j2);
        if (j2 != 0) {
            out.setSize$okio(out.size() + j2);
            Segment segment = this.head;
            while (true) {
                l.b(segment);
                int i = segment.limit;
                int i2 = segment.pos;
                if (j < i - i2) {
                    break;
                }
                j -= i - i2;
                segment = segment.next;
            }
            while (j2 > 0) {
                l.b(segment);
                Segment sharedCopy = segment.sharedCopy();
                int i3 = sharedCopy.pos + ((int) j);
                sharedCopy.pos = i3;
                sharedCopy.limit = Math.min(i3 + ((int) j2), sharedCopy.limit);
                Segment segment2 = out.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    out.head = sharedCopy;
                } else {
                    l.b(segment2);
                    Segment segment3 = segment2.prev;
                    l.b(segment3);
                    segment3.push(sharedCopy);
                }
                j2 -= sharedCopy.limit - sharedCopy.pos;
                segment = segment.next;
                j = 0;
            }
        }
        return this;
    }

    public long indexOf(@NotNull ByteString bytes, long j) throws IOException {
        long j2 = j;
        l.e(bytes, "bytes");
        if (!(bytes.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j3 = 0;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
        }
        Segment segment = this.head;
        if (segment != null) {
            if (size() - j2 < j2) {
                long size = size();
                while (size > j2) {
                    segment = segment.prev;
                    l.b(segment);
                    size -= segment.limit - segment.pos;
                }
                byte[] internalArray$okio = bytes.internalArray$okio();
                byte b = internalArray$okio[0];
                int size2 = bytes.size();
                long size3 = (size() - size2) + 1;
                while (size < size3) {
                    byte[] bArr = segment.data;
                    long j4 = size;
                    int min = (int) Math.min(segment.limit, (segment.pos + size3) - size);
                    for (int i = (int) ((segment.pos + j2) - j4); i < min; i++) {
                        if (bArr[i] == b && BufferKt.rangeEquals(segment, i + 1, internalArray$okio, 1, size2)) {
                            return (i - segment.pos) + j4;
                        }
                    }
                    size = j4 + (segment.limit - segment.pos);
                    segment = segment.next;
                    l.b(segment);
                    j2 = size;
                }
            } else {
                while (true) {
                    long j5 = (segment.limit - segment.pos) + j3;
                    if (j5 > j2) {
                        break;
                    }
                    segment = segment.next;
                    l.b(segment);
                    j3 = j5;
                }
                byte[] internalArray$okio2 = bytes.internalArray$okio();
                byte b2 = internalArray$okio2[0];
                int size4 = bytes.size();
                long size5 = (size() - size4) + 1;
                while (j3 < size5) {
                    byte[] bArr2 = segment.data;
                    long j6 = size5;
                    int min2 = (int) Math.min(segment.limit, (segment.pos + size5) - j3);
                    for (int i2 = (int) ((segment.pos + j2) - j3); i2 < min2; i2++) {
                        if (bArr2[i2] == b2 && BufferKt.rangeEquals(segment, i2 + 1, internalArray$okio2, 1, size4)) {
                            return (i2 - segment.pos) + j3;
                        }
                    }
                    j3 += segment.limit - segment.pos;
                    segment = segment.next;
                    l.b(segment);
                    j2 = j3;
                    size5 = j6;
                }
            }
        }
        return -1L;
    }

    @NotNull
    public Buffer write(@NotNull byte[] source) {
        l.e(source, "source");
        return write(source, 0, source.length);
    }

    @NotNull
    public Buffer write(@NotNull byte[] source, int i, int i2) {
        l.e(source, "source");
        long j = i2;
        -Util.checkOffsetAndCount(source.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            int i4 = i + min;
            g.c(source, writableSegment$okio.data, writableSegment$okio.limit, i, i4);
            writableSegment$okio.limit += min;
            i = i4;
        }
        setSize$okio(size() + j);
        return this;
    }

    public void write(@NotNull Buffer source, long j) {
        Segment segment;
        l.e(source, "source");
        if (!(source != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        -Util.checkOffsetAndCount(source.size(), 0L, j);
        while (j > 0) {
            Segment segment2 = source.head;
            l.b(segment2);
            int i = segment2.limit;
            l.b(source.head);
            if (j < i - r2.pos) {
                Segment segment3 = this.head;
                if (segment3 != null) {
                    l.b(segment3);
                    segment = segment3.prev;
                } else {
                    segment = null;
                }
                if (segment != null && segment.owner) {
                    if ((segment.limit + j) - (segment.shared ? 0 : segment.pos) <= 8192) {
                        Segment segment4 = source.head;
                        l.b(segment4);
                        segment4.writeTo(segment, (int) j);
                        source.setSize$okio(source.size() - j);
                        setSize$okio(size() + j);
                        return;
                    }
                }
                Segment segment5 = source.head;
                l.b(segment5);
                source.head = segment5.split((int) j);
            }
            Segment segment6 = source.head;
            l.b(segment6);
            long j2 = segment6.limit - segment6.pos;
            source.head = segment6.pop();
            Segment segment7 = this.head;
            if (segment7 == null) {
                this.head = segment6;
                segment6.prev = segment6;
                segment6.next = segment6;
            } else {
                l.b(segment7);
                Segment segment8 = segment7.prev;
                l.b(segment8);
                segment8.push(segment6).compact();
            }
            source.setSize$okio(source.size() - j2);
            setSize$okio(size() + j2);
            j -= j2;
        }
    }
}
