package com.google.ads.interactivemedia.v3.internal;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class afc extends afd {
    private final byte[] a;

    public afc(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.a = bArr;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.a;
    }
}
