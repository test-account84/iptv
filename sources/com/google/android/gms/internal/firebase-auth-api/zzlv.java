package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzlv implements zzlj {
    private final zzwo zza;
    private final zzla zzb;

    private zzlv(zzla zzlaVar, zzwo zzwoVar) {
        this.zzb = zzlaVar;
        this.zza = zzwoVar;
    }

    public static zzlv zza(zzwo zzwoVar) throws GeneralSecurityException {
        int i = zzlu.zza[zzwoVar.ordinal()];
        if (i == 1) {
            return new zzlv(new zzla("HmacSha256"), zzwo.NIST_P256);
        }
        if (i == 2) {
            return new zzlv(new zzla("HmacSha384"), zzwo.NIST_P384);
        }
        if (i == 3) {
            return new zzlv(new zzla("HmacSha512"), zzwo.NIST_P521);
        }
        throw new GeneralSecurityException("invalid curve type: " + String.valueOf(zzwoVar));
    }

    public final byte[] zza() throws GeneralSecurityException {
        int i = zzlu.zza[this.zza.ordinal()];
        if (i == 1) {
            return zzlt.zzc;
        }
        if (i == 2) {
            return zzlt.zzd;
        }
        if (i == 3) {
            return zzlt.zze;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }

    public final byte[] zza(byte[] bArr, zzll zzllVar) throws GeneralSecurityException {
        byte[] zza = zzwp.zza(zzwp.zza(this.zza, zzllVar.zza().zzb()), zzwp.zza(this.zza, zzwr.UNCOMPRESSED, bArr));
        byte[] zza2 = zzwg.zza(bArr, zzllVar.zzb().zzb());
        byte[] zza3 = zzlt.zza(zza());
        zzla zzlaVar = this.zzb;
        return zzlaVar.zza(null, zza, "eae_prk", zza2, "shared_secret", zza3, zzlaVar.zza());
    }
}
