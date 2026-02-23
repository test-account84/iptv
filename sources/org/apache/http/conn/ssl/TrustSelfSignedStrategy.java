package org.apache.http.conn.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class TrustSelfSignedStrategy implements TrustStrategy {
    public static final TrustSelfSignedStrategy INSTANCE = new TrustSelfSignedStrategy();

    public boolean isTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        return x509CertificateArr.length == 1;
    }
}
