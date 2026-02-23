package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzeg implements zzeo {
    private final zzec zza;
    private final zzff zzb;
    private final boolean zzc;
    private final zzce zzd;

    private zzeg(zzff zzffVar, zzce zzceVar, zzec zzecVar) {
        this.zzb = zzffVar;
        this.zzc = zzceVar.zzf(zzecVar);
        this.zzd = zzceVar;
        this.zza = zzecVar;
    }

    public static zzeg zzc(zzff zzffVar, zzce zzceVar, zzec zzecVar) {
        return new zzeg(zzffVar, zzceVar, zzecVar);
    }

    public final int zza(Object obj) {
        zzff zzffVar = this.zzb;
        int zzb = zzffVar.zzb(zzffVar.zzd(obj));
        return this.zzc ? zzb + this.zzd.zzb(obj).zzc() : zzb;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : hashCode;
    }

    public final Object zze() {
        zzec zzecVar = this.zza;
        return zzecVar instanceof zzcs ? ((zzcs) zzecVar).zzl() : zzecVar.zzE().zzg();
    }

    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzd(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzeq.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzeq.zzp(this.zzd, obj, obj2);
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzbc zzbcVar) throws IOException {
        zzcs zzcsVar = (zzcs) obj;
        if (zzcsVar.zzc == zzfg.zzc()) {
            zzcsVar.zzc = zzfg.zzf();
        }
        throw null;
    }

    public final void zzi(Object obj, zzfx zzfxVar) throws IOException {
        Iterator zzf = this.zzd.zzb(obj).zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzch zzchVar = (zzch) entry.getKey();
            if (zzchVar.zze() != zzfw.zzi || zzchVar.zzg() || zzchVar.zzf()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzfxVar.zzw(zzchVar.zza(), entry instanceof zzdf ? ((zzdf) entry).zza().zzb() : entry.getValue());
        }
        zzff zzffVar = this.zzb;
        zzffVar.zzi(zzffVar.zzd(obj), zzfxVar);
    }

    public final boolean zzj(Object obj, Object obj2) {
        zzff zzffVar = this.zzb;
        if (!zzffVar.zzd(obj).equals(zzffVar.zzd(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    public final boolean zzk(Object obj) {
        return this.zzd.zzb(obj).zzj();
    }
}
