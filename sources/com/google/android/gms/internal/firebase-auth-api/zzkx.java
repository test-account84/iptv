package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzkx {
    public static zzwo zza(zzty zztyVar) throws GeneralSecurityException {
        int i = zzkw.zzb[zztyVar.ordinal()];
        if (i == 1) {
            return zzwo.NIST_P256;
        }
        if (i == 2) {
            return zzwo.NIST_P384;
        }
        if (i == 3) {
            return zzwo.NIST_P521;
        }
        throw new GeneralSecurityException("unknown curve type: " + String.valueOf(zztyVar));
    }

    public static zzwr zza(zztk zztkVar) throws GeneralSecurityException {
        int i = zzkw.zzc[zztkVar.ordinal()];
        if (i == 1) {
            return zzwr.UNCOMPRESSED;
        }
        if (i == 2) {
            return zzwr.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return zzwr.COMPRESSED;
        }
        throw new GeneralSecurityException("unknown point format: " + String.valueOf(zztkVar));
    }

    public static String zza(zzub zzubVar) throws NoSuchAlgorithmException {
        int i = zzkw.zza[zzubVar.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha224";
        }
        if (i == 3) {
            return "HmacSha256";
        }
        if (i == 4) {
            return "HmacSha384";
        }
        if (i == 5) {
            return "HmacSha512";
        }
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: " + String.valueOf(zzubVar));
    }

    public static void zza(zztq zztqVar) throws GeneralSecurityException {
        zzwp.zza(zza(zztqVar.zzf().zzd()));
        zza(zztqVar.zzf().zze());
        if (zztqVar.zza() == zztk.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzct.zza(zztqVar.zzb().zzd());
    }
}
