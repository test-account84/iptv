package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzib {
    private static long zza(byte[] bArr, int i) {
        return (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16)) & 4294967295L;
    }

    private static long zza(byte[] bArr, int i, int i2) {
        return (zza(bArr, i) >> i2) & 67108863;
    }

    private static void zza(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) (255 & j);
            i2++;
            j >>= 8;
        }
    }

    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        long zza = zza(bArr, 0, 0) & 67108863;
        long zza2 = zza(bArr, 3, 2) & 67108611;
        long zza3 = zza(bArr, 6, 4) & 67092735;
        long zza4 = zza(bArr, 9, 6) & 66076671;
        long zza5 = zza(bArr, 12, 8) & 1048575;
        long j = zza2 * 5;
        long j2 = zza3 * 5;
        long j3 = zza4 * 5;
        long j4 = zza5 * 5;
        int i = 17;
        byte[] bArr3 = new byte[17];
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        int i2 = 0;
        while (i2 < bArr2.length) {
            int min = Math.min(16, bArr2.length - i2);
            System.arraycopy(bArr2, i2, bArr3, 0, min);
            bArr3[min] = 1;
            if (min != 16) {
                Arrays.fill(bArr3, min + 1, i, (byte) 0);
            }
            long zza6 = j9 + zza(bArr3, 0, 0);
            long zza7 = j5 + zza(bArr3, 3, 2);
            long zza8 = j6 + zza(bArr3, 6, 4);
            long zza9 = j7 + zza(bArr3, 9, 6);
            long zza10 = j8 + (zza(bArr3, 12, 8) | (bArr3[16] << 24));
            long j10 = (zza6 * zza) + (zza7 * j4) + (zza8 * j3) + (zza9 * j2) + (zza10 * j);
            long j11 = (zza6 * zza2) + (zza7 * zza) + (zza8 * j4) + (zza9 * j3) + (zza10 * j2);
            long j12 = (zza6 * zza3) + (zza7 * zza2) + (zza8 * zza) + (zza9 * j4) + (zza10 * j3);
            long j13 = (zza6 * zza4) + (zza7 * zza3) + (zza8 * zza2) + (zza9 * zza) + (zza10 * j4);
            long j14 = j11 + (j10 >> 26);
            long j15 = j12 + (j14 >> 26);
            long j16 = j13 + (j15 >> 26);
            long j17 = (zza6 * zza5) + (zza7 * zza4) + (zza8 * zza3) + (zza9 * zza2) + (zza10 * zza) + (j16 >> 26);
            long j18 = (j10 & 67108863) + ((j17 >> 26) * 5);
            j5 = (j14 & 67108863) + (j18 >> 26);
            i2 += 16;
            j6 = j15 & 67108863;
            j7 = j16 & 67108863;
            j8 = j17 & 67108863;
            i = 17;
            j9 = j18 & 67108863;
        }
        long j19 = j6 + (j5 >> 26);
        long j20 = j19 & 67108863;
        long j21 = j7 + (j19 >> 26);
        long j22 = j21 & 67108863;
        long j23 = j8 + (j21 >> 26);
        long j24 = j23 & 67108863;
        long j25 = j9 + ((j23 >> 26) * 5);
        long j26 = j25 & 67108863;
        long j27 = (j5 & 67108863) + (j25 >> 26);
        long j28 = j26 + 5;
        long j29 = j28 & 67108863;
        long j30 = (j28 >> 26) + j27;
        long j31 = j20 + (j30 >> 26);
        long j32 = j22 + (j31 >> 26);
        long j33 = (j24 + (j32 >> 26)) - 67108864;
        long j34 = j33 >> 63;
        long j35 = ~j34;
        long j36 = (j27 & j34) | (j30 & 67108863 & j35);
        long j37 = (j20 & j34) | (j31 & 67108863 & j35);
        long j38 = (j22 & j34) | (j32 & 67108863 & j35);
        long j39 = ((j36 << 26) | (j26 & j34) | (j29 & j35)) & 4294967295L;
        long j40 = ((j36 >> 6) | (j37 << 20)) & 4294967295L;
        long j41 = ((j37 >> 12) | (j38 << 14)) & 4294967295L;
        long j42 = ((((j33 & j35) | (j24 & j34)) << 8) | (j38 >> 18)) & 4294967295L;
        long zza11 = j39 + zza(bArr, 16);
        long j43 = zza11 & 4294967295L;
        long zza12 = j40 + zza(bArr, 20) + (zza11 >> 32);
        long zza13 = j41 + zza(bArr, 24) + (zza12 >> 32);
        long zza14 = (j42 + zza(bArr, 28) + (zza13 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        zza(bArr4, j43, 0);
        zza(bArr4, zza12 & 4294967295L, 4);
        zza(bArr4, zza13 & 4294967295L, 8);
        zza(bArr4, zza14, 12);
        return bArr4;
    }
}
