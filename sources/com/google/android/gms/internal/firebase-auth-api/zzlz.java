package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzlz implements zzll {
    private final zzxt zza;
    private final zzxt zzb;

    private zzlz(byte[] bArr, byte[] bArr2) {
        this.zza = zzxt.zza(bArr);
        this.zzb = zzxt.zza(bArr2);
    }

    public static zzlz zza(byte[] bArr) throws GeneralSecurityException {
        return new zzlz(bArr, zzxr.zza(bArr));
    }

    public final zzxt zzb() {
        return this.zzb;
    }

    public final zzxt zza() {
        return this.zza;
    }
}
