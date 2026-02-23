package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.KeyPair;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bds implements bdj {
    private final bde a;
    private final int b;

    private bds(bde bdeVar, int i) {
        this.a = bdeVar;
        this.b = i;
    }

    public static bds c(int i) throws GeneralSecurityException {
        int i2 = i - 1;
        return i2 != 0 ? i2 != 1 ? new bds(new bde("HmacSha512"), 3) : new bds(new bde("HmacSha384"), 2) : new bds(new bde("HmacSha256"), 1);
    }

    public final bdk a(byte[] bArr) throws GeneralSecurityException {
        KeyPair p = bjh.p(this.b);
        byte[] o = bjh.o(p.getPrivate(), bjh.r(this.b, 1, bArr));
        byte[] u = bjh.u(this.b, 1, p.getPublic().getW());
        byte[] y = bjh.y(u, bArr);
        byte[] d = bdr.d(b());
        bde bdeVar = this.a;
        return new bdk(bdeVar.e(o, y, d, bdeVar.a()), u);
    }

    public final byte[] b() throws GeneralSecurityException {
        int i = this.b - 1;
        return i != 0 ? i != 1 ? bdr.e : bdr.d : bdr.c;
    }
}
