package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzky implements zzld {
    private final int zza;

    public zzky(int i) throws InvalidAlgorithmParameterException {
        if (i == 16 || i == 32) {
            this.zza = i;
        } else {
            throw new InvalidAlgorithmParameterException("Unsupported key length: " + i);
        }
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return 12;
    }

    public final byte[] zzc() throws GeneralSecurityException {
        int i = this.zza;
        if (i == 16) {
            return zzlt.zzi;
        }
        if (i == 32) {
            return zzlt.zzj;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length == this.zza) {
            return new zzht(bArr, false).zza(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + bArr.length);
    }
}
