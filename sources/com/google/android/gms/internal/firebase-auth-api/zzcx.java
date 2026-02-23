package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzuy;
import com.google.android.gms.internal.firebase-auth-api.zzvg;
import com.google.android.gms.internal.firebase-auth-api.zzvj;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzcx {
    private static final Charset zza = Charset.forName("UTF-8");

    public static zzvj zza(zzvg zzvgVar) {
        zzvj.zzb zza2 = zzvj.zza().zza(zzvgVar.zzb());
        for (zzvg.zzb zzbVar : zzvgVar.zze()) {
            zza2.zza((zzvj.zza) ((zzajc) zzvj.zza.zzb().zza(zzbVar.zzb().zzf()).zza(zzbVar.zzc()).zza(zzbVar.zzf()).zza(zzbVar.zza()).zzf()));
        }
        return (zzvj) ((zzajc) zza2.zzf());
    }

    public static void zzb(zzvg zzvgVar) throws GeneralSecurityException {
        int zzb = zzvgVar.zzb();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzvg.zzb zzbVar : zzvgVar.zze()) {
            if (zzbVar.zzc() == zzuz.ENABLED) {
                if (!zzbVar.zzg()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(zzbVar.zza())}));
                }
                if (zzbVar.zzf() == zzvs.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(zzbVar.zza())}));
                }
                if (zzbVar.zzc() == zzuz.UNKNOWN_STATUS) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(zzbVar.zza())}));
                }
                if (zzbVar.zza() == zzb) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                if (zzbVar.zzb().zzb() != zzuy.zza.ASYMMETRIC_PUBLIC) {
                    z2 = false;
                }
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
