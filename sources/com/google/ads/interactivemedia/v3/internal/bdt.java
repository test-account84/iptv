package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bdt implements bdj {
    private final bde a;

    public bdt(bde bdeVar) {
        this.a = bdeVar;
    }

    public final bdk a(byte[] bArr) throws GeneralSecurityException {
        byte[] b = bjh.b();
        byte[] a = bjh.a(b, bArr);
        byte[] c = bjh.c(b);
        byte[] y = bjh.y(c, bArr);
        byte[] d = bdr.d(bdr.b);
        bde bdeVar = this.a;
        return new bdk(bdeVar.e(a, y, d, bdeVar.a()), c);
    }

    public final byte[] b() throws GeneralSecurityException {
        if (Arrays.equals(this.a.b(), bdr.f)) {
            return bdr.b;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
