package z6;

import F6.c;
import F6.e;
import java.util.Arrays;
import x6.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a {
    public static final String[] b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] c = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    public static final String[] e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    public static final String[] f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    public y6.a a;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = h(zArr, i << 3);
        }
        return bArr;
    }

    public static String e(b bVar, int i) {
        int i2 = a.a[bVar.ordinal()];
        if (i2 == 1) {
            return b[i];
        }
        if (i2 == 2) {
            return c[i];
        }
        if (i2 == 3) {
            return d[i];
        }
        if (i2 == 4) {
            return e[i];
        }
        if (i2 == 5) {
            return f[i];
        }
        throw new IllegalStateException("Bad table");
    }

    public static String f(boolean[] zArr) {
        int length = zArr.length;
        b bVar = b.UPPER;
        StringBuilder sb = new StringBuilder(20);
        b bVar2 = bVar;
        int i = 0;
        while (i < length) {
            if (bVar != b.BINARY) {
                int i2 = bVar == b.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int i3 = i(zArr, i, i2);
                i += i2;
                String e2 = e(bVar, i3);
                if (e2.startsWith("CTRL_")) {
                    bVar2 = g(e2.charAt(5));
                    if (e2.charAt(6) != 'L') {
                        bVar2 = bVar;
                        bVar = bVar2;
                    }
                } else {
                    sb.append(e2);
                }
                bVar = bVar2;
            } else {
                if (length - i < 5) {
                    break;
                }
                int i4 = i(zArr, i, 5);
                int i5 = i + 5;
                if (i4 == 0) {
                    if (length - i5 < 11) {
                        break;
                    }
                    i4 = i(zArr, i5, 11) + 31;
                    i5 = i + 16;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= i4) {
                        i = i5;
                        break;
                    }
                    if (length - i5 < 8) {
                        i = length;
                        break;
                    }
                    sb.append((char) i(zArr, i5, 8));
                    i5 += 8;
                    i6++;
                }
                bVar = bVar2;
            }
        }
        return sb.toString();
    }

    public static b g(char c2) {
        return c2 != 'B' ? c2 != 'D' ? c2 != 'P' ? c2 != 'L' ? c2 != 'M' ? b.UPPER : b.MIXED : b.LOWER : b.PUNCT : b.DIGIT : b.BINARY;
    }

    public static byte h(boolean[] zArr, int i) {
        int length = zArr.length - i;
        return (byte) (length >= 8 ? i(zArr, i, 8) : i(zArr, i, length) << (8 - length));
    }

    public static int i(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    public static int j(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    public final boolean[] b(boolean[] zArr) {
        int i;
        F6.a aVar;
        if (this.a.d() <= 2) {
            aVar = F6.a.j;
            i = 6;
        } else {
            i = 8;
            if (this.a.d() <= 8) {
                aVar = F6.a.n;
            } else if (this.a.d() <= 22) {
                aVar = F6.a.i;
                i = 10;
            } else {
                aVar = F6.a.h;
                i = 12;
            }
        }
        int c2 = this.a.c();
        int length = zArr.length / i;
        if (length < c2) {
            throw g.a();
        }
        int length2 = zArr.length % i;
        int[] iArr = new int[length];
        int i2 = 0;
        while (i2 < length) {
            iArr[i2] = i(zArr, length2, i);
            i2++;
            length2 += i;
        }
        try {
            new c(aVar).a(iArr, length - c2);
            int i3 = 1 << i;
            int i4 = i3 - 1;
            int i5 = 0;
            for (int i6 = 0; i6 < c2; i6++) {
                int i7 = iArr[i6];
                if (i7 == 0 || i7 == i4) {
                    throw g.a();
                }
                if (i7 == 1 || i7 == i3 - 2) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[(c2 * i) - i5];
            int i8 = 0;
            for (int i9 = 0; i9 < c2; i9++) {
                int i10 = iArr[i9];
                if (i10 == 1 || i10 == i3 - 2) {
                    Arrays.fill(zArr2, i8, (i8 + i) - 1, i10 > 1);
                    i8 += i - 1;
                } else {
                    int i11 = i - 1;
                    while (i11 >= 0) {
                        int i12 = i8 + 1;
                        zArr2[i8] = ((1 << i11) & i10) != 0;
                        i11--;
                        i8 = i12;
                    }
                }
            }
            return zArr2;
        } catch (e e2) {
            throw g.b(e2);
        }
    }

    public D6.e c(y6.a aVar) {
        this.a = aVar;
        boolean[] b2 = b(d(aVar.a()));
        D6.e eVar = new D6.e(a(b2), f(b2), null, null);
        eVar.l(b2.length);
        return eVar;
    }

    public final boolean[] d(D6.b bVar) {
        boolean e2 = this.a.e();
        int d2 = this.a.d();
        int i = (e2 ? 11 : 14) + (d2 << 2);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[j(d2, e2)];
        int i2 = 2;
        if (e2) {
            for (int i3 = 0; i3 < i; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i / 2;
            int i5 = ((i + 1) + (((i4 - 1) / 15) * 2)) / 2;
            for (int i6 = 0; i6 < i4; i6++) {
                iArr[(i4 - i6) - 1] = (i5 - r12) - 1;
                iArr[i4 + i6] = (i6 / 15) + i6 + i5 + 1;
            }
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < d2) {
            int i9 = ((d2 - i7) << i2) + (e2 ? 9 : 12);
            int i10 = i7 << 1;
            int i11 = (i - 1) - i10;
            int i12 = 0;
            while (i12 < i9) {
                int i13 = i12 << 1;
                int i14 = 0;
                while (i14 < i2) {
                    int i15 = i10 + i14;
                    int i16 = i10 + i12;
                    zArr[i8 + i13 + i14] = bVar.f(iArr[i15], iArr[i16]);
                    int i17 = iArr[i16];
                    int i18 = i11 - i14;
                    zArr[(i9 * 2) + i8 + i13 + i14] = bVar.f(i17, iArr[i18]);
                    int i19 = i11 - i12;
                    zArr[(i9 * 4) + i8 + i13 + i14] = bVar.f(iArr[i18], iArr[i19]);
                    zArr[(i9 * 6) + i8 + i13 + i14] = bVar.f(iArr[i19], iArr[i15]);
                    i14++;
                    d2 = d2;
                    e2 = e2;
                    i2 = 2;
                }
                i12++;
                i2 = 2;
            }
            i8 += i9 << 3;
            i7++;
            i2 = 2;
        }
        return zArr;
    }
}
