package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class bca {
    int[] a;
    private final int b;

    public bca(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.a = bbw.d(bArr);
        this.b = i;
    }

    public abstract int a();

    public abstract int[] b(int[] iArr, int i);

    public final ByteBuffer c(byte[] bArr, int i) {
        int[] b = b(bbw.d(bArr), i);
        int[] iArr = (int[]) b.clone();
        bbw.c(iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            b[i2] = b[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(b, 0, 16);
        return order;
    }

    public final void d(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr2);
        if (bArr.length != a()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + a());
        }
        int remaining = wrap.remaining();
        int i = remaining / 64;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer c = c(bArr, this.b + i3);
            int i4 = 64;
            if (i3 == i) {
                i4 = remaining % 64;
            }
            bjh.w(byteBuffer, wrap, c, i4);
        }
    }
}
