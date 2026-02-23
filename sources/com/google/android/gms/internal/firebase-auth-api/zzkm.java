package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzdl;
import com.google.android.gms.internal.firebase-auth-api.zzes;
import com.google.android.gms.internal.firebase-auth-api.zzjl;
import com.google.android.gms.internal.firebase-auth-api.zzka;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzkm {
    private static final String zza = new zzjj().zze();
    private static final String zzb = new zzji().zze();

    @Deprecated
    private static final zzvt zzc = zzvt.zzb();

    @Deprecated
    private static final zzvt zzd = zzvt.zzb();

    @Deprecated
    private static final zzvt zze = zzvt.zzb();

    static {
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzkp.zzc();
        zzkr.zzc();
        zzcw.zza();
        zziz.zza();
        if (zzif.zzb()) {
            return;
        }
        zzct.zza((zzop) new zzji(), (zznb) new zzjj(), true);
        zzjt.zza();
        zzns zza2 = zzns.zza();
        HashMap hashMap = new HashMap();
        zzjl.zza zzc2 = zzjl.zzc();
        zzjl.zzc zzcVar = zzjl.zzc.zza;
        zzjl.zza zza3 = zzc2.zza(zzcVar);
        zzjl.zzb zzbVar = zzjl.zzb.zzc;
        zzjl.zza zza4 = zza3.zza(zzbVar);
        zzjl.zze zzeVar = zzjl.zze.zzb;
        zzjl.zza zza5 = zza4.zza(zzeVar);
        zzjl.zzd zzdVar = zzjl.zzd.zza;
        zzjl.zza zza6 = zza5.zza(zzdVar);
        zzes.zza zzc3 = zzes.zze().zza(12).zzb(16).zzc(16);
        zzes.zzb zzbVar2 = zzes.zzb.zzc;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zza6.zza(zzc3.zza(zzbVar2).zza()).zza());
        zzjl.zza zza7 = zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar);
        zzjl.zzd zzdVar2 = zzjl.zzd.zzc;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zza7.zza(zzdVar2).zza(zzes.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
        zzjl.zza zza8 = zzjl.zzc().zza(zzcVar).zza(zzbVar);
        zzjl.zze zzeVar2 = zzjl.zze.zza;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zza8.zza(zzeVar2).zza(zzdVar).zza(zzes.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar2).zza(zzes.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar2).zza(zzes.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
        zzjl.zza zza9 = zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar).zza(zzdVar);
        zzdl.zza zzc4 = zzdl.zzf().zza(16).zzb(32).zzd(16).zzc(16);
        zzdl.zzb zzbVar3 = zzdl.zzb.zzc;
        zzdl.zza zza10 = zzc4.zza(zzbVar3);
        zzdl.zzc zzcVar2 = zzdl.zzc.zzc;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zza9.zza(zza10.zza(zzcVar2).zza()).zza());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar).zza(zzdVar2).zza(zzdl.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzbVar3).zza(zzcVar2).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar).zza(zzdl.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzbVar3).zza(zzcVar2).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar2).zza(zzdl.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzbVar3).zza(zzcVar2).zza()).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzct.zza((zzop) new zzln(), (zznb) new zzlr(), true);
        zzke.zza();
        zzns zza11 = zzns.zza();
        HashMap hashMap2 = new HashMap();
        zzka.zzc zzc5 = zzka.zzc();
        zzka.zzf zzfVar = zzka.zzf.zza;
        zzka.zzc zza12 = zzc5.zza(zzfVar);
        zzka.zzd zzdVar3 = zzka.zzd.zzd;
        zzka.zzc zza13 = zza12.zza(zzdVar3);
        zzka.zze zzeVar3 = zzka.zze.zza;
        zzka.zzc zza14 = zza13.zza(zzeVar3);
        zzka.zza zzaVar = zzka.zza.zza;
        hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zza14.zza(zzaVar).zza());
        zzka.zzc zzc6 = zzka.zzc();
        zzka.zzf zzfVar2 = zzka.zzf.zzc;
        hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzc6.zza(zzfVar2).zza(zzdVar3).zza(zzeVar3).zza(zzaVar).zza());
        zzka.zzc zza15 = zzka.zzc().zza(zzfVar).zza(zzdVar3).zza(zzeVar3);
        zzka.zza zzaVar2 = zzka.zza.zzb;
        hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zza15.zza(zzaVar2).zza());
        hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzka.zzc().zza(zzfVar2).zza(zzdVar3).zza(zzeVar3).zza(zzaVar2).zza());
        zzka.zzc zza16 = zzka.zzc().zza(zzfVar).zza(zzdVar3).zza(zzeVar3);
        zzka.zza zzaVar3 = zzka.zza.zzc;
        hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zza16.zza(zzaVar3).zza());
        hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzka.zzc().zza(zzfVar2).zza(zzdVar3).zza(zzeVar3).zza(zzaVar3).zza());
        zzka.zzc zza17 = zzka.zzc().zza(zzfVar);
        zzka.zzd zzdVar4 = zzka.zzd.zza;
        hashMap2.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zza17.zza(zzdVar4).zza(zzeVar3).zza(zzaVar).zza());
        hashMap2.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzka.zzc().zza(zzfVar2).zza(zzdVar4).zza(zzeVar3).zza(zzaVar).zza());
        hashMap2.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzka.zzc().zza(zzfVar).zza(zzdVar4).zza(zzeVar3).zza(zzaVar2).zza());
        hashMap2.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzka.zzc().zza(zzfVar2).zza(zzdVar4).zza(zzeVar3).zza(zzaVar2).zza());
        zzka.zzc zza18 = zzka.zzc().zza(zzfVar);
        zzka.zzd zzdVar5 = zzka.zzd.zzb;
        zzka.zzc zza19 = zza18.zza(zzdVar5);
        zzka.zze zzeVar4 = zzka.zze.zzb;
        hashMap2.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zza19.zza(zzeVar4).zza(zzaVar).zza());
        hashMap2.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzka.zzc().zza(zzfVar2).zza(zzdVar5).zza(zzeVar4).zza(zzaVar).zza());
        hashMap2.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzka.zzc().zza(zzfVar).zza(zzdVar5).zza(zzeVar4).zza(zzaVar2).zza());
        hashMap2.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzka.zzc().zza(zzfVar2).zza(zzdVar5).zza(zzeVar4).zza(zzaVar2).zza());
        zzka.zzc zza20 = zzka.zzc().zza(zzfVar);
        zzka.zzd zzdVar6 = zzka.zzd.zzc;
        zzka.zzc zza21 = zza20.zza(zzdVar6);
        zzka.zze zzeVar5 = zzka.zze.zzc;
        hashMap2.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zza21.zza(zzeVar5).zza(zzaVar).zza());
        hashMap2.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzka.zzc().zza(zzfVar2).zza(zzdVar6).zza(zzeVar5).zza(zzaVar).zza());
        hashMap2.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzka.zzc().zza(zzfVar).zza(zzdVar6).zza(zzeVar5).zza(zzaVar2).zza());
        hashMap2.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzka.zzc().zza(zzfVar2).zza(zzdVar6).zza(zzeVar5).zza(zzaVar2).zza());
        zza11.zza(Collections.unmodifiableMap(hashMap2));
    }
}
