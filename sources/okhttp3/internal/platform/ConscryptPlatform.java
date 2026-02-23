package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ConscryptPlatform extends Platform {
    public static final Companion Companion;
    private static final boolean isSupported;
    private final Provider provider;

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ boolean atLeastVersion$default(Companion companion, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = 0;
            }
            return companion.atLeastVersion(i, i2, i3);
        }

        public final boolean atLeastVersion(int i, int i2, int i3) {
            Conscrypt.Version version = Conscrypt.version();
            return version.major() != i ? version.major() > i : version.minor() != i2 ? version.minor() > i2 : version.patch() >= i3;
        }

        @Nullable
        public final ConscryptPlatform buildIfSupported() {
            if (isSupported()) {
                return new ConscryptPlatform(null);
            }
            return null;
        }

        public final boolean isSupported() {
            return ConscryptPlatform.access$isSupported$cp();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final class DisabledHostnameVerifier implements ConscryptHostnameVerifier {
        public static final DisabledHostnameVerifier INSTANCE = new DisabledHostnameVerifier();

        private DisabledHostnameVerifier() {
        }

        public final boolean verify(@Nullable String str, @Nullable SSLSession sSLSession) {
            return true;
        }

        public boolean verify(@Nullable X509Certificate[] x509CertificateArr, @Nullable String str, @Nullable SSLSession sSLSession) {
            return true;
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        boolean z = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, companion.getClass().getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (companion.atLeastVersion(2, 1, 0)) {
                    z = true;
                }
            }
        } catch (NoClassDefFoundError | ClassNotFoundException unused) {
        }
        isSupported = z;
    }

    private ConscryptPlatform() {
        Provider newProvider = Conscrypt.newProvider();
        l.d(newProvider, "Conscrypt.newProvider()");
        this.provider = newProvider;
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List protocols) {
        l.e(sslSocket, "sslSocket");
        l.e(protocols, "protocols");
        if (!Conscrypt.isConscrypt(sslSocket)) {
            super.configureTlsExtensions(sslSocket, str, protocols);
            return;
        }
        Conscrypt.setUseSessionTickets(sslSocket, true);
        Object[] array = Platform.Companion.alpnProtocolNames(protocols).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Conscrypt.setApplicationProtocols(sslSocket, (String[]) array);
    }

    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket) ? Conscrypt.getApplicationProtocol(sslSocket) : super.getSelectedProtocol(sslSocket);
    }

    @NotNull
    public SSLContext newSSLContext() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.provider);
        l.d(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public SSLSocketFactory newSslSocketFactory(@NotNull X509TrustManager trustManager) {
        l.e(trustManager, "trustManager");
        SSLContext newSSLContext = newSSLContext();
        newSSLContext.init((KeyManager[]) null, new TrustManager[]{trustManager}, (SecureRandom) null);
        SSLSocketFactory socketFactory = newSSLContext.getSocketFactory();
        l.d(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    @NotNull
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        l.d(trustManagerFactory, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        X509TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        l.b(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            X509TrustManager x509TrustManager = trustManagers[0];
            if (x509TrustManager == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            }
            X509TrustManager x509TrustManager2 = x509TrustManager;
            Conscrypt.setHostnameVerifier(x509TrustManager2, DisabledHostnameVerifier.INSTANCE);
            return x509TrustManager2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        l.d(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        throw new IllegalStateException(sb.toString().toString());
    }

    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        l.e(sslSocketFactory, "sslSocketFactory");
        return null;
    }

    public /* synthetic */ ConscryptPlatform(g gVar) {
        this();
    }
}
