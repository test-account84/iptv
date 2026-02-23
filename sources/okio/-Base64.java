package okio;

import java.util.Arrays;
import kotlin.jvm.internal.l;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class -Base64 {

    @NotNull
    private static final byte[] BASE64;

    @NotNull
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    @Nullable
    public static final byte[] decodeBase64ToArray(@NotNull String decodeBase64ToArray) {
        int i;
        char charAt;
        l.e(decodeBase64ToArray, "$this$decodeBase64ToArray");
        int length = decodeBase64ToArray.length();
        while (length > 0 && ((charAt = decodeBase64ToArray.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i2 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt2 = decodeBase64ToArray.charAt(i6);
            if ('A' <= charAt2 && 'Z' >= charAt2) {
                i = charAt2 - 'A';
            } else if ('a' <= charAt2 && 'z' >= charAt2) {
                i = charAt2 - 'G';
            } else if ('0' <= charAt2 && '9' >= charAt2) {
                i = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i = 63;
            } else {
                if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                    return null;
                }
            }
            i4 = (i4 << 6) | i;
            i3++;
            if (i3 % 4 == 0) {
                bArr[i5] = (byte) (i4 >> 16);
                int i7 = i5 + 2;
                bArr[i5 + 1] = (byte) (i4 >> 8);
                i5 += 3;
                bArr[i7] = (byte) i4;
            }
        }
        int i8 = i3 % 4;
        if (i8 == 1) {
            return null;
        }
        if (i8 == 2) {
            bArr[i5] = (byte) ((i4 << 12) >> 16);
            i5++;
        } else if (i8 == 3) {
            int i9 = i4 << 6;
            int i10 = i5 + 1;
            bArr[i5] = (byte) (i9 >> 16);
            i5 += 2;
            bArr[i10] = (byte) (i9 >> 8);
        }
        if (i5 == i2) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i5);
        l.d(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] encodeBase64, @NotNull byte[] map) {
        l.e(encodeBase64, "$this$encodeBase64");
        l.e(map, "map");
        byte[] bArr = new byte[((encodeBase64.length + 2) / 3) * 4];
        int length = encodeBase64.length - (encodeBase64.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = encodeBase64[i];
            int i3 = i + 2;
            byte b2 = encodeBase64[i + 1];
            i += 3;
            byte b3 = encodeBase64[i3];
            bArr[i2] = map[(b & 255) >> 2];
            bArr[i2 + 1] = map[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i4 = i2 + 3;
            bArr[i2 + 2] = map[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
            i2 += 4;
            bArr[i4] = map[b3 & 63];
        }
        int length2 = encodeBase64.length - length;
        if (length2 == 1) {
            byte b4 = encodeBase64[i];
            bArr[i2] = map[(b4 & 255) >> 2];
            bArr[i2 + 1] = map[(b4 & 3) << 4];
            byte b5 = (byte) 61;
            bArr[i2 + 2] = b5;
            bArr[i2 + 3] = b5;
        } else if (length2 == 2) {
            int i5 = i + 1;
            byte b6 = encodeBase64[i];
            byte b7 = encodeBase64[i5];
            bArr[i2] = map[(b6 & 255) >> 2];
            bArr[i2 + 1] = map[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr[i2 + 2] = map[(b7 & 15) << 2];
            bArr[i2 + 3] = (byte) 61;
        }
        return -Platform.toUtf8String(bArr);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    @NotNull
    public static final byte[] getBASE64() {
        return BASE64;
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
