package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class acm {
    private static final byte[] a = cq.ad("OpusHead");

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair a(com.google.ads.interactivemedia.v3.internal.acd r12) {
        /*
            r0 = 1
            com.google.ads.interactivemedia.v3.internal.cj r12 = r12.a
            r1 = 8
            r12.F(r1)
            r2 = 0
            r3 = r2
            r4 = r3
        Lb:
            int r5 = r12.a()
            if (r5 < r1) goto Ld9
            int r5 = r12.c()
            int r6 = r12.e()
            int r7 = r12.e()
            r8 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r7 != r8) goto L75
            r12.F(r5)
            int r3 = r5 + r6
            r12.G(r1)
            c(r12)
        L2d:
            int r7 = r12.c()
            if (r7 >= r3) goto L66
            int r7 = r12.c()
            int r8 = r12.e()
            int r9 = r12.e()
            r10 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r9 != r10) goto L70
            r12.F(r7)
            int r7 = r7 + r8
            r12.G(r1)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L50:
            int r8 = r12.c()
            if (r8 >= r7) goto L60
            com.google.ads.interactivemedia.v3.internal.an r8 = com.google.ads.interactivemedia.v3.internal.act.a(r12)
            if (r8 == 0) goto L50
            r3.add(r8)
            goto L50
        L60:
            boolean r7 = r3.isEmpty()
            if (r7 == 0) goto L69
        L66:
            r3 = r2
            goto Ld3
        L69:
            com.google.ads.interactivemedia.v3.internal.ao r7 = new com.google.ads.interactivemedia.v3.internal.ao
            r7.<init>(r3)
            r3 = r7
            goto Ld3
        L70:
            int r7 = r7 + r8
            r12.F(r7)
            goto L2d
        L75:
            r8 = 1936553057(0x736d7461, float:1.8813092E31)
            if (r7 != r8) goto Ld3
            r12.F(r5)
            int r4 = r5 + r6
            r7 = 12
            r12.G(r7)
        L84:
            int r8 = r12.c()
            if (r8 >= r4) goto L9f
            int r8 = r12.c()
            int r9 = r12.e()
            int r10 = r12.e()
            r11 = 1935766900(0x73617574, float:1.7862687E31)
            if (r10 != r11) goto Lce
            r4 = 14
            if (r9 >= r4) goto La1
        L9f:
            r4 = r2
            goto Ld3
        La1:
            r4 = 5
            r12.G(r4)
            int r4 = r12.i()
            r8 = 1123024896(0x42f00000, float:120.0)
            if (r4 == r7) goto Lb2
            r7 = 13
            if (r4 == r7) goto Lb6
            goto L9f
        Lb2:
            if (r4 != r7) goto Lb6
            r8 = 1131413504(0x43700000, float:240.0)
        Lb6:
            r12.G(r0)
            int r4 = r12.i()
            com.google.ads.interactivemedia.v3.internal.ao r7 = new com.google.ads.interactivemedia.v3.internal.ao
            com.google.ads.interactivemedia.v3.internal.abj r9 = new com.google.ads.interactivemedia.v3.internal.abj
            r9.<init>(r8, r4)
            com.google.ads.interactivemedia.v3.internal.an[] r4 = new com.google.ads.interactivemedia.v3.internal.an[r0]
            r8 = 0
            r4[r8] = r9
            r7.<init>(r4)
            r4 = r7
            goto Ld3
        Lce:
            int r8 = r8 + r9
            r12.F(r8)
            goto L84
        Ld3:
            int r5 = r5 + r6
            r12.F(r5)
            goto Lb
        Ld9:
            android.util.Pair r12 = android.util.Pair.create(r3, r4)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.acm.a(com.google.ads.interactivemedia.v3.internal.acd):android.util.Pair");
    }

    public static ao b(acc accVar) {
        abg abgVar;
        acd b = accVar.b(1751411826);
        acd b2 = accVar.b(1801812339);
        acd b3 = accVar.b(1768715124);
        if (b == null || b2 == null || b3 == null || g(b.a) != 1835299937) {
            return null;
        }
        cj cjVar = b2.a;
        cjVar.F(12);
        int e = cjVar.e();
        String[] strArr = new String[e];
        for (int i = 0; i < e; i++) {
            int e2 = cjVar.e();
            cjVar.G(4);
            strArr[i] = cjVar.u(e2 - 8);
        }
        cj cjVar2 = b3.a;
        cjVar2.F(8);
        ArrayList arrayList = new ArrayList();
        while (cjVar2.a() > 8) {
            int c = cjVar2.c();
            int e3 = cjVar2.e();
            int e4 = cjVar2.e() - 1;
            if (e4 < 0 || e4 >= e) {
                cd.e("AtomParsers", "Skipped metadata with unknown key index: " + e4);
            } else {
                String str = strArr[e4];
                int i2 = c + e3;
                int i3 = act.b;
                while (true) {
                    int c2 = cjVar2.c();
                    if (c2 >= i2) {
                        abgVar = null;
                        break;
                    }
                    int e5 = cjVar2.e();
                    if (cjVar2.e() == 1684108385) {
                        int e6 = cjVar2.e();
                        int e7 = cjVar2.e();
                        int i4 = e5 - 16;
                        byte[] bArr = new byte[i4];
                        cjVar2.A(bArr, 0, i4);
                        abgVar = new abg(str, bArr, e7, e6);
                        break;
                    }
                    cjVar2.F(c2 + e5);
                }
                if (abgVar != null) {
                    arrayList.add(abgVar);
                }
            }
            cjVar2.F(c + e3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new ao((List) arrayList);
    }

    public static void c(cj cjVar) {
        int c = cjVar.c();
        cjVar.G(4);
        if (cjVar.e() != 1751411826) {
            c += 4;
        }
        cjVar.F(c);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0848  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x09f1 A[PHI: r6
      0x09f1: PHI (r6v41 int) = (r6v40 int), (r6v40 int), (r6v73 int), (r6v40 int) binds: [B:42:0x0934, B:49:0x094e, B:171:0x09f0, B:48:0x094c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0a12  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0aaf A[PHI: r20
      0x0aaf: PHI (r20v7 int) = (r20v6 int), (r20v9 int) binds: [B:199:0x0a96, B:201:0x0a9d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0aed  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0b02  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0b64  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0b67  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0b4f  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0aff  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0ae2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0e33  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x0799  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x07f6  */
    /* JADX WARN: Removed duplicated region for block: B:630:0x080e  */
    /* JADX WARN: Removed duplicated region for block: B:631:0x0812  */
    /* JADX WARN: Removed duplicated region for block: B:632:0x0807  */
    /* JADX WARN: Removed duplicated region for block: B:633:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:634:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:635:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:644:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:649:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0bc2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0bd6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List d(com.google.ads.interactivemedia.v3.internal.acc r59, com.google.ads.interactivemedia.v3.internal.zp r60, long r61, com.google.ads.interactivemedia.v3.internal.o r63, boolean r64, com.google.ads.interactivemedia.v3.internal.ati r65) throws com.google.ads.interactivemedia.v3.internal.as {
        /*
            Method dump skipped, instructions count: 3652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.acm.d(com.google.ads.interactivemedia.v3.internal.acc, com.google.ads.interactivemedia.v3.internal.zp, long, com.google.ads.interactivemedia.v3.internal.o, boolean, com.google.ads.interactivemedia.v3.internal.ati):java.util.List");
    }

    private static int e(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    private static int f(cj cjVar) {
        int i = cjVar.i();
        int i2 = i & 127;
        while ((i & 128) == 128) {
            i = cjVar.i();
            i2 = (i2 << 7) | (i & 127);
        }
        return i2;
    }

    private static int g(cj cjVar) {
        cjVar.F(16);
        return cjVar.e();
    }

    private static Pair h(acc accVar) {
        acd b = accVar.b(1701606260);
        if (b == null) {
            return null;
        }
        cj cjVar = b.a;
        cjVar.F(8);
        int f = ace.f(cjVar.e());
        int l = cjVar.l();
        long[] jArr = new long[l];
        long[] jArr2 = new long[l];
        for (int i = 0; i < l; i++) {
            jArr[i] = f == 1 ? cjVar.q() : cjVar.p();
            jArr2[i] = f == 1 ? cjVar.o() : cjVar.e();
            if (cjVar.x() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            cjVar.G(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair i(cj cjVar) {
        cjVar.F(8);
        int f = ace.f(cjVar.e());
        cjVar.G(f == 0 ? 8 : 16);
        long p = cjVar.p();
        cjVar.G(f == 0 ? 4 : 8);
        int m = cjVar.m();
        StringBuilder sb = new StringBuilder();
        sb.append((char) (((m >> 10) & 31) + 96));
        sb.append((char) (((m >> 5) & 31) + 96));
        sb.append((char) ((m & 31) + 96));
        return Pair.create(Long.valueOf(p), sb.toString());
    }

    private static Pair j(cj cjVar, int i, int i2) throws as {
        Integer num;
        adc adcVar;
        Pair create;
        int i3;
        int i4;
        byte[] bArr;
        int c = cjVar.c();
        while (c - i < i2) {
            cjVar.F(c);
            int e = cjVar.e();
            fz.k(e > 0, "childAtomSize must be positive");
            if (cjVar.e() == 1936289382) {
                int i5 = c + 8;
                int i6 = -1;
                int i7 = 0;
                String str = null;
                Integer num2 = null;
                while (i5 - c < e) {
                    cjVar.F(i5);
                    int e2 = cjVar.e();
                    int e3 = cjVar.e();
                    if (e3 == 1718775137) {
                        num2 = Integer.valueOf(cjVar.e());
                    } else if (e3 == 1935894637) {
                        cjVar.G(4);
                        str = cjVar.u(4);
                    } else if (e3 == 1935894633) {
                        i6 = i5;
                        i7 = e2;
                    }
                    i5 += e2;
                }
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    fz.k(num2 != null, "frma atom is mandatory");
                    fz.k(i6 != -1, "schi atom is mandatory");
                    int i8 = i6 + 8;
                    while (true) {
                        if (i8 - i6 >= i7) {
                            num = num2;
                            adcVar = null;
                            break;
                        }
                        cjVar.F(i8);
                        int e4 = cjVar.e();
                        if (cjVar.e() == 1952804451) {
                            int e5 = cjVar.e();
                            cjVar.G(1);
                            if (ace.f(e5) == 0) {
                                cjVar.G(1);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int i9 = cjVar.i();
                                int i10 = (i9 & 240) >> 4;
                                i3 = i9 & 15;
                                i4 = i10;
                            }
                            boolean z = cjVar.i() == 1;
                            int i11 = cjVar.i();
                            byte[] bArr2 = new byte[16];
                            cjVar.A(bArr2, 0, 16);
                            if (z && i11 == 0) {
                                int i12 = cjVar.i();
                                byte[] bArr3 = new byte[i12];
                                cjVar.A(bArr3, 0, i12);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            num = num2;
                            adcVar = new adc(z, str, i11, bArr2, i4, i3, bArr);
                        } else {
                            i8 += e4;
                        }
                    }
                    fz.k(adcVar != null, "tenc atom is mandatory");
                    int i13 = cq.a;
                    create = Pair.create(num, adcVar);
                } else {
                    create = null;
                }
                if (create != null) {
                    return create;
                }
            }
            c += e;
        }
        return null;
    }

    private static acg k(cj cjVar, int i) {
        cjVar.F(i + 12);
        cjVar.G(1);
        f(cjVar);
        cjVar.G(2);
        int i2 = cjVar.i();
        if ((i2 & 128) != 0) {
            cjVar.G(2);
        }
        if ((i2 & 64) != 0) {
            cjVar.G(cjVar.i());
        }
        if ((i2 & 32) != 0) {
            cjVar.G(2);
        }
        cjVar.G(1);
        f(cjVar);
        String h = ar.h(cjVar.i());
        if ("audio/mpeg".equals(h) || "audio/vnd.dts".equals(h) || "audio/vnd.dts.hd".equals(h)) {
            return new acg(h, null, -1L, -1L);
        }
        cjVar.G(4);
        long p = cjVar.p();
        long p2 = cjVar.p();
        cjVar.G(1);
        int f = f(cjVar);
        byte[] bArr = new byte[f];
        cjVar.A(bArr, 0, f);
        return new acg(h, bArr, p2 <= 0 ? -1L : p2, p > 0 ? p : -1L);
    }

    private static ByteBuffer l() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x03ae A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m(com.google.ads.interactivemedia.v3.internal.cj r24, int r25, int r26, int r27, int r28, java.lang.String r29, boolean r30, com.google.ads.interactivemedia.v3.internal.o r31, com.google.ads.interactivemedia.v3.internal.aci r32, int r33) throws com.google.ads.interactivemedia.v3.internal.as {
        /*
            Method dump skipped, instructions count: 1013
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.acm.m(com.google.ads.interactivemedia.v3.internal.cj, int, int, int, int, java.lang.String, boolean, com.google.ads.interactivemedia.v3.internal.o, com.google.ads.interactivemedia.v3.internal.aci, int):void");
    }

    private static boolean n(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length;
        int i = length - 1;
        return jArr[0] <= j2 && j2 < jArr[cq.d(4, 0, i)] && jArr[cq.d(length + (-4), 0, i)] < j3 && j3 <= j;
    }
}
