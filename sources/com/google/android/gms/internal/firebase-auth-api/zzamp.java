package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzamp extends zzamm {
    public final int zza(int i, byte[] bArr, int i2, int i3) {
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            return 0;
        }
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b < 0) {
                if (b < -32) {
                    if (i4 >= i3) {
                        return b;
                    }
                    if (b >= -62) {
                        i2 += 2;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return -1;
                }
                if (b >= -16) {
                    if (i4 >= i3 - 2) {
                        return zzaml.zza(bArr, i4, i3);
                    }
                    int i5 = i2 + 2;
                    byte b2 = bArr[i4];
                    if (b2 <= -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                        int i6 = i2 + 3;
                        if (bArr[i5] <= -65) {
                            i2 += 4;
                            if (bArr[i6] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i4 >= i3 - 1) {
                    return zzaml.zza(bArr, i4, i3);
                }
                int i7 = i2 + 2;
                byte b3 = bArr[i4];
                if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                    i2 += 3;
                    if (bArr[i7] > -65) {
                    }
                }
                return -1;
            }
            i2 = i4;
        }
        return 0;
    }

    public final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        char charAt;
        int length = charSequence.length();
        int i5 = i2 + i;
        int i6 = 0;
        while (i6 < length && (i4 = i6 + i) < i5 && (charAt = charSequence.charAt(i6)) < 128) {
            bArr[i4] = (byte) charAt;
            i6++;
        }
        if (i6 == length) {
            return i + length;
        }
        int i7 = i + i6;
        while (i6 < length) {
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 < 128 && i7 < i5) {
                bArr[i7] = (byte) charAt2;
                i7++;
            } else if (charAt2 < 2048 && i7 <= i5 - 2) {
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                i7 += 2;
                bArr[i8] = (byte) ((charAt2 & '?') | 128);
            } else {
                if ((charAt2 >= 55296 && 57343 >= charAt2) || i7 > i5 - 3) {
                    if (i7 > i5 - 4) {
                        if (55296 <= charAt2 && charAt2 <= 57343 && ((i3 = i6 + 1) == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                            throw new zzamo(i6, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i7);
                    }
                    int i9 = i6 + 1;
                    if (i9 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i9);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i10 = i7 + 3;
                            bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i7 += 4;
                            bArr[i10] = (byte) ((codePoint & 63) | 128);
                            i6 = i9;
                        } else {
                            i6 = i9;
                        }
                    }
                    throw new zzamo(i6 - 1, length);
                }
                bArr[i7] = (byte) ((charAt2 >>> '\f') | 480);
                int i11 = i7 + 2;
                bArr[i7 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i7 += 3;
                bArr[i11] = (byte) ((charAt2 & '?') | 128);
            }
            i6++;
        }
        return i7;
    }

    public final String zza(byte[] bArr, int i, int i2) throws zzaji {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = bArr[i];
            if (b < 0) {
                break;
            }
            i++;
            zzamn.zza(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                int i7 = i5 + 1;
                zzamn.zza(b2, cArr, i5);
                while (i6 < i3) {
                    byte b3 = bArr[i6];
                    if (b3 < 0) {
                        break;
                    }
                    i6++;
                    zzamn.zza(b3, cArr, i7);
                    i7++;
                }
                i5 = i7;
                i = i6;
            } else if (b2 < -32) {
                if (i6 >= i3) {
                    throw zzaji.zzd();
                }
                i += 2;
                zzamn.zza(b2, bArr[i6], cArr, i5);
                i5++;
            } else if (b2 < -16) {
                if (i6 >= i3 - 1) {
                    throw zzaji.zzd();
                }
                int i8 = i + 2;
                i += 3;
                zzamn.zza(b2, bArr[i6], bArr[i8], cArr, i5);
                i5++;
            } else {
                if (i6 >= i3 - 2) {
                    throw zzaji.zzd();
                }
                byte b4 = bArr[i6];
                int i9 = i + 3;
                byte b5 = bArr[i + 2];
                i += 4;
                zzamn.zza(b2, b4, b5, bArr[i9], cArr, i5);
                i5 += 2;
            }
        }
        return new String(cArr, 0, i5);
    }
}
