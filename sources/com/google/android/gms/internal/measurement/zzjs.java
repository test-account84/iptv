package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzjs implements Comparator {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzka zzkaVar = (zzka) obj;
        zzka zzkaVar2 = (zzka) obj2;
        zzjr zzjrVar = new zzjr(zzkaVar);
        zzjr zzjrVar2 = new zzjr(zzkaVar2);
        while (zzjrVar.hasNext() && zzjrVar2.hasNext()) {
            int compareTo = Integer.valueOf(zzjrVar.zza() & 255).compareTo(Integer.valueOf(zzjrVar2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzkaVar.zzd()).compareTo(Integer.valueOf(zzkaVar2.zzd()));
    }
}
