package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class axy {
    public static int a(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new IllegalArgumentException(atp.b("Out of range: %s", Long.valueOf(j)));
    }

    public static int b(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public static int[] c(Collection collection) {
        if (collection instanceof axx) {
            throw null;
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            atp.k(obj);
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }

    public static int d(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return !z ? -1 : 1;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        long f = f(bArr, 0, 0);
        long f2 = f(bArr, 3, 2) & 67108611;
        long f3 = f(bArr, 6, 4) & 67092735;
        long f4 = f(bArr, 9, 6) & 66076671;
        long f5 = f(bArr, 12, 8) & 1048575;
        long j = f2 * 5;
        long j2 = f3 * 5;
        long j3 = f4 * 5;
        long j4 = f5 * 5;
        int i = 17;
        byte[] bArr3 = new byte[17];
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        int i2 = 0;
        while (true) {
            int length = bArr2.length;
            if (i2 >= length) {
                long j10 = j5 + (j6 >> 26);
                long j11 = j10 & 67108863;
                long j12 = j7 + (j10 >> 26);
                long j13 = j12 & 67108863;
                long j14 = j8 + (j12 >> 26);
                long j15 = j14 & 67108863;
                long j16 = j9 + ((j14 >> 26) * 5);
                long j17 = j16 & 67108863;
                long j18 = (j6 & 67108863) + (j16 >> 26);
                long j19 = j17 + 5;
                long j20 = (j19 >> 26) + j18;
                long j21 = j11 + (j20 >> 26);
                long j22 = j13 + (j21 >> 26);
                long j23 = (j15 + (j22 >> 26)) - 67108864;
                long j24 = j23 >> 63;
                long j25 = ~j24;
                long j26 = (j18 & j24) | (j20 & 67108863 & j25);
                long j27 = (j11 & j24) | (j21 & 67108863 & j25);
                long j28 = (j13 & j24) | (j22 & 67108863 & j25);
                long g = (((j17 & j24) | (j19 & 67108863 & j25) | (j26 << 26)) & 4294967295L) + g(bArr, 16);
                long g2 = (((j26 >> 6) | (j27 << 20)) & 4294967295L) + g(bArr, 20) + (g >> 32);
                long g3 = (((j27 >> 12) | (j28 << 14)) & 4294967295L) + g(bArr, 24) + (g2 >> 32);
                long g4 = g(bArr, 28);
                byte[] bArr4 = new byte[16];
                h(bArr4, g & 4294967295L, 0);
                h(bArr4, g2 & 4294967295L, 4);
                h(bArr4, g3 & 4294967295L, 8);
                h(bArr4, ((((((j23 & j25) | (j15 & j24)) << 8) | (j28 >> 18)) & 4294967295L) + g4 + (g3 >> 32)) & 4294967295L, 12);
                return bArr4;
            }
            int min = Math.min(16, length - i2);
            System.arraycopy(bArr2, i2, bArr3, 0, min);
            bArr3[min] = 1;
            if (min != 16) {
                Arrays.fill(bArr3, min + 1, i, (byte) 0);
            }
            long f6 = j9 + f(bArr3, 0, 0);
            long f7 = j6 + f(bArr3, 3, 2);
            long f8 = j5 + f(bArr3, 6, 4);
            long f9 = j7 + f(bArr3, 9, 6);
            long f10 = j8 + (f(bArr3, 12, 8) | (bArr3[16] << 24));
            long j29 = (f6 * f) + (f7 * j4) + (f8 * j3) + (f9 * j2) + (f10 * j);
            long j30 = (f6 * f2) + (f7 * f) + (f8 * j4) + (f9 * j3) + (f10 * j2) + (j29 >> 26);
            long j31 = (f6 * f3) + (f7 * f2) + (f8 * f) + (f9 * j4) + (f10 * j3) + (j30 >> 26);
            long j32 = (f6 * f4) + (f7 * f3) + (f8 * f2) + (f9 * f) + (f10 * j4) + (j31 >> 26);
            long j33 = (f6 * f5) + (f7 * f4) + (f8 * f3) + (f9 * f2) + (f10 * f) + (j32 >> 26);
            j8 = j33 & 67108863;
            long j34 = (j29 & 67108863) + ((j33 >> 26) * 5);
            j9 = j34 & 67108863;
            j6 = (j30 & 67108863) + (j34 >> 26);
            i2 += 16;
            j7 = j32 & 67108863;
            j5 = j31 & 67108863;
            i = 17;
        }
    }

    private static long f(byte[] bArr, int i, int i2) {
        return (g(bArr, i) >> i2) & 67108863;
    }

    private static long g(byte[] bArr, int i) {
        return (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16)) & 4294967295L;
    }

    private static void h(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) (255 & j);
            i2++;
            j >>= 8;
        }
    }
}
