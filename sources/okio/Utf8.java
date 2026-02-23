package okio;

import k8.q;
import org.jetbrains.annotations.NotNull;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        return (i >= 0 && 31 >= i) || (127 <= i && 159 >= i);
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final int process2Utf8Bytes(@NotNull byte[] process2Utf8Bytes, int i, int i2, @NotNull l yield) {
        kotlin.jvm.internal.l.e(process2Utf8Bytes, "$this$process2Utf8Bytes");
        kotlin.jvm.internal.l.e(yield, "yield");
        int i3 = i + 1;
        if (i2 <= i3) {
            yield.invoke(65533);
            return 1;
        }
        byte b = process2Utf8Bytes[i];
        byte b2 = process2Utf8Bytes[i3];
        if ((b2 & 192) != 128) {
            yield.invoke(65533);
            return 1;
        }
        int i4 = (b2 ^ 3968) ^ (b << 6);
        if (i4 < 128) {
            yield.invoke(65533);
            return 2;
        }
        yield.invoke(Integer.valueOf(i4));
        return 2;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] process3Utf8Bytes, int i, int i2, @NotNull l yield) {
        kotlin.jvm.internal.l.e(process3Utf8Bytes, "$this$process3Utf8Bytes");
        kotlin.jvm.internal.l.e(yield, "yield");
        int i3 = i + 2;
        if (i2 <= i3) {
            yield.invoke(65533);
            int i4 = i + 1;
            return (i2 <= i4 || (process3Utf8Bytes[i4] & 192) != 128) ? 1 : 2;
        }
        byte b = process3Utf8Bytes[i];
        byte b2 = process3Utf8Bytes[i + 1];
        if ((b2 & 192) != 128) {
            yield.invoke(65533);
            return 1;
        }
        byte b3 = process3Utf8Bytes[i3];
        if ((b3 & 192) != 128) {
            yield.invoke(65533);
            return 2;
        }
        int i5 = ((b3 ^ (-123008)) ^ (b2 << 6)) ^ (b << 12);
        if (i5 >= 2048 && (55296 > i5 || 57343 < i5)) {
            yield.invoke(Integer.valueOf(i5));
            return 3;
        }
        yield.invoke(65533);
        return 3;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] process4Utf8Bytes, int i, int i2, @NotNull l yield) {
        kotlin.jvm.internal.l.e(process4Utf8Bytes, "$this$process4Utf8Bytes");
        kotlin.jvm.internal.l.e(yield, "yield");
        int i3 = i + 3;
        if (i2 <= i3) {
            yield.invoke(65533);
            int i4 = i + 1;
            if (i2 <= i4 || (process4Utf8Bytes[i4] & 192) != 128) {
                return 1;
            }
            int i5 = i + 2;
            return (i2 <= i5 || (process4Utf8Bytes[i5] & 192) != 128) ? 2 : 3;
        }
        byte b = process4Utf8Bytes[i];
        byte b2 = process4Utf8Bytes[i + 1];
        if ((b2 & 192) != 128) {
            yield.invoke(65533);
            return 1;
        }
        byte b3 = process4Utf8Bytes[i + 2];
        if ((b3 & 192) != 128) {
            yield.invoke(65533);
            return 2;
        }
        byte b4 = process4Utf8Bytes[i3];
        if ((b4 & 192) != 128) {
            yield.invoke(65533);
            return 3;
        }
        int i6 = (((b4 ^ 3678080) ^ (b3 << 6)) ^ (b2 << 12)) ^ (b << 18);
        if (i6 <= 1114111 && ((55296 > i6 || 57343 < i6) && i6 >= 65536)) {
            yield.invoke(Integer.valueOf(i6));
            return 4;
        }
        yield.invoke(65533);
        return 4;
    }

    public static final void processUtf16Chars(@NotNull byte[] processUtf16Chars, int i, int i2, @NotNull l yield) {
        char c;
        int i3;
        int i4;
        kotlin.jvm.internal.l.e(processUtf16Chars, "$this$processUtf16Chars");
        kotlin.jvm.internal.l.e(yield, "yield");
        int i5 = i;
        while (i5 < i2) {
            byte b = processUtf16Chars[i5];
            if (b >= 0) {
                yield.invoke(Character.valueOf((char) b));
                i5++;
                while (i5 < i2) {
                    byte b2 = processUtf16Chars[i5];
                    if (b2 >= 0) {
                        i5++;
                        yield.invoke(Character.valueOf((char) b2));
                    }
                }
            } else {
                if ((b >> 5) == -2) {
                    int i6 = i5 + 1;
                    if (i2 > i6) {
                        byte b3 = processUtf16Chars[i6];
                        if ((b3 & 192) == 128) {
                            int i7 = (b << 6) ^ (b3 ^ 3968);
                            yield.invoke(Character.valueOf(i7 < 128 ? (char) 65533 : (char) i7));
                            q qVar = q.a;
                        }
                    }
                    yield.invoke(Character.valueOf((char) 65533));
                    q qVar2 = q.a;
                } else if ((b >> 4) == -2) {
                    int i8 = i5 + 2;
                    if (i2 <= i8) {
                        yield.invoke(Character.valueOf((char) 65533));
                        q qVar3 = q.a;
                        int i9 = i5 + 1;
                        i4 = (i2 <= i9 || (processUtf16Chars[i9] & 192) != 128) ? 1 : 2;
                    } else {
                        byte b4 = processUtf16Chars[i5 + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = processUtf16Chars[i8];
                            if ((b5 & 192) == 128) {
                                int i10 = (b << 12) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                                yield.invoke(Character.valueOf((i10 >= 2048 && (55296 > i10 || 57343 < i10)) ? (char) i10 : (char) 65533));
                                q qVar4 = q.a;
                                i4 = 3;
                            } else {
                                yield.invoke(Character.valueOf((char) 65533));
                                q qVar5 = q.a;
                            }
                        } else {
                            yield.invoke(Character.valueOf((char) 65533));
                            q qVar6 = q.a;
                        }
                    }
                } else if ((b >> 3) == -2) {
                    int i11 = i5 + 3;
                    if (i2 <= i11) {
                        yield.invoke((char) 65533);
                        q qVar7 = q.a;
                        int i12 = i5 + 1;
                        if (i2 > i12 && (processUtf16Chars[i12] & 192) == 128) {
                            int i13 = i5 + 2;
                            i3 = (i2 <= i13 || (processUtf16Chars[i13] & 192) != 128) ? 2 : 3;
                        }
                        i3 = 1;
                    } else {
                        byte b6 = processUtf16Chars[i5 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = processUtf16Chars[i5 + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = processUtf16Chars[i11];
                                if ((b8 & 192) == 128) {
                                    int i14 = (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << 12)) ^ (b << 18);
                                    if (i14 > 1114111 || ((55296 <= i14 && 57343 >= i14) || i14 < 65536)) {
                                        c = (char) 65533;
                                    } else if (i14 != 65533) {
                                        yield.invoke(Character.valueOf((char) ((i14 >>> 10) + 55232)));
                                        c = Character.valueOf((char) ((i14 & 1023) + 56320));
                                    } else {
                                        c = (char) 65533;
                                    }
                                    yield.invoke(c);
                                    q qVar8 = q.a;
                                    i3 = 4;
                                } else {
                                    yield.invoke((char) 65533);
                                    q qVar9 = q.a;
                                }
                            } else {
                                yield.invoke((char) 65533);
                                q qVar10 = q.a;
                            }
                        } else {
                            yield.invoke((char) 65533);
                            q qVar11 = q.a;
                            i3 = 1;
                        }
                    }
                    i5 += i3;
                } else {
                    yield.invoke((char) 65533);
                    i5++;
                }
                i5 += i4;
            }
        }
    }

    public static final void processUtf8Bytes(@NotNull String processUtf8Bytes, int i, int i2, @NotNull l yield) {
        int i3;
        byte valueOf;
        int i4;
        char charAt;
        kotlin.jvm.internal.l.e(processUtf8Bytes, "$this$processUtf8Bytes");
        kotlin.jvm.internal.l.e(yield, "yield");
        while (i < i2) {
            char charAt2 = processUtf8Bytes.charAt(i);
            if (kotlin.jvm.internal.l.f(charAt2, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) charAt2));
                i++;
                while (i < i2 && kotlin.jvm.internal.l.f(processUtf8Bytes.charAt(i), 128) < 0) {
                    yield.invoke(Byte.valueOf((byte) processUtf8Bytes.charAt(i)));
                    i++;
                }
            } else {
                if (kotlin.jvm.internal.l.f(charAt2, 2048) < 0) {
                    i3 = (charAt2 >> 6) | 192;
                } else if (55296 > charAt2 || 57343 < charAt2) {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> '\f') | 224)));
                    i3 = ((charAt2 >> 6) & 63) | 128;
                } else if (kotlin.jvm.internal.l.f(charAt2, 56319) > 0 || i2 <= (i4 = i + 1) || 56320 > (charAt = processUtf8Bytes.charAt(i4)) || 57343 < charAt) {
                    valueOf = (byte) 63;
                    yield.invoke(valueOf);
                    i++;
                } else {
                    int charAt3 = ((charAt2 << '\n') + processUtf8Bytes.charAt(i4)) - 56613888;
                    yield.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                    yield.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                    i += 2;
                }
                yield.invoke(Byte.valueOf((byte) i3));
                valueOf = Byte.valueOf((byte) ((charAt2 & '?') | 128));
                yield.invoke(valueOf);
                i++;
            }
        }
    }

    public static final void processUtf8CodePoints(@NotNull byte[] processUtf8CodePoints, int i, int i2, @NotNull l yield) {
        int i3;
        int i4;
        kotlin.jvm.internal.l.e(processUtf8CodePoints, "$this$processUtf8CodePoints");
        kotlin.jvm.internal.l.e(yield, "yield");
        int i5 = i;
        while (i5 < i2) {
            byte b = processUtf8CodePoints[i5];
            if (b >= 0) {
                yield.invoke(Integer.valueOf(b));
                i5++;
                while (i5 < i2) {
                    byte b2 = processUtf8CodePoints[i5];
                    if (b2 >= 0) {
                        i5++;
                        yield.invoke(Integer.valueOf(b2));
                    }
                }
            } else {
                if ((b >> 5) == -2) {
                    int i6 = i5 + 1;
                    if (i2 > i6) {
                        byte b3 = processUtf8CodePoints[i6];
                        if ((b3 & 192) == 128) {
                            int i7 = (b << 6) ^ (b3 ^ 3968);
                            yield.invoke(i7 < 128 ? 65533 : Integer.valueOf(i7));
                            q qVar = q.a;
                        }
                    }
                    yield.invoke(65533);
                    q qVar2 = q.a;
                } else if ((b >> 4) == -2) {
                    int i8 = i5 + 2;
                    if (i2 <= i8) {
                        yield.invoke(65533);
                        q qVar3 = q.a;
                        int i9 = i5 + 1;
                        i4 = (i2 <= i9 || (processUtf8CodePoints[i9] & 192) != 128) ? 1 : 2;
                    } else {
                        byte b4 = processUtf8CodePoints[i5 + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = processUtf8CodePoints[i8];
                            if ((b5 & 192) == 128) {
                                int i10 = (b << 12) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                                yield.invoke((i10 >= 2048 && (55296 > i10 || 57343 < i10)) ? Integer.valueOf(i10) : 65533);
                                q qVar4 = q.a;
                                i4 = 3;
                            } else {
                                yield.invoke(65533);
                                q qVar5 = q.a;
                            }
                        } else {
                            yield.invoke(65533);
                            q qVar6 = q.a;
                        }
                    }
                } else if ((b >> 3) == -2) {
                    int i11 = i5 + 3;
                    if (i2 <= i11) {
                        yield.invoke(65533);
                        q qVar7 = q.a;
                        int i12 = i5 + 1;
                        if (i2 > i12 && (processUtf8CodePoints[i12] & 192) == 128) {
                            int i13 = i5 + 2;
                            i3 = (i2 <= i13 || (processUtf8CodePoints[i13] & 192) != 128) ? 2 : 3;
                        }
                        i3 = 1;
                    } else {
                        byte b6 = processUtf8CodePoints[i5 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = processUtf8CodePoints[i5 + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = processUtf8CodePoints[i11];
                                if ((b8 & 192) == 128) {
                                    int i14 = (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << 12)) ^ (b << 18);
                                    yield.invoke((i14 <= 1114111 && (55296 > i14 || 57343 < i14) && i14 >= 65536) ? Integer.valueOf(i14) : 65533);
                                    q qVar8 = q.a;
                                    i3 = 4;
                                } else {
                                    yield.invoke(65533);
                                    q qVar9 = q.a;
                                }
                            } else {
                                yield.invoke(65533);
                                q qVar10 = q.a;
                            }
                        } else {
                            yield.invoke(65533);
                            q qVar11 = q.a;
                            i3 = 1;
                        }
                    }
                    i5 += i3;
                } else {
                    yield.invoke(65533);
                    i5++;
                }
                i5 += i4;
            }
        }
    }

    public static final long size(@NotNull String str) {
        return size$default(str, 0, 0, 3, null);
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    public static final long size(@NotNull String str, int i) {
        return size$default(str, i, 0, 2, null);
    }

    public static final long size(@NotNull String utf8Size, int i, int i2) {
        int i3;
        kotlin.jvm.internal.l.e(utf8Size, "$this$utf8Size");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (!(i2 <= utf8Size.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + utf8Size.length()).toString());
        }
        long j = 0;
        while (i < i2) {
            char charAt = utf8Size.charAt(i);
            if (charAt < 128) {
                j++;
            } else {
                if (charAt < 2048) {
                    i3 = 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i3 = 3;
                } else {
                    int i4 = i + 1;
                    char charAt2 = i4 < i2 ? utf8Size.charAt(i4) : (char) 0;
                    if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                        j++;
                        i = i4;
                    } else {
                        j += 4;
                        i += 2;
                    }
                }
                j += i3;
            }
            i++;
        }
        return j;
    }
}
