package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzjd implements zzbp {
    private final zzcg zza;
    private final zzrr zzb;
    private final zzrr zzc;

    public zzjd(zzcg zzcgVar) {
        zzrr zzrrVar;
        this.zza = zzcgVar;
        if (zzcgVar.zzf()) {
            zzro zzb = zznn.zza().zzb();
            zzrq zza = zznh.zza(zzcgVar);
            this.zzb = zzb.zza(zza, "daead", "encrypt");
            zzrrVar = zzb.zza(zza, "daead", "decrypt");
        } else {
            zzrrVar = zznh.zza;
            this.zzb = zzrrVar;
        }
        this.zzc = zzrrVar;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            for (zzcl zzclVar : this.zza.zza(copyOf)) {
                try {
                    byte[] zza = ((zzbp) zzclVar.zzf()).zza(copyOfRange, bArr2);
                    this.zzc.zza(zzclVar.zza(), copyOfRange.length);
                    return zza;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzcl zzclVar2 : this.zza.zze()) {
            try {
                byte[] zza2 = ((zzbp) zzclVar2.zzf()).zza(bArr, bArr2);
                this.zzc.zza(zzclVar2.zza(), bArr.length);
                return zza2;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzc.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
