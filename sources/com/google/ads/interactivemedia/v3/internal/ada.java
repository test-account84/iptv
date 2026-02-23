package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ada {
    private static final int[] a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean a(zi ziVar) throws IOException {
        return c(ziVar, true);
    }

    public static boolean b(zi ziVar) throws IOException {
        return c(ziVar, false);
    }

    private static boolean c(zi ziVar, boolean z) throws IOException {
        long j;
        int i;
        long b = ziVar.b();
        long j2 = 4096;
        long j3 = -1;
        if (b != -1 && b <= 4096) {
            j2 = b;
        }
        int i2 = (int) j2;
        cj cjVar = new cj(64);
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < i2) {
            cjVar.B(8);
            if (!ziVar.k(cjVar.H(), z2 ? 1 : 0, 8, true)) {
                break;
            }
            long p = cjVar.p();
            int e = cjVar.e();
            if (p == 1) {
                ziVar.f(cjVar.H(), 8, 8);
                i = 16;
                cjVar.E(16);
                j = cjVar.o();
            } else {
                if (p == 0) {
                    long b2 = ziVar.b();
                    if (b2 != j3) {
                        p = (b2 - ziVar.c()) + 8;
                    }
                }
                j = p;
                i = 8;
            }
            long j4 = i;
            if (j < j4) {
                return z2;
            }
            i3 += i;
            if (e == 1836019574) {
                i2 += (int) j;
                if (b != -1 && i2 > b) {
                    i2 = (int) b;
                }
                j3 = -1;
            } else {
                if (e == 1836019558 || e == 1836475768) {
                    z2 = true;
                    break;
                }
                if ((i3 + j) - j4 >= i2) {
                    break;
                }
                int i4 = (int) (j - j4);
                i3 += i4;
                if (e == 1718909296) {
                    if (i4 < 8) {
                        return false;
                    }
                    cjVar.B(i4);
                    ziVar.f(cjVar.H(), 0, i4);
                    int i5 = i4 >> 2;
                    for (int i6 = 0; i6 < i5; i6++) {
                        if (i6 != 1) {
                            int e2 = cjVar.e();
                            if ((e2 >>> 8) != 3368816) {
                                if (e2 == 1751476579) {
                                    e2 = 1751476579;
                                }
                                int[] iArr = a;
                                for (int i7 = 0; i7 < 29; i7++) {
                                    if (iArr[i7] != e2) {
                                    }
                                }
                            }
                            z3 = true;
                            break;
                        }
                        cjVar.G(4);
                    }
                    if (!z3) {
                        return false;
                    }
                } else if (i4 != 0) {
                    ziVar.e(i4);
                }
                j3 = -1;
                z2 = false;
            }
        }
        z2 = false;
        return z3 && z == z2;
    }
}
