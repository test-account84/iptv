package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmm {
    private static final int[] zza = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzb = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzc = {67108863, 33554431};
    private static final int[] zzd = {26, 25};

    public static void zza(long[] jArr) {
        jArr[10] = 0;
        int i = 0;
        while (i < 10) {
            long j = jArr[i];
            long j2 = j / 67108864;
            jArr[i] = j - (j2 << 26);
            int i2 = i + 1;
            long j3 = jArr[i2] + j2;
            jArr[i2] = j3;
            long j4 = j3 / 33554432;
            jArr[i2] = j3 - (j4 << 25);
            i += 2;
            jArr[i] = jArr[i] + j4;
        }
        long j5 = jArr[0];
        long j6 = jArr[10];
        long j7 = j5 + (j6 << 4);
        jArr[0] = j7;
        long j8 = j7 + (j6 << 1);
        jArr[0] = j8;
        long j9 = j8 + j6;
        jArr[0] = j9;
        jArr[10] = 0;
        long j10 = j9 / 67108864;
        jArr[0] = j9 - (j10 << 26);
        jArr[1] = jArr[1] + j10;
    }

    public static void zzb(long[] jArr) {
        long j = jArr[8];
        long j2 = jArr[18];
        long j3 = j + (j2 << 4);
        jArr[8] = j3;
        long j4 = j3 + (j2 << 1);
        jArr[8] = j4;
        jArr[8] = j4 + j2;
        long j5 = jArr[7];
        long j6 = jArr[17];
        long j7 = j5 + (j6 << 4);
        jArr[7] = j7;
        long j8 = j7 + (j6 << 1);
        jArr[7] = j8;
        jArr[7] = j8 + j6;
        long j9 = jArr[6];
        long j10 = jArr[16];
        long j11 = j9 + (j10 << 4);
        jArr[6] = j11;
        long j12 = j11 + (j10 << 1);
        jArr[6] = j12;
        jArr[6] = j12 + j10;
        long j13 = jArr[5];
        long j14 = jArr[15];
        long j15 = j13 + (j14 << 4);
        jArr[5] = j15;
        long j16 = j15 + (j14 << 1);
        jArr[5] = j16;
        jArr[5] = j16 + j14;
        long j17 = jArr[4];
        long j18 = jArr[14];
        long j19 = j17 + (j18 << 4);
        jArr[4] = j19;
        long j20 = j19 + (j18 << 1);
        jArr[4] = j20;
        jArr[4] = j20 + j18;
        long j21 = jArr[3];
        long j22 = jArr[13];
        long j23 = j21 + (j22 << 4);
        jArr[3] = j23;
        long j24 = j23 + (j22 << 1);
        jArr[3] = j24;
        jArr[3] = j24 + j22;
        long j25 = jArr[2];
        long j26 = jArr[12];
        long j27 = j25 + (j26 << 4);
        jArr[2] = j27;
        long j28 = j27 + (j26 << 1);
        jArr[2] = j28;
        jArr[2] = j28 + j26;
        long j29 = jArr[1];
        long j30 = jArr[11];
        long j31 = j29 + (j30 << 4);
        jArr[1] = j31;
        long j32 = j31 + (j30 << 1);
        jArr[1] = j32;
        jArr[1] = j32 + j30;
        long j33 = jArr[0];
        long j34 = jArr[10];
        long j35 = j33 + (j34 << 4);
        jArr[0] = j35;
        long j36 = j35 + (j34 << 1);
        jArr[0] = j36;
        jArr[0] = j36 + j34;
    }

    public static void zzc(long[] jArr, long[] jArr2) {
        zzc(jArr, jArr2, jArr);
    }

    public static void zzd(long[] jArr, long[] jArr2) {
        zzd(jArr, jArr, jArr2);
    }

    private static void zze(long[] jArr, long[] jArr2) {
        if (jArr.length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            jArr = jArr3;
        }
        zzb(jArr);
        zza(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    public static void zza(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        zzb(jArr3, jArr2);
        zzb(jArr12, jArr3);
        zzb(jArr11, jArr12);
        zza(jArr4, jArr11, jArr2);
        zza(jArr5, jArr4, jArr3);
        zzb(jArr11, jArr5);
        zza(jArr6, jArr11, jArr4);
        zzb(jArr11, jArr6);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zza(jArr7, jArr11, jArr6);
        zzb(jArr11, jArr7);
        zzb(jArr12, jArr11);
        for (int i = 2; i < 10; i += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr8, jArr12, jArr7);
        zzb(jArr11, jArr8);
        zzb(jArr12, jArr11);
        for (int i2 = 2; i2 < 20; i2 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr11, jArr12, jArr8);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        for (int i3 = 2; i3 < 10; i3 += 2) {
            zzb(jArr12, jArr11);
            zzb(jArr11, jArr12);
        }
        zza(jArr9, jArr11, jArr7);
        zzb(jArr11, jArr9);
        zzb(jArr12, jArr11);
        for (int i4 = 2; i4 < 50; i4 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr10, jArr12, jArr9);
        zzb(jArr12, jArr10);
        zzb(jArr11, jArr12);
        for (int i5 = 2; i5 < 100; i5 += 2) {
            zzb(jArr12, jArr11);
            zzb(jArr11, jArr12);
        }
        zza(jArr12, jArr11, jArr10);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        for (int i6 = 2; i6 < 50; i6 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr11, jArr12, jArr9);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zza(jArr, jArr12, jArr5);
    }

    public static void zzb(long[] jArr, long[] jArr2) {
        long j = jArr2[0];
        long j2 = jArr2[1];
        long j3 = jArr2[2];
        long j4 = jArr2[3];
        long j5 = jArr2[4];
        long j6 = jArr2[5];
        long j7 = jArr2[6];
        long j8 = jArr2[7];
        long j9 = jArr2[8];
        long j10 = jArr2[9];
        zze(new long[]{j * j, j * 2 * j2, ((j2 * j2) + (j * j3)) * 2, ((j2 * j3) + (j * j4)) * 2, (j3 * j3) + (j2 * 4 * j4) + (j * 2 * j5), ((j3 * j4) + (j2 * j5) + (j * j6)) * 2, ((j4 * j4) + (j3 * j5) + (j * j7) + (j2 * 2 * j6)) * 2, ((j4 * j5) + (j3 * j6) + (j2 * j7) + (j * j8)) * 2, (j5 * j5) + (((j3 * j7) + (j * j9) + (((j2 * j8) + (j4 * j6)) * 2)) * 2), ((j5 * j6) + (j4 * j7) + (j3 * j8) + (j2 * j9) + (j * j10)) * 2, ((j6 * j6) + (j5 * j7) + (j3 * j9) + (((j4 * j8) + (j2 * j10)) * 2)) * 2, ((j6 * j7) + (j5 * j8) + (j4 * j9) + (j3 * j10)) * 2, (j7 * j7) + (((j5 * j9) + (((j6 * j8) + (j4 * j10)) * 2)) * 2), ((j7 * j8) + (j6 * j9) + (j5 * j10)) * 2, ((j8 * j8) + (j7 * j9) + (j6 * 2 * j10)) * 2, ((j8 * j9) + (j7 * j10)) * 2, (j9 * j9) + (j8 * 4 * j10), j9 * 2 * j10, 2 * j10 * j10}, jArr);
    }

    public static void zzc(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] - jArr3[i];
        }
    }

    public static void zzd(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] + jArr3[i];
        }
    }

    public static void zza(long[] jArr, long[] jArr2, long j) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] * j;
        }
    }

    public static void zzb(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr[0] = jArr2[0] * jArr3[0];
        long j = jArr2[0];
        long j2 = jArr3[1] * j;
        long j3 = jArr2[1];
        long j4 = jArr3[0];
        jArr[1] = j2 + (j3 * j4);
        long j5 = jArr2[1];
        long j6 = jArr3[1];
        jArr[2] = (j5 * 2 * j6) + (jArr3[2] * j) + (jArr2[2] * j4);
        long j7 = jArr3[2];
        long j8 = jArr2[2];
        jArr[3] = (j5 * j7) + (j8 * j6) + (jArr3[3] * j) + (jArr2[3] * j4);
        long j9 = jArr3[3];
        long j10 = jArr2[3];
        jArr[4] = (j8 * j7) + (((j5 * j9) + (j10 * j6)) * 2) + (jArr3[4] * j) + (jArr2[4] * j4);
        long j11 = jArr3[4];
        long j12 = jArr2[4];
        jArr[5] = (j8 * j9) + (j10 * j7) + (j5 * j11) + (j12 * j6) + (jArr3[5] * j) + (jArr2[5] * j4);
        long j13 = jArr3[5];
        long j14 = jArr2[5];
        jArr[6] = (((j10 * j9) + (j5 * j13) + (j14 * j6)) * 2) + (j8 * j11) + (j12 * j7) + (jArr3[6] * j) + (jArr2[6] * j4);
        long j15 = jArr3[6];
        long j16 = jArr2[6];
        jArr[7] = (j10 * j11) + (j12 * j9) + (j8 * j13) + (j14 * j7) + (j5 * j15) + (j16 * j6) + (jArr3[7] * j) + (jArr2[7] * j4);
        long j17 = jArr3[7];
        long j18 = jArr2[7];
        jArr[8] = (j12 * j11) + (((j10 * j13) + (j14 * j9) + (j5 * j17) + (j18 * j6)) * 2) + (j8 * j15) + (j16 * j7) + (jArr3[8] * j) + (jArr2[8] * j4);
        long j19 = jArr3[8];
        long j20 = jArr2[8];
        jArr[9] = (j12 * j13) + (j14 * j11) + (j10 * j15) + (j16 * j9) + (j8 * j17) + (j18 * j7) + (j5 * j19) + (j20 * j6) + (j * jArr3[9]) + (jArr2[9] * j4);
        long j21 = jArr3[9];
        long j22 = jArr2[9];
        jArr[10] = (((j14 * j13) + (j10 * j17) + (j18 * j9) + (j5 * j21) + (j6 * j22)) * 2) + (j12 * j15) + (j16 * j11) + (j8 * j19) + (j20 * j7);
        jArr[11] = (j14 * j15) + (j16 * j13) + (j12 * j17) + (j18 * j11) + (j10 * j19) + (j20 * j9) + (j8 * j21) + (j7 * j22);
        jArr[12] = (j16 * j15) + (((j14 * j17) + (j18 * j13) + (j10 * j21) + (j9 * j22)) * 2) + (j12 * j19) + (j20 * j11);
        jArr[13] = (j16 * j17) + (j18 * j15) + (j14 * j19) + (j20 * j13) + (j12 * j21) + (j11 * j22);
        jArr[14] = (((j18 * j17) + (j14 * j21) + (j13 * j22)) * 2) + (j16 * j19) + (j20 * j15);
        jArr[15] = (j18 * j19) + (j20 * j17) + (j16 * j21) + (j15 * j22);
        jArr[16] = (j20 * j19) + (((j18 * j21) + (j17 * j22)) * 2);
        jArr[17] = (j20 * j21) + (j19 * j22);
        jArr[18] = j22 * 2 * j21;
    }

    public static byte[] zzc(long[] jArr) {
        int i;
        long[] copyOf = Arrays.copyOf(jArr, 10);
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                break;
            }
            int i3 = 0;
            while (i3 < 9) {
                long j = copyOf[i3];
                int i4 = -((int) (((j >> 31) & j) >> zzd[i3 & 1]));
                copyOf[i3] = j + (i4 << r14);
                i3++;
                copyOf[i3] = copyOf[i3] - i4;
            }
            long j2 = copyOf[9];
            copyOf[9] = j2 + (r6 << 25);
            copyOf[0] = copyOf[0] - ((-((int) (((j2 >> 31) & j2) >> 25))) * 19);
            i2++;
        }
        long j3 = copyOf[0];
        copyOf[0] = j3 + (r3 << 26);
        copyOf[1] = copyOf[1] - (-((int) (((j3 >> 31) & j3) >> 26)));
        int i5 = 0;
        for (i = 2; i5 < i; i = 2) {
            int i6 = 0;
            while (i6 < 9) {
                long j4 = copyOf[i6];
                int i7 = (int) (j4 >> zzd[i6 & 1]);
                copyOf[i6] = j4 & zzc[r15];
                i6++;
                copyOf[i6] = copyOf[i6] + i7;
            }
            i5++;
        }
        copyOf[9] = copyOf[9] & 33554431;
        long j5 = copyOf[0] + (((int) (r9 >> 25)) * 19);
        copyOf[0] = j5;
        int i8 = ~((((int) j5) - 67108845) >> 31);
        for (int i9 = 1; i9 < 10; i9++) {
            int i10 = ~(((int) copyOf[i9]) ^ zzc[i9 & 1]);
            int i11 = i10 & (i10 << 16);
            int i12 = i11 & (i11 << 8);
            int i13 = i12 & (i12 << 4);
            int i14 = i13 & (i13 << 2);
            i8 &= (i14 & (i14 << 1)) >> 31;
        }
        copyOf[0] = copyOf[0] - (67108845 & i8);
        long j6 = 33554431 & i8;
        copyOf[1] = copyOf[1] - j6;
        for (int i15 = 2; i15 < 10; i15 += 2) {
            copyOf[i15] = copyOf[i15] - (67108863 & i8);
            int i16 = i15 + 1;
            copyOf[i16] = copyOf[i16] - j6;
        }
        for (int i17 = 0; i17 < 10; i17++) {
            copyOf[i17] = copyOf[i17] << zzb[i17];
        }
        byte[] bArr = new byte[32];
        for (int i18 = 0; i18 < 10; i18++) {
            int i19 = zza[i18];
            long j7 = bArr[i19];
            long j8 = copyOf[i18];
            bArr[i19] = (byte) (j7 | (j8 & 255));
            bArr[i19 + 1] = (byte) (bArr[r5] | ((j8 >> 8) & 255));
            bArr[i19 + 2] = (byte) (bArr[r5] | ((j8 >> 16) & 255));
            bArr[i19 + 3] = (byte) (bArr[r4] | ((j8 >> 24) & 255));
        }
        return bArr;
    }

    public static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        zzb(jArr4, jArr2, jArr3);
        zze(jArr4, jArr);
    }

    public static long[] zza(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i = 0; i < 10; i++) {
            int i2 = zza[i];
            jArr[i] = (((((bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8)) | ((bArr[i2 + 2] & 255) << 16)) | ((bArr[i2 + 3] & 255) << 24)) >> zzb[i]) & zzc[i & 1];
        }
        return jArr;
    }
}
