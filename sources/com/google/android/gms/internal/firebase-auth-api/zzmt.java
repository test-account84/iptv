package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzmq;
import java.security.GeneralSecurityException;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzmt implements zzmq.zza {
    private final /* synthetic */ zznb zza;

    public zzmt(zznb zznbVar) {
        this.zza = zznbVar;
    }

    public final zzbs zza() {
        zznb zznbVar = this.zza;
        return new zzmo(zznbVar, zznbVar.zzf());
    }

    public final Class zzb() {
        return this.zza.getClass();
    }

    public final Set zzc() {
        return this.zza.zzh();
    }

    public final zzbs zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzmo(this.zza, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }
}
