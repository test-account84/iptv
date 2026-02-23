package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzgg extends zznb {
    public zzgg() {
        super(zzvo.class, new zzgj(zzbg.class));
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzvo.zza(zzahpVar, zzaio.zza());
    }

    public final zzif.zza zzb() {
        return zzif.zza.zza;
    }

    public final zzne zzc() {
        return new zzgi(this, zzvr.class);
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.REMOTE;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    public final /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zzvo zzvoVar = (zzvo) zzaknVar;
        zzxo.zza(zzvoVar.zza(), 0);
        if (zzgh.zza(zzvoVar.zzd().zza().zzf())) {
            return;
        }
        throw new GeneralSecurityException("Unsupported DEK key type: " + zzvoVar.zzd().zza().zzf() + ". Only Tink AEAD key types are supported.");
    }
}
