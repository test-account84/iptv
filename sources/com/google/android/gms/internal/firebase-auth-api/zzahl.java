package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzahl {
    public static double zza(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    public static float zzb(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }

    public static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int zzd(byte[] bArr, int i, zzahk zzahkVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzahkVar.zzb = j;
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
        zzahkVar.zzb = j2;
        return i3;
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzahk zzahkVar) throws zzaji {
        if ((i >>> 3) == 0) {
            throw zzaji.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzd(bArr, i2, zzahkVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzc(bArr, i2, zzahkVar) + zzahkVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzaji.zzc();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzc(bArr, i2, zzahkVar);
            i6 = zzahkVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zza(i6, bArr, i2, i3, zzahkVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzaji.zzg();
        }
        return i2;
    }

    public static int zzb(byte[] bArr, int i, zzahk zzahkVar) throws zzaji {
        int zzc = zzc(bArr, i, zzahkVar);
        int i2 = zzahkVar.zza;
        if (i2 < 0) {
            throw zzaji.zzf();
        }
        if (i2 == 0) {
            zzahkVar.zzc = "";
            return zzc;
        }
        zzahkVar.zzc = zzaml.zzb(bArr, zzc, i2);
        return zzc + i2;
    }

    public static int zzc(byte[] bArr, int i, zzahk zzahkVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzahkVar);
        }
        zzahkVar.zza = b;
        return i2;
    }

    public static long zzd(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzajj zzajjVar, zzahk zzahkVar) {
        zzajd zzajdVar = (zzajd) zzajjVar;
        int zzc = zzc(bArr, i2, zzahkVar);
        while (true) {
            zzajdVar.zzc(zzahkVar.zza);
            if (zzc >= i3) {
                break;
            }
            int zzc2 = zzc(bArr, zzc, zzahkVar);
            if (i != zzahkVar.zza) {
                break;
            }
            zzc = zzc(bArr, zzc2, zzahkVar);
        }
        return zzc;
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzamd zzamdVar, zzahk zzahkVar) throws zzaji {
        if ((i >>> 3) == 0) {
            throw zzaji.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zzd = zzd(bArr, i2, zzahkVar);
            zzamdVar.zza(i, Long.valueOf(zzahkVar.zzb));
            return zzd;
        }
        if (i4 == 1) {
            zzamdVar.zza(i, Long.valueOf(zzd(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zzc = zzc(bArr, i2, zzahkVar);
            int i5 = zzahkVar.zza;
            if (i5 < 0) {
                throw zzaji.zzf();
            }
            if (i5 > bArr.length - zzc) {
                throw zzaji.zzi();
            }
            zzamdVar.zza(i, i5 == 0 ? zzahp.zza : zzahp.zza(bArr, zzc, i5));
            return zzc + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzaji.zzc();
            }
            zzamdVar.zza(i, Integer.valueOf(zzc(bArr, i2)));
            return i2 + 4;
        }
        zzamd zzd2 = zzamd.zzd();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zzc2 = zzc(bArr, i2, zzahkVar);
            int i8 = zzahkVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = zzc2;
                break;
            }
            int zza = zza(i7, bArr, zzc2, i3, zzd2, zzahkVar);
            i7 = i8;
            i2 = zza;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzaji.zzg();
        }
        zzamdVar.zza(i, zzd2);
        return i2;
    }

    public static int zza(int i, byte[] bArr, int i2, zzahk zzahkVar) {
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
                zzahkVar.zza = i6 | (b2 << 14);
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
                    zzahkVar.zza = i8 | (b4 << 28);
                    return i9;
                }
                int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 28);
                while (true) {
                    int i11 = i9 + 1;
                    if (bArr[i9] >= 0) {
                        zzahkVar.zza = i10;
                        return i11;
                    }
                    i9 = i11;
                }
            }
        }
        zzahkVar.zza = i4 | i3;
        return i5;
    }

    public static int zza(zzalf zzalfVar, int i, byte[] bArr, int i2, int i3, zzajj zzajjVar, zzahk zzahkVar) throws IOException {
        int zza = zza(zzalfVar, bArr, i2, i3, zzahkVar);
        while (true) {
            zzajjVar.add(zzahkVar.zzc);
            if (zza >= i3) {
                break;
            }
            int zzc = zzc(bArr, zza, zzahkVar);
            if (i != zzahkVar.zza) {
                break;
            }
            zza = zza(zzalfVar, bArr, zzc, i3, zzahkVar);
        }
        return zza;
    }

    public static int zza(zzalf zzalfVar, byte[] bArr, int i, int i2, int i3, zzahk zzahkVar) throws IOException {
        Object zza = zzalfVar.zza();
        int zza2 = zza(zza, zzalfVar, bArr, i, i2, i3, zzahkVar);
        zzalfVar.zzc(zza);
        zzahkVar.zzc = zza;
        return zza2;
    }

    public static int zza(zzalf zzalfVar, byte[] bArr, int i, int i2, zzahk zzahkVar) throws IOException {
        Object zza = zzalfVar.zza();
        int zza2 = zza(zza, zzalfVar, bArr, i, i2, zzahkVar);
        zzalfVar.zzc(zza);
        zzahkVar.zzc = zza;
        return zza2;
    }

    public static int zza(Object obj, zzalf zzalfVar, byte[] bArr, int i, int i2, int i3, zzahk zzahkVar) throws IOException {
        int zza = ((zzakr) zzalfVar).zza(obj, bArr, i, i2, i3, zzahkVar);
        zzahkVar.zzc = obj;
        return zza;
    }

    public static int zza(Object obj, zzalf zzalfVar, byte[] bArr, int i, int i2, zzahk zzahkVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zza(i4, bArr, i3, zzahkVar);
            i4 = zzahkVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzaji.zzi();
        }
        int i6 = i4 + i5;
        zzalfVar.zza(obj, bArr, i5, i6, zzahkVar);
        zzahkVar.zzc = obj;
        return i6;
    }

    public static int zza(byte[] bArr, int i, zzahk zzahkVar) throws zzaji {
        int zzc = zzc(bArr, i, zzahkVar);
        int i2 = zzahkVar.zza;
        if (i2 < 0) {
            throw zzaji.zzf();
        }
        if (i2 > bArr.length - zzc) {
            throw zzaji.zzi();
        }
        if (i2 == 0) {
            zzahkVar.zzc = zzahp.zza;
            return zzc;
        }
        zzahkVar.zzc = zzahp.zza(bArr, zzc, i2);
        return zzc + i2;
    }

    public static int zza(byte[] bArr, int i, zzajj zzajjVar, zzahk zzahkVar) throws IOException {
        zzajd zzajdVar = (zzajd) zzajjVar;
        int zzc = zzc(bArr, i, zzahkVar);
        int i2 = zzahkVar.zza + zzc;
        while (zzc < i2) {
            zzc = zzc(bArr, zzc, zzahkVar);
            zzajdVar.zzc(zzahkVar.zza);
        }
        if (zzc == i2) {
            return zzc;
        }
        throw zzaji.zzi();
    }
}
