package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzko implements zzbo {
    private final zzcg zza;
    private final zzrr zzb;

    public zzko(zzcg zzcgVar) {
        this.zza = zzcgVar;
        this.zzb = zzcgVar.zzf() ? zznn.zza().zzb().zza(zznh.zza(zzcgVar), "hybrid_decrypt", "decrypt") : zznh.zza;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
            for (zzcl zzclVar : this.zza.zza(copyOfRange)) {
                try {
                    byte[] zza = ((zzbo) zzclVar.zzf()).zza(copyOfRange2, bArr2);
                    this.zzb.zza(zzclVar.zza(), copyOfRange2.length);
                    return zza;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzcl zzclVar2 : this.zza.zze()) {
            try {
                byte[] zza2 = ((zzbo) zzclVar2.zzf()).zza(bArr, bArr2);
                this.zzb.zza(zzclVar2.zza(), bArr.length);
                return zza2;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzb.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
