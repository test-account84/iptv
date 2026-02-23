package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcu {
    public static zzch zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzvb zza = zzvb.zza(bArr, zzaio.zza());
            zznu zza2 = zznu.zza();
            zzor zza3 = zzor.zza(zza);
            return !zza2.zzb(zza3) ? new zznf(zza3) : zza2.zza(zza3);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] zza(zzch zzchVar) throws GeneralSecurityException {
        return (zzchVar instanceof zznf ? ((zznf) zzchVar).zzb() : (zzor) zznu.zza().zza(zzchVar, zzor.class)).zza().zzj();
    }
}
