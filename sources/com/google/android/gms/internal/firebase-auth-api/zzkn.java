package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzka;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzkn extends zzku {
    private final zzka zza;
    private final zzxt zzb;
    private final zzxt zzc;
    private final Integer zzd;

    private zzkn(zzka zzkaVar, zzxt zzxtVar, zzxt zzxtVar2, Integer num) {
        this.zza = zzkaVar;
        this.zzb = zzxtVar;
        this.zzc = zzxtVar2;
        this.zzd = num;
    }

    public final zzka zza() {
        return this.zza;
    }

    public final zzxt zzb() {
        return this.zzb;
    }

    public static zzkn zza(zzka zzkaVar, zzxt zzxtVar, Integer num) throws GeneralSecurityException {
        ECParameterSpec eCParameterSpec;
        zzxt zza;
        zzka.zzf zzf = zzkaVar.zzf();
        zzka.zzf zzfVar = zzka.zzf.zzc;
        if (!zzf.equals(zzfVar) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzf) + " variant.");
        }
        if (zzf.equals(zzfVar) && num != null) {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
        zzka.zzd zze = zzkaVar.zze();
        int zza2 = zzxtVar.zza();
        String str = "Encoded public key byte length for " + String.valueOf(zze) + " must be %d, not " + zza2;
        zzka.zzd zzdVar = zzka.zzd.zza;
        if (zze == zzdVar) {
            if (zza2 != 65) {
                throw new GeneralSecurityException(String.format(str, new Object[]{65}));
            }
        } else if (zze == zzka.zzd.zzb) {
            if (zza2 != 97) {
                throw new GeneralSecurityException(String.format(str, new Object[]{97}));
            }
        } else if (zze == zzka.zzd.zzc) {
            if (zza2 != 133) {
                throw new GeneralSecurityException(String.format(str, new Object[]{133}));
            }
        } else {
            if (zze != zzka.zzd.zzd) {
                throw new GeneralSecurityException("Unable to validate public key length for " + String.valueOf(zze));
            }
            if (zza2 != 32) {
                throw new GeneralSecurityException(String.format(str, new Object[]{32}));
            }
        }
        if (zze == zzdVar || zze == zzka.zzd.zzb || zze == zzka.zzd.zzc) {
            if (zze == zzdVar) {
                eCParameterSpec = zzmg.zza;
            } else if (zze == zzka.zzd.zzb) {
                eCParameterSpec = zzmg.zzb;
            } else {
                if (zze != zzka.zzd.zzc) {
                    throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zze));
                }
                eCParameterSpec = zzmg.zzc;
            }
            EllipticCurve curve = eCParameterSpec.getCurve();
            zzmg.zza(zzwp.zza(curve, zzwr.UNCOMPRESSED, zzxtVar.zzb()), curve);
        }
        zzka.zzf zzf2 = zzkaVar.zzf();
        if (zzf2 == zzfVar) {
            zza = zzxt.zza(new byte[0]);
        } else {
            if (num == null) {
                throw new IllegalStateException("idRequirement must be non-null for HpkeParameters.Variant " + String.valueOf(zzf2));
            }
            if (zzf2 == zzka.zzf.zzb) {
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else {
                if (zzf2 != zzka.zzf.zza) {
                    throw new IllegalStateException("Unknown HpkeParameters.Variant: " + String.valueOf(zzf2));
                }
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            }
        }
        return new zzkn(zzkaVar, zzxtVar, zza, num);
    }
}
