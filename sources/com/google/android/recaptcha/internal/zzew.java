package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class zzew extends zzev {
    protected final byte[] zza;

    public zzew(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzez) || zzd() != ((zzez) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzew)) {
            return obj.equals(this);
        }
        zzew zzewVar = (zzew) obj;
        int zzl = zzl();
        int zzl2 = zzewVar.zzl();
        if (zzl != 0 && zzl2 != 0 && zzl != zzl2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzewVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        }
        if (zzd > zzewVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzewVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzewVar.zza;
        zzewVar.zzc();
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

    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    public final int zzf(int i, int i2, int i3) {
        return zzgw.zzb(i, this.zza, 0, i3);
    }

    public final zzez zzg(int i, int i2) {
        int zzk = zzez.zzk(0, i2, zzd());
        return zzk == 0 ? zzez.zzb : new zzet(this.zza, 0, zzk);
    }

    public final String zzh(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final void zzi(zzep zzepVar) throws IOException {
        ((zzfh) zzepVar).zzc(this.zza, 0, zzd());
    }

    public final boolean zzj() {
        return zzju.zzf(this.zza, 0, zzd());
    }
}
