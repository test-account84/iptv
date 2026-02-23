package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzir;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzin extends zznb {
    private static final zzno zza = zziq.zza;

    public zzin() {
        super(zztc.class, new zzip(zzbp.class));
    }

    public static int zza() {
        return 0;
    }

    public final zzif.zza zzb() {
        return zzif.zza.zza;
    }

    public final zzne zzc() {
        return new zzis(this, zztd.class);
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.SYMMETRIC;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zztc.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zztc zztcVar = (zztc) zzaknVar;
        zzxo.zza(zztcVar.zza(), 0);
        if (zztcVar.zzd().zzb() == 64) {
            return;
        }
        throw new InvalidKeyException("invalid key size: " + zztcVar.zzd().zzb() + ". Valid keys must have 64 bytes.");
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzct.zza((zznb) new zzin(), true);
        zziw.zza();
        zzns zza2 = zzns.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("AES256_SIV", zzjg.zza);
        hashMap.put("AES256_SIV_RAW", zzir.zzc().zza(64).zza(zzir.zzb.zzc).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznl.zza().zza(zza, zzir.class);
    }
}
