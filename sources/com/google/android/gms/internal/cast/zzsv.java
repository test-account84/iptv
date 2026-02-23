package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzsv {
    private static final zzrw zzb = zzrw.zza;
    protected volatile zztp zza;
    private volatile zzrm zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzsv)) {
            return false;
        }
        zzsv zzsvVar = (zzsv) obj;
        zztp zztpVar = this.zza;
        zztp zztpVar2 = zzsvVar.zza;
        if (zztpVar == null && zztpVar2 == null) {
            return zzb().equals(zzsvVar.zzb());
        }
        if (zztpVar != null && zztpVar2 != null) {
            return zztpVar.equals(zztpVar2);
        }
        if (zztpVar != null) {
            zzsvVar.zzc(zztpVar.zzs());
            return zztpVar.equals(zzsvVar.zza);
        }
        zzc(zztpVar2.zzs());
        return this.zza.equals(zztpVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzrj) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzt();
        }
        return 0;
    }

    public final zzrm zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            try {
                if (this.zzc != null) {
                    return this.zzc;
                }
                this.zzc = this.zza == null ? zzrm.zzb : this.zza.zzq();
                return this.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc(zztp zztpVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zztpVar;
                    this.zzc = zzrm.zzb;
                } catch (zzss unused) {
                    this.zza = zztpVar;
                    this.zzc = zzrm.zzb;
                }
            }
        }
    }
}
