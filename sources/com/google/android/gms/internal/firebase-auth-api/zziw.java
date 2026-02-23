package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzik;
import com.google.android.gms.internal.firebase-auth-api.zzir;
import com.google.android.gms.internal.firebase-auth-api.zzvb;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zziw {
    private static final zzxt zza;
    private static final zznz zzb;
    private static final zznv zzc;
    private static final zzmx zzd;
    private static final zzmu zze;
    private static final Map zzf;
    private static final Map zzg;

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.firebase-auth-api.zzix, com.google.android.gms.internal.firebase-auth-api.zzmz] */
    static {
        zzxt zzb2 = zzpf.zzb("type.googleapis.com/google.crypto.tink.AesSivKey");
        zza = zzb2;
        zzb = zznz.zza(zziv.zza, zzir.class, zzor.class);
        zzc = zznv.zza(zziy.zza, zzb2, zzor.class);
        zzd = zzmx.zza(zzix.zza, zzik.class, zzos.class);
        zze = zzmu.zza(zzja.zza, zzb2, zzos.class);
        HashMap hashMap = new HashMap();
        zzir.zzb zzbVar = zzir.zzb.zzc;
        zzvs zzvsVar = zzvs.RAW;
        hashMap.put(zzbVar, zzvsVar);
        zzir.zzb zzbVar2 = zzir.zzb.zza;
        zzvs zzvsVar2 = zzvs.TINK;
        hashMap.put(zzbVar2, zzvsVar2);
        zzir.zzb zzbVar3 = zzir.zzb.zzb;
        zzvs zzvsVar3 = zzvs.CRUNCHY;
        hashMap.put(zzbVar3, zzvsVar3);
        zzf = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(zzvs.class);
        enumMap.put(zzvsVar, zzbVar);
        enumMap.put(zzvsVar2, zzbVar2);
        enumMap.put(zzvsVar3, zzbVar3);
        enumMap.put(zzvs.LEGACY, zzbVar3);
        zzg = Collections.unmodifiableMap(enumMap);
    }

    public static /* synthetic */ zzik zza(zzos zzosVar, zzcs zzcsVar) {
        return zzb(zzosVar, zzcsVar);
    }

    private static zzik zzb(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        if (!zzosVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
        }
        try {
            zztc zza2 = zztc.zza(zzosVar.zzd(), zzaio.zza());
            if (zza2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return new zzik.zza(null).zza(zzir.zzc().zza(zza2.zzd().zzb()).zza(zza(zzosVar.zzc())).zza()).zza(zzxu.zza(zza2.zzd().zzg(), zzcs.zza(zzcsVar))).zza(zzosVar.zze()).zza();
        } catch (zzaji unused) {
            throw new GeneralSecurityException("Parsing AesSivKey failed");
        }
    }

    private static zzir.zzb zza(zzvs zzvsVar) throws GeneralSecurityException {
        Map map = zzg;
        if (map.containsKey(zzvsVar)) {
            return (zzir.zzb) map.get(zzvsVar);
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvsVar.zza());
    }

    private static zzir zzb(zzor zzorVar) throws GeneralSecurityException {
        if (!zzorVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters: " + zzorVar.zza().zzf());
        }
        try {
            zztd zza2 = zztd.zza(zzorVar.zza().zze(), zzaio.zza());
            if (zza2.zzb() == 0) {
                return zzir.zzc().zza(zza2.zza()).zza(zza(zzorVar.zza().zzd())).zza();
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzaji e) {
            throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzir zza(zzor zzorVar) {
        return zzb(zzorVar);
    }

    public static /* synthetic */ zzor zza(zzir zzirVar) {
        zzvb.zza zza2 = zzvb.zza().zza("type.googleapis.com/google.crypto.tink.AesSivKey").zza(((zztd) ((zzajc) zztd.zzc().zza(zzirVar.zzb()).zzf())).zzi());
        zzir.zzb zzd2 = zzirVar.zzd();
        Map map = zzf;
        if (map.containsKey(zzd2)) {
            return zzor.zzb((zzvb) ((zzajc) zza2.zza((zzvs) map.get(zzd2)).zzf()));
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzd2));
    }

    public static void zza() throws GeneralSecurityException {
        zznu zza2 = zznu.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
