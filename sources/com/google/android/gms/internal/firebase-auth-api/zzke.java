package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzka;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzke {
    private static final zzxt zza;
    private static final zzxt zzb;
    private static final zznz zzc;
    private static final zznv zzd;
    private static final zzmx zze;
    private static final zzmu zzf;
    private static final zzmx zzg;
    private static final zzmu zzh;
    private static final zzmi zzi;
    private static final zzmi zzj;
    private static final zzmi zzk;
    private static final zzmi zzl;

    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.gms.internal.firebase-auth-api.zzkl, com.google.android.gms.internal.firebase-auth-api.zzmz] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.google.android.gms.internal.firebase-auth-api.zzkj, com.google.android.gms.internal.firebase-auth-api.zzmz] */
    static {
        zzxt zzb2 = zzpf.zzb("type.googleapis.com/google.crypto.tink.HpkePrivateKey");
        zza = zzb2;
        zzxt zzb3 = zzpf.zzb("type.googleapis.com/google.crypto.tink.HpkePublicKey");
        zzb = zzb3;
        zzc = zznz.zza(zzkh.zza, zzka.class, zzor.class);
        zzd = zznv.zza(zzkg.zza, zzb2, zzor.class);
        zze = zzmx.zza(zzkj.zza, zzkn.class, zzos.class);
        zzf = zzmu.zza(zzki.zza, zzb3, zzos.class);
        zzg = zzmx.zza(zzkl.zza, zzkf.class, zzos.class);
        zzh = zzmu.zza(zzkk.zza, zzb2, zzos.class);
        zzml zza2 = zzmi.zza().zza(zzvs.RAW, zzka.zzf.zzc).zza(zzvs.TINK, zzka.zzf.zza);
        zzvs zzvsVar = zzvs.LEGACY;
        zzka.zzf zzfVar = zzka.zzf.zzb;
        zzi = zza2.zza(zzvsVar, zzfVar).zza(zzvs.CRUNCHY, zzfVar).zza();
        zzj = zzmi.zza().zza(zzuo.DHKEM_P256_HKDF_SHA256, zzka.zzd.zza).zza(zzuo.DHKEM_P384_HKDF_SHA384, zzka.zzd.zzb).zza(zzuo.DHKEM_P521_HKDF_SHA512, zzka.zzd.zzc).zza(zzuo.DHKEM_X25519_HKDF_SHA256, zzka.zzd.zzd).zza();
        zzk = zzmi.zza().zza(zzum.HKDF_SHA256, zzka.zze.zza).zza(zzum.HKDF_SHA384, zzka.zze.zzb).zza(zzum.HKDF_SHA512, zzka.zze.zzc).zza();
        zzl = zzmi.zza().zza(zzuk.AES_128_GCM, zzka.zza.zza).zza(zzuk.AES_256_GCM, zzka.zza.zzb).zza(zzuk.CHACHA20_POLY1305, zzka.zza.zzc).zza();
    }

    public static /* synthetic */ zzka zza(zzor zzorVar) {
        return zzb(zzorVar);
    }

    private static zzka zzb(zzor zzorVar) throws GeneralSecurityException {
        if (zzorVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            try {
                return zza(zzorVar.zza().zzd(), zzuq.zza(zzorVar.zza().zze(), zzaio.zza()).zzc());
            } catch (zzaji e) {
                throw new GeneralSecurityException("Parsing HpkeParameters failed: ", e);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parseParameters: " + zzorVar.zza().zzf());
    }

    private static zzkf zzc(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        if (!zzosVar.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePrivateKey: " + zzosVar.zzf());
        }
        try {
            zzuu zza2 = zzuu.zza(zzosVar.zzd(), zzaio.zza());
            if (zza2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzuv zzd2 = zza2.zzd();
            return zzkf.zza(zzkn.zza(zza(zzosVar.zzc(), zzd2.zzb()), zza(zzd2.zzb().zzc(), zzd2.zzf().zzg()), zzosVar.zze()), zzxu.zza(zzme.zza(zzme.zza(zza2.zze().zzg()), zzlt.zza(zzd2.zzb().zzc())), zzcs.zza(zzcsVar)));
        } catch (zzaji unused) {
            throw new GeneralSecurityException("Parsing HpkePrivateKey failed");
        }
    }

    private static zzkn zzd(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        if (!zzosVar.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePublicKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePublicKey: " + zzosVar.zzf());
        }
        try {
            zzuv zza2 = zzuv.zza(zzosVar.zzd(), zzaio.zza());
            if (zza2.zza() == 0) {
                return zzkn.zza(zza(zzosVar.zzc(), zza2.zzb()), zza(zza2.zzb().zzc(), zza2.zzf().zzg()), zzosVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzaji unused) {
            throw new GeneralSecurityException("Parsing HpkePublicKey failed");
        }
    }

    private static zzka zza(zzvs zzvsVar, zzur zzurVar) throws GeneralSecurityException {
        return zzka.zzc().zza((zzka.zzf) zzi.zza((Enum) zzvsVar)).zza((zzka.zzd) zzj.zza((Enum) zzurVar.zzc())).zza((zzka.zze) zzk.zza((Enum) zzurVar.zzb())).zza((zzka.zza) zzl.zza((Enum) zzurVar.zza())).zza();
    }

    public static /* synthetic */ zzkn zzb(zzos zzosVar, zzcs zzcsVar) {
        return zzd(zzosVar, zzcsVar);
    }

    public static /* synthetic */ zzkf zza(zzos zzosVar, zzcs zzcsVar) {
        return zzc(zzosVar, zzcsVar);
    }

    public static /* synthetic */ zzor zza(zzka zzkaVar) {
        return zzor.zzb((zzvb) ((zzajc) zzvb.zza().zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey").zza(((zzuq) ((zzajc) zzuq.zza().zza((zzur) ((zzajc) zzur.zzd().zza((zzuo) zzj.zza(zzkaVar.zze())).zza((zzum) zzk.zza(zzkaVar.zzd())).zza((zzuk) zzl.zza(zzkaVar.zzb())).zzf())).zzf())).zzi()).zza((zzvs) zzi.zza(zzkaVar.zzf())).zzf()));
    }

    private static zzxt zza(zzuo zzuoVar, byte[] bArr) throws GeneralSecurityException {
        return zzxt.zza(zzme.zza(zzme.zza(bArr), zzlt.zzb(zzuoVar)));
    }

    public static void zza() throws GeneralSecurityException {
        zznu zza2 = zznu.zza();
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
        zza2.zza(zzh);
    }
}
