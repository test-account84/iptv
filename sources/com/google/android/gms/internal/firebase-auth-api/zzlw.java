package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzlw implements zzlj {
    private final zzla zza;

    public zzlw(zzla zzlaVar) {
        this.zza = zzlaVar;
    }

    public final byte[] zza() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzb(), zzlt.zzf)) {
            return zzlt.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }

    public final byte[] zza(byte[] bArr, zzll zzllVar) throws GeneralSecurityException {
        byte[] zza = zzxr.zza(zzllVar.zza().zzb(), bArr);
        byte[] zza2 = zzwg.zza(bArr, zzllVar.zzb().zzb());
        byte[] zza3 = zzlt.zza(zzlt.zzb);
        zzla zzlaVar = this.zza;
        return zzlaVar.zza(null, zza, "eae_prk", zza2, "shared_secret", zza3, zzlaVar.zza());
    }
}
