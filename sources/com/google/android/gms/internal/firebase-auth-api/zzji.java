package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzji extends zzop {
    public zzji() {
        super(zztr.class, zztu.class, new zzjh(zzbo.class));
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zztr.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ zzakn zzb(zzakn zzaknVar) throws GeneralSecurityException {
        return ((zztr) zzaknVar).zzd();
    }

    public final zzne zzc() {
        return new zzjk(this, zztn.class);
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.ASYMMETRIC_PRIVATE;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zztr zztrVar = (zztr) zzaknVar;
        if (zztrVar.zze().zze()) {
            throw new GeneralSecurityException("invalid ECIES private key");
        }
        zzxo.zza(zztrVar.zza(), 0);
        zzkx.zza(zztrVar.zzd().zzb());
    }

    public final zzif.zza zzb() {
        return zzif.zza.zza;
    }
}
