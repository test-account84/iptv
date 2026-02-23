package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcf {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzcc zza(String str) throws GeneralSecurityException {
        Iterator it = zza.iterator();
        while (it.hasNext()) {
            zzcc zzccVar = (zzcc) it.next();
            if (zzccVar.zzb(str)) {
                return zzccVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }
}
