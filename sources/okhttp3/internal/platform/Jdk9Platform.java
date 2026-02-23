package okhttp3.internal.platform;

import E8.m;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.SuppressSignatureCheck;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Jdk9Platform extends Platform {
    public static final Companion Companion = new Companion(null);
    private static final boolean isAvailable;

    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Jdk9Platform buildIfSupported() {
            if (isAvailable()) {
                return new Jdk9Platform();
            }
            return null;
        }

        public final boolean isAvailable() {
            return Jdk9Platform.access$isAvailable$cp();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    static {
        String property = System.getProperty("java.specification.version");
        Integer i = property != null ? m.i(property) : null;
        boolean z = false;
        if (i == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", (Class[]) null);
                z = true;
            } catch (NoSuchMethodException unused) {
            }
        } else if (i.intValue() >= 9) {
            z = true;
        }
        isAvailable = z;
    }

    public static final /* synthetic */ boolean access$isAvailable$cp() {
        return isAvailable;
    }

    @SuppressSignatureCheck
    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List protocols) {
        l.e(sslSocket, "sslSocket");
        l.e(protocols, "protocols");
        SSLParameters sslParameters = sslSocket.getSSLParameters();
        Collection alpnProtocolNames = Platform.Companion.alpnProtocolNames(protocols);
        l.d(sslParameters, "sslParameters");
        Object[] array = alpnProtocolNames.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        b.a(sslParameters, (String[]) array);
        sslSocket.setSSLParameters(sslParameters);
    }

    @SuppressSignatureCheck
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        try {
            String a = c.a(sslSocket);
            if (a == null) {
                return null;
            }
            if (a.hashCode() == 0) {
                if (a.equals("")) {
                    return null;
                }
            }
            return a;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        l.e(sslSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
