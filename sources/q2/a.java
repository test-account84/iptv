package Q2;

import O2.l1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a {
    public static final int[] a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    public static final int[] b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static final class b {
        public final int a;
        public final int b;
        public final String c;

        public b(int i, int i2, String str) {
            this.a = i;
            this.b = i2;
            this.c = str;
        }

        public /* synthetic */ b(int i, int i2, String str, a aVar) {
            this(i, i2, str);
        }
    }

    public static byte[] a(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (true) {
            int[] iArr = a;
            if (i4 >= iArr.length) {
                break;
            }
            if (i == iArr[i4]) {
                i5 = i4;
            }
            i4++;
        }
        int i6 = -1;
        while (true) {
            int[] iArr2 = b;
            if (i3 >= iArr2.length) {
                break;
            }
            if (i2 == iArr2[i3]) {
                i6 = i3;
            }
            i3++;
        }
        if (i != -1 && i6 != -1) {
            return b(2, i5, i6);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i + ", " + i2);
    }

    public static byte[] b(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static int c(d4.L l) {
        int h = l.h(5);
        return h == 31 ? l.h(6) + 32 : h;
    }

    public static int d(d4.L l) {
        int h = l.h(4);
        if (h == 15) {
            if (l.b() >= 24) {
                return l.h(24);
            }
            throw l1.a("AAC header insufficient data", null);
        }
        if (h < 13) {
            return a[h];
        }
        throw l1.a("AAC header wrong Sampling Frequency Index", null);
    }

    public static b e(d4.L l, boolean z) {
        int c = c(l);
        int d = d(l);
        int h = l.h(4);
        String str = "mp4a.40." + c;
        if (c == 5 || c == 29) {
            d = d(l);
            c = c(l);
            if (c == 22) {
                h = l.h(4);
            }
        }
        if (z) {
            if (c != 1 && c != 2 && c != 3 && c != 4 && c != 6 && c != 7 && c != 17) {
                switch (c) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw l1.e("Unsupported audio object type: " + c);
                }
            }
            g(l, c, h);
            switch (c) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int h2 = l.h(2);
                    if (h2 == 2 || h2 == 3) {
                        throw l1.e("Unsupported epConfig: " + h2);
                    }
            }
        }
        int i = b[h];
        if (i != -1) {
            return new b(d, i, str, null);
        }
        throw l1.a(null, null);
    }

    public static b f(byte[] bArr) {
        return e(new d4.L(bArr), false);
    }

    public static void g(d4.L l, int i, int i2) {
        if (l.g()) {
            d4.B.j("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (l.g()) {
            l.r(14);
        }
        boolean g = l.g();
        if (i2 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i == 6 || i == 20) {
            l.r(3);
        }
        if (g) {
            if (i == 22) {
                l.r(16);
            }
            if (i == 17 || i == 19 || i == 20 || i == 23) {
                l.r(3);
            }
            l.r(1);
        }
    }
}
