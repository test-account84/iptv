package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzfv;
import com.google.android.gms.internal.firebase-auth-api.zzvb;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzfx {
    private static final zzxt zza;
    private static final zznz zzb;
    private static final zznv zzc;
    private static final zzmx zzd;
    private static final zzmu zze;

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.firebase-auth-api.zzgb, com.google.android.gms.internal.firebase-auth-api.zzmz] */
    static {
        zzxt zzb2 = zzpf.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza = zzb2;
        zzb = zznz.zza(zzfz.zza, zzfv.class, zzor.class);
        zzc = zznv.zza(zzfy.zza, zzb2, zzor.class);
        zzd = zzmx.zza(zzgb.zza, zzfr.class, zzos.class);
        zze = zzmu.zza(zzga.zza, zzb2, zzos.class);
    }

    public static /* synthetic */ zzfr zza(zzos zzosVar, zzcs zzcsVar) {
        return zzb(zzosVar, zzcsVar);
    }

    private static zzfr zzb(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        if (!zzosVar.zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zztg zza2 = zztg.zza(zzosVar.zzd(), zzaio.zza());
            if (zza2.zza() == 0) {
                return zzfr.zza(zza(zzosVar.zzc()), zzxu.zza(zza2.zzd().zzg(), zzcs.zza(zzcsVar)), zzosVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzaji unused) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
        }
    }

    private static zzfv.zza zza(zzvs zzvsVar) throws GeneralSecurityException {
        int i = zzgd.zza[zzvsVar.ordinal()];
        if (i == 1) {
            return zzfv.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzfv.zza.zzb;
        }
        if (i == 4) {
            return zzfv.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvsVar.zza());
    }

    private static zzfv zzb(zzor zzorVar) throws GeneralSecurityException {
        if (zzorVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzth.zza(zzorVar.zza().zze(), zzaio.zza());
                return zzfv.zza(zza(zzorVar.zza().zzd()));
            } catch (zzaji e) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: " + zzorVar.zza().zzf());
    }

    public static /* synthetic */ zzfv zza(zzor zzorVar) {
        return zzb(zzorVar);
    }

    public static /* synthetic */ zzor zza(zzfv zzfvVar) {
        zzvs zzvsVar;
        zzvb.zza zza2 = zzvb.zza().zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").zza(zzth.zzb().zzi());
        zzfv.zza zzb2 = zzfvVar.zzb();
        if (zzfv.zza.zza.equals(zzb2)) {
            zzvsVar = zzvs.TINK;
        } else if (zzfv.zza.zzb.equals(zzb2)) {
            zzvsVar = zzvs.CRUNCHY;
        } else {
            if (!zzfv.zza.zzc.equals(zzb2)) {
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
