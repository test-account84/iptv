package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzly {
    private final zzbg zza;
    private final zzbp zzb;

    public zzly(zzbg zzbgVar) {
        this.zza = zzbgVar;
        this.zzb = null;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzbg zzbgVar = this.zza;
        return zzbgVar != null ? zzbgVar.zza(bArr, bArr2) : this.zzb.zza(bArr, bArr2);
    }

    public zzly(zzbp zzbpVar) {
        this.zza = null;
        this.zzb = zzbpVar;
    }
}
