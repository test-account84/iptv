package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzgi extends zzne {
    private final /* synthetic */ zzgg zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgi(zzgg zzggVar, Class cls) {
        super(cls);
        this.zza = zzggVar;
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzvr.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ void zzb(zzakn zzaknVar) throws GeneralSecurityException {
        zzvr zzvrVar = (zzvr) zzaknVar;
        if (zzgh.zza(zzvrVar.zza().zzf())) {
            if (zzvrVar.zze().isEmpty() || !zzvrVar.zzf()) {
                throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
            }
        } else {
            throw new GeneralSecurityException("Unsupported DEK key type: " + zzvrVar.zza().zzf() + ". Only Tink AEAD key types are supported.");
        }
    }

    public final /* synthetic */ zzakn zza(zzakn zzaknVar) throws GeneralSecurityException {
        return (zzvo) ((zzajc) zzvo.zzb().zza((zzvr) zzaknVar).zza(0).zzf());
    }
}
