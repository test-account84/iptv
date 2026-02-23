package okio.internal;

import java.util.Arrays;
import k8.q;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class _Utf8Kt {
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String commonAsUtf8ToByteArray) {
        int i;
        char charAt;
        l.e(commonAsUtf8ToByteArray, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[commonAsUtf8ToByteArray.length() * 4];
        int length = commonAsUtf8ToByteArray.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt2 = commonAsUtf8ToByteArray.charAt(i2);
            if (l.f(charAt2, 128) >= 0) {
                int length2 = commonAsUtf8ToByteArray.length();
                int i3 = i2;
                while (i2 < length2) {
                    char charAt3 = commonAsUtf8ToByteArray.charAt(i2);
                    if (l.f(charAt3, 128) < 0) {
                        int i4 = i3 + 1;
                        bArr[i3] = (byte) charAt3;
                        i2++;
                        while (i2 < length2 && l.f(commonAsUtf8ToByteArray.charAt(i2), 128) < 0) {
                            bArr[i4] = (byte) commonAsUtf8ToByteArray.charAt(i2);
                            i2++;
                            i4++;
                        }
                        i3 = i4;
                    } else {
                        if (l.f(charAt3, 2048) < 0) {
                            bArr[i3] = (byte) ((charAt3 >> 6) | 192);
                            i3 += 2;
                            bArr[i3 + 1] = (byte) ((charAt3 & '?') | 128);
                        } else if (55296 > charAt3 || 57343 < charAt3) {
                            bArr[i3] = (byte) ((charAt3 >> '\f') | 224);
                            bArr[i3 + 1] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i3 += 3;
                            bArr[i3 + 2] = (byte) ((charAt3 & '?') | 128);
                        } else if (l.f(charAt3, 56319) > 0 || length2 <= (i = i2 + 1) || 56320 > (charAt = commonAsUtf8ToByteArray.charAt(i)) || 57343 < charAt) {
                            bArr[i3] = 63;
                            i2++;
                            i3++;
                        } else {
                            int charAt4 = ((charAt3 << '\n') + commonAsUtf8ToByteArray.charAt(i)) - 56613888;
                            bArr[i3] = (byte) ((charAt4 >> 18) | 240);
                            bArr[i3 + 1] = (byte) (((charAt4 >> 12) & 63) | 128);
                            bArr[i3 + 2] = (byte) (((charAt4 >> 6) & 63) | 128);
                            i3 += 4;
                            bArr[i3 + 3] = (byte) ((charAt4 & 63) | 128);
                            i2 += 2;
                        }
                        i2++;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i3);
                l.d(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i2] = (byte) charAt2;
            i2++;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, commonAsUtf8ToByteArray.length());
        l.d(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }

    @NotNull
    public static final String commonToUtf8String(@NotNull byte[] commonToUtf8String, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = i;
        int i11 = 3;
        l.e(commonToUtf8String, "$this$commonToUtf8String");
        if (i10 < 0 || i2 > commonToUtf8String.length || i10 > i2) {
            throw new ArrayIndexOutOfBoundsException("size=" + commonToUtf8String.length + " beginIndex=" + i10 + " endIndex=" + i2);
        }
        char[] cArr = new char[i2 - i10];
        int i12 = 0;
        while (i10 < i2) {
            byte b = commonToUtf8String[i10];
            if (b >= 0) {
                i8 = i12 + 1;
                cArr[i12] = (char) b;
                i10++;
                while (i10 < i2) {
                    byte b2 = commonToUtf8String[i10];
                    if (b2 < 0) {
                        break;
                    }
                    i10++;
                    cArr[i8] = (char) b2;
                    i8++;
                }
            } else if ((b >> 5) == -2) {
                int i13 = i10 + 1;
                if (i2 <= i13) {
                    i8 = i12 + 1;
                    cArr[i12] = (char) 65533;
                } else {
                    byte b3 = commonToUtf8String[i13];
                    if ((b3 & 192) == 128) {
                        int i14 = (b << 6) ^ (b3 ^ 3968);
                        if (i14 < 128) {
                            i8 = i12 + 1;
                            cArr[i12] = (char) 65533;
                        } else {
                            i8 = i12 + 1;
                            cArr[i12] = (char) i14;
                        }
                        q qVar = q.a;
                        i9 = 2;
                        i10 += i9;
                    } else {
                        i8 = i12 + 1;
                        cArr[i12] = (char) 65533;
                    }
                }
                q qVar2 = q.a;
                i9 = 1;
                i10 += i9;
            } else {
                if ((b >> 4) == -2) {
                    int i15 = i10 + 2;
                    if (i2 <= i15) {
                        i5 = i12 + 1;
                        cArr[i12] = (char) 65533;
                        q qVar3 = q.a;
                        int i16 = i10 + 1;
                        i7 = (i2 <= i16 || (commonToUtf8String[i16] & 192) != 128) ? 1 : 2;
                    } else {
                        byte b4 = commonToUtf8String[i10 + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = commonToUtf8String[i15];
                            if ((b5 & 192) == 128) {
                                int i17 = ((b5 ^ (-123008)) ^ (b4 << 6)) ^ (b << 12);
                                if (i17 < 2048) {
                                    i6 = i12 + 1;
                                    cArr[i12] = (char) 65533;
                                } else if (55296 <= i17 && 57343 >= i17) {
                                    i6 = i12 + 1;
                                    cArr[i12] = (char) 65533;
                                } else {
                                    char c = (char) i17;
                                    i6 = i12 + 1;
                                    cArr[i12] = c;
                                }
                                q qVar4 = q.a;
                                i5 = i6;
                                i7 = 3;
                            } else {
                                i5 = i12 + 1;
                                cArr[i12] = (char) 65533;
                                q qVar5 = q.a;
                            }
                        } else {
                            i5 = i12 + 1;
                            cArr[i12] = (char) 65533;
                            q qVar6 = q.a;
                        }
                    }
                    i10 += i7;
                    i12 = i5;
                } else {
                    if ((b >> 3) == -2) {
                        int i18 = i10 + 3;
                        if (i2 <= i18) {
                            i3 = i12 + 1;
                            cArr[i12] = 65533;
                            q qVar7 = q.a;
                            int i19 = i10 + 1;
                            if (i2 <= i19 || (commonToUtf8String[i19] & 192) != 128) {
                                i11 = 1;
                            } else {
                                int i20 = i10 + 2;
                                if (i2 <= i20 || (commonToUtf8String[i20] & 192) != 128) {
                                    i11 = 2;
                                }
                            }
                            i10 += i11;
                        } else {
                            byte b6 = commonToUtf8String[i10 + 1];
                            if ((b6 & 192) == 128) {
                                byte b7 = commonToUtf8String[i10 + 2];
                                if ((b7 & 192) == 128) {
                                    byte b8 = commonToUtf8String[i18];
                                    if ((b8 & 192) == 128) {
                                        int i21 = (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << 12)) ^ (b << 18);
                                        if (i21 > 1114111) {
                                            i3 = i12 + 1;
                                            cArr[i12] = 65533;
                                        } else if (55296 <= i21 && 57343 >= i21) {
                                            i3 = i12 + 1;
                                            cArr[i12] = 65533;
                                        } else if (i21 < 65536) {
                                            i3 = i12 + 1;
                                            cArr[i12] = 65533;
                                        } else {
                                            if (i21 != 65533) {
                                                cArr[i12] = (char) ((i21 >>> 10) + 55232);
                                                i4 = i12 + 2;
                                                cArr[i12 + 1] = (char) ((i21 & 1023) + 56320);
                                            } else {
                                                cArr[i12] = 65533;
                                                i4 = i12 + 1;
                                            }
                                            q qVar8 = q.a;
                                            i3 = i4;
                                            i11 = 4;
                                        }
                                        q qVar9 = q.a;
                                        i11 = 4;
                                    } else {
                                        i3 = i12 + 1;
                                        cArr[i12] = 65533;
                                        q qVar10 = q.a;
                                        i11 = 3;
                                    }
                                    i10 += i11;
                                } else {
                                    i3 = i12 + 1;
                                    cArr[i12] = 65533;
                                    q qVar11 = q.a;
                                    i11 = 2;
                                    i10 += i11;
                                }
                            } else {
                                i3 = i12 + 1;
                                cArr[i12] = 65533;
                                q qVar12 = q.a;
                                i11 = 1;
                                i10 += i11;
                            }
                        }
                    } else {
                        i3 = i12 + 1;
                        cArr[i12] = 65533;
                        i10++;
                    }
                    i12 = i3;
                }
                i11 = 3;
            }
            i12 = i8;
            i11 = 3;
        }
        return new String(cArr, 0, i12);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }
}
