package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzajr {
    private static final zzaio zza = zzaio.zza;
    private zzahp zzb;
    private volatile zzakn zzc;
    private volatile zzahp zzd;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzajr)) {
            return false;
        }
        zzajr zzajrVar = (zzajr) obj;
        zzakn zzaknVar = this.zzc;
        zzakn zzaknVar2 = zzajrVar.zzc;
        return (zzaknVar == null && zzaknVar2 == null) ? zzc().equals(zzajrVar.zzc()) : (zzaknVar == null || zzaknVar2 == null) ? zzaknVar != null ? zzaknVar.equals(zzajrVar.zzb(zzaknVar.zzh())) : zzb(zzaknVar2.zzh()).equals(zzaknVar2) : zzaknVar.equals(zzaknVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzakn zza(zzakn zzaknVar) {
        zzakn zzaknVar2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzaknVar;
        return zzaknVar2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zzb();
        }
        if (this.zzc != null) {
            return this.zzc.zzl();
        }
        return 0;
    }

    public final zzahp zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            try {
                if (this.zzd != null) {
                    return this.zzd;
                }
                this.zzd = this.zzc == null ? zzahp.zza : this.zzc.zzi();
                return this.zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final zzakn zzb(zzakn zzaknVar) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzaknVar;
                        this.zzd = zzahp.zza;
                    } catch (zzaji unused) {
                        this.zzc = zzaknVar;
                        this.zzd = zzahp.zza;
                    }
                }
            }
        }
        return this.zzc;
    }
}
