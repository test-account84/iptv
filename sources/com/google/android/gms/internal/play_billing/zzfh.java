package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzfh extends zzff {
    public final /* synthetic */ int zza(Object obj) {
        return ((zzfg) obj).zza();
    }

    public final /* synthetic */ int zzb(Object obj) {
        return ((zzfg) obj).zzb();
    }

    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzcs zzcsVar = (zzcs) obj;
        zzfg zzfgVar = zzcsVar.zzc;
        if (zzfgVar != zzfg.zzc()) {
            return zzfgVar;
        }
        zzfg zzf = zzfg.zzf();
        zzcsVar.zzc = zzf;
        return zzf;
    }

    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzcs) obj).zzc;
    }

    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzfg.zzc().equals(obj2)) {
            return obj;
        }
        zzfg zzfgVar = (zzfg) obj2;
        if (zzfg.zzc().equals(obj)) {
            return zzfg.zze((zzfg) obj, zzfgVar);
        }
        ((zzfg) obj).zzd(zzfgVar);
        return obj;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, long j) {
        ((zzfg) obj).zzj(i << 3, Long.valueOf(j));
    }

    public final void zzg(Object obj) {
        ((zzcs) obj).zzc.zzh();
    }

    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzcs) obj).zzc = (zzfg) obj2;
    }

    public final /* synthetic */ void zzi(Object obj, zzfx zzfxVar) throws IOException {
        ((zzfg) obj).zzk(zzfxVar);
    }

    public final /* synthetic */ void zzj(Object obj, zzfx zzfxVar) throws IOException {
        ((zzfg) obj).zzl(zzfxVar);
    }
}
