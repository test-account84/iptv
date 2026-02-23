package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final /* synthetic */ zzt zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzt zztVar, boolean z, boolean z2) {
        super("log");
        this.zzc = zztVar;
        this.zza = z;
        this.zzb = z2;
    }

    public final zzap zza(zzg zzgVar, List list) {
        List arrayList;
        zzr zzb;
        zzh.zzi("log", 1, list);
        if (list.size() == 1) {
            zzt.zzb(this.zzc).zza(3, zzgVar.zzb((zzap) list.get(0)).zzi(), Collections.emptyList(), this.zza, this.zzb);
        } else {
            int zzb2 = zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
            int i = zzb2 != 2 ? zzb2 != 3 ? zzb2 != 5 ? zzb2 != 6 ? 3 : 2 : 5 : 1 : 4;
            String zzi = zzgVar.zzb((zzap) list.get(1)).zzi();
            if (list.size() == 2) {
                zzb = zzt.zzb(this.zzc);
                arrayList = Collections.emptyList();
            } else {
                arrayList = new ArrayList();
                for (int i2 = 2; i2 < Math.min(list.size(), 5); i2++) {
                    arrayList.add(zzgVar.zzb((zzap) list.get(i2)).zzi());
                }
                zzb = zzt.zzb(this.zzc);
            }
            zzb.zza(i, zzi, arrayList, this.zza, this.zzb);
        }
        return zzap.zzf;
    }
}
