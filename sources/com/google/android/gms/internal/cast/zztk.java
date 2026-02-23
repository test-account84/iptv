package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zztk {
    public static final int zza(int i, Object obj, Object obj2) {
        zztj zztjVar = (zztj) obj;
        if (zztjVar.isEmpty()) {
            return 0;
        }
        Iterator it = zztjVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }
}
