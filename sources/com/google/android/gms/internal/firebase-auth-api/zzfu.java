package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzfu extends zznb {
    public zzfu() {
        super(zztg.class, new zzft(zzbg.class));
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zztg.zza(zzahpVar, zzaio.zza());
    }

    public final zzif.zza zzb() {
        return zzif.zza.zza;
    }

    public final zzne zzc() {
        return new zzfw(this, zzth.class);
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.SYMMETRIC;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zztg zztgVar = (zztg) zzaknVar;
        zzxo.zza(zztgVar.zza(), 0);
        if (zztgVar.zzd().zzb() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
