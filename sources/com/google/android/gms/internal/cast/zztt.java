package com.google.android.gms.internal.cast;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zztt implements zzua {
    private final zztp zza;
    private final zzur zzb;
    private final boolean zzc;
    private final zzrx zzd;

    private zztt(zzur zzurVar, zzrx zzrxVar, zztp zztpVar) {
        this.zzb = zzurVar;
        this.zzc = zzrxVar.zzc(zztpVar);
        this.zzd = zzrxVar;
        this.zza = zztpVar;
    }

    public static zztt zzi(zzur zzurVar, zzrx zzrxVar, zztp zztpVar) {
        return new zztt(zzurVar, zzrxVar, zztpVar);
    }

    public final int zza(Object obj) {
        zzur zzurVar = this.zzb;
        int zzb = zzurVar.zzb(zzurVar.zzc(obj));
        if (!this.zzc) {
            return zzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzc(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zzc() {
        zztp zztpVar = this.zza;
        return zztpVar instanceof zzsh ? ((zzsh) zztpVar).zzw() : zztpVar.zzB().zzr();
    }

    public final void zzd(Object obj) {
        this.zzb.zze(obj);
        this.zzd.zzb(obj);
    }

    public final void zze(Object obj, Object obj2) {
        zzuc.zzB(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    public final void zzf(Object obj, zzvi zzviVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    public final boolean zzg(Object obj, Object obj2) {
        if (!this.zzb.zzc(obj).equals(this.zzb.zzc(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzh(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
