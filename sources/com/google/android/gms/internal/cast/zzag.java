package com.google.android.gms.internal.cast;

import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzag {
    public static Map zza(Bundle bundle, String str) {
        Map serializable = bundle.getSerializable(str);
        if (serializable == null) {
            return zzfk.zzd();
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : serializable.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                hashMap.put((Integer) entry.getKey(), (Integer) entry.getValue());
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
