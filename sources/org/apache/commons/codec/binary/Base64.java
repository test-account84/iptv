package org.apache.commons.codec.binary;

import java.math.BigInteger;
import org.apache.commons.codec.binary.BaseNCodec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Base64 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    private static final int MASK_6BITS = 63;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;
    static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public Base64() {
        this(0);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(toIntegerBytes(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    @Deprecated
    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = DECODE_TABLE;
                if (b >= bArr.length || bArr[b] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    public static byte[] toIntegerBytes(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = bitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    public void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        byte b;
        if (context.eof) {
            return;
        }
        if (i2 < 0) {
            context.eof = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == this.pad) {
                context.eof = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = DECODE_TABLE;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i5 = (context.modulus + 1) % 4;
                    context.modulus = i5;
                    int i6 = (context.ibitWorkArea << 6) + b;
                    context.ibitWorkArea = i6;
                    if (i5 == 0) {
                        int i7 = context.pos;
                        ensureBufferSize[i7] = (byte) ((i6 >> 16) & 255);
                        ensureBufferSize[i7 + 1] = (byte) ((i6 >> 8) & 255);
                        context.pos = i7 + 3;
                        ensureBufferSize[i7 + 2] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!context.eof || context.modulus == 0) {
            return;
        }
        byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
        int i8 = context.modulus;
        if (i8 != 1) {
            if (i8 == 2) {
                int i9 = context.ibitWorkArea >> 4;
                context.ibitWorkArea = i9;
                int i10 = context.pos;
                context.pos = i10 + 1;
                ensureBufferSize2[i10] = (byte) (i9 & 255);
                return;
            }
            if (i8 != 3) {
                throw new IllegalStateException("Impossible modulus " + context.modulus);
            }
            int i11 = context.ibitWorkArea;
            int i12 = i11 >> 2;
            context.ibitWorkArea = i12;
            int i13 = context.pos;
            ensureBufferSize2[i13] = (byte) ((i11 >> 10) & 255);
            context.pos = i13 + 2;
            ensureBufferSize2[i13 + 1] = (byte) (i12 & 255);
        }
    }

    public void encode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        if (context.eof) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                byte[] ensureBufferSize = ensureBufferSize(this.encodeSize, context);
                int i4 = (context.modulus + 1) % 3;
                context.modulus = i4;
                int i5 = i + 1;
                int i6 = bArr[i];
                if (i6 < 0) {
                    i6 += 256;
                }
                int i7 = (context.ibitWorkArea << 8) + i6;
                context.ibitWorkArea = i7;
                if (i4 == 0) {
                    int i8 = context.pos;
                    byte[] bArr2 = this.encodeTable;
                    ensureBufferSize[i8] = bArr2[(i7 >> 18) & 63];
                    ensureBufferSize[i8 + 1] = bArr2[(i7 >> 12) & 63];
                    int i9 = i8 + 3;
                    ensureBufferSize[i8 + 2] = bArr2[(i7 >> 6) & 63];
                    int i10 = i8 + 4;
                    context.pos = i10;
                    ensureBufferSize[i9] = bArr2[i7 & 63];
                    int i11 = context.currentLinePos + 4;
                    context.currentLinePos = i11;
                    int i12 = this.lineLength;
                    if (i12 > 0 && i12 <= i11) {
                        byte[] bArr3 = this.lineSeparator;
                        System.arraycopy(bArr3, 0, ensureBufferSize, i10, bArr3.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                    }
                }
                i3++;
                i = i5;
            }
            return;
        }
        context.eof = true;
        if (context.modulus == 0 && this.lineLength == 0) {
            return;
        }
        byte[] ensureBufferSize2 = ensureBufferSize(this.encodeSize, context);
        int i13 = context.pos;
        int i14 = context.modulus;
        if (i14 != 0) {
            if (i14 == 1) {
                byte[] bArr4 = this.encodeTable;
                int i15 = context.ibitWorkArea;
                ensureBufferSize2[i13] = bArr4[(i15 >> 2) & 63];
                int i16 = i13 + 2;
                context.pos = i16;
                ensureBufferSize2[i13 + 1] = bArr4[(i15 << 4) & 63];
                if (bArr4 == STANDARD_ENCODE_TABLE) {
                    byte b = this.pad;
                    ensureBufferSize2[i16] = b;
                    context.pos = i13 + 4;
                    ensureBufferSize2[i13 + 3] = b;
                }
            } else {
                if (i14 != 2) {
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
                byte[] bArr5 = this.encodeTable;
                int i17 = context.ibitWorkArea;
                ensureBufferSize2[i13] = bArr5[(i17 >> 10) & 63];
                ensureBufferSize2[i13 + 1] = bArr5[(i17 >> 4) & 63];
                int i18 = i13 + 3;
                context.pos = i18;
                ensureBufferSize2[i13 + 2] = bArr5[(i17 << 2) & 63];
                if (bArr5 == STANDARD_ENCODE_TABLE) {
                    context.pos = i13 + 4;
                    ensureBufferSize2[i18] = this.pad;
                }
            }
        }
        int i19 = context.currentLinePos;
        int i20 = context.pos;
        int i21 = i19 + (i20 - i13);
        context.currentLinePos = i21;
        if (this.lineLength <= 0 || i21 <= 0) {
            return;
        }
        byte[] bArr6 = this.lineSeparator;
        System.arraycopy(bArr6, 0, ensureBufferSize2, i20, bArr6.length);
        context.pos += this.lineSeparator.length;
    }

    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.decodeTable;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    public Base64(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static boolean isBase64(String str) {
        return isBase64(StringUtils.getBytesUtf8(str));
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!isBase64(bArr[i]) && !BaseNCodec.isWhiteSpace(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Base64(int r5, byte[] r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L5
            r1 = 0
            goto L6
        L5:
            int r1 = r6.length
        L6:
            r2 = 3
            r3 = 4
            r4.<init>(r2, r3, r5, r1)
            byte[] r1 = org.apache.commons.codec.binary.Base64.DECODE_TABLE
            r4.decodeTable = r1
            r1 = 0
            if (r6 == 0) goto L28
            boolean r2 = r4.containsAlphabetOrPad(r6)
            if (r2 != 0) goto L2d
            if (r5 <= 0) goto L28
            int r5 = r6.length
            int r5 = r5 + r3
            r4.encodeSize = r5
            int r5 = r6.length
            byte[] r5 = new byte[r5]
            r4.lineSeparator = r5
            int r1 = r6.length
            java.lang.System.arraycopy(r6, r0, r5, r0, r1)
            goto L4d
        L28:
            r4.encodeSize = r3
            r4.lineSeparator = r1
            goto L4d
        L2d:
            java.lang.String r5 = org.apache.commons.codec.binary.StringUtils.newStringUtf8(r6)
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "lineSeparator must not contain base64 characters: ["
            r7.append(r0)
            r7.append(r5)
            java.lang.String r5 = "]"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        L4d:
            int r5 = r4.encodeSize
            int r5 = r5 + (-1)
            r4.decodeSize = r5
            if (r7 == 0) goto L58
            byte[] r5 = org.apache.commons.codec.binary.Base64.URL_SAFE_ENCODE_TABLE
            goto L5a
        L58:
            byte[] r5 = org.apache.commons.codec.binary.Base64.STANDARD_ENCODE_TABLE
        L5a:
            r4.encodeTable = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary.Base64.<init>(int, byte[], boolean):void");
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= i) {
            return base64.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i);
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }
}
