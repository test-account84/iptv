package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbc extends zzaw {
    public zzbc() {
        this.zza.add(zzbl.zzb);
        this.zza.add(zzbl.zzV);
        this.zza.add(zzbl.zzY);
    }

    public final zzap zza(String str, zzg zzgVar, List list) {
        zzbl zzblVar = zzbl.zza;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 1) {
            zzh.zzh(zzbl.zzb.name(), 2, list);
            zzap zzb = zzgVar.zzb((zzap) list.get(0));
            if (!zzb.zzg().booleanValue()) {
                return zzb;
            }
        } else {
            if (ordinal == 47) {
                zzh.zzh(zzbl.zzV.name(), 1, list);
                return new zzaf(Boolean.valueOf(!zzgVar.zzb((zzap) list.get(0)).zzg().booleanValue()));
            }
            if (ordinal != 50) {
                return super.zzb(str);
            }
            zzh.zzh(zzbl.zzY.name(), 2, list);
            zzap zzb2 = zzgVar.zzb((zzap) list.get(0));
            if (zzb2.zzg().booleanValue()) {
                return zzb2;
            }
        }
        return zzgVar.zzb((zzap) list.get(1));
    }
}
