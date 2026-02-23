package com.google.android.gms.internal.cast;

import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzre implements Comparator {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzrm zzrmVar = (zzrm) obj;
        zzrm zzrmVar2 = (zzrm) obj2;
        zzrd zzrdVar = new zzrd(zzrmVar);
        zzrd zzrdVar2 = new zzrd(zzrmVar2);
        while (zzrdVar.hasNext() && zzrdVar2.hasNext()) {
            int compareTo = Integer.valueOf(zzrdVar.zza() & 255).compareTo(Integer.valueOf(zzrdVar2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzrmVar.zzd()).compareTo(Integer.valueOf(zzrmVar2.zzd()));
    }
}
