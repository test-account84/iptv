package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzlx implements zzll {
    private final zzxt zza;
    private final zzxt zzb;

    private zzlx(byte[] bArr, byte[] bArr2) {
        this.zza = zzxt.zza(bArr);
        this.zzb = zzxt.zza(bArr2);
    }

    public static zzlx zza(byte[] bArr, byte[] bArr2, zzwo zzwoVar) throws GeneralSecurityException {
        zzwp.zza(zzwp.zza(zzwoVar, zzwr.UNCOMPRESSED, bArr2), zzwp.zza(zzwoVar, bArr));
        return new zzlx(bArr, bArr2);
    }

    public final zzxt zzb() {
        return this.zzb;
    }

    public final zzxt zza() {
        return this.zza;
    }
}
