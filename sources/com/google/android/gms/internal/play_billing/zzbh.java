package com.google.android.gms.internal.play_billing;

import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzbh implements Comparator {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzbq zzbqVar = (zzbq) obj;
        zzbq zzbqVar2 = (zzbq) obj2;
        zzbg zzbgVar = new zzbg(zzbqVar);
        zzbg zzbgVar2 = new zzbg(zzbqVar2);
        while (zzbgVar.hasNext() && zzbgVar2.hasNext()) {
            int compareTo = Integer.valueOf(zzbgVar.zza() & 255).compareTo(Integer.valueOf(zzbgVar2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzbqVar.zzd()).compareTo(Integer.valueOf(zzbqVar2.zzd()));
    }
}
