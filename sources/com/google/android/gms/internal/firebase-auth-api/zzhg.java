package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzhm;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzhg extends zzcz {
    private final zzhm zza;
    private final zzxu zzb;
    private final zzxt zzc;
    private final Integer zzd;

    private zzhg(zzhm zzhmVar, zzxu zzxuVar, zzxt zzxtVar, Integer num) {
        this.zza = zzhmVar;
        this.zzb = zzxuVar;
        this.zzc = zzxtVar;
        this.zzd = num;
    }

    public static zzhg zza(zzhm.zza zzaVar, zzxu zzxuVar, Integer num) throws GeneralSecurityException {
        zzxt zza;
        zzhm.zza zzaVar2 = zzhm.zza.zzc;
        if (zzaVar != zzaVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zzaVar) + " the value of idRequirement must be non-null");
        }
        if (zzaVar == zzaVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzxuVar.zza() != 32) {
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzxuVar.zza());
        }
        zzhm zza2 = zzhm.zza(zzaVar);
        if (zza2.zzb() == zzaVar2) {
            zza = zzxt.zza(new byte[0]);
        } else if (zza2.zzb() == zzhm.zza.zzb) {
            zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        } else {
            if (zza2.zzb() != zzhm.zza.zza) {
                throw new IllegalStateException("Unknown Variant: " + String.valueOf(zza2.zzb()));
            }
            zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        return new zzhg(zza2, zzxuVar, zza, num);
    }
}
