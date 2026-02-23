package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzph;
import com.google.android.gms.internal.firebase-auth-api.zzpo;
import com.google.android.gms.internal.firebase-auth-api.zzvb;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzpt {
    private static final zzxt zza;
    private static final zznz zzb;
    private static final zznv zzc;
    private static final zzmx zzd;
    private static final zzmu zze;

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.firebase-auth-api.zzmz, com.google.android.gms.internal.firebase-auth-api.zzpu] */
    static {
        zzxt zzb2 = zzpf.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zza = zzb2;
        zzb = zznz.zza(zzps.zza, zzpo.class, zzor.class);
        zzc = zznv.zza(zzpv.zza, zzb2, zzor.class);
        zzd = zzmx.zza(zzpu.zza, zzph.class, zzos.class);
        zze = zzmu.zza(zzpx.zza, zzb2, zzos.class);
    }

    public static /* synthetic */ zzor zza(zzpo zzpoVar) {
        zzvs zzvsVar;
        zzvb.zza zza2 = zzvb.zza().zza("type.googleapis.com/google.crypto.tink.AesCmacKey").zza(((zzsa) ((zzajc) zzsa.zzb().zza((zzsb) ((zzajc) zzsb.zzb().zza(zzpoVar.zzb()).zzf())).zza(zzpoVar.zzc()).zzf())).zzi());
        zzpo.zzb zze2 = zzpoVar.zze();
        if (zzpo.zzb.zza.equals(zze2)) {
            zzvsVar = zzvs.zzb;
        } else if (zzpo.zzb.zzb.equals(zze2)) {
            zzvsVar = zzvs.zze;
        } else if (zzpo.zzb.zzd.equals(zze2)) {
            zzvsVar = zzvs.zzd;
        } else {
            if (!zzpo.zzb.zzc.equals(zze2)) {
                throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zze2));
            }
            zzvsVar = zzvs.zzc;
        }
        return zzor.zzb((zzvb) ((zzajc) zza2.zza(zzvsVar).zzf()));
    }

    private static zzph zzb(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        if (!zzosVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
        try {
            zzrw zza2 = zzrw.zza(zzosVar.zzd(), zzaio.zza());
            if (zza2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return new zzph.zza(null).zza(zzpo.zzd().zza(zza2.zze().zzb()).zzb(zza2.zzd().zza()).zza(zza(zzosVar.zzc())).zza()).zza(zzxu.zza(zza2.zze().zzg(), zzcs.zza(zzcsVar))).zza(zzosVar.zze()).zza();
        } catch (zzaji | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    public static /* synthetic */ zzph zza(zzos zzosVar, zzcs zzcsVar) {
        return zzb(zzosVar, zzcsVar);
    }

    private static zzpo zzb(zzor zzorVar) throws GeneralSecurityException {
        if (zzorVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzsa zza2 = zzsa.zza(zzorVar.zza().zze(), zzaio.zza());
                return zzpo.zzd().zza(zza2.zza()).zzb(zza2.zzd().zza()).zza(zza(zzorVar.zza().zzd())).zza();
            } catch (zzaji e) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: " + zzorVar.zza().zzf());
    }

    private static zzpo.zzb zza(zzvs zzvsVar) throws GeneralSecurityException {
        int i = zzpw.zza[zzvsVar.ordinal()];
        if (i == 1) {
            return zzpo.zzb.zza;
        }
        if (i == 2) {
            return zzpo.zzb.zzb;
        }
        if (i == 3) {
            return zzpo.zzb.zzc;
        }
        if (i == 4) {
            return zzpo.zzb.zzd;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvsVar.zza());
    }

    public static /* synthetic */ zzpo zza(zzor zzorVar) {
        return zzb(zzorVar);
    }

    public static void zza() throws GeneralSecurityException {
        zznu zza2 = zznu.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
