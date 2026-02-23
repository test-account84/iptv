package com.google.android.gms.internal.firebase-auth-api;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzlt {
    private static final byte[] zzn;
    private static final byte[] zzo;
    private static final byte[] zzp;
    public static final byte[] zza = zza(1, 0);
    private static final byte[] zzm = zza(1, 2);
    public static final byte[] zzb = zza(2, 32);
    public static final byte[] zzc = zza(2, 16);
    public static final byte[] zzd = zza(2, 17);
    public static final byte[] zze = zza(2, 18);
    public static final byte[] zzf = zza(2, 1);
    public static final byte[] zzg = zza(2, 2);
    public static final byte[] zzh = zza(2, 3);
    public static final byte[] zzi = zza(2, 1);
    public static final byte[] zzj = zza(2, 2);
    public static final byte[] zzk = zza(2, 3);
    public static final byte[] zzl = new byte[0];

    static {
        Charset charset = zzpf.zza;
        zzn = "KEM".getBytes(charset);
        zzo = "HPKE".getBytes(charset);
        zzp = "HPKE-v1".getBytes(charset);
    }

    public static int zza(zzuo zzuoVar) throws GeneralSecurityException {
        int i = zzls.zza[zzuoVar.ordinal()];
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 48;
        }
        if (i == 3) {
            return 66;
        }
        if (i == 4) {
            return 32;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static int zzb(zzuo zzuoVar) throws GeneralSecurityException {
        int i = zzls.zza[zzuoVar.ordinal()];
        if (i == 1) {
            return 65;
        }
        if (i == 2) {
            return 97;
        }
        if (i == 3) {
            return 133;
        }
        if (i == 4) {
            return 32;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static zzwo zzc(zzuo zzuoVar) throws GeneralSecurityException {
        int i = zzls.zza[zzuoVar.ordinal()];
        if (i == 1) {
            return zzwo.NIST_P256;
        }
        if (i == 2) {
            return zzwo.NIST_P384;
        }
        if (i == 3) {
            return zzwo.NIST_P521;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    public static void zza(zzur zzurVar) throws GeneralSecurityException {
        if (zzurVar.zzc() == zzuo.KEM_UNKNOWN || zzurVar.zzc() == zzuo.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid KEM param: " + zzurVar.zzc().name());
        }
        if (zzurVar.zzb() == zzum.KDF_UNKNOWN || zzurVar.zzb() == zzum.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid KDF param: " + zzurVar.zzb().name());
        }
        if (zzurVar.zza() == zzuk.AEAD_UNKNOWN || zzurVar.zza() == zzuk.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid AEAD param: " + zzurVar.zza().name());
        }
    }

    private static byte[] zza(int i, int i2) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (i2 >> (((i - i3) - 1) * 8));
        }
        return bArr;
    }

    public static byte[] zza(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzwg.zza(zzp, bArr2, str.getBytes(zzpf.zza), bArr);
    }

    public static byte[] zza(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return zzwg.zza(zza(2, i), zzp, bArr2, str.getBytes(zzpf.zza), bArr);
    }

    public static byte[] zza(byte[] bArr) throws GeneralSecurityException {
        return zzwg.zza(zzn, bArr);
    }

    public static byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zzwg.zza(zzo, bArr, bArr2, bArr3);
    }
}
