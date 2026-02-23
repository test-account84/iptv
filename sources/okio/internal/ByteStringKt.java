package okio.internal;

import E8.n;
import java.util.Arrays;
import kotlin.jvm.internal.l;
import l8.g;
import okio.-Base64;
import okio.-Platform;
import okio.-Util;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ByteStringKt {

    @NotNull
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final /* synthetic */ int access$codePointIndexToCharIndex(byte[] bArr, int i) {
        return codePointIndexToCharIndex(bArr, i);
    }

    public static final /* synthetic */ int access$decodeHexDigit(char c) {
        return decodeHexDigit(c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:207:0x005b, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int codePointIndexToCharIndex(byte[] r18, int r19) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }

    @NotNull
    public static final String commonBase64(@NotNull ByteString commonBase64) {
        l.e(commonBase64, "$this$commonBase64");
        return -Base64.encodeBase64$default(commonBase64.getData$okio(), null, 1, null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull ByteString commonBase64Url) {
        l.e(commonBase64Url, "$this$commonBase64Url");
        return -Base64.encodeBase64(commonBase64Url.getData$okio(), -Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@NotNull ByteString commonCompareTo, @NotNull ByteString other) {
        l.e(commonCompareTo, "$this$commonCompareTo");
        l.e(other, "other");
        int size = commonCompareTo.size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            int i2 = commonCompareTo.getByte(i) & 255;
            int i3 = other.getByte(i) & 255;
            if (i2 != i3) {
                return i2 < i3 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    @Nullable
    public static final ByteString commonDecodeBase64(@NotNull String commonDecodeBase64) {
        l.e(commonDecodeBase64, "$this$commonDecodeBase64");
        byte[] decodeBase64ToArray = -Base64.decodeBase64ToArray(commonDecodeBase64);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String commonDecodeHex) {
        l.e(commonDecodeHex, "$this$commonDecodeHex");
        if (!(commonDecodeHex.length() % 2 == 0)) {
            throw new IllegalArgumentException(("Unexpected hex string: " + commonDecodeHex).toString());
        }
        int length = commonDecodeHex.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((access$decodeHexDigit(commonDecodeHex.charAt(i2)) << 4) + access$decodeHexDigit(commonDecodeHex.charAt(i2 + 1)));
        }
        return new ByteString(bArr);
    }

    @NotNull
    public static final ByteString commonEncodeUtf8(@NotNull String commonEncodeUtf8) {
        l.e(commonEncodeUtf8, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(-Platform.asUtf8ToByteArray(commonEncodeUtf8));
        byteString.setUtf8$okio(commonEncodeUtf8);
        return byteString;
    }

    public static final boolean commonEndsWith(@NotNull ByteString commonEndsWith, @NotNull ByteString suffix) {
        l.e(commonEndsWith, "$this$commonEndsWith");
        l.e(suffix, "suffix");
        return commonEndsWith.rangeEquals(commonEndsWith.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEquals(@NotNull ByteString commonEquals, @Nullable Object obj) {
        l.e(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == commonEquals.getData$okio().length && byteString.rangeEquals(0, commonEquals.getData$okio(), 0, commonEquals.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@NotNull ByteString commonGetByte, int i) {
        l.e(commonGetByte, "$this$commonGetByte");
        return commonGetByte.getData$okio()[i];
    }

    public static final int commonGetSize(@NotNull ByteString commonGetSize) {
        l.e(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getData$okio().length;
    }

    public static final int commonHashCode(@NotNull ByteString commonHashCode) {
        l.e(commonHashCode, "$this$commonHashCode");
        int hashCode$okio = commonHashCode.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(commonHashCode.getData$okio());
        commonHashCode.setHashCode$okio(hashCode);
        return hashCode;
    }

    @NotNull
    public static final String commonHex(@NotNull ByteString commonHex) {
        l.e(commonHex, "$this$commonHex");
        char[] cArr = new char[commonHex.getData$okio().length * 2];
        int i = 0;
        for (byte b : commonHex.getData$okio()) {
            int i2 = i + 1;
            cArr[i] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = getHEX_DIGIT_CHARS()[b & 15];
        }
        return new String(cArr);
    }

    public static final int commonIndexOf(@NotNull ByteString commonIndexOf, @NotNull byte[] other, int i) {
        l.e(commonIndexOf, "$this$commonIndexOf");
        l.e(other, "other");
        int length = commonIndexOf.getData$okio().length - other.length;
        int max = Math.max(i, 0);
        if (max > length) {
            return -1;
        }
        while (!-Util.arrayRangeEquals(commonIndexOf.getData$okio(), max, other, 0, other.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull ByteString commonInternalArray) {
        l.e(commonInternalArray, "$this$commonInternalArray");
        return commonInternalArray.getData$okio();
    }

    public static final int commonLastIndexOf(@NotNull ByteString commonLastIndexOf, @NotNull ByteString other, int i) {
        l.e(commonLastIndexOf, "$this$commonLastIndexOf");
        l.e(other, "other");
        return commonLastIndexOf.lastIndexOf(other.internalArray$okio(), i);
    }

    @NotNull
    public static final ByteString commonOf(@NotNull byte[] data) {
        l.e(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        l.d(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@NotNull ByteString commonRangeEquals, int i, @NotNull ByteString other, int i2, int i3) {
        l.e(commonRangeEquals, "$this$commonRangeEquals");
        l.e(other, "other");
        return other.rangeEquals(i2, commonRangeEquals.getData$okio(), i, i3);
    }

    public static final boolean commonStartsWith(@NotNull ByteString commonStartsWith, @NotNull ByteString prefix) {
        l.e(commonStartsWith, "$this$commonStartsWith");
        l.e(prefix, "prefix");
        return commonStartsWith.rangeEquals(0, prefix, 0, prefix.size());
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull ByteString commonSubstring, int i, int i2) {
        l.e(commonSubstring, "$this$commonSubstring");
        if (!(i >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (i2 <= commonSubstring.getData$okio().length) {
            if (i2 - i >= 0) {
                return (i == 0 && i2 == commonSubstring.getData$okio().length) ? commonSubstring : new ByteString(g.g(commonSubstring.getData$okio(), i, i2));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + commonSubstring.getData$okio().length + ')').toString());
    }

    @NotNull
    public static final ByteString commonToAsciiLowercase(@NotNull ByteString commonToAsciiLowercase) {
        byte b;
        l.e(commonToAsciiLowercase, "$this$commonToAsciiLowercase");
        for (int i = 0; i < commonToAsciiLowercase.getData$okio().length; i++) {
            byte b2 = commonToAsciiLowercase.getData$okio()[i];
            byte b3 = (byte) 65;
            if (b2 >= b3 && b2 <= (b = (byte) 90)) {
                byte[] data$okio = commonToAsciiLowercase.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                l.d(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return commonToAsciiLowercase;
    }

    @NotNull
    public static final ByteString commonToAsciiUppercase(@NotNull ByteString commonToAsciiUppercase) {
        byte b;
        l.e(commonToAsciiUppercase, "$this$commonToAsciiUppercase");
        for (int i = 0; i < commonToAsciiUppercase.getData$okio().length; i++) {
            byte b2 = commonToAsciiUppercase.getData$okio()[i];
            byte b3 = (byte) 97;
            if (b2 >= b3 && b2 <= (b = (byte) 122)) {
                byte[] data$okio = commonToAsciiUppercase.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                l.d(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return commonToAsciiUppercase;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull ByteString commonToByteArray) {
        l.e(commonToByteArray, "$this$commonToByteArray");
        byte[] data$okio = commonToByteArray.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        l.d(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public static final ByteString commonToByteString(@NotNull byte[] commonToByteString, int i, int i2) {
        l.e(commonToByteString, "$this$commonToByteString");
        -Util.checkOffsetAndCount(commonToByteString.length, i, i2);
        return new ByteString(g.g(commonToByteString, i, i2 + i));
    }

    @NotNull
    public static final String commonToString(@NotNull ByteString byteString) {
        StringBuilder sb;
        StringBuilder sb2;
        ByteString commonToString = byteString;
        l.e(commonToString, "$this$commonToString");
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = access$codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (access$codePointIndexToCharIndex != -1) {
            String utf8 = byteString.utf8();
            if (utf8 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = utf8.substring(0, access$codePointIndexToCharIndex);
            l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String x = n.x(n.x(n.x(substring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (access$codePointIndexToCharIndex < utf8.length()) {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(byteString.getData$okio().length);
                sb.append(" text=");
                sb.append(x);
                sb.append("…]");
            } else {
                sb = new StringBuilder();
                sb.append("[text=");
                sb.append(x);
                sb.append(']');
            }
            return sb.toString();
        }
        if (byteString.getData$okio().length <= 64) {
            sb2 = new StringBuilder();
            sb2.append("[hex=");
            sb2.append(byteString.hex());
            sb2.append(']');
        } else {
            sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(byteString.getData$okio().length);
            sb2.append(" hex=");
            if (!(64 <= byteString.getData$okio().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
            }
            if (64 != byteString.getData$okio().length) {
                commonToString = new ByteString(g.g(byteString.getData$okio(), 0, 64));
            }
            sb2.append(commonToString.hex());
            sb2.append("…]");
        }
        return sb2.toString();
    }

    @NotNull
    public static final String commonUtf8(@NotNull ByteString commonUtf8) {
        l.e(commonUtf8, "$this$commonUtf8");
        String utf8$okio = commonUtf8.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = -Platform.toUtf8String(commonUtf8.internalArray$okio());
        commonUtf8.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(@NotNull ByteString commonWrite, @NotNull Buffer buffer, int i, int i2) {
        l.e(commonWrite, "$this$commonWrite");
        l.e(buffer, "buffer");
        buffer.write(commonWrite.getData$okio(), i, i2);
    }

    private static final int decodeHexDigit(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        if ('a' <= c && 'f' >= c) {
            return c - 'W';
        }
        if ('A' <= c && 'F' >= c) {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(@NotNull ByteString commonEndsWith, @NotNull byte[] suffix) {
        l.e(commonEndsWith, "$this$commonEndsWith");
        l.e(suffix, "suffix");
        return commonEndsWith.rangeEquals(commonEndsWith.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonLastIndexOf(@NotNull ByteString commonLastIndexOf, @NotNull byte[] other, int i) {
        l.e(commonLastIndexOf, "$this$commonLastIndexOf");
        l.e(other, "other");
        for (int min = Math.min(i, commonLastIndexOf.getData$okio().length - other.length); min >= 0; min--) {
            if (-Util.arrayRangeEquals(commonLastIndexOf.getData$okio(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@NotNull ByteString commonRangeEquals, int i, @NotNull byte[] other, int i2, int i3) {
        l.e(commonRangeEquals, "$this$commonRangeEquals");
        l.e(other, "other");
        return i >= 0 && i <= commonRangeEquals.getData$okio().length - i3 && i2 >= 0 && i2 <= other.length - i3 && -Util.arrayRangeEquals(commonRangeEquals.getData$okio(), i, other, i2, i3);
    }

    public static final boolean commonStartsWith(@NotNull ByteString commonStartsWith, @NotNull byte[] prefix) {
        l.e(commonStartsWith, "$this$commonStartsWith");
        l.e(prefix, "prefix");
        return commonStartsWith.rangeEquals(0, prefix, 0, prefix.length);
    }
}
