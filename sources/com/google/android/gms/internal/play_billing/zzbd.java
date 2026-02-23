package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzbd {
    public static int zza(byte[] bArr, int i, zzbc zzbcVar) throws zzdc {
        int zzh = zzh(bArr, i, zzbcVar);
        int i2 = zzbcVar.zza;
        if (i2 < 0) {
            throw zzdc.zzd();
        }
        if (i2 > bArr.length - zzh) {
            throw zzdc.zzg();
        }
        if (i2 == 0) {
            zzbcVar.zzc = zzbq.zzb;
            return zzh;
        }
        zzbcVar.zzc = zzbq.zzl(bArr, zzh, i2);
        return zzh + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static int zzc(zzeo zzeoVar, byte[] bArr, int i, int i2, int i3, zzbc zzbcVar) throws IOException {
        Object zze = zzeoVar.zze();
        int zzl = zzl(zze, zzeoVar, bArr, i, i2, i3, zzbcVar);
        zzeoVar.zzf(zze);
        zzbcVar.zzc = zze;
        return zzl;
    }

    public static int zzd(zzeo zzeoVar, byte[] bArr, int i, int i2, zzbc zzbcVar) throws IOException {
        Object zze = zzeoVar.zze();
        int zzm = zzm(zze, zzeoVar, bArr, i, i2, zzbcVar);
        zzeoVar.zzf(zze);
        zzbcVar.zzc = zze;
        return zzm;
    }

    public static int zze(zzeo zzeoVar, int i, byte[] bArr, int i2, int i3, zzcz zzczVar, zzbc zzbcVar) throws IOException {
        int zzd = zzd(zzeoVar, bArr, i2, i3, zzbcVar);
        while (true) {
            zzczVar.add(zzbcVar.zzc);
            if (zzd >= i3) {
                break;
            }
            int zzh = zzh(bArr, zzd, zzbcVar);
            if (i != zzbcVar.zza) {
                break;
            }
            zzd = zzd(zzeoVar, bArr, zzh, i3, zzbcVar);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i, zzcz zzczVar, zzbc zzbcVar) throws IOException {
        zzct zzctVar = (zzct) zzczVar;
        int zzh = zzh(bArr, i, zzbcVar);
        int i2 = zzbcVar.zza + zzh;
        while (zzh < i2) {
            zzh = zzh(bArr, zzh, zzbcVar);
            zzctVar.zzg(zzbcVar.zza);
        }
        if (zzh == i2) {
            return zzh;
        }
        throw zzdc.zzg();
    }

    public static int zzg(int i, byte[] bArr, int i2, int i3, zzfg zzfgVar, zzbc zzbcVar) throws zzdc {
        if ((i >>> 3) == 0) {
            throw zzdc.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zzk = zzk(bArr, i2, zzbcVar);
            zzfgVar.zzj(i, Long.valueOf(zzbcVar.zzb));
            return zzk;
        }
        if (i4 == 1) {
            zzfgVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zzh = zzh(bArr, i2, zzbcVar);
            int i5 = zzbcVar.zza;
            if (i5 < 0) {
                throw zzdc.zzd();
            }
            if (i5 > bArr.length - zzh) {
                throw zzdc.zzg();
            }
            zzfgVar.zzj(i, i5 == 0 ? zzbq.zzb : zzbq.zzl(bArr, zzh, i5));
            return zzh + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzdc.zzb();
            }
            zzfgVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzfg zzf = zzfg.zzf();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zzh2 = zzh(bArr, i2, zzbcVar);
            int i8 = zzbcVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = zzh2;
                break;
            }
            int zzg = zzg(i7, bArr, zzh2, i3, zzf, zzbcVar);
            i7 = i8;
            i2 = zzg;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzdc.zze();
        }
        zzfgVar.zzj(i, zzf);
        return i2;
    }

    public static int zzh(byte[] bArr, int i, zzbc zzbcVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzbcVar);
        }
        zzbcVar.zza = b;
        return i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, zzbc zzbcVar) {
        int i3;
        byte b = bArr[i2];
        int i4 = i2 + 1;
        int i5 = i & 127;
        if (b >= 0) {
            i3 = b << 7;
        } else {
            int i6 = i5 | ((b & Byte.MAX_VALUE) << 7);
            int i7 = i2 + 2;
            byte b2 = bArr[i4];
            if (b2 >= 0) {
                zzbcVar.zza = i6 | (b2 << 14);
                return i7;
            }
            i5 = i6 | ((b2 & Byte.MAX_VALUE) << 14);
            i4 = i2 + 3;
            byte b3 = bArr[i7];
            if (b3 >= 0) {
                i3 = b3 << 21;
            } else {
                int i8 = i5 | ((b3 & Byte.MAX_VALUE) << 21);
                int i9 = i2 + 4;
                byte b4 = bArr[i4];
                if (b4 >= 0) {
                    zzbcVar.zza = i8 | (b4 << 28);
                    return i9;
                }
                int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 28);
                while (true) {
                    int i11 = i9 + 1;
                    if (bArr[i9] >= 0) {
                        zzbcVar.zza = i10;
                        return i11;
                    }
                    i9 = i11;
                }
            }
        }
        zzbcVar.zza = i5 | i3;
        return i4;
    }

    public static int zzj(int i, byte[] bArr, int i2, int i3, zzcz zzczVar, zzbc zzbcVar) {
        zzct zzctVar = (zzct) zzczVar;
        int zzh = zzh(bArr, i2, zzbcVar);
        while (true) {
            zzctVar.zzg(zzbcVar.zza);
            if (zzh >= i3) {
                break;
            }
            int zzh2 = zzh(bArr, zzh, zzbcVar);
            if (i != zzbcVar.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzbcVar);
        }
        return zzh;
    }

    public static int zzk(byte[] bArr, int i, zzbc zzbcVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzbcVar.zzb = j;
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
        zzbcVar.zzb = j2;
        return i3;
    }

    public static int zzl(Object obj, zzeo zzeoVar, byte[] bArr, int i, int i2, int i3, zzbc zzbcVar) throws IOException {
        int zzc = ((zzef) zzeoVar).zzc(obj, bArr, i, i2, i3, zzbcVar);
        zzbcVar.zzc = obj;
        return zzc;
    }

    public static int zzm(Object obj, zzeo zzeoVar, byte[] bArr, int i, int i2, zzbc zzbcVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzi(i4, bArr, i3, zzbcVar);
            i4 = zzbcVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzdc.zzg();
        }
        int i6 = i4 + i5;
        zzeoVar.zzh(obj, bArr, i5, i6, zzbcVar);
        zzbcVar.zzc = obj;
        return i6;
    }

    public static long zzn(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }
}
