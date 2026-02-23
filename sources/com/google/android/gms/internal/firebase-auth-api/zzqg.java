package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzql;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzqg extends zznb {
    private static final zzod zza = zzod.zza(zzqf.zza, zzqc.class, zzpz.class);
    private static final zzod zzb = zzod.zza(zzqi.zza, zzqc.class, zzce.class);
    private static final zzno zzc = zzqh.zza;

    public zzqg() {
        super(zzuc.class, new zzqk(zzce.class));
    }

    public static int zza() {
        return 0;
    }

    public final zzif.zza zzb() {
        return zzif.zza.zzb;
    }

    public final zzne zzc() {
        return new zzqj(this, zzug.class);
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.zzb;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    private static void zzb(zzuh zzuhVar) throws GeneralSecurityException {
        if (zzuhVar.zza() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i = zzqm.zza[zzuhVar.zzb().ordinal()];
        if (i == 1) {
            if (zzuhVar.zza() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (i == 2) {
            if (zzuhVar.zza() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (i == 3) {
            if (zzuhVar.zza() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i == 4) {
            if (zzuhVar.zza() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (i != 5) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (zzuhVar.zza() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzuc.zza(zzahpVar, zzaio.zza());
    }

    public final /* bridge */ /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zza((zzuc) zzaknVar);
    }

    public static void zza(zzuc zzucVar) throws GeneralSecurityException {
        zzxo.zza(zzucVar.zza(), 0);
        if (zzucVar.zzf().zzb() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzb(zzucVar.zze());
    }

    public static /* synthetic */ void zza(zzuh zzuhVar) {
        zzb(zzuhVar);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzct.zza((zznb) new zzqg(), true);
        zzre.zza();
        zznr.zza().zza(zza);
        zznr.zza().zza(zzb);
        zzns zza2 = zzns.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", zzqx.zza);
        zzql.zza zzb2 = zzql.zzd().zza(32).zzb(16);
        zzql.zzb zzbVar = zzql.zzb.zzd;
        zzql.zza zza3 = zzb2.zza(zzbVar);
        zzql.zzc zzcVar = zzql.zzc.zzc;
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zza3.zza(zzcVar).zza());
        zzql.zza zzb3 = zzql.zzd().zza(32).zzb(32);
        zzql.zzb zzbVar2 = zzql.zzb.zza;
        hashMap.put("HMAC_SHA256_256BITTAG", zzb3.zza(zzbVar2).zza(zzcVar).zza());
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzql.zzd().zza(32).zzb(32).zza(zzbVar).zza(zzcVar).zza());
        zzql.zza zza4 = zzql.zzd().zza(64).zzb(16).zza(zzbVar2);
        zzql.zzc zzcVar2 = zzql.zzc.zze;
        hashMap.put("HMAC_SHA512_128BITTAG", zza4.zza(zzcVar2).zza());
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzql.zzd().zza(64).zzb(16).zza(zzbVar).zza(zzcVar2).zza());
        hashMap.put("HMAC_SHA512_256BITTAG", zzql.zzd().zza(64).zzb(32).zza(zzbVar2).zza(zzcVar2).zza());
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzql.zzd().zza(64).zzb(32).zza(zzbVar).zza(zzcVar2).zza());
        hashMap.put("HMAC_SHA512_512BITTAG", zzqx.zzb);
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzql.zzd().zza(64).zzb(64).zza(zzbVar).zza(zzcVar2).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznl.zza().zza(zzc, zzql.class);
    }
}
