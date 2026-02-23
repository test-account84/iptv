package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bil extends ThreadLocal {
    public static final Cipher a() {
        try {
            return (Cipher) biv.a.a("AES/CTR/NOPADDING");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    public final /* bridge */ /* synthetic */ Object initialValue() {
        return a();
    }
}
