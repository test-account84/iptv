package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzjl;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzjq extends zzkv {
    private final zzjy zza;
    private final zzxs zzb;
    private final zzxu zzc;

    private zzjq(zzjy zzjyVar, zzxs zzxsVar, zzxu zzxuVar) {
        this.zza = zzjyVar;
        this.zzb = zzxsVar;
        this.zzc = zzxuVar;
    }

    public static zzjq zza(zzjy zzjyVar, zzxs zzxsVar) throws GeneralSecurityException {
        if (zzjyVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        }
        if (zzjyVar.zzc() == null) {
            throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
        }
        if (zzxsVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
        BigInteger zza = zzxsVar.zza(zzbq.zza());
        ECPoint zzc = zzjyVar.zzc();
        zzjl.zzc zzd = zzjyVar.zza().zzd();
        BigInteger order = zza(zzd).getOrder();
        if (zza.signum() <= 0 || zza.compareTo(order) >= 0) {
            throw new GeneralSecurityException("Invalid private value");
        }
        if (zzmg.zza(zza, zza(zzd)).equals(zzc)) {
            return new zzjq(zzjyVar, zzxsVar, null);
        }
        throw new GeneralSecurityException("Invalid private value");
    }

    public static zzjq zza(zzjy zzjyVar, zzxu zzxuVar) throws GeneralSecurityException {
        if (zzjyVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        }
        if (zzjyVar.zzb() == null) {
            throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
        }
        if (zzxuVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
        byte[] zza = zzxuVar.zza(zzbq.zza());
        byte[] zzb = zzjyVar.zzb().zzb();
        if (zza.length != 32) {
            throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
        }
        if (Arrays.equals(zzxr.zza(zza), zzb)) {
            return new zzjq(zzjyVar, null, zzxuVar);
        }
        throw new GeneralSecurityException("Invalid private key for public key.");
    }

    private static ECParameterSpec zza(zzjl.zzc zzcVar) {
        if (zzcVar == zzjl.zzc.zza) {
            return zzmg.zza;
        }
        if (zzcVar == zzjl.zzc.zzb) {
            return zzmg.zzb;
        }
        if (zzcVar == zzjl.zzc.zzc) {
            return zzmg.zzc;
        }
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzcVar));
    }
}
