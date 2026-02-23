package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzqv implements zzce {
    private final zzcg zza;
    private final zzrr zzb;
    private final zzrr zzc;

    private zzqv(zzcg zzcgVar) {
        zzrr zzrrVar;
        this.zza = zzcgVar;
        if (zzcgVar.zzf()) {
            zzro zzb = zznn.zza().zzb();
            zzrq zza = zznh.zza(zzcgVar);
            this.zzb = zzb.zza(zza, "mac", "compute");
            zzrrVar = zzb.zza(zza, "mac", "verify");
        } else {
            zzrrVar = zznh.zza;
            this.zzb = zzrrVar;
        }
        this.zzc = zzrrVar;
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= 5) {
            this.zzc.zza();
            throw new GeneralSecurityException("tag too short");
        }
        for (zzcl zzclVar : this.zza.zza(Arrays.copyOf(bArr, 5))) {
            try {
                ((zzce) zzclVar.zze()).zza(bArr, bArr2);
                this.zzc.zza(zzclVar.zza(), bArr2.length);
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        for (zzcl zzclVar2 : this.zza.zze()) {
            try {
                ((zzce) zzclVar2.zze()).zza(bArr, bArr2);
                this.zzc.zza(zzclVar2.zza(), bArr2.length);
                return;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzc.zza();
        throw new GeneralSecurityException("invalid MAC");
    }

    public /* synthetic */ zzqv(zzcg zzcgVar, zzqu zzquVar) {
        this(zzcgVar);
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        try {
            byte[] zza = ((zzce) this.zza.zza().zze()).zza(bArr);
            this.zzb.zza(this.zza.zza().zza(), bArr.length);
            return zza;
        } catch (GeneralSecurityException e) {
            this.zzb.zza();
            throw e;
        }
    }
}
