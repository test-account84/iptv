package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbh extends zzaw {
    public zzbh() {
        this.zza.add(zzbl.zzA);
        this.zza.add(zzbl.zzB);
        this.zza.add(zzbl.zzC);
        this.zza.add(zzbl.zzD);
        this.zza.add(zzbl.zzE);
        this.zza.add(zzbl.zzF);
        this.zza.add(zzbl.zzG);
        this.zza.add(zzbl.zzan);
    }

    private static zzap zzc(zzbf zzbfVar, Iterator it, zzap zzapVar) {
        if (it != null) {
            while (it.hasNext()) {
                zzap zzc = zzbfVar.zza((zzap) it.next()).zzc((zzae) zzapVar);
                if (zzc instanceof zzag) {
                    zzag zzagVar = (zzag) zzc;
                    if ("break".equals(zzagVar.zzc())) {
                        return zzap.zzf;
                    }
                    if ("return".equals(zzagVar.zzc())) {
                        return zzagVar;
                    }
                }
            }
        }
        return zzap.zzf;
    }

    private static zzap zzd(zzbf zzbfVar, zzap zzapVar, zzap zzapVar2) {
        return zzc(zzbfVar, zzapVar.zzl(), zzapVar2);
    }

    private static zzap zze(zzbf zzbfVar, zzap zzapVar, zzap zzapVar2) {
        if (zzapVar instanceof Iterable) {
            return zzc(zzbfVar, ((Iterable) zzapVar).iterator(), zzapVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    /* JADX WARN: Removed duplicated region for block: B:83:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.measurement.zzap zza(java.lang.String r12, com.google.android.gms.internal.measurement.zzg r13, java.util.List r14) {
        /*
            Method dump skipped, instructions count: 750
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbh.zza(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }
}
