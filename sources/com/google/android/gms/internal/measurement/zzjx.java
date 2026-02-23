package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class zzjx extends zzjw {
    protected final byte[] zza;

    public zzjx(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzka) || zzd() != ((zzka) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzjx)) {
            return obj.equals(this);
        }
        zzjx zzjxVar = (zzjx) obj;
        int zzk = zzk();
        int zzk2 = zzjxVar.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzjxVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        }
        if (zzd > zzjxVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzjxVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzjxVar.zza;
        zzjxVar.zzc();
        int i = 0;
        int i2 = 0;
        while (i < zzd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    public final int zze(int i, int i2, int i3) {
        return zzlj.zzb(i, this.zza, 0, i3);
    }

    public final zzka zzf(int i, int i2) {
        int zzj = zzka.zzj(0, i2, zzd());
        return zzj == 0 ? zzka.zzb : new zzju(this.zza, 0, zzj);
    }

    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final void zzh(zzjq zzjqVar) throws IOException {
        ((zzkf) zzjqVar).zzc(this.zza, 0, zzd());
    }

    public final boolean zzi() {
        return zznz.zze(this.zza, 0, zzd());
    }
}
