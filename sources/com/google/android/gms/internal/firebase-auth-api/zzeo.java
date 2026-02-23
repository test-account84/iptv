package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzes;
import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzeo extends zznb {
    private static final zzno zza = zzer.zza;

    public zzeo() {
        super(zzsu.class, new zzeq(zzbg.class));
    }

    public static int zza() {
        return 0;
    }

    public final zzif.zza zzb() {
        return zzif.zza.zzb;
    }

    public final zzne zzc() {
        return new zzet(this, zzsv.class);
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.SYMMETRIC;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzsu.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zzsu zzsuVar = (zzsu) zzaknVar;
        zzxo.zza(zzsuVar.zza(), 0);
        zzxo.zza(zzsuVar.zzd().zzb());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzct.zza((zznb) new zzeo(), true);
        zzex.zza();
        zzns zza2 = zzns.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzhb.zza);
        zzes.zza zzc = zzes.zze().zza(12).zzb(16).zzc(16);
        zzes.zzb zzbVar = zzes.zzb.zzc;
        hashMap.put("AES128_GCM_RAW", zzc.zza(zzbVar).zza());
        hashMap.put("AES256_GCM", zzhb.zzb);
        hashMap.put("AES256_GCM_RAW", zzes.zze().zza(12).zzb(32).zzc(16).zza(zzbVar).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznl.zza().zza(zza, zzes.class);
    }
}
