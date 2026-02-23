package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzwe implements zzbg {
    private static final zzif.zza zza = zzif.zza.zzb;
    private final zzht zzb;
    private final byte[] zzc;

    public zzwe(byte[] bArr) throws GeneralSecurityException {
        this(bArr, zzxt.zza(new byte[0]));
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzc;
        if (bArr3.length == 0) {
            return this.zzb.zza(Arrays.copyOf(bArr, 12), bArr, bArr2);
        }
        if (!zzpf.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zzc.length, bArr.length);
        return this.zzb.zza(Arrays.copyOf(copyOfRange, 12), copyOfRange, bArr2);
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zza2 = zzou.zza(12);
        byte[] bArr3 = this.zzc;
        return bArr3.length == 0 ? this.zzb.zzb(zza2, bArr, bArr2) : zzwg.zza(bArr3, this.zzb.zzb(zza2, bArr, bArr2));
    }

    private zzwe(byte[] bArr, zzxt zzxtVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zzb = new zzht(bArr, true);
        this.zzc = zzxtVar.zzb();
    }
}
