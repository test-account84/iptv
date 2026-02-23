package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzln extends zzop {
    public zzln() {
        super(zzuu.class, zzuv.class, new zzlm(zzbo.class));
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzuu.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ zzakn zzb(zzakn zzaknVar) throws GeneralSecurityException {
        return ((zzuu) zzaknVar).zzd();
    }

    public final zzne zzc() {
        return new zzlp(this, zzuq.class);
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.ASYMMETRIC_PRIVATE;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    public final /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zzuu zzuuVar = (zzuu) zzaknVar;
        if (zzuuVar.zze().zze()) {
            throw new GeneralSecurityException("Private key is empty.");
        }
        if (!zzuuVar.zzf()) {
            throw new GeneralSecurityException("Missing public key.");
        }
        zzxo.zza(zzuuVar.zza(), 0);
        zzlt.zza(zzuuVar.zzd().zzb());
    }

    public final zzif.zza zzb() {
        return zzif.zza.zza;
    }
}
