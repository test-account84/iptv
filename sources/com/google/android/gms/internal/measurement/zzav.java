package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzav extends zzaw {
    public zzav() {
        this.zza.add(zzbl.zze);
        this.zza.add(zzbl.zzf);
        this.zza.add(zzbl.zzg);
        this.zza.add(zzbl.zzh);
        this.zza.add(zzbl.zzi);
        this.zza.add(zzbl.zzj);
        this.zza.add(zzbl.zzk);
    }

    public final zzap zza(String str, zzg zzgVar, List list) {
        zzbl zzblVar = zzbl.zza;
        switch (zzh.zze(str).ordinal()) {
            case 4:
                zzh.zzh(zzbl.zze.name(), 2, list);
                return new zzah(Double.valueOf(zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue()) & zzh.zzb(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue())));
            case 5:
                zzh.zzh(zzbl.zzf.name(), 2, list);
                return new zzah(Double.valueOf(zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue()) << ((int) (zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()) & 31))));
            case 6:
                zzh.zzh(zzbl.zzg.name(), 1, list);
                return new zzah(Double.valueOf(~zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue())));
            case 7:
                zzh.zzh(zzbl.zzh.name(), 2, list);
                return new zzah(Double.valueOf(zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue()) | zzh.zzb(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue())));
            case 8:
                zzh.zzh(zzbl.zzi.name(), 2, list);
                return new zzah(Double.valueOf(zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue()) >> ((int) (zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()) & 31))));
            case 9:
                zzh.zzh(zzbl.zzj.name(), 2, list);
                return new zzah(Double.valueOf(zzh.zzd(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue()) >>> ((int) (zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()) & 31))));
            case 10:
                zzh.zzh(zzbl.zzk.name(), 2, list);
                return new zzah(Double.valueOf(zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue()) ^ zzh.zzb(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue())));
            default:
                return super.zzb(str);
        }
    }
}
