package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class zzrj extends zzri {
    protected final byte[] zza;

    public zzrj(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrm) || zzd() != ((zzrm) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzrj)) {
            return obj.equals(this);
        }
        zzrj zzrjVar = (zzrj) obj;
        int zzk = zzk();
        int zzk2 = zzrjVar.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzrjVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        }
        if (zzd > zzrjVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzrjVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzrjVar.zza;
        zzrjVar.zzc();
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
        return zzsq.zzb(i, this.zza, 0, i3);
    }

    public final zzrm zzf(int i, int i2) {
        zzrm.zzj(0, i2, zzd());
        return i2 == 0 ? zzrm.zzb : new zzrg(this.zza, 0, i2);
    }

    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final void zzh(zzrc zzrcVar) throws IOException {
        ((zzrr) zzrcVar).zzc(this.zza, 0, zzd());
    }

    public final boolean zzi() {
        return zzvf.zze(this.zza, 0, zzd());
    }
}
