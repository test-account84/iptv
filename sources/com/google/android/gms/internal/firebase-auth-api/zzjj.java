package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzjj extends zznb {
    public zzjj() {
        super(zztu.class, new zzjm(zzbr.class));
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zztu.zza(zzahpVar, zzaio.zza());
    }

    public final zzif.zza zzb() {
        return zzif.zza.zza;
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.ASYMMETRIC_PUBLIC;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zztu zztuVar = (zztu) zzaknVar;
        zzxo.zza(zztuVar.zza(), 0);
        zzkx.zza(zztuVar.zzb());
    }
}
