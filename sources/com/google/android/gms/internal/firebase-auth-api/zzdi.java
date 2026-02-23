package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzdl;
import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzdi extends zznb {
    private static final zzno zza = zzdh.zza;

    public zzdi() {
        super(zzse.class, new zzdk(zzbg.class));
    }

    public static int zza() {
        return 0;
    }

    public final zzif.zza zzb() {
        return zzif.zza.zzb;
    }

    public final zzne zzc() {
        return new zzdj(this, zzsf.class);
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.SYMMETRIC;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzse.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zzse zzseVar = (zzse) zzaknVar;
        zzxo.zza(zzseVar.zza(), 0);
        new zzdv();
        zzdv.zza(zzseVar.zzd());
        new zzqg();
        zzqg.zza(zzseVar.zze());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzct.zza((zznb) new zzdi(), true);
        zzdp.zza();
        zzns zza2 = zzns.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzhb.zze);
        zzdl.zza zzc = zzdl.zzf().zza(16).zzb(32).zzd(16).zzc(16);
        zzdl.zzb zzbVar = zzdl.zzb.zzc;
        zzdl.zza zza3 = zzc.zza(zzbVar);
        zzdl.zzc zzcVar = zzdl.zzc.zzc;
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zza3.zza(zzcVar).zza());
        hashMap.put("AES256_CTR_HMAC_SHA256", zzhb.zzf);
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzdl.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzbVar).zza(zzcVar).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznl.zza().zza(zza, zzdl.class);
    }
}
