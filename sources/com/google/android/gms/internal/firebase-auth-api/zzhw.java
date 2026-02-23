package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzhw extends ThreadLocal {
    private static Cipher zza() {
        try {
            return (Cipher) zzwt.zza.zza("AES/GCM/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    public final /* synthetic */ Object initialValue() {
        return zza();
    }
}
