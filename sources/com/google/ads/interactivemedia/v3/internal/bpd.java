package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public /* synthetic */ class bpd {
    public static bpb a(bpk bpkVar, byte[] bArr) {
        bpkVar.Y();
        return new boz(bArr);
    }

    public static bpk b(bpk bpkVar) {
        return bpkVar;
    }

    public static double c(byte[] bArr, int i) {
        return Double.longBitsToDouble(u(bArr, i));
    }

    public static float d(byte[] bArr, int i) {
        return Float.intBitsToFloat(f(bArr, i));
    }

    public static int e(byte[] bArr, int i, boq boqVar) throws bqw {
        int n = n(bArr, i, boqVar);
        int i2 = boqVar.a;
        if (i2 < 0) {
            throw bqw.f();
        }
        if (i2 > bArr.length - n) {
            throw bqw.i();
        }
        if (i2 == 0) {
            boqVar.c = bpb.b;
            return n;
        }
        boqVar.c = bpb.u(bArr, n, i2);
        return n + i2;
    }

    public static int f(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int g(bsi bsiVar, byte[] bArr, int i, int i2, int i3, boq boqVar) throws IOException {
        Object e = bsiVar.e();
        int r = r(e, bsiVar, bArr, i, i2, i3, boqVar);
        bsiVar.f(e);
        boqVar.c = e;
        return r;
    }

    public static int h(bsi bsiVar, byte[] bArr, int i, int i2, boq boqVar) throws IOException {
        Object e = bsiVar.e();
        int s = s(e, bsiVar, bArr, i, i2, boqVar);
        bsiVar.f(e);
        boqVar.c = e;
        return s;
    }

    public static int i(bsi bsiVar, int i, byte[] bArr, int i2, int i3, bqt bqtVar, boq boqVar) throws IOException {
        int h = h(bsiVar, bArr, i2, i3, boqVar);
        while (true) {
            bqtVar.add(boqVar.c);
            if (h >= i3) {
                break;
            }
            int n = n(bArr, h, boqVar);
            if (i != boqVar.a) {
                break;
            }
            h = h(bsiVar, bArr, n, i3, boqVar);
        }
        return h;
    }

    public static int j(byte[] bArr, int i, bqt bqtVar, boq boqVar) throws IOException {
        bqo bqoVar = (bqo) bqtVar;
        int n = n(bArr, i, boqVar);
        int i2 = boqVar.a + n;
        while (n < i2) {
            n = n(bArr, n, boqVar);
            bqoVar.g(boqVar.a);
        }
        if (n == i2) {
            return n;
        }
        throw bqw.i();
    }

    public static int k(byte[] bArr, int i, boq boqVar) throws bqw {
        int n = n(bArr, i, boqVar);
        int i2 = boqVar.a;
        if (i2 < 0) {
            throw bqw.f();
        }
        if (i2 == 0) {
            boqVar.c = "";
            return n;
        }
        boqVar.c = new String(bArr, n, i2, bqu.a);
        return n + i2;
    }

    public static int l(byte[] bArr, int i, boq boqVar) throws bqw {
        int n = n(bArr, i, boqVar);
        int i2 = boqVar.a;
        if (i2 < 0) {
            throw bqw.f();
        }
        if (i2 == 0) {
            boqVar.c = "";
            return n;
        }
        boqVar.c = btj.h(bArr, n, i2);
        return n + i2;
    }

    public static int m(int i, byte[] bArr, int i2, int i3, bsx bsxVar, boq boqVar) throws bqw {
        if (btm.a(i) == 0) {
            throw bqw.c();
        }
        int b = btm.b(i);
        if (b == 0) {
            int q = q(bArr, i2, boqVar);
            bsxVar.i(i, Long.valueOf(boqVar.b));
            return q;
        }
        if (b == 1) {
            bsxVar.i(i, Long.valueOf(u(bArr, i2)));
            return i2 + 8;
        }
        if (b == 2) {
            int n = n(bArr, i2, boqVar);
            int i4 = boqVar.a;
            if (i4 < 0) {
                throw bqw.f();
            }
            if (i4 > bArr.length - n) {
                throw bqw.i();
            }
            bsxVar.i(i, i4 == 0 ? bpb.b : bpb.u(bArr, n, i4));
            return n + i4;
        }
        if (b != 3) {
            if (b != 5) {
                throw bqw.c();
            }
            bsxVar.i(i, Integer.valueOf(f(bArr, i2)));
            return i2 + 4;
        }
        int i5 = (i & (-8)) | 4;
        bsx e = bsx.e();
        int i6 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int n2 = n(bArr, i2, boqVar);
            int i7 = boqVar.a;
            i6 = i7;
            if (i7 == i5) {
                i2 = n2;
                break;
            }
            int m = m(i6, bArr, n2, i3, e, boqVar);
            i6 = i7;
            i2 = m;
        }
        if (i2 > i3 || i6 != i5) {
            throw bqw.g();
        }
        bsxVar.i(i, e);
        return i2;
    }

    public static int n(byte[] bArr, int i, boq boqVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return o(b, bArr, i2, boqVar);
        }
        boqVar.a = b;
        return i2;
    }

    public static int o(int i, byte[] bArr, int i2, boq boqVar) {
        int i3;
        int i4 = i & 127;
        int i5 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            i3 = b << 7;
        } else {
            int i6 = i4 | ((b & Byte.MAX_VALUE) << 7);
            int i7 = i2 + 2;
            byte b2 = bArr[i5];
            if (b2 >= 0) {
                boqVar.a = i6 | (b2 << 14);
                return i7;
            }
            i4 = i6 | ((b2 & Byte.MAX_VALUE) << 14);
            i5 = i2 + 3;
            byte b3 = bArr[i7];
            if (b3 >= 0) {
                i3 = b3 << 21;
            } else {
                int i8 = i4 | ((b3 & Byte.MAX_VALUE) << 21);
                int i9 = i2 + 4;
                byte b4 = bArr[i5];
                if (b4 >= 0) {
                    boqVar.a = i8 | (b4 << 28);
                    return i9;
                }
                int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 28);
                while (true) {
                    int i11 = i9 + 1;
                    if (bArr[i9] >= 0) {
                        boqVar.a = i10;
                        return i11;
                    }
                    i9 = i11;
                }
            }
        }
        boqVar.a = i4 | i3;
        return i5;
    }

    public static int p(int i, byte[] bArr, int i2, int i3, bqt bqtVar, boq boqVar) {
        bqo bqoVar = (bqo) bqtVar;
        int n = n(bArr, i2, boqVar);
        while (true) {
            bqoVar.g(boqVar.a);
            if (n >= i3) {
                break;
            }
            int n2 = n(bArr, n, boqVar);
            if (i != boqVar.a) {
                break;
            }
            n = n(bArr, n2, boqVar);
        }
        return n;
    }

    public static int q(byte[] bArr, int i, boq boqVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            boqVar.b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        boqVar.b = j2;
        return i3;
    }

    public static int r(Object obj, bsi bsiVar, byte[] bArr, int i, int i2, int i3, boq boqVar) throws IOException {
        int c = ((brv) bsiVar).c(obj, bArr, i, i2, i3, boqVar);
        boqVar.c = obj;
        return c;
    }

    public static int s(Object obj, bsi bsiVar, byte[] bArr, int i, int i2, boq boqVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = o(i4, bArr, i3, boqVar);
            i4 = boqVar.a;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw bqw.i();
        }
        int i6 = i4 + i5;
        bsiVar.i(obj, bArr, i5, i6, boqVar);
        boqVar.c = obj;
        return i6;
    }

    public static int t(int i, byte[] bArr, int i2, int i3, boq boqVar) throws bqw {
        if (btm.a(i) == 0) {
            throw bqw.c();
        }
        int b = btm.b(i);
        if (b == 0) {
            return q(bArr, i2, boqVar);
        }
        if (b == 1) {
            return i2 + 8;
        }
        if (b == 2) {
            return n(bArr, i2, boqVar) + boqVar.a;
        }
        if (b != 3) {
            if (b == 5) {
                return i2 + 4;
            }
            throw bqw.c();
        }
        int i4 = (i & (-8)) | 4;
        int i5 = 0;
        while (i2 < i3) {
            i2 = n(bArr, i2, boqVar);
            i5 = boqVar.a;
            if (i5 == i4) {
                break;
            }
            i2 = t(i5, bArr, i2, i3, boqVar);
        }
        if (i2 > i3 || i5 != i4) {
            throw bqw.g();
        }
        return i2;
    }

    public static long u(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public static /* synthetic */ void v(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }
}
