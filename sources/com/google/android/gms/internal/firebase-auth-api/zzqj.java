package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzqj extends zzne {
    private final /* synthetic */ zzqg zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzqj(zzqg zzqgVar, Class cls) {
        super(cls);
        this.zza = zzqgVar;
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzug.zza(zzahpVar, zzaio.zza());
    }

    public final /* synthetic */ void zzb(zzakn zzaknVar) throws GeneralSecurityException {
        zzug zzugVar = (zzug) zzaknVar;
        if (zzugVar.zza() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzqg.zza(zzugVar.zzf());
    }

    public final /* synthetic */ zzakn zza(zzakn zzaknVar) throws GeneralSecurityException {
        zzug zzugVar = (zzug) zzaknVar;
        return (zzuc) ((zzajc) zzuc.zzb().zza(zzqg.zza()).zza(zzugVar.zzf()).zza(zzahp.zza(zzou.zza(zzugVar.zza()))).zzf());
    }
}
