package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class biu implements azo {
    private final biz a;
    private final bag b;

    public biu(biz bizVar, bag bagVar) {
        this.a = bizVar;
        this.b = bagVar;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] a = this.a.a(bArr);
        return bjh.y(a, this.b.a(bjh.y(bArr2, a, Arrays.copyOf(ByteBuffer.allocate(8).putLong(0L).array(), 8))));
    }
}
