package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaz extends zzaw {
    public zzaz() {
        this.zza.add(zzbl.zzc);
        this.zza.add(zzbl.zzl);
        this.zza.add(zzbl.zzm);
        this.zza.add(zzbl.zzn);
        this.zza.add(zzbl.zzt);
        this.zza.add(zzbl.zzp);
        this.zza.add(zzbl.zzu);
        this.zza.add(zzbl.zzz);
        this.zza.add(zzbl.zzP);
        this.zza.add(zzbl.zzac);
        this.zza.add(zzbl.zzaf);
        this.zza.add(zzbl.zzai);
        this.zza.add(zzbl.zzaj);
    }

    private static zzap zzc(zzg zzgVar, List list) {
        zzh.zzi(zzbl.zzz.name(), 2, list);
        zzap zzb = zzgVar.zzb((zzap) list.get(0));
        zzap zzb2 = zzgVar.zzb((zzap) list.get(1));
        if (!(zzb2 instanceof zzae)) {
            throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", new Object[]{zzb2.getClass().getCanonicalName()}));
        }
        List zzm = ((zzae) zzb2).zzm();
        List arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new zzao(zzb.zzi(), zzm, arrayList, zzgVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0123, code lost:
    
        if (r8.equals("continue") == false) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.measurement.zzap zza(java.lang.String r8, com.google.android.gms.internal.measurement.zzg r9, java.util.List r10) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaz.zza(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }
}
