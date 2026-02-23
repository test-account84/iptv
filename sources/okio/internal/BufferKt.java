package okio.internal;

import java.io.EOFException;
import kotlin.jvm.internal.l;
import l8.g;
import okio.-Platform;
import okio.-Util;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class BufferKt {

    @NotNull
    private static final byte[] HEX_DIGIT_BYTES = -Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(@NotNull Buffer commonClear) {
        l.e(commonClear, "$this$commonClear");
        commonClear.skip(commonClear.size());
    }

    public static final long commonCompleteSegmentByteCount(@NotNull Buffer commonCompleteSegmentByteCount) {
        l.e(commonCompleteSegmentByteCount, "$this$commonCompleteSegmentByteCount");
        long size = commonCompleteSegmentByteCount.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = commonCompleteSegmentByteCount.head;
        l.b(segment);
        Segment segment2 = segment.prev;
        l.b(segment2);
        return (segment2.limit >= 8192 || !segment2.owner) ? size : size - (r2 - segment2.pos);
    }

    @NotNull
    public static final Buffer commonCopy(@NotNull Buffer commonCopy) {
        l.e(commonCopy, "$this$commonCopy");
        Buffer buffer = new Buffer();
        if (commonCopy.size() == 0) {
            return buffer;
        }
        Segment segment = commonCopy.head;
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
        buffer.setSize$okio(commonCopy.size());
        return buffer;
    }

    @NotNull
    public static final Buffer commonCopyTo(@NotNull Buffer commonCopyTo, @NotNull Buffer out, long j, long j2) {
        l.e(commonCopyTo, "$this$commonCopyTo");
        l.e(out, "out");
        -Util.checkOffsetAndCount(commonCopyTo.size(), j, j2);
        if (j2 == 0) {
            return commonCopyTo;
        }
        out.setSize$okio(out.size() + j2);
        Segment segment = commonCopyTo.head;
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
        return commonCopyTo;
    }

    public static final boolean commonEquals(@NotNull Buffer commonEquals, @Nullable Object obj) {
        l.e(commonEquals, "$this$commonEquals");
        if (commonEquals == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (commonEquals.size() != buffer.size()) {
            return false;
        }
        if (commonEquals.size() == 0) {
            return true;
        }
        Segment segment = commonEquals.head;
        l.b(segment);
        Segment segment2 = buffer.head;
        l.b(segment2);
        int i = segment.pos;
        int i2 = segment2.pos;
        long j = 0;
        while (j < commonEquals.size()) {
            long min = Math.min(segment.limit - i, segment2.limit - i2);
            long j2 = 0;
            while (j2 < min) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                j2++;
                i = i3;
                i2 = i4;
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

    public static final byte commonGet(@NotNull Buffer commonGet, long j) {
        l.e(commonGet, "$this$commonGet");
        -Util.checkOffsetAndCount(commonGet.size(), j, 1L);
        Segment segment = commonGet.head;
        if (segment == null) {
            l.b(null);
            throw null;
        }
        if (commonGet.size() - j < j) {
            long size = commonGet.size();
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

    public static final int commonHashCode(@NotNull Buffer commonHashCode) {
        l.e(commonHashCode, "$this$commonHashCode");
        Segment segment = commonHashCode.head;
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
        } while (segment != commonHashCode.head);
        return i;
    }

    public static final long commonIndexOf(@NotNull Buffer commonIndexOf, byte b, long j, long j2) {
        Segment segment;
        int i;
        l.e(commonIndexOf, "$this$commonIndexOf");
        long j3 = 0;
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("size=" + commonIndexOf.size() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > commonIndexOf.size()) {
            j2 = commonIndexOf.size();
        }
        if (j == j2 || (segment = commonIndexOf.head) == null) {
            return -1L;
        }
        if (commonIndexOf.size() - j < j) {
            j3 = commonIndexOf.size();
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

    public static final long commonIndexOfElement(@NotNull Buffer commonIndexOfElement, @NotNull ByteString targetBytes, long j) {
        int i;
        l.e(commonIndexOfElement, "$this$commonIndexOfElement");
        l.e(targetBytes, "targetBytes");
        long j2 = 0;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
        }
        Segment segment = commonIndexOfElement.head;
        if (segment == null) {
            return -1L;
        }
        if (commonIndexOfElement.size() - j < j) {
            j2 = commonIndexOfElement.size();
            while (j2 > j) {
                segment = segment.prev;
                l.b(segment);
                j2 -= segment.limit - segment.pos;
            }
            if (targetBytes.size() == 2) {
                byte b = targetBytes.getByte(0);
                byte b2 = targetBytes.getByte(1);
                while (j2 < commonIndexOfElement.size()) {
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
            while (j2 < commonIndexOfElement.size()) {
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
            while (j2 < commonIndexOfElement.size()) {
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
        while (j2 < commonIndexOfElement.size()) {
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

    public static final boolean commonRangeEquals(@NotNull Buffer commonRangeEquals, long j, @NotNull ByteString bytes, int i, int i2) {
        l.e(commonRangeEquals, "$this$commonRangeEquals");
        l.e(bytes, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || commonRangeEquals.size() - j < i2 || bytes.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (commonRangeEquals.getByte(i3 + j) != bytes.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(@NotNull Buffer commonRead, @NotNull byte[] sink) {
        l.e(commonRead, "$this$commonRead");
        l.e(sink, "sink");
        return commonRead.read(sink, 0, sink.length);
    }

    public static final long commonReadAll(@NotNull Buffer commonReadAll, @NotNull Sink sink) {
        l.e(commonReadAll, "$this$commonReadAll");
        l.e(sink, "sink");
        long size = commonReadAll.size();
        if (size > 0) {
            sink.write(commonReadAll, size);
        }
        return size;
    }

    public static final byte commonReadByte(@NotNull Buffer commonReadByte) {
        l.e(commonReadByte, "$this$commonReadByte");
        if (commonReadByte.size() == 0) {
            throw new EOFException();
        }
        Segment segment = commonReadByte.head;
        l.b(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        commonReadByte.setSize$okio(commonReadByte.size() - 1);
        if (i3 == i2) {
            commonReadByte.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i3;
        }
        return b;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer commonReadByteArray) {
        l.e(commonReadByteArray, "$this$commonReadByteArray");
        return commonReadByteArray.readByteArray(commonReadByteArray.size());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer commonReadByteString) {
        l.e(commonReadByteString, "$this$commonReadByteString");
        return commonReadByteString.readByteString(commonReadByteString.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb A[EDGE_INSN: B:46:0x00bb->B:40:0x00bb BREAK  A[LOOP:0: B:4:0x0018->B:45:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(@org.jetbrains.annotations.NotNull okio.Buffer r17) {
        /*
            r0 = r17
            java.lang.String r1 = "$this$commonReadDecimalLong"
            kotlin.jvm.internal.l.e(r0, r1)
            long r1 = r17.size()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lc9
            r1 = 0
            r5 = -7
            r6 = r5
            r2 = 0
            r4 = r3
            r3 = 0
        L18:
            okio.Segment r8 = r0.head
            kotlin.jvm.internal.l.b(r8)
            byte[] r9 = r8.data
            int r10 = r8.pos
            int r11 = r8.limit
        L23:
            if (r10 >= r11) goto La7
            r12 = r9[r10]
            r13 = 48
            byte r13 = (byte) r13
            if (r12 < r13) goto L77
            r14 = 57
            byte r14 = (byte) r14
            if (r12 > r14) goto L77
            int r13 = r13 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 < 0) goto L4a
            if (r16 != 0) goto L43
            long r14 = (long) r13
            int r16 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r16 >= 0) goto L43
            goto L4a
        L43:
            r14 = 10
            long r4 = r4 * r14
            long r12 = (long) r13
            long r4 = r4 + r12
            goto L83
        L4a:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeDecimalLong(r4)
            okio.Buffer r0 = r0.writeByte(r12)
            if (r2 != 0) goto L5c
            r0.readByte()
        L5c:
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
        L77:
            r13 = 45
            byte r13 = (byte) r13
            r14 = 1
            if (r12 != r13) goto L88
            if (r1 != 0) goto L88
            r12 = 1
            long r6 = r6 - r12
            r2 = 1
        L83:
            int r10 = r10 + 1
            int r1 = r1 + 1
            goto L23
        L88:
            if (r1 == 0) goto L8c
            r3 = 1
            goto La7
        L8c:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            r1.append(r2)
            java.lang.String r2 = okio.-Util.toHexString(r12)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La7:
            if (r10 != r11) goto Lb3
            okio.Segment r9 = r8.pop()
            r0.head = r9
            okio.SegmentPool.recycle(r8)
            goto Lb5
        Lb3:
            r8.pos = r10
        Lb5:
            if (r3 != 0) goto Lbb
            okio.Segment r8 = r0.head
            if (r8 != 0) goto L18
        Lbb:
            long r6 = r17.size()
            long r8 = (long) r1
            long r6 = r6 - r8
            r0.setSize$okio(r6)
            if (r2 == 0) goto Lc7
            goto Lc8
        Lc7:
            long r4 = -r4
        Lc8:
            return r4
        Lc9:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(@NotNull Buffer commonReadFully, @NotNull Buffer sink, long j) {
        l.e(commonReadFully, "$this$commonReadFully");
        l.e(sink, "sink");
        if (commonReadFully.size() >= j) {
            sink.write(commonReadFully, j);
        } else {
            sink.write(commonReadFully, commonReadFully.size());
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3 A[EDGE_INSN: B:39:0x00b3->B:36:0x00b3 BREAK  A[LOOP:0: B:4:0x0012->B:38:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadHexadecimalUnsignedLong(@org.jetbrains.annotations.NotNull okio.Buffer r15) {
        /*
            java.lang.String r0 = "$this$commonReadHexadecimalUnsignedLong"
            kotlin.jvm.internal.l.e(r15, r0)
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lbd
            r0 = 0
            r4 = r2
            r1 = 0
        L12:
            okio.Segment r6 = r15.head
            kotlin.jvm.internal.l.b(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L1d:
            if (r8 >= r9) goto L9f
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L2e
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L2e
            int r11 = r10 - r11
            goto L48
        L2e:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L3d
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L3d
        L38:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L48
        L3d:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L80
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L80
            goto L38
        L48:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L58
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L1d
        L58:
            okio.Buffer r15 = new okio.Buffer
            r15.<init>()
            okio.Buffer r15 = r15.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r15 = r15.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r15 = r15.readUtf8()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L80:
            if (r0 == 0) goto L84
            r1 = 1
            goto L9f
        L84:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = okio.-Util.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L9f:
            if (r8 != r9) goto Lab
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto Lad
        Lab:
            r6.pos = r8
        Lad:
            if (r1 != 0) goto Lb3
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L12
        Lb3:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lbd:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(@NotNull Buffer commonReadInt) {
        l.e(commonReadInt, "$this$commonReadInt");
        if (commonReadInt.size() < 4) {
            throw new EOFException();
        }
        Segment segment = commonReadInt.head;
        l.b(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return (commonReadInt.readByte() & 255) | ((commonReadInt.readByte() & 255) << 24) | ((commonReadInt.readByte() & 255) << 16) | ((commonReadInt.readByte() & 255) << 8);
        }
        byte[] bArr = segment.data;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        commonReadInt.setSize$okio(commonReadInt.size() - 4);
        if (i5 == i2) {
            commonReadInt.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return i6;
    }

    public static final long commonReadLong(@NotNull Buffer commonReadLong) {
        l.e(commonReadLong, "$this$commonReadLong");
        if (commonReadLong.size() < 8) {
            throw new EOFException();
        }
        Segment segment = commonReadLong.head;
        l.b(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((commonReadLong.readInt() & 4294967295L) << 32) | (4294967295L & commonReadLong.readInt());
        }
        byte[] bArr = segment.data;
        int i3 = i + 7;
        long j = ((bArr[i + 3] & 255) << 32) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
        int i4 = i + 8;
        long j2 = j | (bArr[i3] & 255);
        commonReadLong.setSize$okio(commonReadLong.size() - 8);
        if (i4 == i2) {
            commonReadLong.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return j2;
    }

    public static final short commonReadShort(@NotNull Buffer commonReadShort) {
        l.e(commonReadShort, "$this$commonReadShort");
        if (commonReadShort.size() < 2) {
            throw new EOFException();
        }
        Segment segment = commonReadShort.head;
        l.b(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) ((commonReadShort.readByte() & 255) | ((commonReadShort.readByte() & 255) << 8));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        commonReadShort.setSize$okio(commonReadShort.size() - 2);
        if (i5 == i2) {
            commonReadShort.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull Buffer commonReadUtf8, long j) {
        l.e(commonReadUtf8, "$this$commonReadUtf8");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (commonReadUtf8.size() < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        Segment segment = commonReadUtf8.head;
        l.b(segment);
        int i = segment.pos;
        if (i + j > segment.limit) {
            return _Utf8Kt.commonToUtf8String$default(commonReadUtf8.readByteArray(j), 0, 0, 3, null);
        }
        int i2 = (int) j;
        String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i, i + i2);
        segment.pos += i2;
        commonReadUtf8.setSize$okio(commonReadUtf8.size() - j);
        if (segment.pos == segment.limit) {
            commonReadUtf8.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return commonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(@NotNull Buffer commonReadUtf8CodePoint) {
        int i;
        int i2;
        int i3;
        l.e(commonReadUtf8CodePoint, "$this$commonReadUtf8CodePoint");
        if (commonReadUtf8CodePoint.size() == 0) {
            throw new EOFException();
        }
        byte b = commonReadUtf8CodePoint.getByte(0L);
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
                commonReadUtf8CodePoint.skip(1L);
                return 65533;
            }
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (commonReadUtf8CodePoint.size() < j) {
            throw new EOFException("size < " + i2 + ": " + commonReadUtf8CodePoint.size() + " (to read code point prefixed 0x" + -Util.toHexString(b) + ')');
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = commonReadUtf8CodePoint.getByte(j2);
            if ((b2 & 192) != 128) {
                commonReadUtf8CodePoint.skip(j2);
                return 65533;
            }
            i = (i << 6) | (b2 & 63);
        }
        commonReadUtf8CodePoint.skip(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((55296 <= i && 57343 >= i) || i < i3) {
            return 65533;
        }
        return i;
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull Buffer commonReadUtf8Line) {
        l.e(commonReadUtf8Line, "$this$commonReadUtf8Line");
        long indexOf = commonReadUtf8Line.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(commonReadUtf8Line, indexOf);
        }
        if (commonReadUtf8Line.size() != 0) {
            return commonReadUtf8Line.readUtf8(commonReadUtf8Line.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull Buffer commonReadUtf8LineStrict, long j) {
        l.e(commonReadUtf8LineStrict, "$this$commonReadUtf8LineStrict");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        byte b = (byte) 10;
        long indexOf = commonReadUtf8LineStrict.indexOf(b, 0L, j2);
        if (indexOf != -1) {
            return readUtf8Line(commonReadUtf8LineStrict, indexOf);
        }
        if (j2 < commonReadUtf8LineStrict.size() && commonReadUtf8LineStrict.getByte(j2 - 1) == ((byte) 13) && commonReadUtf8LineStrict.getByte(j2) == b) {
            return readUtf8Line(commonReadUtf8LineStrict, j2);
        }
        Buffer buffer = new Buffer();
        commonReadUtf8LineStrict.copyTo(buffer, 0L, Math.min(32, commonReadUtf8LineStrict.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(commonReadUtf8LineStrict.size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    public static final int commonSelect(@NotNull Buffer commonSelect, @NotNull Options options) {
        l.e(commonSelect, "$this$commonSelect");
        l.e(options, "options");
        int selectPrefix$default = selectPrefix$default(commonSelect, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        commonSelect.skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(@NotNull Buffer commonSkip, long j) {
        l.e(commonSkip, "$this$commonSkip");
        while (j > 0) {
            Segment segment = commonSkip.head;
            if (segment == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = min;
            commonSkip.setSize$okio(commonSkip.size() - j2);
            j -= j2;
            int i = segment.pos + min;
            segment.pos = i;
            if (i == segment.limit) {
                commonSkip.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer commonSnapshot) {
        l.e(commonSnapshot, "$this$commonSnapshot");
        if (commonSnapshot.size() <= ((long) Integer.MAX_VALUE)) {
            return commonSnapshot.snapshot((int) commonSnapshot.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + commonSnapshot.size()).toString());
    }

    @NotNull
    public static final Segment commonWritableSegment(@NotNull Buffer commonWritableSegment, int i) {
        l.e(commonWritableSegment, "$this$commonWritableSegment");
        if (!(i >= 1 && i <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment segment = commonWritableSegment.head;
        if (segment != null) {
            l.b(segment);
            Segment segment2 = segment.prev;
            l.b(segment2);
            return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment take = SegmentPool.take();
        commonWritableSegment.head = take;
        take.prev = take;
        take.next = take;
        return take;
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull ByteString byteString, int i, int i2) {
        l.e(commonWrite, "$this$commonWrite");
        l.e(byteString, "byteString");
        byteString.write$okio(commonWrite, i, i2);
        return commonWrite;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer commonWrite, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.size();
        }
        l.e(commonWrite, "$this$commonWrite");
        l.e(byteString, "byteString");
        byteString.write$okio(commonWrite, i, i2);
        return commonWrite;
    }

    public static final long commonWriteAll(@NotNull Buffer commonWriteAll, @NotNull Source source) {
        l.e(commonWriteAll, "$this$commonWriteAll");
        l.e(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(commonWriteAll, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @NotNull
    public static final Buffer commonWriteByte(@NotNull Buffer commonWriteByte, int i) {
        l.e(commonWriteByte, "$this$commonWriteByte");
        Segment writableSegment$okio = commonWriteByte.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        commonWriteByte.setSize$okio(commonWriteByte.size() + 1);
        return commonWriteByte;
    }

    @NotNull
    public static final Buffer commonWriteDecimalLong(@NotNull Buffer commonWriteDecimalLong, long j) {
        boolean z;
        l.e(commonWriteDecimalLong, "$this$commonWriteDecimalLong");
        if (j == 0) {
            return commonWriteDecimalLong.writeByte(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return commonWriteDecimalLong.writeUtf8("-9223372036854775808");
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
        Segment writableSegment$okio = commonWriteDecimalLong.writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit + i;
        while (j != 0) {
            long j2 = 10;
            i2--;
            bArr[i2] = getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i2 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i;
        commonWriteDecimalLong.setSize$okio(commonWriteDecimalLong.size() + i);
        return commonWriteDecimalLong;
    }

    @NotNull
    public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull Buffer commonWriteHexadecimalUnsignedLong, long j) {
        l.e(commonWriteHexadecimalUnsignedLong, "$this$commonWriteHexadecimalUnsignedLong");
        if (j == 0) {
            return commonWriteHexadecimalUnsignedLong.writeByte(48);
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
        Segment writableSegment$okio = commonWriteHexadecimalUnsignedLong.writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        commonWriteHexadecimalUnsignedLong.setSize$okio(commonWriteHexadecimalUnsignedLong.size() + i);
        return commonWriteHexadecimalUnsignedLong;
    }

    @NotNull
    public static final Buffer commonWriteInt(@NotNull Buffer commonWriteInt, int i) {
        l.e(commonWriteInt, "$this$commonWriteInt");
        Segment writableSegment$okio = commonWriteInt.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        writableSegment$okio.limit = i2 + 4;
        commonWriteInt.setSize$okio(commonWriteInt.size() + 4);
        return commonWriteInt;
    }

    @NotNull
    public static final Buffer commonWriteLong(@NotNull Buffer commonWriteLong, long j) {
        l.e(commonWriteLong, "$this$commonWriteLong");
        Segment writableSegment$okio = commonWriteLong.writableSegment$okio(8);
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
        commonWriteLong.setSize$okio(commonWriteLong.size() + 8);
        return commonWriteLong;
    }

    @NotNull
    public static final Buffer commonWriteShort(@NotNull Buffer commonWriteShort, int i) {
        l.e(commonWriteShort, "$this$commonWriteShort");
        Segment writableSegment$okio = commonWriteShort.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        writableSegment$okio.limit = i2 + 2;
        commonWriteShort.setSize$okio(commonWriteShort.size() + 2);
        return commonWriteShort;
    }

    @NotNull
    public static final Buffer commonWriteUtf8(@NotNull Buffer commonWriteUtf8, @NotNull String string, int i, int i2) {
        long size;
        long j;
        l.e(commonWriteUtf8, "$this$commonWriteUtf8");
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
                Segment writableSegment$okio = commonWriteUtf8.writableSegment$okio(1);
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
                commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + i6);
                i = i4;
            } else {
                if (charAt < 2048) {
                    Segment writableSegment$okio2 = commonWriteUtf8.writableSegment$okio(2);
                    byte[] bArr2 = writableSegment$okio2.data;
                    int i7 = writableSegment$okio2.limit;
                    bArr2[i7] = (byte) ((charAt >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((charAt & '?') | 128);
                    writableSegment$okio2.limit = i7 + 2;
                    size = commonWriteUtf8.size();
                    j = 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    Segment writableSegment$okio3 = commonWriteUtf8.writableSegment$okio(3);
                    byte[] bArr3 = writableSegment$okio3.data;
                    int i8 = writableSegment$okio3.limit;
                    bArr3[i8] = (byte) ((charAt >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((charAt & '?') | 128);
                    writableSegment$okio3.limit = i8 + 3;
                    size = commonWriteUtf8.size();
                    j = 3;
                } else {
                    int i9 = i + 1;
                    char charAt3 = i9 < i2 ? string.charAt(i9) : (char) 0;
                    if (charAt > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                        commonWriteUtf8.writeByte(63);
                        i = i9;
                    } else {
                        int i10 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 65536;
                        Segment writableSegment$okio4 = commonWriteUtf8.writableSegment$okio(4);
                        byte[] bArr4 = writableSegment$okio4.data;
                        int i11 = writableSegment$okio4.limit;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        writableSegment$okio4.limit = i11 + 4;
                        commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 4);
                        i += 2;
                    }
                }
                commonWriteUtf8.setSize$okio(size + j);
                i++;
            }
        }
        return commonWriteUtf8;
    }

    @NotNull
    public static final Buffer commonWriteUtf8CodePoint(@NotNull Buffer commonWriteUtf8CodePoint, int i) {
        long size;
        long j;
        l.e(commonWriteUtf8CodePoint, "$this$commonWriteUtf8CodePoint");
        if (i < 128) {
            commonWriteUtf8CodePoint.writeByte(i);
        } else {
            if (i < 2048) {
                Segment writableSegment$okio = commonWriteUtf8CodePoint.writableSegment$okio(2);
                byte[] bArr = writableSegment$okio.data;
                int i2 = writableSegment$okio.limit;
                bArr[i2] = (byte) ((i >> 6) | 192);
                bArr[i2 + 1] = (byte) ((i & 63) | 128);
                writableSegment$okio.limit = i2 + 2;
                size = commonWriteUtf8CodePoint.size();
                j = 2;
            } else if (55296 <= i && 57343 >= i) {
                commonWriteUtf8CodePoint.writeByte(63);
            } else if (i < 65536) {
                Segment writableSegment$okio2 = commonWriteUtf8CodePoint.writableSegment$okio(3);
                byte[] bArr2 = writableSegment$okio2.data;
                int i3 = writableSegment$okio2.limit;
                bArr2[i3] = (byte) ((i >> 12) | 224);
                bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
                bArr2[i3 + 2] = (byte) ((i & 63) | 128);
                writableSegment$okio2.limit = i3 + 3;
                size = commonWriteUtf8CodePoint.size();
                j = 3;
            } else {
                if (i > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: 0x" + -Util.toHexString(i));
                }
                Segment writableSegment$okio3 = commonWriteUtf8CodePoint.writableSegment$okio(4);
                byte[] bArr3 = writableSegment$okio3.data;
                int i4 = writableSegment$okio3.limit;
                bArr3[i4] = (byte) ((i >> 18) | 240);
                bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
                bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
                bArr3[i4 + 3] = (byte) ((i & 63) | 128);
                writableSegment$okio3.limit = i4 + 4;
                size = commonWriteUtf8CodePoint.size();
                j = 4;
            }
            commonWriteUtf8CodePoint.setSize$okio(size + j);
        }
        return commonWriteUtf8CodePoint;
    }

    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(@NotNull Segment segment, int i, @NotNull byte[] bytes, int i2, int i3) {
        l.e(segment, "segment");
        l.e(bytes, "bytes");
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                l.b(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i = segment.pos;
                i4 = segment.limit;
            }
            if (bArr[i] != bytes[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @NotNull
    public static final String readUtf8Line(@NotNull Buffer readUtf8Line, long j) {
        l.e(readUtf8Line, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (readUtf8Line.getByte(j2) == ((byte) 13)) {
                String readUtf8 = readUtf8Line.readUtf8(j2);
                readUtf8Line.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8Line.readUtf8(j);
        readUtf8Line.skip(1L);
        return readUtf82;
    }

    public static final Object seek(@NotNull Buffer seek, long j, @NotNull p lambda) {
        l.e(seek, "$this$seek");
        l.e(lambda, "lambda");
        Segment segment = seek.head;
        if (segment == null) {
            return lambda.invoke(null, -1L);
        }
        if (seek.size() - j < j) {
            long size = seek.size();
            while (size > j) {
                segment = segment.prev;
                l.b(segment);
                size -= segment.limit - segment.pos;
            }
            return lambda.invoke(segment, Long.valueOf(size));
        }
        long j2 = 0;
        while (true) {
            long j3 = (segment.limit - segment.pos) + j2;
            if (j3 > j) {
                return lambda.invoke(segment, Long.valueOf(j2));
            }
            segment = segment.next;
            l.b(segment);
            j2 = j3;
        }
    }

    public static final int selectPrefix(@NotNull Buffer selectPrefix, @NotNull Options options, boolean z) {
        int i;
        int i2;
        Segment segment;
        int i3;
        int i4;
        l.e(selectPrefix, "$this$selectPrefix");
        l.e(options, "options");
        Segment segment2 = selectPrefix.head;
        if (segment2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i5 = segment2.pos;
        int i6 = segment2.limit;
        int[] trie$okio = options.getTrie$okio();
        Segment segment3 = segment2;
        int i7 = 0;
        int i8 = -1;
        loop0: while (true) {
            int i9 = i7 + 1;
            int i10 = trie$okio[i7];
            int i11 = i7 + 2;
            int i12 = trie$okio[i9];
            if (i12 != -1) {
                i8 = i12;
            }
            if (segment3 == null) {
                break;
            }
            if (i10 >= 0) {
                i = i5 + 1;
                int i13 = bArr[i5] & 255;
                int i14 = i11 + i10;
                while (i11 != i14) {
                    if (i13 == trie$okio[i11]) {
                        i2 = trie$okio[i11 + i10];
                        if (i == i6) {
                            segment3 = segment3.next;
                            l.b(segment3);
                            i = segment3.pos;
                            bArr = segment3.data;
                            i6 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i11++;
                    }
                }
                return i8;
            }
            int i15 = i11 + (i10 * (-1));
            while (true) {
                int i16 = i5 + 1;
                int i17 = i11 + 1;
                if ((bArr[i5] & 255) != trie$okio[i11]) {
                    return i8;
                }
                boolean z2 = i17 == i15;
                if (i16 == i6) {
                    l.b(segment3);
                    Segment segment4 = segment3.next;
                    l.b(segment4);
                    i4 = segment4.pos;
                    byte[] bArr2 = segment4.data;
                    i3 = segment4.limit;
                    if (segment4 != segment2) {
                        segment = segment4;
                        bArr = bArr2;
                    } else {
                        if (!z2) {
                            break loop0;
                        }
                        bArr = bArr2;
                        segment = null;
                    }
                } else {
                    segment = segment3;
                    i3 = i6;
                    i4 = i16;
                }
                if (z2) {
                    i2 = trie$okio[i17];
                    i = i4;
                    i6 = i3;
                    segment3 = segment;
                    break;
                }
                i5 = i4;
                i6 = i3;
                segment3 = segment;
                i11 = i17;
            }
            if (i2 >= 0) {
                return i2;
            }
            i7 = -i2;
            i5 = i;
        }
        if (z) {
            return -2;
        }
        return i8;
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final long commonIndexOf(@NotNull Buffer commonIndexOf, @NotNull ByteString bytes, long j) {
        long j2;
        int i;
        long j3 = j;
        l.e(commonIndexOf, "$this$commonIndexOf");
        l.e(bytes, "bytes");
        if (!(bytes.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j4 = 0;
        if (!(j3 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
        }
        Segment segment = commonIndexOf.head;
        if (segment == null) {
            return -1L;
        }
        if (commonIndexOf.size() - j3 < j3) {
            j2 = commonIndexOf.size();
            while (j2 > j3) {
                segment = segment.prev;
                l.b(segment);
                j2 -= segment.limit - segment.pos;
            }
            byte[] internalArray$okio = bytes.internalArray$okio();
            byte b = internalArray$okio[0];
            int size = bytes.size();
            long size2 = (commonIndexOf.size() - size) + 1;
            while (j2 < size2) {
                byte[] bArr = segment.data;
                int min = (int) Math.min(segment.limit, (segment.pos + size2) - j2);
                i = (int) ((segment.pos + j3) - j2);
                while (i < min) {
                    if (bArr[i] != b || !rangeEquals(segment, i + 1, internalArray$okio, 1, size)) {
                        i++;
                    }
                }
                j2 += segment.limit - segment.pos;
                segment = segment.next;
                l.b(segment);
                j3 = j2;
            }
            return -1L;
        }
        while (true) {
            long j5 = (segment.limit - segment.pos) + j4;
            if (j5 > j3) {
                break;
            }
            segment = segment.next;
            l.b(segment);
            j4 = j5;
        }
        byte[] internalArray$okio2 = bytes.internalArray$okio();
        byte b2 = internalArray$okio2[0];
        int size3 = bytes.size();
        long size4 = (commonIndexOf.size() - size3) + 1;
        j2 = j4;
        while (j2 < size4) {
            byte[] bArr2 = segment.data;
            long j6 = size4;
            int min2 = (int) Math.min(segment.limit, (segment.pos + size4) - j2);
            i = (int) ((segment.pos + j3) - j2);
            while (i < min2) {
                if (bArr2[i] == b2 && rangeEquals(segment, i + 1, internalArray$okio2, 1, size3)) {
                }
                i++;
            }
            j2 += segment.limit - segment.pos;
            segment = segment.next;
            l.b(segment);
            size4 = j6;
            j3 = j2;
        }
        return -1L;
        return (i - segment.pos) + j2;
    }

    public static final int commonRead(@NotNull Buffer commonRead, @NotNull byte[] sink, int i, int i2) {
        l.e(commonRead, "$this$commonRead");
        l.e(sink, "sink");
        -Util.checkOffsetAndCount(sink.length, i, i2);
        Segment segment = commonRead.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i3 = segment.pos;
        g.c(bArr, sink, i, i3, i3 + min);
        segment.pos += min;
        commonRead.setSize$okio(commonRead.size() - min);
        if (segment.pos == segment.limit) {
            commonRead.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer commonReadByteArray, long j) {
        l.e(commonReadByteArray, "$this$commonReadByteArray");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (commonReadByteArray.size() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        commonReadByteArray.readFully(bArr);
        return bArr;
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer commonReadByteString, long j) {
        l.e(commonReadByteString, "$this$commonReadByteString");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (commonReadByteString.size() < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(commonReadByteString.readByteArray(j));
        }
        ByteString snapshot = commonReadByteString.snapshot((int) j);
        commonReadByteString.skip(j);
        return snapshot;
    }

    public static final void commonReadFully(@NotNull Buffer commonReadFully, @NotNull byte[] sink) {
        l.e(commonReadFully, "$this$commonReadFully");
        l.e(sink, "sink");
        int i = 0;
        while (i < sink.length) {
            int read = commonReadFully.read(sink, i, sink.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer commonSnapshot, int i) {
        l.e(commonSnapshot, "$this$commonSnapshot");
        if (i == 0) {
            return ByteString.EMPTY;
        }
        -Util.checkOffsetAndCount(commonSnapshot.size(), 0L, i);
        Segment segment = commonSnapshot.head;
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
        Segment segment2 = commonSnapshot.head;
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
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull Source source, long j) {
        l.e(commonWrite, "$this$commonWrite");
        l.e(source, "source");
        while (j > 0) {
            long read = source.read(commonWrite, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return commonWrite;
    }

    public static final long commonRead(@NotNull Buffer commonRead, @NotNull Buffer sink, long j) {
        l.e(commonRead, "$this$commonRead");
        l.e(sink, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (commonRead.size() == 0) {
            return -1L;
        }
        if (j > commonRead.size()) {
            j = commonRead.size();
        }
        sink.write(commonRead, j);
        return j;
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull byte[] source) {
        l.e(commonWrite, "$this$commonWrite");
        l.e(source, "source");
        return commonWrite.write(source, 0, source.length);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull byte[] source, int i, int i2) {
        l.e(commonWrite, "$this$commonWrite");
        l.e(source, "source");
        long j = i2;
        -Util.checkOffsetAndCount(source.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = commonWrite.writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            int i4 = i + min;
            g.c(source, writableSegment$okio.data, writableSegment$okio.limit, i, i4);
            writableSegment$okio.limit += min;
            i = i4;
        }
        commonWrite.setSize$okio(commonWrite.size() + j);
        return commonWrite;
    }

    public static final void commonWrite(@NotNull Buffer commonWrite, @NotNull Buffer source, long j) {
        Segment segment;
        l.e(commonWrite, "$this$commonWrite");
        l.e(source, "source");
        if (!(source != commonWrite)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        -Util.checkOffsetAndCount(source.size(), 0L, j);
        while (j > 0) {
            Segment segment2 = source.head;
            l.b(segment2);
            int i = segment2.limit;
            l.b(source.head);
            if (j < i - r2.pos) {
                Segment segment3 = commonWrite.head;
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
                        commonWrite.setSize$okio(commonWrite.size() + j);
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
            Segment segment7 = commonWrite.head;
            if (segment7 == null) {
                commonWrite.head = segment6;
                segment6.prev = segment6;
                segment6.next = segment6;
            } else {
                l.b(segment7);
                Segment segment8 = segment7.prev;
                l.b(segment8);
                segment8.push(segment6).compact();
            }
            source.setSize$okio(source.size() - j2);
            commonWrite.setSize$okio(commonWrite.size() + j2);
            j -= j2;
        }
    }
}
