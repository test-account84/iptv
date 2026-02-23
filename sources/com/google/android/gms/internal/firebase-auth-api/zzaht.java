package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaht extends zzahz {
    private final int zzc;
    private final int zzd;

    public zzaht(byte[] bArr, int i, int i2) {
        super(bArr);
        zzahp.zza(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    public final byte zza(int i) {
        int zzb = zzb();
        if (((zzb - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + zzb);
    }

    public final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    public final int zzh() {
        return this.zzc;
    }

    public final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, zzh(), bArr, 0, i3);
    }

    public final int zzb() {
        return this.zzd;
    }
}
