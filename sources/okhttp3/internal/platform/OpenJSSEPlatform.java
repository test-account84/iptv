package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openjsse.javax.net.ssl.SSLParameters;
import org.openjsse.net.ssl.OpenJSSE;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class OpenJSSEPlatform extends Platform {
    public static final Companion Companion;
    private static final boolean isSupported;
    private final Provider provider;

    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final OpenJSSEPlatform buildIfSupported() {
            if (isSupported()) {
                return new OpenJSSEPlatform(null);
            }
            return null;
        }

        public final boolean isSupported() {
            return OpenJSSEPlatform.access$isSupported$cp();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        boolean z = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, companion.getClass().getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        isSupported = z;
    }

    private OpenJSSEPlatform() {
        this.provider = new OpenJSSE();
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List protocols) {
        l.e(sslSocket, "sslSocket");
        l.e(protocols, "protocols");
        if (!(sslSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            super.configureTlsExtensions(sslSocket, str, protocols);
            return;
        }
        org.openjsse.javax.net.ssl.SSLSocket sSLSocket = (org.openjsse.javax.net.ssl.SSLSocket) sslSocket;
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        if (sSLParameters instanceof SSLParameters) {
            SSLParameters sSLParameters2 = sSLParameters;
            Object[] array = Platform.Companion.alpnProtocolNames(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sSLParameters2.setApplicationProtocols((String[]) array);
            sSLSocket.setSSLParameters(sSLParameters);
        }
    }

    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        if (!(sslSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            return super.getSelectedProtocol(sslSocket);
        }
        String applicationProtocol = ((org.openjsse.javax.net.ssl.SSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(""))) {
            return null;
        }
        return applicationProtocol;
    }

    @NotNull
    public SSLContext newSSLContext() {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.provider);
        l.d(sSLContext, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @NotNull
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.provider);
        factory.init((KeyStore) null);
        l.d(factory, "factory");
        X509TrustManager[] trustManagers = factory.getTrustManagers();
        l.b(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            X509TrustManager x509TrustManager = trustManagers[0];
            if (x509TrustManager != null) {
                return x509TrustManager;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
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
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with OpenJSSE");
    }

    public /* synthetic */ OpenJSSEPlatform(g gVar) {
        this();
    }
}
