package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzlr extends zznb {
    public zzlr() {
        super(zzuv.class, new zzlq(zzbr.class));
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzuv.zza(zzahpVar, zzaio.zza());
    }

    public final zzif.zza zzb() {
        return zzif.zza.zza;
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.ASYMMETRIC_PUBLIC;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    }

    public final /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zzuv zzuvVar = (zzuv) zzaknVar;
        zzxo.zza(zzuvVar.zza(), 0);
        if (!zzuvVar.zzg()) {
            throw new GeneralSecurityException("Missing HPKE key params.");
        }
        zzlt.zza(zzuvVar.zzb());
    }
}
