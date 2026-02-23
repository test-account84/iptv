package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzfc;
import com.google.android.gms.internal.firebase-auth-api.zzfj;
import com.google.android.gms.internal.firebase-auth-api.zzvb;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzfl {
    private static final zzxt zza;
    private static final zznz zzb;
    private static final zznv zzc;
    private static final zzmx zzd;
    private static final zzmu zze;

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.firebase-auth-api.zzfq, com.google.android.gms.internal.firebase-auth-api.zzmz] */
    static {
        zzxt zzb2 = zzpf.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zza = zzb2;
        zzb = zznz.zza(zzfo.zza, zzfj.class, zzor.class);
        zzc = zznv.zza(zzfn.zza, zzb2, zzor.class);
        zzd = zzmx.zza(zzfq.zza, zzfc.class, zzos.class);
        zze = zzmu.zza(zzfp.zza, zzb2, zzos.class);
    }

    public static /* synthetic */ zzfc zza(zzos zzosVar, zzcs zzcsVar) {
        return zzb(zzosVar, zzcsVar);
    }

    private static zzfc zzb(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        if (!zzosVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
        try {
            zzsy zza2 = zzsy.zza(zzosVar.zzd(), zzaio.zza());
            if (zza2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return new zzfc.zza(null).zza(zzfj.zzc().zza(zza2.zzd().zzb()).zza(zza(zzosVar.zzc())).zza()).zza(zzxu.zza(zza2.zzd().zzg(), zzcs.zza(zzcsVar))).zza(zzosVar.zze()).zza();
        } catch (zzaji unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }

    private static zzfj.zzb zza(zzvs zzvsVar) throws GeneralSecurityException {
        int i = zzfs.zza[zzvsVar.ordinal()];
        if (i == 1) {
            return zzfj.zzb.zza;
        }
        if (i == 2 || i == 3) {
            return zzfj.zzb.zzb;
        }
        if (i == 4) {
            return zzfj.zzb.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvsVar.zza());
    }

    private static zzfj zzb(zzor zzorVar) throws GeneralSecurityException {
        if (!zzorVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: " + zzorVar.zza().zzf());
        }
        try {
            zzsz zza2 = zzsz.zza(zzorVar.zza().zze(), zzaio.zza());
            if (zza2.zzb() == 0) {
                return zzfj.zzc().zza(zza2.zza()).zza(zza(zzorVar.zza().zzd())).zza();
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzaji e) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzfj zza(zzor zzorVar) {
        return zzb(zzorVar);
    }

    public static /* synthetic */ zzor zza(zzfj zzfjVar) {
        zzvs zzvsVar;
        zzvb.zza zza2 = zzvb.zza().zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey").zza(((zzsz) ((zzajc) zzsz.zzc().zza(zzfjVar.zzb()).zzf())).zzi());
        zzfj.zzb zzd2 = zzfjVar.zzd();
        if (zzfj.zzb.zza.equals(zzd2)) {
            zzvsVar = zzvs.TINK;
        } else if (zzfj.zzb.zzb.equals(zzd2)) {
            zzvsVar = zzvs.CRUNCHY;
        } else {
            if (!zzfj.zzb.zzc.equals(zzd2)) {
                throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzd2));
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
