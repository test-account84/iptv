package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzakj implements zzakg {
    public final int zza(int i, Object obj, Object obj2) {
        zzakh zzakhVar = (zzakh) obj;
        if (zzakhVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzakhVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    public final Object zzb(Object obj) {
        return zzakh.zza().zzb();
    }

    public final Object zzc(Object obj) {
        ((zzakh) obj).zzc();
        return obj;
    }

    public final Map zzd(Object obj) {
        return (zzakh) obj;
    }

    public final Map zze(Object obj) {
        return (zzakh) obj;
    }

    public final boolean zzf(Object obj) {
        return !((zzakh) obj).zzd();
    }

    public final zzake zza(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Object zza(Object obj, Object obj2) {
        zzakh zzakhVar = (zzakh) obj;
        zzakh zzakhVar2 = (zzakh) obj2;
        if (!zzakhVar2.isEmpty()) {
            if (!zzakhVar.zzd()) {
                zzakhVar = zzakhVar.zzb();
            }
            zzakhVar.zza(zzakhVar2);
        }
        return zzakhVar;
    }
}
