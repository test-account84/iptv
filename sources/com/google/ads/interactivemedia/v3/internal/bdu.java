package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bdu {
    private bdu(byte[] bArr, byte[] bArr2) {
        bjj.b(bArr);
        bjj.b(bArr2);
    }

    public static bdu a(byte[] bArr) throws GeneralSecurityException {
        return new bdu(bArr, bjh.c(bArr));
    }

    public static bdu b(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        bjh.m(bjh.r(i, 1, bArr2), bjh.q(i, bArr));
        return new bdu(bArr, bArr2, null);
    }

    private bdu(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        bjj.b(bArr);
        bjj.b(bArr2);
    }
}
