package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bip implements azo {
    private final bcb a;

    public bip(byte[] bArr) throws GeneralSecurityException {
        this.a = new bcb(bArr);
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 28);
        byte[] b = bjf.b(12);
        allocate.put(b);
        this.a.b(allocate, b, bArr, bArr2);
        return allocate.array();
    }
}
