package com.google.ads.interactivemedia.v3.internal;

import java.security.InvalidKeyException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bbz extends bca {
    public bbz(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    public final int a() {
        return 12;
    }

    public final int[] b(int[] iArr, int i) {
        int length = iArr.length;
        if (length != 3) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", new Object[]{Integer.valueOf(length * 32)}));
        }
        int[] iArr2 = new int[16];
        bbw.b(iArr2, this.a);
        iArr2[12] = i;
        System.arraycopy(iArr, 0, iArr2, 13, 3);
        return iArr2;
    }
}
