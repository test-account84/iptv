package com.google.android.gms.internal.cast;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzrr extends zzru {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    public zzrr(byte[] bArr, int i, int i2) {
        super(null);
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i2)}));
        }
        this.zzc = bArr;
        this.zze = 0;
        this.zzd = i2;
    }

    public final int zza() {
        return this.zzd - this.zze;
    }

    public final void zzb(byte b) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i = this.zze;
            this.zze = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzrs(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
        }
    }

    public final void zzc(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i2);
            this.zze += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzrs(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i2)}), e);
        }
    }

    public final void zzd(int i, boolean z) throws IOException {
        zzq(i << 3);
        zzb(z ? (byte) 1 : (byte) 0);
    }

    public final void zze(int i, zzrm zzrmVar) throws IOException {
        zzq((i << 3) | 2);
        zzq(zzrmVar.zzd());
        zzrmVar.zzh(this);
    }

    public final void zzf(int i, int i2) throws IOException {
        zzq((i << 3) | 5);
        zzg(i2);
    }

    public final void zzg(int i) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i2 = this.zze;
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            this.zze = i2 + 4;
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzrs(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
        }
    }

    public final void zzh(int i, long j) throws IOException {
        zzq((i << 3) | 1);
        zzi(j);
    }

    public final void zzi(long j) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i = this.zze;
            bArr[i] = (byte) (((int) j) & 255);
            bArr[i + 1] = (byte) (((int) (j >> 8)) & 255);
            bArr[i + 2] = (byte) (((int) (j >> 16)) & 255);
            bArr[i + 3] = (byte) (((int) (j >> 24)) & 255);
            bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
            bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
            bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
            this.zze = i + 8;
            bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzrs(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
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
        int i = this.zze;
        try {
            int zzx = zzru.zzx(str.length() * 3);
            int zzx2 = zzru.zzx(str.length());
            if (zzx2 != zzx) {
                zzq(zzvf.zzc(str));
                byte[] bArr = this.zzc;
                int i2 = this.zze;
                this.zze = zzvf.zzb(str, bArr, i2, this.zzd - i2);
                return;
            }
            int i3 = i + zzx2;
            this.zze = i3;
            int zzb = zzvf.zzb(str, this.zzc, i3, this.zzd - i3);
            this.zze = i;
            zzq((zzb - i) - zzx2);
            this.zze = zzb;
        } catch (IndexOutOfBoundsException e) {
            throw new zzrs(e);
        } catch (zzve e2) {
            this.zze = i;
            zzB(str, e2);
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
                byte[] bArr = this.zzc;
                int i2 = this.zze;
                this.zze = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzrs(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }
        byte[] bArr2 = this.zzc;
        int i3 = this.zze;
        this.zze = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    public final void zzr(int i, long j) throws IOException {
        zzq(i << 3);
        zzs(j);
    }

    public final void zzs(long j) throws IOException {
        if (zzru.zzC() && this.zzd - this.zze >= 10) {
            while ((j & (-128)) != 0) {
                byte[] bArr = this.zzc;
                int i = this.zze;
                this.zze = i + 1;
                zzvb.zzn(bArr, i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr2 = this.zzc;
            int i2 = this.zze;
            this.zze = 1 + i2;
            zzvb.zzn(bArr2, i2, (byte) j);
            return;
        }
        while ((j & (-128)) != 0) {
            try {
                byte[] bArr3 = this.zzc;
                int i3 = this.zze;
                this.zze = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzrs(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }
        byte[] bArr4 = this.zzc;
        int i4 = this.zze;
        this.zze = i4 + 1;
        bArr4[i4] = (byte) j;
    }
}
