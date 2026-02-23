package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ConnectionSpec {
    private static final CipherSuite[] APPROVED_CIPHER_SUITES;
    public static final ConnectionSpec CLEARTEXT;
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final ConnectionSpec MODERN_TLS;
    private final String[] cipherSuites;
    private final boolean supportsTlsExtensions;
    private final boolean tls;
    private final String[] tlsVersions;

    public static final class Builder {
        private String[] cipherSuites;
        private boolean supportsTlsExtensions;
        private boolean tls;
        private String[] tlsVersions;

        public Builder(ConnectionSpec connectionSpec) {
            this.tls = ConnectionSpec.access$400(connectionSpec);
            this.cipherSuites = ConnectionSpec.access$500(connectionSpec);
            this.tlsVersions = ConnectionSpec.access$600(connectionSpec);
            this.supportsTlsExtensions = ConnectionSpec.access$700(connectionSpec);
        }

        public static /* synthetic */ boolean access$000(Builder builder) {
            return builder.tls;
        }

        public static /* synthetic */ String[] access$100(Builder builder) {
            return builder.cipherSuites;
        }

        public static /* synthetic */ String[] access$200(Builder builder) {
            return builder.tlsVersions;
        }

        public static /* synthetic */ boolean access$300(Builder builder) {
            return builder.supportsTlsExtensions;
        }

        public Builder allEnabledCipherSuites() {
            if (!this.tls) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            this.cipherSuites = null;
            return this;
        }

        public Builder allEnabledTlsVersions() {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            this.tlsVersions = null;
            return this;
        }

        public ConnectionSpec build() {
            return new ConnectionSpec(this, null);
        }

        public Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            if (!this.tls) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[cipherSuiteArr.length];
            for (int i = 0; i < cipherSuiteArr.length; i++) {
                strArr[i] = cipherSuiteArr[i].javaName;
            }
            return cipherSuites(strArr);
        }

        public Builder supportsTlsExtensions(boolean z) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.supportsTlsExtensions = z;
            return this;
        }

        public Builder tlsVersions(TlsVersion... tlsVersionArr) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            for (int i = 0; i < tlsVersionArr.length; i++) {
                strArr[i] = tlsVersionArr[i].javaName;
            }
            return tlsVersions(strArr);
        }

        public Builder(boolean z) {
            this.tls = z;
        }

        public Builder cipherSuites(String... strArr) {
            if (!this.tls) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.cipherSuites = (String[]) strArr.clone();
            return this;
        }

        public Builder tlsVersions(String... strArr) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.tlsVersions = (String[]) strArr.clone();
            return this;
        }
    }

    static {
        CipherSuite[] cipherSuiteArr = {CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        APPROVED_CIPHER_SUITES = cipherSuiteArr;
        Builder cipherSuites = new Builder(true).cipherSuites(cipherSuiteArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_0;
        ConnectionSpec build = cipherSuites.tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, tlsVersion).supportsTlsExtensions(true).build();
        MODERN_TLS = build;
        COMPATIBLE_TLS = new Builder(build).tlsVersions(tlsVersion).supportsTlsExtensions(true).build();
        CLEARTEXT = new Builder(false).build();
    }

    private ConnectionSpec(Builder builder) {
        this.tls = Builder.access$000(builder);
        this.cipherSuites = Builder.access$100(builder);
        this.tlsVersions = Builder.access$200(builder);
        this.supportsTlsExtensions = Builder.access$300(builder);
    }

    public static /* synthetic */ boolean access$400(ConnectionSpec connectionSpec) {
        return connectionSpec.tls;
    }

    public static /* synthetic */ String[] access$500(ConnectionSpec connectionSpec) {
        return connectionSpec.cipherSuites;
    }

    public static /* synthetic */ String[] access$600(ConnectionSpec connectionSpec) {
        return connectionSpec.tlsVersions;
    }

    public static /* synthetic */ boolean access$700(ConnectionSpec connectionSpec) {
        return connectionSpec.supportsTlsExtensions;
    }

    private static boolean nonEmptyIntersection(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                if (Util.contains(strArr2, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private ConnectionSpec supportedSpec(SSLSocket sSLSocket, boolean z) {
        String[] strArr = this.cipherSuites;
        String[] enabledCipherSuites = strArr != null ? (String[]) Util.intersect(String.class, strArr, sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
        String[] strArr2 = this.tlsVersions;
        String[] enabledProtocols = strArr2 != null ? (String[]) Util.intersect(String.class, strArr2, sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
        if (z && Util.contains(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
            enabledCipherSuites = Util.concat(enabledCipherSuites, "TLS_FALLBACK_SCSV");
        }
        return new Builder(this).cipherSuites(enabledCipherSuites).tlsVersions(enabledProtocols).build();
    }

    public void apply(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec supportedSpec = supportedSpec(sSLSocket, z);
        String[] strArr = supportedSpec.tlsVersions;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = supportedSpec.cipherSuites;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List cipherSuites() {
        String[] strArr = this.cipherSuites;
        if (strArr == null) {
            return null;
        }
        CipherSuite[] cipherSuiteArr = new CipherSuite[strArr.length];
        int i = 0;
        while (true) {
            String[] strArr2 = this.cipherSuites;
            if (i >= strArr2.length) {
                return Util.immutableList(cipherSuiteArr);
            }
            cipherSuiteArr[i] = CipherSuite.forJavaName(strArr2[i]);
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = this.tls;
        if (z != connectionSpec.tls) {
            return false;
        }
        return !z || (Arrays.equals(this.cipherSuites, connectionSpec.cipherSuites) && Arrays.equals(this.tlsVersions, connectionSpec.tlsVersions) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions);
    }

    public int hashCode() {
        if (this.tls) {
            return ((((527 + Arrays.hashCode(this.cipherSuites)) * 31) + Arrays.hashCode(this.tlsVersions)) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
        }
        return 17;
    }

    public boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.tls) {
            return false;
        }
        String[] strArr = this.tlsVersions;
        if (strArr != null && !nonEmptyIntersection(strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.cipherSuites;
        return strArr2 == null || nonEmptyIntersection(strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean isTls() {
        return this.tls;
    }

    public boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public List tlsVersions() {
        String[] strArr = this.tlsVersions;
        if (strArr == null) {
            return null;
        }
        TlsVersion[] tlsVersionArr = new TlsVersion[strArr.length];
        int i = 0;
        while (true) {
            String[] strArr2 = this.tlsVersions;
            if (i >= strArr2.length) {
                return Util.immutableList(tlsVersionArr);
            }
            tlsVersionArr[i] = TlsVersion.forJavaName(strArr2[i]);
            i++;
        }
    }

    public String toString() {
        if (!this.tls) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.cipherSuites != null ? cipherSuites().toString() : "[all enabled]") + ", tlsVersions=" + (this.tlsVersions != null ? tlsVersions().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
    }

    public /* synthetic */ ConnectionSpec(Builder builder, 1 r2) {
        this(builder);
    }
}
