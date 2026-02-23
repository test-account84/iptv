package org.apache.http.conn.ssl;

import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SSLContextBuilder {
    static final String SSL = "SSL";
    static final String TLS = "TLS";
    private String protocol;
    private SecureRandom secureRandom;
    private final Set keymanagers = new LinkedHashSet();
    private final Set trustmanagers = new LinkedHashSet();

    public static class KeyManagerDelegate implements X509KeyManager {
        private final PrivateKeyStrategy aliasStrategy;
        private final X509KeyManager keyManager;

        public KeyManagerDelegate(X509KeyManager x509KeyManager, PrivateKeyStrategy privateKeyStrategy) {
            this.keyManager = x509KeyManager;
            this.aliasStrategy = privateKeyStrategy;
        }

        public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
            Map hashMap = new HashMap();
            for (String str : strArr) {
                String[] clientAliases = this.keyManager.getClientAliases(str, principalArr);
                if (clientAliases != null) {
                    for (String str2 : clientAliases) {
                        hashMap.put(str2, new PrivateKeyDetails(str, this.keyManager.getCertificateChain(str2)));
                    }
                }
            }
            return this.aliasStrategy.chooseAlias(hashMap, socket);
        }

        public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
            Map hashMap = new HashMap();
            String[] serverAliases = this.keyManager.getServerAliases(str, principalArr);
            if (serverAliases != null) {
                for (String str2 : serverAliases) {
                    hashMap.put(str2, new PrivateKeyDetails(str, this.keyManager.getCertificateChain(str2)));
                }
            }
            return this.aliasStrategy.chooseAlias(hashMap, socket);
        }

        public X509Certificate[] getCertificateChain(String str) {
            return this.keyManager.getCertificateChain(str);
        }

        public String[] getClientAliases(String str, Principal[] principalArr) {
            return this.keyManager.getClientAliases(str, principalArr);
        }

        public PrivateKey getPrivateKey(String str) {
            return this.keyManager.getPrivateKey(str);
        }

        public String[] getServerAliases(String str, Principal[] principalArr) {
            return this.keyManager.getServerAliases(str, principalArr);
        }
    }

    public static class TrustManagerDelegate implements X509TrustManager {
        private final X509TrustManager trustManager;
        private final TrustStrategy trustStrategy;

        public TrustManagerDelegate(X509TrustManager x509TrustManager, TrustStrategy trustStrategy) {
            this.trustManager = x509TrustManager;
            this.trustStrategy = trustStrategy;
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.trustManager.checkClientTrusted(x509CertificateArr, str);
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            if (this.trustStrategy.isTrusted(x509CertificateArr, str)) {
                return;
            }
            this.trustManager.checkServerTrusted(x509CertificateArr, str);
        }

        public X509Certificate[] getAcceptedIssuers() {
            return this.trustManager.getAcceptedIssuers();
        }
    }

    public SSLContext build() throws NoSuchAlgorithmException, KeyManagementException {
        KeyManager[] keyManagerArr;
        String str = this.protocol;
        if (str == null) {
            str = "TLS";
        }
        SSLContext sSLContext = SSLContext.getInstance(str);
        TrustManager[] trustManagerArr = null;
        if (this.keymanagers.isEmpty()) {
            keyManagerArr = null;
        } else {
            Set set = this.keymanagers;
            keyManagerArr = (KeyManager[]) set.toArray(new KeyManager[set.size()]);
        }
        if (!this.trustmanagers.isEmpty()) {
            Set set2 = this.trustmanagers;
            trustManagerArr = (TrustManager[]) set2.toArray(new TrustManager[set2.size()]);
        }
        sSLContext.init(keyManagerArr, trustManagerArr, this.secureRandom);
        return sSLContext;
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore keyStore, char[] cArr) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        loadKeyMaterial(keyStore, cArr, null);
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException {
        return loadTrustMaterial(keyStore, null);
    }

    public SSLContextBuilder setSecureRandom(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
        return this;
    }

    public SSLContextBuilder useProtocol(String str) {
        this.protocol = str;
        return this;
    }

    public SSLContextBuilder useSSL() {
        this.protocol = "SSL";
        return this;
    }

    public SSLContextBuilder useTLS() {
        this.protocol = "TLS";
        return this;
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore keyStore, char[] cArr, PrivateKeyStrategy privateKeyStrategy) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, cArr);
        X509KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
        if (keyManagers != null) {
            if (privateKeyStrategy != null) {
                for (int i = 0; i < keyManagers.length; i++) {
                    X509KeyManager x509KeyManager = keyManagers[i];
                    if (x509KeyManager instanceof X509KeyManager) {
                        keyManagers[i] = new KeyManagerDelegate(x509KeyManager, privateKeyStrategy);
                    }
                }
            }
            for (X509KeyManager x509KeyManager2 : keyManagers) {
                this.keymanagers.add(x509KeyManager2);
            }
        }
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore keyStore, TrustStrategy trustStrategy) throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        X509TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers != null) {
            if (trustStrategy != null) {
                for (int i = 0; i < trustManagers.length; i++) {
                    X509TrustManager x509TrustManager = trustManagers[i];
                    if (x509TrustManager instanceof X509TrustManager) {
                        trustManagers[i] = new TrustManagerDelegate(x509TrustManager, trustStrategy);
                    }
                }
            }
            for (X509TrustManager x509TrustManager2 : trustManagers) {
                this.trustmanagers.add(x509TrustManager2);
            }
        }
        return this;
    }
}
