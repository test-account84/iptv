package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzjl;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzjy extends zzku {
    private final zzjl zza;
    private final ECPoint zzb;
    private final zzxt zzc;
    private final zzxt zzd;
    private final Integer zze;

    private zzjy(zzjl zzjlVar, ECPoint eCPoint, zzxt zzxtVar, zzxt zzxtVar2, Integer num) {
        this.zza = zzjlVar;
        this.zzb = eCPoint;
        this.zzc = zzxtVar;
        this.zzd = zzxtVar2;
        this.zze = num;
    }

    public final zzjl zza() {
        return this.zza;
    }

    public final zzxt zzb() {
        return this.zzc;
    }

    public final ECPoint zzc() {
        return this.zzb;
    }

    public static zzjy zza(zzjl zzjlVar, zzxt zzxtVar, Integer num) throws GeneralSecurityException {
        if (!zzjlVar.zzd().equals(zzjl.zzc.zzd)) {
            throw new GeneralSecurityException("createForCurveX25519 may only be called with parameters for curve X25519");
        }
        zzb(zzjlVar.zzg(), num);
        if (zzxtVar.zza() == 32) {
            return new zzjy(zzjlVar, null, zzxtVar, zza(zzjlVar.zzg(), num), num);
        }
        throw new GeneralSecurityException("Encoded public point byte length for X25519 curve must be 32");
    }

    private static void zzb(zzjl.zzd zzdVar, Integer num) throws GeneralSecurityException {
        zzjl.zzd zzdVar2 = zzjl.zzd.zzc;
        if (zzdVar.equals(zzdVar2) || num != null) {
            if (zzdVar.equals(zzdVar2) && num != null) {
                throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
            }
        } else {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzdVar) + " variant.");
        }
    }

    public static zzjy zza(zzjl zzjlVar, ECPoint eCPoint, Integer num) throws GeneralSecurityException {
        ECParameterSpec eCParameterSpec;
        if (zzjlVar.zzd().equals(zzjl.zzc.zzd)) {
            throw new GeneralSecurityException("createForNistCurve may only be called with parameters for NIST curve");
        }
        zzb(zzjlVar.zzg(), num);
        zzjl.zzc zzd = zzjlVar.zzd();
        if (zzd == zzjl.zzc.zza) {
            eCParameterSpec = zzmg.zza;
        } else if (zzd == zzjl.zzc.zzb) {
            eCParameterSpec = zzmg.zzb;
        } else {
            if (zzd != zzjl.zzc.zzc) {
                throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzd));
            }
            eCParameterSpec = zzmg.zzc;
        }
        zzmg.zza(eCPoint, eCParameterSpec.getCurve());
        return new zzjy(zzjlVar, eCPoint, null, zza(zzjlVar.zzg(), num), num);
    }

    private static zzxt zza(zzjl.zzd zzdVar, Integer num) {
        if (zzdVar == zzjl.zzd.zzc) {
            return zzxt.zza(new byte[0]);
        }
        if (num == null) {
            throw new IllegalStateException("idRequirement must be non-null for EciesParameters.Variant: " + String.valueOf(zzdVar));
        }
        if (zzdVar == zzjl.zzd.zzb) {
            return zzxt.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        }
        if (zzdVar == zzjl.zzd.zza) {
            return zzxt.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        throw new IllegalStateException("Unknown EciesParameters.Variant: " + String.valueOf(zzdVar));
    }
}
