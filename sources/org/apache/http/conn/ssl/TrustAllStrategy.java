package org.apache.http.conn.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class TrustAllStrategy implements TrustStrategy {
    public static final TrustAllStrategy INSTANCE = new TrustAllStrategy();

    public boolean isTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        return true;
    }
}
