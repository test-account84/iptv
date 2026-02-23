package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzgs;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzgu {
    private static final zzxt zza;
    private static final zznz zzb;
    private static final zznv zzc;
    private static final zzmx zzd;
    private static final zzmu zze;

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.firebase-auth-api.zzgz, com.google.android.gms.internal.firebase-auth-api.zzmz] */
    static {
        zzxt zzb2 = zzpf.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zza = zzb2;
        zzb = zznz.zza(zzgx.zza, zzgs.class, zzor.class);
        zzc = zznv.zza(zzgw.zza, zzb2, zzor.class);
        zzd = zzmx.zza(zzgz.zza, zzgq.class, zzos.class);
        zze = zzmu.zza(zzgy.zza, zzb2, zzos.class);
    }

    public static /* synthetic */ zzgq zza(zzos zzosVar, zzcs zzcsVar) {
        return zzb(zzosVar, zzcsVar);
    }

    private static zzgq zzb(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        if (!zzosVar.zzf().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            zzvo zza2 = zzvo.zza(zzosVar.zzd(), zzaio.zza());
            if (zzosVar.zzc() != zzvs.RAW) {
                throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with OutputPrefixType RAW, got " + String.valueOf(zza2));
            }
            if (zza2.zza() == 0) {
                return zzgq.zza(zza(zza2.zzd()));
            }
            throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + String.valueOf(zza2));
        } catch (zzaji e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
        }
    }

    public static /* synthetic */ zzgs zza(zzor zzorVar) {
        return zzb(zzorVar);
    }

    private static zzgs zzb(zzor zzorVar) throws GeneralSecurityException {
        if (zzorVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                return zza(zzvr.zza(zzorVar.zza().zze(), zzaio.zza()));
            } catch (zzaji e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: " + zzorVar.zza().zzf());
    }

    private static zzgs zza(zzvr zzvrVar) throws GeneralSecurityException {
        zzgs.zzb zzbVar;
        zzch zza2 = zzcu.zza(((zzvb) ((zzajc) zzvb.zza().zza(zzvrVar.zza().zzf()).zza(zzvrVar.zza().zze()).zza(zzvs.RAW).zzf())).zzj());
        if (zza2 instanceof zzes) {
            zzbVar = zzgs.zzb.zza;
        } else if (zza2 instanceof zzfv) {
            zzbVar = zzgs.zzb.zzc;
        } else if (zza2 instanceof zzhm) {
            zzbVar = zzgs.zzb.zzb;
        } else if (zza2 instanceof zzdl) {
            zzbVar = zzgs.zzb.zzd;
        } else if (zza2 instanceof zzed) {
            zzbVar = zzgs.zzb.zze;
        } else {
            if (!(zza2 instanceof zzfj)) {
                throw new GeneralSecurityException("Unsupported DEK parameters when parsing " + String.valueOf(zza2));
            }
            zzbVar = zzgs.zzb.zzf;
        }
        return new zzgs.zza(null).zza(zzvrVar.zze()).zza((zzdb) zza2).zza(zzbVar).zza();
    }

    private static zzvr zzb(zzgs zzgsVar) throws GeneralSecurityException {
        try {
            return (zzvr) ((zzajc) zzvr.zzb().zza(zzgsVar.zzc()).zza(zzvb.zza(zzcu.zza(zzgsVar.zzb()), zzaio.zza())).zzf());
        } catch (zzaji e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    public static /* synthetic */ zzor zza(zzgs zzgsVar) {
        return zzor.zzb((zzvb) ((zzajc) zzvb.zza().zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey").zza(zzb(zzgsVar).zzi()).zza(zzvs.RAW).zzf()));
    }

    public static void zza() throws GeneralSecurityException {
        zznu zza2 = zznu.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
