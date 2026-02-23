package com.google.android.gms.internal.firebase-auth-api;

import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzahr implements Comparator {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzahp zzahpVar = (zzahp) obj;
        zzahp zzahpVar2 = (zzahp) obj2;
        zzahv zzahvVar = (zzahv) zzahpVar.iterator();
        zzahv zzahvVar2 = (zzahv) zzahpVar2.iterator();
        while (zzahvVar.hasNext() && zzahvVar2.hasNext()) {
            int compareTo = Integer.valueOf(zzahp.zza(zzahvVar.zza())).compareTo(Integer.valueOf(zzahp.zza(zzahvVar2.zza())));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzahpVar.zzb()).compareTo(Integer.valueOf(zzahpVar2.zzb()));
    }
}
