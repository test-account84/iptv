package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzel;
import com.google.android.gms.internal.firebase-auth-api.zzes;
import com.google.android.gms.internal.firebase-auth-api.zzvb;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzex {
    private static final zzxt zza;
    private static final zznz zzb;
    private static final zznv zzc;
    private static final zzmx zzd;
    private static final zzmu zze;

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.firebase-auth-api.zzey, com.google.android.gms.internal.firebase-auth-api.zzmz] */
    static {
        zzxt zzb2 = zzpf.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zza = zzb2;
        zzb = zznz.zza(zzew.zza, zzes.class, zzor.class);
        zzc = zznv.zza(zzez.zza, zzb2, zzor.class);
        zzd = zzmx.zza(zzey.zza, zzel.class, zzos.class);
        zze = zzmu.zza(zzfb.zza, zzb2, zzos.class);
    }

    public static /* synthetic */ zzel zza(zzos zzosVar, zzcs zzcsVar) {
        return zzb(zzosVar, zzcsVar);
    }

    private static zzel zzb(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        if (!zzosVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
        try {
            zzsu zza2 = zzsu.zza(zzosVar.zzd(), zzaio.zza());
            if (zza2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return new zzel.zza(null).zza(zzes.zze().zzb(zza2.zzd().zzb()).zza(12).zzc(16).zza(zza(zzosVar.zzc())).zza()).zza(zzxu.zza(zza2.zzd().zzg(), zzcs.zza(zzcsVar))).zza(zzosVar.zze()).zza();
        } catch (zzaji unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }

    private static zzes.zzb zza(zzvs zzvsVar) throws GeneralSecurityException {
        int i = zzfa.zza[zzvsVar.ordinal()];
        if (i == 1) {
            return zzes.zzb.zza;
        }
        if (i == 2 || i == 3) {
            return zzes.zzb.zzb;
        }
        if (i == 4) {
            return zzes.zzb.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvsVar.zza());
    }

    private static zzes zzb(zzor zzorVar) throws GeneralSecurityException {
        if (!zzorVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: " + zzorVar.zza().zzf());
        }
        try {
            zzsv zza2 = zzsv.zza(zzorVar.zza().zze(), zzaio.zza());
            if (zza2.zzb() == 0) {
                return zzes.zze().zzb(zza2.zza()).zza(12).zzc(16).zza(zza(zzorVar.zza().zzd())).zza();
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzaji e) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzes zza(zzor zzorVar) {
        return zzb(zzorVar);
    }

    public static /* synthetic */ zzor zza(zzes zzesVar) {
        zzvs zzvsVar;
        if (zzesVar.zzd() != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports serialization of AES GCM keys with tag size equal to 16 bytes.", new Object[]{Integer.valueOf(zzesVar.zzd())}));
        }
        if (zzesVar.zzb() != 12) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d. Currently Tink only supports serialization of AES GCM keys with IV size equal to 12 bytes.", new Object[]{Integer.valueOf(zzesVar.zzb())}));
        }
        zzvb.zza zza2 = zzvb.zza().zza("type.googleapis.com/google.crypto.tink.AesGcmKey").zza(((zzsv) ((zzajc) zzsv.zzc().zza(zzesVar.zzc()).zzf())).zzi());
        zzes.zzb zzf = zzesVar.zzf();
        if (zzes.zzb.zza.equals(zzf)) {
            zzvsVar = zzvs.TINK;
        } else if (zzes.zzb.zzb.equals(zzf)) {
            zzvsVar = zzvs.CRUNCHY;
        } else {
            if (!zzes.zzb.zzc.equals(zzf)) {
                throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzf));
            }
            zzvsVar = zzvs.RAW;
        }
        return zzor.zzb((zzvb) ((zzajc) zza2.zza(zzvsVar).zzf()));
    }

    public static void zza() throws GeneralSecurityException {
        zznu zza2 = zznu.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
