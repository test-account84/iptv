package okio.internal;

import kotlin.jvm.internal.l;
import l8.g;
import okio.-Util;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w8.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class SegmentedByteStringKt {
    public static final /* synthetic */ void access$forEachSegment(SegmentedByteString segmentedByteString, int i, int i2, q qVar) {
        forEachSegment(segmentedByteString, i, i2, qVar);
    }

    public static final int binarySearch(@NotNull int[] binarySearch, int i, int i2, int i3) {
        l.e(binarySearch, "$this$binarySearch");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = binarySearch[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else {
                if (i6 <= i) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final boolean commonEquals(@NotNull SegmentedByteString commonEquals, @Nullable Object obj) {
        l.e(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == commonEquals.size() && commonEquals.rangeEquals(0, byteString, 0, commonEquals.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@NotNull SegmentedByteString commonGetSize) {
        l.e(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getDirectory$okio()[commonGetSize.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(@NotNull SegmentedByteString commonHashCode) {
        l.e(commonHashCode, "$this$commonHashCode");
        int hashCode$okio = commonHashCode.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = commonHashCode.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        while (i < length) {
            int i4 = commonHashCode.getDirectory$okio()[length + i];
            int i5 = commonHashCode.getDirectory$okio()[i];
            byte[] bArr = commonHashCode.getSegments$okio()[i];
            int i6 = (i5 - i2) + i4;
            while (i4 < i6) {
                i3 = (i3 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i2 = i5;
        }
        commonHashCode.setHashCode$okio(i3);
        return i3;
    }

    public static final byte commonInternalGet(@NotNull SegmentedByteString commonInternalGet, int i) {
        l.e(commonInternalGet, "$this$commonInternalGet");
        -Util.checkOffsetAndCount(commonInternalGet.getDirectory$okio()[commonInternalGet.getSegments$okio().length - 1], i, 1L);
        int segment = segment(commonInternalGet, i);
        return commonInternalGet.getSegments$okio()[segment][(i - (segment == 0 ? 0 : commonInternalGet.getDirectory$okio()[segment - 1])) + commonInternalGet.getDirectory$okio()[commonInternalGet.getSegments$okio().length + segment]];
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString commonRangeEquals, int i, @NotNull ByteString other, int i2, int i3) {
        l.e(commonRangeEquals, "$this$commonRangeEquals");
        l.e(other, "other");
        if (i < 0 || i > commonRangeEquals.size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = segment(commonRangeEquals, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : commonRangeEquals.getDirectory$okio()[segment - 1];
            int i6 = commonRangeEquals.getDirectory$okio()[segment] - i5;
            int i7 = commonRangeEquals.getDirectory$okio()[commonRangeEquals.getSegments$okio().length + segment];
            int min = Math.min(i4, i6 + i5) - i;
            if (!other.rangeEquals(i2, commonRangeEquals.getSegments$okio()[segment], i7 + (i - i5), min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull SegmentedByteString commonSubstring, int i, int i2) {
        l.e(commonSubstring, "$this$commonSubstring");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
        }
        if (!(i2 <= commonSubstring.size())) {
            throw new IllegalArgumentException(("endIndex=" + i2 + " > length(" + commonSubstring.size() + ')').toString());
        }
        int i3 = i2 - i;
        if (!(i3 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + i2 + " < beginIndex=" + i).toString());
        }
        if (i == 0 && i2 == commonSubstring.size()) {
            return commonSubstring;
        }
        if (i == i2) {
            return ByteString.EMPTY;
        }
        int segment = segment(commonSubstring, i);
        int segment2 = segment(commonSubstring, i2 - 1);
        byte[][] bArr = (byte[][]) g.h(commonSubstring.getSegments$okio(), segment, segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (segment <= segment2) {
            int i4 = segment;
            int i5 = 0;
            while (true) {
                iArr[i5] = Math.min(commonSubstring.getDirectory$okio()[i4] - i, i3);
                int i6 = i5 + 1;
                iArr[i5 + bArr.length] = commonSubstring.getDirectory$okio()[commonSubstring.getSegments$okio().length + i4];
                if (i4 == segment2) {
                    break;
                }
                i4++;
                i5 = i6;
            }
        }
        int i7 = segment != 0 ? commonSubstring.getDirectory$okio()[segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i - i7);
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull SegmentedByteString commonToByteArray) {
        l.e(commonToByteArray, "$this$commonToByteArray");
        byte[] bArr = new byte[commonToByteArray.size()];
        int length = commonToByteArray.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = commonToByteArray.getDirectory$okio()[length + i];
            int i5 = commonToByteArray.getDirectory$okio()[i];
            int i6 = i5 - i2;
            g.c(commonToByteArray.getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public static final void commonWrite(@NotNull SegmentedByteString commonWrite, @NotNull Buffer buffer, int i, int i2) {
        l.e(commonWrite, "$this$commonWrite");
        l.e(buffer, "buffer");
        int i3 = i2 + i;
        int segment = segment(commonWrite, i);
        while (i < i3) {
            int i4 = segment == 0 ? 0 : commonWrite.getDirectory$okio()[segment - 1];
            int i5 = commonWrite.getDirectory$okio()[segment] - i4;
            int i6 = commonWrite.getDirectory$okio()[commonWrite.getSegments$okio().length + segment];
            int min = Math.min(i3, i5 + i4) - i;
            int i7 = i6 + (i - i4);
            Segment segment2 = new Segment(commonWrite.getSegments$okio()[segment], i7, i7 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                l.b(segment3);
                Segment segment4 = segment3.prev;
                l.b(segment4);
                segment4.push(segment2);
            }
            i += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + commonWrite.size());
    }

    private static final void forEachSegment(SegmentedByteString segmentedByteString, int i, int i2, q qVar) {
        int segment = segment(segmentedByteString, i);
        while (i < i2) {
            int i3 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i4 = segmentedByteString.getDirectory$okio()[segment] - i3;
            int i5 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i2, i4 + i3) - i;
            qVar.e(segmentedByteString.getSegments$okio()[segment], Integer.valueOf(i5 + (i - i3)), Integer.valueOf(min));
            i += min;
            segment++;
        }
    }

    public static final int segment(@NotNull SegmentedByteString segment, int i) {
        l.e(segment, "$this$segment");
        int binarySearch = binarySearch(segment.getDirectory$okio(), i + 1, 0, segment.getSegments$okio().length);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString commonRangeEquals, int i, @NotNull byte[] other, int i2, int i3) {
        l.e(commonRangeEquals, "$this$commonRangeEquals");
        l.e(other, "other");
        if (i < 0 || i > commonRangeEquals.size() - i3 || i2 < 0 || i2 > other.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = segment(commonRangeEquals, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : commonRangeEquals.getDirectory$okio()[segment - 1];
            int i6 = commonRangeEquals.getDirectory$okio()[segment] - i5;
            int i7 = commonRangeEquals.getDirectory$okio()[commonRangeEquals.getSegments$okio().length + segment];
            int min = Math.min(i4, i6 + i5) - i;
            if (!-Util.arrayRangeEquals(commonRangeEquals.getSegments$okio()[segment], i7 + (i - i5), other, i2, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    public static final void forEachSegment(@NotNull SegmentedByteString forEachSegment, @NotNull q action) {
        l.e(forEachSegment, "$this$forEachSegment");
        l.e(action, "action");
        int length = forEachSegment.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = forEachSegment.getDirectory$okio()[length + i];
            int i4 = forEachSegment.getDirectory$okio()[i];
            action.e(forEachSegment.getSegments$okio()[i], Integer.valueOf(i3), Integer.valueOf(i4 - i2));
            i++;
            i2 = i4;
        }
    }
}
