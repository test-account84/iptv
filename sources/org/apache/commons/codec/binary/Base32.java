package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.BaseNCodec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] HEX_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
    private static final byte[] HEX_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final int MASK_5BITS = 31;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base32() {
        this(false);
    }

    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v23 */
    public void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        byte b;
        if (context.eof) {
            return;
        }
        ?? r3 = 1;
        if (i2 < 0) {
            context.eof = true;
        }
        int i3 = i;
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                break;
            }
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 == this.pad) {
                context.eof = r3;
                break;
            }
            byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
            if (b2 >= 0) {
                byte[] bArr2 = this.decodeTable;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i6 = (context.modulus + r3) % 8;
                    context.modulus = i6;
                    context.lbitWorkArea = (context.lbitWorkArea << 5) + b;
                    if (i6 == 0) {
                        int i7 = context.pos;
                        ensureBufferSize[i7] = (byte) ((r12 >> 32) & 255);
                        ensureBufferSize[i7 + 1] = (byte) ((r12 >> 24) & 255);
                        ensureBufferSize[i7 + 2] = (byte) ((r12 >> 16) & 255);
                        ensureBufferSize[i7 + 3] = (byte) ((r12 >> 8) & 255);
                        context.pos = i7 + 5;
                        ensureBufferSize[i7 + 4] = (byte) (r12 & 255);
                    }
                }
            }
            i4++;
            i3 = i5;
            r3 = 1;
        }
        if (!context.eof || context.modulus < 2) {
            return;
        }
        byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
        switch (context.modulus) {
            case 2:
                int i8 = context.pos;
                context.pos = i8 + 1;
                ensureBufferSize2[i8] = (byte) ((context.lbitWorkArea >> 2) & 255);
                return;
            case 3:
                int i9 = context.pos;
                context.pos = i9 + 1;
                ensureBufferSize2[i9] = (byte) ((context.lbitWorkArea >> 7) & 255);
                return;
            case 4:
                context.lbitWorkArea = context.lbitWorkArea >> 4;
                int i10 = context.pos;
                ensureBufferSize2[i10] = (byte) ((r8 >> 12) & 255);
                context.pos = i10 + 2;
                ensureBufferSize2[i10 + 1] = (byte) (r4 & 255);
                return;
            case 5:
                context.lbitWorkArea = context.lbitWorkArea >> 1;
                int i11 = context.pos;
                ensureBufferSize2[i11] = (byte) ((r3 >> 17) & 255);
                ensureBufferSize2[i11 + 1] = (byte) ((r3 >> 9) & 255);
                context.pos = i11 + 3;
                ensureBufferSize2[i11 + 2] = (byte) (r9 & 255);
                return;
            case 6:
                context.lbitWorkArea = context.lbitWorkArea >> 6;
                int i12 = context.pos;
                ensureBufferSize2[i12] = (byte) ((r3 >> 22) & 255);
                ensureBufferSize2[i12 + 1] = (byte) ((r3 >> 14) & 255);
                context.pos = i12 + 3;
                ensureBufferSize2[i12 + 2] = (byte) (r9 & 255);
                return;
            case 7:
                context.lbitWorkArea = context.lbitWorkArea >> 3;
                int i13 = context.pos;
                ensureBufferSize2[i13] = (byte) ((r3 >> 27) & 255);
                ensureBufferSize2[i13 + 1] = (byte) ((r3 >> 19) & 255);
                ensureBufferSize2[i13 + 2] = (byte) ((r3 >> 11) & 255);
                context.pos = i13 + 4;
                ensureBufferSize2[i13 + 3] = (byte) (r8 & 255);
                return;
            default:
                throw new IllegalStateException("Impossible modulus " + context.modulus);
        }
    }

    public void encode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        int i3;
        if (context.eof) {
            return;
        }
        int i4 = 1;
        if (i2 >= 0) {
            int i5 = i;
            int i6 = 0;
            while (i6 < i2) {
                byte[] ensureBufferSize = ensureBufferSize(this.encodeSize, context);
                int i7 = (context.modulus + i4) % 5;
                context.modulus = i7;
                int i8 = i5 + 1;
                int i9 = bArr[i5];
                if (i9 < 0) {
                    i9 += 256;
                }
                long j = (context.lbitWorkArea << 8) + i9;
                context.lbitWorkArea = j;
                if (i7 == 0) {
                    int i10 = context.pos;
                    byte[] bArr2 = this.encodeTable;
                    ensureBufferSize[i10] = bArr2[((int) (j >> 35)) & 31];
                    i3 = i8;
                    ensureBufferSize[i10 + 1] = bArr2[((int) (j >> 30)) & 31];
                    ensureBufferSize[i10 + 2] = bArr2[((int) (j >> 25)) & 31];
                    ensureBufferSize[i10 + 3] = bArr2[((int) (j >> 20)) & 31];
                    ensureBufferSize[i10 + 4] = bArr2[((int) (j >> 15)) & 31];
                    ensureBufferSize[i10 + 5] = bArr2[((int) (j >> 10)) & 31];
                    int i11 = i10 + 7;
                    ensureBufferSize[i10 + 6] = bArr2[((int) (j >> 5)) & 31];
                    int i12 = i10 + 8;
                    context.pos = i12;
                    ensureBufferSize[i11] = bArr2[((int) j) & 31];
                    int i13 = context.currentLinePos + 8;
                    context.currentLinePos = i13;
                    int i14 = this.lineLength;
                    if (i14 > 0 && i14 <= i13) {
                        byte[] bArr3 = this.lineSeparator;
                        System.arraycopy(bArr3, 0, ensureBufferSize, i12, bArr3.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                    }
                    i6++;
                    i5 = i3;
                    i4 = 1;
                } else {
                    i3 = i8;
                }
                i6++;
                i5 = i3;
                i4 = 1;
            }
            return;
        }
        context.eof = true;
        if (context.modulus == 0 && this.lineLength == 0) {
            return;
        }
        byte[] ensureBufferSize2 = ensureBufferSize(this.encodeSize, context);
        int i15 = context.pos;
        int i16 = context.modulus;
        if (i16 != 0) {
            if (i16 == 1) {
                byte[] bArr4 = this.encodeTable;
                long j2 = context.lbitWorkArea;
                ensureBufferSize2[i15] = bArr4[((int) (j2 >> 3)) & 31];
                ensureBufferSize2[i15 + 1] = bArr4[((int) (j2 << 2)) & 31];
                byte b = this.pad;
                ensureBufferSize2[i15 + 2] = b;
                ensureBufferSize2[i15 + 3] = b;
                ensureBufferSize2[i15 + 4] = b;
                ensureBufferSize2[i15 + 5] = b;
                ensureBufferSize2[i15 + 6] = b;
                context.pos = i15 + 8;
                ensureBufferSize2[i15 + 7] = b;
            } else if (i16 == 2) {
                byte[] bArr5 = this.encodeTable;
                long j3 = context.lbitWorkArea;
                ensureBufferSize2[i15] = bArr5[((int) (j3 >> 11)) & 31];
                ensureBufferSize2[i15 + 1] = bArr5[((int) (j3 >> 6)) & 31];
                ensureBufferSize2[i15 + 2] = bArr5[((int) (j3 >> 1)) & 31];
                ensureBufferSize2[i15 + 3] = bArr5[((int) (j3 << 4)) & 31];
                byte b2 = this.pad;
                ensureBufferSize2[i15 + 4] = b2;
                ensureBufferSize2[i15 + 5] = b2;
                ensureBufferSize2[i15 + 6] = b2;
                context.pos = i15 + 8;
                ensureBufferSize2[i15 + 7] = b2;
            } else if (i16 == 3) {
                byte[] bArr6 = this.encodeTable;
                long j4 = context.lbitWorkArea;
                ensureBufferSize2[i15] = bArr6[((int) (j4 >> 19)) & 31];
                ensureBufferSize2[i15 + 1] = bArr6[((int) (j4 >> 14)) & 31];
                ensureBufferSize2[i15 + 2] = bArr6[((int) (j4 >> 9)) & 31];
                ensureBufferSize2[i15 + 3] = bArr6[((int) (j4 >> 4)) & 31];
                ensureBufferSize2[i15 + 4] = bArr6[((int) (j4 << 1)) & 31];
                byte b3 = this.pad;
                ensureBufferSize2[i15 + 5] = b3;
                ensureBufferSize2[i15 + 6] = b3;
                context.pos = i15 + 8;
                ensureBufferSize2[i15 + 7] = b3;
            } else {
                if (i16 != 4) {
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
                byte[] bArr7 = this.encodeTable;
                long j5 = context.lbitWorkArea;
                ensureBufferSize2[i15] = bArr7[((int) (j5 >> 27)) & 31];
                ensureBufferSize2[i15 + 1] = bArr7[((int) (j5 >> 22)) & 31];
                ensureBufferSize2[i15 + 2] = bArr7[((int) (j5 >> 17)) & 31];
                ensureBufferSize2[i15 + 3] = bArr7[((int) (j5 >> 12)) & 31];
                ensureBufferSize2[i15 + 4] = bArr7[((int) (j5 >> 7)) & 31];
                ensureBufferSize2[i15 + 5] = bArr7[((int) (j5 >> 2)) & 31];
                ensureBufferSize2[i15 + 6] = bArr7[((int) (j5 << 3)) & 31];
                context.pos = i15 + 8;
                ensureBufferSize2[i15 + 7] = this.pad;
            }
        }
        int i17 = context.currentLinePos;
        int i18 = context.pos;
        int i19 = i17 + (i18 - i15);
        context.currentLinePos = i19;
        if (this.lineLength <= 0 || i19 <= 0) {
            return;
        }
        byte[] bArr8 = this.lineSeparator;
        System.arraycopy(bArr8, 0, ensureBufferSize2, i18, bArr8.length);
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

    public Base32(byte b) {
        this(false, b);
    }

    public Base32(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base32(int i, byte[] bArr) {
        this(i, bArr, false, (byte) 61);
    }

    public Base32(int i, byte[] bArr, boolean z) {
        this(i, bArr, z, (byte) 61);
    }

    public Base32(int i, byte[] bArr, boolean z, byte b) {
        super(5, 8, i, bArr == null ? 0 : bArr.length, b);
        if (z) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (i <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else {
            if (bArr == null) {
                throw new IllegalArgumentException("lineLength " + i + " > 0, but lineSeparator is null");
            }
            if (containsAlphabetOrPad(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + StringUtils.newStringUtf8(bArr) + "]");
            }
            this.encodeSize = bArr.length + 8;
            byte[] bArr2 = new byte[bArr.length];
            this.lineSeparator = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        this.decodeSize = this.encodeSize - 1;
        if (isInAlphabet(b) || BaseNCodec.isWhiteSpace(b)) {
            throw new IllegalArgumentException("pad must not be in alphabet or whitespace");
        }
    }

    public Base32(boolean z) {
        this(0, null, z, (byte) 61);
    }

    public Base32(boolean z, byte b) {
        this(0, null, z, b);
    }
}
