package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbi extends zzaw {
    public zzbi() {
        this.zza.add(zzbl.zza);
        this.zza.add(zzbl.zzv);
        this.zza.add(zzbl.zzS);
        this.zza.add(zzbl.zzT);
        this.zza.add(zzbl.zzU);
        this.zza.add(zzbl.zzaa);
        this.zza.add(zzbl.zzab);
        this.zza.add(zzbl.zzad);
        this.zza.add(zzbl.zzae);
        this.zza.add(zzbl.zzah);
    }

    public final zzap zza(String str, zzg zzgVar, List list) {
        zzbl zzblVar = zzbl.zza;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 0) {
            zzh.zzh(zzbl.zza.name(), 2, list);
            zzap zzb = zzgVar.zzb((zzap) list.get(0));
            zzap zzb2 = zzgVar.zzb((zzap) list.get(1));
            if (!(zzb instanceof zzal) && !(zzb instanceof zzat) && !(zzb2 instanceof zzal) && !(zzb2 instanceof zzat)) {
                return new zzah(Double.valueOf(zzb.zzh().doubleValue() + zzb2.zzh().doubleValue()));
            }
            return new zzat(String.valueOf(zzb.zzi()).concat(String.valueOf(zzb2.zzi())));
        }
        if (ordinal == 21) {
            zzh.zzh(zzbl.zzv.name(), 2, list);
            return new zzah(Double.valueOf(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue() / zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
        }
        if (ordinal == 59) {
            zzh.zzh(zzbl.zzah.name(), 2, list);
            return new zzah(Double.valueOf(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue() + new zzah(Double.valueOf(-zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue())).zzh().doubleValue()));
        }
        if (ordinal == 52 || ordinal == 53) {
            zzh.zzh(str, 2, list);
            zzap zzb3 = zzgVar.zzb((zzap) list.get(0));
            zzgVar.zzb((zzap) list.get(1));
            return zzb3;
        }
        if (ordinal == 55 || ordinal == 56) {
            zzh.zzh(str, 1, list);
            return zzgVar.zzb((zzap) list.get(0));
        }
        switch (ordinal) {
            case 44:
                zzh.zzh(zzbl.zzS.name(), 2, list);
                return new zzah(Double.valueOf(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue() % zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
            case 45:
                zzh.zzh(zzbl.zzT.name(), 2, list);
                return new zzah(Double.valueOf(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue() * zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
            case 46:
                zzh.zzh(zzbl.zzU.name(), 1, list);
                return new zzah(Double.valueOf(-zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue()));
            default:
                return super.zzb(str);
        }
    }
}
