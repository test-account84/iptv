package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bin implements azo {
    public static final int a = bch.b;
    private final bby b;

    public bin(byte[] bArr) throws GeneralSecurityException {
        if (!bch.a(a)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.b = new bby(bArr, true);
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.b.a(bjf.b(12), bArr);
    }
}
