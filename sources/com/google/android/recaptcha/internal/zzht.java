package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzht {
    public static final int zza(int i, Object obj, Object obj2) {
        zzhs zzhsVar = (zzhs) obj;
        if (zzhsVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzhsVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzhs) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzhs zzhsVar = (zzhs) obj;
        zzhs zzhsVar2 = (zzhs) obj2;
        if (!zzhsVar2.isEmpty()) {
            if (!zzhsVar.zze()) {
                zzhsVar = zzhsVar.zzb();
            }
            zzhsVar.zzd(zzhsVar2);
        }
        return zzhsVar;
    }
}
