package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzka;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzkf extends zzkv {
    private final zzkn zza;
    private final zzxu zzb;

    private zzkf(zzkn zzknVar, zzxu zzxuVar) {
        this.zza = zzknVar;
        this.zzb = zzxuVar;
    }

    public static zzkf zza(zzkn zzknVar, zzxu zzxuVar) throws GeneralSecurityException {
        ECParameterSpec eCParameterSpec;
        if (zzknVar == null) {
            throw new GeneralSecurityException("HPKE private key cannot be constructed without an HPKE public key");
        }
        if (zzxuVar == null) {
            throw new GeneralSecurityException("HPKE private key cannot be constructed without secret");
        }
        zzka.zzd zze = zzknVar.zza().zze();
        int zza = zzxuVar.zza();
        String str = "Encoded private key byte length for " + String.valueOf(zze) + " must be %d, not " + zza;
        zzka.zzd zzdVar = zzka.zzd.zza;
        if (zze == zzdVar) {
            if (zza != 32) {
                throw new GeneralSecurityException(String.format(str, new Object[]{32}));
            }
        } else if (zze == zzka.zzd.zzb) {
            if (zza != 48) {
                throw new GeneralSecurityException(String.format(str, new Object[]{48}));
            }
        } else if (zze == zzka.zzd.zzc) {
            if (zza != 66) {
                throw new GeneralSecurityException(String.format(str, new Object[]{66}));
            }
        } else {
            if (zze != zzka.zzd.zzd) {
                throw new GeneralSecurityException("Unable to validate private key length for " + String.valueOf(zze));
            }
            if (zza != 32) {
                throw new GeneralSecurityException(String.format(str, new Object[]{32}));
            }
        }
        zzka.zzd zze2 = zzknVar.zza().zze();
        byte[] zzb = zzknVar.zzb().zzb();
        byte[] zza2 = zzxuVar.zza(zzbq.zza());
        if (zze2 == zzdVar || zze2 == zzka.zzd.zzb || zze2 == zzka.zzd.zzc) {
            if (zze2 == zzdVar) {
                eCParameterSpec = zzmg.zza;
            } else if (zze2 == zzka.zzd.zzb) {
                eCParameterSpec = zzmg.zzb;
            } else {
                if (zze2 != zzka.zzd.zzc) {
                    throw new IllegalArgumentException("Unable to determine NIST curve params for " + String.valueOf(zze2));
                }
                eCParameterSpec = zzmg.zzc;
            }
            BigInteger order = eCParameterSpec.getOrder();
            BigInteger zza3 = zzme.zza(zza2);
            if (zza3.signum() <= 0 || zza3.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private key.");
            }
            if (!zzmg.zza(zza3, eCParameterSpec).equals(zzwp.zza(eCParameterSpec.getCurve(), zzwr.UNCOMPRESSED, zzb))) {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        } else {
            if (zze2 != zzka.zzd.zzd) {
                throw new IllegalArgumentException("Unable to validate key pair for " + String.valueOf(zze2));
            }
            if (!Arrays.equals(zzxr.zza(zza2), zzb)) {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        }
        return new zzkf(zzknVar, zzxuVar);
    }
}
