package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzns {
    private static final zzns zza = new zzns();
    private final Map zzb = new HashMap();

    public static zzns zza() {
        return zza;
    }

    private final synchronized void zza(String str, zzch zzchVar) throws GeneralSecurityException {
        try {
            if (!this.zzb.containsKey(str)) {
                this.zzb.put(str, zzchVar);
                return;
            }
            if (((zzch) this.zzb.get(str)).equals(zzchVar)) {
                return;
            }
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + String.valueOf(this.zzb.get(str)) + "), cannot insert " + String.valueOf(zzchVar));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zza(Map map) throws GeneralSecurityException {
        for (Map.Entry entry : map.entrySet()) {
            zza((String) entry.getKey(), (zzch) entry.getValue());
        }
    }
}
