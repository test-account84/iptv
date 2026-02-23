package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzlh implements zzbr {
    private static final byte[] zza = new byte[0];
    private final zzuv zzb;
    private final zzlj zzc;
    private final zzlg zzd;
    private final zzld zze;

    private zzlh(zzuv zzuvVar, zzlj zzljVar, zzlg zzlgVar, zzld zzldVar) {
        this.zzb = zzuvVar;
        this.zzc = zzljVar;
        this.zzd = zzlgVar;
        this.zze = zzldVar;
    }

    public static zzlh zza(zzuv zzuvVar) throws GeneralSecurityException {
        if (zzuvVar.zzf().zze()) {
            throw new IllegalArgumentException("HpkePublicKey.public_key is empty.");
        }
        zzur zzb = zzuvVar.zzb();
        return new zzlh(zzuvVar, zzlk.zzc(zzb), zzlk.zzb(zzb), zzlk.zza(zzb));
    }
}
