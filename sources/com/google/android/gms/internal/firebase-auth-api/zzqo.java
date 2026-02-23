package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzqo {
    private static final String zza = new zzqg().zze();

    @Deprecated
    private static final zzvt zzb;

    @Deprecated
    private static final zzvt zzc;

    @Deprecated
    private static final zzvt zzd;

    static {
        zzvt zzb2 = zzvt.zzb();
        zzb = zzb2;
        zzc = zzb2;
        zzd = zzb2;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzqt.zzc();
        zzpy.zzc();
        zzqg.zza(true);
        if (zzif.zzb()) {
            return;
        }
        zzpl.zza(true);
    }
}
