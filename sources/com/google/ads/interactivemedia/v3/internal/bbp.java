package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bbp implements azo {
    private static final byte[] a = new byte[0];
    private final bht b;
    private final azo c;

    public bbp(bht bhtVar, azo azoVar) {
        this.b = bhtVar;
        this.c = azoVar;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] av = bao.c(this.b).av();
        byte[] a2 = this.c.a(av, a);
        byte[] a3 = ((azo) bao.h(this.b.e(), av, azo.class)).a(bArr, bArr2);
        int length = a2.length;
        return ByteBuffer.allocate(length + 4 + a3.length).putInt(length).put(a2).put(a3).array();
    }
}
