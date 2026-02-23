package okio.internal;

import E8.a;
import java.io.EOFException;
import kotlin.jvm.internal.l;
import okio.-Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RealBufferedSourceKt {
    public static final void commonClose(@NotNull RealBufferedSource commonClose) {
        l.e(commonClose, "$this$commonClose");
        if (commonClose.closed) {
            return;
        }
        commonClose.closed = true;
        commonClose.source.close();
        commonClose.bufferField.clear();
    }

    public static final boolean commonExhausted(@NotNull RealBufferedSource commonExhausted) {
        l.e(commonExhausted, "$this$commonExhausted");
        if (!commonExhausted.closed) {
            return commonExhausted.bufferField.exhausted() && commonExhausted.source.read(commonExhausted.bufferField, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(@NotNull RealBufferedSource commonIndexOf, byte b, long j, long j2) {
        l.e(commonIndexOf, "$this$commonIndexOf");
        if (!(!commonIndexOf.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long indexOf = commonIndexOf.bufferField.indexOf(b, j, j2);
            if (indexOf == -1) {
                long size = commonIndexOf.bufferField.size();
                if (size >= j2 || commonIndexOf.source.read(commonIndexOf.bufferField, 8192) == -1) {
                    break;
                }
                j = Math.max(j, size);
            } else {
                return indexOf;
            }
        }
        return -1L;
    }

    public static final long commonIndexOfElement(@NotNull RealBufferedSource commonIndexOfElement, @NotNull ByteString targetBytes, long j) {
        l.e(commonIndexOfElement, "$this$commonIndexOfElement");
        l.e(targetBytes, "targetBytes");
        if (!(!commonIndexOfElement.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOfElement = commonIndexOfElement.bufferField.indexOfElement(targetBytes, j);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = commonIndexOfElement.bufferField.size();
            if (commonIndexOfElement.source.read(commonIndexOfElement.bufferField, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, size);
        }
    }

    @NotNull
    public static final BufferedSource commonPeek(@NotNull RealBufferedSource commonPeek) {
        l.e(commonPeek, "$this$commonPeek");
        return Okio.buffer(new PeekSource(commonPeek));
    }

    public static final boolean commonRangeEquals(@NotNull RealBufferedSource commonRangeEquals, long j, @NotNull ByteString bytes, int i, int i2) {
        l.e(commonRangeEquals, "$this$commonRangeEquals");
        l.e(bytes, "bytes");
        if (!(!commonRangeEquals.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j < 0 || i < 0 || i2 < 0 || bytes.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!commonRangeEquals.request(1 + j2) || commonRangeEquals.bufferField.getByte(j2) != bytes.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(@NotNull RealBufferedSource commonRead, @NotNull byte[] sink, int i, int i2) {
        l.e(commonRead, "$this$commonRead");
        l.e(sink, "sink");
        long j = i2;
        -Util.checkOffsetAndCount(sink.length, i, j);
        if (commonRead.bufferField.size() == 0 && commonRead.source.read(commonRead.bufferField, 8192) == -1) {
            return -1;
        }
        return commonRead.bufferField.read(sink, i, (int) Math.min(j, commonRead.bufferField.size()));
    }

    public static final long commonReadAll(@NotNull RealBufferedSource commonReadAll, @NotNull Sink sink) {
        Buffer buffer;
        l.e(commonReadAll, "$this$commonReadAll");
        l.e(sink, "sink");
        long j = 0;
        while (true) {
            long read = commonReadAll.source.read(commonReadAll.bufferField, 8192);
            buffer = commonReadAll.bufferField;
            if (read == -1) {
                break;
            }
            long completeSegmentByteCount = buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j += completeSegmentByteCount;
                sink.write(commonReadAll.bufferField, completeSegmentByteCount);
            }
        }
        if (buffer.size() <= 0) {
            return j;
        }
        long size = j + commonReadAll.bufferField.size();
        Buffer buffer2 = commonReadAll.bufferField;
        sink.write(buffer2, buffer2.size());
        return size;
    }

    public static final byte commonReadByte(@NotNull RealBufferedSource commonReadByte) {
        l.e(commonReadByte, "$this$commonReadByte");
        commonReadByte.require(1L);
        return commonReadByte.bufferField.readByte();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource commonReadByteArray) {
        l.e(commonReadByteArray, "$this$commonReadByteArray");
        commonReadByteArray.bufferField.writeAll(commonReadByteArray.source);
        return commonReadByteArray.bufferField.readByteArray();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource commonReadByteString) {
        l.e(commonReadByteString, "$this$commonReadByteString");
        commonReadByteString.bufferField.writeAll(commonReadByteString.source);
        return commonReadByteString.bufferField.readByteString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("Expected leading [0-9] or '-' character but was 0x");
        r1 = java.lang.Integer.toString(r8, E8.a.a(E8.a.a(16)));
        kotlin.jvm.internal.l.d(r1, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        r0.append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
    
        throw new java.lang.NumberFormatException(r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(@org.jetbrains.annotations.NotNull okio.RealBufferedSource r10) {
        /*
            java.lang.String r0 = "$this$commonReadDecimalLong"
            kotlin.jvm.internal.l.e(r10, r0)
            r0 = 1
            r10.require(r0)
            r2 = 0
            r4 = r2
        Ld:
            long r6 = r4 + r0
            boolean r8 = r10.request(r6)
            if (r8 == 0) goto L5e
            okio.Buffer r8 = r10.bufferField
            byte r8 = r8.getByte(r4)
            r9 = 48
            byte r9 = (byte) r9
            if (r8 < r9) goto L25
            r9 = 57
            byte r9 = (byte) r9
            if (r8 <= r9) goto L2f
        L25:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L31
            r4 = 45
            byte r4 = (byte) r4
            if (r8 == r4) goto L2f
            goto L31
        L2f:
            r4 = r6
            goto Ld
        L31:
            if (r9 == 0) goto L34
            goto L5e
        L34:
            java.lang.NumberFormatException r10 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9] or '-' character but was 0x"
            r0.append(r1)
            r1 = 16
            int r1 = E8.a.a(r1)
            int r1 = E8.a.a(r1)
            java.lang.String r1 = java.lang.Integer.toString(r8, r1)
            java.lang.String r2 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.l.d(r1, r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L5e:
            okio.Buffer r10 = r10.bufferField
            long r0 = r10.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.RealBufferedSourceKt.commonReadDecimalLong(okio.RealBufferedSource):long");
    }

    public static final void commonReadFully(@NotNull RealBufferedSource commonReadFully, @NotNull Buffer sink, long j) {
        l.e(commonReadFully, "$this$commonReadFully");
        l.e(sink, "sink");
        try {
            commonReadFully.require(j);
            commonReadFully.bufferField.readFully(sink, j);
        } catch (EOFException e) {
            sink.writeAll(commonReadFully.bufferField);
            throw e;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(@NotNull RealBufferedSource commonReadHexadecimalUnsignedLong) {
        byte b;
        l.e(commonReadHexadecimalUnsignedLong, "$this$commonReadHexadecimalUnsignedLong");
        commonReadHexadecimalUnsignedLong.require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!commonReadHexadecimalUnsignedLong.request(i2)) {
                break;
            }
            b = commonReadHexadecimalUnsignedLong.bufferField.getByte(i);
            if ((b < ((byte) 48) || b > ((byte) 57)) && ((b < ((byte) 97) || b > ((byte) 102)) && (b < ((byte) 65) || b > ((byte) 70)))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            String num = Integer.toString(b, a.a(a.a(16)));
            l.d(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(num);
            throw new NumberFormatException(sb.toString());
        }
        return commonReadHexadecimalUnsignedLong.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(@NotNull RealBufferedSource commonReadInt) {
        l.e(commonReadInt, "$this$commonReadInt");
        commonReadInt.require(4L);
        return commonReadInt.bufferField.readInt();
    }

    public static final int commonReadIntLe(@NotNull RealBufferedSource commonReadIntLe) {
        l.e(commonReadIntLe, "$this$commonReadIntLe");
        commonReadIntLe.require(4L);
        return commonReadIntLe.bufferField.readIntLe();
    }

    public static final long commonReadLong(@NotNull RealBufferedSource commonReadLong) {
        l.e(commonReadLong, "$this$commonReadLong");
        commonReadLong.require(8L);
        return commonReadLong.bufferField.readLong();
    }

    public static final long commonReadLongLe(@NotNull RealBufferedSource commonReadLongLe) {
        l.e(commonReadLongLe, "$this$commonReadLongLe");
        commonReadLongLe.require(8L);
        return commonReadLongLe.bufferField.readLongLe();
    }

    public static final short commonReadShort(@NotNull RealBufferedSource commonReadShort) {
        l.e(commonReadShort, "$this$commonReadShort");
        commonReadShort.require(2L);
        return commonReadShort.bufferField.readShort();
    }

    public static final short commonReadShortLe(@NotNull RealBufferedSource commonReadShortLe) {
        l.e(commonReadShortLe, "$this$commonReadShortLe");
        commonReadShortLe.require(2L);
        return commonReadShortLe.bufferField.readShortLe();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource commonReadUtf8) {
        l.e(commonReadUtf8, "$this$commonReadUtf8");
        commonReadUtf8.bufferField.writeAll(commonReadUtf8.source);
        return commonReadUtf8.bufferField.readUtf8();
    }

    public static final int commonReadUtf8CodePoint(@NotNull RealBufferedSource commonReadUtf8CodePoint) {
        long j;
        l.e(commonReadUtf8CodePoint, "$this$commonReadUtf8CodePoint");
        commonReadUtf8CodePoint.require(1L);
        byte b = commonReadUtf8CodePoint.bufferField.getByte(0L);
        if ((b & 224) == 192) {
            j = 2;
        } else {
            if ((b & 240) != 224) {
                if ((b & 248) == 240) {
                    j = 4;
                }
                return commonReadUtf8CodePoint.bufferField.readUtf8CodePoint();
            }
            j = 3;
        }
        commonReadUtf8CodePoint.require(j);
        return commonReadUtf8CodePoint.bufferField.readUtf8CodePoint();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull RealBufferedSource commonReadUtf8Line) {
        l.e(commonReadUtf8Line, "$this$commonReadUtf8Line");
        long indexOf = commonReadUtf8Line.indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(commonReadUtf8Line.bufferField, indexOf);
        }
        if (commonReadUtf8Line.bufferField.size() != 0) {
            return commonReadUtf8Line.readUtf8(commonReadUtf8Line.bufferField.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull RealBufferedSource commonReadUtf8LineStrict, long j) {
        l.e(commonReadUtf8LineStrict, "$this$commonReadUtf8LineStrict");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        byte b = (byte) 10;
        long indexOf = commonReadUtf8LineStrict.indexOf(b, 0L, j2);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(commonReadUtf8LineStrict.bufferField, indexOf);
        }
        if (j2 < Long.MAX_VALUE && commonReadUtf8LineStrict.request(j2) && commonReadUtf8LineStrict.bufferField.getByte(j2 - 1) == ((byte) 13) && commonReadUtf8LineStrict.request(1 + j2) && commonReadUtf8LineStrict.bufferField.getByte(j2) == b) {
            return BufferKt.readUtf8Line(commonReadUtf8LineStrict.bufferField, j2);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = commonReadUtf8LineStrict.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(commonReadUtf8LineStrict.bufferField.size(), j) + " content=" + buffer.readByteString().hex() + "…");
    }

    public static final boolean commonRequest(@NotNull RealBufferedSource commonRequest, long j) {
        l.e(commonRequest, "$this$commonRequest");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(!commonRequest.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (commonRequest.bufferField.size() < j) {
            if (commonRequest.source.read(commonRequest.bufferField, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final void commonRequire(@NotNull RealBufferedSource commonRequire, long j) {
        l.e(commonRequire, "$this$commonRequire");
        if (!commonRequire.request(j)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(@NotNull RealBufferedSource commonSelect, @NotNull Options options) {
        l.e(commonSelect, "$this$commonSelect");
        l.e(options, "options");
        if (!(!commonSelect.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int selectPrefix = BufferKt.selectPrefix(commonSelect.bufferField, options, true);
            if (selectPrefix != -2) {
                if (selectPrefix == -1) {
                    return -1;
                }
                commonSelect.bufferField.skip(options.getByteStrings$okio()[selectPrefix].size());
                return selectPrefix;
            }
        } while (commonSelect.source.read(commonSelect.bufferField, 8192) != -1);
        return -1;
    }

    public static final void commonSkip(@NotNull RealBufferedSource commonSkip, long j) {
        l.e(commonSkip, "$this$commonSkip");
        if (!(!commonSkip.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j > 0) {
            if (commonSkip.bufferField.size() == 0 && commonSkip.source.read(commonSkip.bufferField, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, commonSkip.bufferField.size());
            commonSkip.bufferField.skip(min);
            j -= min;
        }
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSource commonTimeout) {
        l.e(commonTimeout, "$this$commonTimeout");
        return commonTimeout.source.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSource commonToString) {
        l.e(commonToString, "$this$commonToString");
        return "buffer(" + commonToString.source + ')';
    }

    public static final long commonIndexOf(@NotNull RealBufferedSource commonIndexOf, @NotNull ByteString bytes, long j) {
        l.e(commonIndexOf, "$this$commonIndexOf");
        l.e(bytes, "bytes");
        if (!(!commonIndexOf.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOf = commonIndexOf.bufferField.indexOf(bytes, j);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = commonIndexOf.bufferField.size();
            if (commonIndexOf.source.read(commonIndexOf.bufferField, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, (size - bytes.size()) + 1);
        }
    }

    public static final long commonRead(@NotNull RealBufferedSource commonRead, @NotNull Buffer sink, long j) {
        l.e(commonRead, "$this$commonRead");
        l.e(sink, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(true ^ commonRead.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (commonRead.bufferField.size() == 0 && commonRead.source.read(commonRead.bufferField, 8192) == -1) {
            return -1L;
        }
        return commonRead.bufferField.read(sink, Math.min(j, commonRead.bufferField.size()));
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource commonReadByteArray, long j) {
        l.e(commonReadByteArray, "$this$commonReadByteArray");
        commonReadByteArray.require(j);
        return commonReadByteArray.bufferField.readByteArray(j);
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource commonReadByteString, long j) {
        l.e(commonReadByteString, "$this$commonReadByteString");
        commonReadByteString.require(j);
        return commonReadByteString.bufferField.readByteString(j);
    }

    public static final void commonReadFully(@NotNull RealBufferedSource commonReadFully, @NotNull byte[] sink) {
        l.e(commonReadFully, "$this$commonReadFully");
        l.e(sink, "sink");
        try {
            commonReadFully.require(sink.length);
            commonReadFully.bufferField.readFully(sink);
        } catch (EOFException e) {
            int i = 0;
            while (commonReadFully.bufferField.size() > 0) {
                Buffer buffer = commonReadFully.bufferField;
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
    public static final String commonReadUtf8(@NotNull RealBufferedSource commonReadUtf8, long j) {
        l.e(commonReadUtf8, "$this$commonReadUtf8");
        commonReadUtf8.require(j);
        return commonReadUtf8.bufferField.readUtf8(j);
    }
}
