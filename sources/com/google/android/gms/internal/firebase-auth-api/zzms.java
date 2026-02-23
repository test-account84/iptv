package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzmq;
import java.security.GeneralSecurityException;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzms implements zzmq.zza {
    private final /* synthetic */ zzop zza;
    private final /* synthetic */ zznb zzb;

    public zzms(zzop zzopVar, zznb zznbVar) {
        this.zza = zzopVar;
        this.zzb = zznbVar;
    }

    public final zzbs zza() {
        zzop zzopVar = this.zza;
        return new zzoq(zzopVar, this.zzb, zzopVar.zzf());
    }

    public final Class zzb() {
        return this.zza.getClass();
    }

    public final Set zzc() {
        return this.zza.zzh();
    }

    public final zzbs zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzoq(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }
}
