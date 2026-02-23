package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzhm;
import com.google.android.gms.internal.firebase-auth-api.zzvb;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzho {
    private static final zzxt zza;
    private static final zznz zzb;
    private static final zznv zzc;
    private static final zzmx zzd;
    private static final zzmu zze;

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.firebase-auth-api.zzhp, com.google.android.gms.internal.firebase-auth-api.zzmz] */
    static {
        zzxt zzb2 = zzpf.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza = zzb2;
        zzb = zznz.zza(zzhn.zza, zzhm.class, zzor.class);
        zzc = zznv.zza(zzhq.zza, zzb2, zzor.class);
        zzd = zzmx.zza(zzhp.zza, zzhg.class, zzos.class);
        zze = zzmu.zza(zzhs.zza, zzb2, zzos.class);
    }

    public static /* synthetic */ zzhg zza(zzos zzosVar, zzcs zzcsVar) {
        return zzb(zzosVar, zzcsVar);
    }

    private static zzhg zzb(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        if (!zzosVar.zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzvx zza2 = zzvx.zza(zzosVar.zzd(), zzaio.zza());
            if (zza2.zza() == 0) {
                return zzhg.zza(zza(zzosVar.zzc()), zzxu.zza(zza2.zzd().zzg(), zzcs.zza(zzcsVar)), zzosVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzaji unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    private static zzhm.zza zza(zzvs zzvsVar) throws GeneralSecurityException {
        int i = zzhr.zza[zzvsVar.ordinal()];
        if (i == 1) {
            return zzhm.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzhm.zza.zzb;
        }
        if (i == 4) {
            return zzhm.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvsVar.zza());
    }

    private static zzhm zzb(zzor zzorVar) throws GeneralSecurityException {
        if (!zzorVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: " + zzorVar.zza().zzf());
        }
        try {
            if (zzvy.zza(zzorVar.zza().zze(), zzaio.zza()).zza() == 0) {
                return zzhm.zza(zza(zzorVar.zza().zzd()));
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzaji e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzhm zza(zzor zzorVar) {
        return zzb(zzorVar);
    }

    public static /* synthetic */ zzor zza(zzhm zzhmVar) {
        zzvs zzvsVar;
        zzvb.zza zza2 = zzvb.zza().zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key").zza(zzvy.zzc().zzi());
        zzhm.zza zzb2 = zzhmVar.zzb();
        if (zzhm.zza.zza.equals(zzb2)) {
            zzvsVar = zzvs.TINK;
        } else if (zzhm.zza.zzb.equals(zzb2)) {
            zzvsVar = zzvs.CRUNCHY;
        } else {
            if (!zzhm.zza.zzc.equals(zzb2)) {
                throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzb2));
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
