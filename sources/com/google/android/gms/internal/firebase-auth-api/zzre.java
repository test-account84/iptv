package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzql;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzre {
    private static final zzxt zza;
    private static final zzmi zzb;
    private static final zzmi zzc;
    private static final zznz zzd;
    private static final zznv zze;
    private static final zzmx zzf;
    private static final zzmu zzg;

    /* JADX WARN: Type inference failed for: r1v17, types: [com.google.android.gms.internal.firebase-auth-api.zzmz, com.google.android.gms.internal.firebase-auth-api.zzrj] */
    static {
        zzxt zzb2 = zzpf.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zza = zzb2;
        zzb = zzmi.zza().zza(zzvs.zzd, zzql.zzb.zzd).zza(zzvs.zzb, zzql.zzb.zza).zza(zzvs.zzc, zzql.zzb.zzc).zza(zzvs.zze, zzql.zzb.zzb).zza();
        zzc = zzmi.zza().zza(zzub.zza, zzql.zzc.zza).zza(zzub.zze, zzql.zzc.zzb).zza(zzub.zzc, zzql.zzc.zzc).zza(zzub.zzb, zzql.zzc.zzd).zza(zzub.zzd, zzql.zzc.zze).zza();
        zzd = zznz.zza(zzrh.zza, zzql.class, zzor.class);
        zze = zznv.zza(zzrg.zza, zzb2, zzor.class);
        zzf = zzmx.zza(zzrj.zza, zzqc.class, zzos.class);
        zzg = zzmu.zza(zzri.zza, zzb2, zzos.class);
    }

    public static /* synthetic */ zzor zza(zzql zzqlVar) {
        return zzor.zzb((zzvb) ((zzajc) zzvb.zza().zza("type.googleapis.com/google.crypto.tink.HmacKey").zza(((zzug) ((zzajc) zzug.zzc().zza((zzuh) ((zzajc) zzuh.zzc().zza(zzqlVar.zzb()).zza((zzub) zzc.zza(zzqlVar.zze())).zzf())).zza(zzqlVar.zzc()).zzf())).zzi()).zza((zzvs) zzb.zza(zzqlVar.zzf())).zzf()));
    }

    private static zzqc zzb(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        if (!zzosVar.zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzuc zza2 = zzuc.zza(zzosVar.zzd(), zzaio.zza());
            if (zza2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzqc.zzc().zza(zzql.zzd().zza(zza2.zzf().zzb()).zzb(zza2.zze().zza()).zza((zzql.zzc) zzc.zza((Enum) zza2.zze().zzb())).zza((zzql.zzb) zzb.zza((Enum) zzosVar.zzc())).zza()).zza(zzxu.zza(zza2.zzf().zzg(), zzcs.zza(zzcsVar))).zza(zzosVar.zze()).zza();
        } catch (zzaji | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    public static /* synthetic */ zzqc zza(zzos zzosVar, zzcs zzcsVar) {
        return zzb(zzosVar, zzcsVar);
    }

    private static zzql zzb(zzor zzorVar) throws GeneralSecurityException {
        if (!zzorVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: " + zzorVar.zza().zzf());
        }
        try {
            zzug zza2 = zzug.zza(zzorVar.zza().zze(), zzaio.zza());
            if (zza2.zzb() == 0) {
                return zzql.zzd().zza(zza2.zza()).zzb(zza2.zzf().zza()).zza((zzql.zzc) zzc.zza((Enum) zza2.zzf().zzb())).zza((zzql.zzb) zzb.zza((Enum) zzorVar.zza().zzd())).zza();
            }
            throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zza2.zzb());
        } catch (zzaji e) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzql zza(zzor zzorVar) {
        return zzb(zzorVar);
    }

    public static void zza() throws GeneralSecurityException {
        zznu zza2 = zznu.zza();
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
    }
}
