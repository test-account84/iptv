package okhttp3.internal.platform;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Platform {
    public static final Companion Companion;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger;
    private static volatile Platform platform;

    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Platform access$findPlatform(Companion companion) {
            return companion.findPlatform();
        }

        private final Platform findAndroidPlatform() {
            AndroidLog.INSTANCE.enable();
            Platform buildIfSupported = Android10Platform.Companion.buildIfSupported();
            if (buildIfSupported != null) {
                return buildIfSupported;
            }
            Platform buildIfSupported2 = AndroidPlatform.Companion.buildIfSupported();
            l.b(buildIfSupported2);
            return buildIfSupported2;
        }

        private final Platform findJvmPlatform() {
            OpenJSSEPlatform buildIfSupported;
            BouncyCastlePlatform buildIfSupported2;
            ConscryptPlatform buildIfSupported3;
            if (isConscryptPreferred() && (buildIfSupported3 = ConscryptPlatform.Companion.buildIfSupported()) != null) {
                return buildIfSupported3;
            }
            if (isBouncyCastlePreferred() && (buildIfSupported2 = BouncyCastlePlatform.Companion.buildIfSupported()) != null) {
                return buildIfSupported2;
            }
            if (isOpenJSSEPreferred() && (buildIfSupported = OpenJSSEPlatform.Companion.buildIfSupported()) != null) {
                return buildIfSupported;
            }
            Jdk9Platform buildIfSupported4 = Jdk9Platform.Companion.buildIfSupported();
            if (buildIfSupported4 != null) {
                return buildIfSupported4;
            }
            Platform buildIfSupported5 = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
            return buildIfSupported5 != null ? buildIfSupported5 : new Platform();
        }

        private final Platform findPlatform() {
            return isAndroid() ? findAndroidPlatform() : findJvmPlatform();
        }

        private final boolean isBouncyCastlePreferred() {
            Provider provider = Security.getProviders()[0];
            l.d(provider, "Security.getProviders()[0]");
            return l.a("BC", provider.getName());
        }

        private final boolean isConscryptPreferred() {
            Provider provider = Security.getProviders()[0];
            l.d(provider, "Security.getProviders()[0]");
            return l.a("Conscrypt", provider.getName());
        }

        private final boolean isOpenJSSEPreferred() {
            Provider provider = Security.getProviders()[0];
            l.d(provider, "Security.getProviders()[0]");
            return l.a("OpenJSSE", provider.getName());
        }

        public static /* synthetic */ void resetForTests$default(Companion companion, Platform platform, int i, Object obj) {
            if ((i & 1) != 0) {
                platform = companion.findPlatform();
            }
            companion.resetForTests(platform);
        }

        @NotNull
        public final List alpnProtocolNames(@NotNull List protocols) {
            l.e(protocols, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : (Iterable) protocols) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(l8.l.o(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Protocol) it.next()).toString());
            }
            return arrayList2;
        }

        @NotNull
        public final byte[] concatLengthPrefixed(@NotNull List protocols) {
            l.e(protocols, "protocols");
            Buffer buffer = new Buffer();
            for (String str : alpnProtocolNames(protocols)) {
                buffer.writeByte(str.length());
                buffer.writeUtf8(str);
            }
            return buffer.readByteArray();
        }

        @NotNull
        public final Platform get() {
            return Platform.access$getPlatform$cp();
        }

        public final boolean isAndroid() {
            return l.a("Dalvik", System.getProperty("java.vm.name"));
        }

        public final void resetForTests(@NotNull Platform platform) {
            l.e(platform, "platform");
            Platform.access$setPlatform$cp(platform);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        platform = Companion.access$findPlatform(companion);
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static final /* synthetic */ Platform access$getPlatform$cp() {
        return platform;
    }

    public static final /* synthetic */ void access$setPlatform$cp(Platform platform2) {
        platform = platform2;
    }

    @NotNull
    public static final Platform get() {
        return Companion.get();
    }

    public static /* synthetic */ void log$default(Platform platform2, String str, int i, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i2 & 2) != 0) {
            i = 4;
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        platform2.log(str, i, th);
    }

    public void afterHandshake(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
    }

    @NotNull
    public CertificateChainCleaner buildCertificateChainCleaner(@NotNull X509TrustManager trustManager) {
        l.e(trustManager, "trustManager");
        return new BasicCertificateChainCleaner(buildTrustRootIndex(trustManager));
    }

    @NotNull
    public TrustRootIndex buildTrustRootIndex(@NotNull X509TrustManager trustManager) {
        l.e(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        l.d(acceptedIssuers, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List protocols) {
        l.e(sslSocket, "sslSocket");
        l.e(protocols, "protocols");
    }

    public void connectSocket(@NotNull Socket socket, @NotNull InetSocketAddress address, int i) throws IOException {
        l.e(socket, "socket");
        l.e(address, "address");
        socket.connect(address, i);
    }

    @NotNull
    public final String getPrefix() {
        return "OkHttp";
    }

    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        return null;
    }

    @Nullable
    public Object getStackTraceForCloseable(@NotNull String closer) {
        l.e(closer, "closer");
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(@NotNull String hostname) {
        l.e(hostname, "hostname");
        return true;
    }

    public void log(@NotNull String message, int i, @Nullable Throwable th) {
        l.e(message, "message");
        logger.log(i == 5 ? Level.WARNING : Level.INFO, message, th);
    }

    public void logCloseableLeak(@NotNull String message, @Nullable Object obj) {
        l.e(message, "message");
        if (obj == null) {
            message = message + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(message, 5, (Throwable) obj);
    }

    @NotNull
    public SSLContext newSSLContext() {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        l.d(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public SSLSocketFactory newSslSocketFactory(@NotNull X509TrustManager trustManager) {
        l.e(trustManager, "trustManager");
        try {
            SSLContext newSSLContext = newSSLContext();
            newSSLContext.init((KeyManager[]) null, new TrustManager[]{trustManager}, (SecureRandom) null);
            SSLSocketFactory socketFactory = newSSLContext.getSocketFactory();
            l.d(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    @NotNull
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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

    @NotNull
    public String toString() {
        String simpleName = getClass().getSimpleName();
        l.d(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        l.e(sslSocketFactory, "sslSocketFactory");
        try {
            Class sslContextClass = Class.forName("sun.security.ssl.SSLContextImpl");
            l.d(sslContextClass, "sslContextClass");
            Object readFieldOrNull = Util.readFieldOrNull(sslSocketFactory, sslContextClass, "context");
            if (readFieldOrNull != null) {
                return (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
            }
            return null;
        } catch (RuntimeException e) {
            if (!l.a(e.getClass().getName(), "java.lang.reflect.InaccessibleObjectException")) {
                throw e;
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
