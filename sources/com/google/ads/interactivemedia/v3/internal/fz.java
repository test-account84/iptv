package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class fz {
    public static final er a(float f, float f2, long j, float f3, long j2, long j3, float f4) {
        return new er(0.97f, 1.03f, 1000L, 1.0E-7f, j2, j3, 0.999f);
    }

    public static int b(int i) {
        return c(i, 0, 0);
    }

    public static int c(int i, int i2, int i3) {
        return d(i, i2, i3, 0, 128);
    }

    @SuppressLint({"WrongConstant"})
    public static int d(int i, int i2, int i3, int i4, int i5) {
        return i | i2 | i3 | i4 | i5;
    }

    @SuppressLint({"WrongConstant"})
    public static int e(int i) {
        return i & 128;
    }

    @SuppressLint({"WrongConstant"})
    public static int f(int i) {
        return i & 7;
    }

    @SuppressLint({"WrongConstant"})
    public static int g(int i) {
        return i & 64;
    }

    public static int h(aae aaeVar, k kVar, int i, boolean z) throws IOException {
        return aaeVar.h(kVar, i, z);
    }

    public static void i(aae aaeVar, cj cjVar, int i) {
        aaeVar.i(cjVar, i);
    }

    public static List j(byte[] bArr) {
        byte b = bArr[11];
        byte b2 = bArr[10];
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(o(n(((b & 255) << 8) | (b2 & 255))));
        arrayList.add(o(n(3840L)));
        return arrayList;
    }

    public static void k(boolean z, String str) throws as {
        if (!z) {
            throw as.a(str, null);
        }
    }

    public static void l(long j, cj cjVar, aae[] aaeVarArr) {
        int i;
        while (true) {
            if (cjVar.a() <= 1) {
                return;
            }
            int p = p(cjVar);
            int p2 = p(cjVar);
            int c = cjVar.c() + p2;
            if (p2 == -1 || p2 > cjVar.a()) {
                cd.e("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                c = cjVar.d();
            } else if (p == 4 && p2 >= 8) {
                int i2 = cjVar.i();
                int m = cjVar.m();
                if (m == 49) {
                    i = cjVar.e();
                    m = 49;
                } else {
                    i = 0;
                }
                int i3 = cjVar.i();
                if (m == 47) {
                    cjVar.G(1);
                }
                boolean z = i2 == 181 && (m == 49 || m == 47) && i3 == 3;
                if (m == 49) {
                    z &= i == 1195456820;
                }
                if (z) {
                    m(j, cjVar, aaeVarArr);
                }
            }
            cjVar.F(c);
        }
    }

    public static void m(long j, cj cjVar, aae[] aaeVarArr) {
        int i = cjVar.i();
        if ((i & 64) != 0) {
            cjVar.G(1);
            int i2 = (i & 31) * 3;
            int c = cjVar.c();
            for (aae aaeVar : aaeVarArr) {
                cjVar.F(c);
                aaeVar.e(cjVar, i2);
                if (j != -9223372036854775807L) {
                    aaeVar.f(j, 1, i2, 0, null);
                }
            }
        }
    }

    private static long n(long j) {
        return (j * 1000000000) / 48000;
    }

    private static byte[] o(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    private static int p(cj cjVar) {
        int i = 0;
        while (cjVar.a() != 0) {
            int i2 = cjVar.i();
            i += i2;
            if (i2 != 255) {
                return i;
            }
        }
        return -1;
    }
}
