package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaif extends zzaia {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private zzaie zzm;

    private zzaif(InputStream inputStream, int i) {
        super(null);
        this.zzl = Integer.MAX_VALUE;
        this.zzm = null;
        zzajf.zza(inputStream, "input");
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final void zzaa() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = this.zzk + i;
        int i3 = this.zzl;
        if (i2 <= i3) {
            this.zzh = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzh = i4;
        this.zzg = i - i4;
    }

    private final byte zzv() throws IOException {
        if (this.zzi == this.zzg) {
            zzg(1);
        }
        byte[] bArr = this.zzf;
        int i = this.zzi;
        this.zzi = i + 1;
        return bArr[i];
    }

    private final int zzw() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzg(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final int zzx() throws IOException {
        int i;
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i3 != i2) {
            byte[] bArr = this.zzf;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzi = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.zzi = i5;
                return i;
            }
        }
        return (int) zzm();
    }

    private final long zzy() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzg(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private final long zzz() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzi;
        int i2 = this.zzg;
        if (i2 != i) {
            byte[] bArr = this.zzf;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzi = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << 14) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            long j4 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j4;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (bArr[i8] << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i10 = i + 6;
                                long j7 = j6 ^ (bArr[i4] << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (bArr[i10] << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i10 = i + 8;
                                        j7 = j6 ^ (bArr[i4] << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i11 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i11;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j = j7 ^ j2;
                                i4 = i10;
                            }
                            j = j6 ^ j3;
                        }
                    }
                }
                this.zzi = i4;
                return j;
            }
        }
        return zzm();
    }

    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzw());
    }

    public final int zzc() {
        return this.zzk + this.zzi;
    }

    public final int zzd() throws IOException {
        return zzx();
    }

    public final int zze() throws IOException {
        return zzw();
    }

    public final int zzf() throws IOException {
        return zzx();
    }

    public final int zzg() throws IOException {
        return zzw();
    }

    public final int zzh() throws IOException {
        return zzaia.zza(zzx());
    }

    public final int zzi() throws IOException {
        if (zzt()) {
            this.zzj = 0;
            return 0;
        }
        int zzx = zzx();
        this.zzj = zzx;
        if ((zzx >>> 3) != 0) {
            return zzx;
        }
        throw zzaji.zzc();
    }

    public final int zzj() throws IOException {
        return zzx();
    }

    public final long zzk() throws IOException {
        return zzy();
    }

    public final long zzl() throws IOException {
        return zzz();
    }

    public final long zzm() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzv() & 128) == 0) {
                return j;
            }
        }
        throw zzaji.zze();
    }

    public final long zzn() throws IOException {
        return zzy();
    }

    public final long zzo() throws IOException {
        return zzaia.zza(zzz());
    }

    public final long zzp() throws IOException {
        return zzz();
    }

    public final zzahp zzq() throws IOException {
        int zzx = zzx();
        int i = this.zzg;
        int i2 = this.zzi;
        if (zzx <= i - i2 && zzx > 0) {
            zzahp zza = zzahp.zza(this.zzf, i2, zzx);
            this.zzi += zzx;
            return zza;
        }
        if (zzx == 0) {
            return zzahp.zza;
        }
        byte[] zzj = zzj(zzx);
        if (zzj != null) {
            return zzahp.zza(zzj);
        }
        int i3 = this.zzi;
        int i4 = this.zzg;
        int i5 = i4 - i3;
        this.zzk += i4;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzf = zzf(zzx - i5);
        byte[] bArr = new byte[zzx];
        System.arraycopy(this.zzf, i3, bArr, 0, i5);
        for (byte[] bArr2 : zzf) {
            System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
            i5 += bArr2.length;
        }
        return zzahp.zzb(bArr);
    }

    public final String zzr() throws IOException {
        int zzx = zzx();
        if (zzx > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (zzx <= i - i2) {
                String str = new String(this.zzf, i2, zzx, zzajf.zza);
                this.zzi += zzx;
                return str;
            }
        }
        if (zzx == 0) {
            return "";
        }
        if (zzx > this.zzg) {
            return new String(zza(zzx, false), zzajf.zza);
        }
        zzg(zzx);
        String str2 = new String(this.zzf, this.zzi, zzx, zzajf.zza);
        this.zzi += zzx;
        return str2;
    }

    public final String zzs() throws IOException {
        byte[] zza;
        int zzx = zzx();
        int i = this.zzi;
        int i2 = this.zzg;
        if (zzx <= i2 - i && zzx > 0) {
            zza = this.zzf;
            this.zzi = i + zzx;
        } else {
            if (zzx == 0) {
                return "";
            }
            i = 0;
            if (zzx <= i2) {
                zzg(zzx);
                zza = this.zzf;
                this.zzi = zzx;
            } else {
                zza = zza(zzx, false);
            }
        }
        return zzaml.zzb(zza, i, zzx);
    }

    public final boolean zzt() throws IOException {
        return this.zzi == this.zzg && !zzi(1);
    }

    public final boolean zzu() throws IOException {
        return zzz() != 0;
    }

    public /* synthetic */ zzaif(InputStream inputStream, int i, zzaih zzaihVar) {
        this(inputStream, 4096);
    }

    private static int zza(InputStream inputStream) throws IOException {
        try {
            return inputStream.available();
        } catch (zzaji e) {
            e.zzj();
            throw e;
        }
    }

    private final List zzf(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.zze.read(bArr, i2, min - i2);
                if (read == -1) {
                    throw zzaji.zzi();
                }
                this.zzk += read;
                i2 += read;
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzg(int i) throws IOException {
        if (zzi(i)) {
            return;
        }
        if (i <= (this.zzc - this.zzk) - this.zzi) {
            throw zzaji.zzi();
        }
        throw zzaji.zzh();
    }

    private final void zzh(int i) throws IOException {
        int i2 = this.zzg;
        int i3 = this.zzi;
        if (i <= i2 - i3 && i >= 0) {
            this.zzi = i3 + i;
            return;
        }
        if (i < 0) {
            throw zzaji.zzf();
        }
        int i4 = this.zzk;
        int i5 = i4 + i3 + i;
        int i6 = this.zzl;
        if (i5 > i6) {
            zzh((i6 - i4) - i3);
            throw zzaji.zzi();
        }
        this.zzk = i4 + i3;
        int i7 = i2 - i3;
        this.zzg = 0;
        this.zzi = 0;
        while (i7 < i) {
            try {
                long j = i - i7;
                long zza = zza(this.zze, j);
                if (zza >= 0 && zza <= j) {
                    if (zza == 0) {
                        break;
                    } else {
                        i7 += (int) zza;
                    }
                } else {
                    throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + zza + "\nThe InputStream implementation is buggy.");
                }
            } finally {
                this.zzk += i7;
                zzaa();
            }
        }
        if (i7 >= i) {
            return;
        }
        int i8 = this.zzg;
        int i9 = i8 - this.zzi;
        this.zzi = i8;
        while (true) {
            zzg(1);
            int i10 = i - i9;
            int i11 = this.zzg;
            if (i10 <= i11) {
                this.zzi = i10;
                return;
            } else {
                i9 += i11;
                this.zzi = i11;
            }
        }
    }

    private final boolean zzi(int i) throws IOException {
        do {
            int i2 = this.zzi;
            int i3 = i2 + i;
            int i4 = this.zzg;
            if (i3 <= i4) {
                throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
            }
            int i5 = this.zzc;
            int i6 = this.zzk;
            if (i > (i5 - i6) - i2 || i6 + i2 + i > this.zzl) {
                return false;
            }
            if (i2 > 0) {
                if (i4 > i2) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                this.zzk += i2;
                this.zzg -= i2;
                this.zzi = 0;
            }
            InputStream inputStream = this.zze;
            byte[] bArr2 = this.zzf;
            int i7 = this.zzg;
            int zza = zza(inputStream, bArr2, i7, Math.min(bArr2.length - i7, (this.zzc - this.zzk) - i7));
            if (zza == 0 || zza < -1 || zza > this.zzf.length) {
                throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + zza + "\nThe InputStream implementation is buggy.");
            }
            if (zza <= 0) {
                return false;
            }
            this.zzg += zza;
            zzaa();
        } while (this.zzg < i);
        return true;
    }

    private final byte[] zzj(int i) throws IOException {
        if (i == 0) {
            return zzajf.zzb;
        }
        if (i < 0) {
            throw zzaji.zzf();
        }
        int i2 = this.zzk;
        int i3 = this.zzi;
        int i4 = i2 + i3 + i;
        if (i4 - this.zzc > 0) {
            throw zzaji.zzh();
        }
        int i5 = this.zzl;
        if (i4 > i5) {
            zzh((i5 - i2) - i3);
            throw zzaji.zzi();
        }
        int i6 = this.zzg - i3;
        int i7 = i - i6;
        if (i7 >= 4096 && i7 > zza(this.zze)) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, this.zzi, bArr, 0, i6);
        this.zzk += this.zzg;
        this.zzi = 0;
        this.zzg = 0;
        while (i6 < i) {
            int zza = zza(this.zze, bArr, i6, i - i6);
            if (zza == -1) {
                throw zzaji.zzi();
            }
            this.zzk += zza;
            i6 += zza;
        }
        return bArr;
    }

    public final int zzb(int i) throws zzaji {
        if (i < 0) {
            throw zzaji.zzf();
        }
        int i2 = i + this.zzk + this.zzi;
        int i3 = this.zzl;
        if (i2 > i3) {
            throw zzaji.zzi();
        }
        this.zzl = i2;
        zzaa();
        return i3;
    }

    public final void zzc(int i) throws zzaji {
        if (this.zzj != i) {
            throw zzaji.zzb();
        }
    }

    public final void zzd(int i) {
        this.zzl = i;
        zzaa();
    }

    public final boolean zze(int i) throws IOException {
        int zzi;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzg - this.zzi < 10) {
                while (i3 < 10) {
                    if (zzv() < 0) {
                        i3++;
                    }
                }
                throw zzaji.zze();
            }
            while (i3 < 10) {
                byte[] bArr = this.zzf;
                int i4 = this.zzi;
                this.zzi = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            throw zzaji.zze();
            return true;
        }
        if (i2 == 1) {
            zzh(8);
            return true;
        }
        if (i2 == 2) {
            zzh(zzx());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzaji.zza();
            }
            zzh(4);
            return true;
        }
        do {
            zzi = zzi();
            if (zzi == 0) {
                break;
            }
        } while (zze(zzi));
        zzc(((i >>> 3) << 3) | 4);
        return true;
    }

    private static int zza(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        try {
            return inputStream.read(bArr, i, i2);
        } catch (zzaji e) {
            e.zzj();
            throw e;
        }
    }

    private static long zza(InputStream inputStream, long j) throws IOException {
        try {
            return inputStream.skip(j);
        } catch (zzaji e) {
            e.zzj();
            throw e;
        }
    }

    private final byte[] zza(int i, boolean z) throws IOException {
        byte[] zzj = zzj(i);
        if (zzj != null) {
            return zzj;
        }
        int i2 = this.zzi;
        int i3 = this.zzg;
        int i4 = i3 - i2;
        this.zzk += i3;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzf = zzf(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzf) {
            System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
            i4 += bArr2.length;
        }
        return bArr;
    }
}
