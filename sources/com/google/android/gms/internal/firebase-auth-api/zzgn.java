package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzgn {
    private static final zzxt zza;
    private static final zznz zzb;
    private static final zznv zzc;
    private static final zzmx zzd;
    private static final zzmu zze;

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.firebase-auth-api.zzgo, com.google.android.gms.internal.firebase-auth-api.zzmz] */
    static {
        zzxt zzb2 = zzpf.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zza = zzb2;
        zzb = zznz.zza(zzgm.zza, zzgk.class, zzor.class);
        zzc = zznv.zza(zzgp.zza, zzb2, zzor.class);
        zzd = zzmx.zza(zzgo.zza, zzgl.class, zzos.class);
        zze = zzmu.zza(zzgr.zza, zzb2, zzos.class);
    }

    public static /* synthetic */ zzgk zza(zzor zzorVar) {
        return zzb(zzorVar);
    }

    private static zzgk zzb(zzor zzorVar) throws GeneralSecurityException {
        if (!zzorVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: " + zzorVar.zza().zzf());
        }
        try {
            zzvn zza2 = zzvn.zza(zzorVar.zza().zze(), zzaio.zza());
            if (zzorVar.zza().zzd() == zzvs.RAW) {
                return zzgk.zza(zza2.zzd());
            }
            throw new GeneralSecurityException("Only key templates with RAW are accepted, but got " + String.valueOf(zzorVar.zza().zzd()) + " with format " + String.valueOf(zza2));
        } catch (zzaji e) {
            throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
        }
    }

    public static /* synthetic */ zzgl zza(zzos zzosVar, zzcs zzcsVar) {
        return zzb(zzosVar, zzcsVar);
    }

    private static zzgl zzb(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        if (!zzosVar.zzf().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
        if (zzosVar.zzc() != zzvs.RAW) {
            throw new GeneralSecurityException("KmsAeadKey are only accepted with RAW, got " + String.valueOf(zzosVar.zzc()));
        }
        try {
            zzvk zza2 = zzvk.zza(zzosVar.zzd(), zzaio.zza());
            if (zza2.zza() == 0) {
                return zzgl.zza(zzgk.zza(zza2.zzd().zzd()));
            }
            throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + String.valueOf(zza2));
        } catch (zzaji e) {
            throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
        }
    }

    public static /* synthetic */ zzor zza(zzgk zzgkVar) {
        return zzor.zzb((zzvb) ((zzajc) zzvb.zza().zza("type.googleapis.com/google.crypto.tink.KmsAeadKey").zza(((zzvn) ((zzajc) zzvn.zza().zza(zzgkVar.zzb()).zzf())).zzi()).zza(zzvs.RAW).zzf()));
    }

    public static void zza() throws GeneralSecurityException {
        zznu zza2 = zznu.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
