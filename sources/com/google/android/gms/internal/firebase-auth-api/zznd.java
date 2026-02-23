package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zznd extends zzbt {
    private final zzos zza;

    public zznd(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        zza(zzosVar, zzcsVar);
        this.zza = zzosVar;
    }

    public final zzos zza(zzcs zzcsVar) throws GeneralSecurityException {
        zza(this.zza, zzcsVar);
        return this.zza;
    }

    public final Integer zza() {
        return this.zza.zze();
    }

    private static void zza(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        int i = zzng.zza[zzosVar.zza().ordinal()];
        if (i == 1 || i == 2) {
            zzcs.zza(zzcsVar);
        }
    }
}
