package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class zzmo implements zzbs {
    private final zznb zza;
    private final Class zzb;

    public zzmo(zznb zznbVar, Class cls) {
        if (!zznbVar.zzh().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zznbVar.toString(), cls.getName()}));
        }
        this.zza = zznbVar;
        this.zzb = cls;
    }

    public final zzuy zza(zzahp zzahpVar) throws GeneralSecurityException {
        try {
            return (zzuy) ((zzajc) zzuy.zza().zza(this.zza.zze()).zza(new zzmr(this.zza.zzc()).zza(zzahpVar).zzi()).zza(this.zza.zzd()).zzf());
        } catch (zzaji e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    public final Object zzb(zzahp zzahpVar) throws GeneralSecurityException {
        try {
            zzakn zza = this.zza.zza(zzahpVar);
            if (Void.class.equals(this.zzb)) {
                throw new GeneralSecurityException("Cannot create a primitive for Void");
            }
            this.zza.zza(zza);
            return this.zza.zza(zza, this.zzb);
        } catch (zzaji e) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.zza.zzg().getName(), e);
        }
    }

    public final String zza() {
        return this.zza.zze();
    }
}
