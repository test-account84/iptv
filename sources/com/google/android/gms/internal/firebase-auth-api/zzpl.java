package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzpo;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzpl extends zznb {
    private static final zzod zza = zzod.zza(zzpk.zza, zzph.class, zzpz.class);
    private static final zzod zzb = zzod.zza(zzpn.zza, zzph.class, zzce.class);

    public zzpl() {
        super(zzrw.class, new zzpm(zzce.class));
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzrw.zza(zzahpVar, zzaio.zza());
    }

    public final zzif.zza zzb() {
        return zzif.zza.zza;
    }

    public final zzne zzc() {
        return new zzpp(this, zzsa.class);
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.zzb;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public static /* synthetic */ void zza(int i) {
        zzb(i);
    }

    private static void zzb(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    private static void zzb(zzsb zzsbVar) throws GeneralSecurityException {
        if (zzsbVar.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (zzsbVar.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    public final /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zzrw zzrwVar = (zzrw) zzaknVar;
        zzxo.zza(zzrwVar.zza(), 0);
        zzb(zzrwVar.zze().zzb());
        zzb(zzrwVar.zzd());
    }

    public static /* synthetic */ void zza(zzsb zzsbVar) {
        zzb(zzsbVar);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzct.zza((zznb) new zzpl(), true);
        zzpt.zza();
        zznr.zza().zza(zza);
        zznr.zza().zza(zzb);
        zzns zza2 = zzns.zza();
        HashMap hashMap = new HashMap();
        zzpo zzpoVar = zzqx.zzc;
        hashMap.put("AES_CMAC", zzpoVar);
        hashMap.put("AES256_CMAC", zzpoVar);
        hashMap.put("AES256_CMAC_RAW", zzpo.zzd().zza(32).zzb(16).zza(zzpo.zzb.zzd).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
    }
}
