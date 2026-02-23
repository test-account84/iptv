package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bit implements azt {
    private static final byte[] a = new byte[0];
    private final String b;
    private final byte[] c;
    private final bir d;
    private final int e;
    private final oq f;

    public bit(ECPublicKey eCPublicKey, byte[] bArr, String str, int i, bir birVar) throws GeneralSecurityException {
        bjh.l(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.f = new oq(eCPublicKey);
        this.c = bArr;
        this.b = str;
        this.e = i;
        this.d = birVar;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        bel h = this.f.h(this.b, this.c, bArr2, this.d.a(), this.e);
        byte[] d = this.d.b(h.e()).d(bArr, a);
        byte[] d2 = h.d();
        return ByteBuffer.allocate(d2.length + d.length).put(d2).put(d).array();
    }
}
