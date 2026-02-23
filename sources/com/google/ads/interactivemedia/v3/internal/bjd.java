package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bjd implements bag {
    private final bgd a;
    private final int b;

    public bjd(bgd bgdVar, int i) throws GeneralSecurityException {
        this.a = bgdVar;
        this.b = i;
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        bgdVar.a(new byte[0], i);
    }

    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        return this.a.a(bArr, this.b);
    }
}
