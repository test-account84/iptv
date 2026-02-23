package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbu {
    private final zzvb zza = null;
    private final zzch zzb;

    private zzbu(zzch zzchVar) {
        this.zzb = zzchVar;
    }

    public static zzbu zza(zzch zzchVar) throws GeneralSecurityException {
        return new zzbu(zzchVar);
    }

    public final zzvb zza() throws GeneralSecurityException {
        zzch zzchVar = this.zzb;
        return (zzchVar instanceof zznf ? ((zznf) zzchVar).zzb() : (zzor) zznu.zza().zza(this.zzb, zzor.class)).zza();
    }
}
