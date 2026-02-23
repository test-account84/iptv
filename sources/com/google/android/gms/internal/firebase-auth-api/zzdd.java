package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdd implements zzbg {
    private final zzcg zza;
    private final zzrr zzb;
    private final zzrr zzc;

    private zzdd(zzcg zzcgVar) {
        zzrr zzrrVar;
        this.zza = zzcgVar;
        if (zzcgVar.zzf()) {
            zzro zzb = zznn.zza().zzb();
            zzrq zza = zznh.zza(zzcgVar);
            this.zzb = zzb.zza(zza, "aead", "encrypt");
            zzrrVar = zzb.zza(zza, "aead", "decrypt");
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
                    byte[] zza = ((zzbg) zzclVar.zzf()).zza(copyOfRange, bArr2);
                    this.zzc.zza(zzclVar.zza(), copyOfRange.length);
                    return zza;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzcl zzclVar2 : this.zza.zze()) {
            try {
                byte[] zza2 = ((zzbg) zzclVar2.zzf()).zza(bArr, bArr2);
                this.zzc.zza(zzclVar2.zza(), bArr.length);
                return zza2;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzc.zza();
        throw new GeneralSecurityException("decryption failed");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            byte[] zza = zzwg.zza(this.zza.zza().zzh(), ((zzbg) this.zza.zza().zzf()).zzb(bArr, bArr2));
            this.zzb.zza(this.zza.zza().zza(), bArr.length);
            return zza;
        } catch (GeneralSecurityException e) {
            this.zzb.zza();
            throw e;
        }
    }

    public /* synthetic */ zzdd(zzcg zzcgVar, zzdc zzdcVar) {
        this(zzcgVar);
    }
}
