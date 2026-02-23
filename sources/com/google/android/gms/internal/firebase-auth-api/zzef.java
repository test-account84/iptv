package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzdw;
import com.google.android.gms.internal.firebase-auth-api.zzed;
import com.google.android.gms.internal.firebase-auth-api.zzsq;
import com.google.android.gms.internal.firebase-auth-api.zzvb;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzef {
    private static final zzxt zza;
    private static final zznz zzb;
    private static final zznv zzc;
    private static final zzmx zzd;
    private static final zzmu zze;

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.firebase-auth-api.zzek, com.google.android.gms.internal.firebase-auth-api.zzmz] */
    static {
        zzxt zzb2 = zzpf.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zza = zzb2;
        zzb = zznz.zza(zzei.zza, zzed.class, zzor.class);
        zzc = zznv.zza(zzeh.zza, zzb2, zzor.class);
        zzd = zzmx.zza(zzek.zza, zzdw.class, zzos.class);
        zze = zzmu.zza(zzej.zza, zzb2, zzos.class);
    }

    public static /* synthetic */ zzdw zza(zzos zzosVar, zzcs zzcsVar) {
        return zzb(zzosVar, zzcsVar);
    }

    private static zzdw zzb(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        if (!zzosVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzsn zza2 = zzsn.zza(zzosVar.zzd(), zzaio.zza());
            if (zza2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return new zzdw.zza(null).zza(zzed.zze().zzb(zza2.zze().zzb()).zza(zza2.zzd().zza()).zzc(16).zza(zza(zzosVar.zzc())).zza()).zza(zzxu.zza(zza2.zze().zzg(), zzcs.zza(zzcsVar))).zza(zzosVar.zze()).zza();
        } catch (zzaji unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }

    private static zzed.zzb zza(zzvs zzvsVar) throws GeneralSecurityException {
        int i = zzem.zza[zzvsVar.ordinal()];
        if (i == 1) {
            return zzed.zzb.zza;
        }
        if (i == 2 || i == 3) {
            return zzed.zzb.zzb;
        }
        if (i == 4) {
            return zzed.zzb.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvsVar.zza());
    }

    private static zzed zzb(zzor zzorVar) throws GeneralSecurityException {
        if (zzorVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzsq zza2 = zzsq.zza(zzorVar.zza().zze(), zzaio.zza());
                return zzed.zze().zzb(zza2.zza()).zza(zza2.zzd().zza()).zzc(16).zza(zza(zzorVar.zza().zzd())).zza();
            } catch (zzaji e) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: " + zzorVar.zza().zzf());
    }

    public static /* synthetic */ zzed zza(zzor zzorVar) {
        return zzb(zzorVar);
    }

    public static /* synthetic */ zzor zza(zzed zzedVar) {
        zzvs zzvsVar;
        zzvb.zza zza2 = zzvb.zza().zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzsq.zza zzb2 = zzsq.zzb();
        if (zzedVar.zzd() != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports aes eax keys with tag size equal to 16 bytes.", new Object[]{Integer.valueOf(zzedVar.zzd())}));
        }
        zzvb.zza zza3 = zza2.zza(((zzsq) ((zzajc) zzb2.zza((zzsr) ((zzajc) zzsr.zzb().zza(zzedVar.zzb()).zzf())).zza(zzedVar.zzc()).zzf())).zzi());
        zzed.zzb zzf = zzedVar.zzf();
        if (zzed.zzb.zza.equals(zzf)) {
            zzvsVar = zzvs.TINK;
        } else if (zzed.zzb.zzb.equals(zzf)) {
            zzvsVar = zzvs.CRUNCHY;
        } else {
            if (!zzed.zzb.zzc.equals(zzf)) {
                throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzf));
            }
            zzvsVar = zzvs.RAW;
        }
        return zzor.zzb((zzvb) ((zzajc) zza3.zza(zzvsVar).zzf()));
    }

    public static void zza() throws GeneralSecurityException {
        zznu zza2 = zznu.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
