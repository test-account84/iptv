package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zziz {
    public static final String zza = new zzin().zze();

    @Deprecated
    private static final zzvt zzb = zzvt.zzb();

    @Deprecated
    private static final zzvt zzc = zzvt.zzb();

    static {
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzje.zzc();
        if (zzif.zzb()) {
            return;
        }
        zzin.zza(true);
    }
}
