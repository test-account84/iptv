package com.google.ads.interactivemedia.v3.internal;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aaz extends aaj {
    public static final aax a = aaw.a;
    private final aax b;

    public aaz() {
        this(null);
    }

    private static int d(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int e(byte[] bArr, int i, int i2) {
        int f = f(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return f;
        }
        while (true) {
            int length = bArr.length;
            if (f >= length - 1) {
                return length;
            }
            if ((f - i) % 2 == 0 && bArr[f + 1] == 0) {
                return f;
            }
            f = f(bArr, f + 1);
        }
    }

    private static int f(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int g(cj cjVar, int i) {
        byte[] H = cjVar.H();
        int c = cjVar.c();
        int i2 = c;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= c + i) {
                return i;
            }
            if ((H[i2] & 255) == 255 && H[i3] == 0) {
                System.arraycopy(H, i2 + 2, H, i3, (i - (i2 - c)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0297 A[Catch: all -> 0x0252, UnsupportedEncodingException -> 0x0257, TryCatch #0 {all -> 0x0252, blocks: (B:55:0x0511, B:58:0x0532, B:108:0x021e, B:124:0x0284, B:126:0x0297, B:130:0x02d3, B:132:0x02e1, B:134:0x02b7, B:136:0x02cd, B:149:0x0319, B:156:0x035c, B:159:0x038f, B:162:0x03a0, B:163:0x03a8, B:165:0x03ae, B:168:0x03b5, B:173:0x03b9, B:180:0x03db, B:183:0x0404, B:185:0x040e, B:187:0x043f, B:188:0x044b, B:190:0x0451, B:193:0x0458, B:198:0x045c, B:201:0x0471, B:212:0x049d, B:214:0x04d8, B:216:0x04e7, B:217:0x04ff), top: B:46:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02b7 A[Catch: all -> 0x0252, UnsupportedEncodingException -> 0x0257, TryCatch #0 {all -> 0x0252, blocks: (B:55:0x0511, B:58:0x0532, B:108:0x021e, B:124:0x0284, B:126:0x0297, B:130:0x02d3, B:132:0x02e1, B:134:0x02b7, B:136:0x02cd, B:149:0x0319, B:156:0x035c, B:159:0x038f, B:162:0x03a0, B:163:0x03a8, B:165:0x03ae, B:168:0x03b5, B:173:0x03b9, B:180:0x03db, B:183:0x0404, B:185:0x040e, B:187:0x043f, B:188:0x044b, B:190:0x0451, B:193:0x0458, B:198:0x045c, B:201:0x0471, B:212:0x049d, B:214:0x04d8, B:216:0x04e7, B:217:0x04ff), top: B:46:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0511 A[Catch: all -> 0x0252, UnsupportedEncodingException -> 0x02fd, TRY_LEAVE, TryCatch #0 {all -> 0x0252, blocks: (B:55:0x0511, B:58:0x0532, B:108:0x021e, B:124:0x0284, B:126:0x0297, B:130:0x02d3, B:132:0x02e1, B:134:0x02b7, B:136:0x02cd, B:149:0x0319, B:156:0x035c, B:159:0x038f, B:162:0x03a0, B:163:0x03a8, B:165:0x03ae, B:168:0x03b5, B:173:0x03b9, B:180:0x03db, B:183:0x0404, B:185:0x040e, B:187:0x043f, B:188:0x044b, B:190:0x0451, B:193:0x0458, B:198:0x045c, B:201:0x0471, B:212:0x049d, B:214:0x04d8, B:216:0x04e7, B:217:0x04ff), top: B:46:0x00ef }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.ads.interactivemedia.v3.internal.aba h(int r34, com.google.ads.interactivemedia.v3.internal.cj r35, boolean r36, int r37, com.google.ads.interactivemedia.v3.internal.aax r38) {
        /*
            Method dump skipped, instructions count: 1367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aaz.h(int, com.google.ads.interactivemedia.v3.internal.cj, boolean, int, com.google.ads.interactivemedia.v3.internal.aax):com.google.ads.interactivemedia.v3.internal.aba");
    }

    private static String i(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    private static String j(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    private static String k(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) : String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    private static boolean l(cj cjVar, int i, int i2, boolean z) {
        int k;
        long k2;
        int i3;
        int i4;
        int c = cjVar.c();
        while (true) {
            try {
                if (cjVar.a() < i2) {
                    cjVar.F(c);
                    return true;
                }
                if (i >= 3) {
                    k = cjVar.e();
                    k2 = cjVar.p();
                    i3 = cjVar.m();
                } else {
                    k = cjVar.k();
                    k2 = cjVar.k();
                    i3 = 0;
                }
                if (k == 0 && k2 == 0 && i3 == 0) {
                    cjVar.F(c);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & k2) != 0) {
                        cjVar.F(c);
                        return false;
                    }
                    k2 = ((k2 >> 24) << 21) | ((255 & (k2 >> 16)) << 14) | (k2 & 255) | (((k2 >> 8) & 255) << 7);
                }
                if (i == 4) {
                    r4 = i3 & 1;
                    i4 = (i3 & 64) == 0 ? 0 : 1;
                } else {
                    if (i == 3) {
                        i4 = (i3 & 32) != 0 ? 1 : 0;
                        if ((i3 & 128) == 0) {
                        }
                    } else {
                        i4 = 0;
                    }
                    r4 = 0;
                }
                if (r4 != 0) {
                    i4 += 4;
                }
                if (k2 < i4) {
                    cjVar.F(c);
                    return false;
                }
                if (cjVar.a() < k2) {
                    cjVar.F(c);
                    return false;
                }
                cjVar.G((int) k2);
            } catch (Throwable th) {
                cjVar.F(c);
                throw th;
            }
        }
    }

    private static byte[] m(byte[] bArr, int i, int i2) {
        return i2 <= i ? cq.f : Arrays.copyOfRange(bArr, i, i2);
    }

    public final ao b(ByteBuffer byteBuffer) {
        return c(byteBuffer.array(), byteBuffer.limit());
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.v3.internal.ao c(byte[] r13, int r14) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aaz.c(byte[], int):com.google.ads.interactivemedia.v3.internal.ao");
    }

    public aaz(aax aaxVar) {
        this.b = aaxVar;
    }
}
