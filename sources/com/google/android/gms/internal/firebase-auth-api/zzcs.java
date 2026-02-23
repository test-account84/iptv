package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcs {
    private static final zzcs zza = new zzcs();

    private zzcs() {
    }

    public static zzcs zza() {
        return zza;
    }

    public static zzcs zza(zzcs zzcsVar) throws GeneralSecurityException {
        if (zzcsVar != null) {
            return zzcsVar;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }
}
