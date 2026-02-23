package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzbv extends zzby {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzbv(byte[] bArr, int i, int i2) {
        super(null);
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i2)}));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i2;
    }

    public final int zza() {
        return this.zzc - this.zzd;
    }

    public final void zzb(byte b) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i = this.zzd;
            this.zzd = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e);
        }
    }

    public final void zzc(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i2);
            this.zzd += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i2)}), e);
        }
    }

    public final void zzd(int i, boolean z) throws IOException {
        zzq(i << 3);
        zzb(z ? (byte) 1 : (byte) 0);
    }

    public final void zze(int i, zzbq zzbqVar) throws IOException {
        zzq((i << 3) | 2);
        zzq(zzbqVar.zzd());
        zzbqVar.zzh(this);
    }

    public final void zzf(int i, int i2) throws IOException {
        zzq((i << 3) | 5);
        zzg(i2);
    }

    public final void zzg(int i) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i2 = this.zzd;
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            this.zzd = i2 + 4;
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e);
        }
    }

    public final void zzh(int i, long j) throws IOException {
        zzq((i << 3) | 1);
        zzi(j);
    }

    public final void zzi(long j) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i = this.zzd;
            bArr[i] = (byte) (((int) j) & 255);
            bArr[i + 1] = (byte) (((int) (j >> 8)) & 255);
            bArr[i + 2] = (byte) (((int) (j >> 16)) & 255);
            bArr[i + 3] = (byte) (((int) (j >> 24)) & 255);
            bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
            bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
            bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
            this.zzd = i + 8;
            bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e);
        }
    }

    public final void zzj(int i, int i2) throws IOException {
        zzq(i << 3);
        zzk(i2);
    }

    public final void zzk(int i) throws IOException {
        if (i >= 0) {
            zzq(i);
        } else {
            zzs(i);
        }
    }

    public final void zzl(byte[] bArr, int i, int i2) throws IOException {
        zzc(bArr, 0, i2);
    }

    public final void zzm(int i, String str) throws IOException {
        zzq((i << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) throws IOException {
        int i = this.zzd;
        try {
            int zzw = zzby.zzw(str.length() * 3);
            int zzw2 = zzby.zzw(str.length());
            if (zzw2 != zzw) {
                zzq(zzfu.zzc(str));
                byte[] bArr = this.zzb;
                int i2 = this.zzd;
                this.zzd = zzfu.zzb(str, bArr, i2, this.zzc - i2);
                return;
            }
            int i3 = i + zzw2;
            this.zzd = i3;
            int zzb = zzfu.zzb(str, this.zzb, i3, this.zzc - i3);
            this.zzd = i;
            zzq((zzb - i) - zzw2);
            this.zzd = zzb;
        } catch (zzft e) {
            this.zzd = i;
            zzA(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzbw(e2);
        }
    }

    public final void zzo(int i, int i2) throws IOException {
        zzq((i << 3) | i2);
    }

    public final void zzp(int i, int i2) throws IOException {
        zzq(i << 3);
        zzq(i2);
    }

    public final void zzq(int i) throws IOException {
        while ((i & (-128)) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i2 = this.zzd;
                this.zzd = i2 + 1;
                bArr[i2] = (byte) ((i | 128) & 255);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e);
            }
        }
        byte[] bArr2 = this.zzb;
        int i3 = this.zzd;
        this.zzd = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    public final void zzr(int i, long j) throws IOException {
        zzq(i << 3);
        zzs(j);
    }

    public final void zzs(long j) throws IOException {
        if (!zzby.zzB() || this.zzc - this.zzd < 10) {
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i = this.zzd;
                    this.zzd = i + 1;
                    bArr[i] = (byte) ((((int) j) | 128) & 255);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e);
                }
            }
            byte[] bArr2 = this.zzb;
            int i2 = this.zzd;
            this.zzd = i2 + 1;
            bArr2[i2] = (byte) j;
            return;
        }
        while (true) {
            int i3 = (int) j;
            if ((j & (-128)) == 0) {
                byte[] bArr3 = this.zzb;
                int i4 = this.zzd;
                this.zzd = 1 + i4;
                zzfp.zzn(bArr3, i4, (byte) i3);
                return;
            }
            byte[] bArr4 = this.zzb;
            int i5 = this.zzd;
            this.zzd = i5 + 1;
            zzfp.zzn(bArr4, i5, (byte) ((i3 | 128) & 255));
            j >>>= 7;
        }
    }
}
