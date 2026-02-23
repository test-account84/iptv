package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bdc implements bdf {
    private final int a;

    public bdc(int i) throws InvalidAlgorithmParameterException {
        if (i == 16 || i == 32) {
            this.a = i;
            return;
        }
        throw new InvalidAlgorithmParameterException("Unsupported key length: " + i);
    }

    public final int a() {
        return this.a;
    }

    public final byte[] b() throws GeneralSecurityException {
        int i = this.a;
        if (i == 16) {
            return bdr.i;
        }
        if (i == 32) {
            return bdr.j;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }

    public final byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        int length = bArr.length;
        if (length == this.a) {
            return new bby(bArr, false).a(bArr2, bArr3);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + length);
    }
}
