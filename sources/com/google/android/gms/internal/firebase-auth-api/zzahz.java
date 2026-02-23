package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class zzahz extends zzahw {
    protected final byte[] zzb;

    public zzahz(byte[] bArr) {
        bArr.getClass();
        this.zzb = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzahp) || zzb() != ((zzahp) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (!(obj instanceof zzahz)) {
            return obj.equals(this);
        }
        zzahz zzahzVar = (zzahz) obj;
        int zza = zza();
        int zza2 = zzahzVar.zza();
        if (zza == 0 || zza2 == 0 || zza == zza2) {
            return zza(zzahzVar, 0, zzb());
        }
        return false;
    }

    public byte zza(int i) {
        return this.zzb[i];
    }

    public byte zzb(int i) {
        return this.zzb[i];
    }

    public final zzaia zzc() {
        return zzaia.zza(this.zzb, zzh(), zzb(), true);
    }

    public final boolean zzf() {
        int zzh = zzh();
        return zzaml.zzc(this.zzb, zzh, zzb() + zzh);
    }

    public int zzh() {
        return 0;
    }

    public final zzahp zza(int i, int i2) {
        int zza = zzahp.zza(0, i2, zzb());
        return zza == 0 ? zzahp.zza : new zzaht(this.zzb, zzh(), zza);
    }

    public int zzb() {
        return this.zzb.length;
    }

    public final String zza(Charset charset) {
        return new String(this.zzb, zzh(), zzb(), charset);
    }

    public final int zzb(int i, int i2, int i3) {
        return zzajf.zza(i, this.zzb, zzh(), i3);
    }

    public final void zza(zzahm zzahmVar) throws IOException {
        zzahmVar.zza(this.zzb, zzh(), zzb());
    }

    public void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, 0, bArr, 0, i3);
    }

    public final boolean zza(zzahp zzahpVar, int i, int i2) {
        if (i2 > zzahpVar.zzb()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzb());
        }
        if (i2 > zzahpVar.zzb()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzahpVar.zzb());
        }
        if (!(zzahpVar instanceof zzahz)) {
            return zzahpVar.zza(0, i2).equals(zza(0, i2));
        }
        zzahz zzahzVar = (zzahz) zzahpVar;
        byte[] bArr = this.zzb;
        byte[] bArr2 = zzahzVar.zzb;
        int zzh = zzh() + i2;
        int zzh2 = zzh();
        int zzh3 = zzahzVar.zzh();
        while (zzh2 < zzh) {
            if (bArr[zzh2] != bArr2[zzh3]) {
                return false;
            }
            zzh2++;
            zzh3++;
        }
        return true;
    }
}
