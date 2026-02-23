package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zznl {
    private static final zznl zza = new zznl();
    private final Map zzb = new HashMap();

    public static zznl zza() {
        return zza;
    }

    public final synchronized void zza(zzno zznoVar, Class cls) throws GeneralSecurityException {
        try {
            zzno zznoVar2 = (zzno) this.zzb.get(cls);
            if (zznoVar2 != null && !zznoVar2.equals(zznoVar)) {
                throw new GeneralSecurityException("Different key creator for parameters class already inserted");
            }
            this.zzb.put(cls, zznoVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
