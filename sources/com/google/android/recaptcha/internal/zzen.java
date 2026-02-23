package com.google.android.recaptcha.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzen {
    public static int zza(byte[] bArr, int i, zzem zzemVar) throws zzgy {
        int zzj = zzj(bArr, i, zzemVar);
        int i2 = zzemVar.zza;
        if (i2 < 0) {
            throw zzgy.zzf();
        }
        if (i2 > bArr.length - zzj) {
            throw zzgy.zzj();
        }
        if (i2 == 0) {
            zzemVar.zzc = zzez.zzb;
            return zzj;
        }
        zzemVar.zzc = zzez.zzm(bArr, zzj, i2);
        return zzj + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static int zzc(zzil zzilVar, byte[] bArr, int i, int i2, int i3, zzem zzemVar) throws IOException {
        Object zze = zzilVar.zze();
        int zzn = zzn(zze, zzilVar, bArr, i, i2, i3, zzemVar);
        zzilVar.zzf(zze);
        zzemVar.zzc = zze;
        return zzn;
    }

    public static int zzd(zzil zzilVar, byte[] bArr, int i, int i2, zzem zzemVar) throws IOException {
        Object zze = zzilVar.zze();
        int zzo = zzo(zze, zzilVar, bArr, i, i2, zzemVar);
        zzilVar.zzf(zze);
        zzemVar.zzc = zze;
        return zzo;
    }

    public static int zze(zzil zzilVar, int i, byte[] bArr, int i2, int i3, zzgv zzgvVar, zzem zzemVar) throws IOException {
        int zzd = zzd(zzilVar, bArr, i2, i3, zzemVar);
        while (true) {
            zzgvVar.add(zzemVar.zzc);
            if (zzd >= i3) {
                break;
            }
            int zzj = zzj(bArr, zzd, zzemVar);
            if (i != zzemVar.zza) {
                break;
            }
            zzd = zzd(zzilVar, bArr, zzj, i3, zzemVar);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i, zzgv zzgvVar, zzem zzemVar) throws IOException {
        zzgp zzgpVar = (zzgp) zzgvVar;
        int zzj = zzj(bArr, i, zzemVar);
        int i2 = zzemVar.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzemVar);
            zzgpVar.zzg(zzemVar.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzgy.zzj();
    }

    public static int zzg(byte[] bArr, int i, zzem zzemVar) throws zzgy {
        int zzj = zzj(bArr, i, zzemVar);
        int i2 = zzemVar.zza;
        if (i2 < 0) {
            throw zzgy.zzf();
        }
        if (i2 == 0) {
            zzemVar.zzc = "";
            return zzj;
        }
        zzemVar.zzc = new String(bArr, zzj, i2, zzgw.zzb);
        return zzj + i2;
    }

    public static int zzh(byte[] bArr, int i, zzem zzemVar) throws zzgy {
        int zzj = zzj(bArr, i, zzemVar);
        int i2 = zzemVar.zza;
        if (i2 < 0) {
            throw zzgy.zzf();
        }
        if (i2 == 0) {
            zzemVar.zzc = "";
            return zzj;
        }
        zzemVar.zzc = zzju.zzd(bArr, zzj, i2);
        return zzj + i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, int i3, zzjg zzjgVar, zzem zzemVar) throws zzgy {
        if ((i >>> 3) == 0) {
            throw zzgy.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zzm = zzm(bArr, i2, zzemVar);
            zzjgVar.zzj(i, Long.valueOf(zzemVar.zzb));
            return zzm;
        }
        if (i4 == 1) {
            zzjgVar.zzj(i, Long.valueOf(zzq(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zzj = zzj(bArr, i2, zzemVar);
            int i5 = zzemVar.zza;
            if (i5 < 0) {
                throw zzgy.zzf();
            }
            if (i5 > bArr.length - zzj) {
                throw zzgy.zzj();
            }
            zzjgVar.zzj(i, i5 == 0 ? zzez.zzb : zzez.zzm(bArr, zzj, i5));
            return zzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzgy.zzc();
            }
            zzjgVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzjg zzf = zzjg.zzf();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zzj2 = zzj(bArr, i2, zzemVar);
            int i8 = zzemVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = zzj2;
                break;
            }
            int zzi = zzi(i7, bArr, zzj2, i3, zzf, zzemVar);
            i7 = i8;
            i2 = zzi;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzgy.zzg();
        }
        zzjgVar.zzj(i, zzf);
        return i2;
    }

    public static int zzj(byte[] bArr, int i, zzem zzemVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzemVar);
        }
        zzemVar.zza = b;
        return i2;
    }

    public static int zzk(int i, byte[] bArr, int i2, zzem zzemVar) {
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
                zzemVar.zza = i6 | (b2 << 14);
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
                    zzemVar.zza = i8 | (b4 << 28);
                    return i9;
                }
                int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 28);
                while (true) {
                    int i11 = i9 + 1;
                    if (bArr[i9] >= 0) {
                        zzemVar.zza = i10;
                        return i11;
                    }
                    i9 = i11;
                }
            }
        }
        zzemVar.zza = i5 | i3;
        return i4;
    }

    public static int zzl(int i, byte[] bArr, int i2, int i3, zzgv zzgvVar, zzem zzemVar) {
        zzgp zzgpVar = (zzgp) zzgvVar;
        int zzj = zzj(bArr, i2, zzemVar);
        while (true) {
            zzgpVar.zzg(zzemVar.zza);
            if (zzj >= i3) {
                break;
            }
            int zzj2 = zzj(bArr, zzj, zzemVar);
            if (i != zzemVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzemVar);
        }
        return zzj;
    }

    public static int zzm(byte[] bArr, int i, zzem zzemVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzemVar.zzb = j;
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
        zzemVar.zzb = j2;
        return i3;
    }

    public static int zzn(Object obj, zzil zzilVar, byte[] bArr, int i, int i2, int i3, zzem zzemVar) throws IOException {
        int zzc = ((zzib) zzilVar).zzc(obj, bArr, i, i2, i3, zzemVar);
        zzemVar.zzc = obj;
        return zzc;
    }

    public static int zzo(Object obj, zzil zzilVar, byte[] bArr, int i, int i2, zzem zzemVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzk(i4, bArr, i3, zzemVar);
            i4 = zzemVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzgy.zzj();
        }
        int i6 = i4 + i5;
        zzilVar.zzi(obj, bArr, i5, i6, zzemVar);
        zzemVar.zzc = obj;
        return i6;
    }

    public static int zzp(int i, byte[] bArr, int i2, int i3, zzem zzemVar) throws zzgy {
        if ((i >>> 3) == 0) {
            throw zzgy.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzm(bArr, i2, zzemVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzj(bArr, i2, zzemVar) + zzemVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzgy.zzc();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzj(bArr, i2, zzemVar);
            i6 = zzemVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzp(i6, bArr, i2, i3, zzemVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzgy.zzg();
        }
        return i2;
    }

    public static long zzq(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }
}
