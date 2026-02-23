package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzfj;
import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzfg extends zznb {
    private static final zzno zza = zzff.zza;

    public zzfg() {
        super(zzsy.class, new zzfi(zzbg.class));
    }

    public static int zza() {
        return 0;
    }

    private static boolean zzi() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public final zzif.zza zzb() {
        return zzif.zza.zza;
    }

    public final zzne zzc() {
        return new zzfh(this, zzsz.class);
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.SYMMETRIC;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzsy.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zzsy zzsyVar = (zzsy) zzaknVar;
        zzxo.zza(zzsyVar.zza(), 0);
        zzxo.zza(zzsyVar.zzd().zzb());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzi()) {
            zzct.zza((zznb) new zzfg(), true);
            zzfl.zza();
            zzns zza2 = zzns.zza();
            HashMap hashMap = new HashMap();
            zzfj.zza zza3 = zzfj.zzc().zza(16);
            zzfj.zzb zzbVar = zzfj.zzb.zza;
            hashMap.put("AES128_GCM_SIV", zza3.zza(zzbVar).zza());
            zzfj.zza zza4 = zzfj.zzc().zza(16);
            zzfj.zzb zzbVar2 = zzfj.zzb.zzc;
            hashMap.put("AES128_GCM_SIV_RAW", zza4.zza(zzbVar2).zza());
            hashMap.put("AES256_GCM_SIV", zzfj.zzc().zza(32).zza(zzbVar).zza());
            hashMap.put("AES256_GCM_SIV_RAW", zzfj.zzc().zza(32).zza(zzbVar2).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zznl.zza().zza(zza, zzfj.class);
        }
    }
}
