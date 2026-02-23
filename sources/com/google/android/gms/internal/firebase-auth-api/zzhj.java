package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzhm;
import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzhj extends zznb {
    private static final zzno zza = zzhi.zza;

    public zzhj() {
        super(zzvx.class, new zzhl(zzbg.class));
    }

    public static int zza() {
        return 0;
    }

    public final zzif.zza zzb() {
        return zzif.zza.zza;
    }

    public final zzne zzc() {
        return new zzhk(this, zzvy.class);
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.SYMMETRIC;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzvx.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zzvx zzvxVar = (zzvx) zzaknVar;
        zzxo.zza(zzvxVar.zza(), 0);
        if (zzvxVar.zzd().zzb() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzct.zza((zznb) new zzhj(), true);
        zzho.zza();
        zzns zza2 = zzns.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", zzhm.zza(zzhm.zza.zza));
        hashMap.put("XCHACHA20_POLY1305_RAW", zzhm.zza(zzhm.zza.zzc));
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznl.zza().zza(zza, zzhm.class);
    }
}
