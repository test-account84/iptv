package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzlf implements zzbo {
    private static final byte[] zza = new byte[0];
    private final zzll zzb;
    private final zzlj zzc;
    private final zzlg zzd;
    private final zzld zze;
    private final int zzf;

    private zzlf(zzll zzllVar, zzlj zzljVar, zzlg zzlgVar, zzld zzldVar, int i) {
        this.zzb = zzllVar;
        this.zzc = zzljVar;
        this.zzd = zzlgVar;
        this.zze = zzldVar;
        this.zzf = i;
    }

    public static zzlf zza(zzuu zzuuVar) throws GeneralSecurityException {
        int i;
        zzll zza2;
        if (!zzuuVar.zzf()) {
            throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
        }
        if (!zzuuVar.zzd().zzg()) {
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        }
        if (zzuuVar.zze().zze()) {
            throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
        }
        zzur zzb = zzuuVar.zzd().zzb();
        zzlj zzc = zzlk.zzc(zzb);
        zzlg zzb2 = zzlk.zzb(zzb);
        zzld zza3 = zzlk.zza(zzb);
        zzuo zzc2 = zzb.zzc();
        int i2 = zzle.zza[zzc2.ordinal()];
        if (i2 == 1) {
            i = 32;
        } else if (i2 == 2) {
            i = 65;
        } else if (i2 == 3) {
            i = 97;
        } else {
            if (i2 != 4) {
                throw new IllegalArgumentException("Unable to determine KEM-encoding length for " + zzc2.name());
            }
            i = 133;
        }
        int i3 = zzli.zza[zzuuVar.zzd().zzb().zzc().ordinal()];
        if (i3 == 1) {
            zza2 = zzlz.zza(zzuuVar.zze().zzg());
        } else {
            if (i3 != 2 && i3 != 3 && i3 != 4) {
                throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
            }
            zza2 = zzlx.zza(zzuuVar.zze().zzg(), zzuuVar.zzd().zzf().zzg(), zzlt.zzc(zzuuVar.zzd().zzb().zzc()));
        }
        return new zzlf(zza2, zzc, zzb2, zza3, i);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzf;
        if (length < i) {
            throw new GeneralSecurityException("Ciphertext is too short.");
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr3 = bArr2;
        byte[] copyOf = Arrays.copyOf(bArr, i);
        return zzlc.zza(copyOf, this.zzb, this.zzc, this.zzd, this.zze, bArr3).zza(Arrays.copyOfRange(bArr, this.zzf, bArr.length), zza);
    }
}
